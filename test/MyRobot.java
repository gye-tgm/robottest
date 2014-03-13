package test;

import java.awt.AWTException;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

public class MyRobot extends Robot {
	public MyRobot() throws AWTException {
	}
	
	public void clickButton(JButton button) {
		Point buttonLocation = button.getLocationOnScreen();
		
		int x = (int)buttonLocation.getX();
		int y = (int)buttonLocation.getY();
		
		click(x + button.getWidth() / 2, y + button.getHeight() / 2);
	}
	
	public void click(int x, int y) {
		mouseMove(x, y);
		mousePress(MouseEvent.BUTTON1_DOWN_MASK);
		mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
	}
}
