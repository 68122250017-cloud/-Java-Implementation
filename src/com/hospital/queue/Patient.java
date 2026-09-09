package com.hospital.queue;

/**
 * Data Model สำหรับเก็บข้อมูลผู้ป่วย
 */
public class Patient {
    private final String id;
    private final String name;
    private final long arrivalTime;
    private final int severity; // 1: Critical, 2: Urgent, 3: Normal
    private final int serviceTime; // หน่วยนาที

    public Patient(String id, String name, long arrivalTime, int severity, int serviceTime) {
        this.id = id;
        this.name = name;
        this.arrivalTime = arrivalTime;
        this.severity = severity;
        this.serviceTime = serviceTime;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public long getArrivalTime() { return arrivalTime; }
    public int getSeverity() { return severity; }
    public int getServiceTime() { return serviceTime; }

    public String getSeverityLabel() {
        switch (severity) {
            case 1: return "Critical";
            case 2: return "Urgent";
            case 3: return "Normal";
            default: return "Unknown";
        }
    }

    @Override
    public String toString() {
        return String.format("Patient[ID='%s', Name='%s', Severity=%d (%s), ArrivalTime=%d, ServiceTime=%d mins]",
                id, name, severity, getSeverityLabel(), arrivalTime, serviceTime);
    }
}
