package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import code.BurningShip;
import code.MandelbrotSet;

public class testphase1 {
	@Test
	public void MandelbrotSetTest1(){
		MandelbrotSet m = new MandelbrotSet();
		assertEquals(255,m.escapeTime(0.3207031250000001, -0.07109374999999386));
		assertEquals(1,m.escapeTime(0.5946289062500001, 1.2949218750000122));
	}
	@Test
	public void BurningShipTest(){ 
		BurningShip ship=new BurningShip();
		
		assertEquals(255,ship.escapeTime(-1.7443359374999874, -0.017451171875000338));
		assertEquals(true,ship.test());
	}
	
	
}
