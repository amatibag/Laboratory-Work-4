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
import javax.swing.JOptionPane;
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
        adjEarning1.setText("0");
        
        JLabel oThours1 = new JLabel("Enter overtime hours if applicable: "); // creates a label to be added inside frameTitleP panel
        oThours1.setForeground(new Color(0x0E3171)); // sets the font color of the text
        oThours1.setFont(new Font("Arial", Font.BOLD, 12)); // sets the font of the text
        oThours1.setOpaque(true); // this will display background color
        oThours1.setVerticalAlignment(JLabel.CENTER); // sets the Vertical position of the frameTitleL (icon + Text)
        oThours1.setHorizontalAlignment(JLabel.LEFT); // sets the Horizontal position of the frameTitleL (icon + Text)
        oThours1.setBounds(5, 50, 350, 20); // sets the position of the entire label on the frame
        
        JTextField otDur1 = new JTextField();
        otDur1.setBounds(360, 50, 75, 20);
        otDur1.setText("0");
       
        JLabel otRate1 = new JLabel("Enter overtime rate in decimal form (sample 1.25 for 125%):"); // creates a label to be added inside frameTitleP panel
        otRate1.setForeground(new Color(0x0E3171)); // sets the font color of the text
        otRate1.setFont(new Font("Arial", Font.BOLD, 12)); // sets the font of the text
        otRate1.setOpaque(true); // this will display background color
        otRate1.setVerticalAlignment(JLabel.CENTER); // sets the Vertical position of the frameTitleL (icon + Text)
        otRate1.setHorizontalAlignment(JLabel.LEFT); // sets the Horizontal position of the frameTitleL (icon + Text)
        otRate1.setBounds(5, 75, 350, 20); // sets the position of the entire label on the frame

        JTextField otPay1 = new JTextField();
        otPay1.setBounds(360, 75, 75, 20);
        otPay1.setText("0");
        
        
        
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
        adjBene1.setText("0");
        
        JButton calculate1 = new JButton("Calculate");
        calculate1.setBounds(225, 215, 150, 20);
        
        JLabel grossTaxable1 = new JLabel("Gross Taxable Earnings: "); // creates a label to be added inside frameTitleP panel
        grossTaxable1.setForeground(new Color(0x0E3171)); // sets the font color of the text
        grossTaxable1.setFont(new Font("Arial", Font.BOLD, 12)); // sets the font of the text
        grossTaxable1.setOpaque(true); // this will display background color
        grossTaxable1.setVerticalAlignment(JLabel.CENTER); // sets the Vertical position of the frameTitleL (icon + Text)
        grossTaxable1.setHorizontalAlignment(JLabel.LEFT); // sets the Horizontal position of the frameTitleL (icon + Text)
        grossTaxable1.setBounds(5, 495, 190, 15); // sets the position of the entire label on the frame
        
        JLabel grossTaxabl1 = new JLabel(" "); // creates a label to be added inside frameTitleP panel
        grossTaxabl1.setForeground(new Color(0x0E3171)); // sets the font color of the text
        grossTaxabl1.setFont(new Font("Arial", Font.BOLD, 12)); // sets the font of the text
        grossTaxabl1.setOpaque(true); // this will display background color
        grossTaxabl1.setVerticalAlignment(JLabel.CENTER); // sets the Vertical position of the frameTitleL (icon + Text)
        grossTaxabl1.setHorizontalAlignment(JLabel.LEFT); // sets the Horizontal position of the frameTitleL (icon + Text)
        grossTaxabl1.setBounds(210, 494, 60, 17); // sets the position of the entire label on the frame
        
        JLabel adjTaxable1 = new JLabel("Taxable Earnings Adjustment: "); // creates a label to be added inside frameTitleP panel
        adjTaxable1.setForeground(new Color(0x0E3171)); // sets the font color of the text
        adjTaxable1.setFont(new Font("Arial", Font.BOLD, 12)); // sets the font of the text
        adjTaxable1.setOpaque(true); // this will display background color
        adjTaxable1.setVerticalAlignment(JLabel.CENTER); // sets the Vertical position of the frameTitleL (icon + Text)
        adjTaxable1.setHorizontalAlignment(JLabel.LEFT); // sets the Horizontal position of the frameTitleL (icon + Text)
        adjTaxable1.setBounds(5, 515, 190, 15); // sets the position of the entire label on the frame
        
        JLabel adjTaxabl1 = new JLabel(" "); // creates a label to be added inside frameTitleP panel
        adjTaxabl1.setForeground(new Color(0x0E3171)); // sets the font color of the text
        adjTaxabl1.setFont(new Font("Arial", Font.BOLD, 12)); // sets the font of the text
        adjTaxabl1.setOpaque(true); // this will display background color
        adjTaxabl1.setVerticalAlignment(JLabel.CENTER); // sets the Vertical position of the frameTitleL (icon + Text)
        adjTaxabl1.setHorizontalAlignment(JLabel.LEFT); // sets the Horizontal position of the frameTitleL (icon + Text)
        adjTaxabl1.setBounds(210, 514, 60, 17); // sets the position of the entire label on the frame
        
        JLabel sss1 = new JLabel("SSS Deduction: "); // creates a label to be added inside frameTitleP panel
        sss1.setForeground(new Color(0x0E3171)); // sets the font color of the text
        sss1.setFont(new Font("Arial", Font.BOLD, 12)); // sets the font of the text
        sss1.setOpaque(true); // this will display background color
        sss1.setVerticalAlignment(JLabel.CENTER); // sets the Vertical position of the frameTitleL (icon + Text)
        sss1.setHorizontalAlignment(JLabel.LEFT); // sets the Horizontal position of the frameTitleL (icon + Text)
        sss1.setBounds(5, 535, 190, 15); // sets the position of the entire label on the frame
        
        JLabel sssDed1 = new JLabel(" "); // creates a label to be added inside frameTitleP panel
        sssDed1.setForeground(new Color(0x0E3171)); // sets the font color of the text
        sssDed1.setFont(new Font("Arial", Font.BOLD, 12)); // sets the font of the text
        sssDed1.setOpaque(true); // this will display background color
        sssDed1.setVerticalAlignment(JLabel.CENTER); // sets the Vertical position of the frameTitleL (icon + Text)
        sssDed1.setHorizontalAlignment(JLabel.LEFT); // sets the Horizontal position of the frameTitleL (icon + Text)
        sssDed1.setBounds(210, 534, 60, 17); // sets the position of the entire label on the frame
        
        JLabel philH1 = new JLabel("PhilHealth Deduction: "); // creates a label to be added inside frameTitleP panel
        philH1.setForeground(new Color(0x0E3171)); // sets the font color of the text
        philH1.setFont(new Font("Arial", Font.BOLD, 12)); // sets the font of the text
        philH1.setOpaque(true); // this will display background color
        philH1.setVerticalAlignment(JLabel.CENTER); // sets the Vertical position of the frameTitleL (icon + Text)
        philH1.setHorizontalAlignment(JLabel.LEFT); // sets the Horizontal position of the frameTitleL (icon + Text)
        philH1.setBounds(5, 555, 190, 15); // sets the position of the entire label on the frame
        
        JLabel philDed1 = new JLabel(" "); // creates a label to be added inside frameTitleP panel
        philDed1.setForeground(new Color(0x0E3171)); // sets the font color of the text
        philDed1.setFont(new Font("Arial", Font.BOLD, 12)); // sets the font of the text
        philDed1.setOpaque(true); // this will display background color
        philDed1.setVerticalAlignment(JLabel.CENTER); // sets the Vertical position of the frameTitleL (icon + Text)
        philDed1.setHorizontalAlignment(JLabel.LEFT); // sets the Horizontal position of the frameTitleL (icon + Text)
        philDed1.setBounds(210, 554, 60, 17); // sets the position of the entire label on the frame
        
        JLabel pagIbg1 = new JLabel("PagIbig Deduction: "); // creates a label to be added inside frameTitleP panel
        pagIbg1.setForeground(new Color(0x0E3171)); // sets the font color of the text
        pagIbg1.setFont(new Font("Arial", Font.BOLD, 12)); // sets the font of the text
        pagIbg1.setOpaque(true); // this will display background color
        pagIbg1.setVerticalAlignment(JLabel.CENTER); // sets the Vertical position of the frameTitleL (icon + Text)
        pagIbg1.setHorizontalAlignment(JLabel.LEFT); // sets the Horizontal position of the frameTitleL (icon + Text)
        pagIbg1.setBounds(5, 575, 190, 15); // sets the position of the entire label on the frame
        
        JLabel pagIbgDed1 = new JLabel(" "); // creates a label to be added inside frameTitleP panel
        pagIbgDed1.setForeground(new Color(0x0E3171)); // sets the font color of the text
        pagIbgDed1.setFont(new Font("Arial", Font.BOLD, 12)); // sets the font of the text
        pagIbgDed1.setOpaque(true); // this will display background color
        pagIbgDed1.setVerticalAlignment(JLabel.CENTER); // sets the Vertical position of the frameTitleL (icon + Text)
        pagIbgDed1.setHorizontalAlignment(JLabel.LEFT); // sets the Horizontal position of the frameTitleL (icon + Text)
        pagIbgDed1.setBounds(210, 574, 60, 17); // sets the position of the entire label on the frame
        
        JLabel withholding1 = new JLabel("Witholding Tax Deduction: "); // creates a label to be added inside frameTitleP panel
        withholding1.setForeground(new Color(0x0E3171)); // sets the font color of the text
        withholding1.setFont(new Font("Arial", Font.BOLD, 12)); // sets the font of the text
        withholding1.setOpaque(true); // this will display background color
        withholding1.setVerticalAlignment(JLabel.CENTER); // sets the Vertical position of the frameTitleL (icon + Text)
        withholding1.setHorizontalAlignment(JLabel.LEFT); // sets the Horizontal position of the frameTitleL (icon + Text)
        withholding1.setBounds(5, 595, 190, 15); // sets the position of the entire label on the frame
        
        JLabel withholdingDed1 = new JLabel(" "); // creates a label to be added inside frameTitleP panel
        withholdingDed1.setForeground(new Color(0x0E3171)); // sets the font color of the text
        withholdingDed1.setFont(new Font("Arial", Font.BOLD, 12)); // sets the font of the text
        withholdingDed1.setOpaque(true); // this will display background color
        withholdingDed1.setVerticalAlignment(JLabel.CENTER); // sets the Vertical position of the frameTitleL (icon + Text)
        withholdingDed1.setHorizontalAlignment(JLabel.LEFT); // sets the Horizontal position of the frameTitleL (icon + Text)
        withholdingDed1.setBounds(210, 594, 60, 17); // sets the position of the entire label on the frame
        
        JLabel benefitsL1 = new JLabel("Non-Taxable Benefits Pay: "); // creates a label to be added inside frameTitleP panel
        benefitsL1.setForeground(new Color(0x0E3171)); // sets the font color of the text
        benefitsL1.setFont(new Font("Arial", Font.BOLD, 12)); // sets the font of the text
        benefitsL1.setOpaque(true); // this will display background color
        benefitsL1.setVerticalAlignment(JLabel.CENTER); // sets the Vertical position of the frameTitleL (icon + Text)
        benefitsL1.setHorizontalAlignment(JLabel.LEFT); // sets the Horizontal position of the frameTitleL (icon + Text)
        benefitsL1.setBounds(310, 495, 210, 15); // sets the position of the entire label on the frame
        
        JLabel benefitsPay1 = new JLabel(" "); // creates a label to be added inside frameTitleP panel
        benefitsPay1.setForeground(new Color(0x0E3171)); // sets the font color of the text
        benefitsPay1.setFont(new Font("Arial", Font.BOLD, 12)); // sets the font of the text
        benefitsPay1.setOpaque(true); // this will display background color
        benefitsPay1.setVerticalAlignment(JLabel.CENTER); // sets the Vertical position of the frameTitleL (icon + Text)
        benefitsPay1.setHorizontalAlignment(JLabel.LEFT); // sets the Horizontal position of the frameTitleL (icon + Text)
        benefitsPay1.setBounds(525, 494, 60, 17); // sets the position of the entire label on the frame
        
        JLabel benefitsAdjL1 = new JLabel("Non-Taxable Benefits Adjustment: "); // creates a label to be added inside frameTitleP panel
        benefitsAdjL1.setForeground(new Color(0x0E3171)); // sets the font color of the text
        benefitsAdjL1.setFont(new Font("Arial", Font.BOLD, 12)); // sets the font of the text
        benefitsAdjL1.setOpaque(true); // this will display background color
        benefitsAdjL1.setVerticalAlignment(JLabel.CENTER); // sets the Vertical position of the frameTitleL (icon + Text)
        benefitsAdjL1.setHorizontalAlignment(JLabel.LEFT); // sets the Horizontal position of the frameTitleL (icon + Text)
        benefitsAdjL1.setBounds(310, 515, 210, 15); // sets the position of the entire label on the frame
        
        JLabel benefitsAdjDed1 = new JLabel(" "); // creates a label to be added inside frameTitleP panel
        benefitsAdjDed1.setForeground(new Color(0x0E3171)); // sets the font color of the text
        benefitsAdjDed1.setFont(new Font("Arial", Font.BOLD, 12)); // sets the font of the text
        benefitsAdjDed1.setOpaque(true); // this will display background color
        benefitsAdjDed1.setVerticalAlignment(JLabel.CENTER); // sets the Vertical position of the frameTitleL (icon + Text)
        benefitsAdjDed1.setHorizontalAlignment(JLabel.LEFT); // sets the Horizontal position of the frameTitleL (icon + Text)
        benefitsAdjDed1.setBounds(525, 514, 60, 17); // sets the position of the entire label on the frame
        
        JLabel netPayL1 = new JLabel("Net Pay: "); // creates a label to be added inside frameTitleP panel
        netPayL1.setForeground(new Color(0x0E3171)); // sets the font color of the text
        netPayL1.setFont(new Font("Arial", Font.BOLD, 12)); // sets the font of the text
        netPayL1.setOpaque(true); // this will display background color
        netPayL1.setVerticalAlignment(JLabel.CENTER); // sets the Vertical position of the frameTitleL (icon + Text)
        netPayL1.setHorizontalAlignment(JLabel.LEFT); // sets the Horizontal position of the frameTitleL (icon + Text)
        netPayL1.setBounds(310, 555, 210, 15); // sets the position of the entire label on the frame
        
        JLabel netPay1 = new JLabel(" "); // creates a label to be added inside frameTitleP panel
        netPay1.setForeground(new Color(0x0E3171)); // sets the font color of the text
        netPay1.setFont(new Font("Arial", Font.BOLD, 12)); // sets the font of the text
        netPay1.setOpaque(true); // this will display background color
        netPay1.setVerticalAlignment(JLabel.CENTER); // sets the Vertical position of the frameTitleL (icon + Text)
        netPay1.setHorizontalAlignment(JLabel.LEFT); // sets the Horizontal position of the frameTitleL (icon + Text)
        netPay1.setBounds(525, 554, 60, 17); // sets the position of the entire label on the frame
        
        JButton submit1 = new JButton("Submit for Payroll");
        submit1.setBounds(225, 625, 150, 20);
        
        calculate1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Retrieve input values
                    double otRate = Double.parseDouble(otPay1.getText());
                    double otHours = Double.parseDouble(otDur1.getText());
                    double adjEarnings = Double.parseDouble(adjEarning1.getText());
                    double benefitsAdjustment = Double.parseDouble(adjBene1.getText());
                    double basicSalary = Double.parseDouble(rowData[13]);
                    double riceSubsidyP = Double.parseDouble(rowData[14]); 
                    double phoneAllowanceP = Double.parseDouble(rowData[15]); 
                    double clothingAllowanceP = Double.parseDouble(rowData[16]);
                    double hourlyRate = Double.parseDouble(rowData[18]);

                    // Perform calculations
                    double overtimeEarnings = PayrollCalculation.calculateOvertimeEarnings(otRate, hourlyRate, otHours);
                    double taxableEarnings = PayrollCalculation.calculateTaxableEarnings(basicSalary, adjEarnings);
                    double netGross = PayrollCalculation.calculateNetGross(overtimeEarnings, taxableEarnings);
                    double sssDeduction = PayrollCalculation.calculateSSS(netGross);
                    double philHealthDeduction = PayrollCalculation.calculatePhilHealth(netGross);
                    double pagIbigDeduction = PayrollCalculation.calculatePagibig(netGross);
                    double taxableIncome = netGross - (sssDeduction + philHealthDeduction + pagIbigDeduction);
                    double witholdingTax = PayrollCalculation.calculateWitholdingTax(taxableIncome);
                    double nettaxedEarnings = taxableIncome - witholdingTax;

                    // Display results
                    grossTaxabl1.setText(String.format("%.2f", netGross));
                    adjTaxabl1.setText(String.format("%.2f", adjEarnings));
                    sssDed1.setText(String.format("%.2f", sssDeduction));
                    philDed1.setText(String.format("%.2f", philHealthDeduction));
                    pagIbgDed1.setText(String.format("%.2f", pagIbigDeduction));
                    withholdingDed1.setText(String.format("%.2f", witholdingTax));
                    
                    if (benefits1.isSelected()) {
                    double totalBenefits = riceSubsidyP + phoneAllowanceP + clothingAllowanceP;
                    double netWben = nettaxedEarnings + totalBenefits + benefitsAdjustment;
                    benefitsPay1.setText(String.format("%.2f", totalBenefits));
                    benefitsAdjDed1.setText(String.format("%.2f", benefitsAdjustment));
                    netPay1.setText(String.format("%.2f", netWben));
                    
            }else{
                        
                    netPay1.setText(String.format("%.2f", nettaxedEarnings));}

                    // Add other calculations and display logic here
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter valid numbers.", "Input Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
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
        
        JLabel grossTaxable2 = new JLabel("Gross Taxable Earnings: "); // creates a label to be added inside frameTitleP panel
        grossTaxable2.setForeground(new Color(0x0E3171)); // sets the font color of the text
        grossTaxable2.setFont(new Font("Arial", Font.BOLD, 12)); // sets the font of the text
        grossTaxable2.setOpaque(true); // this will display background color
        grossTaxable2.setVerticalAlignment(JLabel.CENTER); // sets the Vertical position of the frameTitleL (icon + Text)
        grossTaxable2.setHorizontalAlignment(JLabel.LEFT); // sets the Horizontal position of the frameTitleL (icon + Text)
        grossTaxable2.setBounds(5, 495, 190, 15); // sets the position of the entire label on the frame
        
        JLabel grossTaxabl2 = new JLabel("Gross"); // creates a label to be added inside frameTitleP panel
        grossTaxabl2.setForeground(new Color(0x0E3171)); // sets the font color of the text
        grossTaxabl2.setFont(new Font("Arial", Font.BOLD, 12)); // sets the font of the text
        grossTaxabl2.setOpaque(true); // this will display background color
        grossTaxabl2.setVerticalAlignment(JLabel.CENTER); // sets the Vertical position of the frameTitleL (icon + Text)
        grossTaxabl2.setHorizontalAlignment(JLabel.LEFT); // sets the Horizontal position of the frameTitleL (icon + Text)
        grossTaxabl2.setBounds(210, 494, 50, 17); // sets the position of the entire label on the frame
        
        JLabel adjTaxable2 = new JLabel("Taxable Earnings Adjustment: "); // creates a label to be added inside frameTitleP panel
        adjTaxable2.setForeground(new Color(0x0E3171)); // sets the font color of the text
        adjTaxable2.setFont(new Font("Arial", Font.BOLD, 12)); // sets the font of the text
        adjTaxable2.setOpaque(true); // this will display background color
        adjTaxable2.setVerticalAlignment(JLabel.CENTER); // sets the Vertical position of the frameTitleL (icon + Text)
        adjTaxable2.setHorizontalAlignment(JLabel.LEFT); // sets the Horizontal position of the frameTitleL (icon + Text)
        adjTaxable2.setBounds(5, 515, 190, 15); // sets the position of the entire label on the frame
        
        JLabel adjTaxabl2 = new JLabel("G Adj"); // creates a label to be added inside frameTitleP panel
        adjTaxabl2.setForeground(new Color(0x0E3171)); // sets the font color of the text
        adjTaxabl2.setFont(new Font("Arial", Font.BOLD, 12)); // sets the font of the text
        adjTaxabl2.setOpaque(true); // this will display background color
        adjTaxabl2.setVerticalAlignment(JLabel.CENTER); // sets the Vertical position of the frameTitleL (icon + Text)
        adjTaxabl2.setHorizontalAlignment(JLabel.LEFT); // sets the Horizontal position of the frameTitleL (icon + Text)
        adjTaxabl2.setBounds(210, 514, 50, 17); // sets the position of the entire label on the frame
        
        JLabel sss2 = new JLabel("SSS Deduction: "); // creates a label to be added inside frameTitleP panel
        sss2.setForeground(new Color(0x0E3171)); // sets the font color of the text
        sss2.setFont(new Font("Arial", Font.BOLD, 12)); // sets the font of the text
        sss2.setOpaque(true); // this will display background color
        sss2.setVerticalAlignment(JLabel.CENTER); // sets the Vertical position of the frameTitleL (icon + Text)
        sss2.setHorizontalAlignment(JLabel.LEFT); // sets the Horizontal position of the frameTitleL (icon + Text)
        sss2.setBounds(5, 535, 190, 15); // sets the position of the entire label on the frame
        
        JLabel sssDed2 = new JLabel("SSS Ded"); // creates a label to be added inside frameTitleP panel
        sssDed2.setForeground(new Color(0x0E3171)); // sets the font color of the text
        sssDed2.setFont(new Font("Arial", Font.BOLD, 12)); // sets the font of the text
        sssDed2.setOpaque(true); // this will display background color
        sssDed2.setVerticalAlignment(JLabel.CENTER); // sets the Vertical position of the frameTitleL (icon + Text)
        sssDed2.setHorizontalAlignment(JLabel.LEFT); // sets the Horizontal position of the frameTitleL (icon + Text)
        sssDed2.setBounds(210, 534, 50, 17); // sets the position of the entire label on the frame
        
        JLabel philH2 = new JLabel("PhilHealth Deduction: "); // creates a label to be added inside frameTitleP panel
        philH2.setForeground(new Color(0x0E3171)); // sets the font color of the text
        philH2.setFont(new Font("Arial", Font.BOLD, 12)); // sets the font of the text
        philH2.setOpaque(true); // this will display background color
        philH2.setVerticalAlignment(JLabel.CENTER); // sets the Vertical position of the frameTitleL (icon + Text)
        philH2.setHorizontalAlignment(JLabel.LEFT); // sets the Horizontal position of the frameTitleL (icon + Text)
        philH2.setBounds(5, 555, 190, 15); // sets the position of the entire label on the frame
        
        JLabel philDed2 = new JLabel("Phil Ded"); // creates a label to be added inside frameTitleP panel
        philDed2.setForeground(new Color(0x0E3171)); // sets the font color of the text
        philDed2.setFont(new Font("Arial", Font.BOLD, 12)); // sets the font of the text
        philDed2.setOpaque(true); // this will display background color
        philDed2.setVerticalAlignment(JLabel.CENTER); // sets the Vertical position of the frameTitleL (icon + Text)
        philDed2.setHorizontalAlignment(JLabel.LEFT); // sets the Horizontal position of the frameTitleL (icon + Text)
        philDed2.setBounds(210, 554, 50, 17); // sets the position of the entire label on the frame
        
        JLabel pagIbg2 = new JLabel("PagIbig Deduction: "); // creates a label to be added inside frameTitleP panel
        pagIbg2.setForeground(new Color(0x0E3171)); // sets the font color of the text
        pagIbg2.setFont(new Font("Arial", Font.BOLD, 12)); // sets the font of the text
        pagIbg2.setOpaque(true); // this will display background color
        pagIbg2.setVerticalAlignment(JLabel.CENTER); // sets the Vertical position of the frameTitleL (icon + Text)
        pagIbg2.setHorizontalAlignment(JLabel.LEFT); // sets the Horizontal position of the frameTitleL (icon + Text)
        pagIbg2.setBounds(5, 575, 190, 15); // sets the position of the entire label on the frame
        
        JLabel pagIbgDed2 = new JLabel("PagIbgDed Ded"); // creates a label to be added inside frameTitleP panel
        pagIbgDed2.setForeground(new Color(0x0E3171)); // sets the font color of the text
        pagIbgDed2.setFont(new Font("Arial", Font.BOLD, 12)); // sets the font of the text
        pagIbgDed2.setOpaque(true); // this will display background color
        pagIbgDed2.setVerticalAlignment(JLabel.CENTER); // sets the Vertical position of the frameTitleL (icon + Text)
        pagIbgDed2.setHorizontalAlignment(JLabel.LEFT); // sets the Horizontal position of the frameTitleL (icon + Text)
        pagIbgDed2.setBounds(210, 574, 50, 17); // sets the position of the entire label on the frame
        
        JLabel withholding2 = new JLabel("Witholding Tax Deduction: "); // creates a label to be added inside frameTitleP panel
        withholding2.setForeground(new Color(0x0E3171)); // sets the font color of the text
        withholding2.setFont(new Font("Arial", Font.BOLD, 12)); // sets the font of the text
        withholding2.setOpaque(true); // this will display background color
        withholding2.setVerticalAlignment(JLabel.CENTER); // sets the Vertical position of the frameTitleL (icon + Text)
        withholding2.setHorizontalAlignment(JLabel.LEFT); // sets the Horizontal position of the frameTitleL (icon + Text)
        withholding2.setBounds(5, 595, 190, 15); // sets the position of the entire label on the frame
        
        JLabel withholdingDed2 = new JLabel("Witholding Tax Ded"); // creates a label to be added inside frameTitleP panel
        withholdingDed2.setForeground(new Color(0x0E3171)); // sets the font color of the text
        withholdingDed2.setFont(new Font("Arial", Font.BOLD, 12)); // sets the font of the text
        withholdingDed2.setOpaque(true); // this will display background color
        withholdingDed2.setVerticalAlignment(JLabel.CENTER); // sets the Vertical position of the frameTitleL (icon + Text)
        withholdingDed2.setHorizontalAlignment(JLabel.LEFT); // sets the Horizontal position of the frameTitleL (icon + Text)
        withholdingDed2.setBounds(210, 594, 50, 17); // sets the position of the entire label on the frame
        
        JLabel benefitsL2 = new JLabel("Non-Taxable Benefits Pay: "); // creates a label to be added inside frameTitleP panel
        benefitsL2.setForeground(new Color(0x0E3171)); // sets the font color of the text
        benefitsL2.setFont(new Font("Arial", Font.BOLD, 12)); // sets the font of the text
        benefitsL2.setOpaque(true); // this will display background color
        benefitsL2.setVerticalAlignment(JLabel.CENTER); // sets the Vertical position of the frameTitleL (icon + Text)
        benefitsL2.setHorizontalAlignment(JLabel.LEFT); // sets the Horizontal position of the frameTitleL (icon + Text)
        benefitsL2.setBounds(310, 495, 210, 15); // sets the position of the entire label on the frame
        
        JLabel benefitsPay2 = new JLabel("Bene"); // creates a label to be added inside frameTitleP panel
        benefitsPay2.setForeground(new Color(0x0E3171)); // sets the font color of the text
        benefitsPay2.setFont(new Font("Arial", Font.BOLD, 12)); // sets the font of the text
        benefitsPay2.setOpaque(true); // this will display background color
        benefitsPay2.setVerticalAlignment(JLabel.CENTER); // sets the Vertical position of the frameTitleL (icon + Text)
        benefitsPay2.setHorizontalAlignment(JLabel.LEFT); // sets the Horizontal position of the frameTitleL (icon + Text)
        benefitsPay2.setBounds(525, 494, 50, 17); // sets the position of the entire label on the frame
        
        JLabel benefitsAdjL2 = new JLabel("Non-Taxable Benefits Adjustment: "); // creates a label to be added inside frameTitleP panel
        benefitsAdjL2.setForeground(new Color(0x0E3171)); // sets the font color of the text
        benefitsAdjL2.setFont(new Font("Arial", Font.BOLD, 12)); // sets the font of the text
        benefitsAdjL2.setOpaque(true); // this will display background color
        benefitsAdjL2.setVerticalAlignment(JLabel.CENTER); // sets the Vertical position of the frameTitleL (icon + Text)
        benefitsAdjL2.setHorizontalAlignment(JLabel.LEFT); // sets the Horizontal position of the frameTitleL (icon + Text)
        benefitsAdjL2.setBounds(310, 515, 210, 15); // sets the position of the entire label on the frame
        
        JLabel benefitsAdjDed2 = new JLabel("Bene Adj"); // creates a label to be added inside frameTitleP panel
        benefitsAdjDed2.setForeground(new Color(0x0E3171)); // sets the font color of the text
        benefitsAdjDed2.setFont(new Font("Arial", Font.BOLD, 12)); // sets the font of the text
        benefitsAdjDed2.setOpaque(true); // this will display background color
        benefitsAdjDed2.setVerticalAlignment(JLabel.CENTER); // sets the Vertical position of the frameTitleL (icon + Text)
        benefitsAdjDed2.setHorizontalAlignment(JLabel.LEFT); // sets the Horizontal position of the frameTitleL (icon + Text)
        benefitsAdjDed2.setBounds(525, 514, 50, 17); // sets the position of the entire label on the frame
        
        JLabel netPayL2 = new JLabel("Net Pay: "); // creates a label to be added inside frameTitleP panel
        netPayL2.setForeground(new Color(0x0E3171)); // sets the font color of the text
        netPayL2.setFont(new Font("Arial", Font.BOLD, 12)); // sets the font of the text
        netPayL2.setOpaque(true); // this will display background color
        netPayL2.setVerticalAlignment(JLabel.CENTER); // sets the Vertical position of the frameTitleL (icon + Text)
        netPayL2.setHorizontalAlignment(JLabel.LEFT); // sets the Horizontal position of the frameTitleL (icon + Text)
        netPayL2.setBounds(310, 555, 210, 15); // sets the position of the entire label on the frame
        
        JLabel netPay2 = new JLabel("Net"); // creates a label to be added inside frameTitleP panel
        netPay2.setForeground(new Color(0x0E3171)); // sets the font color of the text
        netPay2.setFont(new Font("Arial", Font.BOLD, 12)); // sets the font of the text
        netPay2.setOpaque(true); // this will display background color
        netPay2.setVerticalAlignment(JLabel.CENTER); // sets the Vertical position of the frameTitleL (icon + Text)
        netPay2.setHorizontalAlignment(JLabel.LEFT); // sets the Horizontal position of the frameTitleL (icon + Text)
        netPay2.setBounds(525, 554, 50, 17); // sets the position of the entire label on the frame
        
        JButton submit2 = new JButton("Submit for Payroll");
        submit2.setBounds(225, 625, 150, 20);
        
        //tab3 content:
        JLabel header3 = new JLabel("<html><u>Calculate salary based on Hourly Rate:</u></html>");
        header3.setForeground(new Color(0x0E3171)); // sets the font color of the text
        header3.setFont(new Font("Arial", Font.ITALIC, 12)); // sets the font of the text
        header3.setOpaque(true); // this will display background color
        header3.setVerticalAlignment(JLabel.CENTER); // sets the Vertical position of the frameTitleL (icon + Text)
        header3.setHorizontalAlignment(JLabel.LEFT); // sets the Horizontal position of the frameTitleL (icon + Text)
        header3.setBounds(5, 5, 350, 20); // sets the position of the entire label on the frame
        
        JLabel login1 = new JLabel("Login:"); // creates a label to be added inside frameTitleP panel
        login1.setForeground(new Color(0x0E3171)); // sets the font color of the text
        login1.setFont(new Font("Arial", Font.BOLD, 11)); // sets the font of the text
        login1.setOpaque(true); // this will display background color
        login1.setVerticalAlignment(JLabel.CENTER); // sets the Vertical position of the frameTitleL (icon + Text)
        login1.setHorizontalAlignment(JLabel.LEFT); // sets the Horizontal position of the frameTitleL (icon + Text)
        login1.setBounds(108, 35, 45, 15); // sets the position of the entire label on the frame
        
        JLabel logout1 = new JLabel("LogOut:"); // creates a label to be added inside frameTitleP panel
        logout1.setForeground(new Color(0x0E3171)); // sets the font color of the text
        logout1.setFont(new Font("Arial", Font.BOLD, 11)); // sets the font of the text
        logout1.setOpaque(true); // this will display background color
        logout1.setVerticalAlignment(JLabel.CENTER); // sets the Vertical position of the frameTitleL (icon + Text)
        logout1.setHorizontalAlignment(JLabel.LEFT); // sets the Horizontal position of the frameTitleL (icon + Text)
        logout1.setBounds(160, 35, 45, 15); // sets the position of the entire label on the frame
        
        JLabel day1 = new JLabel("Day  1 (HH:MM):"); // creates a label to be added inside frameTitleP panel
        day1.setForeground(new Color(0x0E3171)); // sets the font color of the text
        day1.setFont(new Font("Arial", Font.BOLD, 12)); // sets the font of the text
        day1.setOpaque(true); // this will display background color
        day1.setVerticalAlignment(JLabel.CENTER); // sets the Vertical position of the frameTitleL (icon + Text)
        day1.setHorizontalAlignment(JLabel.LEFT); // sets the Horizontal position of the frameTitleL (icon + Text)
        day1.setBounds(5, 55, 95, 15); // sets the position of the entire label on the frame
        
        JTextField li1 = new JTextField();
        li1.setBounds(108, 54, 45, 17);
        
        JTextField lo1 = new JTextField();
        lo1.setBounds(160, 54, 45, 17);
        
        JLabel day2 = new JLabel("Day  2 (HH:MM):"); // creates a label to be added inside frameTitleP panel
        day2.setForeground(new Color(0x0E3171)); // sets the font color of the text
        day2.setFont(new Font("Arial", Font.BOLD, 12)); // sets the font of the text
        day2.setOpaque(true); // this will display background color
        day2.setVerticalAlignment(JLabel.CENTER); // sets the Vertical position of the frameTitleL (icon + Text)
        day2.setHorizontalAlignment(JLabel.LEFT); // sets the Horizontal position of the frameTitleL (icon + Text)
        day2.setBounds(5, 75, 95, 15); // sets the position of the entire label on the frame
        
        JTextField li2 = new JTextField();
        li2.setBounds(108, 74, 45, 17);
        
        JTextField lo2 = new JTextField();
        lo2.setBounds(160, 74, 45, 17);
        
        JLabel day3 = new JLabel("Day  3 (HH:MM):"); // creates a label to be added inside frameTitleP panel
        day3.setForeground(new Color(0x0E3171)); // sets the font color of the text
        day3.setFont(new Font("Arial", Font.BOLD, 12)); // sets the font of the text
        day3.setOpaque(true); // this will display background color
        day3.setVerticalAlignment(JLabel.CENTER); // sets the Vertical position of the frameTitleL (icon + Text)
        day3.setHorizontalAlignment(JLabel.LEFT); // sets the Horizontal position of the frameTitleL (icon + Text)
        day3.setBounds(5, 95, 95, 15); // sets the position of the entire label on the frame
        
        JTextField li3 = new JTextField();
        li3.setBounds(108, 94, 45, 17);
        
        JTextField lo3 = new JTextField();
        lo3.setBounds(160, 94, 45, 17);
        
        JLabel day4 = new JLabel("Day  4 (HH:MM):"); // creates a label to be added inside frameTitleP panel
        day4.setForeground(new Color(0x0E3171)); // sets the font color of the text
        day4.setFont(new Font("Arial", Font.BOLD, 12)); // sets the font of the text
        day4.setOpaque(true); // this will display background color
        day4.setVerticalAlignment(JLabel.CENTER); // sets the Vertical position of the frameTitleL (icon + Text)
        day4.setHorizontalAlignment(JLabel.LEFT); // sets the Horizontal position of the frameTitleL (icon + Text)
        day4.setBounds(5, 115, 95, 15); // sets the position of the entire label on the frame
        
        JTextField li4 = new JTextField();
        li4.setBounds(108, 114, 45, 17);
        
        JTextField lo4 = new JTextField();
        lo4.setBounds(160, 114, 45, 17);
        
        JLabel day5 = new JLabel("Day  5 (HH:MM):"); // creates a label to be added inside frameTitleP panel
        day5.setForeground(new Color(0x0E3171)); // sets the font color of the text
        day5.setFont(new Font("Arial", Font.BOLD, 12)); // sets the font of the text
        day5.setOpaque(true); // this will display background color
        day5.setVerticalAlignment(JLabel.CENTER); // sets the Vertical position of the frameTitleL (icon + Text)
        day5.setHorizontalAlignment(JLabel.LEFT); // sets the Horizontal position of the frameTitleL (icon + Text)
        day5.setBounds(5, 135, 95, 15); // sets the position of the entire label on the frame
        
        JTextField li5 = new JTextField();
        li5.setBounds(108, 134, 45, 17);
        
        JTextField lo5 = new JTextField();
        lo5.setBounds(160, 134, 45, 17);
        
        JLabel day6 = new JLabel("Day  6 (HH:MM):"); // creates a label to be added inside frameTitleP panel
        day6.setForeground(new Color(0x0E3171)); // sets the font color of the text
        day6.setFont(new Font("Arial", Font.BOLD, 12)); // sets the font of the text
        day6.setOpaque(true); // this will display background color
        day6.setVerticalAlignment(JLabel.CENTER); // sets the Vertical position of the frameTitleL (icon + Text)
        day6.setHorizontalAlignment(JLabel.LEFT); // sets the Horizontal position of the frameTitleL (icon + Text)
        day6.setBounds(5, 155, 95, 15); // sets the position of the entire label on the frame
        
        JTextField li6 = new JTextField();
        li6.setBounds(108, 154, 45, 17);
        
        JTextField lo6 = new JTextField();
        lo6.setBounds(160, 154, 45, 17);
        
        JLabel day7 = new JLabel("Day  7 (HH:MM):"); // creates a label to be added inside frameTitleP panel
        day7.setForeground(new Color(0x0E3171)); // sets the font color of the text
        day7.setFont(new Font("Arial", Font.BOLD, 12)); // sets the font of the text
        day7.setOpaque(true); // this will display background color
        day7.setVerticalAlignment(JLabel.CENTER); // sets the Vertical position of the frameTitleL (icon + Text)
        day7.setHorizontalAlignment(JLabel.LEFT); // sets the Horizontal position of the frameTitleL (icon + Text)
        day7.setBounds(5, 175, 95, 15); // sets the position of the entire label on the frame
        
        JTextField li7 = new JTextField();
        li7.setBounds(108, 174, 45, 17);
        
        JTextField lo7 = new JTextField();
        lo7.setBounds(160, 174, 45, 17);
        
        JLabel day8 = new JLabel("Day  8 (HH:MM):"); // creates a label to be added inside frameTitleP panel
        day8.setForeground(new Color(0x0E3171)); // sets the font color of the text
        day8.setFont(new Font("Arial", Font.BOLD, 12)); // sets the font of the text
        day8.setOpaque(true); // this will display background color
        day8.setVerticalAlignment(JLabel.CENTER); // sets the Vertical position of the frameTitleL (icon + Text)
        day8.setHorizontalAlignment(JLabel.LEFT); // sets the Horizontal position of the frameTitleL (icon + Text)
        day8.setBounds(5, 195, 95, 15); // sets the position of the entire label on the frame
        
        JTextField li8 = new JTextField();
        li8.setBounds(108, 194, 45, 17);
        
        JTextField lo8 = new JTextField();
        lo8.setBounds(160, 194, 45, 17);
        
        JLabel day9 = new JLabel("Day  9 (HH:MM):"); // creates a label to be added inside frameTitleP panel
        day9.setForeground(new Color(0x0E3171)); // sets the font color of the text
        day9.setFont(new Font("Arial", Font.BOLD, 12)); // sets the font of the text
        day9.setOpaque(true); // this will display background color
        day9.setVerticalAlignment(JLabel.CENTER); // sets the Vertical position of the frameTitleL (icon + Text)
        day9.setHorizontalAlignment(JLabel.LEFT); // sets the Horizontal position of the frameTitleL (icon + Text)
        day9.setBounds(5, 215, 95, 15); // sets the position of the entire label on the frame
        
        JTextField li9 = new JTextField();
        li9.setBounds(108, 214, 45, 17);
        
        JTextField lo9 = new JTextField();
        lo9.setBounds(160, 214, 45, 17);
        
        JLabel day10 = new JLabel("Day 10 (HH:MM):"); // creates a label to be added inside frameTitleP panel
        day10.setForeground(new Color(0x0E3171)); // sets the font color of the text
        day10.setFont(new Font("Arial", Font.BOLD, 12)); // sets the font of the text
        day10.setOpaque(true); // this will display background color
        day10.setVerticalAlignment(JLabel.CENTER); // sets the Vertical position of the frameTitleL (icon + Text)
        day10.setHorizontalAlignment(JLabel.LEFT); // sets the Horizontal position of the frameTitleL (icon + Text)
        day10.setBounds(5, 235, 95, 15); // sets the position of the entire label on the frame
        
        JTextField li10 = new JTextField();
        li10.setBounds(108, 234, 45, 17);
        
        JTextField lo10 = new JTextField();
        lo10.setBounds(160, 234, 45, 17);
        
        JLabel day11 = new JLabel("Day 11 (HH:MM):"); // creates a label to be added inside frameTitleP panel
        day11.setForeground(new Color(0x0E3171)); // sets the font color of the text
        day11.setFont(new Font("Arial", Font.BOLD, 12)); // sets the font of the text
        day11.setOpaque(true); // this will display background color
        day11.setVerticalAlignment(JLabel.CENTER); // sets the Vertical position of the frameTitleL (icon + Text)
        day11.setHorizontalAlignment(JLabel.LEFT); // sets the Horizontal position of the frameTitleL (icon + Text)
        day11.setBounds(5, 255, 95, 15); // sets the position of the entire label on the frame
        
        JTextField li11 = new JTextField();
        li11.setBounds(108, 254, 45, 17);
        
        JTextField lo11 = new JTextField();
        lo11.setBounds(160, 254, 45, 17);
        
        JLabel login2 = new JLabel("Login:"); // creates a label to be added inside frameTitleP panel
        login2.setForeground(new Color(0x0E3171)); // sets the font color of the text
        login2.setFont(new Font("Arial", Font.BOLD, 11)); // sets the font of the text
        login2.setOpaque(true); // this will display background color
        login2.setVerticalAlignment(JLabel.CENTER); // sets the Vertical position of the frameTitleL (icon + Text)
        login2.setHorizontalAlignment(JLabel.LEFT); // sets the Horizontal position of the frameTitleL (icon + Text)
        login2.setBounds(328, 35, 45, 15); // sets the position of the entire label on the frame
        
        JLabel logout2 = new JLabel("LogOut:"); // creates a label to be added inside frameTitleP panel
        logout2.setForeground(new Color(0x0E3171)); // sets the font color of the text
        logout2.setFont(new Font("Arial", Font.BOLD, 11)); // sets the font of the text
        logout2.setOpaque(true); // this will display background color
        logout2.setVerticalAlignment(JLabel.CENTER); // sets the Vertical position of the frameTitleL (icon + Text)
        logout2.setHorizontalAlignment(JLabel.LEFT); // sets the Horizontal position of the frameTitleL (icon + Text)
        logout2.setBounds(380, 35, 45, 15); // sets the position of the entire label on the frame
        
        JLabel day12 = new JLabel("Day 12 (HH:MM):"); // creates a label to be added inside frameTitleP panel
        day12.setForeground(new Color(0x0E3171)); // sets the font color of the text
        day12.setFont(new Font("Arial", Font.BOLD, 12)); // sets the font of the text
        day12.setOpaque(true); // this will display background color
        day12.setVerticalAlignment(JLabel.CENTER); // sets the Vertical position of the frameTitleL (icon + Text)
        day12.setHorizontalAlignment(JLabel.LEFT); // sets the Horizontal position of the frameTitleL (icon + Text)
        day12.setBounds(225, 55, 95, 15); // sets the position of the entire label on the frame
        
        JTextField li12 = new JTextField();
        li12.setBounds(328, 54, 45, 17);
        
        JTextField lo12 = new JTextField();
        lo12.setBounds(380, 54, 45, 17);
        
        JLabel day13 = new JLabel("Day 13 (HH:MM):"); // creates a label to be added inside frameTitleP panel
        day13.setForeground(new Color(0x0E3171)); // sets the font color of the text
        day13.setFont(new Font("Arial", Font.BOLD, 12)); // sets the font of the text
        day13.setOpaque(true); // this will display background color
        day13.setVerticalAlignment(JLabel.CENTER); // sets the Vertical position of the frameTitleL (icon + Text)
        day13.setHorizontalAlignment(JLabel.LEFT); // sets the Horizontal position of the frameTitleL (icon + Text)
        day13.setBounds(225, 75, 95, 15); // sets the position of the entire label on the frame
        
        JTextField li13 = new JTextField();
        li13.setBounds(328, 74, 45, 17);
        
        JTextField lo13 = new JTextField();
        lo13.setBounds(380, 74, 45, 17);
        
        JLabel day14 = new JLabel("Day 14 (HH:MM):"); // creates a label to be added inside frameTitleP panel
        day14.setForeground(new Color(0x0E3171)); // sets the font color of the text
        day14.setFont(new Font("Arial", Font.BOLD, 12)); // sets the font of the text
        day14.setOpaque(true); // this will display background color
        day14.setVerticalAlignment(JLabel.CENTER); // sets the Vertical position of the frameTitleL (icon + Text)
        day14.setHorizontalAlignment(JLabel.LEFT); // sets the Horizontal position of the frameTitleL (icon + Text)
        day14.setBounds(225, 95, 95, 15); // sets the position of the entire label on the frame
        
        JTextField li14 = new JTextField();
        li14.setBounds(328, 94, 45, 17);
        
        JTextField lo14 = new JTextField();
        lo14.setBounds(380, 94, 45, 17);
        
        JLabel day15 = new JLabel("Day 15 (HH:MM):"); // creates a label to be added inside frameTitleP panel
        day15.setForeground(new Color(0x0E3171)); // sets the font color of the text
        day15.setFont(new Font("Arial", Font.BOLD, 12)); // sets the font of the text
        day15.setOpaque(true); // this will display background color
        day15.setVerticalAlignment(JLabel.CENTER); // sets the Vertical position of the frameTitleL (icon + Text)
        day15.setHorizontalAlignment(JLabel.LEFT); // sets the Horizontal position of the frameTitleL (icon + Text)
        day15.setBounds(225, 115, 95, 15); // sets the position of the entire label on the frame
        
        JTextField li15 = new JTextField();
        li15.setBounds(328, 114, 45, 17);
        
        JTextField lo15 = new JTextField();
        lo15.setBounds(380, 114, 45, 17);
        
        JLabel day16 = new JLabel("Day 16 (HH:MM):"); // creates a label to be added inside frameTitleP panel
        day16.setForeground(new Color(0x0E3171)); // sets the font color of the text
        day16.setFont(new Font("Arial", Font.BOLD, 12)); // sets the font of the text
        day16.setOpaque(true); // this will display background color
        day16.setVerticalAlignment(JLabel.CENTER); // sets the Vertical position of the frameTitleL (icon + Text)
        day16.setHorizontalAlignment(JLabel.LEFT); // sets the Horizontal position of the frameTitleL (icon + Text)
        day16.setBounds(225, 135, 95, 15); // sets the position of the entire label on the frame
        
        JTextField li16 = new JTextField();
        li16.setBounds(328, 134, 45, 17);
        
        JTextField lo16 = new JTextField();
        lo16.setBounds(380, 134, 45, 17);
        
        JLabel day17 = new JLabel("Day 17 (HH:MM):"); // creates a label to be added inside frameTitleP panel
        day17.setForeground(new Color(0x0E3171)); // sets the font color of the text
        day17.setFont(new Font("Arial", Font.BOLD, 12)); // sets the font of the text
        day17.setOpaque(true); // this will display background color
        day17.setVerticalAlignment(JLabel.CENTER); // sets the Vertical position of the frameTitleL (icon + Text)
        day17.setHorizontalAlignment(JLabel.LEFT); // sets the Horizontal position of the frameTitleL (icon + Text)
        day17.setBounds(225, 155, 95, 15); // sets the position of the entire label on the frame
        
        JTextField li17 = new JTextField();
        li17.setBounds(328, 154, 45, 17);
        
        JTextField lo17 = new JTextField();
        lo17.setBounds(380, 154, 45, 17);
        
        JLabel day18 = new JLabel("Day 18 (HH:MM):"); // creates a label to be added inside frameTitleP panel
        day18.setForeground(new Color(0x0E3171)); // sets the font color of the text
        day18.setFont(new Font("Arial", Font.BOLD, 12)); // sets the font of the text
        day18.setOpaque(true); // this will display background color
        day18.setVerticalAlignment(JLabel.CENTER); // sets the Vertical position of the frameTitleL (icon + Text)
        day18.setHorizontalAlignment(JLabel.LEFT); // sets the Horizontal position of the frameTitleL (icon + Text)
        day18.setBounds(225, 175, 95, 15); // sets the position of the entire label on the frame
        
        JTextField li18 = new JTextField();
        li18.setBounds(328, 174, 45, 17);
        
        JTextField lo18 = new JTextField();
        lo18.setBounds(380, 174, 45, 17);
        
        JLabel day19 = new JLabel("Day 19 (HH:MM):"); // creates a label to be added inside frameTitleP panel
        day19.setForeground(new Color(0x0E3171)); // sets the font color of the text
        day19.setFont(new Font("Arial", Font.BOLD, 12)); // sets the font of the text
        day19.setOpaque(true); // this will display background color
        day19.setVerticalAlignment(JLabel.CENTER); // sets the Vertical position of the frameTitleL (icon + Text)
        day19.setHorizontalAlignment(JLabel.LEFT); // sets the Horizontal position of the frameTitleL (icon + Text)
        day19.setBounds(225, 195, 95, 15); // sets the position of the entire label on the frame
        
        JTextField li19 = new JTextField();
        li19.setBounds(328, 194, 45, 17);
        
        JTextField lo19 = new JTextField();
        lo19.setBounds(380, 194, 45, 17);
        
        JLabel day20 = new JLabel("Day 20 (HH:MM):"); // creates a label to be added inside frameTitleP panel
        day20.setForeground(new Color(0x0E3171)); // sets the font color of the text
        day20.setFont(new Font("Arial", Font.BOLD, 12)); // sets the font of the text
        day20.setOpaque(true); // this will display background color
        day20.setVerticalAlignment(JLabel.CENTER); // sets the Vertical position of the frameTitleL (icon + Text)
        day20.setHorizontalAlignment(JLabel.LEFT); // sets the Horizontal position of the frameTitleL (icon + Text)
        day20.setBounds(225, 215, 95, 15); // sets the position of the entire label on the frame
        
        JTextField li20 = new JTextField();
        li20.setBounds(328, 214, 45, 17);
        
        JTextField lo20 = new JTextField();
        lo20.setBounds(380, 214, 45, 17);
        
        JLabel day21 = new JLabel("Day 21 (HH:MM):"); // creates a label to be added inside frameTitleP panel
        day21.setForeground(new Color(0x0E3171)); // sets the font color of the text
        day21.setFont(new Font("Arial", Font.BOLD, 12)); // sets the font of the text
        day21.setOpaque(true); // this will display background color
        day21.setVerticalAlignment(JLabel.CENTER); // sets the Vertical position of the frameTitleL (icon + Text)
        day21.setHorizontalAlignment(JLabel.LEFT); // sets the Horizontal position of the frameTitleL (icon + Text)
        day21.setBounds(225, 235, 95, 15); // sets the position of the entire label on the frame
        
        JTextField li21 = new JTextField();
        li21.setBounds(328, 234, 45, 17);
        
        JTextField lo21 = new JTextField();
        lo21.setBounds(380, 234, 45, 17);
        
        JLabel day22 = new JLabel("Day 22 (HH:MM):"); // creates a label to be added inside frameTitleP panel
        day22.setForeground(new Color(0x0E3171)); // sets the font color of the text
        day22.setFont(new Font("Arial", Font.BOLD, 12)); // sets the font of the text
        day22.setOpaque(true); // this will display background color
        day22.setVerticalAlignment(JLabel.CENTER); // sets the Vertical position of the frameTitleL (icon + Text)
        day22.setHorizontalAlignment(JLabel.LEFT); // sets the Horizontal position of the frameTitleL (icon + Text)
        day22.setBounds(225, 255, 95, 15); // sets the position of the entire label on the frame
        
        JTextField li22 = new JTextField();
        li22.setBounds(328, 254, 45, 17);
        
        JTextField lo22 = new JTextField();
        lo22.setBounds(380, 254, 45, 17);
        
        JLabel lunchDed = new JLabel("Enter Number of Days with 1 hour Lunch Deduction: "); // creates a label to be added inside frameTitleP panel
        lunchDed.setForeground(new Color(0x0E3171)); // sets the font color of the text
        lunchDed.setFont(new Font("Arial", Font.BOLD, 12)); // sets the font of the text
        lunchDed.setOpaque(true); // this will display background color
        lunchDed.setVerticalAlignment(JLabel.CENTER); // sets the Vertical position of the frameTitleL (icon + Text)
        lunchDed.setHorizontalAlignment(JLabel.LEFT); // sets the Horizontal position of the frameTitleL (icon + Text)
        lunchDed.setBounds(10, 285, 340, 15); // sets the position of the entire label on the frame
        
        JTextField lunchDur = new JTextField();
        lunchDur.setBounds(380, 284, 45, 17);
        
        JLabel adjEarnings3 = new JLabel("Enter amount of adjustment on Taxable Earnings:"); // creates a label to be added inside frameTitleP panel
        adjEarnings3.setForeground(new Color(0x0E3171)); // sets the font color of the text
        adjEarnings3.setFont(new Font("Arial", Font.BOLD, 12)); // sets the font of the text
        adjEarnings3.setOpaque(true); // this will display background color
        adjEarnings3.setVerticalAlignment(JLabel.CENTER); // sets the Vertical position of the frameTitleL (icon + Text)
        adjEarnings3.setHorizontalAlignment(JLabel.LEFT); // sets the Horizontal position of the frameTitleL (icon + Text)
        adjEarnings3.setBounds(10, 305, 340, 15); // sets the position of the entire label on the frame
        
        JTextField adjEarning3 = new JTextField();
        adjEarning3.setBounds(380, 304, 45, 17);
       
        JLabel otRate3 = new JLabel("Enter overtime rate in decimal form (sample 1.25 for 125%):"); // creates a label to be added inside frameTitleP panel
        otRate3.setForeground(new Color(0x0E3171)); // sets the font color of the text
        otRate3.setFont(new Font("Arial", Font.BOLD, 12)); // sets the font of the text
        otRate3.setOpaque(true); // this will display background color
        otRate3.setVerticalAlignment(JLabel.CENTER); // sets the Vertical position of the frameTitleL (icon + Text)
        otRate3.setHorizontalAlignment(JLabel.LEFT); // sets the Horizontal position of the frameTitleL (icon + Text)
        otRate3.setBounds(10, 325, 340, 15); // sets the position of the entire label on the frame

        JTextField otPay3 = new JTextField();
        otPay3.setBounds(380, 324, 45, 17);
        
        
        
        // Create the JCheckBox with the retrieved benefits
       JCheckBox benefits3 = new JCheckBox("<html>" +
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
        benefits3.setBounds(10, 345, 350, 80);
        
        JLabel adjBen3 = new JLabel("Enter amount of adjustment on Non-Taxable Earnings:"); // creates a label to be added inside frameTitleP panel
        adjBen3.setForeground(new Color(0x0E3171)); // sets the font color of the text
        adjBen3.setFont(new Font("Arial", Font.BOLD, 12)); // sets the font of the text
        adjBen3.setOpaque(true); // this will display background color
        adjBen3.setVerticalAlignment(JLabel.CENTER); // sets the Vertical position of the frameTitleL (icon + Text)
        adjBen3.setHorizontalAlignment(JLabel.LEFT); // sets the Horizontal position of the frameTitleL (icon + Text)
        adjBen3.setBounds(10, 430, 350, 15); // sets the position of the entire label on the frame
        
        JTextField adjBene3 = new JTextField();
        adjBene3.setBounds(380, 429, 45, 17);
        
        JButton calculate3 = new JButton("Calculate");
        calculate3.setBounds(225, 460, 150, 20);
        
        JLabel grossTaxable3 = new JLabel("Gross Taxable Earnings: "); // creates a label to be added inside frameTitleP panel
        grossTaxable3.setForeground(new Color(0x0E3171)); // sets the font color of the text
        grossTaxable3.setFont(new Font("Arial", Font.BOLD, 12)); // sets the font of the text
        grossTaxable3.setOpaque(true); // this will display background color
        grossTaxable3.setVerticalAlignment(JLabel.CENTER); // sets the Vertical position of the frameTitleL (icon + Text)
        grossTaxable3.setHorizontalAlignment(JLabel.LEFT); // sets the Horizontal position of the frameTitleL (icon + Text)
        grossTaxable3.setBounds(5, 495, 190, 15); // sets the position of the entire label on the frame
        
        JLabel grossTaxabl3 = new JLabel("Gross"); // creates a label to be added inside frameTitleP panel
        grossTaxabl3.setForeground(new Color(0x0E3171)); // sets the font color of the text
        grossTaxabl3.setFont(new Font("Arial", Font.BOLD, 12)); // sets the font of the text
        grossTaxabl3.setOpaque(true); // this will display background color
        grossTaxabl3.setVerticalAlignment(JLabel.CENTER); // sets the Vertical position of the frameTitleL (icon + Text)
        grossTaxabl3.setHorizontalAlignment(JLabel.LEFT); // sets the Horizontal position of the frameTitleL (icon + Text)
        grossTaxabl3.setBounds(210, 494, 50, 17); // sets the position of the entire label on the frame
        
        JLabel adjTaxable3 = new JLabel("Taxable Earnings Adjustment: "); // creates a label to be added inside frameTitleP panel
        adjTaxable3.setForeground(new Color(0x0E3171)); // sets the font color of the text
        adjTaxable3.setFont(new Font("Arial", Font.BOLD, 12)); // sets the font of the text
        adjTaxable3.setOpaque(true); // this will display background color
        adjTaxable3.setVerticalAlignment(JLabel.CENTER); // sets the Vertical position of the frameTitleL (icon + Text)
        adjTaxable3.setHorizontalAlignment(JLabel.LEFT); // sets the Horizontal position of the frameTitleL (icon + Text)
        adjTaxable3.setBounds(5, 515, 190, 15); // sets the position of the entire label on the frame
        
        JLabel adjTaxabl3 = new JLabel("G Adj"); // creates a label to be added inside frameTitleP panel
        adjTaxabl3.setForeground(new Color(0x0E3171)); // sets the font color of the text
        adjTaxabl3.setFont(new Font("Arial", Font.BOLD, 12)); // sets the font of the text
        adjTaxabl3.setOpaque(true); // this will display background color
        adjTaxabl3.setVerticalAlignment(JLabel.CENTER); // sets the Vertical position of the frameTitleL (icon + Text)
        adjTaxabl3.setHorizontalAlignment(JLabel.LEFT); // sets the Horizontal position of the frameTitleL (icon + Text)
        adjTaxabl3.setBounds(210, 514, 50, 17); // sets the position of the entire label on the frame
        
        JLabel sss3 = new JLabel("SSS Deduction: "); // creates a label to be added inside frameTitleP panel
        sss3.setForeground(new Color(0x0E3171)); // sets the font color of the text
        sss3.setFont(new Font("Arial", Font.BOLD, 12)); // sets the font of the text
        sss3.setOpaque(true); // this will display background color
        sss3.setVerticalAlignment(JLabel.CENTER); // sets the Vertical position of the frameTitleL (icon + Text)
        sss3.setHorizontalAlignment(JLabel.LEFT); // sets the Horizontal position of the frameTitleL (icon + Text)
        sss3.setBounds(5, 535, 190, 15); // sets the position of the entire label on the frame
        
        JLabel sssDed3 = new JLabel("SSS Ded"); // creates a label to be added inside frameTitleP panel
        sssDed3.setForeground(new Color(0x0E3171)); // sets the font color of the text
        sssDed3.setFont(new Font("Arial", Font.BOLD, 12)); // sets the font of the text
        sssDed3.setOpaque(true); // this will display background color
        sssDed3.setVerticalAlignment(JLabel.CENTER); // sets the Vertical position of the frameTitleL (icon + Text)
        sssDed3.setHorizontalAlignment(JLabel.LEFT); // sets the Horizontal position of the frameTitleL (icon + Text)
        sssDed3.setBounds(210, 534, 50, 17); // sets the position of the entire label on the frame
        
        JLabel philH3 = new JLabel("PhilHealth Deduction: "); // creates a label to be added inside frameTitleP panel
        philH3.setForeground(new Color(0x0E3171)); // sets the font color of the text
        philH3.setFont(new Font("Arial", Font.BOLD, 12)); // sets the font of the text
        philH3.setOpaque(true); // this will display background color
        philH3.setVerticalAlignment(JLabel.CENTER); // sets the Vertical position of the frameTitleL (icon + Text)
        philH3.setHorizontalAlignment(JLabel.LEFT); // sets the Horizontal position of the frameTitleL (icon + Text)
        philH3.setBounds(5, 555, 190, 15); // sets the position of the entire label on the frame
        
        JLabel philDed3 = new JLabel("Phil Ded"); // creates a label to be added inside frameTitleP panel
        philDed3.setForeground(new Color(0x0E3171)); // sets the font color of the text
        philDed3.setFont(new Font("Arial", Font.BOLD, 12)); // sets the font of the text
        philDed3.setOpaque(true); // this will display background color
        philDed3.setVerticalAlignment(JLabel.CENTER); // sets the Vertical position of the frameTitleL (icon + Text)
        philDed3.setHorizontalAlignment(JLabel.LEFT); // sets the Horizontal position of the frameTitleL (icon + Text)
        philDed3.setBounds(210, 554, 50, 17); // sets the position of the entire label on the frame
        
        JLabel pagIbg3 = new JLabel("PagIbig Deduction: "); // creates a label to be added inside frameTitleP panel
        pagIbg3.setForeground(new Color(0x0E3171)); // sets the font color of the text
        pagIbg3.setFont(new Font("Arial", Font.BOLD, 12)); // sets the font of the text
        pagIbg3.setOpaque(true); // this will display background color
        pagIbg3.setVerticalAlignment(JLabel.CENTER); // sets the Vertical position of the frameTitleL (icon + Text)
        pagIbg3.setHorizontalAlignment(JLabel.LEFT); // sets the Horizontal position of the frameTitleL (icon + Text)
        pagIbg3.setBounds(5, 575, 190, 15); // sets the position of the entire label on the frame
        
        JLabel pagIbgDed3 = new JLabel("PagIbgDed Ded"); // creates a label to be added inside frameTitleP panel
        pagIbgDed3.setForeground(new Color(0x0E3171)); // sets the font color of the text
        pagIbgDed3.setFont(new Font("Arial", Font.BOLD, 12)); // sets the font of the text
        pagIbgDed3.setOpaque(true); // this will display background color
        pagIbgDed3.setVerticalAlignment(JLabel.CENTER); // sets the Vertical position of the frameTitleL (icon + Text)
        pagIbgDed3.setHorizontalAlignment(JLabel.LEFT); // sets the Horizontal position of the frameTitleL (icon + Text)
        pagIbgDed3.setBounds(210, 574, 50, 17); // sets the position of the entire label on the frame
        
        JLabel withholding3 = new JLabel("Witholding Tax Deduction: "); // creates a label to be added inside frameTitleP panel
        withholding3.setForeground(new Color(0x0E3171)); // sets the font color of the text
        withholding3.setFont(new Font("Arial", Font.BOLD, 12)); // sets the font of the text
        withholding3.setOpaque(true); // this will display background color
        withholding3.setVerticalAlignment(JLabel.CENTER); // sets the Vertical position of the frameTitleL (icon + Text)
        withholding3.setHorizontalAlignment(JLabel.LEFT); // sets the Horizontal position of the frameTitleL (icon + Text)
        withholding3.setBounds(5, 595, 190, 15); // sets the position of the entire label on the frame
        
        JLabel withholdingDed3 = new JLabel("Witholding Tax Ded"); // creates a label to be added inside frameTitleP panel
        withholdingDed3.setForeground(new Color(0x0E3171)); // sets the font color of the text
        withholdingDed3.setFont(new Font("Arial", Font.BOLD, 12)); // sets the font of the text
        withholdingDed3.setOpaque(true); // this will display background color
        withholdingDed3.setVerticalAlignment(JLabel.CENTER); // sets the Vertical position of the frameTitleL (icon + Text)
        withholdingDed3.setHorizontalAlignment(JLabel.LEFT); // sets the Horizontal position of the frameTitleL (icon + Text)
        withholdingDed3.setBounds(210, 594, 50, 17); // sets the position of the entire label on the frame
        
        JLabel benefitsL3 = new JLabel("Non-Taxable Benefits Pay: "); // creates a label to be added inside frameTitleP panel
        benefitsL3.setForeground(new Color(0x0E3171)); // sets the font color of the text
        benefitsL3.setFont(new Font("Arial", Font.BOLD, 12)); // sets the font of the text
        benefitsL3.setOpaque(true); // this will display background color
        benefitsL3.setVerticalAlignment(JLabel.CENTER); // sets the Vertical position of the frameTitleL (icon + Text)
        benefitsL3.setHorizontalAlignment(JLabel.LEFT); // sets the Horizontal position of the frameTitleL (icon + Text)
        benefitsL3.setBounds(310, 495, 210, 15); // sets the position of the entire label on the frame
        
        JLabel benefitsPay3 = new JLabel("Bene"); // creates a label to be added inside frameTitleP panel
        benefitsPay3.setForeground(new Color(0x0E3171)); // sets the font color of the text
        benefitsPay3.setFont(new Font("Arial", Font.BOLD, 12)); // sets the font of the text
        benefitsPay3.setOpaque(true); // this will display background color
        benefitsPay3.setVerticalAlignment(JLabel.CENTER); // sets the Vertical position of the frameTitleL (icon + Text)
        benefitsPay3.setHorizontalAlignment(JLabel.LEFT); // sets the Horizontal position of the frameTitleL (icon + Text)
        benefitsPay3.setBounds(525, 494, 50, 17); // sets the position of the entire label on the frame
        
        JLabel benefitsAdjL3 = new JLabel("Non-Taxable Benefits Adjustment: "); // creates a label to be added inside frameTitleP panel
        benefitsAdjL3.setForeground(new Color(0x0E3171)); // sets the font color of the text
        benefitsAdjL3.setFont(new Font("Arial", Font.BOLD, 12)); // sets the font of the text
        benefitsAdjL3.setOpaque(true); // this will display background color
        benefitsAdjL3.setVerticalAlignment(JLabel.CENTER); // sets the Vertical position of the frameTitleL (icon + Text)
        benefitsAdjL3.setHorizontalAlignment(JLabel.LEFT); // sets the Horizontal position of the frameTitleL (icon + Text)
        benefitsAdjL3.setBounds(310, 515, 210, 15); // sets the position of the entire label on the frame
        
        JLabel benefitsAdjDed3 = new JLabel("Bene Adj"); // creates a label to be added inside frameTitleP panel
        benefitsAdjDed3.setForeground(new Color(0x0E3171)); // sets the font color of the text
        benefitsAdjDed3.setFont(new Font("Arial", Font.BOLD, 12)); // sets the font of the text
        benefitsAdjDed3.setOpaque(true); // this will display background color
        benefitsAdjDed3.setVerticalAlignment(JLabel.CENTER); // sets the Vertical position of the frameTitleL (icon + Text)
        benefitsAdjDed3.setHorizontalAlignment(JLabel.LEFT); // sets the Horizontal position of the frameTitleL (icon + Text)
        benefitsAdjDed3.setBounds(525, 514, 50, 17); // sets the position of the entire label on the frame
        
        JLabel netPayL3 = new JLabel("Net Pay: "); // creates a label to be added inside frameTitleP panel
        netPayL3.setForeground(new Color(0x0E3171)); // sets the font color of the text
        netPayL3.setFont(new Font("Arial", Font.BOLD, 12)); // sets the font of the text
        netPayL3.setOpaque(true); // this will display background color
        netPayL3.setVerticalAlignment(JLabel.CENTER); // sets the Vertical position of the frameTitleL (icon + Text)
        netPayL3.setHorizontalAlignment(JLabel.LEFT); // sets the Horizontal position of the frameTitleL (icon + Text)
        netPayL3.setBounds(310, 555, 210, 15); // sets the position of the entire label on the frame
        
        JLabel netPay3 = new JLabel("Net"); // creates a label to be added inside frameTitleP panel
        netPay3.setForeground(new Color(0x0E3171)); // sets the font color of the text
        netPay3.setFont(new Font("Arial", Font.BOLD, 12)); // sets the font of the text
        netPay3.setOpaque(true); // this will display background color
        netPay3.setVerticalAlignment(JLabel.CENTER); // sets the Vertical position of the frameTitleL (icon + Text)
        netPay3.setHorizontalAlignment(JLabel.LEFT); // sets the Horizontal position of the frameTitleL (icon + Text)
        netPay3.setBounds(525, 554, 50, 17); // sets the position of the entire label on the frame
        
        JButton submit3 = new JButton("Submit for Payroll");
        submit3.setBounds(225, 625, 150, 20);


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
        tab1.add(grossTaxable1);tab1.add(grossTaxabl1);tab1.add(adjTaxable1);tab1.add(adjTaxabl1);tab1.add(sss1);tab1.add(sssDed1);
        tab1.add(philDed1);tab1.add(philH1);tab1.add(pagIbgDed1);tab1.add(pagIbg1);tab1.add(withholdingDed1);tab1.add(withholding1);
        tab1.add(benefitsPay1);tab1.add(benefitsL1);tab1.add(benefitsAdjDed1);tab1.add(benefitsAdjL1);tab1.add(netPay1);tab1.add(netPayL1);tab1.add(submit1);

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
        tab2.add(grossTaxable2);tab2.add(grossTaxabl2);tab2.add(adjTaxable2);tab2.add(adjTaxabl2);tab2.add(sss2);tab2.add(sssDed2);
        tab2.add(philDed2);tab2.add(philH2);tab2.add(pagIbgDed2);tab2.add(pagIbg2);tab2.add(withholdingDed2);tab2.add(withholding2);
        tab2.add(benefitsPay2);tab2.add(benefitsL2);tab2.add(benefitsAdjDed2);tab2.add(benefitsAdjL2);tab2.add(netPay2);tab2.add(netPayL2);tab2.add(submit2);

        JPanel tab3 = new JPanel(null);
        tab3.add(header3);
        tab3.add(login1);tab3.add(logout1);tab3.add(login2);tab3.add(logout2);
        tab3.add(day1);tab3.add(day2);tab3.add(day3);tab3.add(day4);tab3.add(day5);tab3.add(day6);tab3.add(day7);
        tab3.add(day8);tab3.add(day9);tab3.add(day10);tab3.add(day11);tab3.add(day12);tab3.add(day13);tab3.add(day14);
        tab3.add(day15);tab3.add(day16);tab3.add(day17);tab3.add(day18);tab3.add(day19);tab3.add(day20);tab3.add(day21);
        tab3.add(day22);
        tab3.add(li1);tab3.add(li2);tab3.add(li3);tab3.add(li4);tab3.add(li5);tab3.add(li6);tab3.add(li7);
        tab3.add(li8);tab3.add(li9);tab3.add(li10);tab3.add(li11);tab3.add(li12);tab3.add(li13);tab3.add(li14);
        tab3.add(li15);tab3.add(li16);tab3.add(li17);tab3.add(li18);tab3.add(li19);tab3.add(li20);tab3.add(li21);
        tab3.add(li22);
        tab3.add(lo1);tab3.add(lo2);tab3.add(lo3);tab3.add(lo4);tab3.add(lo5);tab3.add(lo6);tab3.add(lo7);
        tab3.add(lo8);tab3.add(lo9);tab3.add(lo10);tab3.add(lo11);tab3.add(lo12);tab3.add(lo13);tab3.add(lo14);
        tab3.add(lo15);tab3.add(lo16);tab3.add(lo17);tab3.add(lo18);tab3.add(lo19);tab3.add(lo20);tab3.add(lo21);
        tab3.add(lo22);
        tab3.add(lunchDed);tab3.add(lunchDur);
        tab3.add(adjEarnings3);tab3.add(adjEarning3);
        tab3.add(otRate3);tab3.add(otPay3);
        tab3.add(benefits3);
        tab3.add(adjBen3);tab3.add(adjBene3);
        tab3.add(calculate3);
        tab3.add(grossTaxable3);tab3.add(grossTaxabl3);tab3.add(adjTaxable3);tab3.add(adjTaxabl3);tab3.add(sss3);tab3.add(sssDed3);
        tab3.add(philDed3);tab3.add(philH3);tab3.add(pagIbgDed3);tab3.add(pagIbg3);tab3.add(withholdingDed3);tab3.add(withholding3);
        tab3.add(benefitsPay3);tab3.add(benefitsL3);tab3.add(benefitsAdjDed3);tab3.add(benefitsAdjL3);tab3.add(netPay3);tab3.add(netPayL3);tab3.add(submit3);
                   
                  
        

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