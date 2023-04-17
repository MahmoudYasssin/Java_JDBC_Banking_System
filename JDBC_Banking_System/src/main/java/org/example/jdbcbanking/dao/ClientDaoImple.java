package org.example.jdbcbanking.dao;

import org.example.jdbcbanking.model.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ClientDaoImple implements ClientDao{
    @Override
    public void save(Client client) {

        Connection con=DBConnection.getConnection();
        if(con==null)
        {
            return;
        }

        Boolean Exist=true;

        String query = "SELECT * FROM client WHERE password='" + client.getPassword() + "'";

        try (PreparedStatement preparedStatement = con.prepareStatement(query);) {

           // preparedStatement.setString(1, client.getPassword());

           // preparedStatement.executeUpdate();

            ResultSet rs = preparedStatement.executeQuery(query);


            if(rs.next())   //Update
            {

                Exist=true;
            }
            else  //Insert
            {

                Exist=false;

            }


        } catch (SQLException se) {
            se.printStackTrace();
        }


        if (Exist)  // update
        {
            String query1 = "UPDATE client SET name=?,address=?,phone =?,money=? WHERE password=?;";

            try (PreparedStatement preparedStatement = con.prepareStatement(query1);) {

                preparedStatement.setString(1, client.getName());
                preparedStatement.setString(5, client.getPassword());
                preparedStatement.setString(2, client.getAddress());
                preparedStatement.setString(3, client.getPhone());
                preparedStatement.setDouble(4, client.getMoney());


                preparedStatement.executeUpdate();

            } catch (SQLException se) {
                se.printStackTrace();
            } finally {
                try {
                    con.close();
                } catch (SQLException se) {
                    se.printStackTrace();
                }
            }


        }
        else  //insert
        {
            String Query="INSERT INTO client(name,password,address,phone,money)VALUES(?,?,?,?,?);";

            try (PreparedStatement preparedStatement = con.prepareStatement(Query);) {

                preparedStatement.setString(1, client.getName());
                preparedStatement.setString(2, client.getPassword());
                preparedStatement.setString(3, client.getAddress());
                preparedStatement.setString(4, client.getPhone());
                preparedStatement.setDouble(5, client.getMoney());


                preparedStatement.executeUpdate();

            } catch (SQLException se) {
                se.printStackTrace();
            } finally {
                try {
                    con.close();
                } catch (SQLException se) {
                    se.printStackTrace();
                }
            }


        }


    }

    @Override
    public void delete(String password) {

        Connection con = DBConnection.getConnection();
        if (con == null) {
            return;
        }
        String query = "DELETE FROM client WHERE password=?;";
        try (PreparedStatement preparedStatement = con.prepareStatement(query);) {

            preparedStatement.setString(1, password);

            preparedStatement.executeUpdate();

        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }


    }

    @Override
    public Client findByPass(String password) {
        Connection con = DBConnection.getConnection();
        if (con == null) {
            return null;
        }

        String query = "SELECT * FROM client WHERE password=?;";
        try (PreparedStatement preparedStatement = con.prepareStatement(query);) {
            preparedStatement.setString(1, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if ((resultSet.next())) {
                // int id, String name, double GPA, String department, String status
                Client client = new Client(resultSet.getString("name"), resultSet.getString("password"), resultSet.getString("address"), resultSet.getString("phone"), resultSet.getDouble("money"));

                return client;
            }

        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }

        return null;
    }



    @Override
    public void deposit_withdraw(String password) {
        Connection con = DBConnection.getConnection();
        if (con == null) {
            return ;
        }
        String query1 = "UPDATE client SET money=? WHERE password=?;";
        Scanner sc = new Scanner(System.in);



        System.out.println("deposit 1  | withdraw 2");
        int s;
        s=sc.nextInt();


        System.out.println("Enter money");
        double Money;
        Money=sc.nextDouble();


       try (PreparedStatement preparedStatement = con.prepareStatement(query1);) {


            if(s==1)
            {
                preparedStatement.setString(2, password);

                preparedStatement.setDouble(1, findByPass(password).getMoney()+Money);
                preparedStatement.executeUpdate();


            }
            else if(s==2)
            {
                if(findByPass(password).getMoney()<Money)
                {
                    System.out.println("Don't Have Enough Money");
                }
                else
                {
                    preparedStatement.setString(2, password);
                    preparedStatement.setDouble(1, findByPass(password).getMoney()-Money);
                    preparedStatement.executeUpdate();

                }
            }




          } catch (SQLException se) {
            se.printStackTrace();
          }finally {
            try {
                con.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }

        }


    }


}
