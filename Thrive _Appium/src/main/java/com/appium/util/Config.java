package com.appium.util;

import java.io.File;

public interface Config {
    File f=new File("src");
    File fs = new File(f, "app-dev-debug.apk");

    String platformName       = System.getProperty("platformName", "Android");
    String platformVersion    = System.getProperty("platformVersion", "8.1.0");//5.1  or 6.0
    String deviceName         = System.getProperty("deviceName","Android Emulator");//K7  or Android Emulator
    String app                = System.getProperty("app",fs.getAbsolutePath());

    }


