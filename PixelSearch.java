package com.fortnitemaincheats;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class PixelSearch {
    private static ArrayList[] processPixelsWithTolerance(BufferedImage screen, int targetR, int targetG, int targetB, int tolerance) {
        int minR = targetR - tolerance;
        int maxR = targetR + tolerance;
        int minG = targetG - tolerance;
        int maxG = targetG + tolerance;
        int minB = targetB - tolerance;
        int maxB = targetB + tolerance;
        
        
        // pd = pixel difference
        int pD = 25;
        int startX = (screen.getWidth()/2)-pD;
        int endX = (screen.getWidth()/2)+pD;
        
        int startY = (screen.getHeight()/2)-20;
        int endY = (screen.getHeight()/2)+20;
        
        ArrayList<Integer> xArr = new ArrayList<Integer>();
        ArrayList<Integer> yArr = new ArrayList<Integer>();
        
        for (int y = startY; y < endY; y+=3) {
            for (int x = startX; x < endX; x+=3) {
                int pixelRGB = screen.getRGB(x, y);
                int r = (pixelRGB >> 16) & 0xFF;
                int g = (pixelRGB >> 8) & 0xFF;
                int b = pixelRGB & 0xFF;

                if (r >= minR && r <= maxR && g >= minG && g <= maxG && b >= minB && b <= maxB) {
                    // Match found within tolerance! Process the pixel at (x, y)
                    xArr.add(x);
                    yArr.add(y);
                }
            }
        }
        ArrayList<Integer>[] a = new ArrayList[2];
        a[0] = xArr;
        a[1] = yArr;
//        System.out.println(a[0]);
		return a;
    }


    // Method to capture the screen
    public static BufferedImage createScreenCapture() {
        try {
            Robot robot = new Robot();
            Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
            return robot.createScreenCapture(screenRect);
        } catch (AWTException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static ArrayList[] run(int r, int g, int b, int t) {
        // Capture the screen
        BufferedImage screenCapture = createScreenCapture();

        // Save the screenshot to a file
        try {
            ImageIO.write(screenCapture, "png", new File("C:\\Users\\justi\\eclipse-workspace\\JustinProgram\\image\\screenshot.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // Perform pixel searching using the BufferedImage
        return processPixelsWithTolerance(screenCapture, r, g, b, t); // Specify target color and tolerance
    }
    
    public static void main(String[] args) {
    	run(0,0,0,10);
    }



}
