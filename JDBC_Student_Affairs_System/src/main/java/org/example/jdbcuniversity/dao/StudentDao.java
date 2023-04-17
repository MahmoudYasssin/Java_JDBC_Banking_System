package org.example.jdbcuniversity.dao;

import org.example.jdbcuniversity.model.Student;

import java.util.List;

public interface StudentDao {
    List<Student>findAll();
    Student findById(int id);
    void save (Student student);   //
    void deleteById(int id);  //

    void deleteAll();


}
