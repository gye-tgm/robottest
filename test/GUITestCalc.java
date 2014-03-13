package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ye.Controler;
import ye.TRExtrem;

/**
 * Diese Klasse demonstriert den Einsatz des java.awt.Robots für GUI-Tests.
 * 
 * @author Elias Frantar
 * @version 13.3.2014
 */
public class GUITestCalc {
	private final int ROBOT_DELAY = 50; // die Wartezeit nach jeder Aktion in Millisekunden 
	private final int TEST_DELAY = 50; // die Wartezeit beim Reinitialisieren der zu testenden GUI
	
	private MyRobot r;
	private Controler c;
	private TRExtrem frame;

	@Before
	public void setUp() throws Exception {
		Thread.sleep(TEST_DELAY);
		
		frame = new TRExtrem();
		c = new Controler(frame);
		
		r = new MyRobot();
		r.setAutoDelay(ROBOT_DELAY); // der Robot wartet nach jeder Aktion automatisch ROBOT_DELAY Sekunden
		
		Thread.sleep(TEST_DELAY);
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(TEST_DELAY);
		
		frame.getFrmTaschenrechenrExtrem().dispose();
		frame = null;
		c = null;
		r = null;
		
		Thread.sleep(TEST_DELAY);
	}

	/**
	 * Testet die Rechnung "1 + 1" durch klicken der GUI-Buttons.
	 */
	@Test
	public void testAdd() {
		System.out.println("test: 1 + 1");
		
		r.clickButton(frame.getBtnDigit1());
		r.clickButton(frame.getBtnPlus());
		r.clickButton(frame.getBtnDigit1());
		r.clickButton(frame.getBtnEqual());
		
		assertEquals("2.0", frame.getText());
	}
	
	/**
	 * Testet die Rechnung "1 - 1" durch klicken der GUI-Buttons.
	 */
	@Test
	public void testSubtract() {
		System.out.println("test: 1 - 1");
		
		r.clickButton(frame.getBtnDigit1());
		r.clickButton(frame.getBtnMinus());
		r.clickButton(frame.getBtnDigit1());
		r.clickButton(frame.getBtnEqual());
		
		assertEquals("0.0", frame.getText());
	}
}
