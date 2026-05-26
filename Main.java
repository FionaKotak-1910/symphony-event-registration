// Main.java
// Runs the entire Event Registration System
// This is the menu system the user interacts with

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        EventManager manager = new EventManager();

        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║   SYMPHONY 2026 — KJSCE              ║");
        System.out.println("║   Event Registration System          ║");
        System.out.println("╚══════════════════════════════════════╝");

        boolean running = true;

        while (running) {
            System.out.println("\n======= MAIN MENU =======");
            System.out.println("1. View All Events");
            System.out.println("2. Register for an Event");
            System.out.println("3. View My Registrations");
            System.out.println("4. Cancel a Registration");
            System.out.println("5. View All Participants");
            System.out.println("6. View All Registrations");
            System.out.println("7. Exit");
            System.out.print("\nEnter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            switch (choice) {

                case 1:
                    // View all events
                    manager.displayAllEvents();
                    break;

                case 2:
                    // Register for an event
                    System.out.println("\n====== NEW REGISTRATION ======");

                    System.out.print("Enter your Full Name       : ");
                    String name = scanner.nextLine();

                    System.out.print("Enter your Roll Number     : ");
                    String roll = scanner.nextLine();

                    System.out.print("Enter your Email           : ");
                    String email = scanner.nextLine();

                    System.out.print("Enter your Phone Number    : ");
                    String phone = scanner.nextLine();

                    System.out.print("Enter your Branch          : ");
                    String branch = scanner.nextLine();

                    System.out.print("Enter your Year (1/2/3/4)  : ");
                    int year = scanner.nextInt();
                    scanner.nextLine();

                    // Add participant (handles duplicates automatically)
                    Participant p = manager.addParticipant(name, roll, email, phone, branch, year);

                    // Show events and ask which one
                    manager.displayAllEvents();
                    System.out.print("Enter Event ID to register (e.g. E001): ");
                    String eventId = scanner.nextLine();

                    manager.registerParticipant(p, eventId);
                    break;

                case 3:
                    // View my registrations
                    System.out.print("\nEnter your Roll Number: ");
                    String myRoll = scanner.nextLine();
                    manager.displayRegistrationsByRoll(myRoll);
                    break;

                case 4:
                    // Cancel a registration
                    System.out.print("\nEnter Registration ID to cancel (e.g. R001): ");
                    String regId = scanner.nextLine();
                    manager.cancelRegistration(regId);
                    break;

                case 5:
                    // View all participants
                    manager.displayAllParticipants();
                    break;

                case 6:
                    // View all registrations
                    manager.displayAllRegistrations();
                    break;

                case 7:
                    // Exit
                    System.out.println("\nThank you! See you at Symphony 2026 🎶");
                    System.out.println("— KJSCE Student Council PR Team");
                    running = false;
                    break;

                default:
                    System.out.println("❌ Invalid choice. Please enter 1–7.");
            }
        }

        scanner.close();
    }
}
