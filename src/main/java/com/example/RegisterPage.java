package com.example;


import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage extends AbstractPage{

   private final WebDriver driver;
   public RegisterPage(WebDriver driver){
       super(driver);
       this.driver = driver;
       PageFactory.initElements(driver,this);

   }
    @FindBy(how = How.XPATH, using = "//button[@aria-label='Consent']")
    WebElement consent;

    @FindBy(how = How.XPATH, using = "//input[@placeholder='First Name']")
    WebElement firstNameContainer;
    @FindBy(how = How.CSS, using = "input[ng-model='LastName'")
    WebElement lastNameContainer;
    @FindBy(how = How.CSS, using = "textarea.form-control.ng-pristine.ng-untouched.ng-valid[ng-model=\"Adress\"]")
    WebElement addressContainer;

    @FindBy(how = How.XPATH, using = "//input[@ng-model='EmailAdress']")
    WebElement emailContainer;
    @FindBy(how = How.CSS, using = "input[ng-model='Phone']")
    WebElement phoneContainer;

    @FindBy(how = How.XPATH, using = "//input[@value='FeMale']")
    WebElement genderFemail;

    @FindBy(how = How.XPATH, using = "//input[@id='checkbox1']")
    WebElement cricketBox;
    @FindBy(how = How.XPATH, using = "//label[contains(text(), 'Cricket')]")
    WebElement cricketOption;
    @FindBy(how = How.XPATH, using = "//div[@id='msdd']")
    WebElement languageBox;

    @FindBy(how = How.XPATH, using = "//a[@class='ui-corner-all' and text()='Bulgarian']")
    WebElement languageBulgarian;
    @FindBy(how = How.XPATH, using = "//div[@class='ui-autocomplete-multiselect-item']")
    WebElement languageSelectedBulgarian;
    @FindBy(how = How.XPATH, using = "//select[@id='Skills']")
    WebElement selectSkillsBox;
    @FindBy(how = How.XPATH, using = "//option[@value='Java']")
    WebElement optionJava;

    @FindBy(how = How.XPATH,using = "//span[@aria-labelledby='select2-country-container']")
    WebElement countryContainer;
    @FindBy(how = How.XPATH,using = "//span[@aria-labelledby='select2-country-container']/span")
    WebElement countryValue;


    @FindBy(how = How.XPATH,using = "//li[text()='Japan']")
    WebElement countryOptionJapan;

    @FindBy(how = How.XPATH, using = "//select[@id='yearbox']")
    WebElement yearBox;
    @FindBy(how = How.XPATH, using = "//select[@ng-model='monthbox']")
    WebElement monthBox;
    @FindBy(how = How.ID, using = "daybox")
    WebElement dayBox;
    @FindBy(how = How.XPATH, using = "//option[text()='1991']")
    WebElement yearOption;
    @FindBy(how = How.XPATH, using = "//option[text()='January']")
    WebElement monthOption;
    @FindBy(how = How.XPATH, using = "//option[text()='8']")
    WebElement dayOption;

    @FindBy(how = How.ID, using = "firstpassword")
    WebElement passwordBox;
    @FindBy(how = How.ID, using = "secondpassword")
    WebElement confirmPasswordBox;

    @FindBy(how = How.XPATH, using = "//body")
    WebElement bodyElement;


    public void personalDataConsent(){
        waitForElementToBeVisible(consent);
        consent.click();
    }
    public void enterFirstName(String firstName){
        waitForElementToBeVisible(firstNameContainer);
        firstNameContainer.sendKeys(firstName);
    }
    public void enterLastName(String lastName){
        waitForElementToBeVisible(lastNameContainer);
        lastNameContainer.sendKeys(lastName);
    }

    public void enterAddress(String address) {
        waitForElementToBeVisible(addressContainer);
        addressContainer.sendKeys(address);
        bodyElement.click();
    }

    public void enterEmail(String email){
        waitForElementToBeVisible(emailContainer);
        emailContainer.click();
        emailContainer.sendKeys(email);
    }
    public void enterPhone(String phone) {
        waitForElementToBeVisible(phoneContainer);
        phoneContainer.sendKeys(phone);
    }

    public void tickGender() {
        waitForElementToBeVisible(genderFemail);
        genderFemail.click();
    }
    public void checkHobbyCricket() {
        waitForElementToBeVisible(cricketBox);
        cricketBox.click();
    }
    public void chooseLanguage() {
        waitForElementToBeVisible(languageBox);
        languageBox.click();
        waitForElementToBeVisible(languageBulgarian);
        languageBulgarian.click();

        bodyElement.click();
    }
    public void selectSkills() {
        waitForElementToBeClickable(selectSkillsBox);
        Select select = new Select(selectSkillsBox);
        select.selectByVisibleText("Java");
    }

    public void selectCountry(){
        waitForElementToBeVisible(countryContainer);
        countryContainer.click();
        WebElement countryOptionScrolled = scrollMenu(countryContainer,countryOptionJapan);
        countryOptionScrolled.click();
        bodyElement.click();
    }

    public void selectYear() {
        wait.until(ExpectedConditions.elementToBeClickable(yearBox));
        Select select = new Select(yearBox);
        select.selectByVisibleText("1991");
    }
    public void selectMonth(){
        waitForElementToBeVisible(monthBox);
        Select select = new Select(monthBox);
        select.selectByVisibleText("January");
    }
    public void selectDay() {
        waitForElementToBeVisible(dayBox);
        Select select = new Select(dayBox);
        select.selectByValue("8");
    }
    public void enterPassword(String password){
        waitForElementToBeVisible(passwordBox);
        passwordBox.sendKeys(password);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].type = 'text';", passwordBox);
        bodyElement.click();
    }
   public void enterConfirmedPassword(String secondPassword){
        waitForElementToBeVisible(confirmPasswordBox);
        confirmPasswordBox.sendKeys(secondPassword);
        bodyElement.click();
    }


    public String getFirstName() {
        return firstNameContainer.getAttribute("value");
    }
    public String getLastName() {
        return lastNameContainer.getAttribute("value");
    }

    public String getEmail() {
        return emailContainer.getAttribute("value");
    }
    public String getPhone() {
        return phoneContainer.getAttribute("value");
    }
    public String getGenderFemale() {
        return genderFemail.getAttribute("value");
    }

    public String getHooby() {
        return cricketOption.getText();
    }

    public String getLanguage() {
        return languageSelectedBulgarian.getText();
    }

    public String getSkill() {
        return optionJava.getText();
    }
    public String getCountryValue() {
        return countryValue.getText();
    }

    public String selectValeuOfElement(WebElement element, String textValue) {
        Select select = new Select(element);
        select.selectByVisibleText(textValue);

        return select.getFirstSelectedOption().getText();
    }
    public String getYear() {
        return selectValeuOfElement(yearBox, yearOption.getText());
    }
    public String getMonth() {
        return selectValeuOfElement(monthBox, monthOption.getText());
    }
    public String getDay() {
        return selectValeuOfElement(dayBox, dayOption.getText());
    }

    public String getPassword() {
        return passwordBox.getAttribute("value");
    }

    public String getConfirmedPassword() {
        return confirmPasswordBox.getAttribute("value");
    }
}
