package selenium_core.helpers.database;

public class Person
{
    private int person_id;
    private String first_name;
    private String last_name;
    private int age;
    private String phone_number;

    public void setId(int id)
    {
        this.person_id = id;
    }

    public int getId()
    {
        return person_id;
    }

    public String getLastName()
    {
        return last_name;
    }

    public void setLastName(String lastName)
    {
        this.last_name = lastName;
    }

    public void setFirstName(String firstName)
    {
        this.first_name = firstName;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public void setMobileNumber(String mobileNumber)
    {
        this.phone_number = mobileNumber;
    }

    public String getFirstName()
    {
        return first_name;
    }

    public int getAge()
    {
        return age;
    }

    public String getMobileNumber()
    {
        return phone_number;
    }
}
