package universitymanagement;
import static com.sun.java.accessibility.util.AWTEventMonitor.addActionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
public class pannel extends WindowAdapter {

	JFrame pnl;
	
	public pannel() {
		pnl=new JFrame("MainPanel");
                
		JLabel label1 = new JLabel(" University Management System  ");
		label1.setFont(new Font("Tahoma", Font.BOLD, 27));
		label1.setBounds(246, 11, 478, 33);
               pnl.addWindowListener(this); 
		pnl.add(label1);
		
		JLabel label2 = new JLabel("University authority access only!");
		label2.setBounds(336, 437, 197, 14);
                 
		pnl.add(label2);
		
		JButton button1 = new JButton("Courses");
	
		button1.setBounds(168, 161, 99, 36);
		pnl.add(button1);
                button1.addActionListener((ActionEvent e) -> {
                    pnl.setVisible(false);
                    try {
                        course crse=new course();
                    } catch (IOException ex) {
                       
                    }
                }); 
                
             //    pnl.setVisible(false);
                             
	        
		
		JButton button2 = new JButton("Faculty");
		
		button2.setBounds(601, 159, 98, 36);
		pnl.add(button2);
                 button2.addActionListener(new ActionListener() {  
	               public void actionPerformed(ActionEvent e) {       
	                	  pnl.setVisible(false);
                           try {      
                               faculty nw=new faculty();
                           } catch (IOException ex) {
                              
                           }
	               }  
	            }); 
		
		JButton button3 = new JButton("Student Management");
		button3.setBounds(353, 160, 176, 36);
		pnl.add(button3);
                button3.addActionListener((ActionEvent e) -> {
                    pnl.setVisible(false);
                    try {
                        student std=new student();
                    } catch (IOException ex) {
                       
                    }
                }); 
		
		
		JButton button5 = new JButton("Payment");
		button5.setBounds(262, 222, 135, 36);
		pnl.add(button5);
                button5.addActionListener(new ActionListener() {  
                       @Override
	               public void actionPerformed(ActionEvent e) {       
	                       pnl.setVisible(false);
                             payment pt=new payment();
	                 }
	                      
	               } );
               
		
		JButton button6 = new JButton("Notice Board");
		button6.setBounds(455, 222, 129, 36);
		pnl.add(button6);
                 button6.addActionListener(new ActionListener() {  
                       @Override
	               public void actionPerformed(ActionEvent e) {       
	                       pnl.setVisible(false);
                               notice stt=new notice();
	                 }
	                      
	               } );
		
		JLabel label3 = new JLabel("Welcome to main panel!");
		label3.setBounds(379, 55, 197, 14); 
		pnl.add(label3);
                
               
                JButton button7 = new JButton("Sign out!");
		button7.setBounds(384, 390, 105, 36);
		pnl.add(button7);
                   button7.addActionListener(new ActionListener() {  
	               public void actionPerformed(ActionEvent e) { 
  
    int n = JOptionPane.showOptionDialog(null,"Do you really want to signout?","Warning!",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,null,null);  
    if(n==0){
         pnl.setVisible(false);
         startmenu stt=new startmenu();
    }
    
	                 }
	                      
	               } ); 
	        
		
		pnl.setSize(901,499); //frame
		pnl.setLayout(null);  //frame
		pnl.setVisible(true);  //frame
		pnl.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); 	
	}
        @Override
                public void windowClosing(WindowEvent e) {  
    int a=JOptionPane.showConfirmDialog(pnl,"Are you sure you want to Exit?");  
if(a==JOptionPane.YES_OPTION){  
    pnl.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
}  
} 

}
