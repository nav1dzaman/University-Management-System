package universitymanagement;

import java.awt.Font;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class student extends WindowAdapter {

    private String StdName, StdId, StdMail, Phone,gender;

    private String CGPA, Credit;
    
    ArrayList <course> takencourse= new ArrayList <> ();
    
    JFrame std;
    String selected;
    student() throws FileNotFoundException, IOException {
        
        std=new JFrame("Student Management");
         std.addWindowListener(this);  
        std.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		JLabel label = new JLabel("Student Management");
		label.setFont(new Font("Tahoma", Font.BOLD, 20));
		label.setBounds(370, 11, 230, 32);
		std.add(label);
		
		
		JButton button = new JButton("Add Student");
		button.setBounds(24, 163, 124, 23);
		std.add(button);
                 button.addActionListener(new ActionListener() {  
                       @Override
	               public void actionPerformed(ActionEvent e) {       
	                       std.setVisible(false);
                               try{
                                   addstudent add=new addstudent();
                               }catch(IOException eee){
                                   
                               }
                            
	                 }
	                      
	               } ); 
                 
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(188, 96, 256, 262);
		std.add(scrollPane);
                
                 JTextPane textPane = new JTextPane();
		textPane.setBounds(539, 96, 296, 262);
		std.add(textPane);
		
                
               final DefaultListModel<String> l1 = new DefaultListModel<>();  
       
                 FileReader fw=null;
		BufferedReader bf=null;
		try {
			fw=new FileReader("studentList.txt");
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
                
                   selected="";
                 JButton button1 = new JButton("Show Details");   //showing details
		button1.setBounds(24, 116, 124, 23);
		std.add(button1);
                 button1.addActionListener(new ActionListener() {  
	               public void actionPerformed(ActionEvent e) {       
                   
                            if (list.getSelectedIndex() != -1) {                       
                       selected = list.getSelectedValue(); 
                                     
                       String line2=" ";
                       String line="";
                                int lineno=0;
                                boolean ans=true;
                               FileReader fw=null;
		BufferedReader bf=null;
		try {
			fw=new FileReader("detailedStudentinfo.txt");
			bf= new BufferedReader(fw);
                       
			 String original="Student Id   :"+selected;
                        
			while((line2=bf.readLine())!=null) {
                            if(line2.equals(original)){
                                ans=false;
                               lineno++;
                            }
                            if(ans==false && lineno<=12){
                                 line=line+"\n"+line2;  // && !line.equals("END")
                                  lineno++;
                            }
				
			}
                        fw.close();
			bf.close();
			
		}              catch (FileNotFoundException ex) {
                                  
                               } catch (IOException ex) {
                                    
                                }

                           textPane.setText(line);        
     
                           }
                              
                  
                       }} ); 
		JTextField textField = new JTextField();
		textField.setBounds(711, 66, 124, 20);
		std.add(textField);
		textField.setColumns(10);
		
		
		JButton button2 = new JButton("<Back");
		button2.setBounds(10, 11, 87, 32);
		std.add(button2);
                button2.addActionListener(new ActionListener() {  
	               public void actionPerformed(ActionEvent e) {       
	                       std.setVisible(false);
                              pannel pnl=new pannel();
	                 }
	                      
	               } ); 
		
		JLabel label1 = new JLabel("Student ID (Running Semester)");
		label1.setFont(new Font("Tahoma", Font.BOLD, 11));
		label1.setBounds(220, 71, 235, 14);
		std.add(label1);
		
              
                JButton button3 = new JButton("Delete");         //deleting option
		button3.setBounds(24, 210, 124, 23);
		std.add(button3);
                 button3.addActionListener(new ActionListener() {  
	               public void actionPerformed(ActionEvent e) {
     int n = JOptionPane.showOptionDialog(null,"Do you really want to Delete?","Warning!",
            JOptionPane.YES_NO_CANCEL_OPTION,
            JOptionPane.QUESTION_MESSAGE,null,null,null);  
                       if(n==0)
	                      if (list.getSelectedIndex() != -1) {                       
                       selected = list.getSelectedValue(); 
                FileWriter fwrite=null;
		BufferedWriter bw=null;
		PrintWriter pw=null;
		FileReader fw=null;
		BufferedReader bf=null;
                String content="";
		try {
			fw=new FileReader("studentList.txt");
			bf= new BufferedReader(fw);
			String line="";
			while((line=bf.readLine())!=null) {
				content+=line+"\n";
			}
                        
                        fw.close();
			bf.close();
			
		}                 catch (FileNotFoundException ex) {
                                   
                                  } catch (IOException ex) {
                                    
                                  }                   
                content=content.replaceAll(selected,"deleted");
		try {
		    // fle= new File();
			 fwrite =new FileWriter("studentList.txt");
			 bw =new BufferedWriter(fwrite);
			 pw=new PrintWriter(bw);
			pw.println(content);
                        bw.close();
			pw.close();
		}                 catch (IOException ex) {
                                     
                                  }
			
		
                        
                              }
	                 }
	                      
	               } ); 
                 
		JButton button4 = new JButton("Update List");     //update list
		button4.setBounds(243, 379, 124, 23);
		std.add(button4);
                button4 .addActionListener(new ActionListener() {  
	               public void actionPerformed(ActionEvent e) {   
                           
                           l1.clear();
                 
                FileReader fw=null;
		BufferedReader bf=null;
		try {
			fw=new FileReader("studentList.txt");
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
                               
                           }
         
           final JList<String> list = new JList<>(l1);
                           
               
	                 }
	                      
	               } ); 
                JButton button5 = new JButton("Search by ID :");    //saerching option
		button5.setBounds(566, 65, 120, 23);
                std.add(button5);
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
			fw=new FileReader("detailedStudentinfo.txt");
			bf= new BufferedReader(fw);
                       
			 String original="Student Id   :"+show;
                        
			while((line2=bf.readLine())!=null) {
                            if(line2.equals(original)){
                                ans1=false;
                                confirm=true;
                               lineno++;
                            }
                            if(ans1==false && lineno<=12){
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
                   JOptionPane.showMessageDialog(std,"Not Found! , Enter correct ID");
                          }
                          else
                       textPane.setText(line);           
                            
                            
			
                        }});
		
                
                
                std.setSize(901,499); //frame
		std.setLayout(null);  //frame
		std.setVisible(true);  //frame
		std.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	}
       

    student(String StdName, String StdId, String StdMail, String Phone, String CGPA, String Credit,String gender) {
        this.StdName = StdName;
        this.StdId = StdId;
        this.StdMail = StdMail;
        this.Phone = Phone;
        this.CGPA = CGPA;
        this.Credit = Credit;
        this.gender=gender;
    }
    
    @Override
                public void windowClosing(WindowEvent e) {  
    int a=JOptionPane.showConfirmDialog(std,"Are you sure you want to Exit?");  
if(a==JOptionPane.YES_OPTION){  
    std.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
}  
} 

    public String getStdName() {
        return StdName;
    }
     public void setgender(String gender) {
       this.gender=gender;
    }
     public String getgender() {
      return gender;
    }

    public void setStdName(String StdName) {
        this.StdName = StdName;
    }

    public String getStdId() {
        return StdId;
    }

    public void setStdId(String StdId) {
        this.StdId = StdId;
    }

    public String getStdMail() {
        return StdMail;
    }

    public void setStdMail(String StdMail) {
        this.StdMail = StdMail;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getCGPA() {
        return CGPA;
    }

    public void setCGPA(String CGPA) {
        this.CGPA = CGPA;
    }

    public String getCredit() {
        return Credit;
    }
    
    public String gettakencourse() {
        String s="";
      for(course crs:takencourse){
         String s1=crs.getCourseName();
         s+=s1+"\n";
                 }
      return s;
    }
    
    public void settakencourse(ArrayList<course> takencourse) {
       this.takencourse=takencourse;
               }

    public void setCredit(String Credit) {
        this.Credit = Credit;
    }

    @Override
    public String toString() {
        return  "\nStudent Id   :"+StdId+"\nStudent Name    :" + getStdName() + "\nStudent Gender   :" +gender+"\nStudent mail    :" + getStdMail()
                + "\nStudent Phone    :" + getPhone() + "\nStident CGPA  :" + getCGPA() + "\nStudent Credit    :" + Credit;
    }
}

