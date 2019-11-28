package com.practice.hibernate.main;

import com.practice.hibernate.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateEmployee {
  public static void main(String[] args) {
      SessionFactory sessionFactory =
              new Configuration()
                      .configure("hibernate.cfg.xml")
                      .addAnnotatedClass(Employee.class)
                      .buildSessionFactory();

      try (sessionFactory) {
          Session currentSession = sessionFactory.getCurrentSession();
          currentSession.beginTransaction();

          Employee employee = new Employee("dummy_first_name", "dummy_fist_name", "dummy_company_name");
          currentSession.save(employee);
          currentSession.getTransaction().commit();
      }
  }
}
