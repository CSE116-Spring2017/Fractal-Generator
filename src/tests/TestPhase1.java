package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import code.BurningShip;
import code.JuliaSet;
import code.MandelbrotSet;

public class TestPhase1 {

	@Test
	public void MandelbroteRowToXCoordinateFor() {
		MandelbrotSet m = new MandelbrotSet();
		double[][] x = m.setCoordinateX();
		assertEquals(-2.15, x[0][0], 0.01);
	}

	@Test
	public void MandelbroteColToYCoordinate() {
		MandelbrotSet m = new MandelbrotSet();
		double[][] y = m.setCoordinateY();
		assertEquals(-1.3, y[0][0], 0.01);

	}

	@Test
	public void MandelbroteNeverExceedEscDis() {
		MandelbrotSet m = new MandelbrotSet();
		assertEquals(255, m.escapeTime(0.3207031250000001, -0.07109374999999386));

	}

	@Test
	public void MandelbroteSingleLoop() {
		MandelbrotSet m = new MandelbrotSet();
		assertEquals(1, m.escapeTime(0.5946289062500001, 1.2949218750000122));
	}

	@Test
	public void MandelbrotFractalSize() {
		MandelbrotSet m = new MandelbrotSet();
		int[][] result = m.fractals();
		assertEquals(512, result.length);
		assertEquals(512, result[0].length);
	}

	// END OF MANDELBROT TEST//

	@Test
	public void BurningShipColToXCoordinateFor() {
		BurningShip ship = new BurningShip();
		double[][] x = ship.setCoordinateX();
		assertEquals(-1.8, x[0][0], 0.01);
	}

	@Test
	public void BurningShipColToYCoordinate() {

		BurningShip ship = new BurningShip();
		double[][] y = ship.setCoordinateY();
		assertEquals(-0.08, y[0][0], 0.01);

	}

	@Test
	public void BurningShipNeverExceedEscDis() {
		BurningShip ship = new BurningShip();
		assertEquals(255, ship.escapeTime(-1.7443359374999874, -0.017451171875000338));
	}

	@Test
	public void BurningShipEscapeTime() {
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
	public void BurningShipFractalSize() {
		BurningShip ship = new BurningShip();

		int[][] result = ship.fractals();

		assertEquals(512, result.length);
		assertEquals(512, result[0].length);

	}

	// END OF BURNING SHIP ///

	@Test
	public void JuliaSetRowToXCoordinateFor() {
		JuliaSet js = new JuliaSet();
		double[][] x = js.setCoordinateX();
		assertEquals(-1.7, x[0][0], 0.01);
	}

	@Test
	public void JuliaSetColToYCoordinate() {
		JuliaSet js = new JuliaSet();
		double[][] y = js.setCoordinateY();
		assertEquals(-1.0, y[0][0], 0.01);

	}

	@Test
	public void JuliaSetNeverExceedEscDis() {
		JuliaSet js = new JuliaSet();
		assertEquals(255, js.escapeTime(1.0492187499999897, -0.234375));
	}

	@Test
	public void JuliaSetSingleLoop() {
		JuliaSet js = new JuliaSet();
		assertEquals(1, js.escapeTime(1.6933593749999853, 0.9765625));
	}

	@Test
	public void JuliaSetFractalSize() {
		JuliaSet js = new JuliaSet();

		int[][] result = js.fractals();

		assertEquals(512, result.length);
		assertEquals(512, result[0].length);

	}

	// END OF JULIA SET//

	@Test
	public void MultibrotFractalSize() {

		MandelbrotSet m = new MandelbrotSet();
		int[][] result = m.fractals();

		assertEquals(512, result.length);
		assertEquals(512, result[0].length);

	}

}
