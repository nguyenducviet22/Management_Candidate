/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managementcandidate;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author NGUYEN DUC VIET
 */
public class CandidateList extends ArrayList<Candidate> {

    public Candidate searchByName(String name) {
        for (Candidate can : this) {
            if (can.getFirstName().equalsIgnoreCase(name)) {
                return can;
            }
        }
        return null;
    }

    public Candidate searchById(String id) {
        for (Candidate can : this) {
            if (can.getCandidateID().equalsIgnoreCase(id)) {
                return can;
            }
        }
        return null;
    }

    public void insert(Candidate can) {
        this.add(can);
        
    }

    public void deleteByID(String id) {
        this.remove(id);
    }

    public List<Candidate> showCandidateList() {
        try {
            FileReader fr = new FileReader("Candidate info.txt");
            BufferedReader br = new BufferedReader(fr);
            String info = "";
            while (true) {
                info = br.readLine();
                if (info == null) {
                    break;
                }
                String str[] = info.split(",");
                String id = str[0];
                String fname = str[1];
                String lname = str[2];
                int yob = Integer.parseInt(str[3].trim());
                String addr = str[4];
                int phone = Integer.parseInt(str[5].trim());
                String email = str[6];
                this.insert(new Candidate(id, fname, lname, yob, addr, phone, email));
            }
        } catch (Exception e) {
            System.out.println("Failed");
        }
        return this;
    }
}
