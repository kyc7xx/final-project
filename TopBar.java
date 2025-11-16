// Package para sa UI components
package sis.ui;

// Import necessary classes
import sis.utils.Colors;
import javax.swing.*;
import java.awt.*;

// TopBar class - top navigation bar ng application
public class TopBar extends JPanel {
    // Private field para sa title label
    private JLabel titleLabel;
    
    // Constructor - initialize top bar
    public TopBar() {
        // Set layout to BorderLayout
        setLayout(new BorderLayout());
        
        // Set white background
        setBackground(Color.WHITE);
        
        // Set fixed height - 60 pixels, width flexible
        setPreferredSize(new Dimension(0, 60));
        
        // Add bottom border - 1px gray line
        setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Colors.BORDER_NEUTRAL));
        
        // Initialize components
        initComponents();
    }
    
    // Method para mag-setup ng components
    private void initComponents() {
        // Create title label with default text
        titleLabel = new JLabel("Dashboard");
        titleLabel.setFont(new Font("Tahoma", Font.BOLD, 16));        // Bold, size 16
        titleLabel.setForeground(Colors.CAVIAR);                 // Caviar
        titleLabel.setBorder(BorderFactory.createEmptyBorder(0, 30, 0, 0)); // Left padding
        
        // Create user profile component
        UserProfile userProfile = new UserProfile();
        
        // Add components sa top bar
        add(titleLabel, BorderLayout.WEST);                            // Title sa left
        add(userProfile, BorderLayout.EAST);                           // Profile sa right
    }
    
    // Method para mag-update ng title
    // @param title - new title na idisplay
    public void setTitle(String title) {
        titleLabel.setText(title);    // Update title text
    }
}
