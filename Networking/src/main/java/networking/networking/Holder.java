
package networking.networking;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Holder {
public String insertAndConnect(String port, String Ipaddress, String Domain, String Host, String protocol)
{
    try
    {
 
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection obj = DriverManager.getConnection("jdbc:mysql://localhost:3306/netdb", "root", "");
        String query = "insert into nettable(port,protocol,Host,Ipaddress,Domain)values(?,?,?,?,?)";
        PreparedStatement preparedStatementStmt = obj.prepareStatement(query);
        preparedStatementStmt.setString(1, port);
        preparedStatementStmt.setString(2, Ipaddress);
        preparedStatementStmt.setString(3, Domain);
        preparedStatementStmt.setString(4, Host);
        preparedStatementStmt.setString(5, protocol);
        
        
  
        int i = preparedStatementStmt.executeUpdate();
            if (i>=1) 
            {
                System.out.println("Data is inserted sucessfully !");    
            }
            else
            {
                System.out.println("Data not inserted!"); 
            }
            
    }
    catch(Exception Jordan)
    {
    }
    return null;
}

}
