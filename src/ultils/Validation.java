/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ultils;

import java.util.ArrayList;
import java.util.Scanner;
import model.Candidate;

/**
 *
 * @author NGUYEN DUC VIET
 */
public class Validation {

    private static Scanner sc = new Scanner(System.in);

    public static int chooseChoice() {
        int choice;
        while (true) {
            try {
                choice = Integer.parseInt(sc.nextLine());
                if (choice < 0) {
                    System.out.print("Enter your choice again: ");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.print("Enter your choice again: ");
            }
        }
        return choice;
    }

    public static boolean checkDuplcationID(ArrayList<Candidate> arr, String id) {
        for (Candidate can : arr) {
            if (can.getCandidateID().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }

    public static String insertId(ArrayList<Candidate> arr) {
        String pattern = "^se\\d+$";
        String id;
        while (true) {
            id = sc.nextLine();
            if (id.trim().isEmpty()) {
                System.out.print("Id cannot be empty. Enter id again: ");
            } else if (checkDuplcationID(arr, id)) {
                System.out.print("Id has existed. Enter other Id: ");
            } else if (!id.matches(pattern)) {
                System.out.println("Enter is as this pattern 'se' and a random digit.");
                System.out.print("Enter id again: ");
            } else {
                break;
            }
        }
        return id.toUpperCase();
    }

    public static String insertFirstName() {
        String name;
        while (true) {
            name = sc.nextLine();
            if (name.trim().isEmpty()) {
                System.out.print("First name cannot be enpty. Enter first name again: ");
            } else {
                break;
            }
        }
        return name.toUpperCase();
    }

    public static String insertLastName() {
        String name;
        while (true) {
            name = sc.nextLine();
            if (name.trim().isEmpty()) {
                System.out.print("Last name cannot be enpty. Enter last name again: ");
            } else {
                break;
            }
        }
        return name.toUpperCase();
    }

    public static int insertBirthDate(int min, int max) {
        int n;
        while (true) {
            try {
                n = Integer.parseInt(sc.nextLine());
                if (min <= n && n <= max) {
                    break;
                }
                System.out.print("Please enter an integer number in range " + min + " to " + max + " : ");
            } catch (Exception e) {
                System.out.print("Please enter an integer number in range " + min + " to " + max + " : ");
            }
        }
        return n;
    }

    public static String insertAddress() {
        String address;
        while (true) {
            address = sc.nextLine();
            if (address.isEmpty()) {
                System.out.print("Address cannot be empty. Enter address again: ");
            } else {
                break;
            }
        }
        return address;
    }

    public static String insertPhone() {
        String pattern = "^0\\d{9}$";
        String phone;
        while (true) {
            phone = sc.nextLine();
            if (phone.isEmpty()) {
                System.out.println("Phone cannot be empty. Enter phone again: ");
            } else if (!phone.matches(pattern)) {
                System.out.println("Enter your phone as this pattern '0' and 9 digits.");
                System.out.print("Enter phone again: ");
            } else {
                break;
            }
        }
        return phone;
    }

    public static String insertEmail() {
        String pattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[gmail\\.com]+$";
        String email;
        while (true) {
            email = sc.nextLine();
            if (email.isEmpty()) {
                System.out.println("Email cannot be empty. Enter email again: ");
            } else if (!email.matches(pattern)) {
                System.out.println("Enter your email again as this pattern 'emailname@gmail.com'.");
                System.out.print("Enter email again: ");
            } else {
                break;
            }
        }
        return email;
    }

    public static int insertExp() {
        int exp;
        while (true) {
            try {
                exp = Integer.parseInt(sc.nextLine());
                if (exp < 0) {
                    System.out.print("Exp must be > 0. Please enter experience again: ");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.print("Please enter experience again: ");
            }
        }
        return exp;
    }

    public static String insertProSkill() {
        String skill;
        while (true) {
            skill = sc.nextLine();
            if (skill.isEmpty()) {
                System.out.print("Pro-skill cannot be empty. Enter pro-skill again: ");
            } else {
                break;
            }
        }
        return skill.toUpperCase();
    }

    public static int insertGraYear() {
        int graYear;
        while (true) {
            try {
                graYear = Integer.parseInt(sc.nextLine());
                if (graYear < 0) {
                    System.out.print("Year of graduation must be > 0. Please year of graduation again: ");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.print("Please year of graduation again: ");
            }
        }
        return graYear;
    }

    public static String insertGraRank() {
        String rank;
        while (true) {
            rank = sc.nextLine();
            if (rank.isEmpty()) {
                System.out.print("Graduation rank cannot be empty. Enter graduation rank again: ");
            } else {
                break;
            }
        }
        return rank.toUpperCase();
    }

    public static String insertEdu() {
        String edu;
        while (true) {
            edu = sc.nextLine();
            if (edu.isEmpty()) {
                System.out.print("Education cannot be empty. Enter education again: ");
            } else {
                break;
            }
        }
        return edu.toUpperCase();
    }

    public static String insertMajor() {
        String major;
        while (true) {
            major = sc.nextLine();
            if (major.isEmpty()) {
                System.out.print("Major cannot be empty. Enter major again: ");
            } else {
                break;
            }
        }
        return major.toUpperCase();
    }

    public static String insertSemester() {
        String semester;
        while (true) {
            semester = sc.nextLine();
            if (semester.isEmpty()) {
                System.out.print("Semester cannot be empty. Enter semester again: ");
            } else {
                break;
            }
        }
        return semester.toUpperCase();
    }

    public static String uniName() {
        String uniName;
        while (true) {
            uniName = sc.nextLine();
            if (uniName.isEmpty()) {
                System.out.print("University's name cannot be empty. Enter uni's name again: ");
            } else {
                break;
            }
        }
        return uniName.toUpperCase();
    }
}
