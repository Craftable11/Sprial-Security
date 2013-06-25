package com.github.sprial404.ss.core.util;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.github.sprial404.ss.lib.Reference;

import cpw.mods.fml.common.FMLLog;

public class LogHelper {

    private static Logger ssLogger = Logger.getLogger(Reference.MOD_ID);
    
    public static void init() {
        ssLogger.setParent(FMLLog.getLogger());
    }
    
    public static void log(Level logLevel, String message) {
        ssLogger.log(logLevel, message);
    }
    
    public static void severe(String message) {
        log(Level.SEVERE, message);
    }
    
    public static void debug(String message) {
        log(Level.WARNING, "[Debug] " + message);
    }
    
    public static void warning(String message) {
        log(Level.WARNING, message);
    }
    
    public static void info(String message) {
        log(Level.INFO, message);
    }
    
    public static void config(String message) {
        log(Level.CONFIG, message);
    }
    
    public static void fine(String message) {
        log(Level.FINE, message);
    }
    
    public static void finer(String message) {
        log(Level.FINER, message);
    }
    
    public static void finest(String message) {
        log(Level.FINEST, message);
    }
}
