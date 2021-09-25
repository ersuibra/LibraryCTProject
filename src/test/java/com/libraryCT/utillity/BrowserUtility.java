package com.libraryCT.utillity;

public class BrowserUtility {
    public static void waitFor(int seconds) {
        try {
            Thread.sleep(seconds*1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
