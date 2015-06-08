import java.awt.EventQueue;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.sql.*;
import java.util.Calendar;

import javax.swing.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.CompoundBorder;

import java.awt.*;

import javax.swing.border.MatteBorder;

import java.awt.Component;

public class Login_page {

	private JFrame frame;
	private JLabel lblClock;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_page window = new Login_page();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	Connection connection=null;
	private JTextField textFieldUN;
	private JPasswordField passwordField;
	private JPanel panel;
	/**
	 * Create the application.
	 */
	
	public void clock()
	{
		Thread clock=new Thread()
		{
			public void run()
			{
				try{
					for(;;){
						Calendar cal= new GregorianCalendar();
					    int month =cal.get(Calendar.MONTH);
					    int year= cal.get(Calendar.YEAR);
					    int day= cal.get(Calendar.DAY_OF_MONTH);
					    
					    
					    int second =cal.get(Calendar.SECOND);
					    int minute =cal.get(Calendar.MINUTE);
					    int hour =cal.get(Calendar.HOUR);
					    
					    lblClock.setText("Time  "+hour+":"+minute+":"+second+"     Date  "+day+"/"+month+"/"+year);
				sleep(1000);
					}
				}catch(InterruptedException e){
					e.printStackTrace();
				}
			}
		};
		
		clock.start();
	}
	
	
	public Login_page() {
		initialize();
		clock();
		connection=DbConnection.dbConnector();
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 572, 489);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(new Color(240, 255, 240));
		panel.setBorder(new TitledBorder(new CompoundBorder(new MatteBorder(5, 1, 1, 1, (Color) new Color(0, 0, 0)), null), "Login Page", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(64, 64, 64)));
		panel.setBounds(160, 193, 259, 186);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("User Name");
		lblNewLabel.setBounds(29, 39, 70, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(29, 87, 70, 14);
		panel.add(lblNewLabel_1);
		
		textFieldUN = new JTextField();
		textFieldUN.setBounds(119, 36, 130, 23);
		panel.add(textFieldUN);
		textFieldUN.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(127, 152, 89, 23);
		panel.add(btnLogin);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(119, 83, 130, 23);
		panel.add(passwordField);
		
		JLabel lblNewLabel_2 = new JLabel("");
		Image img =new ImageIcon(this.getClass().getResource("/eHospital_logo.jpg")).getImage();
		lblNewLabel_2.setIcon(new ImageIcon(img));
		lblNewLabel_2.setBounds(180, 24, 205, 52);
		frame.getContentPane().add(lblNewLabel_2);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 423, 536, 28);
		frame.getContentPane().add(separator);
		
		JLabel lblNewLabel_3 = new JLabel("eHospital \u00A9 Gurpreet, Reema");
		lblNewLabel_3.setBounds(26, 423, 241, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblHospitalManagmentSystem = new JLabel("Hospital Managment System");
		lblHospitalManagmentSystem.setForeground(new Color(34, 139, 34));
		lblHospitalManagmentSystem.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lblHospitalManagmentSystem.setBackground(new Color(34, 139, 34));
		lblHospitalManagmentSystem.setBounds(160, 87, 269, 24);
		frame.getContentPane().add(lblHospitalManagmentSystem);
		
		lblClock = new JLabel("");
		lblClock.setBounds(197, 168, 222, 14);
		frame.getContentPane().add(lblClock);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String sql ="select * from loginTable where username=? and password=?";
				String sql2 ="select * from loginForm where username=? and password=?";
		        try {
		        	PreparedStatement  pst=connection.prepareStatement(sql);
		        	PreparedStatement  pst2=connection.prepareStatement(sql2);
		            pst.setString(1,textFieldUN.getText());
		            pst.setString(2,passwordField.getText());
		            pst2.setString(1,textFieldUN.getText());
			         pst2.setString(2,passwordField.getText());
		            ResultSet rs=pst.executeQuery();
		            ResultSet rs2=pst2.executeQuery();
		            if(rs.next() || rs2.next()){
		                rs.close();
		                pst.close();
		                rs2.close();
		                pst2.close();
		                //JOptionPane.showMessageDialog(null, "u done");
		                frame.dispose();
		                MainPage m=new MainPage();
		                m.setVisible(true);
		                
		                
		            }
		            else{
		                JOptionPane.showMessageDialog(null, "u not done");
		            }
		            
		        }
		        catch(Exception e){
		            JOptionPane.showMessageDialog(null, e);
		            
		            
		        }
		        
		        
				
		        }
		});
		
		
	}
}
