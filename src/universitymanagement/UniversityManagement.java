package universitymanagement;
import javax.swing.*; 
import java.awt.event.*; 
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UniversityManagement {

    public static void main(String[] args) {
        startmenu st=new startmenu();
    }

}

class startmenu extends WindowAdapter{         
    JFrame f;
	    startmenu(){
	f=new JFrame("Login Panel");
            JLabel lblNewLabel = new JLabel("University Management System");
            lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
            lblNewLabel.setBounds(114, 0, 264, 22);
	    JLabel lblNewLabel_1 = new JLabel("Welcome to Login panel!");
            lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
	    lblNewLabel_1.setBounds(145, 22, 168, 22);
	    final JLabel label = new JLabel();            
	    label.setBounds(20,150, 200,50);  
	    final JPasswordField value = new JPasswordField();   
	    value.setBounds(159, 128, 184, 28);   
	    JLabel l1=new JLabel("Username:");    
	       l1.setBounds(68, 75, 84, 14);    
	       JLabel l2=new JLabel("Password:");    
	       l2.setBounds(68, 135, 84, 14);
	       JButton b = new JButton("Login");  
	       b.setBounds(170, 189, 89, 45);   
	       final JTextField text = new JTextField();  
	       text.setBounds(159, 68, 184, 28); 
                        f.add(lblNewLabel_1);
                       f.addWindowListener(this);    //permission
                       f.add(lblNewLabel);
	               f.add(value); f.add(l1);
                       f.add(label); f.add(l2); f.add(b); f.add(text);  
	               f.setSize( 450, 300);    
	               f.setLayout(null);    
	               f.setVisible(true); 
                       f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	               b.addActionListener(new ActionListener() {  
                       @Override
	               public void actionPerformed(ActionEvent e) {       
	                  String user =text.getText();  
	                 String pass= new String(value.getPassword()); 
	                
	                 if(user.equals("1") && pass.equals("1")) {
                             
	                	  f.setVisible(false);
	                	  pannel nw=new pannel();
	                	
	                 }
                         else{
                             JOptionPane.showMessageDialog(f,"Wrong password or Userid !","Warning!",JOptionPane.WARNING_MESSAGE);   
                         }
	                      
	               }  
	            }); 
                       

	}
    @Override
            public void windowClosing(WindowEvent e) {  
    int a=JOptionPane.showConfirmDialog(f,"Are you sure you want to Exit?");  
if(a==JOptionPane.YES_OPTION){  
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
}  
} 
	   
}


