package by.bsu.test.devby;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class DevByPageTest {
    private DriverApi driverApi;
    private WebDriver driver;
    private DevByPage page;

    @BeforeEach
    public void beforeEach() {
        driver = new ChromeDriver();
        driverApi = new DriverApi(driver);
        page = new DevByPage(driverApi);
        driver.get("https://devby.io/");
    }

    @AfterEach
    public void afterEach() {
        driver.quit();
    }

    /**
     * открытие домашней страницы интернет-приложения
     */
    @Test
    void openMain() {
        assertEquals("Поддержать", page.openMain());
    }

    /**
     * открытие страницы с формой логина
     */
    @Test
    void openLoginPage() {
        assertEquals("Войти", page.openLoginPage());
    }

    /**
     * проверка формы логина с пустыми входными данными (отсутствием логина и пароля)
     */
    @Test
    void login1() {
        page.emptyLogin();
        assertEquals("Введите адрес электронной почты или имя пользователя.", findErrorMessage());
    }

    /**
     * проверка формы логина с некорректными данными
     */
    @Test
    void login2() {
        page.login(Util.generateEmail(), Util.generatePassword());
        assertEquals("Неверный логин или пароль.", findErrorMessage());
    }

    /**
     * заполнение формы логина корректными данными и входа на домашнюю страницу
     * интернет-приложения для зарегистрированного пользователя,
     */
    @Test
    void login3() {
        page.login("jejyfi@biz-art.biz", "somePassword");
        synchronized (this) {
            Util.wait(2);
        }
        assertNotNull(driverApi.find("//a[@class='navbar__user-name']"));
    }

    /**
     * проверка формы логина с пустыми входными данными (частичным отсутствием логина или пароля)
     */
    @Test
    void login4() {
        page.partialLogin("jejyfi@biz-art.biz");
        synchronized (this) {
            Util.wait(2);
        }
        assertEquals("Введите пароль.", findErrorMessage());
    }

    private String findErrorMessage() {
        synchronized (this) {
            Util.wait(1);
        }
        return driverApi.findText("//span[@class='message message_error']");
    }
}