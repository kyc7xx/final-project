// Package para sa UI components
package sis.ui;

// Import necessary classes
import sis.components.CustomScrollBar;
import sis.utils.Colors;
import javax.swing.*;
import java.awt.*;

// Dashboard class - main content area ng application
public class Dashboard extends JPanel {
    // Private fields para sa components
    private JPanel contentPanel;     // Panel na mag-hold ng forms
    private CardLayout cardLayout;   // Layout para sa form switching
    
    // Constructor - initialize dashboard
    public Dashboard() {
        // Set layout to BorderLayout
        setLayout(new BorderLayout());
        
        // Set background color
        setBackground(Colors.VAPOROUS_GRAY);
        
        // Initialize components
        initComponents();
    }
    
    // Method para mag-setup ng components
    private void initComponents() {
        // Initialize CardLayout para sa form switching
        cardLayout = new CardLayout();
        
        // Create content panel with CardLayout
        contentPanel = new JPanel(cardLayout);
        contentPanel.setBackground(Colors.VAPOROUS_GRAY);     // Set background
        
        // Create scroll pane para sa content
        JScrollPane scrollPane = new JScrollPane(contentPanel);
        scrollPane.setBorder(null);                     // Remove border
        scrollPane.setVerticalScrollBar(new CustomScrollBar()); // Custom scrollbar
        scrollPane.getVerticalScrollBar().setUnitIncrement(16); // Set scroll speed
        
        // Add scroll pane sa dashboard
        add(scrollPane, BorderLayout.CENTER);
    }
    
    // Method para mag-add ng form sa dashboard
    // @param name - unique name ng form para sa switching
    // @param form - yung JPanel na form
    public void addForm(String name, JPanel form) {
        contentPanel.add(form, name);   // Add form with name identifier
    }
    
    // Method para i-show yung specific form
    // @param name - name ng form na ipa-display
    public void showForm(String name) {
        cardLayout.show(contentPanel, name);  // Switch to specified form
    }
}
