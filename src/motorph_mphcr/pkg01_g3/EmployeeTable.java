/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package motorph_mphcr.pkg01_g3;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

public class EmployeeTable extends JFrame {
    
    
    EmployeeTable() { // constructor
        ImageIcon logo = new ImageIcon("logo.png"); // creates the logo
        ImageIcon motorPHHeader = new ImageIcon("MotorPHHeader.png"); // inserts an image for the label

        JLabel headerLabel = new JLabel(); // creates a label to be added inside frameTitleP panel
        headerLabel.setText("Motor PH - CP2 | Group 3: Employee Details Page"); // text that will be reflected on the frameTitleL Label
        headerLabel.setIcon(motorPHHeader); // adds the image on the JLabel frameTitleL
        headerLabel.setHorizontalTextPosition(JLabel.CENTER); // sets the Horizontal position of the text with image icon
        headerLabel.setVerticalTextPosition(JLabel.TOP); // sets the Vertical position of the text with image icon
        headerLabel.setForeground(new Color(0xFFFFFF)); // sets the font color of the text
        headerLabel.setFont(new Font("Arial", Font.BOLD, 30)); // sets the font of the text
        headerLabel.setBackground(new Color(0x0E3171)); // sets the background color of the label
        headerLabel.setOpaque(true); // this will display background color
        headerLabel.setVerticalAlignment(JLabel.TOP); // sets the Vertical position of the frameTitleL (icon + Text)
        headerLabel.setHorizontalAlignment(JLabel.CENTER); // sets the Horizontal position of the frameTitleL (icon + Text)
        headerLabel.setBounds(0, 2, 1265, 480); // sets the position of the entire label on the frame
        
        JLabel tableNote = new JLabel(); // creates a label to be added inside frameTitleP panel
        tableNote.setText("Click on specific row on the table below to select employee:"); // text that will be reflected on the frameTitleL Label
        tableNote.setForeground(new Color(0x0E3171)); // sets the font color of the text
        tableNote.setFont(new Font("Arial", Font.ITALIC, 14)); // sets the font of the text
        //tableNote.setBackground(new Color(0x0E3171)); // sets the background color of the label
        tableNote.setOpaque(true); // this will display background color
        tableNote.setVerticalAlignment(JLabel.CENTER); // sets the Vertical position of the frameTitleL (icon + Text)
        tableNote.setHorizontalAlignment(JLabel.CENTER); // sets the Horizontal position of the frameTitleL (icon + Text)
        tableNote.setBounds(0, 0, 1140, 20); // sets the position of the entire label on the frame
        
        JButton update = new JButton("Update");
        update.setBounds(35, 820, 190, 20);
        
        JButton delete = new JButton("Delete");
        delete.setBounds(255, 820, 190, 20);
        
        JButton calculate = new JButton("Calculate Salary");
        calculate.setBounds(475, 820, 190, 20);
        
        JButton clear = new JButton("Clear");
        clear.setBounds(695, 820, 190, 20);
        
        JButton add = new JButton("Add");
        add.setBounds(915, 820, 190, 20);
        
        JLabel employeeNumber = new JLabel("Employee Number:"); // creates a label to be added inside frameTitleP panel
        employeeNumber.setForeground(new Color(0x0E3171)); // sets the font color of the text
        employeeNumber.setFont(new Font("Arial", Font.PLAIN, 11)); // sets the font of the text
        employeeNumber.setOpaque(true); // this will display background color
        employeeNumber.setVerticalAlignment(JLabel.CENTER); // sets the Vertical position of the frameTitleL (icon + Text)
        employeeNumber.setHorizontalAlignment(JLabel.LEFT); // sets the Horizontal position of the frameTitleL (icon + Text)
        employeeNumber.setBounds(30, 455, 100, 15); // sets the position of the entire label on the frame
        
        JTextField employeNumber = new JTextField();
        employeNumber.setBounds(130, 453, 190, 19);
        
        JLabel basicSalary = new JLabel("Basic Salary:"); // creates a label to be added inside frameTitleP panel
        basicSalary.setForeground(new Color(0x0E3171)); // sets the font color of the text
        basicSalary.setFont(new Font("Arial", Font.PLAIN, 11)); // sets the font of the text
        basicSalary.setOpaque(true); // this will display background color
        basicSalary.setVerticalAlignment(JLabel.CENTER); // sets the Vertical position of the frameTitleL (icon + Text)
        basicSalary.setHorizontalAlignment(JLabel.LEFT); // sets the Horizontal position of the frameTitleL (icon + Text)
        basicSalary.setBounds(350, 455, 170, 15); // sets the position of the entire label on the frame
        
        JTextField basic = new JTextField();
        basic.setBounds(480, 453, 100, 19);
       
        JLabel lastName = new JLabel("Last Name:"); // creates a label to be added inside frameTitleP panel
        lastName.setForeground(new Color(0x0E3171)); // sets the font color of the text
        lastName.setFont(new Font("Arial", Font.PLAIN, 11)); // sets the font of the text
        lastName.setOpaque(true); // this will display background color
        lastName.setVerticalAlignment(JLabel.CENTER); // sets the Vertical position of the frameTitleL (icon + Text)
        lastName.setHorizontalAlignment(JLabel.LEFT); // sets the Horizontal position of the frameTitleL (icon + Text)
        lastName.setBounds(30, 480, 100, 15); // sets the position of the entire label on the frame

        JTextField lasName = new JTextField();
        lasName.setBounds(130, 478, 190, 19);
        
        JLabel riceSubsidy = new JLabel("Rice Subsidy:"); // creates a label to be added inside frameTitleP panel
        riceSubsidy.setForeground(new Color(0x0E3171)); // sets the font color of the text
        riceSubsidy.setFont(new Font("Arial", Font.PLAIN, 11)); // sets the font of the text
        riceSubsidy.setOpaque(true); // this will display background color
        riceSubsidy.setVerticalAlignment(JLabel.CENTER); // sets the Vertical position of the frameTitleL (icon + Text)
        riceSubsidy.setHorizontalAlignment(JLabel.LEFT); // sets the Horizontal position of the frameTitleL (icon + Text)
        riceSubsidy.setBounds(350, 480, 170, 15); // sets the position of the entire label on the frame
        
        JTextField rice = new JTextField();
        rice.setBounds(480, 478, 100, 19);
        
        JLabel firstName = new JLabel("First Name:"); // creates a label to be added inside frameTitleP panel
        firstName.setForeground(new Color(0x0E3171)); // sets the font color of the text
        firstName.setFont(new Font("Arial", Font.PLAIN, 11)); // sets the font of the text
        firstName.setOpaque(true); // this will display background color
        firstName.setVerticalAlignment(JLabel.CENTER); // sets the Vertical position of the frameTitleL (icon + Text)
        firstName.setHorizontalAlignment(JLabel.LEFT); // sets the Horizontal position of the frameTitleL (icon + Text)
        firstName.setBounds(30, 505, 100, 15); // sets the position of the entire label on the frame
        
        JTextField firsName = new JTextField();
        firsName.setBounds(130, 503, 190, 19);
        
        JLabel phoneAllowance = new JLabel("Phone Allowance:"); // creates a label to be added inside frameTitleP panel
        phoneAllowance.setForeground(new Color(0x0E3171)); // sets the font color of the text
        phoneAllowance.setFont(new Font("Arial", Font.PLAIN, 11)); // sets the font of the text
        phoneAllowance.setOpaque(true); // this will display background color
        phoneAllowance.setVerticalAlignment(JLabel.CENTER); // sets the Vertical position of the frameTitleL (icon + Text)
        phoneAllowance.setHorizontalAlignment(JLabel.LEFT); // sets the Horizontal position of the frameTitleL (icon + Text)
        phoneAllowance.setBounds(350, 505, 170, 15); // sets the position of the entire label on the frame
        
        JTextField phone = new JTextField();
        phone.setBounds(480, 503, 100, 19);
        
        JLabel birthday = new JLabel("Birthday:"); // creates a label to be added inside frameTitleP panel
        birthday.setForeground(new Color(0x0E3171)); // sets the font color of the text
        birthday.setFont(new Font("Arial", Font.PLAIN, 11)); // sets the font of the text
        birthday.setOpaque(true); // this will display background color
        birthday.setVerticalAlignment(JLabel.CENTER); // sets the Vertical position of the frameTitleL (icon + Text)
        birthday.setHorizontalAlignment(JLabel.LEFT); // sets the Horizontal position of the frameTitleL (icon + Text)
        birthday.setBounds(30, 530, 100, 15); // sets the position of the entire label on the frame
        
        JTextField birhday = new JTextField();
        birhday.setBounds(130, 528, 190, 19);
        
        JLabel clothingAllowance = new JLabel("Clothing Allowance:"); // creates a label to be added inside frameTitleP panel
        clothingAllowance.setForeground(new Color(0x0E3171)); // sets the font color of the text
        clothingAllowance.setFont(new Font("Arial", Font.PLAIN, 11)); // sets the font of the text
        clothingAllowance.setOpaque(true); // this will display background color
        clothingAllowance.setVerticalAlignment(JLabel.CENTER); // sets the Vertical position of the frameTitleL (icon + Text)
        clothingAllowance.setHorizontalAlignment(JLabel.LEFT); // sets the Horizontal position of the frameTitleL (icon + Text)
        clothingAllowance.setBounds(350, 530, 170, 15); // sets the position of the entire label on the frame
        
        JTextField clothing = new JTextField();
        clothing.setBounds(480, 528, 100, 19);
        
        JLabel address = new JLabel("Address:"); // creates a label to be added inside frameTitleP panel
        address.setForeground(new Color(0x0E3171)); // sets the font color of the text
        address.setFont(new Font("Arial", Font.PLAIN, 11)); // sets the font of the text
        address.setOpaque(true); // this will display background color
        address.setVerticalAlignment(JLabel.CENTER); // sets the Vertical position of the frameTitleL (icon + Text)
        address.setHorizontalAlignment(JLabel.LEFT); // sets the Horizontal position of the frameTitleL (icon + Text)
        address.setBounds(30, 555, 100, 50); // sets the position of the entire label on the frame

        JTextArea adress = new JTextArea();
        adress.setLineWrap(true); // Enable line wrapping
        adress.setWrapStyleWord(true); // Wrap at word boundaries
        adress.setCaretPosition(0); // Set cursor to the beginning

        // Create a new JScrollPane for the address JTextArea
        JScrollPane addressScrollPane = new JScrollPane(adress);
        addressScrollPane.setBounds(130, 553, 190, 54); // Set bounds for the JScrollPane
        
        JLabel grossSMrate = new JLabel("Gross Semi-monthly Rate:"); // creates a label to be added inside frameTitleP panel
        grossSMrate.setForeground(new Color(0x0E3171)); // sets the font color of the text
        grossSMrate.setFont(new Font("Arial", Font.PLAIN, 11)); // sets the font of the text
        grossSMrate.setOpaque(true); // this will display background color
        grossSMrate.setVerticalAlignment(JLabel.CENTER); // sets the Vertical position of the frameTitleL (icon + Text)
        grossSMrate.setHorizontalAlignment(JLabel.LEFT); // sets the Horizontal position of the frameTitleL (icon + Text)
        grossSMrate.setBounds(350, 555, 170, 15); // sets the position of the entire label on the frame
        
        JTextField grossSM = new JTextField();
        grossSM.setBounds(480, 553, 100, 19);
        
        JLabel phoneNo = new JLabel("Phone Number:"); // creates a label to be added inside frameTitleP panel
        phoneNo.setForeground(new Color(0x0E3171)); // sets the font color of the text
        phoneNo.setFont(new Font("Arial", Font.PLAIN, 11)); // sets the font of the text
        phoneNo.setOpaque(true); // this will display background color
        phoneNo.setVerticalAlignment(JLabel.CENTER); // sets the Vertical position of the frameTitleL (icon + Text)
        phoneNo.setHorizontalAlignment(JLabel.LEFT); // sets the Horizontal position of the frameTitleL (icon + Text)
        phoneNo.setBounds(30, 615, 100, 15); // sets the position of the entire label on the frame
        
        JTextField phonNo = new JTextField();
        phonNo.setBounds(130, 613, 190, 19);
        
        JLabel hourlyRate = new JLabel("Hourly Rate:"); // creates a label to be added inside frameTitleP panel
        hourlyRate.setForeground(new Color(0x0E3171)); // sets the font color of the text
        hourlyRate.setFont(new Font("Arial", Font.PLAIN, 11)); // sets the font of the text
        hourlyRate.setOpaque(true); // this will display background color
        hourlyRate.setVerticalAlignment(JLabel.CENTER); // sets the Vertical position of the frameTitleL (icon + Text)
        hourlyRate.setHorizontalAlignment(JLabel.LEFT); // sets the Horizontal position of the frameTitleL (icon + Text)
        hourlyRate.setBounds(350, 580, 170, 15); // sets the position of the entire label on the frame
        
        JTextField hourly = new JTextField();
        hourly.setBounds(480, 578, 100, 19);
        
        JLabel sssNo = new JLabel("SSS Number:"); // creates a label to be added inside frameTitleP panel
        sssNo.setForeground(new Color(0x0E3171)); // sets the font color of the text
        sssNo.setFont(new Font("Arial", Font.PLAIN, 11)); // sets the font of the text
        sssNo.setOpaque(true); // this will display background color
        sssNo.setVerticalAlignment(JLabel.CENTER); // sets the Vertical position of the frameTitleL (icon + Text)
        sssNo.setHorizontalAlignment(JLabel.LEFT); // sets the Horizontal position of the frameTitleL (icon + Text)
        sssNo.setBounds(30, 640, 100, 15); // sets the position of the entire label on the frame

        JTextField ssNo = new JTextField();
        ssNo.setBounds(130, 638, 190, 19);
        
        JLabel philHealthNo = new JLabel("Philhealth Number:"); // creates a label to be added inside frameTitleP panel
        philHealthNo.setForeground(new Color(0x0E3171)); // sets the font color of the text
        philHealthNo.setFont(new Font("Arial", Font.PLAIN, 11)); // sets the font of the text
        philHealthNo.setOpaque(true); // this will display background color
        philHealthNo.setVerticalAlignment(JLabel.CENTER); // sets the Vertical position of the frameTitleL (icon + Text)
        philHealthNo.setHorizontalAlignment(JLabel.LEFT); // sets the Horizontal position of the frameTitleL (icon + Text)
        philHealthNo.setBounds(30, 665, 100, 15); // sets the position of the entire label on the frame        
        
        JTextField philHealtNo = new JTextField();
        philHealtNo.setBounds(130, 663, 190, 19);
        
        JLabel tinNo = new JLabel("TIN Number:"); // creates a label to be added inside frameTitleP panel
        tinNo.setForeground(new Color(0x0E3171)); // sets the font color of the text
        tinNo.setFont(new Font("Arial", Font.PLAIN, 11)); // sets the font of the text
        tinNo.setOpaque(true); // this will display background color
        tinNo.setVerticalAlignment(JLabel.CENTER); // sets the Vertical position of the frameTitleL (icon + Text)
        tinNo.setHorizontalAlignment(JLabel.LEFT); // sets the Horizontal position of the frameTitleL (icon + Text)
        tinNo.setBounds(30, 690, 100, 15); // sets the position of the entire label on the frame 
        
        JTextField tinN = new JTextField();
        tinN.setBounds(130, 688, 190, 19);
        
        JLabel pagibigNo = new JLabel("Pag-ibig Number:"); // creates a label to be added inside frameTitleP panel
        pagibigNo.setForeground(new Color(0x0E3171)); // sets the font color of the text
        pagibigNo.setFont(new Font("Arial", Font.PLAIN, 11)); // sets the font of the text
        pagibigNo.setOpaque(true); // this will display background color
        pagibigNo.setVerticalAlignment(JLabel.CENTER); // sets the Vertical position of the frameTitleL (icon + Text)
        pagibigNo.setHorizontalAlignment(JLabel.LEFT); // sets the Horizontal position of the frameTitleL (icon + Text)
        pagibigNo.setBounds(30, 715, 100, 15); // sets the position of the entire label on the frame  
        
        JTextField pagibigN = new JTextField();
        pagibigN.setBounds(130, 713, 190, 19);
        
        JLabel status = new JLabel("Status:"); // creates a label to be added inside frameTitleP panel
        status.setForeground(new Color(0x0E3171)); // sets the font color of the text
        status.setFont(new Font("Arial", Font.PLAIN, 11)); // sets the font of the text
        status.setOpaque(true); // this will display background color
        status.setVerticalAlignment(JLabel.CENTER); // sets the Vertical position of the frameTitleL (icon + Text)
        status.setHorizontalAlignment(JLabel.LEFT); // sets the Horizontal position of the frameTitleL (icon + Text)
        status.setBounds(30, 740, 100, 15); // sets the position of the entire label on the frame  
        
        JTextField stat = new JTextField();
        stat.setBounds(130, 738, 190, 19);

        JLabel position = new JLabel("Position:"); // creates a label to be added inside frameTitleP panel
        position.setForeground(new Color(0x0E3171)); // sets the font color of the text
        position.setFont(new Font("Arial", Font.PLAIN, 11)); // sets the font of the text
        position.setOpaque(true); // this will display background color
        position.setVerticalAlignment(JLabel.CENTER); // sets the Vertical position of the frameTitleL (icon + Text)
        position.setHorizontalAlignment(JLabel.LEFT); // sets the Horizontal position of the frameTitleL (icon + Text)
        position.setBounds(30, 765, 100, 15); // sets the position of the entire label on the frame  
        
        JTextField post = new JTextField();
        post.setBounds(130, 763, 190, 19);
        
        JLabel sup = new JLabel("Supervisor:"); // creates a label to be added inside frameTitleP panel
        sup.setForeground(new Color(0x0E3171)); // sets the font color of the text
        sup.setFont(new Font("Arial", Font.PLAIN, 11)); // sets the font of the text
        sup.setOpaque(true); // this will display background color
        sup.setVerticalAlignment(JLabel.CENTER); // sets the Vertical position of the frameTitleL (icon + Text)
        sup.setHorizontalAlignment(JLabel.LEFT); // sets the Horizontal position of the frameTitleL (icon + Text)
        sup.setBounds(30, 790, 100, 15); // sets the position of the entire label on the frame 
        
        JTextField supvsr = new JTextField();
        supvsr.setBounds(130, 788, 190, 19);
        
        JPanel bodyP = new JPanel();
        bodyP.setBackground(new Color(255, 255, 255, 250)); // sets the background color of the panel
        bodyP.setBounds(50, 110, 1140, 850); // sets the position of the panel
        bodyP.setLayout(null); // Using null layout for precise control

        // Read CSV and populate data into JTable
        String csvFile = "motorPHEmployeeList.csv";
        DefaultTableModel model = new DefaultTableModel();
        JTable table = new JTable(model);

        // Custom table header renderer
        JTableHeader tableHeader = table.getTableHeader();
        tableHeader.setDefaultRenderer(new HeaderRenderer());

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(1140, 402));
        scrollPane.setBounds(0, 20, 1140, 422); // Set bounds for the JScrollPane

