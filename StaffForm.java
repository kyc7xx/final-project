// Package para sa forms
package sis.forms;

// Import necessary classes
import sis.components.*;
import sis.utils.Colors;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

// StaffForm class - form para sa staff management
public class StaffForm extends JPanel {
    // Private fields para sa components
    private CustomTable table;                     // Table para display ng staff
    private DefaultTableModel tableModel;          // Model para sa table data
    private JTextField searchField;                // Search field

    // Store all staff data sa memory
    private List<Object[]> staffData = new ArrayList<>();

    // Constructor - initialize staff form
    public StaffForm() {
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
        // Main panel with BorderLayout, 20px vertical spacing
        JPanel mainPanel = new JPanel(new BorderLayout(0, 20));
        mainPanel.setOpaque(false);

        // Top panel - search at refresh buttons
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        topPanel.setOpaque(false);

        // Search text field - 20 columns width
        searchField = new JTextField(20);
        searchField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        searchField.setForeground(Colors.CAVIAR);

        // Search button
        CustomButton searchButton = new CustomButton("Search");
        searchButton.setPreferredSize(new Dimension(100, 35));
        searchButton.addActionListener(e -> searchStaff());    // Click action
        searchButton.setFont(new Font("Tahoma", Font.PLAIN, 14));

        // Refresh button
        CustomButton refreshButton = new CustomButton("Refresh");
        refreshButton.setPreferredSize(new Dimension(100, 35));
        refreshButton.addActionListener(e -> refreshTable());  // Click action
        refreshButton.setFont(new Font("Tahoma", Font.PLAIN, 14));

        // Add components sa top panel
        topPanel.add(searchField);
        topPanel.add(searchButton);
        topPanel.add(refreshButton);

        // Create table panel
        RoundPanel tablePanel = createTablePanel();

        // Add panels sa main panel
        mainPanel.add(topPanel, BorderLayout.NORTH);           // Search sa top
        mainPanel.add(tablePanel, BorderLayout.CENTER);        // Table sa center

        // Add main panel sa form
        add(mainPanel, BorderLayout.CENTER);
    }

    // Method para gumawa ng table panel
    private RoundPanel createTablePanel() {
        // Create rounded panel
        RoundPanel panel = new RoundPanel();
        panel.setBackground(Color.WHITE);
        panel.setLayout(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Table title
        JLabel title = new JLabel("Staff List");
        title.setFont(new Font("Tahoma", Font.BOLD, 18));
        title.setForeground(Colors.CAVIAR);
        title.setBorder(BorderFactory.createEmptyBorder(0, 0, 15, 0));

        // Define table columns
        String[] columns = {"Name", "Email", "Phone", "Department", "Status"};
        
        // Create table model - non-editable cells
        tableModel = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;                               // All cells read-only
            }
        };

        // Create custom table
        table = new CustomTable();
        table.setModel(tableModel);

        // Create scroll pane with custom scrollbar
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(null);
        scrollPane.setVerticalScrollBar(new CustomScrollBar());

        // Add components sa panel
        panel.add(title, BorderLayout.NORTH);               // Title sa top
        panel.add(scrollPane, BorderLayout.CENTER);         // Table sa center

        // Load sample data
        loadSampleData();

        return panel;
    }

    // Method para mag-load ng sample staff data
    private void loadSampleData() {
        // Clear existing data
        staffData.clear();
        
        // Add sample staff - format: Name, Email, Phone, Department, Status
        staffData.add(new Object[]{"Liza Shin", "shinliza@gmail.com", "0924-122-4567", "COECS", "On Leave"});
        staffData.add(new Object[]{"Angela Bernardo", "angebernardo@gmail.com", "0989-012-4617", "CBEE", "Active"});
        staffData.add(new Object[]{"Sofia Lim", "sofielim45@gmail.com", "0999-887-5615", "CAS", "Active"});
        staffData.add(new Object[]{"Kevin Flojo", "flojokev77@gmail.com", "0911-223-1456", "CASTECH", "Active"});
        staffData.add(new Object[]{"Rhea De Leon", "leonderhea32@gmail.com", "0909-412-0405", "COECS", "Retired"});
        staffData.add(new Object[]{"Mark Campos", "markcampos21@gmail.com", "0944-562-3461", "COECS", "Active"});

        // Populate table with data
        refreshTable();
    }

    // Search function - filters staff by keyword
    private void searchStaff() {
        // Get search keyword - convert to lowercase para case-insensitive
        String keyword = searchField.getText().trim().toLowerCase();
        
        // Clear table rows
        tableModel.setRowCount(0);

        // Loop through all staff data
        for (Object[] row : staffData) {
            // Check each cell kung may match sa keyword
            for (Object cell : row) {
                if (cell != null && cell.toString().toLowerCase().contains(keyword)) {
                    tableModel.addRow(row);             // Add row kung may match
                    break;                              // Break para hindi duplicate
                }
            }
        }
    }

    // Refresh function - resets table to show all staff
    private void refreshTable() {
        // Clear search field
        searchField.setText("");
        
        // Clear table
        tableModel.setRowCount(0);
        
        // Add all staff back sa table
        for (Object[] row : staffData) {
            tableModel.addRow(row);
        }
    }
}
