package com.raven.service;

import com.raven.connection.DatabaseConnection;
import com.raven.model.ModelName;
import com.raven.model.ModelStaff;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class ServiceStaff {

    public void insertStaff(ModelStaff data) throws SQLException, IOException {
        String sql = "insert into staff(FirstName, LastName, Gender, Age, Email, Tel, Profile) values (?,?,?,?,?,?,?)";
        PreparedStatement p = DatabaseConnection.getInstance().getConnection().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        p.setString(1, data.getName().getFirstName());
        p.setString(2, data.getName().getLastName());
        p.setString(3, data.getGender());
        p.setInt(4, data.getAge());
        p.setString(5, data.getEmail());
        p.setString(6, data.getPhoneNumber());
        if (data.getName().getPath().equals("")) {
            p.setObject(7, null);
        } else {
            p.setBlob(7, Files.newInputStream(new File(data.getName().getPath()).toPath()));
        }
        p.execute();
        ResultSet r = p.getGeneratedKeys();
        r.first();
        int staffID = r.getInt(1);
        data.setStaffID(staffID);
        r.close();
        p.close();
    }

    public void updateStaff(ModelStaff data) throws SQLException, IOException {
        if (data.getName().getPath().equals("Image")) {
            //  User no update image
            String sql = "update staff set Firstname=?, LastName=?, Gender=?, Age=?, Email=?, Tel=? where StaffID=? limit 1";
            PreparedStatement p = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
            p.setString(1, data.getName().getFirstName());
            p.setString(2, data.getName().getLastName());
            p.setString(3, data.getGender());
            p.setInt(4, data.getAge());
            p.setString(5, data.getEmail());
            p.setString(6, data.getPhoneNumber());
            p.setInt(7, data.getStaffID());
            p.execute();
            p.close();
        } else {
            //  User update image
            String sql = "update staff set Firstname=?, LastName=?, Gender=?, Age=?, Email=?, Tel=?, Profile=? where StaffID=? limit 1";
            PreparedStatement p = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
            p.setString(1, data.getName().getFirstName());
            p.setString(2, data.getName().getLastName());
            p.setString(3, data.getGender());
            p.setInt(4, data.getAge());
            p.setString(5, data.getEmail());
            p.setString(6, data.getPhoneNumber());
            if (data.getName().getPath().equals("")) {
                p.setObject(7, null);
            } else {
                p.setBlob(7, Files.newInputStream(new File(data.getName().getPath()).toPath()));
            }
            p.setInt(8, data.getStaffID());
            p.execute();
            p.close();
        }
    }

    public List<ModelStaff> getStaff() throws SQLException {
        List<ModelStaff> list = new ArrayList<>();
        String sql = "select * from staff";
        PreparedStatement p = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
        ResultSet r = p.executeQuery();
        while (r.next()) {
            int staffID = r.getInt("StaffID");
            String firstName = r.getString("FirstName");
            String lastName = r.getString("LastName");
            Icon profile = null;
            if (r.getObject("Profile") != null) {
                profile = new ImageIcon(r.getBytes("Profile"));
            }
            String gender = r.getString("Gender");
            int age = r.getInt("Age");
            String email = r.getString("Email");
            String phoneNumber = r.getString("Tel");
            list.add(new ModelStaff(staffID, new ModelName(firstName, lastName, profile, "Image"), gender, age, email, phoneNumber));
        }
        r.close();
        p.close();
        return list;
    }

    public void deleteStaff(int staffID) throws SQLException {
        String sql = "delete from staff where StaffID=? limit 1";
        PreparedStatement p = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
        p.setInt(1, staffID);
        p.execute();
        p.close();
    }
}
