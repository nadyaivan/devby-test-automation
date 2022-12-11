package by.bsu.test.devby;

/**
 * объекты веб-страниц (Page Object) с описанием тестируемых веб-элементов и методами
 * взаимодействия (API) с ними;
 */
public class DevByPage {

    private final DriverApi driverApi;

    public DevByPage(final DriverApi driverApi) {
        this.driverApi = driverApi;
    }

    public String openMain() {
        return driverApi.findText("//a[@class='navbar__nav-item navbar__nav-item_gradient']//span");
    }

    public void login(final String email, final String password) {
        clickLoginBtn();
        driverApi.findAndSend("//input[@name='email']", email);
        driverApi.findAndSend("//input[@name='password']", password);
        clickEnterBtn();
    }

    public void partialLogin(final String email) {
        clickLoginBtn();
        driverApi.findAndSend("//input[@name='email']", email);
        clickEnterBtn();
    }

    public String openLoginPage() {
        clickLoginBtn();
        return driverApi.findText("//span[@class='button__text']");
    }

    public void emptyLogin() {
        clickLoginBtn();
        clickEnterBtn();
    }

    private void clickLoginBtn() {
        driverApi.findAndClick("//a[@href='https://id.devby.io/@/hello']");
        synchronized (this) {
            Util.wait(2);
        }
    }

    private void clickEnterBtn() {
        driverApi.findAndClick("//span[@class='button__text']");
    }

}
