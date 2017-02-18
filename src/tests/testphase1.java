package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import code.MandelbrotSet;

public class testphase1 {
	@Test
	public void MandelbrotSetTest1(){
		MandelbrotSet m = new MandelbrotSet();
		assertEquals(255,m.escapeTime(0.3207031250000001, -0.07109374999999386));
		assertEquals(4,m.escapeTime(0.5946289062500001, 1.2949218750000122));
	}
}
