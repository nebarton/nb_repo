package ThriveTests.WebSignUp.FrameWorkUtils;

public interface WebSignUpConfig {

    final String browser            = System.getProperty("browser", "firefox");//chrome//ie/edge/safari/firefox
    final String host               = System.getProperty("host","localhost");// "localhost" or browserstack
    final String browserVersion     = System.getProperty("browserVersion","18");//52/11/17
    final String platform           = System.getProperty("platform","Windows");
    final String os_version         = System.getProperty("os_version","10");
    final String resolution         = System.getProperty("resolution","1920x1080");

}
