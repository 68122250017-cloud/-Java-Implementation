package com.hospital.queue;

import java.util.Comparator;

/**
 * Custom Comparator สำหรับเปรียบเทียบความสำคัญของผู้ป่วย (Priority Queue)
 * 1. เปรียบเทียบ Severity (1=Critical, 2=Urgent, 3=Normal) -> ค่าน้อยได้สิทธิ์ก่อน
 * 2. หาก Severity เท่ากัน ให้เปรียบเทียบ Arrival Time (FIFO) -> มาก่อนได้สิทธิ์ก่อน
 */
public class PatientPriorityComparator implements Comparator<Patient> {
    @Override
    public int compare(Patient p1, Patient p2) {
        int severityCompare = Integer.compare(p1.getSeverity(), p2.getSeverity());
        if (severityCompare != 0) {
            return severityCompare;
        }
        return Long.compare(p1.getArrivalTime(), p2.getArrivalTime());
    }
}
