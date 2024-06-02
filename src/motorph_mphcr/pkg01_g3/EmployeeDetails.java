/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package motorph_mphcr.pkg01_g3;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author amatibag
 * includes the use of JPanel and JFrame
 * JPanel = a GUI component that functions as a container to hold other components
 */
public class EmployeeDetails extends JFrame{
        
     EmployeeDetails(){ //contructor
        
        ImageIcon logo = new ImageIcon("logo.png"); // creates the logo
        ImageIcon smallLogo = new ImageIcon("SmallLogo.png"); // creates the logo
        ImageIcon motorPHHeader = new ImageIcon("MotorPHHeader.png"); //inserts an image for the label
         
        JLabel frameTitleL = new JLabel(); //creates a label to be added inside frameTitleP panel
        frameTitleL.setText("Motor PH - CP2 | Group 3: Employee Details Page"); // text that will be reflected on the frameTitleL Label
        frameTitleL.setIcon(smallLogo); //adds the logo on the JLabel frameTitleL
        //frameTitleL.setHorizontalTextPosition(JLabel.CENTER); //sets the Horizontal position of the text with image icon
        //frameTitleL.setVerticalTextPosition(JLabel.TOP); //sets the Vertical position of the text with image icon
        frameTitleL.setForeground(new Color(0xFFFFFF)); //sets the font color of the text
        frameTitleL.setFont(new Font("Arial", Font.BOLD, 30)); //sets the font of the text
        frameTitleL.setBackground(new Color(0x0E3171));//sets the background color of the label
        frameTitleL.setOpaque(true); // this will display background color
        frameTitleL.setVerticalAlignment(JLabel.TOP); //sets the Vertical position of  the frameTitleL (icon + Text)
        frameTitleL.setHorizontalAlignment(JLabel.CENTER); //sets the Horizontal position of  the frameTitleL (icon + Text)
        //frameTitleL.setBounds(0,2,1265,150);// sets the position of the entire label on the frame
        
        JLabel backgroundImageL = new JLabel(); //creates a label to be added inside titleHolder panel
        backgroundImageL.setIcon(motorPHHeader); // add the motorPH background
        //backgroundImageL.setVerticalAlignment(JLabel.TOP); //sets the Vertical position of  the backgroundImage
        //backgroundImageL.setHorizontalAlignment(JLabel.CENTER); //sets the Horizontal position of  the backgroundImage
       // backgroundImageL.setBounds(0,150,1265,480);// sets the position of the entire label on the frame
        
        JPanel frameTitleP = new JPanel();
        frameTitleP.setBackground(new Color(0x0E3171)); //sets the background color of the panel
        frameTitleP.setBounds(0,0,1265,150); //sets the position of the panel
        
        JPanel backgroundImageP = new JPanel();
        //backgroundImageP.setBackground(new Color(0x0E3171)); //sets the background color of the panel
        backgroundImageP.setBounds(0,100,1265,450); //sets the position of the panel
                
        JPanel bodyP = new JPanel();
        bodyP.setBackground(new Color(255,255,255,200)); //sets the background color of the panel
        bodyP.setBounds(50,100,1140,850); //sets the position of the panel
        
        //this is the name of the frame
        this.setTitle("Motor PH - CP2 | Group 3: Employee Details Page"); //sets the title for employee selection page
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit out of application
        this.setResizable(false); //prevent frame from being resized
        this.setSize(1265, 1000); //sets the x-dimension, and y-dimension of frame
        this.setLayout(null); //allows to define the position of the label by setbounds
        this.setVisible(true); //make frame visible-should be set on the end
               
        this.setIconImage(logo.getImage());  // to apply the image icon named logo as the frame logo
        this.getContentPane().setBackground(new Color(0x0E3171)); //change color of background
            //options: Color.red; new Color(14,49,113); new Color(0x0HEX)
        //this.pack(); // can be used to automatically adjust the size of the frame depending on what it contains
            //note if pack function is used no need to use setBounds, setResizable, setSize and setLayout
            //make sure that all components are added before using the pack
        this.add(bodyP); // adds the panel on the frame
        frameTitleP.add(frameTitleL); // add the JLabel frameTitleL inside the frameTitleP panel
        backgroundImageP.add(backgroundImageL); // add the JLabel backgroundImageP inside the frameTitleP panel
        this.add(frameTitleP); // adds the panel on the frame
        this.add(backgroundImageP);
        
    
    }
}
