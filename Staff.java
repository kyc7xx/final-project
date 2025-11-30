package sis.models;

public class Staff {
    private String name;
    private String email;
    private String phone;
    private String department;
    private String status;

    public Staff(String name, String email, String phone, String department, String status) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.department = department;
        this.status = status;
    }

    public String getName() { 
        return name; 
    }

    public String getEmail() { 
        return email; 
    }

    public String getPhone() { 
        return phone; 
    }

    public String getDepartment() { 
        return department; 
    }

    public String getStatus() { 
        return status; 
    }

    public void setName(String name) { 
        this.name = name; 
    }

    public void setEmail(String email) { 
        this.email = email; 
    }

    public void setPhone(String phone) { 
        this.phone = phone; 
    }

    public void setDepartment(String department) { 
        this.department = department; 
    }

    public void setStatus(String status) { 
        this.status = status; 
    }
}