package Task_2;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class BasicListener {
	public class BasicListeners extends BaseClass implements ITestListener{

		@Override
		public void onTestStart(ITestResult result) {
			Reporter.log("onTestStart",true);
		}

		@Override
		public void onTestSuccess(ITestResult result) {
			Reporter.log("onTestSuccess",true);
		}

		@Override
		public void onTestFailure(ITestResult result) {
			
			LocalDateTime t = LocalDateTime.now();
			String time = t.toString().replace(":", "-");
			
			TakesScreenshot ts = (TakesScreenshot) driver;
			File from = ts.getScreenshotAs(OutputType.FILE);
			File to = new File("./Screenshot/ss"+time+".png");
			try {
				FileHandler.copy(from, to);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		@Override
		public void onTestSkipped(ITestResult result) {
			Reporter.log("onTestSkipped",true);
		}

		@Override
		public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
			Reporter.log("onTestFailedButWithinSuccessPercentage",true);
		}

		@Override
		public void onTestFailedWithTimeout(ITestResult result) {
			Reporter.log("onTestFailedWithTimeout",true);
		}

		@Override
		public void onStart(ITestContext context) {
			// TODO Auto-generated method stub
//			ITestListener.super.onStart(context);
			Reporter.log("onStart",true);
		}

		@Override
		public void onFinish(ITestContext context) {
			Reporter.log("onFinish",true);
		}
}
}