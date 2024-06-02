/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package motorph_mphcr.pkg01_g3;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author amatibag
 */
public class HomePage extends JFrame{
    
    HomePage(){ //contructor
        ImageIcon motorPHHeader = new ImageIcon("MotorPHHeader.png"); // inserts an image for the label
        ImageIcon logo = new ImageIcon("logo.png"); // creates the logo
        ImageIcon smallLogo = new ImageIcon("SmallLogo.png"); // creates the small logo

        JLabel headerLabel = new JLabel(); // creates a label
        headerLabel.setText("Motor PH - CP2 | Group 3: Home Page"); // sets text for the label
        headerLabel.setIcon(motorPHHeader); // makes the motorPHHeader image visible on the label
        headerLabel.setHorizontalTextPosition(JLabel.CENTER); // sets the Horizontal position of the text with image icon
        headerLabel.setVerticalTextPosition(JLabel.TOP); // sets the Vertical position of the text with image icon
        headerLabel.setForeground(new Color(0xFFFFFF)); // sets the font color of the text
        headerLabel.setFont(new Font("Arial", Font.BOLD, 30)); // sets the font of the text
        headerLabel.setBackground(new Color(0x0E3171)); // sets the background color of the label
        headerLabel.setOpaque(true); // this will display background color
        headerLabel.setVerticalAlignment(JLabel.TOP); // sets the Vertical position of the headerLabel (icon + Text)
        headerLabel.setHorizontalAlignment(JLabel.CENTER); // sets the Horizontal position of the headerLabel (icon + Text)
        headerLabel.setBounds(0, 2, 1265, 480); // sets the position of the entire label on the frame
        
        JLabel instructionLabel = new JLabel(); // creates a label
        instructionLabel.setText("Use the dropdown to select employee."); // sets text for the label
        instructionLabel.setForeground(new Color(0x0E3171)); // sets the font color of the text
        instructionLabel.setFont(new Font("Arial", Font.PLAIN, 15)); // sets the font of the text
        instructionLabel.setBackground(new Color(255, 255, 255, 200)); // sets the background color of the label
        instructionLabel.setOpaque(true); // this will display background color
        instructionLabel.setVerticalAlignment(JLabel.BOTTOM); // sets the Vertical position of the label (icon + Text)
        instructionLabel.setHorizontalAlignment(JLabel.CENTER); // sets the Horizontal position of the label (icon + Text)
        instructionLabel.setBounds(0, 485, 633, 30); // sets the position of the entire label on the frame
        
        // Create buttons
        JButton addButton = new JButton("Add Employee");
        JButton rehireButton = new JButton("Rehire Employee");
        JButton allReportsButton = new JButton("View All Payroll Reports");
        JButton viewButton = new JButton("View/Update Employee Details");
        JButton processButton = new JButton("Process Payroll");
        JButton recordButton = new JButton("View Payroll Records");
        JButton terminateButton = new JButton("Terminate Employee");
        
        JPanel motorPHGenericP = new JPanel(); // creates a panel for the dropdown list
        motorPHGenericP.setBackground(new Color(255, 255, 255, 200)); // sets the background color of the panel
        motorPHGenericP.setBounds(635, 515, 630, 520); // sets the position of the panel on the frame
        
        JLabel motorPHGenericL = new JLabel(); // creates a label
        motorPHGenericL.setText("Use the button to perform appropriate action for MotorPH maintainance."); // sets text for the label
        motorPHGenericL.setForeground(new Color(0x0E3171)); // sets the font color of the text
        motorPHGenericL.setFont(new Font("Arial", Font.PLAIN, 15)); // sets the font of the text
        motorPHGenericL.setBackground(new Color(255, 255, 255, 200)); // sets the background color of the label
        motorPHGenericL.setOpaque(true); // this will display background color
        motorPHGenericL.setVerticalAlignment(JLabel.BOTTOM); // sets the Vertical position of the label (icon + Text)
        motorPHGenericL.setHorizontalAlignment(JLabel.CENTER); // sets the Horizontal position of the label (icon + Text)
        motorPHGenericL.setBounds(635, 485, 630, 30); // sets the position of the entire label on the frame
        
        JPanel dropdownPanel = new JPanel(); // creates a panel for the dropdown list
        dropdownPanel.setBackground(new Color(255, 255, 255, 200)); // sets the background color of the panel
        dropdownPanel.setBounds(0, 515, 633, 520); // sets the position of the panel on the frame
        
         // Add buttons to the panel
         dropdownPanel.add(viewButton);
         dropdownPanel.add(processButton);
         dropdownPanel.add(recordButton);
         dropdownPanel.add(terminateButton);
         motorPHGenericP.add(rehireButton);
         motorPHGenericP.add(allReportsButton);
        
        // Create and add drop-down list to the panel
        JComboBox<String> employeeDropDown = createEmployeeDropDown();
        employeeDropDown.setBounds((dropdownPanel.getWidth() - 300) / 2, 40, 300, 30); // center horizontally
        dropdownPanel.setLayout(null); // set layout to null to use setBounds
        dropdownPanel.add(employeeDropDown); // add drop-down to the panel
        
        
        // Set up the frame
        this.setTitle("Motor PH - CP2 | Group 3: Home Page"); // sets the title for employee selection page
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit out of application
        this.setResizable(false); // prevent frame from being resized
        this.setSize(1265, 1000); // sets the x-dimension, and y-dimension of frame
        this.setLayout(null); // allows to define the position of the label by setbounds
        this.setVisible(true); // make frame visible-should be set on the end
        this.add(headerLabel); // add the employeeDDLabel on the frame
        this.add(instructionLabel);
        this.add(motorPHGenericL);
        this.setIconImage(logo.getImage()); // to apply the image icon named logo as the frame logo
        this.getContentPane().setBackground(new Color(0x0E3171)); // change color of background
        this.add(dropdownPanel);
        this.add(motorPHGenericP);

    }
    // Method to create the employee drop-down
    private JComboBox<String> createEmployeeDropDown() {
        ArrayList<String> employees = new ArrayList<>();
        for (int i = 0; i < EmployeeDetailsArray.employeeNo.size(); i++) {
            if ("Active".equals(EmployeeDetailsArray.employmentStatus.get(i))) {
                String fullName = EmployeeDetailsArray.employeeNo.get(i) + " - " + EmployeeDetailsArray.lastName.get(i) + ", " + EmployeeDetailsArray.firstName.get(i);
                employees.add(fullName);
            }
        }
        return new JComboBox<>(employees.toArray(new String[0]));
    }
}
    

