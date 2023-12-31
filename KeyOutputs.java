package com.fortnitemaincheats;



import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class KeyOutputs {
	private Robot bot;
	public KeyOutputs() throws AWTException{
		bot = new Robot();
	}
	public void click(int x, int y) throws AWTException{
	    bot.mouseMove(x, y);  
	    System.out.println(x+y);
	    
	}
	public void space() throws AWTException{
		bot.keyPress(KeyEvent.VK_SPACE);
		bot.delay(5);
		bot.keyRelease(KeyEvent.VK_SPACE);
	}
	
	// 90degrees each method call
	// 10000 pixels = 360
	// 5000 pixels == 180
	// 2500 pixels == 90
	public void turnAround() {
		int[] xy = KeyHandler.getXY();
		
		HandleMouseOutput.mouseMove(2500, 0);
		
	}
	public void reset() {
		bot.delay(15);
		bot.keyPress(KeyEvent.VK_F7);
		bot.delay(5);
		bot.keyRelease(KeyEvent.VK_F7); 
	}
	public void crouch() {
		bot.keyPress(KeyEvent.VK_CONTROL);
		bot.delay(100);
		bot.keyRelease(KeyEvent.VK_CONTROL);
	}
	public void quickPeek() {
		// uncrouch
		crouch();
		bot.delay(25);
		// shoot
		shoot();
		//crouch back again
		crouch();
	}
	public void shoot() {
		bot.keyPress(KeyEvent.VK_L);
		
		bot.keyRelease(KeyEvent.VK_L);
	}
	public void crank() {
		buildFourWall();
//	    bot.delay(d);
//		bot.keyPress(KeyEvent.VK_V);
//		bot.delay(d);
//		bot.keyRelease(KeyEvent.VK_V);
//		HandleMouseOutput.mouseMove(0, 25000);
//		bot.delay(d);
//		HandleMouseOutput.mouseMove(0, 25000);

	}
	public void buildFourWall() {
		int d = 7;
		
		bot.keyPress(KeyEvent.VK_F3);
		bot.keyRelease(KeyEvent.VK_F3);
		
	    bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
	    for(int i = 0; i<4;i++) {
	    	turnAround();
	    	bot.delay(d);
	    }
		bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
//		buildFloor(0);
	}
	
	public void buildFloor(int value) {
		// value 0 == down floor
		// value 1 == up floor
		if(value==0) {
			HandleMouseOutput.mouseMove(0, 2500);
		}
	}
	
	public void hop() {
		bot.keyPress(KeyEvent.VK_SPACE);
		bot.keyRelease(KeyEvent.VK_SPACE);
	}
	
	public void quickEdit() {
		edit();
		confirmEdit();
	}
	
	// same as mousebutton down and up
	public void confirmEdit() {
	    bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
	    bot.delay(10);
	    bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	}
	
	public void edit() {
		bot.keyPress(KeyEvent.VK_0);
		bot.keyRelease(KeyEvent.VK_0);
	}
	
	
}

