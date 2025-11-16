// Package para sa custom components
package sis.components;

// Import necessary classes
import sis.utils.Colors;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import java.awt.*;

// CustomTable - custom na table component with minimalist styling
public class CustomTable extends JTable {
    
    // Constructor - default table setup
    public CustomTable() {
        // Call ng parent constructor
        super();
        // Initialize custom styling
        customizeTable();
    }
    
    // Method para i-customize yung table appearance
    private void customizeTable() {
        // Set font ng table cells - Tahoma, plain, size 13
        setFont(new Font("Tahoma", Font.PLAIN, 13));
        
        // Set row height - 40 pixels para hindi masikip
        setRowHeight(40);
        
        // Hide grid lines para cleaner yung look
        setShowGrid(false);
        
        // Set cell spacing to 0
        setIntercellSpacing(new Dimension(0, 0));
        
        // Set selection background color
        setSelectionBackground(Colors.LIGHT_GRAY);
        
        // Set selection foreground (text) color
        setSelectionForeground(Colors.CHARCOAL_DARK);
        
        // HEADER STYLING - customize yung table header
        JTableHeader header = getTableHeader();
        
        // Set font ng header - bold para emphasized
        header.setFont(new Font("Tahoma", Font.BOLD, 13));
        
        // Set background color ng header
        header.setBackground(Colors.CHARCOAL);
        
        // Set foreground (text) color ng header
        header.setForeground(Colors.CHARCOAL_DARK);
        
        // Set height ng header - 45 pixels
        header.setPreferredSize(new Dimension(header.getPreferredSize().width, 45));
        
        // CELL RENDERER - custom rendering ng cells with alternating colors
        setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {
                // Call parent method
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                
                // Kung hindi selected yung row
                if (!isSelected) {
                    // Alternating row colors - white at light gray
                    c.setBackground(row % 2 == 0 ? Color.WHITE : Colors.LIGHT_GRAY);
                }
                
                // Set text color to light gray
                setForeground(Colors.CAVIAR);
                
                // Set padding ng cell - 5 top/bottom, 10 left/right
                setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
                
                return c;
            }
        });
    }
}
