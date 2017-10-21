package com.wechat.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log {

    public static final String LOG_TYPE_TRACE = "logTypeTrace";
    public static final String LOG_TYPE_DEBUG = "logTypeDebug";
    public static final String LOG_TYPE_INFO = "logTypeInfo";
    public static final String LOG_TYPE_WARN = "logTypeWarn";
    public static final String LOG_TYPE_ERROR = "logTypeError";
    //打印日志
    private Logger logger;

    public Log(Class clazz) {
        logger = LogManager.getLogger(clazz);
    }

    public void trace(String s) {
        logger.trace(s);
    }

    public void debug(String s) {
        logger.debug(s);
    }

    public void info(String s) {
        logger.info(s);
    }

    public void warn(String s) {
        logger.warn(s);
    }

    public void error(String s) {
        logger.error(s);
    }

    public void trace(String s, Exception e) {
        logger.trace(s, e);
    }

    public void debug(String s, Exception e) {
        logger.debug(s, e);
    }

    public void info(String s, Exception e) {
        logger.info(s, e);
    }

    public void warn(String s, Exception e) {
        logger.warn(s, e);
    }

    public void error(String s, Exception e) {
        logger.error(s, e);
    }

    public void log(String type, String s) {
        if (type.equals(Log.LOG_TYPE_TRACE)) {
            trace(s);
        } else if (type.equals(Log.LOG_TYPE_DEBUG)) {
            debug(s);
        } else if (type.equals(Log.LOG_TYPE_INFO)) {
            info(s);
        } else if (type.equals(Log.LOG_TYPE_WARN)) {
            warn(s);
        } else if (type.equals(Log.LOG_TYPE_ERROR)) {
            error(s);
        }
    }

}
