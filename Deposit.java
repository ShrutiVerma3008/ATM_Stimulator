package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Deposit extends JFrame implements ActionListener
{
	JLabel i1;
	JButton deposit, back;
	JTextField amount;
	String pinnumber;
	Deposit(String pinnumber)
	{
		this.pinnumber= pinnumber;
		setLayout(null);
		
		i1 = new JLabel();
		Image img = new ImageIcon(this.getClass().getResource("/bank/management/system/atm.jpg")).getImage();
		i1.setIcon(new ImageIcon(img));
		i1.setBounds(0,0,900,900);add(i1);
		
		JLabel text = new JLabel("Enter the amount to deposit : ");
		text.setForeground(Color.white);
		text.setFont(new Font("System", Font.BOLD,16));
		text.setBounds(170,300,400,20);
		i1.add(text);
		
		 amount = new JTextField();
		amount.setFont( new Font("Raleway",Font.BOLD,20));
		amount.setBounds(170,350,320,25);
		i1.add(amount);
		
		 deposit = new JButton("Deposit");
		deposit.setBounds(170,485,150,30);
		deposit.addActionListener(this);
		i1.add(deposit);
		
		back = new JButton("Back");
		back.setBounds(400,485,150,30);
		back.addActionListener(this);
		i1.add(back);

		setSize(900,900);
		setLocation(300,0);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == deposit)
		{
			String number = amount.getText();
			Date date = new Date();
			if(number.equals(""))
			{
				JOptionPane.showMessageDialog(null,"Enter the amount you want to deposit");
			}
			else
			{
				try 
				{
					Conn c = new Conn();
					String query = "insert into bank values('"+pinnumber+"', '"+date+"', 'Deposit', '"+number+"')";
					c.s.executeUpdate(query);
					JOptionPane.showMessageDialog(null,"Rs. "+number+" Deposited successfully");
					setVisible(false);
					new Transactions(pinnumber).setVisible(true);
				}
				catch(Exception ex)
				{
					// System.out.println(ex);
					ex.printStackTrace();
				}
				
			}
			
		}
		else if(e.getSource() == back)
		{
			setVisible(false);
			new Transactions(pinnumber);
			//setVisible(true);
		}
		
	}
	public static void main(String[] args) 
	{
		new Deposit("");
	}

}
