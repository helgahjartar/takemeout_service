import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Properties;
import java.lang.reflect.Type;
import java.io.InputStream;
import java.io.FileInputStream;
import java.nio.file.Paths;
import javax.lang.model.element.Modifier;
import java.io.IOException;

import com.squareup.javapoet.*;

public class TypeGenerator {

  // Declare & Initialize generator fields

  private static final ClassName _typeItemClass = ClassName.get("takemeout.types", "TypeItem");
  private static final ClassName _listClass = ClassName.get("java.util", "List");
  private static final ClassName _arrayListClass = ClassName.get("java.util", "ArrayList");
  private static final TypeName _typeList = ParameterizedTypeName.get(_listClass, _typeItemClass);
  private static final TypeName _typeArrayList = ParameterizedTypeName.get(_arrayListClass, _typeItemClass);

  // Type Generation methods

  private static Iterable<FieldSpec> getFields(List<TypeItem> typeItems) {
    List<FieldSpec> fields= new ArrayList<FieldSpec>();
    for(TypeItem ti : typeItems) {
      fields.add(FieldSpec.builder(_typeItemClass, ti.typeItemName)
        .addModifiers(Modifier.PUBLIC , Modifier.STATIC, Modifier.FINAL)
        .initializer("new $T($L, $S, $S, $S)", _typeItemClass, ti.id,
          ti.name, ti.description)
        .build());
    }

    fields.add(FieldSpec.builder(_typeList, "types")
      .addModifiers(Modifier.PRIVATE, Modifier.STATIC, Modifier.FINAL)
      .initializer("new $T()", _typeArrayList)
      .build());

    return fields;
  }

  private static Iterable<MethodSpec> getMethods(String className) {
    List<MethodSpec> methods = new ArrayList<MethodSpec>();

    methods.add(MethodSpec.methodBuilder(className)
      .addModifiers(Modifier.PRIVATE)
      .build());

    methods.add(MethodSpec.methodBuilder("getTypes")
      .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
      .returns(_typeList)
      .addParameter(_typeList, "typeItems")
      .addStatement("$T items = new $T()", _typeList, _typeArrayList)
      .beginControlFlow("for ($T ti : typeItems)", _typeItemClass)
      .addStatement("items.add(new $T(ti.id, ti.typeItemName, " +
        "ti.description))", _typeItemClass)
      .endControlFlow()
      .addStatement("return items")
      .build());

    return methods;
  }

  private static TypeSpec build(List<TypeItem> types, String className) {
    TypeSpec spec = TypeSpec.classBuilder(className)
      .addModifiers(Modifier.PUBLIC)
      .addFields(getFields(types))
      .addMethods(getMethods(className))
      .build();

    return spec;
  }

  // Declare java properties fields

  private static Properties _props;

  // Java properties methods

  private static void initializeProperties(String fileName) {
    _props = new Properties();
    _props.load(new FileInputStream("typeConfig.properties"));
  }

  private static String getProperty(String propertyName) {
    String propertyValue = null;
    try {
      propertyValue = _props.getProperty(propertyName);
    } catch(Exception e) {
      System.out.println(e.getMessage());
    }
    return propertyValue;
  }

  // Write to file methods

  private static void createFiles(Map<String,List<TypeItem>> map) {
    for (String key : map.keySet()) {
      TypeSpec spec = build(map.get(key), key);

      try {
        JavaFile.builder(packageName, spec)
          .build().writeTo(Paths.get(".."));
      } catch (IOException e) {
        System.out.println(e.getMessage());
      }
    }
  }

  // Sort Types methods

  private static Map<String,List<TypeItem>> sortTypeItems(List<TypeItemProjection> projections) {
    Map<String,List<TypeItem>> map = new HashMap<String,List<TypeItem>>();
    for (TypeItemProjection p : projections) {
      String key = p.typeName;
      if (!map.containsKey(key)) map.put(key, new ArrayList<TypeItem>());
      map.get(key).add(new TypeItem(p.id, p.typeItemName, p.description));
    }
    return map;
  }

  // main function

  public static void main(String[] args) {
    initializeProperties("TypeConfig.properties");
    String packageName = getProperty("package");
    List<TypeItemProjection> types = getTypeItemTestData(packageName);
    Map<String,List<TypeItem>> map = sortTypeItems(types);
    createFiles(map);
  }

  // Todo: Replace with actual DB call
  private static List<TypeItemProjection> getTypeItemTestData(String packageName) {
    List<TypeItemProjection> list = new ArrayList<TypeItemProjection>();
    if (packageName.equals("takemeout.event.types")) {
      list.add(new TypeItemProjection(10001, "music", "Music", "Tónlist", 101000, "EventType", "takemeout.event.types" ));
      list.add(new TypeItemProjection(10002, "visualArt", "Visual Art", "Myndlist", 101000, "EventType", "takemeout.event.types" ));
      list.add(new TypeItemProjection(10003, "standUp", "Stand up", "Uppistand", 101000, "EventType", "takemeout.event.types" ));
      list.add(new TypeItemProjection(20001, "musician", "Tónlistarmaður", 102000, "PerformerType", "takemeout.event.types"));
      list.add(new TypeItemProjection(20002, "band", "Hljómsveit", 102000, "PerformerType", "takemeout.event.types"));
    } else if (packageName.equals("takemeout.event.genres")) {
      list.add(new TypeItemProjection(10001, "concert", "Tónleikar"));
      list.add(new TypeItemProjection(10002, "artExhibit", "Myndlistarsýning"));
      list.add(new TypeItemProjection(10003, "standUp", "Uppistand"));
      list.add(new TypeItemProjection(20001, "DrunkType", "musician", "Tónlistarmaður"));
      list.add(new TypeItemProjection(20001, "DrunkType", "band", "Hljómsveit"));
    }
    return list;
  }
}
