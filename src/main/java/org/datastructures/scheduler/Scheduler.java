package org.datastructures.scheduler;

import java.util.ArrayList;
import java.util.List;

public class Scheduler {
    private List<Room> rooms;

    public Scheduler(int numberOfRooms) {
        this.rooms = new ArrayList<>(numberOfRooms);
        for (int i = 0; i < numberOfRooms; i++) {
            this.rooms.add(new Room(i));
        }
    }

    public void scheduleRoom(int start, int end) {
        for (Room room : rooms) {
            room.book(start, end);
        }
    }

    public static void main(String[] args) {
        Scheduler scheduler = new Scheduler(8);
        scheduler.scheduleRoom(9, 11); // Success
        scheduler.scheduleRoom(10, 12); // Might fail if room 9-11 is already taken
        scheduler.scheduleRoom(9, 10);
    }
}
