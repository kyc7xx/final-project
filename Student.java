// Package para sa models
package sis.models;

// Student model - para sa student data
public class Student {
    // Private fields para sa student information
    private String id;       // Student ID
    private String name;     // Student name
    private String email;    // Email address
    private String phone;    // Phone number
    private String course;   // Course enrolled
    private String status;   // Enrollment status
    
    // Constructor - initialize student object
    // @param id - student ID
    // @param name - student name
    // @param email - email address
    // @param phone - contact number
    // @param course - enrolled course
    // @param status - enrollment status
    public Student(String id, String name, String email, String phone, String course, String status) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.course = course;
        this.status = status;
    }
    
    // Getter methods - para makuha yung values
    public String getId() { return id; }         // Get ID
    public String getName() { return name; }     // Get name
    public String getEmail() { return email; }   // Get email
    public String getPhone() { return phone; }   // Get phone
    public String getCourse() { return course; } // Get course
    public String getStatus() { return status; } // Get status
    
    // Setter methods - para mag-update ng values
    public void setId(String id) { this.id = id; }                // Set ID
    public void setName(String name) { this.name = name; }        // Set name
    public void setEmail(String email) { this.email = email; }    // Set email
    public void setPhone(String phone) { this.phone = phone; }    // Set phone
    public void setCourse(String course) { this.course = course; } // Set course
    public void setStatus(String status) { this.status = status; } // Set status
}
