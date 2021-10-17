package org.lockedme.virtualkey.application.services;

import org.lockedme.virtualkey.application.consolescreen.FileOperation;
import org.lockedme.virtualkey.application.consolescreen.ScreenInterface;
import org.lockedme.virtualkey.application.consolescreen.StartScreen;


public class ScreenService {
	
	//static Directory dir = new Directory();
	
	
	
	public static StartScreen WelcomeScreen = new StartScreen();
    public static FileOperation FileOptionsScreen = new FileOperation();
    
    

    public static ScreenInterface CurrentScreen = WelcomeScreen;

    
    public static ScreenInterface getCurrentScreen() {
        return CurrentScreen;
    }

    
    public static void setCurrentScreen(ScreenInterface currentScreen) {
        CurrentScreen = currentScreen;
    }
    
    
    
}
