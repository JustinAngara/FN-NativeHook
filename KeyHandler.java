package com.fortnitemaincheats;



import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import javax.swing.Timer;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;


public class KeyHandler implements NativeKeyListener{
	KeyOutputs ko;
	static Timer fire;
	static Timer crank;
	static Timer bhop;
	static Timer fastEdit;
	public KeyHandler() throws AWTException {
		ko = new KeyOutputs();
		fire = new Timer(100,(ActionEvent e)->{
			ko.quickPeek();
		});
		crank = new Timer(5,(ActionEvent e)->{
			ko.crank();
		});
		bhop = new Timer(5,(ActionEvent e)->{
//			ko.hop();
		});
		fastEdit = new Timer(55,(ActionEvent e)->{
			ko.quickEdit();
		});
	} 
	@Override
	public void nativeKeyPressed(NativeKeyEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getKeyCode() == NativeKeyEvent.VC_G) {
			ko.reset();
		}
		if(arg0.getKeyCode()==NativeKeyEvent.VC_ALT_L) {
			// t.start();
			fire.start();
		}
		if(arg0.getKeyCode()==NativeKeyEvent.VC_C) {
			crank.start();
		}
		if(arg0.getKeyCode()==NativeKeyEvent.VC_SPACE) {
//			bhop.start();
		}
		
		if(arg0.getKeyCode()==NativeKeyEvent.VC_F) {
			fastEdit.start();
		}
	}
		
	@Override
	public void nativeKeyReleased(NativeKeyEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getKeyCode()==NativeKeyEvent.VC_ALT_L) {
			fire.stop();
		}
		
		if(arg0.getKeyCode()==NativeKeyEvent.VC_C) {
			crank.stop();
		}
		
		if(arg0.getKeyCode()==NativeKeyEvent.VC_SPACE) {
			bhop.stop();
		}
		
		if(arg0.getKeyCode()==NativeKeyEvent.VC_F) {
			fastEdit.stop();
		}
	}

	@Override
	public void nativeKeyTyped(NativeKeyEvent arg0) {
		// TODO Auto-generated method stub
		
		
	}
	
	public static int[] getXY() {
		PointerInfo a = MouseInfo.getPointerInfo();
		Point b = a.getLocation();
		int x = (int) b.getX();
		int y = (int) b.getY();
		int[] arr = {x,y};
		
		return arr;
	}
	public static void main(String[] args) throws AWTException {

		GlobalScreen.addNativeKeyListener(new KeyHandler());
		LogManager.getLogManager().reset();

		// Get the logger for "org.jnativehook" and set the level to off.
		Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
		logger.setLevel(Level.OFF);
		try {
			GlobalScreen.registerNativeHook();
		}
		catch (NativeHookException ex) {}
	}

}
