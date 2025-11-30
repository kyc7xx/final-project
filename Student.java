package sis.models;

public class Student {
    private String id;
    private String name;
    private String email;
    private String phone;
    private String course;
    private String status;

    public Student(String id, String name, String email, String phone, String course, String status) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.course = course;
        this.status = status;
    }

    public String getId() { 
        return id; 
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

    public String getCourse() { 
        return course; 
    }

    public String getStatus() { 
        return status; 
    }

    public void setId(String id) { 
        this.id = id; 
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

    public void setCourse(String course) { 
        this.course = course; 
    }

    public void setStatus(String status) { 
        this.status = status; 
    }
}