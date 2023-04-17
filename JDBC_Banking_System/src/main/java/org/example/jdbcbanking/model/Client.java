package org.example.jdbcbanking.model;

public class Client {

    private  String name;
    private  String password;

    private String address;

    private String phone;
    private  double money;

    public Client() {
    }

    public String getName() {
        return name;
    }

    public Client(String name, String password, String address, String phone, double money) {
        this.name = name;
        this.password = password;
        this.address = address;
        this.phone = phone;
        this.money = money;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "client{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", money=" + money +
                '}';
    }
}
