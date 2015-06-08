import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class Search_page extends JFrame {

	Connection conn=null;
	PreparedStatement pst=null;
    ResultSet rs=null;
	private JPanel contentPane;
	private JTextField Pname;
	private JTextField Mobile;
	
	private JLabel reg_1;
	private JLabel date;
	private JTextField DOB;
	
	private JTextField age1;
	private JTextField Martial;
	private JTextField Gender;
	private JTextField textField;
	private JTextField Address;
	
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Search_page frame = new Search_page();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Search_page() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 588, 624);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblR = new JLabel("Rigistration Number");
		lblR.setBounds(56, 76, 200, 50);
		contentPane.add(lblR);
		
		
		
		JLabel lblNewLabel = new JLabel("Patient Name");
		lblNewLabel.setBounds(56, 122, 200, 50);
		contentPane.add(lblNewLabel);
		
		JLabel lblRigistrationDate = new JLabel("Rigistration Date");
		lblRigistrationDate.setBounds(56, 168, 200, 50);
		contentPane.add(lblRigistrationDate);
		
		JLabel lblPatientAddress = new JLabel("Patient Address");
		lblPatientAddress.setBounds(56, 226, 200, 50);
		contentPane.add(lblPatientAddress);
		
		JLabel lblMartialStatus = new JLabel("Martial Status");
		lblMartialStatus.setBounds(56, 287, 200, 50);
		contentPane.add(lblMartialStatus);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(56, 328, 200, 50);
		contentPane.add(lblGender);
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth");
		lblDateOfBirth.setBounds(56, 365, 200, 50);
		contentPane.add(lblDateOfBirth);
		
		JLabel lblMobileNumber = new JLabel("Mobile Number");
		lblMobileNumber.setBounds(56, 452, 200, 50);
		contentPane.add(lblMobileNumber);
		
		Pname = new JTextField();
		Pname.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				
				conn=ConnectionMain.dbConnector();
				  try{
				 
			            String sql="select * from patient where pname=?";
			            pst=conn.prepareStatement(sql);
			            pst.setString(1, Pname.getText());
			            rs=pst.executeQuery();
			            if(rs.next()){
			                String add1=rs.getString("reg");
			                reg_1.setText(add1);
			                String add2=rs.getString("rdate");
			                date.setText(add2);
			                 String add3=rs.getString("address");
			                Address.setText(add3);
			                String add4=rs.getString("martial");
			                Martial.setText(add4);
			                 String add5=rs.getString("gender");
			                Gender.setText(add5);
			                String add6=rs.getString("dob");
			                DOB.setText(add6);
			                 String add7=rs.getString("age");
			                age1.setText(add7);
			              //  String add8=rs.getString("pname");
			             //  Pname.setText(add8);
			                 String add9=rs.getString("phone");
			                Mobile.setText(add9);
			               
			                
			            } 
			            rs.close();
			         pst.close();   
			        }
			        
			        
			        catch (Exception e){
			            JOptionPane.showMessageDialog(null, e);
			           }
				
			}
		});
		Pname.setBounds(213, 137, 139, 20);
		contentPane.add(Pname);
		Pname.setColumns(10);
		
		Mobile = new JTextField();
		Mobile.setBounds(213, 467, 139, 20);
		contentPane.add(Mobile);
		Mobile.setColumns(10);
		
		date = new JLabel("");
		date.setBounds(213, 168, 200, 50);
		contentPane.add(date);
		
		DOB = new JTextField();
		DOB.setBounds(213, 380, 139, 20);
		contentPane.add(DOB);
		DOB.setColumns(10);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setBounds(54, 426, 46, 14);
		contentPane.add(lblAge);
		
		age1 = new JTextField();
		age1.setBounds(213, 421, 89, 20);
		contentPane.add(age1);
		age1.setColumns(10);
		
		Martial = new JTextField();
		Martial.setBounds(213, 302, 139, 20);
		contentPane.add(Martial);
		Martial.setColumns(10);
		
		Gender = new JTextField();
		Gender.setBounds(213, 343, 139, 19);
		contentPane.add(Gender);
		Gender.setColumns(10);
		
	    reg_1 = new JLabel("");
		reg_1.setBounds(213, 94, 124, 14);
		contentPane.add(reg_1);
		
		JLabel lblSearch = new JLabel("Search ");
		lblSearch.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSearch.setBackground(Color.BLACK);
		lblSearch.setBounds(56, 38, 99, 14);
		contentPane.add(lblSearch);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				conn=ConnectionMain.dbConnector();
				  try{
				 
			            String sql="select * from patient where reg=?";
			            pst=conn.prepareStatement(sql);
			            pst.setString(1, textField.getText());
			            rs=pst.executeQuery();
			            if(rs.next()){
			                String add1=rs.getString("reg");
			                reg_1.setText(add1);
			                String add2=rs.getString("rdate");
			                date.setText(add2);
			                 String add3=rs.getString("address");
			                Address.setText(add3);
			                String add4=rs.getString("martial");
			                Martial.setText(add4);
			                 String add5=rs.getString("gender");
			                Gender.setText(add5);
			                String add6=rs.getString("dob");
			                DOB.setText(add6);
			                 String add7=rs.getString("age");
			                age1.setText(add7);
			                String add8=rs.getString("pname");
			                Pname.setText(add8);
			                 String add9=rs.getString("phone");
			                Mobile.setText(add9);
			               
			                
			            } 
			            rs.close();
			         pst.close();   
			        }
			        catch (Exception e){
			            JOptionPane.showMessageDialog(null, e);
			           }
				  
				  
				  try{
						 
			            String sql="select * from patient where pname=?";
			            pst=conn.prepareStatement(sql);
			            pst.setString(1, textField.getText());
			            rs=pst.executeQuery();
			            if(rs.next()){
			                String add1=rs.getString("reg");
			                reg_1.setText(add1);
			                String add2=rs.getString("rdate");
			                date.setText(add2);
			                 String add3=rs.getString("address");
			                Address.setText(add3);
			                String add4=rs.getString("martial");
			                Martial.setText(add4);
			                 String add5=rs.getString("gender");
			                Gender.setText(add5);
			                String add6=rs.getString("dob");
			                DOB.setText(add6);
			                 String add7=rs.getString("age");
			                age1.setText(add7);
			                String add8=rs.getString("pname");
			               Pname.setText(add8);
			                 String add9=rs.getString("phone");
			                Mobile.setText(add9);
			               
			                
			            } 
			            rs.close();
			         pst.close();   
			        }
			        
			        
			        catch (Exception e){
			            JOptionPane.showMessageDialog(null, e);
			           }
				  
				  
				  try{
						 
			            String sql="select * from patient where phone=?";
			            pst=conn.prepareStatement(sql);
			            pst.setString(1, textField.getText());
			            rs=pst.executeQuery();
			            if(rs.next()){
			                String add1=rs.getString("reg");
			                reg_1.setText(add1);
			                String add2=rs.getString("rdate");
			                date.setText(add2);
			                 String add3=rs.getString("address");
			                Address.setText(add3);
			                String add4=rs.getString("martial");
			                Martial.setText(add4);
			                 String add5=rs.getString("gender");
			                Gender.setText(add5);
			                String add6=rs.getString("dob");
			                DOB.setText(add6);
			                 String add7=rs.getString("age");
			                age1.setText(add7);
			                String add8=rs.getString("pname");
			               Pname.setText(add8);
			                 String add9=rs.getString("phone");
			                Mobile.setText(add9);
			               
			                
			            } 
			            rs.close();
			         pst.close();   
			        }
			        
			        
			        catch (Exception e){
			            JOptionPane.showMessageDialog(null, e);
			           }
				
			}
			
			
				  
	
		});
		textField.setBounds(182, 27, 183, 38);
		contentPane.add(textField);
		textField.setColumns(10);
		
		Address = new JTextField();
		Address.setBounds(198, 231, 257, 38);
		contentPane.add(Address);
		Address.setColumns(10);
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				conn=ConnectionMain.dbConnector();	 
		 String value1 =Mobile.getText();
        String value2 =Address.getText();
        String value3 =reg_1.getText();
       try{
            String sql="update  patient set phone='"+value1+"',address='"+value2+"' where reg='"+value3+"'" ;
            pst=conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Updated");
           rs.close();
         pst.close();
         
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
           } 
				 
				 
				 
			}
		});
		btnNewButton.setBounds(138, 531, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Exit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			
			}
		});
		btnNewButton_1.setBounds(291, 531, 89, 23);
		contentPane.add(btnNewButton_1);
		
	

	}
}
