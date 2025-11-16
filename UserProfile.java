// Package para sa UI
package sis.ui;

// Import necessary classes
import sis.utils.Colors;
import javax.swing.*;
import java.awt.*;

// UserProfile class - user info display sa top bar
public class UserProfile extends JPanel {
    
    // Constructor - initialize user profile
    public UserProfile() {
        // Set FlowLayout - aligned to right, 15px horizontal gap, 10px vertical
        setLayout(new FlowLayout(FlowLayout.RIGHT, 15, 10));
        
        // Set white background
        setBackground(Color.WHITE);
        
        // Set fixed width - 300 pixels, height 60
        setPreferredSize(new Dimension(300, 60));
        
        // Initialize components
        initComponents();
    }
    
    // Method para mag-setup ng components
    private void initComponents() {
        // Create info panel - 2 rows, 1 column
        JPanel infoPanel = new JPanel(new GridLayout(2, 1));
        infoPanel.setOpaque(false);                          // Transparent background
        
        // Name label - bold para emphasized
        JLabel nameLabel = new JLabel("Admin User");
        nameLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
        nameLabel.setForeground(Colors.CAVIAR);        // Caviar
        
        // Role label - plain font, lighter color
        JLabel roleLabel = new JLabel("Administrator");
        roleLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
        roleLabel.setForeground(Colors.CAVIAR);      // Caviar
        
        // Add labels sa info panel
        infoPanel.add(nameLabel);                            // Name sa top
        infoPanel.add(roleLabel);                            // Role sa bottom
        
        // Add info panel sa user profile
        add(infoPanel);
    }
}
