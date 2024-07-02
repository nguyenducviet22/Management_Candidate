/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.Candidate;

/**
 *
 * @author NGUYEN DUC VIET
 */
public class Intern extends Candidate{
    private String major;
    private String semester;
    private String uniName;

    public Intern() {
    }

    public Intern(String candidateID, String firstName, String lastName, int birthDate, String address, String phone, String email, String major, String semester, String uniName) {
        super(candidateID, firstName, lastName, birthDate, address, phone, email);
        this.major = major;
        this.semester = semester;
        this.uniName = uniName;
    }

    

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getUniName() {
        return uniName;
    }

    public void setUniName(String uniName) {
        this.uniName = uniName;
    }

    @Override
    public String toString() {
        return String.format("%-15s | %-12s | %-10s | %-10s | %4d | %-15s | %-10s | %-15s | %-10s | %-8s | %-10s |", 
                "Intern", candidateID, firstName, lastName, birthDate, address, phone, email, major, semester, uniName);
    }
    
    
}
