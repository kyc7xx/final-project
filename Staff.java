// Package para sa models
package sis.models;

// Staff model - para sa staff member data
public class Staff {
    // Private fields para sa staff information
    private String name;         // Name ng staff
    private String email;        // Email address
    private String phone;        // Phone number
    private String department;   // Department assignment
    private String status;       // Employment status
    
    // Constructor - initialize staff object with all fields
    // @param name - staff name
    // @param email - email address
    // @param phone - contact number
    // @param department - department name
    // @param status - employment status
    public Staff(String name, String email, String phone, String department, String status) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.department = department;
        this.status = status;
    }
    
    // Getter methods - para makuha yung values
    public String getName() { return name; }               // Get name
    public String getEmail() { return email; }             // Get email
    public String getPhone() { return phone; }             // Get phone
    public String getDepartment() { return department; }   // Get department
    public String getStatus() { return status; }           // Get status
    
    // Setter methods - para mag-update ng values
    public void setName(String name) { this.name = name; }                      // Set name
    public void setEmail(String email) { this.email = email; }                  // Set email
    public void setPhone(String phone) { this.phone = phone; }                  // Set phone
    public void setDepartment(String department) { this.department = department; } // Set department
    public void setStatus(String status) { this.status = status; }              // Set status
}
