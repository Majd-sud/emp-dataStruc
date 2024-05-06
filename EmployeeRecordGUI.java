package structure_project;
import javax.swing.*;
import java.awt.*;

public class EmployeeRecordGUI extends JFrame {
    private JLabel idLabel, nameLabel, phoneLabel, addressLabel, hoursLabel, salaryLabel, firstDayLabel;
    private JTextField idField, nameField, phoneField, addressField, hoursField, salaryField, firstDayField;
    private JButton insertButton, deleteButton, updateButton, showButton;
    private JTextArea outputArea;

    private Structure_Project structureProject;

    public EmployeeRecordGUI() {
        this.structureProject = new Structure_Project();

        setTitle("Employee Record System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(10, 2, 5, 5)); // Use GridLayout for structured layout
        setSize(500, 600); // Set the JFrame size
        getContentPane().setBackground(new Color(220, 220, 220)); // Set the background color of the JFrame

        // Initialize components
        idLabel = createLabel("ID:");
        nameLabel = createLabel("Name:");
        phoneLabel = createLabel("Phone:");
        addressLabel = createLabel("Address:");
        hoursLabel = createLabel("Hours:");
        salaryLabel = createLabel("Salary:");
        firstDayLabel = createLabel("First Day:");

        idField = new JTextField(10);
        nameField = new JTextField(10);
        phoneField = new JTextField(10);
        addressField = new JTextField(10);
        hoursField = new JTextField(10);
        salaryField = new JTextField(10);
        firstDayField = new JTextField(10);

        insertButton = new JButton("Insert");
        deleteButton = new JButton("Delete");
        updateButton = new JButton("Update");
        showButton = new JButton("Show All");

        outputArea = new JTextArea(10, 30);
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        scrollPane.setPreferredSize(new Dimension(450, 100));

        // Add components to JFrame
        add(idLabel);
        add(idField);
        add(nameLabel);
        add(nameField);
        add(phoneLabel);
        add(phoneField);
        add(addressLabel);
        add(addressField);
        add(hoursLabel);
        add(hoursField);
        add(salaryLabel);
        add(salaryField);
        add(firstDayLabel);
        add(firstDayField);
        add(insertButton);
        add(deleteButton);
        add(updateButton);
        add(showButton);
        add(scrollPane);

        // Set up listeners for buttons
        insertButton.addActionListener(e -> insertRecord());
        deleteButton.addActionListener(e -> deleteRecord());
        updateButton.addActionListener(e -> updateRecord());
        showButton.addActionListener(e -> showAllRecords());

        // Display the JFrame
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JLabel createLabel(String text) {
        JLabel label = new JLabel(text);
        label.setOpaque(true);
        label.setBackground(new Color(169, 169, 169)); // Dark gray background
        label.setForeground(Color.WHITE); // White text
        return label;
    }

    private void insertRecord() {
        try {
            int id = Integer.parseInt(idField.getText());
            String name = nameField.getText();
            String firstDay = firstDayField.getText();
            int phone = Integer.parseInt(phoneField.getText());
            String address = addressField.getText();
            int hours = Integer.parseInt(hoursField.getText());
            double salary = Double.parseDouble(salaryField.getText());

            structureProject.InsertEmployeeRecord(id, name, firstDay, phone, address, hours, salary);
            outputArea.setText("Record Inserted Successfully");
        } catch (NumberFormatException nfe) {
            outputArea.setText("Error: Invalid number format");
        }
        clearFields();
    }

    private void deleteRecord() {
        try {
            int id = Integer.parseInt(idField.getText());
            int result = structureProject.DeleteEmployeeRecord(id);
            if (result == 0) {
                outputArea.setText("Record Deleted Successfully");
            } else {
                outputArea.setText("Error: Record not found");
            }
        } catch (NumberFormatException nfe) {
            outputArea.setText("Error: Invalid ID format");
        }
        clearFields();
    }

    private void updateRecord() {
        try {
            int id = Integer.parseInt(idField.getText());
            structureProject.updateEmployeeRecord(id);
            outputArea.setText("Record Updated Successfully");
        } catch (NumberFormatException nfe) {
            outputArea.setText("Error: Invalid ID format");
        }
        clearFields();
    }

    private void showAllRecords() {
        String allRecords = structureProject.ShowEmployeeDetails();
        outputArea.setText(allRecords);
    }

    private void clearFields() {
        idField.setText("");
        nameField.setText("");
        phoneField.setText("");
        addressField.setText("");
        hoursField.setText("");
        salaryField.setText("");
        firstDayField.setText("");
        idField.requestFocus();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new EmployeeRecordGUI());
    }
}
