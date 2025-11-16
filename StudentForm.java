// Package declaration - dito yung forms ng application
package sis.forms;

// Import ng custom components at utilities
import sis.components.*;
import sis.utils.Colors;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

// StudentForm class - main panel para sa student management
public class StudentForm extends JPanel {
    // Declare ng components na gagamitin
    private CustomTable table;                    // Table para display ng students
    private DefaultTableModel tableModel;          // Model para sa table data
    private JTextField searchField;                // Field para sa search functionality
    
    // Text fields para sa student information
    private JTextField idField, nameField, emailField, phoneField, courseField;
    private JComboBox<String> statusBox;          // Dropdown para sa status
    
    // List para mag-store ng lahat ng student data
    private List<Object[]> studentData = new ArrayList<>();
    
    // Constructor - mag-initialize ng panel
    public StudentForm() {
        // Set layout to BorderLayout para organized yung placement
        setLayout(new BorderLayout());
        
        // Set background color to main bg color
        setBackground(Colors.VAPOROUS_GRAY);
        
        // Set padding - 30 pixels sa lahat ng sides
        setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        
        // Initialize lahat ng components
        initComponents();
    }
    
    // Method para mag-setup ng lahat ng UI components
    private void initComponents() {
        // Main panel container with BorderLayout at 20px spacing
        JPanel mainPanel = new JPanel(new BorderLayout(0, 20));
        mainPanel.setOpaque(false); // Transparent para makita yung background
        
        // Create form panel para sa input fields
        RoundPanel formPanel = createFormPanel();
        
        // Create search panel para sa search functionality
        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        searchPanel.setOpaque(false); // Make transparent
        
        // Initialize search text field - 20 columns width
        searchField = new JTextField(20);
        searchField.setFont(new Font("Tahoma", Font.PLAIN, 14));      // Set font
        searchField.setForeground(Colors.CAVIAR);                // Set text color
        
        // Create search button with custom styling
        CustomButton searchButton = new CustomButton("Search");
        searchButton.setPreferredSize(new Dimension(100, 35));        // Set size
        searchButton.addActionListener(e -> searchStudent());          // Add click action
        searchButton.setFont(new Font("Tahoma", Font.PLAIN, 12));     // Set font
        
        // Create refresh button para i-reset yung table
        CustomButton refreshButton = new CustomButton("Refresh");
        refreshButton.setPreferredSize(new Dimension(100, 35));       // Set size
        refreshButton.addActionListener(e -> refreshTable());          // Add click action
        refreshButton.setFont(new Font("Tahoma", Font.PLAIN, 12));    // Set font
        
        // Add components sa search panel
        searchPanel.add(searchField);
        searchPanel.add(searchButton);
        searchPanel.add(refreshButton);
        
        // Create table panel para display ng student list
        RoundPanel tablePanel = createTablePanel();
        
        // Top section - combined form at search panel
        JPanel topSection = new JPanel(new BorderLayout(0, 20));
        topSection.setOpaque(false);                                  // Transparent background
        topSection.add(formPanel, BorderLayout.NORTH);                // Form sa top
        topSection.add(searchPanel, BorderLayout.SOUTH);              // Search sa bottom
        
        // Add sa main panel
        mainPanel.add(topSection, BorderLayout.NORTH);                // Top section sa north
        mainPanel.add(tablePanel, BorderLayout.CENTER);               // Table sa center
        
        // Add main panel sa StudentForm
        add(mainPanel, BorderLayout.CENTER);
    }
    
