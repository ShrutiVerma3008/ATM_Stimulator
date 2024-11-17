package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

public class SignupOne extends JFrame implements ActionListener
 {

    JTextField nameTextField, fnameTextField, emailTextField, addressTextField, cityTextField, pinTextField;
    JDateChooser date;
    JRadioButton male, female, Married, unMarried, other;
    JComboBox<String> state1;

    long random;

    public SignupOne() {
        setLayout(null);

        Random ran = new Random();
        random = (Math.abs(ran.nextLong() % 9000L) + 1000L);

        JLabel formno = new JLabel("Application Form no. : " + random);
        formno.setFont(new Font("Raleway", Font.BOLD, 38));
        formno.setBounds(140, 20, 600, 40);
        add(formno);

        JLabel personalDetails = new JLabel("Page 1 : Personal Details");
        personalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        personalDetails.setBounds(290, 80, 400, 30);
        add(personalDetails);

        // Name
        JLabel name = new JLabel("Name : ");
        name.setFont(new Font("Raleway", Font.BOLD, 22));
        name.setBounds(100, 140, 100, 30);
        add(name);

        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        nameTextField.setBounds(300, 140, 400, 30);
        add(nameTextField);

        // Father Name
        JLabel fname = new JLabel("Father Name : ");
        fname.setFont(new Font("Raleway", Font.BOLD, 22));
        fname.setBounds(100, 190, 200, 30);
        add(fname);

        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        fnameTextField.setBounds(300, 190, 400, 30);
        add(fnameTextField);

        // Date of Birth
        JLabel dob = new JLabel("Date Of Birth : ");
        dob.setFont(new Font("Raleway", Font.BOLD, 22));
        dob.setBounds(100, 240, 200, 30);
        add(dob);

        date = new JDateChooser();
        date.setBounds(300, 240, 400, 30);
        add(date);

        // Gender
        JLabel gender = new JLabel("Gender : ");
        gender.setFont(new Font("Raleway", Font.BOLD, 22));
        gender.setBounds(100, 290, 200, 30);
        add(gender);

        male = new JRadioButton("Male");
        male.setBounds(300, 290, 60, 30);
        male.setBackground(Color.white);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(450, 290, 120, 30);
        female.setBackground(Color.white);
        add(female);

        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);

        // Email
        JLabel email = new JLabel("Email : ");
        email.setFont(new Font("Raleway", Font.BOLD, 22));
        email.setBounds(100, 340, 200, 30);
        add(email);

        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        emailTextField.setBounds(300, 340, 400, 30);
        add(emailTextField);

        // Marital Status
        JLabel marital = new JLabel("Marital Status : ");
        marital.setFont(new Font("Raleway", Font.BOLD, 22));
        marital.setBounds(100, 390, 200, 30);
        add(marital);

        Married = new JRadioButton("Married");
        Married.setBounds(300, 390, 120, 30);
        Married.setBackground(Color.white);
        add(Married);

        unMarried = new JRadioButton("UnMarried");
        unMarried.setBounds(450, 390, 120, 30);
        unMarried.setBackground(Color.white);
        add(unMarried);

        other = new JRadioButton("Other");
        other.setBounds(630, 390, 120, 30);
        other.setBackground(Color.white);
        add(other);

        ButtonGroup mgroup = new ButtonGroup();
        mgroup.add(Married);
        mgroup.add(unMarried);
        mgroup.add(other);

        // Address
        JLabel address = new JLabel("Address : ");
        address.setFont(new Font("Raleway", Font.BOLD, 22));
        address.setBounds(100, 440, 200, 30);
        add(address);

        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        addressTextField.setBounds(300, 440, 400, 30);
        add(addressTextField);

        // City
        JLabel city = new JLabel("City : ");
        city.setFont(new Font("Raleway", Font.BOLD, 22));
        city.setBounds(100, 490, 200, 30);
        add(city);

        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        cityTextField.setBounds(300, 490, 400, 30);
        add(cityTextField);

        // State
        JLabel state = new JLabel("State : ");
        state.setFont(new Font("Raleway", Font.BOLD, 22));
        state.setBounds(100, 540, 200, 30);
        add(state);

        String stateValues[] = {
            "Andhra Pradesh", "Arunachal Pradesh", "Assam", "Bihar", "Chhattisgarh", "Goa", "Gujarat", "Haryana", 
            "Himachal Pradesh", "Jharkhand", "Karnataka", "Kerala", "Madhya Pradesh", "Maharashtra", "Manipur", 
            "Meghalaya", "Mizoram", "Nagaland", "Odisha", "Punjab", "Rajasthan", "Sikkim", "Tamil Nadu", "Telangana", 
            "Tripura", "Uttarakhand", "Uttar Pradesh", "West Bengal"
        };
        state1 = new JComboBox<>(stateValues);
        state1.setBounds(300, 540, 400, 30);
        state1.setBackground(Color.white);
        add(state1);

        // Pin Code
        JLabel pincode = new JLabel("Pin Code : ");
        pincode.setFont(new Font("Raleway", Font.BOLD, 22));
        pincode.setBounds(100, 590, 200, 30);
        add(pincode);

        pinTextField = new JTextField();
        pinTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        pinTextField.setBounds(300, 590, 400, 30);
        add(pinTextField);

        // Next Button
        JButton next = new JButton("Next");
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 660, 80, 30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.white);

        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String formno = "" + random; // long to string
        String name = nameTextField.getText();
        if (name.equals("")) {
            JOptionPane.showMessageDialog(null, "Name is required.");
            return;
        }

        String fname = fnameTextField.getText();
        if (fname.equals("")) {
            JOptionPane.showMessageDialog(null, "Father Name is required.");
            return;
        }

        String dob = null;
        if (date.getDate() != null) {
            dob = ((JTextField) date.getDateEditor().getUiComponent()).getText();
        } else {
            JOptionPane.showMessageDialog(null, "Date of Birth is required.");
            return;
        }

        String gender = null;
        if (male.isSelected()) {
            gender = "Male";
        } else if (female.isSelected()) {
            gender = "Female";
        } else {
            JOptionPane.showMessageDialog(null, "Gender is required.");
            return;
        }

        String email = emailTextField.getText();
        if (email.equals("")) {
            JOptionPane.showMessageDialog(null, "Email is required.");
            return;
        }

        if (isValidEmail(email)) {
            JOptionPane.showMessageDialog(null, "Email is valid.");
        } else {
            JOptionPane.showMessageDialog(null, "Invalid email format.");
            return;
        }

        String marital = null;
        if (Married.isSelected()) {
            marital = "Married";
        } else if (unMarried.isSelected()) {
            marital = "Unmarried";
        } else if (other.isSelected()) {
            marital = "Other";
        } else {
            JOptionPane.showMessageDialog(null, "Marital Status is required.");
            return;
        }

        String address = addressTextField.getText();
        if (address.equals("")) {
            JOptionPane.showMessageDialog(null, "Address is required.");
            return;
        }

        String city = cityTextField.getText();
        if (city.equals("")) {
            JOptionPane.showMessageDialog(null, "City is required.");
            return;
        }

        String stateB = (String) state1.getSelectedItem();

        String pin = pinTextField.getText();
        if (pin.equals("") || pin.length() != 6) {
            JOptionPane.showMessageDialog(null, "Enter a valid pin (6 digits only)");
            return;
        }

        try {
            Conn c = new Conn();
            String query = "INSERT INTO signup VALUES ('" + formno + "', '" + name + "', '" + fname + "', '" + dob + "', '" + gender + "', '" + email + "', '" + marital + "', '" + address + "', '" + city + "', '" + stateB + "', '" + pin + "')";
            c.s.executeUpdate(query);

            setVisible(false);
            new SignupTwo(formno).setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // Method to validate email using regex
    public boolean isValidEmail(String email) {
        // Define a regex pattern for email validation
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

        // Compile the regex pattern
        Pattern pattern = Pattern.compile(emailRegex);

        // Match the email string with the regex pattern
        Matcher matcher = pattern.matcher(email);

        // Return true if the email matches the regex, else false
        return matcher.matches();
    }



	
	public static void main(String[] args) {
		new SignupOne();
	}

	
}
