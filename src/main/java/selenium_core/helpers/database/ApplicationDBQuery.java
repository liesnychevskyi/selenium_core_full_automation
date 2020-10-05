package selenium_core.helpers.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ApplicationDBQuery //Help us to get the data from automation scripts
{
    //----------------------------------------------------------------------------------------------------------------||
    public String getPhoneNumber(int personId) throws SQLException, NumberFormatException
    {
        //int number = 0;
        String number = null;
        String dbQuery = "select Mobile_Number from family where ID=" + personId;
        ResultSet result = DatabaseHelper.getInstance().getResultSet(dbQuery);
       // ResultSet result = DatabaseHelper.getResultSet(dbQuery);
        while(result.next())
        {
           // number = Integer.parseInt(result.getString("Mobile_Number")); // if data int
            number = result.getString("Mobile_Number"); // If data String
        }
        return number;
    }
    //----------------------------------------------------------------------------------------------------------------||
    public List<Person> getPerson() throws SQLException
    {
        List<Person> dataPerson = new ArrayList<Person>();
        String dbQuery = "select * from family";
        ResultSet result = DatabaseHelper.getInstance().getResultSet(dbQuery);
        while(result.next())
        {
            Person person = new Person();
            person.setId(Integer.parseInt(result.getString("ID")));
            person.setLastName(result.getString("LastName"));
            person.setFirstName(result.getString("FirstName"));
            person.setAge(Integer.parseInt(result.getString("Age")));
            person.setMobileNumber(result.getString("Mobile_Number"));

            dataPerson.add(person);
        }
        return dataPerson;
    }
    //----------------------------------------------------------------------------------------------------------------||
    public static void main(String[] args) throws SQLException
    {
        selenium_core.helpers.database.ApplicationDBQuery applicationDBQuery = new selenium_core.helpers.database.ApplicationDBQuery();
        String number = applicationDBQuery.getPhoneNumber(2);
        System.out.println("The number is: " + number) ;
    //----------------------------------------------------------------------------------------------------------------||
        List<Person> listOfData = applicationDBQuery.getPerson();
        for(Person data: listOfData)
        {
            System.out.println("Person ID is: " + data.getId() + " Last name is: " + data.getLastName()
            + " First name is: " + data.getFirstName() + " Age is: " + data.getAge() + " Phone number is: " + data.getMobileNumber());
        }
    //----------------------------------------------------------------------------------------------------------------||
    }
}
