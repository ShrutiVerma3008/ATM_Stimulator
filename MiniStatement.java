package bank.management.system;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class MiniStatement extends JFrame implements ActionListener 
{
	 String pinnumber;
	 JButton printB,exitB;
	 public MiniStatement(String pinnumber) 
	 { 
		this.pinnumber= pinnumber;
		setLayout(null);
		// TODO Auto-generated constructor stub
		 
		JLabel mini = new JLabel();
		add(mini);
		
		JLabel bank = new JLabel("Indian Bank");
		bank.setBounds(150,20,100,20);
		add(bank);
		
		JLabel card = new JLabel();
		card.setBounds(20,80,300,20);
		add(card);
		
		JLabel balance = new JLabel();
		balance.setBounds(20,400,300,20);
		add(balance);
		
		try
		{
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("select * from login where pin = '"+pinnumber+"'");
			while(rs.next())
			{
				card.setText("Card Number : "+ rs.getString("cardnumber").substring(0,4)+"XXXXXXXX"+ rs.getString("cardnumber").substring(12));
			}
		
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		
		try
		{
			Conn c = new Conn();
			int bal =0 ;
			ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
			while(rs.next())
			{
				mini.setText(mini.getText()+"<html>"+rs.getString("date")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ rs.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ rs.getString("amount")+"<br><br><html>");//getText for -append    setText-it overwrite
				
				if(rs.getString("type").equals("Deposit"))
				{
					bal += Integer.parseInt(rs.getString("amount"));
				}
				else
				{
					bal -= Integer.parseInt(rs.getString("amount"));
				}
				
			}
			
			balance.setText("Your current account balance is Rs "+bal);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			//System.out.println(ex);
		}
		
		mini.setBounds(20,140,400,200);
		
		 setTitle("Mini Staement");
		 setSize(400,600);
		 setLocation(20,20);
		 getContentPane().setBackground(Color.white);
		 setVisible(true);

		 setLayout(null);
		exitB = new JButton("Exit");
		exitB.setBounds(20, 500, 100, 25);
		exitB.addActionListener(this);
		add(exitB);

		printB = new JButton("Print");
		printB.setBounds(250, 500, 100, 25);
		add(printB);
		         
		 
		printB.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent ae) 
			{
					// Open new window with JTable
							new PrintPage(pinnumber).setVisible(true);
						}
					});
		 
		         
		     }
		 
		     public void actionPerformed(ActionEvent ae) {
		         this.setVisible(false);
		     }
		 
	 public static void main(String[] args)
	 {
		 new MiniStatement("");
		
	}

}

class PrintPage extends JFrame 
{
    PrintPage(String pin) {
        super("Transaction Details");
        setSize(800, 600);
        setLocation(100, 100);

        String[] columnNames = {"Date", "Type","Amount"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        try {
            Conn c1 = new Conn();
            ResultSet rs = c1.s.executeQuery("SELECT * FROM bank WHERE pin = '" + pin + "'");
            while (rs.next()) {
                String date = rs.getString("date");
                String type = rs.getString("type");
                String amount = rs.getString("amount");
                model.addRow(new Object[]{date, type, amount});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Add Print functionality
        JButton printButton = new JButton("Print");
        add(printButton, BorderLayout.SOUTH);
        printButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    table.print();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}