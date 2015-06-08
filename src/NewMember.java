import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class NewMember extends JFrame {

	Connection conn=null;
	PreparedStatement pst=null;
    ResultSet rs=null;
    
	private JPanel contentPane;
	private JTextField uname;
	private JPasswordField pname;
	private JPasswordField pname2;
	private JTextField ans;
	private JComboBox comboBox_1;
	
	private String selectQue;
	
	
	public void comboItem(){
		Connection conn=DbConnection.dbConnector();
		try{
		String query="select * from quesTable";
		
		PreparedStatement pst=conn.prepareStatement(query);
		ResultSet rs=pst.executeQuery();
		
		while(rs.next()){
			comboBox_1.addItem(rs.getString("ques"));

		}
		pst.close();
		rs.close();
				
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	}
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewMember frame = new NewMember();
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
	public NewMember() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblNewUserName = new JLabel("New User Name");
		lblNewUserName.setBounds(59, 54, 133, 14);
		contentPane.add(lblNewUserName);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(59, 91, 108, 14);
		contentPane.add(lblPassword);
		
		JLabel lblReenteredPassword = new JLabel("Re-Enter Password");
		lblReenteredPassword.setBounds(59, 131, 133, 14);
		contentPane.add(lblReenteredPassword);
		
		JLabel lblQues = new JLabel("Ques");
		lblQues.setBounds(59, 173, 108, 14);
		contentPane.add(lblQues);
		
		uname = new JTextField();
		uname.setBounds(202, 51, 159, 20);
		contentPane.add(uname);
		uname.setColumns(10);
		
		pname = new JPasswordField();
		pname.setBounds(202, 88, 159, 20);
		contentPane.add(pname);
		
		pname2 = new JPasswordField();
		pname2.setBounds(202, 128, 159, 20);
		contentPane.add(pname2);
		
		
		JLabel lblAns = new JLabel("Ans");
		lblAns.setBounds(59, 222, 46, 14);
		contentPane.add(lblAns);
		
		ans = new JTextField();
		ans.setBounds(202, 219, 159, 20);
		contentPane.add(ans);
		ans.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int a=0;
				conn=DbConnection.dbConnector();
				
					try {
						String sql1="select * from loginForm";
						pst=conn.prepareStatement(sql1);
						ResultSet rs=pst.executeQuery();
						
						while(rs.next()){
							if(uname.getText().equals(rs.getString("username"))){
								a=1;
								}
						}
						 pst.close();
						 rs.close();
						
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, e);
					}
					
					if(a==1)
					{
						JOptionPane.showMessageDialog(null, "Exists");
					}
					
				
				
				else if(!pname.getText().equals(pname2.getText())){
					JOptionPane.showMessageDialog(null, "Don't macth Password");
				}
				else if(uname.getText().equals("") || pname.getText().equals("") || ans.getText().equals("")){
					JOptionPane.showMessageDialog(null, "First Fill All The Field");
				}
				
				else {
					
			 
				try{
					String sql="insert into loginForm(username,password,ques,ans) values (?,?,?,?)";
					pst=conn.prepareStatement(sql);
					pst.setString(1,uname.getText());
					pst.setString(2,pname.getText());
					pst.setString(3,selectQue);
					pst.setString(4,ans.getText());
					pst.execute();
				       pst.close();
				       
				       JOptionPane.showMessageDialog(null, "Done");
					
				}catch(Exception e){
					JOptionPane.showMessageDialog(null, e);
				}
				}   
			}
		});
		btnSubmit.setBounds(121, 300, 89, 23);
		contentPane.add(btnSubmit);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LoginForm lf=new LoginForm();
				lf.setVisible(true);
			}
		});
		btnBack.setBounds(259, 300, 89, 23);
		contentPane.add(btnBack);
		
		comboBox_1 = new JComboBox();
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Connection conn=DbConnection.dbConnector();
				try{
				String query2="select * from quesTable where ques=?";
				
			    pst=conn.prepareStatement(query2);
				pst.setString(1, (String)comboBox_1.getSelectedItem());
				ResultSet rs=pst.executeQuery();
				
				while(rs.next()){
					
				selectQue=rs.getString("ques");
				
				}
				pst.close();
				rs.close();
						
				}catch(Exception e){
					e.printStackTrace();
				}    
				
			}
		});
		comboBox_1.setBounds(202, 170, 287, 20);
		contentPane.add(comboBox_1);
		
		comboItem();
		
		
	}
}
