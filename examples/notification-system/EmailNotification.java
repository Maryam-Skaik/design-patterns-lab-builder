/*
 * EmailNotification.java
 *
 * Represents an Email notification. Uses Builder pattern to construct
 * complex objects with multiple optional fields.
 */

package NotificationSystem;

public class EmailNotification implements Notification {

    // Required fields
    private final String emailTo;
    private final String subject;
    private final String body;

    // Optional field
    private final int priority;

    /**
     * Private constructor called by Builder
     */
    private EmailNotification(Builder builder) {
        this.emailTo = builder.emailTo;
        this.subject = builder.subject;
        this.body = builder.body;
        this.priority = builder.priority;
    }

    // =======================
    // Getters (Immutable object)
    // =======================
    public String getEmailTo() { return emailTo; }
    public String getSubject() { return subject; }
    public String getBody() { return body; }
    public int getPriority() { return priority; }

    @Override
    public void send() {
        System.out.println("Sending Email to " + emailTo + " with subject: " + subject);
    }

    // =======================
    // Builder class for EmailNotification
    // =======================
    public static class Builder {
        private String emailTo;  // required
        private String subject;  // required
        private String body;     // required
        private int priority = 0; // optional, default = 0

        // Setter methods return Builder for chaining
        public Builder setTo(String emailTo) { this.emailTo = emailTo; return this; }
        public Builder setSubject(String subject) { this.subject = subject; return this; }
        public Builder setBody(String body) { this.body = body; return this; }
        public Builder setPriority(int priority) { this.priority = priority; return this; }

        // Build method validates required fields
        public EmailNotification build() {
            if(emailTo == null || subject == null || body == null) {
                throw new IllegalStateException("Missing required fields for EmailNotification");
            }
            return new EmailNotification(this);
        }
    }
}
