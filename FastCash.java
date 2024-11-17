package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class FastCash extends JFrame implements ActionListener
{
	String pinnumber;
	JLabel i1;
	JButton deposit,withdrawl,exit,balanceEnquiry,pinchange,ministatement,fastcash;
	FastCash(String pinnumber)
	{
		setLayout(null);
		this.pinnumber = pinnumber; 
		
		i1 = new JLabel();
		Image img = new ImageIcon(this.getClass().getResource("/bank/management/system/atm.jpg")).getImage();
		i1.setIcon(new ImageIcon(img));
		i1.setBounds(0,0,900,900);add(i1);
		
		JLabel text = new JLabel("Select Withdrawl Amount : ");
		text.setBounds(230, 300, 700, 35);
		text.setForeground(Color.white);
		text.setFont(new Font("System",Font.BOLD,22));
		i1.add(text);
		
		 deposit = new JButton("Rs 100");
		deposit.setBounds(170,415,150,30);
		i1.add(deposit);
		deposit.addActionListener(this);

		 withdrawl = new JButton("Rs 500");
		withdrawl.setBounds(400,415,150,30);
		i1.add(withdrawl);
		withdrawl.addActionListener(this);

		 fastcash = new JButton("Rs 1000");
		fastcash.setBounds(170,450,150,30);
		i1.add(fastcash);
		fastcash.addActionListener(this);

		 ministatement = new JButton("Rs 2000");
		ministatement.setBounds(400,450,150,30);
		i1.add(ministatement);
		ministatement.addActionListener(this);

	
		 pinchange = new JButton("Rs 5000");
		pinchange.setBounds(170,485,150,30);
		i1.add(pinchange);
		pinchange.addActionListener(this);
		
		 balanceEnquiry = new JButton("Rs 10000");
		balanceEnquiry.setBounds(400,485,150,30);
		balanceEnquiry.addActionListener(this);
		i1.add(balanceEnquiry);
		
		 exit = new JButton("back");
		exit.setBounds(400,520,150,30);
		exit.addActionListener(this);
		i1.add(exit);
		
		
		
		setSize(900,900);
		setLocation(300,0);
		setUndecorated(true);
		
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==exit)
		{
			setVisible(false);
			new Transactions(pinnumber).setVisible(true);;
		}
		
		else 
		{
			String amount =((JButton) e.getSource()).getText().substring(3);//beavuse it retun an object - give Rs 500 to 500 only
			Conn c = new Conn();
			try
			{
				if (pinnumber == null || pinnumber.isEmpty()) {
					JOptionPane.showMessageDialog(null, "PIN number is not valid.");
					return;
				}
				ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
				int balance =0 ;
				while(rs.next())//ek-ek row ko dega
				{
					if(rs.getString("type").equals("Deposit"))
					{
						balance += Integer.parseInt(rs.getString("amount"));
					}
					else
					{
						balance -= Integer.parseInt(rs.getString("amount"));
					}
				}
				
				if(e.getSource() != exit && balance < Integer.parseInt(amount))
				{
					JOptionPane.showMessageDialog(null, "Insufficient Balance");
					return;
				}
				
				Date date = new Date(); // date is present in util
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String dateString = sdf.format(date);
				String query = "insert into bank values ('" + pinnumber + "', '" + dateString + "', 'Withdrawl', '" + amount + "')";
				c.s.executeUpdate(query);
				
				JOptionPane.showMessageDialog(null,"Rs "+amount+" Debited Successfully.");
			
				setVisible(false);
				new Transactions(pinnumber).setVisible(true);
			}
			catch (Exception e3) {
				// TODO: handle exception
				System.out.println(e3);
			}
		}
		
	}
	
	
	public static void main(String[] args) 
	{
		new FastCash("");
		
	}

	
}

