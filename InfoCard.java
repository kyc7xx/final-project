// Package para sa UI components
package sis.ui;

// Import necessary classes
import sis.components.RoundPanel;
import sis.models.CardData;
import javax.swing.*;
import java.awt.*;

// InfoCard class - card component para sa statistics display
public class InfoCard extends RoundPanel {
    // Private fields
    private CardData data;           // Data ng card
    private JLabel titleLabel;       // Label para sa title
    private JLabel valueLabel;       // Label para sa value
    
    // Constructor - initialize info card
    // @param data - CardData object with info
    public InfoCard(CardData data) {
        this.data = data;                       // Store data
        
        // Set layout with spacing
        setLayout(new BorderLayout(10, 10));
        
        // Set white background
        setBackground(Color.WHITE);
        
        // Set padding - 20px sa lahat ng sides
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        // Initialize components
        initComponents();
    }
    
    // Method para mag-setup ng card components
    private void initComponents() {
        // Text panel - 2 rows, 1 column, 5px spacing
        JPanel textPanel = new JPanel(new GridLayout(2, 1, 0, 5));
        textPanel.setOpaque(false);              // Transparent background
        
        // Title label - gray color, plain font
        titleLabel = new JLabel(data.getTitle());
        titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        titleLabel.setForeground(new Color(120, 120, 120));  // Gray
        
        // Value label - larger bold font
        valueLabel = new JLabel(data.getValue());
        valueLabel.setFont(new Font("Tahoma", Font.BOLD, 28));
        valueLabel.setForeground(new Color(85, 85, 85));     // Dark gray
        
        // Add labels sa text panel
        textPanel.add(titleLabel);
        textPanel.add(valueLabel);
        
        // Add text panel sa center ng card
        add(textPanel, BorderLayout.CENTER);
    }
    
    // Method para mag-update ng value
    // @param value - new value na idisplay
    public void updateValue(String value) {
        valueLabel.setText(value);    // Update label text
    }
}
