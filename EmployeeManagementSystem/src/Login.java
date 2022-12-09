import java.awt.Color;
import java.awt.Image;

import javax.swing.*;

import java.awt.event.*;
import java.sql.ResultSet;

import java.awt.*;
import java.sql.*;
import java.sql.Statement;
import java.sql.DriverManager;

public class Login extends JFrame implements ActionListener 
{
    JTextField tfusername,tfpassword;

    Login()
    {
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setLayout(null);

        JLabel lblusername=new JLabel("Username");
        lblusername.setBounds(40, 40, 100, 30);
        add(lblusername);

        tfusername=new JTextField();
        tfusername.setBounds(150, 45, 100, 20);
        add(tfusername);

        JLabel lblpassword=new JLabel("Password");
        lblpassword.setBounds(40,80,100,30);
        add(lblpassword);

        tfpassword=new JTextField();
        tfpassword.setBounds(150,85,100,20);
        add(tfpassword);

        JButton login=new JButton("Login");
        login.setBounds(150,135,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("second.png"));
        Image i2=i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(300,15,200,200);
        add(image);

        setSize(600, 300);
        setLocation(450,200);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        try
        {
            String username=tfusername.getText();
            String password=tfpassword.getText();

            //System.out.println(username+" "+password);
            //System.out.println(query);
            
            Conn cu= new Conn(); 

            String query="select * from login where username = '"+username+"' and password = '"+password+"'";
            

            ResultSet rs= cu.sp.executeQuery(query);

            

            if(rs.next())
            {
                setVisible(false);
                
                new Home();
                //nextclass
            }
            else
            {
                //JOptionPane.showMessageDialog(username, "Invalid username or password");
                JOptionPane.showMessageDialog(null, "Invalid username or password");
                setVisible(false);
            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String args[])
    {
        new Login();
    }
}
