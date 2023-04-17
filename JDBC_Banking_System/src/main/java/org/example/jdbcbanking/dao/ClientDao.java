package org.example.jdbcbanking.dao;

import org.example.jdbcbanking.model.Client;

public interface ClientDao {

    void save(Client client);  //insert new  or update

    void delete(String password);   //delete

    Client findByPass(String password);   // print

    void deposit_withdraw(String password);  //add money







}
