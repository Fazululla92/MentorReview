package Listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    public void onTestStart(ITestResult result) {
        System.out.println("Test Started: " + result.getName());
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println("Test Passed: " + result.getName());
    }

    public void onTestFailure(ITestResult result) {
        System.out.println("Test Failed: " + result.getName());
    }
}
