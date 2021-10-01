package universitymanagement;
import java.awt.Font;
import java.awt.event.*;
import java.io.*;
import java.util.logging.*;
import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class faculty{

    private String FacultyName, FacultyId, Phone, OfficeHour, Mail;
    int salari;
    JFrame fc;
    
    faculty() throws FileNotFoundException, IOException{
        fc=new JFrame("Faculty Mangement");
        fc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fc.setSize(901, 499);
		fc.setLayout(null);
                fc.setVisible(true);
		
		JLabel label1 = new JLabel("Faculty mangement");
		label1.setFont(new Font("Tahoma", Font.BOLD, 20));
		label1.setBounds(341, 11, 254, 46);
		fc.add(label1);
		
		
		
		
		
		JLabel label2 = new JLabel("Faculty List");
		label2.setBounds(338, 92, 105, 14);
		fc.add(label2);
		
		JButton button = new JButton("Add");
		button.setBounds(49, 215, 89, 23);
		fc.add(button);
                  button.addActionListener(new ActionListener() {  
	               public void actionPerformed(ActionEvent e) {       
	                	  fc.setVisible(false);
	                	addfac ad=new addfac();
	                      
	               }  
	            }); 
                
		
		
		
        JTextField textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(706, 69, 136, 20);
		fc.add(textField);
		
		JButton button2 = new JButton("<Back");
		button2.setBounds(10, 11, 87, 32);
		fc.add(button2);
                 button2.addActionListener(new ActionListener() {  
	               public void actionPerformed(ActionEvent e) {       
	                	  fc.setVisible(false);
	                	  pannel nw=new pannel();
	                      
	               }  
	            }); 
		
		
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(561, 117, 281, 245);
		fc.add(textPane);
		
		
		
		
                                                      //viwing is done
                 JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(253, 117, 239, 245);
		fc.add(scrollPane);
                 final DefaultListModel<String> l1 = new DefaultListModel<>();  
       
                 FileReader fw=null;
		BufferedReader bf=null;
		try {
			fw=new FileReader("facultyView.txt");
			bf= new BufferedReader(fw);
			String line="";
			while((line=bf.readLine())!=null) {
                            if(!line.equals("deleted"))
				l1.addElement(line);
			}
			
                        fw.close();
			bf.close();
		}finally {
			
		}
         
           final JList<String> list = new JList<>(l1);
		scrollPane.setViewportView(list); 
                JButton btnNewButton_1_2 = new JButton("Show Details");
		btnNewButton_1_2.setBounds(37, 162, 116, 23);
		fc.add(btnNewButton_1_2);
                btnNewButton_1_2.addActionListener(new ActionListener() {  
	               public void actionPerformed(ActionEvent e) {       
	                
                  if (list.getSelectedIndex() != -1) {                       
                      String  selected =list.getSelectedValue(); 
                                     
                       String line2=" ";
                       String line="";
                                int lineno=0;
                                boolean ans=true;
                               FileReader fw=null;
		           BufferedReader bf=null;
		try {
			fw=new FileReader("facultyMAIN.txt");
			bf= new BufferedReader(fw);
                       
			 String original="Faculty Id   :"+selected;
                     
			while((line2=bf.readLine())!=null) {
                            if(line2.equals(original)){
                                ans=false;
                               lineno++;
                            }
                            if(ans==false && lineno<=6){
                                 line=line+"\n"+line2;  // && !line.equals("END")
                                  lineno++;
                            }
				
			}
                     fw.close();
		    bf.close();   
                        
			
		} catch (FileNotFoundException ex) {
                                  
                               } catch (IOException ex) {

                           }
                            textPane.setText(line); 
	                      
                  }
                       }}); 
                       
                JButton button3 = new JButton("Delete");
		button3.setBounds(49, 280, 89, 23);
		fc.add(button3);
                button3.addActionListener(new ActionListener() {  
	               public void actionPerformed(ActionEvent e) {       
   int n = JOptionPane.showOptionDialog(null,"Do you really want to Delete?","Warning!",
            JOptionPane.YES_NO_CANCEL_OPTION,
            JOptionPane.QUESTION_MESSAGE,null,null,null);  
                       if(n==0)
                if (list.getSelectedIndex() != -1) {                       
                     String  selected = list.getSelectedValue(); 
                     
                       
                FileWriter fwrite=null;
		BufferedWriter bw=null;
		PrintWriter pw=null;
		
		FileReader fw=null;
		BufferedReader bf=null;
                String content="";
		try {
			fw=new FileReader("facultyView.txt");
			bf= new BufferedReader(fw);
			String line="";
			while((line=bf.readLine())!=null) {
				content+=line+"\n";
			}
                        
                        fw.close();
			bf.close();
			
		}   catch (FileNotFoundException ex) {
                       
                    } catch (IOException ex) {
                       
                    }finally {
			
		}
                
                
               
                content=content.replaceAll(selected,"deleted");
                
              //  writing
              
            
		try {
		    // fle= new File();
			 fwrite =new FileWriter("facultyView.txt");
			 bw =new BufferedWriter(fwrite);
			 pw=new PrintWriter(bw);
			pw.println(content);
                        
                        bw.close();
			pw.close();
		}   catch (IOException ex) {
                        Logger.getLogger(faculty.class.getName()).log(Level.SEVERE, null, ex);
                    }finally {
			
		}
                        
                
                       
                              }
	                      
	               }  
	            }); 
                JButton button4 = new JButton("Update List");
		button4.setBounds(309, 386, 124, 23);
		fc.add(button4);
                button4.addActionListener(new ActionListener() {  
                       @Override
	               public void actionPerformed(ActionEvent e) {       
	                	
                             l1.clear();
                 
                FileReader fw=null;
		BufferedReader bf=null;
		try {
			fw=new FileReader("facultyView.txt");
			bf= new BufferedReader(fw);
			String line="";
			while((line=bf.readLine())!=null) {
                            if(!line.equals("deleted"))
				l1.addElement(line);
			}
                        
                        fw.close();
			bf.close();
			
		}          catch (FileNotFoundException ex) {
                              
                           } catch (IOException ex) {
                             
                           }finally {
			
		}
         
           final JList<String> list = new JList<>(l1);
                
	                      
	               }  
	            }); 
                
		JButton button5 = new JButton("Search by ID :");
		button5.setBounds(562, 68, 120, 23);
		fc.add(button5);
                 button5.addActionListener(new ActionListener() {  
	               public void actionPerformed(ActionEvent e) {       
	                	
                              String show=textField.getText();
                         
                            
                    String line2=" ";
                             String line="";
                                int lineno=0;
                                boolean ans1=true;
                               FileReader fw=null;
		           BufferedReader bf=null;  
                           boolean confirm=false;
                           
                         try {
			fw=new FileReader("facultyMAIN.txt");
			bf= new BufferedReader(fw);
                       
			 String original="Faculty Id   :"+show;
                        
			while((line2=bf.readLine())!=null) {
                            if(line2.equals(original)){
                                ans1=false;
                                confirm=true;
                               lineno++;
                            }
                            if(ans1==false && lineno<=6){
                                 line=line+"\n"+line2;  // && !line.equals("END")
                                  lineno++;
                            }
				
			}
                        fw.close();
			bf.close();
		} catch (FileNotFoundException ex) {
                                  
                               } catch (IOException ex) {
                             
                           }finally {
			
		}         
                           
                          if(confirm==false){
                   JOptionPane.showMessageDialog(fc,"Not Found! , Enter correct CODE");
                          }
                          else
                              
                       textPane.setText(line);  
	                      
	               }  
	            }); 
                 
    }

    faculty(String FacultyName, String FacultyId, String Phone, int salari, String Mail) {
        this.FacultyName = FacultyName;
        this.FacultyId = FacultyId;
        this.Phone = Phone;
        this.salari = salari;
      
        this.Mail = Mail;
    }

    public String getFacultyName() {
        return FacultyName;
    }

    public void setFacultyName(String FacultyName) {
        this.FacultyName = FacultyName;
    }

    public String getFacultyId() {
        return FacultyId;
    }

    public void setFacultyId(String FacultyId) {
        this.FacultyId = FacultyId;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public int getSalary() {
        return salari;
    }

    public void setSalary(int salari) {
        this.salari = salari;
    }

    public String getOfficeHour() {
        return OfficeHour;
    }

    public void setOfficeHour(String OfficeHour) {
        this.OfficeHour = OfficeHour;
    }

    public String getMail() {
        return Mail;
    }

    public void setMail(String Mail) {
        this.Mail = Mail;
    }
    public String  Annualincome() {
        int an=salari*12;
        String hb=String.valueOf(an);
         return hb;
    }

    @Override
    public String toString() {
        return "Faculty Id   :" + getFacultyId() +"\nFaculty Name    :" + getFacultyName() +  "\nFaculty Phone   :" + getPhone()
                + "\nFaculty  Salary  :" + getSalary() + "\nFaculty Mail    :" + getMail()+"\nAnnualIncome : "+Annualincome();
    }

}
class addfac{
    JFrame af;
        addfac(){
            af=new JFrame("Add faculty");
       af. setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		af.setSize(901,499);
		af.setLayout(null);
                af.setVisible(true);
		
		JLabel lblFacultyDetails = new JLabel("Faculty Details");
		lblFacultyDetails.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblFacultyDetails.setBounds(376, 0, 220, 45);
		af.add(lblFacultyDetails);
		
        JTextField textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(342, 114, 208, 29);
		af.add(textField);
		
        JTextField textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(342, 180, 208, 29);
		af.add(textField_1);
		
        JTextField textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(342, 235, 208, 29);
		af.add(textField_2);
		
        JTextField textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(342, 295, 208, 29);
		af.add(textField_3);
		
		JLabel lblFacultyName = new JLabel("Faculty Name :");
		lblFacultyName.setBounds(251, 121, 91, 14);
		af.add(lblFacultyName);
		
		JLabel lblFacultyId = new JLabel("Faculty ID :");
		lblFacultyId.setBounds(251, 187, 91, 14);
		af.add(lblFacultyId);
		
		JLabel lblPhone = new JLabel("Phone :");
		lblPhone.setBounds(251, 242, 91, 14);
		af.add(lblPhone);
		
		JLabel lblSalary = new JLabel("Salary  :");
		lblSalary.setBounds(264, 302, 91, 14);
		af.add(lblSalary);
		
		JLabel lblSalary_1 = new JLabel("E-Mail  :");
		lblSalary_1.setBounds(251, 359, 91, 14);
		af.add(lblSalary_1);
		
        JTextField textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(342, 352, 208, 29);
		af.add(textField_4);
		
		JButton btnNewButton = new JButton("Done");
		btnNewButton.setBounds(410, 412, 89, 23);
		af.add(btnNewButton);
                JButton btnNewButton_2 = new JButton("<Back");
		btnNewButton_2.setBounds(20, 15, 87, 32);
		af.add(btnNewButton_2);
                btnNewButton_2.addActionListener(new ActionListener() {  
	               public void actionPerformed(ActionEvent e) {       
	                     af.setVisible(false);
                             try{
                                faculty cf=new faculty();  
                             }catch(IOException ee){
                                 
                             }
                            
                           
	                 }
	                      
	               } ); 
                
                
                
                btnNewButton.addActionListener(new ActionListener() {  
	               public void actionPerformed(ActionEvent e) {       
	                	
                           String name=textField.getText();
                           String id=textField_1.getText();
                           String phone=textField_2.getText();
                           String slry=textField_3.getText();
                           String mail=textField_4.getText();
                           int sl=Integer.parseInt(slry);
                           
                         faculty fac=new faculty(name,id,phone,sl,mail);
                         
                           String print=fac.toString();
                          
                            FileWriter fwrite=null;
		BufferedWriter bw=null;
		PrintWriter pw=null;
                          try {
		   
			 fwrite =new FileWriter("facultyMAIN.txt",true);
			 bw =new BufferedWriter(fwrite);
			 pw=new PrintWriter(bw);
                         pw.println(print);
                         
                         bw.close();
			pw.close();
			
		}          catch (IOException ex) {
                               
                           }finally {
			
		}
              
                
                
                  try {

                   fwrite = new FileWriter("facultyView.txt",true);
			 bw =new BufferedWriter(fwrite);
			 pw=new PrintWriter(bw);
                         pw.println(id);
			
                         bw.close();
			pw.close();
			
		}          catch (IOException ex) {
                              
                           }finally {
			
		}
            
                             af.setVisible(false);
                           try { 
                               faculty cf=new faculty();
                           } catch (IOException ex) {
                              
                           }
                           
                           
	                      
	               }  
	            }); 
    }
}
