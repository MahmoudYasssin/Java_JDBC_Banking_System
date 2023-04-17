package org.example.jdbcbanking;

import org.example.jdbcbanking.dao.ClientDao;
import org.example.jdbcbanking.dao.ClientDaoImple;
import org.example.jdbcbanking.dao.DBConnection;
import org.example.jdbcbanking.model.Client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {



       ClientDao clientDao=new ClientDaoImple();



        System.out.println("To Create Account Press 1");
        System.out.println("To Update Your information Press 1");
        System.out.println("To Delete Your Account Press 2");
        System.out.println("To Print Your Information Press 3");
        System.out.println("To Deposit OR Withdraw Press 4");
        System.out.println("To Exit Press 5");


        Scanner sc = new Scanner(System.in);
        while (true) {


            int num;
            num = sc.nextInt();

            switch (num) {
                case 1:

                    double Money = 0;
                    System.out.print("Enter Your Name:");
                    String Name = sc.next();

                    System.out.print("Enter Your Password:");
                    String Password = sc.next();
                    System.out.print("Enter Your Address:");
                    String address = sc.next();
                    System.out.print("Enter Your Phone Number:");
                    String Phone = sc.next();
                    Client new_client = new Client(Name, Password, address, Phone, Money);
                    clientDao.save(new_client);
                    System.out.println("Done !");
                    break;
                case 2:
                    String Password2;
                    System.out.print("Enter Your Password:");
                    Password2 = sc.next();
                    clientDao.delete(Password2);
                    System.out.println("Done !");
                    break;
                case 3:
                    String Password3;
                    System.out.print("Enter Your Password:");
                    Password3 = sc.next();
                    System.out.println(clientDao.findByPass(Password3));
                    System.out.println("Done !");
                    break;

                case 4:
                    String Password4;
                    System.out.print("Enter Your Password:");
                    Password4 = sc.next();
                    clientDao.deposit_withdraw(Password4);
                    System.out.println("Done !");
                    break;

                case 5:
                    System.out.println("Thank You -_-");
                    return;


            }
        }



    }
}