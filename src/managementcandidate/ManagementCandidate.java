package managementcandidate;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;
import java.util.Scanner;

public class ManagementCandidate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CandidateList list = new CandidateList();
        List<Candidate> canList = list.showCandidateList();
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

            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    int searchChoice;
                    do {
                        System.out.println("1. Search by name");
                        System.out.println("2. Search by id");
                        System.out.println("0. Exit");
                        System.out.print("Enter your choice: ");
                        searchChoice = Integer.parseInt(sc.nextLine());
                        switch (searchChoice) {
                            case 1:
                                System.out.print("Enter name to find: ");
                                String name = sc.nextLine();
                                Candidate foundName = list.searchByName(name);
                                if (foundName != null) {
                                    System.out.println(foundName);
                                } else {
                                    System.out.println("Not found");
                                }

                                break;

                            case 2:
                                System.out.print("Enter id to find: ");

                                String id = sc.nextLine();
                                Candidate foundID = list.searchById(id);
                                if (foundID != null) {
                                    System.out.println(foundID);
                                } else {
                                    System.out.println("Not found");
                                }

                                break;
                            case 0:
                                System.out.println("Exit.");
                                break;
                            default:
                                System.out.println("Invalid choice!");
                        }
                    } while (searchChoice != 0);
                    break;
                case 2:
                    System.out.println("Enter candidate info: ");
                    try {
                        FileWriter fw = new FileWriter("Candidate info.txt", true);
                        BufferedWriter bw = new BufferedWriter(fw);
                        System.out.print("Enter id: ");
                        String id = sc.nextLine();
                        System.out.print("Enter first name: ");
                        String firstName = sc.nextLine();
                        System.out.print("Enter last name: ");
                        String lastName = sc.nextLine();
                        System.out.print("Enter year of birth: ");
                        int birthDate = Integer.parseInt(sc.nextLine());
                        System.out.print("Enter address: ");
                        String address = sc.nextLine();
                        System.out.print("Enter phone: ");
                        int phone = Integer.parseInt(sc.nextLine());
                        System.out.print("Enter email: ");
                        String email = sc.nextLine();
                        Candidate newCan = new Candidate(id, firstName,
                                lastName, birthDate, address, phone, email);
                        bw.write(newCan.toString());
                        bw.newLine();
                        bw.close();
                        fw.close();
//                        list.insert(newCan);
                        System.out.println("Inserted.");
                    } catch (Exception e) {
                        System.out.println("Enter again please.");
                    }
                    break;
                case 3:
                    System.out.println("Enter id to delete: ");
                    String id = sc.nextLine();
                    list.deleteByID(id);
                    System.out.println("Deleted");
                    break;
                case 5:
                    System.out.println("Candidate list: ");
//                    list.showCandidateList();
                    for (Candidate candidate : canList) {
                        System.out.println(candidate);
                    }
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
