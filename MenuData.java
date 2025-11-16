// Package para sa models
package sis.models;

// MenuData model - para sa menu item data
public class MenuData {
    // Private field para sa menu name
    private String name;    // Name ng menu item
    
    // Constructor - initialize menu data
    // @param name - name ng menu
    public MenuData(String name) {
        this.name = name;
    }
    
    // Getter method - para makuha yung name
    public String getName() { return name; }
    
    // Setter method - para mag-update ng name
    public void setName(String name) { this.name = name; }
}
