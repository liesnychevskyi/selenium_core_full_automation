package selenium_core.helpers.database;

public class Person
{
    private int id;
    private String lastName;
    private String firstName;
    private int age;
    private String mobileNumber;

    public void setId(int id)
    {
        this.id = id;
    }

    public int getId()
    {
        return id;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public void setMobileNumber(String mobileNumber)
    {
        this.mobileNumber = mobileNumber;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public int getAge()
    {
        return age;
    }

    public String getMobileNumber()
    {
        return mobileNumber;
    }
}
