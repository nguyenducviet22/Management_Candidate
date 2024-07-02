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
public class Experienced extends Candidate {

    private int expYear;
    private String proSkill;

    public Experienced() {
    }

    public Experienced(String candidateID, String firstName, String lastName, int birthDate, String address, String phone, String email, int expYear, String proSkill) {
        super(candidateID, firstName, lastName, birthDate, address, phone, email);
        this.expYear = expYear;
        this.proSkill = proSkill;
    }

    public int getExpYear() {
        return expYear;
    }

    public void setExpYear(int expYear) {
        this.expYear = expYear;
    }

    public String getProSkill() {
        return proSkill;
    }

    public void setProSkill(String proSkill) {
        this.proSkill = proSkill;
    }

    @Override
    public String toString() {
        return String.format("%-15s | %-12s | %-10s | %-10s | %4d | %-15s | %-10s | %-15s | %10d | %-10s |", 
                "Experienced", candidateID, firstName, lastName, birthDate, address, phone, email, expYear, proSkill);
    }

}
