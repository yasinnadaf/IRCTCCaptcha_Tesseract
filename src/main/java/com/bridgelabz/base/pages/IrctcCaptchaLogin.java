package com.bridgelabz.base.pages;

import com.bridgelabz.base.BaseClass;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;

public class IrctcCaptchaLogin extends BaseClass {

    WebDriver driver;

    @FindBy(xpath = "//a[contains(text(),'LOGIN')]")
    WebElement loginBtn;

    @FindBy(xpath = "//body/app-root[1]/app-home[1]/div[3]/app-login[1]/p-dialog[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[2]/div[2]/form[1]/div[4]/div[1]/app-captcha[1]/div[1]/div[1]/div[2]/span[1]/img[1]")
    WebElement captchaImg;

    @FindBy(id = "captcha")
    WebElement enterCaptcha;

    public IrctcCaptchaLogin(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void irctcCaptcha() throws InterruptedException, IOException, TesseractException {
        loginBtn.click();
        Thread.sleep(1000);
        File src = captchaImg.getScreenshotAs(OutputType.FILE);
        String path = "C:\\IRCTCCaptcha\\captchascreenshot\\captcha.png";
        FileHandler.copy(src, new File(path));

        Tesseract img = new Tesseract();
        img.setDatapath("E:\\Tesseract\\tessdata");
        String str = img.doOCR(new File(path));
        System.out.println("image text: "+ str);

        enterCaptcha.sendKeys(str);
        Thread.sleep(500);

    }

}
