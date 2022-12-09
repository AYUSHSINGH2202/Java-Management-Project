
import java.awt.Color;
import java.awt.color.*;
import java.sql.ResultSet;

import javax.swing.*;

import net.proteanit.sql.DbUtils;

import java.awt.*;

public class RemoveEmployee extends JFrame
{
	Choice cEmpId;
	
	RemoveEmployee()
	{
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setLayout(null);
		
		
		JLabel labelempId=new JLabel("Employee Id");
		labelempId.setBounds(50,50,100,30);
		add(labelempId);
		
		cEmpId=new Choice();
		cEmpId.setBounds(200,50,150,30);
		add(cEmpId);
		
		try
		{
			Conn c=new Conn();
			String query="select * from employee";
			ResultSet rs=c.sp.executeQuery(query);
			while(rs.next())
			{
				cEmpId.add(rs.getString("empId"));
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		setSize(1000,400);
		setLocation(200,150);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new RemoveEmployee();
	}

}
