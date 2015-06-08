import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.*;

import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class LoginForm extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JPanel panel;
	private JPanel panel_4;
	private JPanel panel_3;
	private JPanel panel_2;
	
	private String uname;
	
	public void close()
    {
    WindowEvent w=new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
    Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(w);
    }

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginForm frame = new LoginForm();
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
	public LoginForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 549, 416);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setBounds(181, 71, 78, 14);
		contentPane.add(lblUserName);
		
		 panel_2 = new JPanel();
		panel_2.setBounds(181, 115, 78, 14);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("Password");
		lblNewLabel.setBounds(0, 0, 90, 14);
		panel_2.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(297, 68, 179, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(297, 112, 179, 20);
		contentPane.add(passwordField);
		
		JLabel label = new JLabel("");
		Image img4 =new ImageIcon(this.getClass().getResource("login.png")).getImage();
		label.setIcon(new ImageIcon(img4));
		label.setBounds(10, 71, 161, 196);
		contentPane.add(label);
		
		panel_3 = new JPanel();
		panel_3.setBounds(157, 107, 112, 25);
		contentPane.add(panel_3);
		panel_3.setVisible(false);
		
		JLabel lblNewLabel_1 = new JLabel("New Password");
		panel_3.add(lblNewLabel_1);
		
		 panel_4 = new JPanel();
		panel_4.setBounds(167, 140, 323, 111);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		panel_4.setVisible(false);
		
		JLabel lblReEnterPassword = new JLabel("Re-Enter Password");
		lblReEnterPassword.setBounds(10, 11, 110, 14);
		panel_4.add(lblReEnterPassword);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				
				if(passwordField.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Fill First Password Field");
				}
				else if(passwordField.getText().equals(passwordField_1.getText())){
				Connection	conn=DbConnection.dbConnector();
				
				try {
					String sql="Update loginForm set password='"+passwordField.getText()+"' where username='"+uname+"' ";
				PreparedStatement pst=conn.prepareStatement(sql);
				pst.execute();
			       pst.close();
			      
			       JOptionPane.showMessageDialog(null, "Password Updated");
				
			}catch(Exception e){
				JOptionPane.showMessageDialog(null, e);
			} } else{
				
				JOptionPane.showMessageDialog(null, "Don't macth Password");
			} 
			}
		});
		btnUpdate.setBounds(67, 77, 89, 23);
		panel_4.add(btnUpdate);
		
		 panel = new JPanel();
		panel.setBounds(186, 193, 304, 83);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setText("");
				passwordField.setText("");
				panel.setVisible(true);
				panel_3.setVisible(false);
				panel_2.setVisible(true);
				panel_4.setVisible(false);
			}
		});
		btnBack.setBounds(189, 77, 89, 23);
		panel_4.add(btnBack);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(130, 8, 183, 20);
		panel_4.add(passwordField_1);
		
		
		
		JButton btnNewButton = new JButton("Forget Password");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Forget_form ff=new Forget_form();
				ff.setVisible(true);
			}
		});
		btnNewButton.setBounds(0, 0, 147, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Change Password");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Connection conn=DbConnection.dbConnector();
				String sql ="select * from loginForm where username=? and password=?";
		        try {
		        	PreparedStatement  pst=conn.prepareStatement(sql);
		            pst.setString(1,textField.getText());
		            pst.setString(2,passwordField.getText());
		            
		            ResultSet rs=pst.executeQuery();
		            
		            if(rs.next()){
		            	uname=rs.getString("username");
		            	passwordField.setText("");
		                rs.close();
		                pst.close();
		                JOptionPane.showMessageDialog(null, "u done");
		                
		                panel.setVisible(false);
						panel_3.setVisible(true);
						panel_2.setVisible(false);
						panel_4.setVisible(true);
		                
		                
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
		btnNewButton_1.setBounds(157, 0, 147, 23);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Login");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				NewMember nm=new NewMember();
				nm.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(0, 60, 147, 23);
		panel.add(btnNewButton_2);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				close();
			}
		});
		btnExit.setBounds(157, 60, 147, 23);
		panel.add(btnExit);
	}
}
