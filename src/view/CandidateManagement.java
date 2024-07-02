package view;

import java.util.Scanner;
import control.CandidateList;
import ultils.Validation;

public class CandidateManagement {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CandidateList list = new CandidateList();
        Validation v = new Validation();
        int choice;
        do {
            System.out.println("\nCandidate Management System");
            System.out.println("1. Find Candidate");
            System.out.println("2. Insert Candidate");
            System.out.println("3. Delete Candidate");
            System.out.println("4. Update Candidate");
            System.out.println("5. Show Candidate List");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            choice = v.chooseChoice();

            switch (choice) {
                case 1:
                    list.searchCandidate();
                    break;
                case 2:
                    list.insertCandidate();
                    break;
                case 3:
                    list.deleteCandidateByID();
                    break;
                case 4:
                    list.updateCandidate();
                    break;
                case 5:
                    list.showCandidateList();
                    break;
                case 0:
                    System.out.println("Exit.");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 0);
    }
}
