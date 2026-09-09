package com.hospital.queue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * ระบบจัดการคิวโรงพยาบาล (Hospital Queue System)
 */
public class HospitalQueueSystem {

    // Queue A: FIFO Queue (ปกติ)
    private final Queue<Patient> normalQueue = new ArrayDeque<>();

    // Queue B: Priority Queue (ตามระดับความรุนแรงและเวลาที่มาถึง)
    private final PriorityQueue<Patient> priorityQueue = new PriorityQueue<>(new PatientPriorityComparator());

    /**
     * คำสั่ง ARRIVE: เพิ่มผู้ป่วยเข้าสู่คิว
     */
    public void arrive(Patient patient, boolean isPriority) {
        if (isPriority) {
            priorityQueue.offer(patient);
            System.out.printf("[ARRIVE] Added to Priority Queue: %s%n", patient);
        } else {
            normalQueue.offer(patient);
            System.out.printf("[ARRIVE] Added to Normal Queue: %s%n", patient);
        }
    }

    /**
     * คำสั่ง SERVE: เรียกผู้ป่วยเข้ารับการรักษาและนำออกจากคิว
     */
    public Patient serve(boolean isPriority) {
        Patient patient = isPriority ? priorityQueue.poll() : normalQueue.poll();
        String queueType = isPriority ? "Priority Queue" : "Normal Queue";

        if (patient != null) {
            System.out.printf("[SERVE] Serving from %s -> %s%n", queueType, patient);
        } else {
            System.out.printf("[SERVE] %s is currently empty! No patient to serve.%n", queueType);
        }
        return patient;
    }

    /**
     * คำสั่ง PEEK: แอบดูผู้ป่วยคนถัดไปที่จะถูกเรียกโดยไม่นำออกจากคิว
     */
    public Patient peek(boolean isPriority) {
        Patient patient = isPriority ? priorityQueue.peek() : normalQueue.peek();
        String queueType = isPriority ? "Priority Queue" : "Normal Queue";

        if (patient != null) {
            System.out.printf("[PEEK] Next in %s -> %s%n", queueType, patient);
        } else {
            System.out.printf("[PEEK] %s is empty.%n", queueType);
        }
        return patient;
    }

    /**
     * คำสั่ง DISPLAY: แสดงผู้ป่วยทั้งหมดที่มีอยู่ในคิวปัจจุบัน
     */
    public void display(boolean isPriority) {
        if (isPriority) {
            System.out.println("\n--- Priority Queue Contents (Sorted by Priority) ---");
            if (priorityQueue.isEmpty()) {
                System.out.println(" (Queue is empty)");
            } else {
                List<Patient> list = new ArrayList<>(priorityQueue);
                list.sort(new PatientPriorityComparator());
                int rank = 1;
                for (Patient p : list) {
                    System.out.printf(" %d. %s%n", rank++, p);
                }
            }
        } else {
            System.out.println("\n--- Normal Queue Contents (FIFO) ---");
            if (normalQueue.isEmpty()) {
                System.out.println(" (Queue is empty)");
            } else {
                int rank = 1;
                for (Patient p : normalQueue) {
                    System.out.printf(" %d. %s%n", rank++, p);
                }
            }
        }
        System.out.println("---------------------------------------------------");
    }

    /**
     * คำสั่ง QUEUE_SIZE: ตรวจสอบจำนวนคิวคงเหลือ
     */
    public int getQueueSize(boolean isPriority) {
        int size = isPriority ? priorityQueue.size() : normalQueue.size();
        String queueType = isPriority ? "Priority Queue" : "Normal Queue";
        System.out.printf("[QUEUE_SIZE] Current size of %s: %d%n", queueType, size);
        return size;
    }
}
