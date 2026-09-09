package com.hospital.queue;

public class Main {
    public static void main(String[] args) {
        HospitalQueueSystem system = new HospitalQueueSystem();
        System.out.println("==================================================");
        System.out.println("  Hospital Queue Management System Initialized");
        System.out.println("==================================================");

        long currentTime = System.currentTimeMillis();

        System.out.println("\n>>> Testing ARRIVE Commands...");
        system.arrive(new Patient("P101", "Somchai", currentTime, 3, 15), true);       // Normal
        system.arrive(new Patient("P102", "Somsri", currentTime + 10, 1, 30), true);   // Critical
        system.arrive(new Patient("P103", "Anan", currentTime + 20, 2, 20), true);     // Urgent
        system.arrive(new Patient("P104", "Boonmee", currentTime + 30, 1, 10), true);  // Critical

        System.out.println("\n>>> Testing QUEUE_SIZE Command...");
        system.getQueueSize(true);

        System.out.println("\n>>> Testing DISPLAY Command...");
        system.display(true);

        System.out.println("\n>>> Testing PEEK Command...");
        system.peek(true);

        System.out.println("\n>>> Testing SERVE Commands...");
        system.serve(true); // P102
        system.serve(true); // P104
        system.serve(true); // P103

        System.out.println("\n>>> Checking Queue Status after Serving...");
        system.getQueueSize(true);
        system.display(true);
    }
}
