package com.fortnitemaincheats;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import javax.swing.Timer;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.mouse.NativeMouseEvent;
import org.jnativehook.mouse.NativeMouseListener;

/*

dimension for pixel searching
1235 680 top left corner
1325 680 top right corner

1235 750 bottom left corner
1325 750 bottom right corner

*/

public class Aimbot implements NativeMouseListener {
	private static Robot bot;
	private static Timer t;
	public Aimbot() throws AWTException {
		bot = new Robot();
		t = new Timer(25,(ActionEvent e)->{
			try {
				search();
			} catch (AWTException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
	}

	/*
	 x value iterate through 1235 -> 1235 + 90
	 
	 y value iterate through 705 -> 705 + 30
	 * */
	public static void search() throws AWTException {
		System.out.println("searching");
		List <Integer> values = new ArrayList<Integer>(); // add all the white pixels, then pick the middle x value and move there
		for(int i = 1; i<=90; i+=9) {
			for(int j = 1; j<=30; j+=5) {
				
				if(grabColor(1235+i,705+j)) {
					// found
					
					HandleMouseOutput.mouseMove(i/2, 0);
					return;
					
				} 

			}
		}
	}
	
	public static boolean grabColor(int x, int y) throws AWTException {
		Color pColor = new Color(255,255,255);
		
		Color grabPixelLocation1 = bot.getPixelColor(x,y);
		if(pColor.getRGB()==grabPixelLocation1.getRGB()) {
			return true;
		}
		return false;
	}

	@Override
	public void nativeMouseClicked(NativeMouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void nativeMousePressed(NativeMouseEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getButton()==2) {
			t.start();
		}
	}

	@Override
	public void nativeMouseReleased(NativeMouseEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getButton()==2) {
			t.stop();
		}
	}

	public static void main(String[] args) throws AWTException {

		GlobalScreen.addNativeMouseListener(new Aimbot());
		LogManager.getLogManager().reset();

		// Get the logger for "org.jnativehook" and set the level to off.
		Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
		//logger.setLevel(Level.OFF);
		try {
			GlobalScreen.registerNativeHook();
		}
		catch (NativeHookException ex) {
			
	

			System.exit(1);
		}
	}
}
