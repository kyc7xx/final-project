// Package para sa custom components
package sis.components;

// Import necessary classes
import sis.utils.Colors;
import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;

// CustomScrollBar - minimalist na scrollbar design
public class CustomScrollBar extends JScrollBar {
    
    // Constructor - default setup ng scrollbar
    public CustomScrollBar() {
        // Set custom UI para sa scrollbar
        setUI(new ModernScrollBarUI());
        
        // Set preferred size - 8x8 pixels, very thin
        setPreferredSize(new Dimension(8, 8));
        
        // Set background color
        setBackground(Colors.LIGHT_GRAY);
        
        // Set scroll speed - 16 pixels per click
        setUnitIncrement(16);
    }
    
    // Inner class - custom UI para sa modern scrollbar look
    private static class ModernScrollBarUI extends BasicScrollBarUI {
        
        // Override method para sa colors ng scrollbar
        @Override
        protected void configureScrollBarColors() {
            // Thumb color - yung movable part ng scrollbar
            this.thumbColor = Colors.CHARCOAL_LIGHT;
            
            // Shadow color ng thumb
            this.thumbDarkShadowColor = Colors.CHARCOAL_DARK;
            
            // Highlight color ng thumb
            this.thumbHighlightColor = Colors.CAVIAR;
            
            // Track color - yung background ng scrollbar
            this.trackColor = Colors.LIGHT_GRAY;
        }
        
        // Override - remove yung decrease button (top/left arrow)
        @Override
        protected JButton createDecreaseButton(int orientation) {
            return createZeroButton(); // Return invisible button
        }
        
        // Override - remove yung increase button (bottom/right arrow)
        @Override
        protected JButton createIncreaseButton(int orientation) {
            return createZeroButton(); // Return invisible button
        }
        
        // Helper method - create ng invisible button (0 size)
        private JButton createZeroButton() {
            JButton button = new JButton();
            // Set lahat ng dimensions to 0 para maging invisible
            button.setPreferredSize(new Dimension(0, 0));
            button.setMinimumSize(new Dimension(0, 0));
            button.setMaximumSize(new Dimension(0, 0));
            return button;
        }
        
        // Override - custom painting ng thumb (movable part)
        @Override
        protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
            // Create Graphics2D para sa better rendering
            Graphics2D g2 = (Graphics2D) g.create();
            
            // Enable anti-aliasing para smooth yung edges
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            
            // Set color ng thumb
            g2.setColor(thumbColor);
            
            // Draw rounded rectangle para sa thumb
            g2.fillRoundRect(thumbBounds.x, thumbBounds.y, thumbBounds.width, thumbBounds.height, 5, 5);
            
            // Dispose ng graphics object para maglinis ng resources
            g2.dispose();
        }
        
        // Override - custom painting ng track (background)
        @Override
        protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
            // Create Graphics2D object
            Graphics2D g2 = (Graphics2D) g.create();
            
            // Set track color
            g2.setColor(trackColor);
            
            // Fill rectangle para sa track
            g2.fillRect(trackBounds.x, trackBounds.y, trackBounds.width, trackBounds.height);
            
            // Dispose ng graphics object
            g2.dispose();
        }
    }
}
