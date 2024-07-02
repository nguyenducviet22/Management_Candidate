/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ultils;

import model.Candidate;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import model.Experienced;
import model.Fresher;
import model.Intern;

/**
 *
 * @author NGUYEN DUC VIET
 */
public class ReadWriteFile {

    public List readFromExpFile() {
        List list = new ArrayList<>();
        try {
            FileReader fr = new FileReader("Experienced candidate info.txt");
            BufferedReader br = new BufferedReader(fr);
            String info = "";
            while (true) {
                info = br.readLine();
                if (info == null) {
                    break;
                }
                String str[] = info.split("\\|");
                String id = str[1].trim();
                String fname = str[2].trim();
                String lname = str[3].trim();
                int yob = Integer.parseInt(str[4].trim());
                String addr = str[5].trim();
                String phone = str[6].trim();
                String email = str[7].trim();
                int exp = Integer.parseInt(str[8].trim());
                String skill = str[9].trim();

                list.add(new Experienced(id, fname, lname, yob, addr, phone, email, exp, skill));
            }
        } catch (Exception e) {
            System.out.println("Cannot read from experienced file.");
        }
        return list;
    }

    public List readFromFresherFile() {
        List list = new ArrayList<>();
        try {
            FileReader fr = new FileReader("Fresher candidate info.txt");
            BufferedReader br = new BufferedReader(fr);
            String info = "";
            while (true) {
                info = br.readLine();
                if (info == null) {
                    break;
                }
                String str[] = info.split("\\|");
                String id = str[1].trim();
                String fname = str[2].trim();
                String lname = str[3].trim();
                int yob = Integer.parseInt(str[4].trim());
                String addr = str[5].trim();
                String phone = str[6].trim();
                String email = str[7].trim();
                int graYear = Integer.parseInt(str[8].trim());
                String graRank = str[9].trim();
                String edu = str[10].trim();

                list.add(new Fresher(id, fname, lname, yob, addr, phone, email, graYear, graRank, edu));
            }
        } catch (Exception e) {
            System.out.println("Cannot read from fresher file.");
        }
        return list;
    }

    public List readFromInternFile() {
        List list = new ArrayList<>();
        try {
            FileReader fr = new FileReader("Intern candidate info.txt");
            BufferedReader br = new BufferedReader(fr);
            String info = "";
            while (true) {
                info = br.readLine();
                if (info == null) {
                    break;
                }
                String str[] = info.split("\\|");
                String id = str[1].trim();
                String fname = str[2].trim();
                String lname = str[3].trim();
                int yob = Integer.parseInt(str[4].trim());
                String addr = str[5].trim();
                String phone = str[6].trim();
                String email = str[7].trim();
                String major = str[8].trim();
                String semester = str[9].trim();
                String uniName = str[10].trim();

                list.add(new Intern(id, fname, lname, yob, addr, phone, email, major, semester, uniName));
            }
        } catch (Exception e) {
            System.out.println("Cannot read from intern file.");
        }
        return list;
    }

    public void writeToExpFile(ArrayList<Experienced> list) {
        try {
            FileWriter fw = new FileWriter("Experienced candidate info.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            for (Experienced exp : list) {
                bw.write(exp.toString());
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (Exception e) {
            System.out.println("Cannot write to experienced file.");
        }
    }

    public void writeToFresherFile(ArrayList<Fresher> list) {
        try {
            FileWriter fw = new FileWriter("Fresher candidate info.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            for (Fresher fresher : list) {
                bw.write(fresher.toString());
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (Exception e) {
            System.out.println("Cannot write to fresher file.");
        }
    }

    public void writeToInternFile(ArrayList<Intern> list) {
        try {
            FileWriter fw = new FileWriter("Intern candidate info.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            for (Intern intern : list) {
                bw.write(intern.toString());
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (Exception e) {
            System.out.println("Cannot write to intern file.");
        }
    }
}
