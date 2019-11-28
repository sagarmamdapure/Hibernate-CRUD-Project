package com.practice.hibernate.main;

import com.practice.hibernate.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteEmployee {
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

      Employee employee = new Employee();
      employee.setEmployeeId(employeeId);
      currentSession.delete(employee);
      currentSession.getTransaction().commit();
    }
  }
}
