package selenium_core.helpers.browser_configurations.config;

public class B implements A
{

    @Override
    public void test1() {

    }

    @Override
    public void test2() {

    }

    public static void main(String[] args)
    {
        A obj = new B();
        obj.test1();
        System.out.println("G");
        obj.test2();

        C.reader = new B();
        C.reader.test1();
        C.reader.test2();
    }

}
