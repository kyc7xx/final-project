// Package para sa forms
package sis.forms;

// Import necessary classes
import sis.components.RoundPanel;
import sis.utils.Colors;
import javax.swing.*;
import java.awt.*;

// ReportForm class - form para sa reports at statistics
public class ReportForm extends JPanel {
    
    // Constructor - initialize report form
    public ReportForm() {
        // Set layout to BorderLayout
        setLayout(new BorderLayout());
        
        // Set background color
        setBackground(Colors.VAPOROUS_GRAY);
        
        // Set padding - 30px sa lahat ng sides
        setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        
        // Initialize components
        initComponents();
    }
    
    // Method para mag-setup ng components
    private void initComponents() {
        // Main panel with vertical box layout
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setOpaque(false);
        
        // Create statistics panel
        RoundPanel statsPanel = createStatsPanel();
        
        // Set maximum size - full width, 350px height
        statsPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 350));
        
        // Add stats panel sa main panel
        mainPanel.add(statsPanel);
        
        // Add main panel sa form
        add(mainPanel, BorderLayout.NORTH);
    }
    
    // Method para gumawa ng statistics panel
    private RoundPanel createStatsPanel() {
        // Create rounded panel
        RoundPanel panel = new RoundPanel();
        panel.setBackground(Color.WHITE);
        panel.setLayout(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        // Panel title
        JLabel title = new JLabel("Quick Statistics");
        title.setFont(new Font("Tahoma", Font.BOLD, 18));
        title.setForeground(Colors.CAVIAR);
        title.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0)); // Bottom padding
        
        // Stats grid - 2 rows, 2 columns, 20px spacing
        JPanel statsGrid = new JPanel(new GridLayout(2, 2, 20, 20));
        statsGrid.setOpaque(false);
        
        // Add stat cards with different colors
        statsGrid.add(createStatCard("Total Enrollment", "1,245", Colors.BLUE));     // Blue
        statsGrid.add(createStatCard("Active Courses", "24", Colors.GREEN));       // Green
        statsGrid.add(createStatCard("Staff Members", "87", Colors.YELLOW));        // Yellow
        statsGrid.add(createStatCard("Completion Rate", "92%", Colors.RED));      // Red
        
        // Add components sa panel
        panel.add(title, BorderLayout.NORTH);           // Title sa top
        panel.add(statsGrid, BorderLayout.CENTER);      // Grid sa center
        
        return panel;
    }
    
    // Method para gumawa ng individual stat card
    // @param label - title ng statistic
    // @param value - value ng statistic
    // @param color - color ng value text
    private JPanel createStatCard(String label, String value, Color color) {
        // Create panel with BorderLayout, 10px spacing
        JPanel card = new JPanel(new BorderLayout(10, 10));
        card.setBackground(Colors.LIGHT_GRAY);        // Light gray background
        
        // Create compound border - 1px border + 20px padding
        card.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Colors.BORDER_DARK, 1),
            BorderFactory.createEmptyBorder(20, 20, 20, 20)
        ));
        
        // Value label - large bold font
        JLabel valueLabel = new JLabel(value);
        valueLabel.setFont(new Font("Tahoma", Font.BOLD, 36));
        valueLabel.setForeground(color);                // Colored text
        valueLabel.setHorizontalAlignment(SwingConstants.CENTER); // Center aligned
        
        // Label component - description
        JLabel labelComponent = new JLabel(label);
        labelComponent.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelComponent.setForeground(Colors.CAVIAR);
        labelComponent.setHorizontalAlignment(SwingConstants.CENTER);
        
        // Add components sa card
        card.add(valueLabel, BorderLayout.CENTER);      // Value sa center
        card.add(labelComponent, BorderLayout.SOUTH);   // Label sa bottom
        
        return card;
    }
}
