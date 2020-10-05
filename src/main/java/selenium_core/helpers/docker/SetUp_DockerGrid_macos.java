package selenium_core.helpers.docker;

import java.io.IOException;

public class SetUp_DockerGrid_macos
{
    //@BeforeTest
    //@Test(priority = 1)
    public void startDockerGrid() throws IOException, InterruptedException
    {
        Runtime.getRuntime().exec("open /Users/Stan/IdeaProjects/docker_grid_framework_full_automation/dockergrid__start");
        Thread.sleep(25000);
    }

   // @AfterTest
    //@Test(priority = 2)
    public void  stopDockerGrid() throws IOException, InterruptedException
    {
        Runtime.getRuntime().exec("open /Users/Stan/IdeaProjects/docker_grid_framework_full_automation/dockergrid__stop");
        Thread.sleep(20000);
        Runtime.getRuntime().exec("killall Terminal"); // close all command prompts
    }
}
