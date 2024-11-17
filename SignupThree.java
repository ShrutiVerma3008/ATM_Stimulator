package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class SignupThree extends JFrame implements ActionListener

{
	JButton submit,cancel;
	JCheckBox c1,c2,c3,c4,c5,c6,c7;
	JTextField aadharTextField,pan,nameTextField,fnameTextField,dobTextField,emailTextField,addressTextField,cityTextField,stateTextField,pinTextField;
	JRadioButton r1,r2,r3,r4;
	@SuppressWarnings("rawtypes")//not paramters
	JComboBox religion,category1,income1,Qualification1,Occupiaction1;
	//JDateChooser date;
	String formno;
	
	SignupThree(String formno)
	{
		this.formno = formno;
		setLayout(null);
		
		setTitle("New Account Details Form - page 3");
		
		
		JLabel accountDetails = new JLabel("Page 3 : Account Details");
		accountDetails.setFont(new Font("Raleway",Font.BOLD,22));
		accountDetails.setBounds(290, 80, 400, 30);//setbound will work only when setlayout i s null
		add(accountDetails);
		
		JLabel type = new JLabel("Account Type : ");
		type.setFont(new Font("Raleway",Font.BOLD,22));
		type.setBounds(100, 140, 200, 30);//setbound will work only when setlayout i s null
		add(type);
		
		 r1 = new JRadioButton("Saving Account");
		 r1.setBounds(100, 180, 150, 20);
		 r1.setBackground(Color.white);
		add(r1);
		r2 = new JRadioButton("Fixed Deposit Account");
		r2.setBounds(350, 180, 250, 20);
		r2.setBackground(Color.white);
		add(r2);
		r3 = new JRadioButton("Current Account");
		r3.setBounds(100, 220, 150, 20);
		r3.setBackground(Color.white);
		add(r3);
		r4 = new JRadioButton("Recurring Deposit Account");
		r4.setBounds(350, 220, 250, 20);
		r4.setBackground(Color.white);
		add(r4);
			
			ButtonGroup typegroup = new ButtonGroup();
			typegroup.add(r1);
			typegroup.add(r2);
			typegroup.add(r3);
			typegroup.add(r4);

		
		JLabel card = new JLabel("Card Numer : ");
		card.setFont(new Font("Raleway",Font.BOLD,22));
		card.setBounds(100, 300, 200, 30);//setbound will work only when setlayout i s null
		add(card);
		
		JLabel number = new JLabel("XXXX-XXXX-XXXX-4124");
		number.setFont(new Font("Raleway",Font.BOLD,22));
		number.setBounds(330, 300, 300, 30);//setbound will work only when setlayout i s null
		add(number);
		JLabel cardDetail = new JLabel("Your 16 digit Card Number. ");
		cardDetail.setFont(new Font("Raleway",Font.BOLD,12));
		cardDetail.setBounds(100, 330, 300, 20);//setbound will work only when setlayout i s null
		add(cardDetail);
		
		JLabel pin = new JLabel("Pin Numer : ");
		pin.setFont(new Font("Raleway",Font.BOLD,22));
		pin.setBounds(100, 370, 200, 30);//setbound will work only when setlayout i s null
		add(pin);
		
		JLabel pnumber = new JLabel("XXXX");
		pnumber.setFont(new Font("Raleway",Font.BOLD,22));
		pnumber.setBounds(330, 370, 300, 30);//setbound will work only when setlayout i s null
		add(pnumber);
		JLabel pinDetail = new JLabel("Your 4 digit pin Number. ");
		pinDetail.setFont(new Font("Raleway",Font.BOLD,12));
		pinDetail.setBounds(100, 400, 300, 20);//setbound will work only when setlayout i s null
		add(pinDetail);
		
		
		JLabel services = new JLabel("Services Required : ");
		services.setFont(new Font("Raleway",Font.BOLD,22));
		services.setBounds(100, 450, 400, 30);//setbound will work only when setlayout i s null
		add(services);
		
		c1 = new JCheckBox("ATM CARD");
		c1.setFont(new Font("Raleway",Font.BOLD,16));
		c1.setBounds(100,500,200,30);
		c1.setBackground(Color.white);
		add(c1);
		c2 = new JCheckBox("Internet Banking");
		c2.setFont(new Font("Raleway",Font.BOLD,16));
		c2.setBounds(350,500,200,30);
		c2.setBackground(Color.white);
		add(c2);
		c3 = new JCheckBox("Mobile Banking");
		c3.setFont(new Font("Raleway",Font.BOLD,16));
		c3.setBounds(100,550,200,30);
		c3.setBackground(Color.white);
		add(c3);
		c4 = new JCheckBox("Email & SMS Aletrs");
		c4.setFont(new Font("Raleway",Font.BOLD,16));
		c4.setBounds(350,550,200,30);
		c4.setBackground(Color.white);
		add(c4);
		c5 = new JCheckBox("Cheque book");
		c5.setFont(new Font("Raleway",Font.BOLD,16));
		c5.setBounds(100,600,200,30);
		c5.setBackground(Color.white);
		add(c5);
		c6 = new JCheckBox("E Statement");
		c6.setFont(new Font("Raleway",Font.BOLD,16));
		c6.setBounds(350,600,200,30);
		c6.setBackground(Color.white);
		add(c6);
		c7 = new JCheckBox("I hereby declare that above entered details are correct to the best of my knowledge.");
		c7.setFont(new Font("Raleway",Font.BOLD,12));
		c7.setForeground(Color.red);
		c7.setBounds(100,680,600,30);
		c7.setBackground(Color.white);
		add(c7);
		
		
		
		
		submit = new JButton("Submit");
		submit.setBackground(Color.green);
		submit.setForeground(Color.white);
		submit.setFont(new Font("Raleway", Font.BOLD,14));
		submit.setBounds(250, 720, 100, 30);
		submit.addActionListener(this);
		add(submit);
		
		cancel = new JButton("Cancel");
		cancel.setBackground(Color.red);
		cancel.setForeground(Color.white);
		cancel.setFont(new Font("Raleway", Font.BOLD,14));
		cancel.setBounds(250, 720, 80, 30);
		cancel.addActionListener(this);
		add(cancel);


		
		getContentPane().setBackground(Color.white);
		
		
		setSize(850,800);
		setLocation(350,10);
		setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
//		String accountType=null;String cardnumber=null; String facility=null;
//		String pinnumber=null;
		if(e.getSource() == submit)
		{
			 String accountType= null;
			if(r1.isSelected())
			{
				accountType= "Saving Account";
			}
			else if(r2.isSelected())
			{
				accountType= "Fixed Deposit Account";
			}
			else if(r3.isSelected())
			{
				accountType= "Current Account";
			}
			else if(r4.isSelected())
			{
				accountType= "Recurring Deposit Account";
			}
			else 			
			{
				JOptionPane.showMessageDialog(null, "Account selection is required.");
				return;
			}
			
			Random random = new Random();
			String cardnumber =""+ Math.abs((random.nextLong() % 90000000000000000L)+ 50409360);//starting digit fix
			String pinnumber =""+ Math.abs((random.nextLong() % 9000L)+1000L);//starting digit fix
			
			String facility = "";
			if(c1.isSelected())
			{
				facility += "ATM CARD" ;
			}
			 if(c2.isSelected())
			{
				facility += " Internet Banking" ;
			}
			 if(c3.isSelected())
			{
				facility += " Mobile Banking" ;
			}
			 if(c4.isSelected())
			{
				facility += " Email & SMS Aletrs" ;
			}
			 if(c5.isSelected())
			{
				facility += " Cheque book" ;
			}
			 if(c6.isSelected())
			{
				facility += " E Statement" ;
			}
			if(facility.equals(""))
			{
				JOptionPane.showMessageDialog(null, "Select atleast one facility.");
				return;
			} 
			 try 
				{
					if(accountType.equals(""))
					{
						JOptionPane.showMessageDialog(null,"Account Type is Required !");
					}
					else	
						{
							Conn c = new Conn();							
							String query = "insert into signupthree values('"+formno+"', '"+accountType+"', '"+cardnumber+"', '"+pinnumber+"', '"+facility+"')";
							String query2 = "insert into login values('"+formno+"', '"+cardnumber+"', '"+pinnumber+"')";

							c.s.executeUpdate(query);
							c.s.executeUpdate(query2);

							JOptionPane.showMessageDialog(null, "Card Number " + cardnumber + "\n Pin : " + pinnumber);
							setVisible(false);
							new Deposit(pinnumber).setVisible(true); 

						}
											
				}
				catch(Exception ex) 
			   {
					System.out.println(ex);
				}
			 
		}
		else if(e.getSource() == cancel)
		{
			setVisible(false);
			new Login().setVisible(true);
		}
	


		
		
	}
	
	public static void main(String[] args) {
		new SignupThree("");
	}

}
