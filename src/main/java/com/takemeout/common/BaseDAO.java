package com.takemeout.common;

import java.util.function.Consumer;
import java.util.function.Function;
import org.hibernate.Session;
import com.takemeout.util.SessionUtil;

public class BaseDAO {
  public void execute(Consumer<Session> r) {
    Session session = SessionUtil.getSession();
    try {
      session.beginTransaction();
      r.accept(session);
      session.getTransaction().commit();
    } catch(Exception e) {
      session.getTransaction().rollback();
    } finally  {
      session.close();
    }
  }

  public <R> R executeR(Function<Session, R> r) {
    Session session = SessionUtil.getSession();
    try {
      session.beginTransaction();
      R result = r.apply(session);
      session.getTransaction().commit();
      return result;
    } catch(Exception e) {
      session.getTransaction().rollback();
      return null;
    } finally  {
      session.close();
    }
  }
}
