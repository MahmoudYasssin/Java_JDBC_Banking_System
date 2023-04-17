package org.example.jdbcuniversity.dao;

import org.example.jdbcuniversity.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class StudentDaoImple implements StudentDao {

    @Override
    public List<Student> findAll() {

        Connection con = DBConnection.getConnection();
        if (con == null) {
            return null;
        }
        List<Student> students = new LinkedList<>();
        String query = "SELECT * FROM student;";
        try (PreparedStatement preparedStatement = con.prepareStatement(query);) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while ((resultSet.next())) {
                // int id, String name, double GPA, String department, String status
                Student student = new Student(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getDouble("GPA"), resultSet.getString("department"), resultSet.getString("status"));

                students.add(student);

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

        return students;

    }

    @Override
    public Student findById(int id) {
        Connection con = DBConnection.getConnection();
        if (con == null) {
            return null;
        }

        String query = "SELECT * FROM student WHERE id=?;";
        try (PreparedStatement preparedStatement = con.prepareStatement(query);) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if ((resultSet.next())) {
                // int id, String name, double GPA, String department, String status
                Student student = new Student(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getDouble("GPA"), resultSet.getString("department"), resultSet.getString("status"));
                return student;
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
    public void save(Student student) {
        Connection con = DBConnection.getConnection();
        if (con == null) {
            return;
        }
        if (student.getId() > 0)  //update
        {

            String query = "UPDATE student SET name=?,GPA=?,department=?,status =? WHERE id=?;";
            try (PreparedStatement preparedStatement = con.prepareStatement(query);) {

                preparedStatement.setString(1, student.getName());
                preparedStatement.setDouble(2, student.getGPA());
                preparedStatement.setString(3, student.getDepartment());
                preparedStatement.setString(4, student.getStatus());

                preparedStatement.setInt(5, student.getId());

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

        } else  //insert
        {
            String query = "INSERT INTO student(name,GPA,department,status)VALUES(?,?,?,?);";
            try (PreparedStatement preparedStatement = con.prepareStatement(query);) {

                preparedStatement.setString(1, student.getName());
                preparedStatement.setDouble(2, student.getGPA());
                preparedStatement.setString(3, student.getDepartment());
                preparedStatement.setString(4, student.getStatus());

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
    public void deleteById(int id) {
        Connection con = DBConnection.getConnection();
        if (con == null) {
            return;
        }
        String query = "DELETE FROM student WHERE id=?;";
        try (PreparedStatement preparedStatement = con.prepareStatement(query);) {

            preparedStatement.setInt(1, id);

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


    public void deleteAll() {
        Connection con = DBConnection.getConnection();
        if (con == null) {
            return;
        }
        String query = "DELETE FROM student;";
        try (PreparedStatement preparedStatement = con.prepareStatement(query);) {

            int rowsDeleted = preparedStatement.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println(rowsDeleted + " rows have been deleted successfully.");
            } else {
                System.out.println("No rows have been deleted.");
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


    }
}
