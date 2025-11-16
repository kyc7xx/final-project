// Package para sa custom components
package sis.components;

// Import necessary classes
import javax.swing.*;
import java.awt.*;

// RoundPanel - panel with rounded corners for modern UI
public class RoundPanel extends JPanel {
    // Variable para sa corner radius
    private int cornerRadius = 15;
    
    // Default constructor
    public RoundPanel() {
        super();
        // Set to false para ma-paint yung custom background
        setOpaque(false);
    }
    
    // Constructor with layout manager
    public RoundPanel(LayoutManager layout) {
        super(layout);
        setOpaque(false);
    }
    
    // Constructor with custom radius
    public RoundPanel(int radius) {
        super();
        // Set custom corner radius
        this.cornerRadius = radius;
        setOpaque(false);
    }
    
    // Override paintComponent - custom painting ng rounded panel
    @Override
    protected void paintComponent(Graphics g) {
        // Call parent method
        super.paintComponent(g);
        
        // Create Graphics2D para sa better rendering
        Graphics2D g2 = (Graphics2D) g.create();
        
        // Enable anti-aliasing para smooth yung rounded corners
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        // Set color ng background
        g2.setColor(getBackground());
        
        // Draw rounded rectangle with specified corner radius
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), cornerRadius, cornerRadius);
        
        // Dispose ng graphics object
        g2.dispose();
    }
}
