
import com.example.RegisterPage;
import com.example.util.TestListener;
import com.example.util.WebDriverSingleton;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

@Listeners({TestListener.class})
public class RegisterPageTest {

    WebDriver driver;
    RegisterPage registerPage;


    @BeforeMethod
        public void setup(ITestContext context) {
        WebDriverManager.chromedriver().setup();
        driver = WebDriverSingleton.getDriver();
        context.setAttribute("driver", driver);
        driver.get("http://demo.automationtesting.in/Register.html");
        registerPage = new RegisterPage(driver);
        registerPage.personalDataConsent();
    }
    @AfterMethod
    public void tearDown(){
        WebDriverSingleton.closeDriver();
    }

    @Test
    public void personalDetailsTest(){
        final String FIRST_NAME = "Margot";
        final String LAST_NAME = "Margo";
        final String ADDRESS = "Address";

        registerPage.enterFirstName(FIRST_NAME);
        registerPage.enterLastName(LAST_NAME);
        registerPage.enterAddress(ADDRESS);

        assertEquals(registerPage.getFirstName(), FIRST_NAME);
        assertEquals(registerPage.getLastName(), LAST_NAME);

    }
    @Test
    public void accountDetailsTest(){
        final String EMAIL = "margot11@abv.bg";
        final String PHONE = "0878200952";

        registerPage.enterEmail(EMAIL);
        registerPage.enterPhone(PHONE);

        assertEquals(registerPage.getEmail(), EMAIL);
        assertEquals(registerPage.getPhone(), PHONE);

    }
    @Test
    public void genderTest(){
        final String GENDER = "FeMale";

        registerPage.tickGender();
        assertEquals(registerPage.getGenderFemale(), GENDER);
    }

    @Test
    public void testUserCanSelectCricketLanguageAndSkills() {
        final String HOBY_CRICKET = "Cricket";
        final String LANGUAGE = "Bulgarian";
        final String JAVA = "Java";

        registerPage.checkHobbyCricket();
        registerPage.chooseLanguage();
        registerPage.selectSkills();

        assertEquals(registerPage.getHooby(), HOBY_CRICKET);
        assertEquals(LANGUAGE, registerPage.getLanguage());
        assertEquals(registerPage.getSkill(), JAVA);

    }
    @Test
    public void selectCountryTest() {
    final String COUNTRY_VALUE = "Japan";
        registerPage.selectCountry();
        assertEquals(registerPage.getCountryValue(), COUNTRY_VALUE);

    }

    @Test
    public void dateOfBirthTest() {
        String YEAR = "1991";
        String MONTH = "January";
        String DAY = "8";
        registerPage.selectYear();
        registerPage.selectMonth();
        registerPage.selectDay();

        assertEquals(YEAR, registerPage.getYear());
        assertEquals(MONTH, registerPage.getMonth());
        assertEquals(DAY, registerPage.getDay());
    }
    @Test
    public void passwordsTest() {
        String PASSWORD = "Password123";
        String CONFIRM_PASSWORD = "Password123";

        registerPage.enterPassword(PASSWORD);
        registerPage.enterConfirmedPassword(CONFIRM_PASSWORD);

        assertEquals(PASSWORD, CONFIRM_PASSWORD);
        assertEquals(PASSWORD, registerPage.getPassword());
        assertEquals(PASSWORD, registerPage.getConfirmedPassword());
    }
 }