    // Method para gumawa ng form panel with input fields
    private RoundPanel createFormPanel() {
        // Create rounded panel para sa form
        RoundPanel panel = new RoundPanel();
        panel.setBackground(Color.WHITE);                             // White background
        panel.setLayout(new BorderLayout(0, 15));                     // BorderLayout with 15px spacing
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // 20px padding
        
        // Title label para sa form
        JLabel title = new JLabel("Student Management");
        title.setFont(new Font("Tahoma", Font.BOLD, 18));            // Bold, size 18
        title.setForeground(Colors.CAVIAR);                        // Dark text color
        
        // Fields panel - 2 rows, 3 columns grid layout
        JPanel fieldsPanel = new JPanel(new GridLayout(2, 3, 15, 15));
        fieldsPanel.setOpaque(false);                                 // Transparent
        
        // Initialize ID field
        idField = new JTextField();
        idField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        idField.setForeground(Colors.CAVIAR);
        
        // Initialize name field
        nameField = new JTextField();
        nameField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        nameField.setForeground(Colors.CAVIAR);
        
        // Initialize email field
        emailField = new JTextField();
        emailField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        emailField.setForeground(Colors.CAVIAR);
        
        // Initialize phone field
        phoneField = new JTextField();
        phoneField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        phoneField.setForeground(Colors.CAVIAR);
        
        // Initialize course field
        courseField = new JTextField();
        courseField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        courseField.setForeground(Colors.CAVIAR);
        
        // Initialize status dropdown with options
        String[] statuses = {"Active", "Inactive", "Graduated"};
        statusBox = new JComboBox<>(statuses);
        statusBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
        statusBox.setForeground(Colors.CAVIAR);
        
        // Add lahat ng fields sa panel with labels
        fieldsPanel.add(createFieldPanel("Student ID:", idField));
        fieldsPanel.add(createFieldPanel("Full Name:", nameField));
        fieldsPanel.add(createFieldPanel("Email:", emailField));
        fieldsPanel.add(createFieldPanel("Phone:", phoneField));
        fieldsPanel.add(createFieldPanel("Course:", courseField));
        fieldsPanel.add(createFieldPanel("Status:", statusBox));
        
        // Buttons panel para sa actions
        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
        buttonsPanel.setOpaque(false);
        
        // Add button - green color para sa add action
        CustomButton addButton = new CustomButton("Add Student");
        addButton.setPreferredSize(new Dimension(120, 35));
        addButton.addActionListener(e -> addStudent());               // Click action
        addButton.setBackground(Colors.GREEN);                      // Green color
        addButton.setFont(new Font("Tahoma", Font.BOLD, 12));
        
        // Update button - yellow color para sa update action
        CustomButton updateButton = new CustomButton("Update");
        updateButton.setPreferredSize(new Dimension(100, 35));
        updateButton.addActionListener(e -> updateStudent());         // Click action
        updateButton.setBackground(Colors.YELLOW);                   // Yellow color
        updateButton.setFont(new Font("Tahoma", Font.BOLD, 12));
        
        // Delete button - red color para sa delete action
        CustomButton deleteButton = new CustomButton("Delete");
        deleteButton.setPreferredSize(new Dimension(100, 35));
        deleteButton.addActionListener(e -> deleteStudent());         // Click action
        deleteButton.setBackground(Colors.RED);                    // Red color
        deleteButton.setFont(new Font("Tahoma", Font.BOLD, 12));
        
        // Clear button - blue color para sa clear action
        CustomButton clearButton = new CustomButton("Clear");
        clearButton.setPreferredSize(new Dimension(100, 35));
        clearButton.addActionListener(e -> clearFields());            // Click action
        clearButton.setBackground(Colors.BLUE);                       // Blue color
        clearButton.setFont(new Font("Tahoma", Font.BOLD, 12));
        
        // Add buttons sa panel - right to left order
        buttonsPanel.add(clearButton);
        buttonsPanel.add(deleteButton);
        buttonsPanel.add(updateButton);
        buttonsPanel.add(addButton);
        
        // Add lahat sa main panel
        panel.add(title, BorderLayout.NORTH);                         // Title sa top
        panel.add(fieldsPanel, BorderLayout.CENTER);                  // Fields sa center
        panel.add(buttonsPanel, BorderLayout.SOUTH);                  // Buttons sa bottom
        
        return panel;
    }
    
    // Helper method para gumawa ng field with label
    // @param label - yung text ng label
    // @param component - yung input component (TextField or ComboBox)
    private JPanel createFieldPanel(String label, JComponent component) {
        // Panel with BorderLayout at 5px spacing
        JPanel panel = new JPanel(new BorderLayout(0, 5));
        panel.setOpaque(false);                                       // Transparent
        
        // Create label component
        JLabel labelComponent = new JLabel(label);
        labelComponent.setFont(new Font("Tahoma", Font.PLAIN, 12));
        labelComponent.setForeground(Colors.CAVIAR);          // Secondary text color
        
        // Add label sa top, component sa center
        panel.add(labelComponent, BorderLayout.NORTH);
        panel.add(component, BorderLayout.CENTER);
        
        return panel;
    }
    
