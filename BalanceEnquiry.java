package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BalanceEnquiry extends JFrame implements ActionListener {
    JLabel i1;
    String pinnumber;
    JButton back;
    
    public BalanceEnquiry(String pinnumber) {
        this.pinnumber = pinnumber;
        setLayout(null);
        
        i1 = new JLabel();
        Image img = new ImageIcon(this.getClass().getResource("/bank/management/system/atm.jpg")).getImage();
        i1.setIcon(new ImageIcon(img));
        i1.setBounds(0, 0, 900, 900);
        add(i1);
        
        back = new JButton("Back");
        back.setBounds(400, 540, 150, 30);
        back.addActionListener(this);
        i1.add(back);
        
        int balance = 0;

        Conn c = new Conn();
        try {
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '" + pinnumber + "'");
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace(); // You can replace this with a logging framework if needed
        }
        
        JLabel text = new JLabel("Current Balance is Rs " + balance);
        text.setBounds(170, 330, 300, 25);
        text.setForeground(Color.white);
        text.setFont(new Font("System", Font.BOLD, 16));
        i1.add(text);
        
        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new BalanceEnquiry("");
    }
}
