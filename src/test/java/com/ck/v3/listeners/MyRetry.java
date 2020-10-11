package com.ck.v3.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * 重试类，只有失败的Test才会进行重试
 */
public class MyRetry implements IRetryAnalyzer {
    //初始重试次数0
    private int retryCount = 0;
    //最大重试次数3
    private static final int maxRetryCount = 3;

    /**
     *
     * @param result
     * @return true表示重试，false表示停止重试
     */
    @Override
    public boolean retry(ITestResult result) {
            if (retryCount < maxRetryCount) {
                retryCount++;
                return true;
            }
        return false;
    }
}
