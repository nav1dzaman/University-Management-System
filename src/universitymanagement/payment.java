package universitymanagement;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class payment {
    JFrame py;
    String money;
      payment(){
          py=new JFrame("University Internal Expenses");
          py.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		py.setSize(901,499);
		
		py.setLayout(null);
                py.setVisible(true);
		
		JLabel label1 = new JLabel("University Internal Expenses");
		label1.setFont(new Font("Tahoma", Font.BOLD, 20));
		label1.setBounds(315, 0, 386, 45);
		py.add(label1);
                
                JButton button = new JButton("<Back");
		button.setBounds(10, 15, 87, 32);
		py.add(button);
               button.addActionListener(new ActionListener() {  
                       @Override
	               public void actionPerformed(ActionEvent e) {       
	                      py.setVisible(false);
                              pannel pl=new pannel();
	                 }
	                      
	               } );
		
		JLabel label2 = new JLabel("Electricity Bill :");
		label2.setBounds(39, 101, 117, 24);
		py.add(label2);
		
        JTextField textField = new JTextField();
		textField.setBounds(166, 96, 167, 34);
		py.add(textField);
		textField.setColumns(10);
		
        JTextField textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(166, 156, 167, 34);
		py.add(textField_1);
		
        JTextField textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(166, 223, 167, 34);
		py.add(textField_2);
		
        JTextField textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(166, 295, 167, 34);
		py.add(textField_3);
		
        JTextField textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(166, 366, 167, 34);
		py.add(textField_4);
		
		JLabel lblWaterBill = new JLabel("Water Bill :");
		lblWaterBill.setBounds(39, 166, 117, 24);
		py.add(lblWaterBill);
		
		JLabel lblGroundCharger = new JLabel("Ground Charge :");
		lblGroundCharger.setBounds(39, 233, 132, 24);
		py.add(lblGroundCharger);
		
		JLabel lblStaffCost = new JLabel("Staff Cost :");
		lblStaffCost.setBounds(39, 305, 132, 24);
		py.add(lblStaffCost);
		
		JLabel lblMaintananceCost = new JLabel("Maintanance Cost :");
		lblMaintananceCost.setBounds(25, 371, 132, 24);
		py.add(lblMaintananceCost);
		
		JLabel lblTaka = new JLabel("Taka");
		lblTaka.setBounds(343, 101, 48, 24);
		py.add(lblTaka);
		
		JLabel lblTaka_1 = new JLabel("Taka");
		lblTaka_1.setBounds(343, 156, 48, 24);
		py.add(lblTaka_1);
		
		JLabel lblTaka_2 = new JLabel("Taka");
		lblTaka_2.setBounds(343, 228, 48, 24);
		py.add(lblTaka_2);
		
		JLabel lblTaka_3 = new JLabel("Taka");
		lblTaka_3.setBounds(343, 300, 48, 24);
		py.add(lblTaka_3);
		
		JLabel lblTaka_4 = new JLabel("Taka");
		lblTaka_4.setBounds(343, 371, 48, 24);
		py.add(lblTaka_4);
                
                 JLabel label4 = new JLabel("");
		label4.setFont(new Font("Tahoma", Font.BOLD, 17));
		label4.setBounds(542, 172, 314, 34);
		py.add(label4);
		
		JButton button5 = new JButton("calculate");
		button5.setBounds(563, 270, 89, 34);
		py.add(button5);
                button5.addActionListener(new ActionListener() {  
                       @Override
	               public void actionPerformed(ActionEvent e) {       
	                       String s1=textField.getText();
                               String s2=textField_1.getText();
                                String s3=textField_2.getText();
                                 String s4=textField_3.getText();
                                  String s5=textField_4.getText();
                                  
                              double d1=Double.parseDouble(s1);
                               double d2=Double.parseDouble(s2);
                                double d3=Double.parseDouble(s3); 
                                double d4=Double.parseDouble(s4);
                                 double d5=Double.parseDouble(s5);
                                 
                                 double sum=d1+d2+d3+d4+d5;
                            
                                 String sm=String.valueOf(sum);
                                 money=sm;
                                 sm+=" Taka Payable";
                                 label4.setText(sm);

	                 }
	                      
	               } );
                 
		
		JButton Slipbuttton = new JButton("Generate Bank Slip");
		Slipbuttton.setBounds(534, 332, 147, 34);
		py.add(Slipbuttton);
                Slipbuttton.addActionListener(new ActionListener() {  
                       @Override
	               public void actionPerformed(ActionEvent e) {       
	                 
                FileWriter fwrite=null;
		java.io.BufferedWriter bw=null;
		PrintWriter pw=null;
		
		try {
		
			 fwrite =new FileWriter("BANKSLIP.txt");
			 bw =new java.io.BufferedWriter(fwrite);
			 pw=new PrintWriter(bw);
			 pw.println("Bank of bangladesh");
                         pw.println("Digital Payment receipt Cheque");
                         String pay="Account NO: 1294847"+"   Account Holder: East_West University";
                         pw.println(pay);
                         pw.println("To be paid : "+money+" taka");
                         pw.println("Excluding 10% Service Charge !");
      
                         JOptionPane.showMessageDialog(py,"The slip has been generated!");  
                        bw.close();
			pw.close();
                        
                        
		}          catch (IOException ex) {
                             
                           }

	                 }
	                      
	               } );
		
		
      }
}