    // Method para gumawa ng table panel
    private RoundPanel createTablePanel() {
        // Create rounded panel
        RoundPanel panel = new RoundPanel();
        panel.setBackground(Color.WHITE);                             // White background
        panel.setLayout(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // 20px padding
        
        // Table title
        JLabel title = new JLabel("Student List");
        title.setFont(new Font("Tahoma", Font.BOLD, 18));
        title.setForeground(Colors.CAVIAR);
        title.setBorder(BorderFactory.createEmptyBorder(0, 0, 15, 0)); // Bottom padding
        
        // Define table columns
        String[] columns = {"ID", "Name", "Email", "Phone", "Course", "Status"};
        
        // Create table model - override isCellEditable para hindi ma-edit yung cells
        tableModel = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;                                         // All cells read-only
            }
        };
        
        // Create custom table with model
        table = new CustomTable();
        table.setModel(tableModel);
        
        // Add row selection listener para ma-load sa form yung selected row
        table.getSelectionModel().addListSelectionListener(e -> {
            // Check kung hindi pa nag-aadjust at may selected row
            if (!e.getValueIsAdjusting() && table.getSelectedRow() != -1) {
                loadStudentToForm(table.getSelectedRow());            // Load data sa form
            }
        });
        
        // Create scroll pane para sa table
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(null);                                   // Remove border
        scrollPane.setVerticalScrollBar(new CustomScrollBar());       // Custom scrollbar
        
        // Add components sa panel
        panel.add(title, BorderLayout.NORTH);                         // Title sa top
        panel.add(scrollPane, BorderLayout.CENTER);                   // Table sa center
        
        // Load sample data sa table
        loadSampleData();
        
