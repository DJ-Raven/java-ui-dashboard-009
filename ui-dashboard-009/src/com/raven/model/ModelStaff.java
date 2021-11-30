package com.raven.model;

import com.raven.table.model.TableRowData;

public class ModelStaff extends TableRowData {

    public ModelName getName() {
        return name;
    }

    public void setName(ModelName name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public ModelStaff(ModelName name, String gender, int age, String email, String phoneNumber) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public ModelStaff() {
    }

    private ModelName name;
    private String gender;
    private int age;
    private String email;
    private String phoneNumber;

    @Override
    public Object[] toTableRow() {
        return new Object[]{name, gender, age, email, phoneNumber};
    }
}
