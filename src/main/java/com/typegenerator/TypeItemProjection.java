public class TypeItemProjection {
  public final int id;
  public final String name;
  public final String descriptionEng;
  public final String descriptionIsl;

  public final int baseTypeId;
  public final String baseTypeName;
  public final String packageName;

  public TypeItemProjection(int id, String name, String descriptionEng,
    String descriptionIsl, int baseTypeId, String baseTypeName, String packageName) {
    this.id = id;
    this.name = typeName;
    this.descriptionEng = descriptionEng;
    this.descriptionIsl = descriptionIsl;

    this.baseTypeId = baseTypeId;
    this.baseTypeName = baseTypeName;
    this.packageName = packageName;
  }
}
