package seleniumWorkshops;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Instant;


public class workshop1 {
    public static void main(String[] args) throws InterruptedException
    {
        // Bir kullanıcı olarak ben adım adım nasıl yapıyorum?
        // GÖRÜNTÜ => HTML

        WebDriver webDriver = new ChromeDriver();
        webDriver.navigate().to("https://www.saucedemo.com/v1/");
        String title = webDriver.getTitle();
        System.out.println(title);

        // Locator => Html'deki bir elemente ulaşmak için gerekli rota.

        // //*[@id="login_button_container"]/div/form
        // /html/body/div[2]/div[1]/div/div/form

        ///// HATALI LOGİN GİRİŞİ /////
        WebElement usernameInputFalse = webDriver.findElement(By.id("user-name"));
        usernameInputFalse.sendKeys("standart_cavit");
        Thread.sleep(1000);


        WebElement passwordInputFalse = webDriver.findElement(By.id("password"));
        passwordInputFalse.sendKeys("secret_cavit");
        Thread.sleep(1000);

        WebElement loginBtnFalse = webDriver.findElement(By.id("login-button"));
        loginBtnFalse.click();
        Thread.sleep(2000);


        ///// BAŞARILI LOGİN KONTROLU /////
        // Form username temizle
        usernameInputFalse.clear();
        WebElement usernameInputTrue = webDriver.findElement(By.id("user-name"));
        usernameInputTrue.sendKeys("standard_user");
        Thread.sleep(1000);

        // Form password temizle
        passwordInputFalse.clear();
        WebElement passwordInputTrue = webDriver.findElement(By.id("password"));
        passwordInputTrue.sendKeys("secret_sauce");
        Thread.sleep(1000);

        WebElement loginBtnTrue = webDriver.findElement(By.id("login-button"));
        loginBtnTrue.click();
        Thread.sleep(2000);



        ///// SIRALAMA /////
        // Sıralama dropdown'ını bulma
        WebElement sortingDropdown = webDriver.findElement(By.className("product_sort_container"));
        Select sortingSelect = new Select(sortingDropdown);

        // Name: A to Z
        sortingSelect.selectByValue("az");
        Thread.sleep(2000); // Sonuçları gözlemlemek için bekleyin

        // Name: Z to A
        sortingSelect.selectByValue("za");
        Thread.sleep(2000); // Sonuçları gözlemlemek için bekleyin

        // Price: Low to High
        sortingSelect.selectByValue("lohi");
        Thread.sleep(2000); // Sonuçları gözlemlemek için bekleyin

        // Price: High to Low
        sortingSelect.selectByValue("hilo");
        Thread.sleep(2000); // Sonuçları gözlemlemek için bekleyin



        ///// ÜRÜNLERİ SEPETE EKLEME /////
        // İlk ürünü sepete ekle
        WebElement firstAddToCartButton = webDriver.findElement(By.xpath("(//button[text()='ADD TO CART'])[1]"));
        firstAddToCartButton.click();
        Thread.sleep(1000); // Ürün eklendikten sonra bekleyin

        // İkinci ürünü sepete ekle
        WebElement secondAddToCartButton = webDriver.findElement(By.xpath("(//button[text()='ADD TO CART'])[2]"));
        secondAddToCartButton.click();
        Thread.sleep(1000); // Ürün eklendikten sonra bekleyin

        // Üçüncü ürünü sepete ekle
        WebElement thirdAddToCartButton = webDriver.findElement(By.xpath("(//button[text()='ADD TO CART'])[3]"));
        thirdAddToCartButton.click();
        Thread.sleep(1000); // Ürün eklendikten sonra bekleyin



        ///// ÜRÜNÜ ANASAYDAFA SEPETTEN ÇIKARMA /////
        // Üçüncü ürünü sepetten çıkarmak
        WebElement thirdRemoveFromCartButton = webDriver.findElement(By.xpath("(//button[text()='REMOVE'])[2]"));
        thirdRemoveFromCartButton.click();
        Thread.sleep(1000); // Ürün çıkarıldıktan sonra bekleyin



        ///// SEPET SAYFASI AÇMA /////
        WebElement cartButton = webDriver.findElement(By.className("shopping_cart_container"));
        cartButton.click();
        Thread.sleep(2000); // Sepet sayfası yüklensin diye bekleyin



        ///// SEPET SAYFASINDA ÜRÜN ÇIKARMA /////
        WebElement removeButton = webDriver.findElement(By.className("btn_secondary"));
        removeButton.click();
        Thread.sleep(2000); // Anasayfa yüklenirken bekleyin



        ///// SEPETTEYKEN CONTİNUE SHOPPİNG İLE GERİ GİTME /////
        // "Continue Shopping" butonuna tıklamak için doğru XPath kullanarak elementi bulma
        WebElement continueShoppingButton = webDriver.findElement(By.xpath("//a[@class='btn_secondary'][@href='./inventory.html']"));
        continueShoppingButton.click();
        Thread.sleep(2000); // Anasayfa yüklenirken bekleyin

        // Anasayfadan dördüncü ürünü sepete ekle
        WebElement fourthAddToCartButton = webDriver.findElement(By.xpath("(//button[text()='ADD TO CART'])[4]"));
        fourthAddToCartButton.click();
        Thread.sleep(1000); // Ürün eklendikten sonra bekleyin

        // Tekrar sepet sayfasına git
        WebElement cartButtonAgain = webDriver.findElement(By.className("shopping_cart_container"));
        cartButtonAgain.click();
        Thread.sleep(2000); // Sepet sayfası yüklensin diye bekleyin

        ///// SEPETTE CHECK OUT YAPMA /////
        // "Checkout" butonuna tıklamak için elementi bulma
        WebElement checkoutButton = webDriver.findElement(By.xpath("//a[@class='btn_action checkout_button'][@href='./checkout-step-one.html']"));
        checkoutButton.click();
        Thread.sleep(2000); // Checkout adımına geçiş yapılırken bekleyin



        ///// KİŞİSEL BİLGİ ALANINDA CANCEL YAPMA /////
        // "CANCEL" butonuna tıklama
        WebElement cancelButton = webDriver.findElement(By.cssSelector(".cart_cancel_link.btn_secondary"));
        cancelButton.click();
        Thread.sleep(1000); // Butona tıkladıktan sonra beklemek için

        // "Checkout" butonuna tıklamak için elementi bulma
        WebElement checkoutButtonCancel = webDriver.findElement(By.xpath("//a[@class='btn_action checkout_button'][@href='./checkout-step-one.html']"));
        checkoutButtonCancel.click();
        Thread.sleep(2000); // Checkout adımına geçiş yapılırken bekleyin



        ///// KİŞİSEL BİLGİLERİ GİRME /////
        // İsim alanını bulma ve bilgi girme
        WebElement firstNameInput = webDriver.findElement(By.id("first-name"));
        firstNameInput.clear();  // Eğer önceden değer varsa temizle
        firstNameInput.sendKeys("Ahmet");

        // Soy isim alanını bulma ve bilgi girme
        WebElement lastNameInput = webDriver.findElement(By.id("last-name"));
        lastNameInput.clear();  // Eğer önceden değer varsa temizle
        lastNameInput.sendKeys("Yılmaz");

        // Posta kodu alanını bulma ve bilgi girme
        WebElement postalCodeInput = webDriver.findElement(By.id("postal-code"));
        postalCodeInput.clear();  // Eğer önceden değer varsa temizle
        postalCodeInput.sendKeys("34000");

        Thread.sleep(1000); // Bilgi girildikten sonra beklemek için



        ///// KİŞİSEL BİLGİLERİ GİRDİKTEN SONRA CONTİNUE YAPMAK /////
        // "CONTINUE" butonuna tıklama
        WebElement continueButton = webDriver.findElement(By.cssSelector(".btn_primary.cart_button"));
        continueButton.click();
        Thread.sleep(1000); // Butona tıkladıktan sonra beklemek için



        ///// SON SEPET EKRANINDA CANCEL /////
        // "CANCEL" butonuna tıklamak için elementi bulma ve tıklama
        WebElement cancelButtonFinish = webDriver.findElement(By.cssSelector("a.cart_cancel_link.btn_secondary"));
        cancelButtonFinish.click();
        Thread.sleep(1000); // İşlem sırasında beklemek için

        ///// SON SEPET EKRANINDA FİNİSH /////
        // "FINISH" butonuna tıklamak için elementi bulma ve tıklama
        WebElement finishButton = webDriver.findElement(By.cssSelector("a.btn_action.cart_button"));
        finishButton.click();
        Thread.sleep(2000); // İşlem sırasında beklemek için











        // Test sonrası tarayıcıyı kapat
        //webDriver.quit();
    }
}
//  10 adet Selenium fonksiyonu
//  click fonksiyonu ..... ..... ....
//  loginBtn.click();

//