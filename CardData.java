// Package para sa model classes
package sis.models;

// Import Color class
import java.awt.Color;

// CardData model - para sa info card data
public class CardData {
    // Private fields para sa card information
    private String title;   // Title ng card
    private String value;   // Value/number na idisplay
    private Color color;    // Color ng value text
    
    // Constructor - para gumawa ng CardData object
    // @param title - title ng card
    // @param value - value na idisplay
    // @param color - color ng value
    // @param icon - icon (hindi na ginagamit pero nandito pa for compatibility)
    public CardData(String title, String value, Color color, String icon) {
        this.title = title;
        this.value = value;
        this.color = color;
    }
    
    // Getter methods - para makuha yung values
    public String getTitle() { return title; }    // Return title
    public String getValue() { return value; }    // Return value
    public Color getColor() { return color; }     // Return color
    
    // Setter methods - para mag-update ng values
    public void setTitle(String title) { this.title = title; }    // Set new title
    public void setValue(String value) { this.value = value; }    // Set new value
    public void setColor(Color color) { this.color = color; }     // Set new color
}
