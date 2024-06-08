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
public class ComputeSalary extends JFrame{

ComputeSalary () {
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
        
        JLabel employeeDetails = new JLabel(); // creates a label
        employeeDetails.setText("   Employee Number and Name Goes here   "); // sets text for the label
        employeeDetails.setForeground(new Color(255, 255, 255, 255)); // sets the font color of the text
        employeeDetails.setFont(new Font("Arial", Font.BOLD, 15)); // sets the font of the text
        employeeDetails.setBackground(new Color(0x0E3171)); // sets the background color of the label
        employeeDetails.setOpaque(true); // this will display background color
        employeeDetails.setVerticalAlignment(JLabel.BOTTOM); // sets the Vertical position of the label (icon + Text)
        employeeDetails.setHorizontalAlignment(JLabel.CENTER); // sets the Horizontal position of the label (icon + Text)
        employeeDetails.setBounds(0, 0, 600, 20); // sets the position of the entire label on the frame
        
        
        
        JPanel bodyPanel = new JPanel(); // creates a panel for the dropdown list
        bodyPanel.setBackground(new Color(255, 255, 255, 255)); // sets the background color of the panel
        bodyPanel.setBounds(10, 130, 600, 825); // sets the position of the panel on the frame
        bodyPanel.add(employeeDetails); // add drop-down to the panel
        
        //JFrame frame = new JFrame();
        this.setTitle("Motor PH - CP2 | Group 3: Employee Salary Calculation Page"); // sets the title for employee selection page
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit out of application
        this.setResizable(false); // prevent frame from being resized
        this.setSize(633, 1000); // sets the x-dimension, and y-dimension of frame
        this.setVisible(true); // make frame visible-should be set on the end
        this.setIconImage(logo.getImage()); // to apply the image icon named logo as the frame logo
        this.getContentPane().setBackground(new Color(0x0E3171)); // change color of background
        this.setLayout(null); // allows to define the position of the label by setbounds
        this.add(headerLabel); // add the employeeDDLabel on the frame
        this.add(bodyPanel); // add the employeeDDLabel on the frame
        
        
    }
}
    
    

    
    
    

