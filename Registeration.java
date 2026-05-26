// Registration.java
// Links a Participant to an Event — this is the core OOP concept (association)

public class Registration {

    // Properties
    private String registrationId;
    private Participant participant;  // uses Participant class
    private Event event;              // uses Event class
    private String registrationDate;
    private boolean isActive;

    // Constructor
    public Registration(String registrationId, Participant participant,
                        Event event, String registrationDate) {
        this.registrationId = registrationId;
        this.participant = participant;
        this.event = event;
        this.registrationDate = registrationDate;
        this.isActive = true; // active by default when created
    }

    // Getters
    public String getRegistrationId() { return registrationId; }
    public Participant getParticipant() { return participant; }
    public Event getEvent() { return event; }
    public String getRegistrationDate() { return registrationDate; }
    public boolean isActive() { return isActive; }

    // Cancel this registration
    public void cancelRegistration() {
        if (isActive) {
            isActive = false;
            event.cancelSlot(); // free up the slot in the event
            System.out.println("Registration " + registrationId + " cancelled successfully.");
        } else {
            System.out.println("This registration is already cancelled.");
        }
    }

    // Display registration details nicely
    public void displayRegistration() {
        System.out.println("=============================");
        System.out.println("Registration ID : " + registrationId);
        System.out.println("Participant     : " + participant.getFullName());
        System.out.println("Roll Number     : " + participant.getRollNumber());
        System.out.println("Event           : " + event.getEventName());
        System.out.println("Event Date      : " + event.getEventDate());
        System.out.println("Venue           : " + event.getVenue());
        System.out.println("Registered On   : " + registrationDate);
        System.out.println("Status          : " + (isActive ? "✅ Active" : "❌ Cancelled"));
        System.out.println("=============================");
    }
}
