package com.appium.util;

import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import au.com.bytecode.opencsv.CSVReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ExcelDriver {

    //Provide CSV file path. It Is In D: Drive.
    String CSV_PATH = "Search.csv";

    public static String csvDataRead(String fileName, int column) throws IOException{

        CSVReader reader = new CSVReader(new FileReader(fileName));
        String [] csvCell;
        //while loop will be executed till the last line In CSV.
        while ((csvCell = reader.readNext()) != null) {
            String columns = csvCell[column];
            return columns;
        }
        return null;
    }
}

