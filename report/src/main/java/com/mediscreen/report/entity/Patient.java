package com.mediscreen.report.entity;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

public class Patient {
    private int id;
    private String name;
    private String firstName;
    private Date birthday;
    private String sex;
    private String address;
    private String phone;

    public Patient() {
    }

    public Patient(int id, String name, String firstName, Date birthday, String sex, String address, String phone) {
        this.id = id;
        this.name = name;
        this.firstName = firstName;
        this.birthday = birthday;
        this.sex = sex;
        this.address = address;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
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


    public int getAge(){
        LocalDate now = LocalDate.now();
        return birthday != null ? Period.between(convertToLocalDateTime(this.birthday), now).getYears() : 0;
    }

    public static LocalDate convertToLocalDateTime(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }


}