        // Define the specific columns to include
        List<String> desiredColumns = List.of("Employee Number", "Last Name", "First Name", "SSS Number", "Philhealth Number", "TIN Number", "Pag-ibig Number");
        List<Integer> columnIndices = new ArrayList<>();

        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            // Read headers
            line = br.readLine();
            String[] headers = line.split(",");
            for (int i = 0; i < headers.length; i++) {
                if (desiredColumns.contains(headers[i].trim())) {
                    model.addColumn(headers[i].trim());
                    columnIndices.add(i);
                }
            }

            // Read data and add to table
            while ((line = br.readLine()) != null) {
                String[] rowData = line.split(",");
                List<String> selectedData = new ArrayList<>();
                for (int index : columnIndices) {
                    selectedData.add(rowData[index]);
                }
                model.addRow(selectedData.toArray());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
// Add this after populating the table
table.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent e) {
        int row = table.getSelectedRow();
        String selectedEmployeeNumber = (String) table.getValueAt(row, 0); // Assuming the employee number is in the first column

        // Retrieve data from the CSV file for the selected employee number
        String csvFile = "motorPHEmployeeList.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            // Skip headers
            br.readLine();
            // Read data and find the row with the selected employee number
            while ((line = br.readLine()) != null) {
                String[] rowData = line.split(",");
                if (selectedEmployeeNumber.equals(rowData[0].trim())) { // Assuming employee number is in the first column
                    // Populate the JTextFields with data from the CSV file
                    employeNumber.setText(rowData[0].trim());
                    lasName.setText(rowData[1].trim());
                    firsName.setText(rowData[2].trim());
                    birhday.setText(rowData[3].trim());
                    adress.setText(rowData[4].trim());
                    phonNo.setText(rowData[5].trim());
                    ssNo.setText(rowData[6].trim());
                    philHealtNo.setText(rowData[7].trim());
                    tinN.setText(rowData[8].trim());
                    pagibigN.setText(rowData[9].trim());
                    stat.setText(rowData[10].trim());
                    post.setText(rowData[11].trim());
                    supvsr.setText(rowData[12].trim());
                    basic.setText(rowData[13].trim());
                    rice.setText(rowData[14].trim());
                    phone.setText(rowData[15].trim());
                    clothing.setText(rowData[16].trim());
                    grossSM.setText(rowData[17].trim());
                    hourly.setText(rowData[18].trim());
                    break; // No need to continue reading the file
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
});

        clear.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // Clear the selection in the table
        table.clearSelection();

        // Clear the JTextFields
        employeNumber.setText("");
        lasName.setText("");
        firsName.setText("");
        birhday.setText("");
        adress.setText("");
        phonNo.setText("");
        ssNo.setText("");
        philHealtNo.setText("");
        tinN.setText("");
        pagibigN.setText("");
        stat.setText("");
        post.setText("");
        supvsr.setText("");
        basic.setText("");
        rice.setText("");
        phone.setText("");
        clothing.setText("");
        grossSM.setText("");
        hourly.setText("");
    }
});
        

