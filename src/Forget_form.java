import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Label;
import java.awt.TextField;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Forget_form extends JFrame {

	private JPanel contentPane;
	private JTextField uname;
	private JTextField textField;
	private JLabel label;
	private JTextField ques;
	private JPanel panel;
	
	private String ans;
	private String pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Forget_form frame = new Forget_form();
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
	public Forget_form() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 425);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setBounds(40, 70, 70, 14);
		contentPane.add(lblUserName);
		
		uname = new JTextField();
		uname.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				
				Connection	conn=DbConnection.dbConnector();
				  try{
				 
			            String sql="select * from loginForm where username=?";
			            PreparedStatement  pst=conn.prepareStatement(sql);
			            pst.setString(1, uname.getText());
			            ResultSet rs=pst.executeQuery();
			            if(rs.next()){
			                ques.setText(rs.getString("ques"));
			                ans= rs.getString("ans");
			                pass=rs.getString("password");
			            } 
			            rs.close();
			         pst.close();   
			        }
			        catch (Exception e){
			            JOptionPane.showMessageDialog(null, e);
			           }
			}
		});
		uname.setBounds(136, 67, 146, 20);
		contentPane.add(uname);
		uname.setColumns(10);
		
		JLabel lblQues = new JLabel("Ques");
		lblQues.setBounds(40, 123, 46, 14);
		contentPane.add(lblQues);
		
		JLabel lblAns = new JLabel("Ans");
		lblAns.setBounds(40, 173, 46, 14);
		contentPane.add(lblAns);
		
		textField = new JTextField();
		textField.setBounds(136, 170, 146, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(textField.getText().equals(ans)){
					
					JOptionPane.showMessageDialog(null, "Password:  "+pass);
				}
				else{
					 JOptionPane.showMessageDialog(null, "Worng Answer");
				}
			}
		});
		btnSubmit.setBounds(107, 243, 89, 23);
		contentPane.add(btnSubmit);
		
		ques = new JTextField();
		ques.setBounds(136, 120, 288, 20);
		contentPane.add(ques);
		ques.setColumns(10);
		
	
	}
}
