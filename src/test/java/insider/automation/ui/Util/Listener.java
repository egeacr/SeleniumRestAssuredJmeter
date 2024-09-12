package insider.automation.ui.Util;



import insider.automation.ui.Pages.BasePage;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener extends BasePage implements ITestListener  {

    @Override
    public void onTestFailure(ITestResult result) {
        logger().info(result.getName() +" test failed!");
                try{
            captureScreenShot(result.getName());
        }
        catch (Exception e){
            e.getMessage();
        }
    }

    @Override
    public void onTestStart(ITestResult result) {
        logger().info("Test start:" +result.getName());
    }
}
