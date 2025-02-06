package org.datastructures.cache;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NotificationManagerTest {

    private NotificationManager<String> notificationManager;

    @BeforeEach
    void setUp() {
        notificationManager = NotificationManager.of();
    }

    @Test
    public void test_add_notification() {
        notificationManager.add("Notification1");
        notificationManager.add("Notification2");
        notificationManager.add("Notification3");

        assertEquals("Notification3", notificationManager.get());
        assertEquals(3, notificationManager.size());
    }

    @Test
    public void test_add_notification_duplicate() {
        notificationManager.add("Notification1");
        notificationManager.add("Notification2");
        notificationManager.add("Notification1");

        assertEquals("Notification1", notificationManager.get());
        assertEquals(3, notificationManager.size());
    }

    @Test
    public void test_add_notification_contain() {
        notificationManager.add("Notification1");
        notificationManager.add("Notification2");
        notificationManager.add("Notification1");

        assertTrue(notificationManager.contains("Notification1"));
        assertTrue(notificationManager.contains("Notification2"));
        assertTrue(notificationManager.contains("Notification1"));
    }
}