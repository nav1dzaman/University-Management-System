package universitymanagement;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.in;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.util.Date;
import javax.swing.JOptionPane;

public class notice {
    JFrame ntc;
   notice(){
       ntc=new JFrame("Notice Management");
       ntc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ntc.setSize(901,499);
		
		ntc.setLayout(null);
                ntc.setVisible(true);
		
		JLabel label1 = new JLabel("Notice Management");
		label1.setFont(new Font("Tahoma", Font.BOLD, 20));
		label1.setBounds(349, 0, 269, 39);
		ntc.add(label1);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(110, 75, 703, 329);
		ntc.add(textPane);
                 JTextField textField = new JTextField();
		textField.setBounds(324, 44, 257, 20);
		ntc.add(textField);
		textField.setColumns(10);
                 JLabel time = new JLabel("TIME :");
		time.setBounds(798, 16, 49, 14);
		ntc.add(time);
		
		JLabel date_show = new JLabel("");
		date_show.setBounds(695, 47, 182, 14);
		ntc.add(date_show);
                Date dt=new Date();
                String dat=String.valueOf(dt);
                date_show.setText(dat);
		
		JButton button = new JButton("Publish Notice");
		button.setBounds(342, 415, 220, 23);
		ntc.add(button);
                 button.addActionListener(new ActionListener() {  
	               public void actionPerformed(ActionEvent e) {       
	                	Date date=new Date(); 
                           String text=textField.getText();
                           String thenotice=textPane.getText();
                           
                           FileWriter fwrite=null;
		BufferedWriter bw=null;
		PrintWriter pw=null;
		
		try {
		    // fle= new File();
			 fwrite =new FileWriter("notice.txt");
			 bw =new BufferedWriter(fwrite);
			 pw=new PrintWriter(bw);
			
			pw.println(text);
                        pw.println("Date : "+dat);
                        pw.println(thenotice);
                        
                        bw.close();
			pw.close();
                        
                        
		}          catch (IOException ex) {
                          
                           }finally {
			
		}
                           
	         JOptionPane.showMessageDialog(ntc,"The Notice has been published!");        
	               }  
	            }); 
		
       
		
		JLabel label2 = new JLabel("Title:");
		label2.setFont(new Font("Tahoma", Font.BOLD, 11));
		label2.setBounds(249, 47, 49, 14);
		ntc.add(label2);
		
		JButton button4 = new JButton("<Back");
		button4.setBounds(10, 12, 87, 32);
		ntc.add(button4);
                 button4.addActionListener(new ActionListener() {  
	               public void actionPerformed(ActionEvent e) {       

	                	  ntc.setVisible(false);
	                	  pannel nw=new pannel();
	                      
	               }  
	            });
                 
                
                
   }
}
