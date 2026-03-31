/*
 * Main.java
 *
 * Demonstrates how to combine Factory + Builder patterns to create
 * different notification types in a clean, readable, and maintainable way.
 * Shows method chaining for optional fields.
 */

package NotificationSystem;

public class Main {

    public static void main(String[] args) {

        // =======================
        // Email Notification
        // =======================
        EmailNotification email = ((EmailNotification.Builder)
            NotificationFactory.getBuilder("EMAIL"))
                .setTo("student@example.com")  // required
                .setSubject("Welcome")         // required
                .setBody("Hello student!")     // required
                .setPriority(5)                // optional
                .build();                      // finalize

        email.send(); // Demonstrates sending

        // =======================
        // SMS Notification
        // =======================
        SMSNotification sms = ((SMSNotification.Builder)
            NotificationFactory.getBuilder("SMS"))
                .setTo("+1234567890")          // required
                .setMessage("Your code is 1234") // required
                .build();                       // finalize

        sms.send(); // Demonstrates sending
    }
}
