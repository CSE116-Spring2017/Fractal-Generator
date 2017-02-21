package tests;

import static org.junit.Assert.*;

import javax.swing.plaf.synth.SynthSeparatorUI;

import org.junit.Test;

import code.BurningShip;
import code.JuliaSet;
import code.MandelbrotSet;

public class TestPhase1 {
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

				assertNotEquals(1, result[row][col]);
				assertNotEquals(0, result[row][col]);

			}
		}

	}

	

	@Test
	public void neverExceedEscapeDistance() {
		JuliaSet js = new JuliaSet();
		assertEquals(255, js.escapeTime(1.0492187499999897, -0.234375));
	}

	@Test
	public void ExceedEscapeDistance() {
		JuliaSet js = new JuliaSet();
		assertEquals(1, js.escapeTime(1.6933593749999853, 0.9765625));
	}
	@Test
	public void JuliaSetFractalSize()
	{ 
		JuliaSet js = new JuliaSet();
		
		int[][] result = js.fractals();

		assertEquals(512, result.length);
		assertEquals(512, result[0].length);
		
		
	}
	@Test
	public void MandelbrotFractalSize()
	{ 
		
		MandelbrotSet m = new MandelbrotSet();
		int[][] result = m.fractals();

		assertEquals(512, result.length);
		assertEquals(512, result[0].length);
		
		
	}
	
	@Test
	public void BurningShipFractalSize() {
		BurningShip ship = new BurningShip();

		int[][] result = ship.fractals();

		assertEquals(512, result.length);
		assertEquals(512, result[0].length);

	}
	
	@Test
	public void MultibrotFractalSize()
	{ 
		
		MandelbrotSet m = new MandelbrotSet();
		int[][] result = m.fractals();

		assertEquals(512, result.length);
		assertEquals(512, result[0].length);
		
		
	}
	

}
