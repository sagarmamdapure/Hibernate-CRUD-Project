package com.practice.hibernate.main;

import com.practice.hibernate.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryEmployee {
  public static void main(String[] args) {
    SessionFactory sessionFactory =
        new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(Employee.class)
            .buildSessionFactory();

    try (sessionFactory) {
      int employeeId = 4;
      Session currentSession = sessionFactory.getCurrentSession();
      currentSession.beginTransaction();

      List<Employee> employeeList = currentSession.createQuery("from Employee").getResultList();
      for (Employee employee : employeeList) {
        System.out.println(employee);
      }

      Employee employee = currentSession.get(Employee.class, employeeId);
      System.out.println("Employee name is : " + employee.getFirstName());

      System.out.println("Querying employee based on the company name");
      List<Employee> resultList =
          currentSession
              .createQuery("from Employee E where E.companyName='dummy_company_name'")
              .getResultList();
      for (Employee tempEmployee : resultList) {
        System.out.println(tempEmployee);
      }
      currentSession.getTransaction().commit();
    }
  }
}
