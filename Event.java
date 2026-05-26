// Event.java
// Represents a single event at Symphony 2026

public class Event {

    // Properties of an event
    private String eventId;
    private String eventName;
    private String eventDate;
    private String venue;
    private int totalSlots;
    private int bookedSlots;

    // Constructor — called when we create a new Event
    public Event(String eventId, String eventName, String eventDate, String venue, int totalSlots) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.venue = venue;
        this.totalSlots = totalSlots;
        this.bookedSlots = 0; // no bookings when event is first created
    }

    // Getters — to read the values
    public String getEventId() { return eventId; }
    public String getEventName() { return eventName; }
    public String getEventDate() { return eventDate; }
    public String getVenue() { return venue; }
    public int getTotalSlots() { return totalSlots; }
    public int getBookedSlots() { return bookedSlots; }

    // Check if slots are available
    public boolean hasAvailableSlots() {
        return bookedSlots < totalSlots;
    }

    // Book one slot
    public void bookSlot() {
        if (hasAvailableSlots()) {
            bookedSlots++;
        }
    }

    // Cancel one slot
    public void cancelSlot() {
        if (bookedSlots > 0) {
            bookedSlots--;
        }
    }

    // Display event details nicely
    public void displayEvent() {
        System.out.println("-----------------------------");
        System.out.println("Event ID   : " + eventId);
        System.out.println("Event Name : " + eventName);
        System.out.println("Date       : " + eventDate);
        System.out.println("Venue      : " + venue);
        System.out.println("Slots Left : " + (totalSlots - bookedSlots) + "/" + totalSlots);
        System.out.println("Status     : " + (hasAvailableSlots() ? "Open" : "FULL"));
        System.out.println("-----------------------------");
    }
}
