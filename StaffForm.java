package sis.forms;

import sis.components.*;
import sis.utils.Colors;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class StaffForm extends JPanel {
    private CustomTable table;
    private DefaultTableModel tableModel;
    private JTextField searchField;
    private List<Object[]> staffData = new ArrayList<>();

    public StaffForm() {
        setLayout(new BorderLayout());
        setBackground(Colors.VAPOROUS_GRAY);
        setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        initComponents();
    }

    private void initComponents() {
        JPanel mainPanel = new JPanel(new BorderLayout(0, 20));
        mainPanel.setOpaque(false);

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        topPanel.setOpaque(false);

        searchField = new JTextField(20);
        searchField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        searchField.setForeground(Colors.CAVIAR);

        CustomButton searchButton = new CustomButton("Search");
        searchButton.setPreferredSize(new Dimension(100, 35));
        searchButton.addActionListener(e -> searchStaff());
        searchButton.setFont(new Font("Tahoma", Font.PLAIN, 14));

        CustomButton refreshButton = new CustomButton("Refresh");
        refreshButton.setPreferredSize(new Dimension(100, 35));
        refreshButton.addActionListener(e -> refreshTable());
        refreshButton.setFont(new Font("Tahoma", Font.PLAIN, 14));

        topPanel.add(searchField);
        topPanel.add(searchButton);
        topPanel.add(refreshButton);

        RoundPanel tablePanel = createTablePanel();

        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(tablePanel, BorderLayout.CENTER);

        add(mainPanel, BorderLayout.CENTER);
    }

    private RoundPanel createTablePanel() {
        RoundPanel panel = new RoundPanel();
        panel.setBackground(Color.WHITE);
        panel.setLayout(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel title = new JLabel("Staff List");
        title.setFont(new Font("Tahoma", Font.BOLD, 18));
        title.setForeground(Colors.CAVIAR);
        title.setBorder(BorderFactory.createEmptyBorder(0, 0, 15, 0));

        String[] columns = {"Name", "Email", "Phone", "Department", "Status"};

        tableModel = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        table = new CustomTable();
        table.setModel(tableModel);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(null);
        scrollPane.setVerticalScrollBar(new CustomScrollBar());

        panel.add(title, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);

        loadSampleData();

        return panel;
    }

    private void loadSampleData() {
        staffData.clear();

        staffData.add(new Object[]{"Liza Shin", "shinliza@gmail.com", "0924-122-4567", "COECS", "On Leave"});
        staffData.add(new Object[]{"Angela Bernardo", "angebernardo@gmail.com", "0989-012-4617", "CBEE", "Active"});
        staffData.add(new Object[]{"Sofia Lim", "sofielim45@gmail.com", "0999-887-5615", "CAS", "Active"});
        staffData.add(new Object[]{"Kevin Flojo", "flojokev77@gmail.com", "0966-123-7890", "CASTECH", "Active"});
        staffData.add(new Object[]{"Rhea De Leon", "leonderhea32@gmail.com", "0909-412-0405", "COECS", "Retired"});
        staffData.add(new Object[]{"Mark Campos", "markcampos21@gmail.com", "0944-562-3461", "COECS", "Active"});

        refreshTable();
    }

    private void searchStaff() {
        String keyword = searchField.getText().trim().toLowerCase();
        tableModel.setRowCount(0);

        for (Object[] row : staffData) {
            for (Object cell : row) {
                if (cell != null && cell.toString().toLowerCase().contains(keyword)) {
                    tableModel.addRow(row);
                    break;
                }
            }
        }
    }

    private void refreshTable() {
        searchField.setText("");
        tableModel.setRowCount(0);

        for (Object[] row : staffData) {
            tableModel.addRow(row);
        }
    }
}