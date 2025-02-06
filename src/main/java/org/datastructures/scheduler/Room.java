package org.datastructures.scheduler;

import lombok.Getter;

import java.util.Map;
import java.util.TreeMap;

public class Room {
    @Getter
    private final int id;
    private TreeMap<Integer, Integer> schedule;

    public Room(int id) {
        this.id = id;
        this.schedule = new TreeMap<>();
    }

    public boolean book(int start, int end){
//        Map.Entry<Integer, Integer> startEntry = schedule.ceilingEntry(start);
//        Map.Entry<Integer, Integer> endEntry = schedule.floorEntry(end);
//
//        if (startEntry != null && endEntry != null) {
//            if (startEntry.getValue() < start || endEntry.getValue() > end) {
//                System.out.println("Room " + getId() + " Is currently booked from " + start + " to " + end);
//                return false;
//            }
//        }
//        System.out.println("Room " + getId() + " Successfully booked for " + start + " to " + end);
//        schedule.put(start, end);

        Map.Entry<Integer, Integer> floorEntry = schedule.floorEntry(start);
        Map.Entry<Integer, Integer> ceilingEntry = schedule.ceilingEntry(start);

        System.out.println(floorEntry + " " + ceilingEntry);

        // Check if the requested time overlaps with existing bookings
        if ((floorEntry != null && floorEntry.getValue() > start) ||
                (ceilingEntry != null && ceilingEntry.getKey() < end)) {
            System.out.println("Room " + getId() + " Is currently booked from " + start + " to " + end);
            return false;
        }

        schedule.put(start, end);
        System.out.println("Room " + getId() + " Successfully booked for " + start + " to " + end);
        return true;
    }

}
