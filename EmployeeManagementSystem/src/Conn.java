import java.sql.DriverManager;
import java.sql.*;

public class Conn {
    Connection c;
    Statement sp;

    public Conn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///employeems", "root", "prince123#");
            sp = c.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) 
    {

    }
}