update.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // Check if a row is selected
        if (table.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(EmployeeTable.this, "Please select an employee from the table.", "No Employee Selected", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Check for empty fields
        if (employeNumber.getText().isEmpty() || lasName.getText().isEmpty() || firsName.getText().isEmpty() ||
                birhday.getText().isEmpty() || adress.getText().isEmpty() || phonNo.getText().isEmpty() ||
                ssNo.getText().isEmpty() || philHealtNo.getText().isEmpty() || tinN.getText().isEmpty() ||
                pagibigN.getText().isEmpty() || stat.getText().isEmpty() || post.getText().isEmpty() ||
                supvsr.getText().isEmpty() || basic.getText().isEmpty() || rice.getText().isEmpty() ||
                phone.getText().isEmpty() || clothing.getText().isEmpty() || grossSM.getText().isEmpty() ||
                hourly.getText().isEmpty()) {
            JOptionPane.showMessageDialog(EmployeeTable.this, "Please fill in all fields.", "Empty Fields", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Check for commas in text fields
        if (employeNumber.getText().contains(",") || lasName.getText().contains(",") || firsName.getText().contains(",") ||
                birhday.getText().contains(",") || adress.getText().contains(",") || phonNo.getText().contains(",") ||
                ssNo.getText().contains(",") || philHealtNo.getText().contains(",") || tinN.getText().contains(",") ||
                pagibigN.getText().contains(",") || stat.getText().contains(",") || post.getText().contains(",") ||
                supvsr.getText().contains(",") || basic.getText().contains(",") || rice.getText().contains(",") ||
                phone.getText().contains(",") || clothing.getText().contains(",") || grossSM.getText().contains(",") ||
                hourly.getText().contains(",")) {
            JOptionPane.showMessageDialog(EmployeeTable.this, "Comma (',') cannot be used in fields.", "Invalid Character", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Get the selected row index
        int selectedRowIndex = table.getSelectedRow();

        // Get the employee number of the selected row
        String selectedEmployeeNumber = (String) table.getValueAt(selectedRowIndex, 0);

        // Read the CSV file and check for duplicates
        String csvFile = "motorPHEmployeeList.csv";
        List<String> lines = new ArrayList<>();
        Set<String> employeeNumbers = new HashSet<>();
        Set<String> sssNumbers = new HashSet<>();
        Set<String> philhealthNumbers = new HashSet<>();
        Set<String> tinNumbers = new HashSet<>();
        Set<String> pagibigNumbers = new HashSet<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] rowData = line.split(",");
                if (!selectedEmployeeNumber.equals(rowData[0].trim())) {
                    employeeNumbers.add(rowData[0].trim());
                    sssNumbers.add(rowData[6].trim());
                    philhealthNumbers.add(rowData[7].trim());
                    tinNumbers.add(rowData[8].trim());
                    pagibigNumbers.add(rowData[9].trim());
                }
                lines.add(line);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(EmployeeTable.this, "Failed to update employee data.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Check for duplicate values
        if (employeeNumbers.contains(employeNumber.getText().trim()) ||
            sssNumbers.contains(ssNo.getText().trim()) ||
            philhealthNumbers.contains(philHealtNo.getText().trim()) ||
            tinNumbers.contains(tinN.getText().trim()) ||
            pagibigNumbers.contains(pagibigN.getText().trim())) {
            JOptionPane.showMessageDialog(EmployeeTable.this, "Duplicate value found. Update not allowed.", "Duplicate Entry", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Update the corresponding row
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            lines.clear();
            while ((line = br.readLine()) != null) {
                String[] rowData = line.split(",");
                if (selectedEmployeeNumber.equals(rowData[0].trim())) {
                    // Update the row with new data from JTextFields and JTextArea
                    rowData[0] = employeNumber.getText();
                    rowData[1] = lasName.getText();
                    rowData[2] = firsName.getText();
                    rowData[3] = birhday.getText();
                    rowData[4] = adress.getText();
                    rowData[5] = phonNo.getText();
                    rowData[6] = ssNo.getText();
                    rowData[7] = philHealtNo.getText();
                    rowData[8] = tinN.getText();
                    rowData[9] = pagibigN.getText();
                    rowData[10] = stat.getText();
                    rowData[11] = post.getText();
                    rowData[12] = supvsr.getText();
                    rowData[13] = basic.getText();
                    rowData[14] = rice.getText();
                    rowData[15] = phone.getText();
                    rowData[16] = clothing.getText();
                    rowData[17] = grossSM.getText();
                    rowData[18] = hourly.getText();
                }
                lines.add(String.join(",", rowData));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(EmployeeTable.this, "Failed to update employee data.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Write the updated data back to the CSV file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFile))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
            JOptionPane.showMessageDialog(EmployeeTable.this, "Employee data updated successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(EmployeeTable.this, "Failed to update employee data.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        // Refresh the JTable by reloading the data
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // Clear the existing rows
        refreshTable(model); // Load the updated data into the table
        table.clearSelection();

        // Clear the JTextFields
        employeNumber.setText("");
        lasName.setText("");
        firsName.setText("");
        birhday.setText("");
        adress.setText("");
        phonNo.setText("");
        ssNo.setText("");
        philHealtNo.setText("");
        tinN.setText("");
        pagibigN.setText("");
        stat.setText("");
        post.setText("");
        supvsr.setText("");
        basic.setText("");
        rice.setText("");
        phone.setText("");
        clothing.setText("");
        grossSM.setText("");
        hourly.setText("");
    }
});

        delete.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // Check if a row is selected
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(EmployeeTable.this, "Please select a row to delete.", "No Row Selected", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Get the employee number and last name of the selected row
        String employeeNumber = (String) table.getValueAt(selectedRow, 0);
        String lastName = (String) table.getValueAt(selectedRow, 1);

        // Remove row from motorPHEmployeeList.csv
        removeRowFromCSV("motorPHEmployeeList.csv", employeeNumber, lastName);

        // Remove row from password.csv
        removeRowFromCSV("password.csv", employeeNumber, lastName);

        // Remove row from the table
        model.removeRow(selectedRow);
        table.clearSelection();

        // Clear the JTextFields
        employeNumber.setText("");
        lasName.setText("");
        firsName.setText("");
        birhday.setText("");
        adress.setText("");
        phonNo.setText("");
        ssNo.setText("");
        philHealtNo.setText("");
        tinN.setText("");
        pagibigN.setText("");
        stat.setText("");
        post.setText("");
        supvsr.setText("");
        basic.setText("");
        rice.setText("");
        phone.setText("");
        clothing.setText("");
        grossSM.setText("");
        hourly.setText("");
    
    }
});
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Validate fields
                JTextField[] fields = {employeNumber, lasName, firsName, birhday, phonNo, ssNo, philHealtNo, tinN, pagibigN, stat, post, supvsr, basic, rice, phone, clothing, grossSM, hourly};
                for (JTextField field : fields) {
                    if (field.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(EmployeeTable.this, "Please fill in all fields.", "Empty Fields", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    if (field.getText().contains(",")) {
                        JOptionPane.showMessageDialog(EmployeeTable.this, "Comma (',') cannot be used in fields.", "Invalid Character", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }
                if (adress.getText().isEmpty() || adress.getText().contains(",")) {
                    JOptionPane.showMessageDialog(EmployeeTable.this, "Please fill in the address field without commas.", "Invalid Character", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Check for duplicate values
                Set<String> uniqueValues = new HashSet<>();
                String[] uniqueColumns = {employeNumber.getText(), ssNo.getText(), philHealtNo.getText(), tinN.getText(), pagibigN.getText()};
                for (String columnValue : uniqueColumns) {
                    if (!uniqueValues.add(columnValue)) {
                        JOptionPane.showMessageDialog(EmployeeTable.this, "Duplicate value found: " + columnValue, "Duplicate Entry", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }

                // Add to motorPHEmployeeList.csv
                try (BufferedWriter writer = new BufferedWriter(new FileWriter("motorPHEmployeeList.csv", true))) {
                    writer.write(String.join(",", employeNumber.getText(), lasName.getText(), firsName.getText(), birhday.getText(), adress.getText(),
                            phonNo.getText(), ssNo.getText(), philHealtNo.getText(), tinN.getText(), pagibigN.getText(), stat.getText(), post.getText(),
                            supvsr.getText(), basic.getText(), rice.getText(), phone.getText(), clothing.getText(), grossSM.getText(), hourly.getText()));
                    writer.newLine();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(EmployeeTable.this, "Failed to add employee data.", "Error", JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                    return;
                }

                // Update password.csv
                try (BufferedWriter writer = new BufferedWriter(new FileWriter("password.csv", true))) {
                    writer.write(employeNumber.getText() + "," + lasName.getText() + "," + "motorPH" + employeNumber.getText());
                    writer.newLine();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(EmployeeTable.this, "Failed to update password data.", "Error", JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                    return;
                }

                // Refresh the table
                model.addRow(new Object[]{employeNumber.getText(), lasName.getText(), firsName.getText(), ssNo.getText(), philHealtNo.getText(), tinN.getText(), pagibigN.getText()});
                JOptionPane.showMessageDialog(EmployeeTable.this, "Employee data added successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        });
     
        bodyP.add(scrollPane);
        bodyP.add(tableNote); // Add tableNote to the bodyP panel
        bodyP.add(employeeNumber); bodyP.add(lastName); bodyP.add(firstName); bodyP.add(birthday); bodyP.add(address); bodyP.add(phoneNo);
        bodyP.add(sssNo); bodyP.add(philHealthNo); bodyP.add(tinNo); bodyP.add(pagibigNo); bodyP.add(status); bodyP.add(position); bodyP.add(sup);
        bodyP.add(basicSalary); bodyP.add(riceSubsidy); bodyP.add(phoneAllowance); bodyP.add(clothingAllowance); bodyP.add(grossSMrate);
        bodyP.add(hourlyRate);
        
        bodyP.add(employeNumber); bodyP.add(lasName); bodyP.add(firsName); bodyP.add(birhday); bodyP.add(addressScrollPane);
        bodyP.add(phonNo); bodyP.add(ssNo); bodyP.add(philHealtNo); bodyP.add(tinN); bodyP.add(pagibigN); bodyP.add(stat);
        bodyP.add(post); bodyP.add(supvsr); bodyP.add(basic); bodyP.add(rice); bodyP.add(phone); bodyP.add(clothing); bodyP.add(grossSM); bodyP.add(hourly); 
 
        bodyP.add(update); bodyP.add(delete); bodyP.add(calculate); bodyP.add(clear); bodyP.add(add);
        
        // this is the name of the frame
        this.setTitle("Motor PH - CP2 | Group 3: Employee Details Page"); // sets the title for employee selection page
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit out of application
        this.setResizable(false); // prevent frame from being resized
        this.setSize(1265, 1000); // sets the x-dimension, and y-dimension of frame
        this.setLayout(null); // allows to define the position of the label by setBounds
        this.setVisible(true); // make frame visible-should be set on the end

        this.setIconImage(logo.getImage()); // to apply the image icon named logo as the frame logo
        this.getContentPane().setBackground(new Color(0x0E3171)); // change color of background
        // options: Color.red; new Color(14,49,113); new Color(0x0HEX)
        // this.pack(); // can be used to automatically adjust the size of the frame depending on what it contains
        // note if pack function is used no need to use setBounds, setResizable, setSize and setLayout
        // make sure that all components are added before using the pack

        this.add(bodyP); // adds the panel on the frame
        this.add(headerLabel); // adds the panel on the frame
    }

    // Custom header renderer class
    static class HeaderRenderer extends JButton implements TableCellRenderer {

        public HeaderRenderer() {
            setFont(new Font("Arial", Font.BOLD, 12));
            setForeground(Color.WHITE);
            setBackground(new Color(0x0E3171));
            setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createRaisedBevelBorder(),
                    BorderFactory.createEmptyBorder(4, 4, 4, 4)
            ));
            setFocusPainted(false);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setText(value.toString());
            return this;
        }
    }
    // Method to load data into the JTable
private void refreshTable(DefaultTableModel model) {
    String csvFile = "motorPHEmployeeList.csv";
    try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
        // Skip the header line
        br.readLine();
        
        String line;
        while ((line = br.readLine()) != null) {
            String[] rowData = line.split(",");
            model.addRow(rowData);
        }
    } catch (IOException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(EmployeeTable.this, "Failed to load employee data.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}
private void removeRowFromCSV(String filename, String employeeNumber, String lastName) {
    try {
        List<String> lines = Files.readAllLines(Paths.get(filename));
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        for (String line : lines) {
            String[] data = line.split(",");
            // Check if the row matches the employee number and last name
            if (!(data[0].equals(employeeNumber) && data[1].equals(lastName))) {
                writer.write(line + "\n");
            }
        }
        writer.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
}


}