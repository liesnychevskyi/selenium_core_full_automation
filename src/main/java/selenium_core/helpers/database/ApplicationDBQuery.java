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
        String dbQuery = "select phone_number from person where person_id=" + personId;
        ResultSet result = DatabaseHelper.getInstance().getResultSet(dbQuery);
        // ResultSet result = DatabaseHelper.getResultSet(dbQuery);
        while(result.next())
        {
           // number = Integer.parseInt(result.getString("Mobile_Number")); // if data int
            number = result.getString("phone_number"); // If data String
        }
        return number;
    }
    //----------------------------------------------------------------------------------------------------------------||
    public List<Person> getPerson() throws SQLException
    {
        List<Person> dataPerson = new ArrayList<Person>();
        String dbQuery = "select * from person";
        ResultSet result = DatabaseHelper.getInstance().getResultSet(dbQuery);
        while(result.next())
        {
            Person person = new Person();
            person.setId(Integer.parseInt(result.getString("person_id")));
            person.setLastName(result.getString("last_name"));
            person.setFirstName(result.getString("first_name"));
            person.setAge(Integer.parseInt(result.getString("age")));
            person.setMobileNumber(result.getString("phone_number"));

            dataPerson.add(person);
        }
        return dataPerson;
    }
    //----------------------------------------------------------------------------------------------------------------||
    public static void main(String[] args) throws SQLException
    {
        ApplicationDBQuery applicationDBQuery = new ApplicationDBQuery();
        String number = applicationDBQuery.getPhoneNumber(2);
        System.out.println("The number is: " + number) ;

        List<Person> listOfData = applicationDBQuery.getPerson();
        for(Person data: listOfData)
        {
            System.out.println("Person ID is: " + data.getId() + "| Last name is: " + data.getLastName()
            + "|  First name is: " + data.getFirstName() + "| Age is: " + data.getAge() + "| Phone number is: " + data.getMobileNumber());
        }
    //----------------------------------------------------------------------------------------------------------------||
    }
}