class addstudent extends WindowAdapter{
     JFrame ads;
     student mystd;
     course c1,c2,c3;
    static ArrayList <student> studentlist=new ArrayList <student> ();
     ArrayList <course> courselist=new ArrayList <course> ();
     
      String StdName, StdId, StdMail, Phone,gender;
    String CGPA, Credit;
     String ans;
         JTextField textField;
	 JTextField textField_1;
	 JTextField textField_2;
	 JTextField textField_3;
	 JTextField textField_4;
	 JTextField textField_5;
          addstudent(String s){
              ans=s;
          }
	
    addstudent() throws FileNotFoundException, IOException{
       
       ads=new JFrame();
                ads.addWindowListener(this);  
		JLabel lblSrtudentDetails = new JLabel("Student Details");
		lblSrtudentDetails.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSrtudentDetails.setBounds(372, 11, 269, 39);
		ads.add(lblSrtudentDetails);
		JLabel lblNewLabel = new JLabel("Student Name :");
		lblNewLabel.setBounds(109, 104, 91, 14);
		ads.add(lblNewLabel);
		JLabel lblStudentId = new JLabel("Student ID :");
		lblStudentId.setBounds(136, 145, 91, 14);
		ads.add(lblStudentId);
		JLabel lblStudentMail = new JLabel("Student Mail :");
		lblStudentMail.setBounds(125, 188, 91, 14);
		ads.add(lblStudentMail);
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Male");
		rdbtnNewRadioButton.setBounds(555, 132, 111, 23);
		ads.add(rdbtnNewRadioButton);
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Female");
		rdbtnNewRadioButton_1.setBounds(555, 159, 111, 23);
		ads.add(rdbtnNewRadioButton_1);
                ButtonGroup bg=new ButtonGroup();   
                bg.add(rdbtnNewRadioButton);
                bg.add(rdbtnNewRadioButton_1);
		JLabel lblNewLabel_1 = new JLabel("Select Gender");
		lblNewLabel_1.setBounds(543, 104, 91, 14);
		ads.add(lblNewLabel_1);
		JLabel lblNewLabel_2 = new JLabel("Phone Number :");
		lblNewLabel_2.setBounds(109, 228, 118, 14);
		ads.add(lblNewLabel_2);
		JLabel lblNewLabel_3 = new JLabel("CGPA :");
		lblNewLabel_3.setBounds(157, 280, 49, 14);
		ads.add(lblNewLabel_3);
		JLabel lblNewLabel_4 = new JLabel("Completed Credit :");
		lblNewLabel_4.setBounds(94, 328, 122, 14);
		ads.add(lblNewLabel_4);
		JButton btnNewButton_2 = new JButton("<Back");
		btnNewButton_2.setBounds(10, 11, 87, 32);
		ads.add(btnNewButton_2);
                 btnNewButton_2.addActionListener(new ActionListener() {  
	               public void actionPerformed(ActionEvent e) {       
	                ads.setVisible(false);
                           try {      
                               student sttd=new student();
                           } catch (IOException ex) {
                              
                           }
	               }  
	            });   
		textField = new JTextField();
		textField.setBounds(218, 101, 208, 29); 
		ads.add(textField);
		textField.setColumns(10);
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(218, 138, 208, 29);
		ads.add(textField_1);
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(218, 181, 208, 29);
		ads.add(textField_2);
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(218, 221, 208, 29);
		ads.add(textField_3);
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(218, 273, 208, 29);
		ads.add(textField_4);
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(218, 321, 208, 29);
		ads.add(textField_5);
                String[] courseList=new String[10];
		FileReader fw=null;
		BufferedReader bf=null;
		try {
			fw=new FileReader("COURSECANBETAKEN.txt");
			bf= new BufferedReader(fw);
			String line="";
                        int i=0;
			while((line=bf.readLine())!=null) {
			    courseList[i++]=line;
			}
                        
                        fw.close();
			bf.close();
		}finally {
			
		}
                 JComboBox comboBox = new JComboBox(courseList);    //COMBO BOX
		comboBox.setBounds(510, 272, 87, 22);
		ads.add(comboBox);
	
	        JComboBox comboBox_1 = new JComboBox(courseList);
		comboBox_1.setBounds(621, 273, 87, 21);
		ads.add(comboBox_1);
		
		JComboBox comboBox_1_1 = new JComboBox(courseList);
		comboBox_1_1.setBounds(737, 273, 87, 21);
		ads.add(comboBox_1_1);                     

		JLabel lblNewLabel_5 = new JLabel("Course 1");
		lblNewLabel_5.setBounds(526, 249, 71, 14);
		ads.add(lblNewLabel_5);
		
		JLabel lblNewLabel_5_1 = new JLabel("Course 2");
		lblNewLabel_5_1.setBounds(635, 249, 73, 14);
		ads.add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_5_2 = new JLabel("Course 3");
		lblNewLabel_5_2.setBounds(749, 249, 75, 14);
		ads.add(lblNewLabel_5_2);
                
                JButton btnNewButton_2_1 = new JButton("<DONE>");
		btnNewButton_2_1.setBounds(372, 374, 87, 32);
		ads.add(btnNewButton_2_1);
                 btnNewButton_2_1.addActionListener(new ActionListener() {  
	               public void actionPerformed(ActionEvent e) {          
                            StdName =textField.getText();
                            StdId=textField_1.getText();
                            StdMail=textField_2.getText();
                            Phone=textField_3.getText();
                            if(rdbtnNewRadioButton.isSelected()){
                                gender="Male";
                            }
                            else gender ="Female";
                            Credit =textField_5.getText();
                            CGPA =textField_4.getText();  
                            String hh= (String)comboBox.getSelectedItem();
                            String hh1=comboBox.getSelectedItem().toString();
                             c1=new course(hh1);
                            
                            String hha= (String)comboBox_1.getSelectedItem();
                            String hh2=comboBox_1.getSelectedItem().toString();
                            c2=new course(hh2);
                                    
                            String hhb= (String)comboBox_1_1.getSelectedItem();
                            String hh3=comboBox_1_1.getSelectedItem().toString();
                             c3=new course(hh3);
                             
                       
                                
                mystd=new student(StdName,StdId,StdMail,Phone,CGPA,Credit,gender);
               
                       courselist.add(c1);
                        courselist.add(c2);
                         courselist.add(c3);
                         mystd.settakencourse(courselist);
                       studentlist.add(mystd);
                       
                       
                 FileWriter fwrite=null;
		BufferedWriter bw=null;
		PrintWriter pw=null;
		
		try {
		    // fle= new File();
			 fwrite =new FileWriter("studentList.txt",true);
			 bw =new BufferedWriter(fwrite);
			 pw=new PrintWriter(bw);
			 pw.println(StdId);

                   bw.close();
			pw.close();     
                        
                        
		}          catch (IOException ex) {
                              
                           }finally {
			
		}
                
                try {
		  
			 fwrite =new FileWriter("detailedStudentinfo.txt",true);
			 bw =new BufferedWriter(fwrite);
			 pw=new PrintWriter(bw);
			pw.println(mystd.toString());
                        pw.println("Course Taken:");
                         pw.println(hh1);
                         pw.println(hh2);
                         pw.println(hh3);
                       bw.close();
			pw.close(); 
                        
		}          catch (IOException ex) {
                              
                           }finally {
			
		}   
                
                
                           String sd=mystd.toString();
                          
               
		
		try {
		    // fle= new File();
			 fwrite =new FileWriter("DEPOSITSLIP_STUDENT.txt");
			 bw =new BufferedWriter(fwrite);
			 pw=new PrintWriter(bw);
                         pw.println("Payment/Deposit Slip");
                         pw.println("Student Details........");
                         pw.println(sd);
                         pw.println("Course Details........");
                         pw.println(c1.getcoursecode()+".....(Estimated cost max. 25000 taka)");
                         pw.println(c2.getcoursecode()+".....(Estimated cost max. 25000 taka)");
                         pw.println(c3.getcoursecode()+".....(Estimated cost max. 25000 taka)");
                         pw.println("Enter Amount (Manually) :");
                         pw.println("Adccepted Bank: ");
                         String dd="Bangladesh bank(AC NO:12456)"+"\n"+"DBBL Bankbank(AC NO:12456)";
                         pw.println(dd);
                         
                        
                        bw.close();
			pw.close();
                        
                        
		}          catch (IOException ex) {
                              
                           }
                           
	         JOptionPane.showMessageDialog(ads,"The Slip has been generated!");   

                 ads.setVisible(false);
                           try {
                            student std2 = new student();
                           } catch (IOException ex) {
                              
                           }   
	               }  
	            }); 

                ads.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		ads.setBounds(100,100,901,499);
		ads.setLayout(null);
                ads.setVisible(true);
 
                
	}
     @Override
                public void windowClosing(WindowEvent e) {  
    int a=JOptionPane.showConfirmDialog(ads,"Are you sure you want to Exit?");  
if(a==JOptionPane.YES_OPTION){  
    ads.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
}  
} 
    //
    
    public ArrayList<student> getTheList(){
        return studentlist;
    }
    
 
}

