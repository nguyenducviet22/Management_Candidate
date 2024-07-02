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
public class Fresher extends Candidate{
    private int graduationDate;
    private String graduationRank;
    private String education;

    public Fresher() {
    }

    public Fresher(String candidateID, String firstName, String lastName, int birthDate, String address, String phone, String email, int graduationDate, String graduationRank, String education) {
        super(candidateID, firstName, lastName, birthDate, address, phone, email);
        this.graduationDate = graduationDate;
        this.graduationRank = graduationRank;
        this.education = education;
    }
    

    public int getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(int graduationDate) {
        this.graduationDate = graduationDate;
    }

    public String getGraduationRank() {
        return graduationRank;
    }

    public void setGraduationRank(String graduationRank) {
        this.graduationRank = graduationRank;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    @Override
    public String toString() {
        return String.format("%-15s | %-12s | %-10s | %-10s | %4d | %-15s | %-10s | %-15s | %15d | %-15s | %-10s |", 
                "Fresher", candidateID, firstName, lastName, birthDate, address, phone, email, graduationDate, graduationRank, education);
    }
    
    
}
