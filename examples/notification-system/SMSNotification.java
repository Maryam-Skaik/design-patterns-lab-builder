/*
 * SMSNotification.java
 *
 * Represents an SMS notification. Uses Builder pattern for step-by-step
 * construction of complex objects.
 */

package NotificationSystem;

public class SMSNotification implements Notification {

    // Required fields
    private final String phoneNumber;
    private final String message;

    // Optional field
    private final boolean flashSMS;

    /**
     * Private constructor called by Builder
     */
    private SMSNotification(Builder builder) {
        this.phoneNumber = builder.phoneNumber;
        this.message = builder.message;
        this.flashSMS = builder.flashSMS;
    }

    // =======================
    // Getters
    // =======================
    public String getPhoneNumber() { return phoneNumber; }
    public String getMessage() { return message; }
    public boolean isFlashSMS() { return flashSMS; }

    @Override
    public void send() {
        System.out.println("Sending SMS to " + phoneNumber + ": " + message);
    }

    // =======================
    // Builder class for SMSNotification
    // =======================
    public static class Builder {
        private String phoneNumber; // required
        private String message;     // required
        private boolean flashSMS = false; // optional, default false

        // Setters return Builder for chaining
        public Builder setTo(String phoneNumber) { this.phoneNumber = phoneNumber; return this; }
        public Builder setMessage(String message) { this.message = message; return this; }
        public Builder setFlashSMS(boolean flashSMS) { this.flashSMS = flashSMS; return this; }

        // Build method validates required fields
        public SMSNotification build() {
            if(phoneNumber == null || message == null) {
                throw new IllegalStateException("Missing required fields for SMSNotification");
            }
            return new SMSNotification(this);
        }
    }
}
