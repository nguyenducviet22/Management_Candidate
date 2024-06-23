/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managementcandidate;

/**
 *
 * @author NGUYEN DUC VIET
 */
public class Experienced extends Candidate{
    private int expYear;
    private String proSkill;

    public Experienced() {
    }

    public Experienced(int expYear, String proSkill) {
        this.expYear = expYear;
        this.proSkill = proSkill;
    }

    @Override
    public String toString() {
        return "Experienced{" + "expYear=" + expYear + ", proSkill=" + proSkill + '}';
    }
    
    
}
