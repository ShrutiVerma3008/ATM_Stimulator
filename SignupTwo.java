package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public class SignupTwo extends JFrame implements ActionListener{
	
	
	JTextField aadharTextField,pan,nameTextField,fnameTextField,dobTextField,emailTextField,addressTextField,cityTextField,stateTextField,pinTextField;
	JRadioButton y,n,y1,n1,Married,unMarried,other;
	JComboBox<String> religion, category1, income1, Qualification1, Occupiaction1;

	//JDateChooser date;
	String formno;
	
	SignupTwo(String formno)
	{
		this.formno = formno;
		setLayout(null);
		
		setTitle("New Application Form - Page 2");
		
		
		JLabel additionalDetails = new JLabel("Page 2 : Additional Details");
		additionalDetails.setFont(new Font("Raleway",Font.BOLD,22));
		additionalDetails.setBounds(290, 80, 400, 30);//setbound will work only when setlayout i s null
		add(additionalDetails);
		
		JLabel religion1 = new JLabel("Religion : ");
		religion1.setFont(new Font("Raleway",Font.BOLD,18));
		religion1.setBounds(100, 140, 400, 30);//setbound will work only when setlayout i s null
		add(religion1);
		
		//copmbo box- drop dow with array of string
		String valReligion[] = {"Hindu", "Muslim", "Christian", "Sikh", "Other"};
		religion = new JComboBox<>(valReligion);
		religion.setBounds(300, 140, 400, 30);
		religion.setBackground(Color.white);
		add(religion);
		
		JLabel category = new JLabel("Category : ");
		category.setFont(new Font("Raleway",Font.BOLD,18));
		category.setBounds(100, 190, 200, 30);//setbound will work only when setlayout i s null
		add(category);
		
		String valcategory[] = {"General", "OBC", "ST", "SC"};
		category1 = new JComboBox<>(valcategory);
		category1.setBounds(300,190,400,30);
		category1.setBackground(Color.white);
		add(category1);
		
		JLabel income = new JLabel("Income : ");
		income.setFont(new Font("Raleway",Font.BOLD,18));
		income.setBounds(100, 240, 200, 30);//setbound will work only when setlayout i s null
		add(income);
		String incomecategory[] = {"NULL", "< 1,50,000", "< 2,50,000", "<5,00,000", "< 10,00,000", "> 10,00,000"};
		income1 = new JComboBox<>(incomecategory);
		income1.setBounds(300,240,400,30);
		income1.setBackground(Color.white);
		add(income1);
		 

		
		
		JLabel educational = new JLabel("Educatioanls : ");
		educational.setFont(new Font("Raleway",Font.BOLD,18));
		educational.setBounds(100, 290, 200, 30);//setbound will work only when setlayout i s null
		add(educational);
	
		JLabel Qualification = new JLabel("Qualification : ");
		Qualification.setFont(new Font("Raleway",Font.BOLD,18));
		Qualification.setBounds(100, 315, 200, 30);//setbound will work only when setlayout i s null
		add(Qualification);
		
		String educationValues[] = {"Non Graduation", "Graduate", "Post Graduate", "Doctorate","Illetriate","other"};
		Qualification1 = new JComboBox<>(educationValues);
		Qualification1.setBounds(300,300,400,30);
		Qualification1.setBackground(Color.white);
		add(Qualification1);
		
	
		JLabel Occupiaction = new JLabel("Occupiaction : ");
		Occupiaction.setFont(new Font("Raleway",Font.BOLD,18));
		Occupiaction.setBounds(100, 390, 200, 30);//setbound will work only when setlayout i s null
		add(Occupiaction);
		
		String occupationValues[] = {"Student", "Self Employed", "Salaried", "Business", "Other"};
		Occupiaction1 = new JComboBox<>(occupationValues);
		Occupiaction1.setBounds(300,390,400,30);
		Occupiaction1.setBackground(Color.white);
		add(Occupiaction1);
		
		
		JLabel panNumber = new JLabel("PAN Number : ");
		panNumber.setFont(new Font("Raleway",Font.BOLD,18));
		panNumber.setBounds(100, 440, 200, 30);//setbound will work only when setlayout i s null
		add(panNumber);
		 pan = new JTextField();
		pan.setFont(new Font("Raleway",Font.BOLD,14));
		pan.setBounds(300,440,400,30);
		add(pan);
		
		JLabel aadhar = new JLabel("Aadhar Number : ");
		aadhar.setFont(new Font("Raleway",Font.BOLD,18));
		aadhar.setBounds(100, 490, 200, 30);//setbound will work only when setlayout i s null
		add(aadhar);
		aadharTextField = new JTextField();
		aadharTextField.setFont(new Font("Raleway",Font.BOLD,14));
		aadharTextField.setBounds(300,490,400,30);
		add(aadharTextField);
		
		JLabel state = new JLabel("Senior Citizen : ");
		state.setFont(new Font("Raleway",Font.BOLD,18));
		state.setBounds(100, 540, 200, 30);//setbound will work only when setlayout i s null
		add(state);
		
		y = new JRadioButton("Yes");
		y.setBounds(300, 540, 60, 30);
		y.setBackground(Color.white);
		add(y);
		n = new JRadioButton("No");
		n.setBounds(450, 540, 120, 30);
		n.setBackground(Color.white);
		add(n);
			
		ButtonGroup gendergroup = new ButtonGroup();
		gendergroup.add(y);
		gendergroup.add(n);
			
		
		JLabel pincode = new JLabel("Existing Account: ");
		pincode.setFont(new Font("Raleway",Font.BOLD,18));
		pincode.setBounds(100, 590, 200, 30);//setbound will work only when setlayout i s null
		add(pincode);
		 y1 = new JRadioButton("Yes");
		y1.setBounds(300, 590, 60, 30);
		y1.setBackground(Color.white);
		add(y1);
		n1 = new JRadioButton("No");
		n1.setBounds(450, 590, 120, 30);
		n1.setBackground(Color.white);
		add(n1);
			
		ButtonGroup gendergroup1 = new ButtonGroup();
		gendergroup1.add(y1);
		gendergroup1.add(n1);
		
		
		JButton next = new JButton("Next");
		next.setBackground(Color.black);
		next.setForeground(Color.white);
		next.setFont(new Font("Raleway", Font.BOLD,14));
		next.setBounds(620, 660, 80, 30);
		next.addActionListener(this);
		add(next);

		
		getContentPane().setBackground(Color.white);
		
		
		setSize(850,800);
		setLocation(350,10);
		setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	 {
		String sreligion =(String) religion.getSelectedItem();//object return
		String scatergory = (String) category1.getSelectedItem();
		String sincome = (String) income1.getSelectedItem();
		String squalification = (String) Qualification1.getSelectedItem();
		String soccupiaction= (String) Occupiaction1.getSelectedItem();
		String seniorcitizen = null;
		if(y.isSelected())
		{
			seniorcitizen="Yes";
		}
		else if(n.isSelected())
		{
			seniorcitizen="No";
		}
		String existingacc = null;
		if(y1.isSelected())
		{
			existingacc="Yes";
		}
		else if(n1.isSelected())
		{
			existingacc="No";
		}
		
	
		String span = pan.getText();
		if(span.equals("")||span.length() !=10)
		{
			JOptionPane.showMessageDialog(null, "PAN number is required( of 10 digits only).");
			return;
		}
		String saadhar = aadharTextField.getText();
		if(saadhar.equals("")|| saadhar.length() !=12)
		{
			JOptionPane.showMessageDialog(null, "Aadhar number is required(of 12 digits only).");
			return;
		}


		try 
		{
			
				Conn c = new Conn();
				String query = "insert into signuptwo values('" + formno + "', '" + sreligion + "', '" + scatergory + "', '" + sincome + "', '" + squalification + "', '" + soccupiaction + "', '" + seniorcitizen + "', '" + existingacc + "', '" + span + "', '" + saadhar + "')";
				c.s.executeUpdate(query);
					
				//Signupthree
				setVisible(false);
				new SignupThree(formno).setVisible(true);
				
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		new SignupTwo("");
	}

	
}

