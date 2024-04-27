import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ContactDetails {
    WebDriver driver;

    @BeforeAll
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://opensource-demo.orangehrmlive.com/");
    }

    @Test
    public void runTest() {
        loginToOrangeHRM();
        navigateToPIMMenu();
        clickAddButton();
        toggleLoginDetails();
        fillEmployeeDetails();
        navigateBackToPIMMenu();
        searchEmployeeByName();
        assertRecordFoundMessage();
        clickContactDetails();
        addMobileNumber();
    }

    public void loginToOrangeHRM() {
        driver.findElement(By.name("txtUsername")).sendKeys("Admin");
        driver.findElement(By.name("txtPassword")).sendKeys("admin123");
        driver.findElement(By.id("btnLogin")).click();
    }

    public void navigateToPIMMenu() {
        driver.findElement(By.id("menu_pim_viewPimModule")).click();
    }

    public void clickAddButton() {
        driver.findElement(By.id("btnAdd")).click();
    }

    public void toggleLoginDetails() {
        WebElement toggleButton = driver.findElement(By.id("chkLogin"));
        if (!toggleButton.isSelected()) {
            toggleButton.click();
        }
    }

    public void fillEmployeeDetails() {
        driver.findElement(By.id("firstName")).sendKeys("Irfanul");
        driver.findElement(By.id("lastName")).sendKeys("Haque");
        driver.findElement(By.id("employeeId")).clear();
        driver.findElement(By.id("employeeId")).sendKeys("34675");
        driver.findElement(By.id("user_name")).sendKeys("irfan123");
        driver.findElement(By.id("user_password")).sendKeys("abcd12345");
        driver.findElement(By.id("re_password")).sendKeys("abcd12345");
        driver.findElement(By.id("btnSave")).click();
    }

    public void navigateBackToPIMMenu() {
        driver.findElement(By.id("menu_pim_viewPimModule")).click();
    }

    public void searchEmployeeByName() {
        driver.findElement(By.id("empsearch_employee_name_empName")).sendKeys("Irfanul Haque");
        driver.findElement(By.id("searchBtn")).click();
    }

    public void assertRecordFoundMessage() {
        WebElement recordFoundMessage = driver.findElement(By.xpath("//span[contains(text(),'No Records Found')]"));
        assert recordFoundMessage.isDisplayed();
    }

    public void clickContactDetails() {
        driver.findElement(By.linkText("Contact Details")).click();
    }

    public void addMobileNumber() {
        driver.findElement(By.id("contact_emp_mobile")).clear();
        driver.findElement(By.id("contact_emp_mobile")).sendKeys("01877530378");
        driver.findElement(By.id("btnSave")).click();
    }
}
