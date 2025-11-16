// Package para sa forms
package sis.forms;

// Import necessary classes
import sis.components.RoundPanel;
import sis.utils.Colors;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

// HomeForm class - dashboard/home page ng system
public class HomeForm extends JPanel {
    // Private field para sa clock display
    private JLabel timeLabel;

    // Constructor - initialize home form
    public HomeForm() {
        // Set layout to BorderLayout with 20px spacing
        setLayout(new BorderLayout(20, 20));
        
        // Set background color
        setBackground(Colors.VAPOROUS_GRAY);
        
        // Set padding - 30px sa lahat ng sides
        setBorder(new EmptyBorder(30, 30, 30, 30));
        
        // Initialize components
        initComponents();
        
        // Start real-time clock
        startClock();
    }

    // Method para mag-setup ng lahat ng components
    private void initComponents() {
        // Create header panel with welcome message at clock
        JPanel headerPanel = createHeaderPanel();

        // Create top cards panel - statistics cards
        JPanel topCardsPanel = createTopCardsPanel();

        // Create bottom panel - performance at quick stats
        JPanel bottomPanel = createBottomPanel();

        // Add lahat sa main layout
        add(headerPanel, BorderLayout.NORTH);        // Header sa top
        add(topCardsPanel, BorderLayout.CENTER);     // Cards sa center
        add(bottomPanel, BorderLayout.SOUTH);        // Bottom panels sa south
    }

    // Method para gumawa ng header panel
    private JPanel createHeaderPanel() {
        // Main panel with BorderLayout
        JPanel panel = new JPanel(new BorderLayout());
        panel.setOpaque(false);                      // Transparent
        panel.setBorder(new EmptyBorder(0, 0, 20, 0)); // Bottom padding
        
        // Welcome panel - 2 rows for welcome text
        JPanel welcomePanel = new JPanel(new GridLayout(2, 1, 0, 5));
        welcomePanel.setOpaque(false);

        // Main welcome message - bold at malaki
        JLabel welcome = new JLabel("Welcome Back, Admin!");
        welcome.setFont(new Font("Tahoma", Font.BOLD, 28));
        welcome.setForeground(Colors.CAVIAR);     // Caviar

        // Subtitle message - plain font
        JLabel subtitle = new JLabel("Here's what's happening with your institution today");
        subtitle.setFont(new Font("Tahoma", Font.PLAIN, 14));
        subtitle.setForeground(Colors.CAVIAR); // Caviar

        // Add labels sa welcome panel
        welcomePanel.add(welcome);
        welcomePanel.add(subtitle);

        // Initialize time label para sa clock
        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        timeLabel.setForeground(Colors.CAVIAR);  // Caviar

        // Add components sa panel
        panel.add(welcomePanel, BorderLayout.WEST);    // Welcome sa left
        panel.add(timeLabel, BorderLayout.EAST);       // Clock sa right

        return panel;
    }

    // Method para gumawa ng top cards panel
    private JPanel createTopCardsPanel() {
        // Grid layout - 1 row, 4 columns, 10px spacing
        JPanel grid = new JPanel(new GridLayout(1, 4, 10, 0));
        grid.setOpaque(false);
        grid.setBorder(new EmptyBorder(0, 0, 10, 0));  // Bottom padding
        grid.setMaximumSize(new Dimension(Integer.MAX_VALUE, 120)); // Max height

        // Array ng card data - title, value, color type
        String[][] cards = {
            {"Total Students", "1,245", "INFO"},        // Blue card
            {"Total Staff", "87", "SUCCESS"},           // Green card
            {"Courses", "24", "WARNING"},               // Yellow card
            {"Dropout Rate", "2.18%", "DANGER"}         // Red card
        };

        // Loop para gumawa ng cards
        for (String[] data : cards) {
            // Get color from Colors utility
            grid.add(createInfoCard(data[0], data[1], Colors.getColor(data[2])));
        }

        return grid;
    }

    // Method para gumawa ng individual info card
    // @param label - title ng card
    // @param value - value na idisplay
    // @param color - color ng value
    private JPanel createInfoCard(String label, String value, Color color) {
        // Create rounded panel
        RoundPanel card = new RoundPanel();
        card.setBackground(Color.WHITE);              // White background
        card.setLayout(new BorderLayout());
        card.setBorder(new EmptyBorder(15, 15, 15, 15)); // 15px padding

        // Value label - large bold font
        JLabel valueLabel = new JLabel(value);
        valueLabel.setFont(new Font("Tahoma", Font.BOLD, 32));
        valueLabel.setForeground(color);              // Colored text

        // Name/title label - smaller plain font
        JLabel nameLabel = new JLabel(label);
        nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
        nameLabel.setForeground(Colors.CAVIAR); // Caviar

        // Text panel - 2 rows for value at label
        JPanel textPanel = new JPanel(new GridLayout(2, 1, 0, 5));
        textPanel.setOpaque(false);
        textPanel.add(valueLabel);                    // Value sa top
        textPanel.add(nameLabel);                     // Label sa bottom

        // Add text panel sa card
        card.add(textPanel, BorderLayout.CENTER);

        return card;
    }

