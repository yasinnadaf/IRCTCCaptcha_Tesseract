package com.bridgelabz.selenium.test;

import com.bridgelabz.base.BaseClass;
import com.bridgelabz.base.pages.IrctcCaptchaLogin;
import net.sourceforge.tess4j.TesseractException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class IRCTCTest extends BaseClass {

    IrctcCaptchaLogin login;

    @BeforeTest
    public void setUp(){
        initialization();
        login = new IrctcCaptchaLogin(driver);

    }

@Test
    public void automateCaptcha() throws InterruptedException, IOException, TesseractException {
        login.irctcCaptcha();
    }

@AfterTest
    public void tearDown(){
        driver.close();
    }
}
