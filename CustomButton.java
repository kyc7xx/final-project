// Package para sa custom components
package sis.components;

// Import necessary classes
import sis.utils.Colors;
import javax.swing.*;
import java.awt.*;

// CustomButton - custom na button component with minimalist design
public class CustomButton extends JButton {
    
    // Constructor - tatanggapin yung text na ilalagay sa button
    public CustomButton(String text) {
        // Call ng parent constructor with text
        super(text);
        
        // Set font ng button - Tahoma, plain style, size 14
        setFont(new Font("Tahoma", Font.PLAIN, 14));
        
        // Set text color to white
        setForeground(Color.WHITE);
        
        // Set background color using PRIMARY color
        setBackground(Colors.CHARCOAL);
        
        // Remove yung focus rectangle pag naka-focus yung button
        setFocusPainted(false);
        
        // Remove yung border ng button
        setBorderPainted(false);
        
        // Change cursor to hand cursor pag nag-hover
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        // Set to true para makita yung background color
        setContentAreaFilled(true);
        
        // Set to true para ma-render yung background
        setOpaque(true);
    }
    
    // Method para mag-set ng custom color sa button
    // @param color - yung bagong color na gagamitin
    public void setButtonColor(Color color) {
        // Set ng background color
        setBackground(color);
    }
}
