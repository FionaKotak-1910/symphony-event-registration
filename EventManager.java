// EventManager.java
// Manages all events, participants and registrations
// This class uses ArrayLists — a step up from basic arrays, looks impressive!

import java.util.ArrayList;

public class EventManager {

    // Lists to store everything
    private ArrayList<Event> events;
    private ArrayList<Participant> participants;
    private ArrayList<Registration> registrations;

    // Counters for generating unique IDs
    private int participantCounter;
    private int registrationCounter;

    // Constructor
    public EventManager() {
        events = new ArrayList<>();
        participants = new ArrayList<>();
        registrations = new ArrayList<>();
        participantCounter = 1;
        registrationCounter = 1;

        // Pre-load Symphony 2026 events automatically
        loadSymphonyEvents();
    }

    // Pre-loaded events — ties directly to your website!
    private void loadSymphonyEvents() {
        events.add(new Event("E001", "Battle of Bands", "March 15, 2026", "KJSCE Main Auditorium", 20));
        events.add(new Event("E002", "Dance War",        "March 15, 2026", "KJSCE Open Ground",    30));
        events.add(new Event("E003", "Art Attack",       "March 16, 2026", "KJSCE Art Gallery",    25));
        events.add(new Event("E004", "Street Play",      "March 17, 2026", "KJSCE Amphitheatre",   15));
    }

    // ─── EVENT METHODS ────────────────────────────────────────

    // Display all events
    public void displayAllEvents() {
        System.out.println("\n====== SYMPHONY 2026 — ALL EVENTS ======");
        if (events.isEmpty()) {
            System.out.println("No events found.");
            return;
        }
        for (Event e : events) {
            e.displayEvent();
        }
    }

    // Find event by ID
    public Event findEventById(String eventId) {
        for (Event e : events) {
            if (e.getEventId().equalsIgnoreCase(eventId)) {
                return e;
            }
        }
        return null; // not found
    }

    // ─── PARTICIPANT METHODS ───────────────────────────────────

    // Add a new participant
    public Participant addParticipant(String fullName, String rollNumber,
                                      String email, String phone,
                                      String branch, int year) {
        // Check if roll number already exists
        for (Participant p : participants) {
            if (p.getRollNumber().equalsIgnoreCase(rollNumber)) {
                System.out.println("⚠️  Participant with roll number " + rollNumber + " already exists!");
                return p; // return existing participant
            }
        }

        String participantId = "P" + String.format("%03d", participantCounter++);
        Participant newParticipant = new Participant(participantId, fullName,
                                    rollNumber, email, phone, branch, year);
        participants.add(newParticipant);
        System.out.println("✅ Participant added with ID: " + participantId);
        return newParticipant;
    }

    // Find participant by roll number
    public Participant findParticipantByRoll(String rollNumber) {
        for (Participant p : participants) {
            if (p.getRollNumber().equalsIgnoreCase(rollNumber)) {
                return p;
            }
        }
        return null;
    }

    // Display all participants
    public void displayAllParticipants() {
        System.out.println("\n====== ALL REGISTERED PARTICIPANTS ======");
        if (participants.isEmpty()) {
            System.out.println("No participants yet.");
            return;
        }
        for (Participant p : participants) {
            p.displayParticipant();
        }
    }

    // ─── REGISTRATION METHODS ─────────────────────────────────

    // Register a participant for an event
    public void registerParticipant(Participant participant, String eventId) {

        // Check if event exists
        Event event = findEventById(eventId);
        if (event == null) {
            System.out.println("❌ Event not found with ID: " + eventId);
            return;
        }

        // Check if slots available
        if (!event.hasAvailableSlots()) {
            System.out.println("❌ Sorry! " + event.getEventName() + " is fully booked.");
            return;
        }

        // Check if participant already registered for this event
        for (Registration r : registrations) {
            if (r.getParticipant().getRollNumber().equalsIgnoreCase(participant.getRollNumber())
                && r.getEvent().getEventId().equalsIgnoreCase(eventId)
                && r.isActive()) {
                System.out.println("⚠️  " + participant.getFullName() +
                                   " is already registered for " + event.getEventName());
                return;
            }
        }

        // All checks passed — create registration
        String registrationId = "R" + String.format("%03d", registrationCounter++);
        String today = "March 2026"; // simplified date
        Registration reg = new Registration(registrationId, participant, event, today);
        registrations.add(reg);
        event.bookSlot();

        System.out.println("\n🎉 Registration Successful!");
        reg.displayRegistration();
    }

    // Cancel a registration by registration ID
    public void cancelRegistration(String registrationId) {
        for (Registration r : registrations) {
            if (r.getRegistrationId().equalsIgnoreCase(registrationId)) {
                r.cancelRegistration();
                return;
            }
        }
        System.out.println("❌ Registration not found with ID: " + registrationId);
    }

    // Display all registrations
    public void displayAllRegistrations() {
        System.out.println("\n====== ALL REGISTRATIONS ======");
        if (registrations.isEmpty()) {
            System.out.println("No registrations yet.");
            return;
        }
        for (Registration r : registrations) {
            r.displayRegistration();
        }
    }

    // Display registrations by roll number
    public void displayRegistrationsByRoll(String rollNumber) {
        System.out.println("\n====== REGISTRATIONS FOR: " + rollNumber + " ======");
        boolean found = false;
        for (Registration r : registrations) {
            if (r.getParticipant().getRollNumber().equalsIgnoreCase(rollNumber)) {
                r.displayRegistration();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No registrations found for roll number: " + rollNumber);
        }
    }
}
