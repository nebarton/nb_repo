package com.appium.util;

import io.appium.java_client.AppiumDriver;
import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;

public class LaunchAppiumProgramatically {

//Appium Launch on Mac

    public static void startAppiumonMac() throws Exception{

//node appium

//node appium.js
        Thread.sleep(3000);
        CommandLine command = new CommandLine("/usr/local/bin/node");
        command.addArgument("/Users/freedomqa/node_modules/appium/build/lib/main.js", false);
        command.addArgument("--address", false);
        command.addArgument("127.0.0.1");
        command.addArgument("--port", false);
        command.addArgument("4723");
        command.addArgument("--no-reset", false);
        DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();
        DefaultExecutor executor = new DefaultExecutor();
        executor.setExitValue(1);
        executor.execute(command, resultHandler);
    }

    public static void stopAppium() throws Exception{

        Runtime.getRuntime().exec("killall node");
    }

//killall node
static AppiumDriver driver;

    public static void startAppiumServer() throws Exception {

        stopAppium();
        stopAppium();
        startAppiumonMac();
    }


    public static void main(String[] args) throws Exception {

        stopAppium();
        Thread.sleep(5000);
        stopAppium();
        Thread.sleep(5000);
        startAppiumonMac();

    }

}
