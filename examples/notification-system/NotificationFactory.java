/*
 * NotificationFactory.java
 *
 * Factory Pattern implementation to centralize the creation of Notification Builders.
 * Returns the Builder for Email or SMS notifications.
 *
 * This separates the client code from the concrete implementation classes.
 */

package NotificationSystem;

public class NotificationFactory {

    /**
     * Returns a Builder object for the requested notification type.
     * 
     * @param type "EMAIL" or "SMS"
     * @return Builder object
     */
    public static Object getBuilder(String type) {
        switch(type) {
            case "EMAIL": return new EmailNotification.Builder();
            case "SMS": return new SMSNotification.Builder();
            default: throw new IllegalArgumentException("Unknown notification type: " + type);
        }
    }
}
