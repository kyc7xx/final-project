// Package para sa UI components
package sis.ui;

// Import necessary classes
import sis.utils.Colors;
import sis.utils.MenuListener;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

// SideMenu - left sidebar menu ng application
public class SideMenu extends JPanel {
    // List ng listeners para sa menu events
    private List<MenuListener> listeners = new ArrayList<>();

    // List ng menu item panels
    private List<JPanel> menuItems = new ArrayList<>();

    // Index ng currently selected menu
    private int selectedIndex = 0;

    // Reference sa currently active label (bold)
    private JLabel activeLabel = null;

    // Constructor - setup ng side menu
    public SideMenu() {
        // Set layout to BorderLayout
        setLayout(new BorderLayout());

        // Set dark gray background
        setBackground(Colors.MULBERRY);

        // Set width to 250 pixels, height flexible
        setPreferredSize(new Dimension(250, 0));

        // Initialize components
        initComponents();
    }

    // Method para mag-setup ng menu components
    private void initComponents() {
        // LOGO PANEL - top section ng sidebar
        JPanel logoPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 30));
        logoPanel.setBackground(Colors.MULBERRY);

        // Logo label - "SIS" text
        JLabel logoLabel = new JLabel("SIS");
        logoLabel.setFont(new Font("Tahoma", Font.BOLD, 28));
        logoLabel.setForeground(Color.WHITE);
        logoPanel.add(logoLabel);

        // MENU PANEL - container ng menu items
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));
        menuPanel.setBackground(Colors.MULBERRY);
        menuPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));

        // Array ng menu names
        String[] menus = {"Home", "Students", "Staff", "Reports"};

        // Loop para gumawa ng menu items
        for (int i = 0; i < menus.length; i++) {
            // Create menu item panel
            JPanel item = createMenuItem(menus[i], i);

            // Add sa list
            menuItems.add(item);

            // Add sa menu panel
            menuPanel.add(item);

            // Add spacing between items
            menuPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        }

        // Add logo at top
        add(logoPanel, BorderLayout.NORTH);

        // Add menu sa center
        add(menuPanel, BorderLayout.CENTER);

        // Select first item by default
        selectMenuItem(0);
    }

    // Method para gumawa ng individual menu item
    private JPanel createMenuItem(String menuName, int index) {
        // Create panel with FlowLayout
        JPanel item = new JPanel(new FlowLayout(FlowLayout.LEFT, 30, 15));
        item.setBackground(Colors.MULBERRY);

        // Set fixed height
        item.setMaximumSize(new Dimension(250, 50));

        // Set hand cursor on hover
        item.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Create label para sa menu name
        JLabel nameLabel = new JLabel(menuName);
        nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 15)); // not bold by default
        nameLabel.setForeground(Color.WHITE);

        // Add label sa item
        item.add(nameLabel);

        // Add mouse listener para sa interactions
        item.addMouseListener(new MouseAdapter() {
            // Pag nag-click sa menu item
            @Override
            public void mouseClicked(MouseEvent e) {
                // Select yung menu item
                selectMenuItem(index);
                // Gawing bold yung clicked label
                setActiveLabel(nameLabel);
                // Notify all listeners
                notifyListeners(menuName);
            }

            // Pag pumasok yung mouse sa menu item
            @Override
            public void mouseEntered(MouseEvent e) {
                // Change background kung hindi selected
                if (index != selectedIndex) {
                    item.setBackground(Colors.CHARCOAL_DARK);
                }
            }

            // Pag lumabas yung mouse sa menu item
            @Override
            public void mouseExited(MouseEvent e) {
                // Restore original background kung hindi selected
                if (index != selectedIndex) {
                    item.setBackground(Colors.MULBERRY);
                }
            }
        });

        return item;
    }

    // Method para i-select yung menu item
    private void selectMenuItem(int index) {
        // Deselect previous item
        if (selectedIndex >= 0 && selectedIndex < menuItems.size()) {
            menuItems.get(selectedIndex).setBackground(Colors.MULBERRY);
        }

        // Update selected index
        selectedIndex = index;

        // Set background ng selected item
        menuItems.get(index).setBackground(Colors.CHARCOAL);
    }

    // Helper method para gawing bold yung active label
    private void setActiveLabel(JLabel label) {
        if (activeLabel != null) {
            activeLabel.setFont(new Font("Tahoma", Font.PLAIN, 15)); // reset previous
        }
        label.setFont(new Font("Tahoma", Font.BOLD, 15)); // bold current
        activeLabel = label;
    }

    // Method para mag-add ng menu listener
    public void addMenuListener(MenuListener listener) {
        listeners.add(listener);
    }

    // Method para i-notify yung lahat ng listeners
    private void notifyListeners(String menuName) {
        // Loop through all listeners
        for (MenuListener listener : listeners) {
            // Call onMenuSelected method
            listener.onMenuSelected(menuName);
        }
    }
}
