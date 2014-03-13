package test;

import java.awt.AWTException;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

/**
 * Diese Klasse erweitert den java.awt.Robot, um Funktionalitaeten, wie das drücken eines Buttons.
 * Diese Klasse soll GUI-Tests mit dem java.awt.Robot vereinfachen.
 * 
 * @author Elias Frantar
 * @version 13.3.2014
 */
public class MyRobot extends Robot {
	public MyRobot() throws AWTException { super(); }
	
	/**
	 * Klickt den uebergebenen Button (Dieser muss sich auf auf dem Bildschirm befinden!)
	 * @param button der zu drückende Button
	 */
	public void clickButton(JButton button) {
		Point buttonLocation = button.getLocationOnScreen();
		
		int x = (int)buttonLocation.getX();
		int y = (int)buttonLocation.getY();
		
		click(x + button.getWidth() / 2, y + button.getHeight() / 2); // klickt die Mitte des Buttons
	}
	
	/**
	 * Klickt die uebergebenen Bildschirmstelle.
	 * @param x die x-Koordinate der zu klickenden Bildschirmstelle
	 * @param y die y-Koordinate der zu klickenden Bildschirmstelle
	 */
	protected void click(int x, int y) {
		mouseMove(x, y); // bewegt die Maus auf die Bildschirmposition (x|y), wobei sich (0|0) in der linken oberen Bildschirmecke befindet
		/* ein Mausklick besteht aus mousePress() und anschliessendes mouseRelease() */
		mousePress(MouseEvent.BUTTON1_DOWN_MASK); // BUTTON1 ist die linke Maustaste
		mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
	}
}
