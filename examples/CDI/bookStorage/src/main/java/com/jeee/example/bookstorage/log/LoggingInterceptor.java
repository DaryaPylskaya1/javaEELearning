package com.jeee.example.bookstorage.log;

import java.util.logging.Logger;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import com.jeee.example.bookstorage.api.annotations.Loggable;

@Interceptor
@Loggable
public class LoggingInterceptor {

    @Inject
    private Logger logger;

    @AroundInvoke
    public Object logMethod(InvocationContext context) throws Exception {
        logger.entering(context.getTarget().getClass().getName(), context.getMethod().getName());
        try {
            return context.proceed();
        } finally {
            logger.exiting(context.getTarget().getClass().getName(), context.getMethod().getName());
        }
    }
}
