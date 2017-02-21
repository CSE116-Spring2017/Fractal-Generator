package tests;

import static org.junit.Assert.*;

import javax.swing.plaf.synth.SynthSeparatorUI;
import static org.junit.Assert.assertNotEquals;


import org.junit.Test;

import code.BurningShip;
import code.MandelbrotSet;

public class testphase1 {
	@Test
	public void MandelbrotSetTest1() {
		MandelbrotSet m = new MandelbrotSet();
		assertEquals(255, m.escapeTime(0.3207031250000001, -0.07109374999999386));
		assertEquals(1, m.escapeTime(0.5946289062500001, 1.2949218750000122));
	}

	@Test
	public void BurningShipTest() {
		BurningShip ship = new BurningShip();
		assertEquals(255, ship.escapeTime(-1.7443359374999874, -0.017451171875000338));
	}
	@Test
	public void BurningShipTest2() {
		BurningShip ship = new BurningShip();

		int[][] result = ship.fractals();

		double[][] _x;
		double[][] _y;

		_x = ship.setCoordinateX();
		_y = ship.setCoordinateY();

		for (int row = 0; row < result.length; row = row + 1) {
			for (int col = 0; col < result[row].length; col = col + 1) {
				result[row][col] = ship.escapeTime(_x[row][col], _y[row][col]);

				assertNotEquals(1,result[row][col]);
				assertNotEquals(0,result[row][col]);
				
				
			}
		}

	}

	@Test
	public void test() {

		System.out.println("Lit");
		// Okay

	}

}
