// Package para sa UI
package sis.ui;

// Import forms
import sis.forms.*;
import javax.swing.*;
import java.awt.*;

// MainFrame class - main window ng application
public class MainFrame extends JFrame {
    // Private fields para sa main components
    private SideMenu sideMenu;       // Left sidebar menu
    private TopBar topBar;           // Top navigation bar
    private Dashboard dashboard;     // Main content area
    
    // Constructor - initialize main frame
    public MainFrame() {
        // Set window title
        setTitle("Student Information System");
        
        // Set window size - 1400x800 pixels
        setSize(1400, 800);
        
        // Set close operation - exit on close
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Center window sa screen
        setLocationRelativeTo(null);
        
        // Initialize lahat ng components
        initComponents();
    }
    
    // Method para mag-setup ng components
    private void initComponents() {
        // Set layout to BorderLayout
        setLayout(new BorderLayout());
        
        // Initialize side menu
        sideMenu = new SideMenu();
        
        // Initialize top bar
        topBar = new TopBar();
        
        // Initialize dashboard
        dashboard = new Dashboard();
        
        // Add lahat ng forms sa dashboard with unique names
        dashboard.addForm("Home", new HomeForm());           // Home form
        dashboard.addForm("Students", new StudentForm());    // Students form
        dashboard.addForm("Staff", new StaffForm());         // Staff form
        dashboard.addForm("Reports", new ReportForm());      // Reports form
        
        // Add menu listener para sa form switching
        sideMenu.addMenuListener(menuName -> {
            // Switch sa selected form
            dashboard.showForm(menuName);
            
            // Update top bar title
            topBar.setTitle(menuName);
        });
        
        // Create main panel para sa topbar at dashboard
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(topBar, BorderLayout.NORTH);           // Top bar sa top
        mainPanel.add(dashboard, BorderLayout.CENTER);       // Dashboard sa center
        
        // Add components sa frame
        add(sideMenu, BorderLayout.WEST);                    // Side menu sa left
        add(mainPanel, BorderLayout.CENTER);                 // Main panel sa center
    }
}
