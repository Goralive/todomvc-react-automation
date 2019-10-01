import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;


import java.net.MalformedURLException;

import static com.codeborne.selenide.Browsers.CHROME;

public class SelenideTestBase {
    private String browser = System.getProperty("browser", CHROME);

    public DesiredCapabilities setDesiredCapabilities(String platform, String remoteBrowser) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        if (platform.equalsIgnoreCase("WIN8_1")) {
            caps.setPlatform(Platform.WIN8_1);
            caps.setBrowserName(remoteBrowser);
        }
        return caps;
    }
    @Parameters({"platform", "remoteBrowser"})
    @BeforeClass
    public void setUp(@Optional String platform, @Optional String remoteBrowser) throws MalformedURLException {
        Configuration.browser = browser;
        switch (browser) {
            case CHROME:
                ChromeDriverManager.chromedriver().setup();
                Configuration.holdBrowserOpen = true;
                break;
            case WebDriverRunner.FIREFOX:
                FirefoxDriverManager.firefoxdriver().setup();
                break;
        }
    }
}
