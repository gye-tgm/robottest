package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ye.Controller;
import ye.TRExtrem;

public class GUITestCalc {
	private final int ROBOT_DELAY = 200;
	private final int TEST_DELAY = 500;
	
	MyRobot r;
	Controller c;
	TRExtrem frame;

	@Before
	public void setUp() throws Exception {
		frame = new TRExtrem();
		c = new Controller(frame);
		
		r = new MyRobot();
		r.setAutoDelay(ROBOT_DELAY);
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(TEST_DELAY);
		
		frame = null;
		c = null;
		r = null;
	}

	@Test
	public void testAdd() {
		r.clickButton(frame.getBtnDigit1());
		r.clickButton(frame.getBtnPlus());
		r.clickButton(frame.getBtnDigit1());
		r.clickButton(frame.getBtnEqual());
		
		assertEquals("2.0", frame.getText());
	}
	
	@Test
	public void testSubtract() {
		r.clickButton(frame.getBtnDigit1());
		r.clickButton(frame.getBtnMinus());
		r.clickButton(frame.getBtnDigit1());
		r.clickButton(frame.getBtnEqual());
		
		assertEquals("0.0", frame.getText());
	}

}
