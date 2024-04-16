package utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFaild implements IRetryAnalyzer{
	int retryCount=0;
	int maxRetry=1;
	public boolean retry(ITestResult result) {
		
		if (!result.isSuccess() && retryCount<maxRetry) {
			
			retryCount++;
			return true;
		}
		return false;
	}

}
