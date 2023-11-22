package com.app.Entitys;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;
public class Log {

    public Log() {
        Configurator.initialize(null,"C:\\Users\\My Xen\\Documents\\NetBeansProjects\\PetShop\\src\\main\\resources\\log4j\\log4j2.properties");
    }
    
    private static final Logger Log =  LogManager.getLogger(Log.class);
    
   
    public static void info (String message) {
        Log.info(message);
    }
    public static void info (Object object) {
        Log.info(object);
    }

    
    public static void warn (String message) {
        Log.warn(message);
    }
    public static void warn (Object object) {
        Log.warn(object);
    }

    
    public static void error (String message) {
        Log.error(message);
    }
    public static void error (Object object) {
        Log.error(object);
    }

   
    public static void fatal (String message) {
        Log.fatal(message);
    }

   
    public static void debug (String message) {
        Log.debug(message);
    }
    public static void debug (Object object) {
        Log.debug(object);
    }
}