    // Method para gumawa ng bottom panel
    private JPanel createBottomPanel() {
        // Grid layout - 1 row, 2 columns, 20px spacing
        JPanel panel = new JPanel(new GridLayout(1, 2, 20, 0));
        panel.setOpaque(false);
        panel.setPreferredSize(new Dimension(0, 300)); // Fixed height

        // Add performance panel sa left
        panel.add(createPerformancePanel());
        
        // Add quick stats panel sa right
        panel.add(createQuickStatsPanel());

        return panel;
    }

    // Method para gumawa ng performance panel
    private RoundPanel createPerformancePanel() {
        // Create rounded panel
        RoundPanel panel = new RoundPanel();
        panel.setBackground(Color.WHITE);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));
        panel.setPreferredSize(new Dimension(0, 300));

        // Title label
        JLabel title = new JLabel("Department Performance");
        title.setFont(new Font("Tahoma", Font.BOLD, 16));
        title.setForeground(Colors.CAVIAR);
        title.setAlignmentX(Component.LEFT_ALIGNMENT);

        // Add title at spacing
        panel.add(title);
        panel.add(Box.createVerticalStrut(15));

        // Arrays ng department data
        String[] departments = {"Computer Science", "Mathematics", "Engineering", "Business"};
        int[] values = {85, 72, 91, 68};              // Performance percentages

        // Loop para gumawa ng progress bars
        for (int i = 0; i < departments.length; i++) {
            panel.add(createProgressItem(departments[i], values[i]));
            panel.add(Box.createVerticalStrut(10));   // Spacing between items
        }

        return panel;
    }

    // Method para gumawa ng progress bar item
    // @param name - department name
    // @param value - progress percentage
    private JPanel createProgressItem(String name, int value) {
        // Panel with BorderLayout, 10px horizontal, 5px vertical spacing
        JPanel panel = new JPanel(new BorderLayout(10, 5));
        panel.setOpaque(false);
        panel.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40)); // Max height

        // Label with name at percentage
        JLabel label = new JLabel(name + " - " + value + "%");
        label.setFont(new Font("Tahoma", Font.PLAIN, 12));
        label.setForeground(Colors.CAVIAR);

        // Create progress bar
        JProgressBar progressBar = new JProgressBar(0, 100);
        progressBar.setValue(value);                  // Set progress value
        progressBar.setForeground(Colors.CAVIAR); // Bar color
        progressBar.setBackground(Colors.LIGHT_GRAY);  // Background color
        progressBar.setPreferredSize(new Dimension(0, 8)); // 8px height
        progressBar.setBorderPainted(false);          // No border
        progressBar.setStringPainted(false);          // No text sa bar

        // Add components
        panel.add(label, BorderLayout.NORTH);         // Label sa top
        panel.add(progressBar, BorderLayout.CENTER);  // Bar sa center

        return panel;
    }

    // Method para gumawa ng quick stats panel
    private RoundPanel createQuickStatsPanel() {
        // Create rounded panel
        RoundPanel panel = new RoundPanel();
        panel.setBackground(Colors.LIGHT_GRAY);     // Light gray background
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));
        panel.setPreferredSize(new Dimension(0, 300));

        // Large GPA value - very big font
        JLabel gpaLabel = new JLabel("2.27");
        gpaLabel.setFont(new Font("Tahoma", Font.BOLD, 48));
        gpaLabel.setForeground(Colors.CAVIAR);
        gpaLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        // GPA description text
        JLabel gpaText = new JLabel("Average GPA");
        gpaText.setFont(new Font("Tahoma", Font.PLAIN, 14));
        gpaText.setForeground(Colors.CAVIAR);
        gpaText.setAlignmentX(Component.LEFT_ALIGNMENT);

        // Add components with vertical glue para centered
        panel.add(Box.createVerticalGlue());          // Push down
        panel.add(gpaLabel);                          // GPA value
        panel.add(Box.createVerticalStrut(10));       // Spacing
        panel.add(gpaText);                           // Description
        panel.add(Box.createVerticalGlue());          // Push up

        return panel;
    }

    // Method para mag-start ng real-time clock
    private void startClock() {
        // Create timer - updates every 1000ms (1 second)
        Timer timer = new Timer(1000, e -> {
            // Format: Day, Month DD, YYYY | HH:MM:SS
            String time = new SimpleDateFormat("EEEE, MMM dd, yyyy  |  HH:mm:ss").format(new Date());
            
            // Update time label text
            timeLabel.setText(time);
            
            // Set color to brown
            timeLabel.setForeground(new Color(160, 82, 45));
        });
        
        // Start yung timer
        timer.start();
    }
}
