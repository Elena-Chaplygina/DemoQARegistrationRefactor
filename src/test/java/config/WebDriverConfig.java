package config;
import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${net}.properties"
})
public interface WebDriverConfig extends Config {

    @Key("baseUrl")
    @DefaultValue("https://demoqa.com/automation-practice-form")
    String getBaseUrl();

    @Key("browser")
    @DefaultValue("CHROME")
    String getBrowser();

    @Key("remoteUrl")
    String getRemoteUrl();

    @Key("browserVersion")
    @DefaultValue("100.0")
    String getBrowserVersion();
}