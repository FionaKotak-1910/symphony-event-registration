// Participant.java
// Represents a student registering for an event

public class Participant {

    // Properties of a participant
    private String participantId;
    private String fullName;
    private String rollNumber;
    private String email;
    private String phone;
    private String branch;
    private int year;

    // Constructor
    public Participant(String participantId, String fullName, String rollNumber,
                       String email, String phone, String branch, int year) {
        this.participantId = participantId;
        this.fullName = fullName;
        this.rollNumber = rollNumber;
        this.email = email;
        this.phone = phone;
        this.branch = branch;
        this.year = year;
    }

    // Getters
    public String getParticipantId() { return participantId; }
    public String getFullName() { return fullName; }
    public String getRollNumber() { return rollNumber; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public String getBranch() { return branch; }
    public int getYear() { return year; }

    // Display participant details nicely
    public void displayParticipant() {
        System.out.println("-----------------------------");
        System.out.println("Participant ID : " + participantId);
        System.out.println("Name           : " + fullName);
        System.out.println("Roll Number    : " + rollNumber);
        System.out.println("Email          : " + email);
        System.out.println("Phone          : " + phone);
        System.out.println("Branch         : " + branch);
        System.out.println("Year           : " + year);
        System.out.println("-----------------------------");
    }
}
