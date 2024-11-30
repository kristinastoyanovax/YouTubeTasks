package Subscribe;

import com.example.work.task.account.page.factory.ProfilePage;
import com.example.work.task.account.page.factory.SubscribeSection;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SubscribeTest extends TestObject {
    @DataProvider(name = "basicData")
    public Object[][] basicData() {
        return new Object[][]{{"https://www.youtube.com/@EssentialClassics"}};
    }

    @Test(dataProvider = "basicData")
    public void subscribe(String accountUrl) {
        WebDriver driver = getDriver();

        // Setup
        ProfilePage profilePage = new ProfilePage(driver, accountUrl);
        SubscribeSection subscribeSection = new SubscribeSection(driver);

        // Act
        profilePage.navigateTo();
        subscribeSection.subscribe();

        // Assert
        Assert.assertTrue(profilePage.isUrlLoaded());
        Assert.assertTrue(subscribeSection.isSubscribed());
        // Would like to add a network request check if the response is 200
        // listen for: [POST] https://www.youtube.com/youtubei/v1/subscription/subscribe?prettyPrint=false
        // Response code should be 200 OK

    }
}
