package pack1;

import org.testng.ITestContext;
import org.testng.ITestListener;

import org.testng.ITestResult;

public class listernerCustom  implements ITestListener{
	@Override
	public void onTestStart(ITestResult result) {
        System.out.println("New Test Started " + result.getName());
    }
	@Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test Successfully Finished " + result.getName());
      System.out.println(System.getProperty("scr.folder"));
       
    }
	@Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test Failed " + result.getName());
        System.out.println(System.getProperty("scr.folder"));
    }
	@Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test Skipped " + result.getName());
        System.out.println(System.getProperty("scr.folder"));
    }
	@Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("Test Failed but within success percentage" + result.getName());
        System.out.println(System.getProperty("scr.folder"));
    }
	@Override
    public void onStart(ITestContext context) {
        System.out.println("This is onStart method" + context.getOutputDirectory());
       
    }
	@Override
    public void onFinish(ITestContext context) {
        System.out.println("This is onFinish method" + context.getPassedTests());
        System.out.println("This is onFinish method" + context.getFailedTests());
        
    }
	

}
