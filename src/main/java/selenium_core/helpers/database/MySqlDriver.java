package selenium_core.helpers.database;

import java.sql.*;

public class MySqlDriver
{
    //----------------------------------------------------------------------------------------------------------------||
    public static final String DB_URL = "jdbc:mysql://localhost/family";
    public static final String DB_USER = "root";
    public static final String DB_PASSWORD = "7753191ilove7753191";
    public static Connection conn = null;
    private static Statement stmt;
    //----------------------------------------------------------------------------------------------------------------||
    public static void getConnection() throws Exception
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver"); //com.mysql.cj.jdbc.Driver
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Where is your MySQL JDBC Driver?");
            e.printStackTrace();
        }
        try
        {
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            if (conn != null)
            {
                stmt = conn.createStatement();
            }
            else
            {
                System.out.println("Failed to make connection!");
                stmt = null;
            }
        }
        catch (SQLException e)
        {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
        }
    }
    //----------------------------------------------------------------------------------------------------------------||
    public static ResultSet queryDataBaseValue(String query) throws Exception
    {
        getConnection();
        ResultSet res = stmt.executeQuery(query);
        //res.next();
        //return res.getObject(1);
        return res;
    }
    //----------------------------------------------------------------------------------------------------------------||
    public static void main(String[] args) throws Exception
    {
//        String query = "SELECT display_name FROM wp_users WHERE user_login IN ('john_smith')";
        String query = "select phone_number from person where person_id=1";
        ResultSet rs = queryDataBaseValue(query);
        try
        {
            while (rs.next())
            {
                System.out.println(rs.getString(1));
               // System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4) + " " + rs.getString(5));

            }
        }
        catch (Exception err)
        {
            System.err.println("Error loading JDBC driver");
            err.printStackTrace(System.err);
            System.exit(0);
        }
        finally
        {
            if (rs != null) try
            {
                rs.close();
            }
            catch (Exception e)
            {
            }
            if (stmt != null)
                try
                {
                stmt.close();
            }
            catch (Exception e)
            {
            }
            if (conn != null)
                try
                {
                conn.close();
            }
            catch (Exception e)
            {
            }
        }
//        String result = (String) queryDataBaseValue(query);
//        System.out.println(result);
    }
    //----------------------------------------------------------------------------------------------------------------||
}
