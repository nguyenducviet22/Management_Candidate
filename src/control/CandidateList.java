package control;

import java.util.ArrayList;
import ultils.ReadWriteFile;
import model.Candidate;
import java.util.Scanner;
import model.Experienced;
import model.Fresher;
import model.Intern;
import ultils.Validation;

public class CandidateList {

    Scanner sc = new Scanner(System.in);
    Validation v = new Validation();
    ReadWriteFile rw = new ReadWriteFile();
    ArrayList<Experienced> expList = new ArrayList<>();
    ArrayList<Fresher> fresherList = new ArrayList<>();
    ArrayList<Intern> internList = new ArrayList<>();
    ArrayList<Candidate> list = new ArrayList<>();

    public CandidateList() {
        expList = (ArrayList<Experienced>) rw.readFromExpFile();
        fresherList = (ArrayList<Fresher>) rw.readFromFresherFile();
        internList = (ArrayList<Intern>) rw.readFromInternFile();
        list.addAll(expList);
        list.addAll(fresherList);
        list.addAll(internList);
    }

    public void showExpList() {
        if (expList != null) {
            System.out.println("The experienced candidate list: ");
            System.out.println(String.format("%-15s | %-12s | %-10s | %-10s | %-4s | %-15s | %-10s | %-15s | %-10s | %-10s |", 
                "Candidate", "Candidate ID", "First name", "Last name", "Yob", "Address", "Phone", "Email", "Experience", "Pro skill"));
            for (Experienced exp : expList) {
                if (exp.getProSkill() != null) {
                    System.out.println(exp);
                }
            }
        } else {
            System.out.println("The experienced candidate list is empty!");
        }
    }
    
    public void showFresherList(){
        if (fresherList != null) {
            System.out.println("The fresher candidate list: ");
            System.out.println(String.format("%-15s | %-12s | %-10s | %-10s | %-4s | %-15s | %-10s | %-15s | %-15s | %-15s | %-10s |", 
                "Candidate", "Candidate ID", "First name", "Last name", "Yob", "Address", "Phone", "Email", "Graduated year", "Graduated rank", "Education"));
            for (Fresher fresher : fresherList) {
                if (fresher.getGraduationRank() != null) {
                    System.out.println(fresher);
                }
            }
        } else {
            System.out.println("The fresher candidate list is empty!");
        }
    }
    
    public void showInternList(){
        if (internList != null) {
            System.out.println("The intern candidate list: ");
            System.out.println(String.format("%-15s | %-12s | %-10s | %-10s | %-4s | %-15s | %-10s | %-15s | %-10s | %-8s | %-10s |", 
                "Candidate", "Candidate ID", "First name", "Last name", "Yob", "Address", "Phone", "Email", "Major", "Semester", "University"));
            for (Intern intern : internList) {
                if (intern.getUniName() != null) {
                    System.out.println(intern);
                }
            }
        } else {
            System.out.println("The intern candidate list is empty!");
        }
    }
    
    public void showAllCandidateList(){
        if (list != null) {
            System.out.println("The list of all candidates: ");
            System.out.println(String.format("%-15s | %-12s | %-10s | %-10s | %-4s | %-15s | %-10s | %-15s |", 
                "Candidate", "Candidate ID", "First name", "Last name", "Yob", "Address", "Phone", "Email"));
            for (Candidate can : list) {
                if (can.getCandidateID() != null) {
                    System.out.println(can);
                }
            }
        } else {
            System.out.println("The intern candidate list is empty!");
        }
    }
    
