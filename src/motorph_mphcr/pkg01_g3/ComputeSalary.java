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
import javax.swing.JCheckBox;
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
        
        // Retrieve non-taxable benefits from rowData
        String riceSubsidy = rowData[14]; // 15th column
        String phoneAllowance = rowData[15]; // 16th column
        String clothingAllowance = rowData[16]; // 17th column
        
        //tab1 content:
        JLabel header1 = new JLabel("<html><u>Calculate salary based on Monthly Rate:</u></html>");
        header1.setForeground(new Color(0x0E3171)); // sets the font color of the text
        header1.setFont(new Font("Arial", Font.ITALIC, 12)); // sets the font of the text
        header1.setOpaque(true); // this will display background color
        header1.setVerticalAlignment(JLabel.CENTER); // sets the Vertical position of the frameTitleL (icon + Text)
        header1.setHorizontalAlignment(JLabel.LEFT); // sets the Horizontal position of the frameTitleL (icon + Text)
        header1.setBounds(5, 5, 350, 20); // sets the position of the entire label on the frame
        
        JLabel adjEarnings1 = new JLabel("Enter amount of adjustment on Taxable Earnings:"); // creates a label to be added inside frameTitleP panel
        adjEarnings1.setForeground(new Color(0x0E3171)); // sets the font color of the text
        adjEarnings1.setFont(new Font("Arial", Font.BOLD, 12)); // sets the font of the text
        adjEarnings1.setOpaque(true); // this will display background color
        adjEarnings1.setVerticalAlignment(JLabel.CENTER); // sets the Vertical position of the frameTitleL (icon + Text)
        adjEarnings1.setHorizontalAlignment(JLabel.LEFT); // sets the Horizontal position of the frameTitleL (icon + Text)
        adjEarnings1.setBounds(5, 25, 350, 20); // sets the position of the entire label on the frame
        
        JTextField adjEarning1 = new JTextField();
        adjEarning1.setBounds(360, 25, 75, 20);
        
        JLabel oThours1 = new JLabel("Enter overtime hours if applicable: "); // creates a label to be added inside frameTitleP panel
        oThours1.setForeground(new Color(0x0E3171)); // sets the font color of the text
        oThours1.setFont(new Font("Arial", Font.BOLD, 12)); // sets the font of the text
        oThours1.setOpaque(true); // this will display background color
        oThours1.setVerticalAlignment(JLabel.CENTER); // sets the Vertical position of the frameTitleL (icon + Text)
        oThours1.setHorizontalAlignment(JLabel.LEFT); // sets the Horizontal position of the frameTitleL (icon + Text)
        oThours1.setBounds(5, 50, 350, 20); // sets the position of the entire label on the frame
        
        JTextField otDur1 = new JTextField();
        otDur1.setBounds(360, 50, 75, 20);
       
        JLabel otRate1 = new JLabel("Enter overtime rate in decimal form (sample 1.25 for 125%):"); // creates a label to be added inside frameTitleP panel
        otRate1.setForeground(new Color(0x0E3171)); // sets the font color of the text
        otRate1.setFont(new Font("Arial", Font.BOLD, 12)); // sets the font of the text
        otRate1.setOpaque(true); // this will display background color
        otRate1.setVerticalAlignment(JLabel.CENTER); // sets the Vertical position of the frameTitleL (icon + Text)
        otRate1.setHorizontalAlignment(JLabel.LEFT); // sets the Horizontal position of the frameTitleL (icon + Text)
        otRate1.setBounds(5, 75, 350, 20); // sets the position of the entire label on the frame

        JTextField otPay1 = new JTextField();
        otPay1.setBounds(360, 75, 75, 20);
        
        
        
        // Create the JCheckBox with the retrieved benefits
       JCheckBox benefits1 = new JCheckBox("<html>" +
             "<style>" +
            "body {margin: 0; padding: 0; font-size: 9px; font-family: Arial;}" +
            "table {line-height: 1.0; margin: 0; padding: 0;}" +
            "td {padding: 0; margin: 0; font-size: 9px; font-family: Arial;}" +
            "</style>" +
            "<body>" +
            "Pay non-taxable benefits:<br>" +
            "<table>" +
            "<tr><td style='padding-left: 15px;'>Rice Subsidy:</td><td style='padding-left: 15px;'>" + riceSubsidy + "</td></tr>" +
            "<tr><td style='padding-left: 15px;'>Phone Allowance:</td><td style='padding-left: 15px;'>" + phoneAllowance + "</td></tr>" +
            "<tr><td style='padding-left: 15px;'>Clothing Allowance:</td><td style='padding-left: 15px;'>" + clothingAllowance + "</td></tr>" +
            "</table>" +
            "</body>" +
            "</html>");
        benefits1.setBounds(5, 100, 350, 80);
        
        JLabel adjBen1 = new JLabel("Enter amount of adjustment on Non-Taxable Earnings:"); // creates a label to be added inside frameTitleP panel
        adjBen1.setForeground(new Color(0x0E3171)); // sets the font color of the text
        adjBen1.setFont(new Font("Arial", Font.BOLD, 12)); // sets the font of the text
        adjBen1.setOpaque(true); // this will display background color
        adjBen1.setVerticalAlignment(JLabel.CENTER); // sets the Vertical position of the frameTitleL (icon + Text)
        adjBen1.setHorizontalAlignment(JLabel.LEFT); // sets the Horizontal position of the frameTitleL (icon + Text)
        adjBen1.setBounds(5, 180, 350, 20); // sets the position of the entire label on the frame
        
        JTextField adjBene1 = new JTextField();
        adjBene1.setBounds(360, 180, 75, 20);
        
        JButton calculate1 = new JButton("Calculate");
        calculate1.setBounds(225, 215, 150, 20);
        
         //tab2 content:
         
        JLabel header2 = new JLabel("<html><u>Calculate salary based on Semi-Monthly Rate:</u></html>");
        header2.setForeground(new Color(0x0E3171)); // sets the font color of the text
        header2.setFont(new Font("Arial", Font.ITALIC, 12)); // sets the font of the text
        header2.setOpaque(true); // this will display background color
        header2.setVerticalAlignment(JLabel.CENTER); // sets the Vertical position of the frameTitleL (icon + Text)
        header2.setHorizontalAlignment(JLabel.LEFT); // sets the Horizontal position of the frameTitleL (icon + Text)
        header2.setBounds(5, 5, 350, 20); // sets the position of the entire label on the frame
        
        JLabel adjEarnings2 = new JLabel("Enter amount of adjustment on Taxable Earnings:"); // creates a label to be added inside frameTitleP panel
        adjEarnings2.setForeground(new Color(0x0E3171)); // sets the font color of the text
        adjEarnings2.setFont(new Font("Arial", Font.BOLD, 12)); // sets the font of the text
        adjEarnings2.setOpaque(true); // this will display background color
        adjEarnings2.setVerticalAlignment(JLabel.CENTER); // sets the Vertical position of the frameTitleL (icon + Text)
        adjEarnings2.setHorizontalAlignment(JLabel.LEFT); // sets the Horizontal position of the frameTitleL (icon + Text)
        adjEarnings2.setBounds(5, 25, 350, 20); // sets the position of the entire label on the frame
        
        JTextField adjEarning2 = new JTextField();
        adjEarning2.setBounds(360, 25, 75, 20);
        
        JLabel oThours2 = new JLabel("Enter overtime hours if applicable: "); // creates a label to be added inside frameTitleP panel
        oThours2.setForeground(new Color(0x0E3171)); // sets the font color of the text
        oThours2.setFont(new Font("Arial", Font.BOLD, 12)); // sets the font of the text
        oThours2.setOpaque(true); // this will display background color
        oThours2.setVerticalAlignment(JLabel.CENTER); // sets the Vertical position of the frameTitleL (icon + Text)
        oThours2.setHorizontalAlignment(JLabel.LEFT); // sets the Horizontal position of the frameTitleL (icon + Text)
        oThours2.setBounds(5, 50, 350, 20); // sets the position of the entire label on the frame
        
        JTextField otDur2 = new JTextField();
        otDur2.setBounds(360, 50, 75, 20);
       
        JLabel otRate2 = new JLabel("Enter overtime rate in decimal form (sample 1.25 for 125%):"); // creates a label to be added inside frameTitleP panel
        otRate2.setForeground(new Color(0x0E3171)); // sets the font color of the text
        otRate2.setFont(new Font("Arial", Font.BOLD, 12)); // sets the font of the text
        otRate2.setOpaque(true); // this will display background color
        otRate2.setVerticalAlignment(JLabel.CENTER); // sets the Vertical position of the frameTitleL (icon + Text)
        otRate2.setHorizontalAlignment(JLabel.LEFT); // sets the Horizontal position of the frameTitleL (icon + Text)
        otRate2.setBounds(5, 75, 350, 20); // sets the position of the entire label on the frame

        JTextField otPay2 = new JTextField();
        otPay2.setBounds(360, 75, 75, 20);
        
        
        
        // Create the JCheckBox with the retrieved benefits
       JCheckBox benefits2 = new JCheckBox("<html>" +
             "<style>" +
            "body {margin: 0; padding: 0; font-size: 9px; font-family: Arial;}" +
            "table {line-height: 1.0; margin: 0; padding: 0;}" +
            "td {padding: 0; margin: 0; font-size: 9px; font-family: Arial;}" +
            "</style>" +
            "<body>" +
            "Pay non-taxable benefits:<br>" +
            "<table>" +
            "<tr><td style='padding-left: 15px;'>Rice Subsidy:</td><td style='padding-left: 15px;'>" + riceSubsidy + "</td></tr>" +
            "<tr><td style='padding-left: 15px;'>Phone Allowance:</td><td style='padding-left: 15px;'>" + phoneAllowance + "</td></tr>" +
            "<tr><td style='padding-left: 15px;'>Clothing Allowance:</td><td style='padding-left: 15px;'>" + clothingAllowance + "</td></tr>" +
            "</table>" +
            "</body>" +
            "</html>");
        benefits2.setBounds(5, 100, 350, 80);
        
        JLabel adjBen2 = new JLabel("Enter amount of adjustment on Non-Taxable Earnings:"); // creates a label to be added inside frameTitleP panel
        adjBen2.setForeground(new Color(0x0E3171)); // sets the font color of the text
        adjBen2.setFont(new Font("Arial", Font.BOLD, 12)); // sets the font of the text
        adjBen2.setOpaque(true); // this will display background color
        adjBen2.setVerticalAlignment(JLabel.CENTER); // sets the Vertical position of the frameTitleL (icon + Text)
        adjBen2.setHorizontalAlignment(JLabel.LEFT); // sets the Horizontal position of the frameTitleL (icon + Text)
        adjBen2.setBounds(5, 180, 350, 20); // sets the position of the entire label on the frame
        
        JTextField adjBene2 = new JTextField();
        adjBene2.setBounds(360, 180, 75, 20);
        
        JButton calculate2 = new JButton("Calculate");
        calculate2.setBounds(225, 215, 150, 20);
        
        

        // Create a tabbed pane
        JTabbedPane tabbedPane = new JTabbedPane();

        // Create panels for each tab
        JPanel tab1 = new JPanel(null);
        tab1.add(header1);
        tab1.add(adjEarnings1);
        tab1.add(adjEarning1);
        tab1.add(oThours1);
        tab1.add(otDur1);
        tab1.add(otRate1);
        tab1.add(otPay1);
        tab1.add(benefits1);
        tab1.add(adjBen1);
        tab1.add(adjBene1);
        tab1.add(calculate1);

        JPanel tab2 = new JPanel(null);
        tab2.add(header2);
        tab2.add(adjEarnings2);
        tab2.add(adjEarning2);
        tab2.add(oThours2);
        tab2.add(otDur2);
        tab2.add(otRate2);
        tab2.add(otPay2);
        tab2.add(benefits2);
        tab2.add(adjBen2);
        tab2.add(adjBene2);
        tab2.add(calculate2);

        JPanel tab3 = new JPanel();
        tab3.add(new JLabel("Calculate Based on Hourly Rate"));

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