package selenium_core.helpers.resource;

public class ResourceHelper
{
    // Path to project properties
    //----------------------------------------------------------------------------------------------------------------||
    public static String getRecoursePath(String path)
    {
        String basePath = System.getProperty("user.dir");
        return basePath + path;
    }
    //----------------------------------------------------------------------------------------------------------------||
}
