package com.mediscreen.patient.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import org.springframework.format.annotation.DateTimeFormat;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
public class Patient {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column (name = "last_name")
    @Length(min = 2, max = 60)
    @NotBlank(message = "LastName can't be blank")
    @NotNull
    private String name;
    
    @Column (name = "first_name") 
    @Length(min = 2, max = 60)
    @NotBlank(message = "LastName can't be blank")
    @NotNull
    private String firstName;
    
    @Column (name = "sex") 
    @NotBlank(message = "Sex can't be blank")
    private String sex;
    
    @Column (name = "date_of_birth") 
    @NotNull(message = "Date of Birth can't be null")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;
    
    @Column (name = "home_address") 
    @NotBlank(message = "Address can't be blank")
    private String address;
    
    @Column (name = "phone_number") 
    private String phone;

    public Patient() {
    }

    public Patient(String name, String firstName, LocalDate birthday, String sex, String address, String phone) {
        this.name = name;
        this.firstName = firstName;
        this.birthday = birthday;
        this.sex = sex;
        this.address = address;
        this.phone = phone;
    }

    public Patient(int id, String name, String firstName, LocalDate birthday, String sex, String address, String phone) {
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

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
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


    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", firstName='" + firstName + '\'' +
                ", birthday=" + birthday +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
