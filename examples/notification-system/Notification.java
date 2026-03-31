/*
 * Notification.java
 *
 * Interface representing a generic notification.
 * All notification types (Email, SMS) must implement this interface.
 */

package NotificationSystem;

public interface Notification {
    void send(); // method to send the notification
}