    public void showCandidateList() {
        int searchChoice;
        do {
            System.out.println("1. Show the Experienced list.");
            System.out.println("2. Show the Fresher list.");
            System.out.println("3. Show the Intern list.");
            System.out.println("4. Show the all candidate list.");
            System.out.println("0. Back to main menu.");
            System.out.print("Enter your choice: ");
            searchChoice = v.chooseChoice();
            switch (searchChoice) {
                case 1:
                    showExpList();
                    break;
                case 2:
                    showFresherList();
                    break;
                case 3:
                    showInternList();
                    break;
                case 4:
                    showAllCandidateList();
                    break;
                case 0:
                    System.out.println("The main menu: ");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (searchChoice != 0);
    }
    

    public void searchByName() {
        System.out.print("Enter name to find: ");
        String name = sc.nextLine();
        System.out.println(String.format("%-15s | %-12s | %-10s | %-10s | %-4s | %-15s | %-10s | %-15s |", 
                "Candidate", "Candidate ID", "First name", "Last name", "Yob", "Address", "Phone", "Email"));
        Candidate can = null;
        for (int i = 0; i < list.size(); i++) {
            String sName = list.get(i).getFirstName().trim();
            if (sName.equalsIgnoreCase(name)) {
                can = list.get(i);
            }
        }
        if (can != null) {
            System.out.println(can);
        } else {
            System.out.println("Not found");
        }
    }

    public void searchById() {
        System.out.print("Enter id to find: ");
        String id = sc.nextLine();
        System.out.println(String.format("%-15s | %-12s | %-10s | %-10s | %-4s | %-15s | %-10s | %-15s |", 
                "Candidate", "Candidate ID", "First name", "Last name", "Yob", "Address", "Phone", "Email"));
        Candidate can = null;
        for (Candidate c : list) {
            if (c.getCandidateID().trim().equalsIgnoreCase(id)) {
                can = c;
            }
        }
        if (can != null) {
            System.out.println(can);
        } else {
            System.out.println("Not found");
        }
    }

    public void searchCandidate() {
        int searchChoice;
        do {
            System.out.println("1. Search by name");
            System.out.println("2. Search by id");
            System.out.println("0. Back to main menu.");
            System.out.print("Enter your choice: ");
            searchChoice = v.chooseChoice();
            switch (searchChoice) {
                case 1:
                    searchByName();
                    break;
                case 2:
                    searchById();
                    break;
                case 0:
                    System.out.println("The main menu: ");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (searchChoice != 0);
    }
    

    public void insertExp() {
        System.out.println("Enter candidate info: ");
        System.out.print("Enter id: ");
        String id = v.insertId(list);
        System.out.print("Enter first name: ");
        String firstName = v.insertFirstName();
        System.out.print("Enter last name: ");
        String lastName = v.insertLastName();
        System.out.print("Enter year of birth: ");
        int birthDate = v.insertBirthDate(1980, 2004);
        System.out.print("Enter address: ");
        String address = v.insertAddress();
        System.out.print("Enter phone: ");
        String phone = v.insertPhone();
        System.out.print("Enter email: ");
        String email = v.insertEmail();
        System.out.print("Enter years of experiences: ");
        int exp = v.insertExp();
        System.out.print("Enter pro-skill: ");
        String skill = v.insertProSkill();
        Experienced newExp = new Experienced(id, firstName,
                lastName, birthDate, address, phone, email, exp, skill);
        expList.add(newExp);
        rw.writeToExpFile(expList);
        System.out.println("Inserted.");
    }

    public void insertFresher() {
        System.out.println("Enter candidate info: ");
        System.out.print("Enter id: ");
        String id = v.insertId(list);
        System.out.print("Enter first name: ");
        String firstName = v.insertFirstName();
        System.out.print("Enter last name: ");
        String lastName = v.insertLastName();
        System.out.print("Enter year of birth: ");
        int birthDate = v.insertBirthDate(1980, 2004);
        System.out.print("Enter address: ");
        String address = v.insertAddress();
        System.out.print("Enter phone: ");
        String phone = v.insertPhone();
        System.out.print("Enter email: ");
        String email = v.insertEmail();
        System.out.print("Enter years of graduation: ");
        int graYear = v.insertGraYear();
        System.out.print("Enter graduation rank: ");
        String graRank = v.insertGraRank();
        System.out.print("Enter education: ");
        String edu = v.insertEdu();
        Fresher newFresher = new Fresher(id, firstName,
                lastName, birthDate, address, phone, email, graYear, graRank, edu);
        fresherList.add(newFresher);
        rw.writeToFresherFile(fresherList);
        System.out.println("Inserted.");
    }

    public void insertIntern() {
        System.out.println("Enter candidate info: ");
        System.out.print("Enter id: ");
        String id = v.insertId(list);
        System.out.print("Enter first name: ");
        String firstName = v.insertFirstName();
        System.out.print("Enter last name: ");
        String lastName = v.insertLastName();
        System.out.print("Enter year of birth: ");
        int birthDate = v.insertBirthDate(1980, 2004);
        System.out.print("Enter address: ");
        String address = v.insertAddress();
        System.out.print("Enter phone: ");
        String phone = v.insertPhone();
        System.out.print("Enter email: ");
        String email = v.insertEmail();
        System.out.print("Enter major: ");
        String major = v.insertMajor();
        System.out.print("Enter semester: ");
        String semeter = v.insertSemester();
        System.out.print("Enter university: ");
        String uniName = v.uniName();
        Intern newIntern = new Intern(id, firstName, lastName, birthDate,
                address, phone, email, major, semeter, uniName);
        internList.add(newIntern);
        rw.writeToInternFile(internList);
        System.out.println("Inserted.");
    }

    public void insertCandidate() {
        int searchChoice;
        do {
            System.out.println("1. Insert an Experienced");
            System.out.println("2. Insert a Fresher");
            System.out.println("3. Insert an Intern");
            System.out.println("0. Back to main menu.");
            System.out.print("Enter your choice: ");
            searchChoice = v.chooseChoice();
            switch (searchChoice) {
                case 1:
                    insertExp();
                    break;
                case 2:
                    insertFresher();
                    break;
                case 3:
                    insertIntern();
                    break;
                case 0:
                    System.out.println("The main menu: ");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (searchChoice != 0);
    }
    

    public void updateExp() {
        System.out.print("Enter id to update: ");
        String searchID = sc.nextLine();
        for (int i = 0; i < expList.size(); i++) {
            if (expList.get(i).getCandidateID().equalsIgnoreCase(searchID)) {
                System.out.println("Enter candidate info: ");
                System.out.print("Enter first name: ");
                String firstName = v.insertFirstName();
                System.out.print("Enter last name: ");
                String lastName = v.insertLastName();
                System.out.print("Enter year of birth: ");
                int birthDate = v.insertBirthDate(1980, 2004);
                System.out.print("Enter address: ");
                String address = v.insertAddress();
                System.out.print("Enter phone: ");
                String phone = v.insertPhone();
                System.out.print("Enter email: ");
                String email = v.insertEmail();
                System.out.print("Enter years of experiences: ");
                int exp = v.insertExp();
                System.out.print("Enter pro-skill: ");
                String skill = v.insertProSkill();
                Experienced newExp = new Experienced(searchID, firstName,
                        lastName, birthDate, address, phone, email, exp, skill);
                expList.set(i, newExp);
                rw.writeToExpFile(expList);
                System.out.println("Updated.");
            }
        }
    }

    public void updateFresher() {
        System.out.print("Enter id to update: ");
        String searchID = sc.nextLine();
        for (int i = 0; i < expList.size(); i++) {
            if (expList.get(i).getCandidateID().equalsIgnoreCase(searchID)) {
                System.out.println("Enter candidate info: ");
                System.out.print("Enter first name: ");
                String firstName = v.insertFirstName();
                System.out.print("Enter last name: ");
                String lastName = v.insertLastName();
                System.out.print("Enter year of birth: ");
                int birthDate = v.insertBirthDate(1980, 2004);
                System.out.print("Enter address: ");
                String address = v.insertAddress();
                System.out.print("Enter phone: ");
                String phone = v.insertPhone();
                System.out.print("Enter email: ");
                String email = v.insertEmail();
                System.out.print("Enter years of graduation: ");
                int graYear = v.insertGraYear();
                System.out.print("Enter graduation rank: ");
                String graRank = v.insertGraRank();
                System.out.print("Enter education: ");
                String edu = v.insertEdu();
                Fresher newFresher = new Fresher(searchID, firstName,
                        lastName, birthDate, address, phone, email, graYear, graRank, edu);
                fresherList.set(i, newFresher);
                rw.writeToFresherFile(fresherList);
                System.out.println("Updated.");
            }
        }
    }

    public void updateIntern() {
        System.out.print("Enter id to update: ");
        String searchID = sc.nextLine();
        for (int i = 0; i < internList.size(); i++) {
            if (internList.get(i).getCandidateID().equalsIgnoreCase(searchID)) {
                System.out.println("Enter candidate info: ");
                System.out.print("Enter first name: ");
                String firstName = v.insertFirstName();
                System.out.print("Enter last name: ");
                String lastName = v.insertLastName();
                System.out.print("Enter year of birth: ");
                int birthDate = v.insertBirthDate(1980, 2004);
                System.out.print("Enter address: ");
                String address = v.insertAddress();
                System.out.print("Enter phone: ");
                String phone = v.insertPhone();
                System.out.print("Enter email: ");
                String email = v.insertEmail();
                System.out.print("Enter major: ");
                String major = v.insertMajor();
                System.out.print("Enter semester: ");
                String semeter = v.insertSemester();
                System.out.print("Enter university: ");
                String uniName = v.uniName();
                Intern newIntern = new Intern(searchID, firstName, lastName, birthDate,
                        address, phone, email, major, semeter, uniName);
                internList.set(i, newIntern);
                rw.writeToInternFile(internList);
                System.out.println("Updated.");
            }
        }
    }

    public void updateCandidate() {
        int serachChoice;
        do {
            System.out.println("1. Update an Experienced");
            System.out.println("2. Update a Fresher");
            System.out.println("3. Update an Intern");
            System.out.println("0. Back to main menu.");
            System.out.print("Enter your choice: ");
            serachChoice = v.chooseChoice();
            switch (serachChoice) {
                case 1:
                    updateExp();
                    break;
                case 2:
                    updateFresher();
                    break;
                case 3:
                    updateIntern();
                    break;
                case 0:
                    System.out.println("The main menu: ");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (serachChoice != 0);
    }
    
    
    public void deleteExpByID() {
        System.out.print("Enter id to delete: ");
        String id = sc.nextLine();
        for (int i = 0; i < expList.size(); i++) {
            if (expList.get(i).getCandidateID().equalsIgnoreCase(id)) {
                expList.remove(i);
                rw.writeToExpFile(expList);
                break;
            }
        }
        System.out.println("Deleted");
    }

    public void deleteFresherByID() {
        System.out.print("Enter id to delete: ");
        String id = sc.nextLine();
        for (int i = 0; i < fresherList.size(); i++) {
            if (fresherList.get(i).getCandidateID().equalsIgnoreCase(id)) {
                fresherList.remove(i);
                rw.writeToFresherFile(fresherList);
                break;
            }
        }
        System.out.println("Deleted");
    }
    
    public void deleteInternByID(){
        System.out.print("Enter id to delete: ");
        String id = sc.nextLine();
        for (int i = 0; i < internList.size(); i++) {
            if (internList.get(i).getCandidateID().equalsIgnoreCase(id)) {
                internList.remove(i);
                rw.writeToInternFile(internList);
                break;
            }
        }
        System.out.println("Deleted");
    }
    
    public void deleteCandidateByID() {
    int serachChoice;
        do {
            System.out.println("1. Delete an Experienced");
            System.out.println("2. Delete a Fresher");
            System.out.println("3. Delete an Intern");
            System.out.println("0. Back to main menu.");
            System.out.print("Enter your choice: ");
            serachChoice = v.chooseChoice();
            switch (serachChoice) {
                case 1:
                    deleteExpByID();
                    break;
                case 2:
                    deleteFresherByID();
                    break;
                case 3:
                    deleteInternByID();
                    break;
                case 0:
                    System.out.println("The main menu: ");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (serachChoice != 0);
    }
}
