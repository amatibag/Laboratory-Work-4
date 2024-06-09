/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package motorph_mphcr.pkg01_g3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

/**
 *
 * @author amatibag
 */
public class ComputeSalary extends JFrame{
    JLabel employeeDetails;
    JLabel payDetails;

    public ComputeSalary(String[] rowData) {
        ImageIcon logo = new ImageIcon("logo.png"); // creates the logo
        ImageIcon smallLogo = new ImageIcon("SmallLogo.png"); // creates the small logo

        JLabel headerLabel = new JLabel(); // creates a label
        headerLabel.setText("Employee Salary Calculation Page"); // sets text for the label
        headerLabel.setIcon(smallLogo); // makes the motorPHHeader image visible on the label
        headerLabel.setHorizontalTextPosition(JLabel.CENTER); // sets the Horizontal position of the text with image icon
        headerLabel.setVerticalTextPosition(JLabel.TOP); // sets the Vertical position of the text with image icon
        headerLabel.setForeground(new Color(0xFFFFFF)); // sets the font color of the text
        headerLabel.setFont(new Font("Arial", Font.BOLD, 20)); // sets the font of the text
        headerLabel.setBackground(new Color(0x0E3171)); // sets the background color of the label
        headerLabel.setOpaque(true); // this will display background color
        headerLabel.setVerticalAlignment(JLabel.TOP); // sets the Vertical position of the headerLabel (icon + Text)
        headerLabel.setHorizontalAlignment(JLabel.CENTER); // sets the Horizontal position of the headerLabel (icon + Text)
        headerLabel.setBounds(0, 0, 633, 130); // sets the position of the entire label on the frame

        employeeDetails = new JLabel();
        employeeDetails.setText("   Employee #: " + rowData[0] + " | " + rowData[1] + ", " + rowData[2] + "   ");
        employeeDetails.setForeground(new Color(255, 255, 255, 255)); // sets the font color of the text
        employeeDetails.setFont(new Font("Arial", Font.BOLD, 15)); // sets the font of the text
        employeeDetails.setBackground(new Color(0x0E3171)); // sets the background color of the label
        employeeDetails.setOpaque(true); // this will display background color
        employeeDetails.setVerticalAlignment(JLabel.BOTTOM); // sets the Vertical position of the label (icon + Text)
        employeeDetails.setHorizontalAlignment(JLabel.CENTER); // sets the Horizontal position of the label (icon + Text)
        employeeDetails.setBounds(0, 0, 600, 20); // sets the position of the entire label on the frame

        payDetails = new JLabel();
        payDetails.setText("Basic Salary: " + rowData[13] + " | Gross Semi-monthly Rate: " + rowData[17] + " | Hourly Rate: " + rowData[18]);
        payDetails.setForeground(new Color(0x0E3171)); // sets the font color of the text
        payDetails.setFont(new Font("Arial", Font.BOLD, 11)); // sets the font of the text
        payDetails.setBackground(new Color(0xFFFFFF)); // sets the background color of the label
        payDetails.setOpaque(true); // this will display background color
        payDetails.setVerticalAlignment(JLabel.CENTER); // sets the Vertical position of the headerLabel (icon + Text)
        payDetails.setHorizontalAlignment(JLabel.CENTER); // sets the Horizontal position of the headerLabel (icon + Text)
        payDetails.setBounds(10, 227,600, 15); // sets the position of the entire label on the frame

        // Employee Details Panel
        JPanel employeeDetailsP = new JPanel(); // creates a panel for the dropdown list
        employeeDetailsP.setBackground(new Color(255, 255, 255, 255)); // sets the background color of the panel
        employeeDetailsP.setBounds(10, 135, 600, 25); // sets the position of the panel on the frame
        employeeDetailsP.add(employeeDetails); // add drop-down to the panel

        // Month and Year Panel
        JPanel monthYrPanel = new JPanel(new GridBagLayout());
        monthYrPanel.setBackground(new Color(255, 255, 255, 255)); // sets the background color of the panel

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Add some padding around components

        JLabel monthInst = new JLabel("Select Month:"); // creates a label to be added inside frameTitleP panel
        monthInst.setForeground(new Color(0x0E3171)); // sets the font color of the text
        monthInst.setFont(new Font("Arial", Font.ITALIC, 11)); // sets the font of the text

        JLabel yearInst = new JLabel("Enter Year (YYYY):"); // creates a label to be added inside frameTitleP panel
        yearInst.setForeground(new Color(0x0E3171)); // sets the font color of the text
        yearInst.setFont(new Font("Arial", Font.ITALIC, 11)); // sets the font of the text

        String[] monthName = {"January", "February", "March", "April", "May",
                "June", "July", "August", "September", "October", "November", "December"};
        JComboBox<String> monthBox = new JComboBox<>(monthName);

        Font inputFont = new Font("Arial", Font.PLAIN, 12); // Define a font for the inputs
        monthBox.setFont(inputFont); // Set the font for the combo box

        JTextField yr = new JTextField(4); // Set columns for the text field
        yr.setFont(inputFont); // Set the font for the text field

        // Add month label
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.LINE_END;
        monthYrPanel.add(monthInst, gbc);

        // Add month combo box
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.LINE_START;
        monthYrPanel.add(monthBox, gbc);

        // Add year label
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.LINE_END;
        monthYrPanel.add(yearInst, gbc);

        // Add year text field
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        monthYrPanel.add(yr, gbc);

        // Create a tabbed pane
        JTabbedPane tabbedPane = new JTabbedPane();

        // Create panels for each tab
        JPanel tab1 = new JPanel(new BorderLayout());
        tab1.add(new JLabel("Content for Pay with Monthly Rate"), BorderLayout.NORTH);

        JPanel tab2 = new JPanel();
        tab2.add(new JLabel("Content for Pay with Semi-Monthly Rate"));

        JPanel tab3 = new JPanel();
        tab3.add(new JLabel("Content for Pay with Hourly Rate"));

        // Add tabs to the tabbed pane
        tabbedPane.addTab("Pay with Monthly Rate", tab1);
        tabbedPane.addTab("Pay with Semi-Monthly Rate", tab2);
        tabbedPane.addTab("Pay with Hourly Rate", tab3);
        
        JButton back = new JButton("Select Another Employee");
        back.setBounds(220, 930, 190, 20);
        // Add the components to the frame
        setTitle("Motor PH - CP2 | Group 3: Employee Salary Calculation Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(633, 1000);
        setVisible(true);
        setIconImage(logo.getImage());
        getContentPane().setBackground(new Color(0x0E3171));
        setLayout(null);

        add(headerLabel);
        add(employeeDetailsP);
        add(payDetails);
        add(tabbedPane);
        add(monthYrPanel);
        add(back);

        // Set the bounds for the tabbed pane
        tabbedPane.setBounds(10, 243,600, 680); // Set the bounds for the tabbed pane

        // Adjust the position of employeeDetails label
        employeeDetails.setBounds(0, 135, 600, 25); // sets the position of the panel on the frame

        // Adjust the position of monthYrPanel
        monthYrPanel.setBounds(10, 160, 600, 65); // sets the position of the panel on the frame
        
        // Add an ActionListener to the back button
    back.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // Close the current frame
        dispose();
        // Open the EmployeeTable frame
        new EmployeeTable();
    }
});
    }
}