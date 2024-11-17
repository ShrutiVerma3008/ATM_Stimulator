package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Transactions extends JFrame implements ActionListener
{
	String pinnumber;
	JLabel i1;
	JButton deposit,withdrawl,exit,balanceEnquiry,pinchange,ministatement,fastcash;
	Transactions(String pinnumber)
	{
		setLayout(null);
		this.pinnumber = pinnumber; 
		
		i1 = new JLabel();
		Image img = new ImageIcon(this.getClass().getResource("/bank/management/system/atm.jpg")).getImage();
		i1.setIcon(new ImageIcon(img));
		i1.setBounds(0,0,900,900);add(i1);
		
		JLabel text = new JLabel("Please select the transaction: ");
		text.setBounds(212, 300, 700, 35);
		text.setForeground(Color.white);
		text.setFont(new Font("System",Font.BOLD,16));
		i1.add(text);
		
		 deposit = new JButton("Deposit");
		deposit.setBounds(170,415,150,30);
		i1.add(deposit);
		deposit.addActionListener(this);

		 withdrawl = new JButton("Cash withdrawl");
		withdrawl.setBounds(390,415,150,30);
		i1.add(withdrawl);
		withdrawl.addActionListener(this);

		 fastcash = new JButton("Fast Cash");
		fastcash.setBounds(170,450,150,30);
		i1.add(fastcash);
		fastcash.addActionListener(this);

		 ministatement = new JButton("Mini Statement");
		ministatement.setBounds(390,450,150,30);
		i1.add(ministatement);
		ministatement.addActionListener(this);

		 pinchange = new JButton("pin change");
		pinchange.setBounds(170,485,150,30);
		i1.add(pinchange);
		pinchange.addActionListener(this);
		
		 balanceEnquiry = new JButton("Balance Enquiry");
		balanceEnquiry.setBounds(390,485,150,30);
		balanceEnquiry.addActionListener(this);
		i1.add(balanceEnquiry);
		
		 exit = new JButton("Exit");
		exit.setBounds(390,520,150,30);
		exit.addActionListener(this);
		i1.add(exit);
		
		
		
		setSize(900,900);
		setLocation(300,0);
		setUndecorated(true);
		
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==exit)
		{
			System.exit(0);
		}
		else if(e.getSource() == deposit)
		{
			setVisible(false);
			new Deposit(pinnumber);//setVisible(true);
		}
		else if(e.getSource() == withdrawl)
		{
			setVisible(false);
			new Withdrawl(pinnumber);//setVisible(true);
		}
		else if(e.getSource() == fastcash)
		{
			setVisible(false);
			new FastCash(pinnumber);//setVisible(true);
		}
		else if(e.getSource() == pinchange)
		{
			setVisible(false);
			new PinChange(pinnumber);//setVisible(true);
		}
		else if(e.getSource() == balanceEnquiry)
		{
			setVisible(false);
			new BalanceEnquiry(pinnumber);//setVisible(true);
		}
		else if(e.getSource() == ministatement)
		{
			//setVisible(false);
			new MiniStatement(pinnumber);//setVisible(true);
		}
		
	}
	
	
	public static void main(String[] args) 
	{
		new Transactions("");
		
	}

	
}
