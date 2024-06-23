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
public class Intern extends Candidate{
    private String major;
    private String semester;
    private String uniName;

    public Intern() {
    }

    public Intern(String major, String semester, String uniName) {
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
        return "Intern{" + "major=" + major + ", semester=" + semester + ", uniName=" + uniName + '}';
    }
    
    
}
