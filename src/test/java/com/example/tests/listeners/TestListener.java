package com.example.tests.listeners;

import com.example.framework.utils.ScreenshotUtil;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.lang.reflect.Field;

public class TestListener implements ITestListener {
  private WebDriver extractDriver(Object instance) {
    try {
      Field f = instance.getClass().getSuperclass().getField("driver");
      return (WebDriver) f.get(instance);
    } catch (Exception e) {
      return null;
    }
  }

  @Override
  public void onTestFailure(ITestResult result) {
    WebDriver driver = extractDriver(result.getInstance());
    if (driver != null) {
      try { ScreenshotUtil.take(driver, result.getName()); } catch (Exception ignored) {}
    }
  }

  @Override
  public void onStart(ITestContext context) {}
  @Override
  public void onFinish(ITestContext context) {}
}
