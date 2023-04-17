package org.example.jdbcuniversity;


import org.example.jdbcuniversity.model.Student;
import org.example.jdbcuniversity.dao.StudentDao;
import org.example.jdbcuniversity.dao.StudentDaoImple;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        StudentDao studentDao=new StudentDaoImple();
       // Student student1=new Student(0,"Mahmoud",2.72,"IT","Active");
      //  studentDao.save(student1);

    //    Student student2=new Student(0,"Ahmed",2.5,"IT","UnActivate");
        //studentDao.save(student2);

        //Student student3=new Student(0,"Ziad",2.2,"CS","Activate");
       // studentDao.save(student3);
       // studentDao.deleteById(2);
       // studentDao.deleteById(1);

       // studentDao.findAll().forEach(System.out::println);
      //  Student student4=studentDao.findById(4);
      //  System.out.println(student4);
       // studentDao.deleteAll();
        System.out.println("if you need to add new student press 1");
        System.out.println("if you need to delete student press 2");
        System.out.println("if you need to print all student's data press 3");
        System.out.println("if you need to print student's data press 4");
        System.out.println("if you need to Update student's data press 5");
        System.out.println("if you need to Delete all student's data press 6");
        System.out.println("if you need to Exist press 7");

        Scanner sc = new Scanner(System.in);
          while (true)
          {
              int num;


              num=sc.nextInt();
              switch (num){

                  case 1:
                      String Name;
                      String Department;
                      String Status;
                      double gpa;
                      System.out.println("Enter Student Name");
                      Name=sc.next();
                      System.out.println("Enter Student Department");
                      Department=sc.next();
                      System.out.println("Enter Student GPA");
                      gpa=sc.nextDouble();
                      System.out.println("Enter Student Status");
                      Status=sc.next();
                      Student student1=new Student(0,Name,gpa,Department,Status);
                      studentDao.save(student1);
                      System.out.println("Done !");
                      break;
                  case 2:
                      int ID;
                      System.out.println("Enter the student's ID you need to delete it");
                      ID=sc.nextInt();
                      studentDao.deleteById(ID);
                      System.out.println("Done !");
                      break;
                  case 3:
                      studentDao.findAll().forEach(System.out::println);
                      System.out.println("Done !");
                      break;
                  case 4:

                      int IDD;
                      System.out.println("Enter the student's ID you need to print it");
                      IDD=sc.nextInt();
                      Student student4=studentDao.findById(IDD);
                      System.out.println(student4);
                      System.out.println("Done !");
                      break;

                  case 5:
                      String Namee;
                      String Departmentt;
                      String Statuss;
                      double gpaa;
                      int IDDD;
                      System.out.println("Enter Student Name");
                      Namee=sc.next();
                      System.out.println("Enter Student ID");
                      IDDD=sc.nextInt();
                      System.out.println("Enter Student Department");
                      Departmentt=sc.next();
                      System.out.println("Enter Student GPA");
                      gpaa=sc.nextDouble();
                      System.out.println("Enter Student Status");
                      Statuss=sc.next();
                      Student student3=new Student(IDDD,Namee,gpaa,Departmentt,Statuss);
                      studentDao.save(student3);
                      System.out.println("Done !");
                  case 6:
                      studentDao.deleteAll();
                      System.out.println("Done !");
                      break;
                  default:
                      System.out.println("Thank You -_-");
                      return;
              }

          }

    }
}
