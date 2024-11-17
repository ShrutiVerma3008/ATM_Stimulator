package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;




public class Login extends JFrame implements ActionListener
{
	JButton login , logup,clear;
	JTextField cardTextField;//gglobal because acction listener listener is added
	JPasswordField pinTextField;
	//JLabel i1;
	Login()
	{
		setTitle("AUTOMATED TELER MACHINE");
		
		setLayout(null);
				
		JLabel text = new JLabel("Welcome to ATM");
		text.setFont(new Font("Osward",Font.BOLD,38));
		text.setBounds(200, 40, 400, 40);
		add(text);
		
		JLabel cardno = new JLabel("Card Number : ");
		cardno.setFont(new Font("Raleway",Font.BOLD,22));
		cardno.setBounds(120, 150, 250, 30);
		add(cardno);
		
		cardTextField = new JTextField();
		cardTextField.setBounds(300, 150, 250, 30);
		cardTextField.setFont(new Font("Arial", Font.BOLD,20));
		add(cardTextField);
		
		JLabel pin = new JLabel("Pin : ");
		pin.setFont(new Font("Raleway",Font.BOLD,22));
		pin.setBounds(130, 215, 250, 40);
		add(pin);
		
		pinTextField = new JPasswordField();
		pinTextField.setBounds(300, 220, 250, 30);
		pinTextField.setFont(new Font("Arial", Font.BOLD,14));
		add(pinTextField);
		
		 login = new JButton("Sign In");
		login.setBounds(300, 300, 100, 30);
		login.setBackground(Color.green);
		login.setForeground(Color.white);
		login.addActionListener(this);
		add(login);
		
		 clear = new JButton("Clear");
		clear.setBounds(430, 300, 100, 30);
		clear.setBackground(Color.red);
		clear.setForeground(Color.white);
		clear.addActionListener(this);

		add(clear);
		
		 logup = new JButton("Sign Up");
		logup.setBounds(300, 350, 230, 30);
		logup.setBackground(Color.black);
		logup.setForeground(Color.white);
		logup.addActionListener(this);

		add(logup);
		
		getContentPane().setBackground(Color.white);//awt
		
		setSize(800,480);
		setVisible(true);
		setLocation(350,200);//x-y axis from the scree on pc
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==clear) {
			cardTextField.setText("");//to clear the text field
			pinTextField.setText("");
		}
		else if(e.getSource()==login)
		{
			Conn c = new Conn();
			String cardnumber = cardTextField.getText();
			@SuppressWarnings("deprecation")
			String pinnumber = pinTextField.getText();//indicate it is passworrd
			String query = "select * from login where cardnumber = '"+cardnumber+"' and pin = '"+pinnumber+"'";
			try
			{
				ResultSet rs = c.s.executeQuery(query);
				
				if(rs.next())
				{
					setVisible(false);
					new Transactions(pinnumber).setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Incorrect Card Number or pin");
				}
				
				
			} 
			catch (Exception ex) 
			{
				ex.printStackTrace();
				//System.out.println(e2);
			}

			
		}	
		else if(e.getSource()==logup)
		{
			setVisible(false);
			new SignupOne().setVisible(true);	
		}
	}
	
	public static void main(String[] args) 
	{
		new Login();
		
	}

	

}
