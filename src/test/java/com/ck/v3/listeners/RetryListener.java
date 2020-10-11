package com.ck.v3.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;
import org.testng.internal.annotations.IAnnotationTransformer;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * 重试监听类。当@Test注解中没有设置retryAnalyzer属性时候，统一设置
 */
public class RetryListener implements IAnnotationTransformer {
    @Override
    public void transform(ITestAnnotation annotation, Class testClass,
                          Constructor testConstructor, Method testMethod) {
        IRetryAnalyzer retryAnalyzer = annotation.getRetryAnalyzer();
        if (retryAnalyzer == null){
            annotation.setRetryAnalyzer(MyRetry.class);
        }
    }
}
