package com.fortnitemaincheats;



import java.awt.AWTException;
import java.awt.Color;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import javax.swing.Timer;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.mouse.NativeMouseEvent;
import org.jnativehook.mouse.NativeMouseListener;
import org.jnativehook.mouse.NativeMouseWheelEvent;
import org.jnativehook.mouse.NativeMouseWheelListener;

public class JNativeHookMouse implements NativeMouseListener, NativeMouseWheelListener{
	private static Timer t;
	private static Timer aimbot; 
	private static boolean aimOn;
	private static KeyOutputs ko;
	private static KeyHandler kh;
	private static HandleMouseOutput ho;
	
	
	private static int left = 1235;
	private static int right = 1325;
	private static int top = 680;
	private static int bottom = 750;
	
	
	@Override
	public void nativeMouseClicked(NativeMouseEvent arg0) {
		// TODO Auto-generated method stub
//		System.out.println("clicked");
	}

	@Override
	public void nativeMousePressed(NativeMouseEvent arg0) {
		// TODO Auto-generated method stub
		// start
		if(arg0.getButton()==1) {
			t.start();
		}
		if(arg0.getButton()==2) {
			// aim assist on 
			System.out.println("Aim on");
			aimbot.start();
		}
	}

	@Override
	public void nativeMouseReleased(NativeMouseEvent arg0) {
		// TODO Auto-generated method stub
		//stop
		if(arg0.getButton()==1) {
			t.stop();
		}
		if(arg0.getButton()==2) {
			System.out.println("Aim off");
			aimbot.stop();
		}
		
	} 
	
	
	@Override
	public void nativeMouseWheelMoved(NativeMouseWheelEvent arg0) {
		// TODO Auto-generated method stub
		
		// we want -1
		if(arg0.getWheelRotation() == -1) {
//			ko.quickEdit();
		}
	}
	public static void run() throws AWTException {
		ko = new KeyOutputs();
		kh = new KeyHandler();
		ho = new HandleMouseOutput();
		t = new Timer(10,(ActionEvent e)->{
			HandleMouseOutput.mouseMove(0,1);
			
//			System.out.println("test");
		});
		

		aimbot = new Timer(250,(ActionEvent e)->{
//			System.out.println("AIMBOTOOTOT");
//			ArrayList<Integer>[] x = PixelSearch.run(0, 0, 0, 10);
//			int i = findIterationOfPixel(x);
//			ho.mouseMove(x[0].get(i) - (2560/2), x[1].get(i) - (1440/2));
		});
		GlobalScreen.addNativeMouseListener(new JNativeHookMouse());
		GlobalScreen.addNativeMouseWheelListener(new JNativeHookMouse());
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


	public static int findIterationOfPixel(ArrayList<Integer>[] x) {
		int index = 0;
		int max = x[1].get(0);
		
		for(int i = 0; i<x[1].size();i++) {
			if(max < x[1].get(i)) {
				index = i;
				max = x[1].get(i);
			}
		}
		
		return index;
	}
	
}
