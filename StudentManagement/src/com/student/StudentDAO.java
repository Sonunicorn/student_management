package com.student;

import java.sql.*;

public class StudentDAO {

    public void addStudent(Student s) throws Exception {
        Connection con = DBconnection.getConnection();
        PreparedStatement ps = con.prepareStatement(
            "INSERT INTO students(name,email,course) VALUES(?,?,?)");

        ps.setString(1, s.getName());
        ps.setString(2, s.getEmail());
        ps.setString(3, s.getCourse());

        ps.executeUpdate();
        System.out.println("Student Added!");
    }

    public void viewStudents() throws Exception {
        Connection con = DBconnection.getConnection();
        Statement st = con.createStatement();

        ResultSet rs = st.executeQuery("SELECT * FROM students");
        if(!rs.isBeforeFirst()) {
            System.out.println("No records found!");
        }
        while(rs.next()) {  
            System.out.println("ID: " + rs.getInt("id"));
            System.out.println("Name: " + rs.getString("name"));
            System.out.println("Email: " + rs.getString("email"));
            System.out.println("Course: " + rs.getString("course"));
            System.out.println("---------------------------");
        }
    }
}