        return panel;
    }
    
    // Method para mag-load ng sample student data
    private void loadSampleData() {
        // Clear existing data
        studentData.clear();
        
        // Add sample students - format: ID, Name, Email, Phone, Course, Status
        studentData.add(new Object[]{"C2025184921", "Dos Deleon", "dospordos@gmail.com", "0989-788-9120", "Civil Engineering", "Inactive"});
        studentData.add(new Object[]{"C2025557803", "Cruz Alcantara", "alcantaracruz@gmail.com", "0976-903-2415", "Food Technology", "Active"});
        studentData.add(new Object[]{"C2025902174", "Kurt Salas", "kurtsalas@gmail.com", "0955-678-0354", "Aircraft Maintenance", "Inactive"});
        studentData.add(new Object[]{"C2025331689", "Brice Salazar", "salazarbri@gmail.com", "0911-223-4565", "Information Technology", "Active"});
        studentData.add(new Object[]{"C2025749210", "Hanmi Aguas", "hanmiaguas@gmail.com", "0998-567-1234", "Aircraft Engineering", "Graduated"});
        studentData.add(new Object[]{"C2025628537", "John Estrada", "estradajohn@gmail.com", "0955-678-1245", "Criminology", "Active"});
        studentData.add(new Object[]{"C2025184921", "Leo Pineda", "leopineda76@gmail.com", "0990-807-8564", "Psychology", "Active"});
        
        // Refresh table para ma-display yung data
        refreshTable();
    }
    
    // Method para i-load yung selected row data sa form fields
    // @param row - yung index ng selected row
    private void loadStudentToForm(int row) {
        // Get data from table at i-set sa fields
        idField.setText(tableModel.getValueAt(row, 0).toString());
        nameField.setText(tableModel.getValueAt(row, 1).toString());
        emailField.setText(tableModel.getValueAt(row, 2).toString());
        phoneField.setText(tableModel.getValueAt(row, 3).toString());
        courseField.setText(tableModel.getValueAt(row, 4).toString());
        statusBox.setSelectedItem(tableModel.getValueAt(row, 5).toString());
    }
    
    // Method para mag-add ng new student
    private void addStudent() {
        // Validate muna kung complete yung fields
        if (validateFields()) {
            // Create array ng student data from form fields
            Object[] newStudent = {
                idField.getText(),
                nameField.getText(),
                emailField.getText(),
                phoneField.getText(),
                courseField.getText(),
                statusBox.getSelectedItem().toString()
            };
            
            // Add sa data list
            studentData.add(newStudent);
            
            // Add sa table
            tableModel.addRow(newStudent);
            
            // Clear form fields
            clearFields();
            
            // Show success message
            JOptionPane.showMessageDialog(this, "Student added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    // Method para mag-update ng existing student
    private void updateStudent() {
        // Get selected row
        int selectedRow = table.getSelectedRow();
        
        // Check kung may selected row
        if (selectedRow == -1) {
            // Show warning kung walang selected
            JOptionPane.showMessageDialog(this, "Please select a student to update!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        // Validate fields
        if (validateFields()) {
            // Create updated student data
            Object[] updatedStudent = {
                idField.getText(),
                nameField.getText(),
                emailField.getText(),
                phoneField.getText(),
                courseField.getText(),
                statusBox.getSelectedItem().toString()
            };
            
            // Update sa data list
            studentData.set(selectedRow, updatedStudent);
            
            // Update sa table - loop through columns
            for (int i = 0; i < updatedStudent.length; i++) {
                tableModel.setValueAt(updatedStudent[i], selectedRow, i);
            }
            
            // Clear fields
            clearFields();
            
            // Show success message
            JOptionPane.showMessageDialog(this, "Student updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    // Method para mag-delete ng student
    private void deleteStudent() {
        // Get selected row
        int selectedRow = table.getSelectedRow();
        
        // Check kung may selected
        if (selectedRow == -1) {
            // Show warning
            JOptionPane.showMessageDialog(this, "Please select a student to delete!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        // Ask for confirmation
        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this student?", 
                                                     "Confirm Delete", JOptionPane.YES_NO_OPTION);
        
        // Kung nag-confirm yung user
        if (confirm == JOptionPane.YES_OPTION) {
            // Remove from data list
            studentData.remove(selectedRow);
            
            // Remove from table
            tableModel.removeRow(selectedRow);
            
            // Clear fields
            clearFields();
            
            // Show success message
            JOptionPane.showMessageDialog(this, "Student deleted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    // Method para mag-search ng students
    private void searchStudent() {
        // Get search keyword - convert to lowercase para case-insensitive
        String keyword = searchField.getText().trim().toLowerCase();
        
        // Clear table
        tableModel.setRowCount(0);
        
        // Loop through all student data
        for (Object[] row : studentData) {
            // Loop through each cell sa row
            for (Object cell : row) {
                // Check kung may match yung keyword
                if (cell != null && cell.toString().toLowerCase().contains(keyword)) {
                    // Add row sa table
                    tableModel.addRow(row);
                    break; // Break para hindi duplicate yung row
                }
            }
        }
    }
    
    // Method para i-refresh yung table - show all students
    private void refreshTable() {
        // Clear search field
        searchField.setText("");
        
        // Clear table
        tableModel.setRowCount(0);
        
        // Add all students back sa table
        for (Object[] row : studentData) {
            tableModel.addRow(row);
        }
    }
    
    // Method para i-clear lahat ng form fields
    private void clearFields() {
        idField.setText("");                      // Clear ID
        nameField.setText("");                    // Clear name
        emailField.setText("");                   // Clear email
        phoneField.setText("");                   // Clear phone
        courseField.setText("");                  // Clear course
        statusBox.setSelectedIndex(0);            // Reset to first status
        table.clearSelection();                   // Clear table selection
    }
    
    // Method para i-validate kung complete yung fields
    // @return true kung valid, false kung may empty fields
    private boolean validateFields() {
        // Check kung may empty fields
        if (idField.getText().trim().isEmpty() || nameField.getText().trim().isEmpty() ||
            emailField.getText().trim().isEmpty() || phoneField.getText().trim().isEmpty() ||
            courseField.getText().trim().isEmpty()) {
            
            // Show error message
            JOptionPane.showMessageDialog(this, "Please fill in all fields!", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true; // All fields complete
    }
}
