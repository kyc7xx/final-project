// Package declaration - dito nakalagay yung main entry point ng application
package sis.Main;

// Import ng necessary classes para sa GUI
import sis.ui.MainFrame;
import javax.swing.*;

// Main class - ito yung starting point ng buong program
public class Main {
    // Main method - dito nagsisimula yung program execution
    public static void main(String[] args) {
        // Try-catch block para sa error handling ng look and feel
        try {
            // Set ng system look and feel para magmukhang native yung UI sa OS
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            // Print error sa console kung may problema sa look and feel
            e.printStackTrace();
        }
        
        // SwingUtilities.invokeLater - ginagamit para sa thread-safe na UI creation
        SwingUtilities.invokeLater(() -> {
            // Create new MainFrame instance - ito yung main window
            MainFrame frame = new MainFrame();
            // I-display yung window sa screen
            frame.setVisible(true);
        });
    }
}
