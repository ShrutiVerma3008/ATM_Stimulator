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
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;


public class PinChange extends JFrame implements ActionListener
{
	JButton back,change;
	JLabel i1;
	String pinnumber;JPasswordField pinText,repinText;
	PinChange(String pinnumber)
	{
		this.pinnumber= pinnumber;
		setLayout(null);
		
		i1 = new JLabel();
		Image img = new ImageIcon(this.getClass().getResource("/bank/management/system/atm.jpg")).getImage();
		i1.setIcon(new ImageIcon(img));
		i1.setBounds(0,0,900,900);add(i1);
		
		JLabel head = new JLabel("Change Your Pin : ");
		head.setBounds(250, 258, 700, 35);
		head.setForeground(Color.white);
		head.setFont(new Font("System",Font.BOLD,22));
		i1.add(head);
		
		JLabel text = new JLabel("New Pin : ");
		text.setBounds(165, 330, 180, 25);
		text.setForeground(Color.white);
		text.setFont(new Font("System",Font.BOLD,16));
		i1.add(text);
		
		pinText = new JPasswordField();
		pinText.setFont( new Font("Raleway",Font.BOLD,14));
		pinText.setBounds(350,320,180,25);
		i1.add(pinText);
		
		JLabel repin = new JLabel("Re-Enter New Pin : ");
		repin.setBounds(165, 360, 180, 25);
		repin.setForeground(Color.white);
		repin.setFont(new Font("System",Font.BOLD,16));
		i1.add(repin);
		
		repinText = new JPasswordField();
		repinText.setFont( new Font("Raleway",Font.BOLD,14));
		repinText.setBounds(350,360,180,25);
		i1.add(repinText);
		
		change = new JButton("Change");
		change.setBounds(400,495,150,30);
		change.addActionListener(this);
		i1.add(change);
		
		back = new JButton("Back");
		back.setBounds(400,540,150,30);
		back.addActionListener(this);
		i1.add(back);
		
		setSize(900,900);
		setLocation(300,0);
		setVisible(true);
	}
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()== change)
		{	
			try
			{
				@SuppressWarnings("deprecation")
				String npin = pinText.getText();
				@SuppressWarnings("deprecation")
				String rpin = repinText.getText();
				
				if(!npin.equals(rpin))
				{
					JOptionPane.showMessageDialog(null,"Entered pin does not match");
					return;
				}
				
				if(npin.equals(""))
				{
					JOptionPane.showMessageDialog(null,"Please enter pin !");
					return;
				}
				if(rpin.equals(""))
				{
					JOptionPane.showMessageDialog(null,"Please Re-enter pin !");
					return;
				}
				
				Conn c = new Conn();
				String query1 = "update bank set pin = '"+rpin+"' where pin='"+pinnumber+ "'";
				String query2 = "update login set pin = '"+rpin+"' where pin='"+pinnumber+ "'";
				String query3 = "update signupthree set pin = '"+rpin+"' where pin='"+pinnumber+ "'";

				c.s.executeUpdate(query1);
				c.s.executeUpdate(query2);
				c.s.executeUpdate(query3);
				
				JOptionPane.showMessageDialog(null,"PIN CHANGED SUCCESSFULLY !");
				setVisible(false);
				new Transactions(pinnumber);
			}	
		
			catch(Exception ex)
			{
				System.out.println(ex);
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
		new PinChange("").setVisible(true);
	}

	
}
