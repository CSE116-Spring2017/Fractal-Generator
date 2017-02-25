package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import code.BurningShip;
import code.JuliaSet;
import code.MandelbrotSet;
import code.MultibrotSet;

public class TestPhase1 {
	/**
	 * Mandelbrot Set 
	 * Translate a pixel's row to the associated x-coordinate in the fractal
	 * test for the first, second and last x coordinate
	 */
	@Test
	public void MandelbrotRowToXCoordinate() {
		MandelbrotSet m = new MandelbrotSet();
		double[][] x = m.setCoordinateX();;
		assertEquals(-2.15, x[0][0], 0.0001);
		assertEquals(-2.1446184,x[1][0],0.0001);
		assertEquals(0.6, x[511][0],0.0001); 
		
	}
	/**
	 * Mandelbrot Set 
	 * Translate a pixel's column to the associated y-coordinate in the fractal
	 * test for the first, second and last y coordinate
	 */
	@Test
	public void MandelbrotColToYCoordinate() {
		MandelbrotSet m = new MandelbrotSet();
		double[][] y = m.setCoordinateY();
		assertEquals(-1.3, y[0][0], 0.0001);
		assertEquals(-1.29491194,y[0][1], 0.0001);
		assertEquals(1.3,y[0][511],0.0001);

	}
	/**
	 * Mandelbrot Set 
	 * test for escape time for the given coordinate (0.3207031250000001, -0.07109374999999386)
	 * never exceed escape distance, so escape time == 255
	 */
	@Test
	public void MandelbrotNeverExceedEscDis() {
		MandelbrotSet m = new MandelbrotSet();
		assertEquals(255, m.escapeTime(0.3207031250000001, -0.07109374999999386));

	}
	/**
	 * Mandelbrot Set 
	 * test for escape time for the given coordinate (0.5946289062500001, 1.2949218750000122)
	 * exceeds the escape distance after a single loop pass, so escape time == 1
	 */

	@Test
	public void MandelbrotSingleLoop() {
		MandelbrotSet m = new MandelbrotSet();
		assertEquals(1, m.escapeTime(0.5946289062500001, 1.2949218750000122));
	}
	
	/**
	 * Mandelbrot Set 
	 * The method called to calculate the fractal returns a 2-d array with 512 rows and 512 columns
	 */
	@Test
	public void MandelbrotFractalSize() {
		MandelbrotSet m = new MandelbrotSet();
		int[][] result = m.fractals();
		assertEquals(512, result.length);
		assertEquals(512, result[0].length);
	}

	// END OF MANDELBROT TEST//
	
	/**
	 * Burning Ship Set 
	 * Translate a pixel's row to the associated x-coordinate in the fractal
	 * test for the first, second and last x coordinate
	 */
	@Test
	public void BurningShipRowToXCoordinate() {
		BurningShip ship = new BurningShip();
		double[][] x = ship.setCoordinateX();
		assertEquals(-1.8, x[0][0], 0.0001);
		assertEquals(-1.79980431,x[1][0],0.0001);
		assertEquals(-1.7, x[511][0],0.0001);
	}
	
	/**
	 * Burning Ship Set 
	 * Translate a pixel's column to the associated y-coordinate in the fractal
	 * test for the first, second and last y coordinate
	 */
	@Test
	public void BurningShipColToYCoordinate() {
		BurningShip ship = new BurningShip();
		double[][] y = ship.setCoordinateY();
		assertEquals(-0.08, y[0][0], 0.0001);
		assertEquals(-0.07979452,y[0][1],0.0001);
		assertEquals(0.025, y[0][511],0.0001);
	}
	
	/**
	 * Burning Ship Set 
	 * test for escape time for the given coordinate (-1.7443359374999874, -0.017451171875000338)
	 * never exceed escape distance, so escape time == 255
	 */

	@Test
	public void BurningShipNeverExceedEscDis() {
		BurningShip ship = new BurningShip();
		assertEquals(255, ship.escapeTime(-1.7443359374999874, -0.017451171875000338));
	}
	
	/**
	 * Burning Ship Set 
	 * test none of the pixels in the Burning Ship set have an escape time of 0 or 1
	 */
	@Test
	public void BurningShipEscapeTime() {
		BurningShip ship = new BurningShip();
		int[][] result = ship.fractals();
		for (int row = 0; row < result.length; row = row + 1) {
			for (int col = 0; col < result[row].length; col = col + 1) {
				assertNotEquals(1, result[row][col]);
				assertNotEquals(0, result[row][col]);
			}
		}
	}
	
	/**
	 * Burning Ship Set 
	 * The method called to calculate the fractal returns a 2-d array with 512 rows and 512 columns
	 */
	@Test
	public void BurningShipFractalSize() {
		BurningShip ship = new BurningShip();

		int[][] result = ship.fractals();

		assertEquals(512, result.length);
		assertEquals(512, result[0].length);

	}

	// END OF BURNING SHIP ///

	/**
	 * Julia Set
	 * Translate a pixel's row to the associated x-coordinate in the fractal
	 * test for the first, second and last x coordinate
	 */
	@Test
	public void JuliaSetRowToXCoordinate() {
		JuliaSet js = new JuliaSet();
		double[][] x = js.setCoordinateX();
		assertEquals(-1.7, x[0][0], 0.0001);
		assertEquals(-1.69334638,x[0][0], 0.0001);
		assertEquals(1.7,x[511][0],0.0001);
	}
	
	/**
	 * Julia Set
	 * Translate a pixel's column to the associated y-coordinate in the fractal
	 * test for the first, second and last y coordinate
	 */

	@Test
	public void JuliaSetColToYCoordinate() {
		JuliaSet js = new JuliaSet();
		double[][] y = js.setCoordinateY();
		assertEquals(-1.0, y[0][0], 0.0001);
		assertEquals(-0.99608611,y[0][1],0.0001);
		assertEquals(1.0, y[0][511], 0.0001);

	}
	/**
	 * Julia Set
	 * test for escape time for the given coordinate (1.0492187499999897, -0.234375)
	 * never exceed escape distance, so escape time == 255
	 */

	@Test
	public void JuliaSetNeverExceedEscDis() {
		JuliaSet js = new JuliaSet();
		assertEquals(255, js.escapeTime(1.0492187499999897, -0.234375));
	}
	
	/**
	 * Julia Set
	 test for escape time for the given coordinate (1.6933593749999853, 0.9765625)
	 * exceeds the escape distance after a single loop pass, so escape time == 1
	 */
	@Test
	public void JuliaSetSingleLoop() {
		JuliaSet js = new JuliaSet();
		assertEquals(1, js.escapeTime(1.6933593749999853, 0.9765625));
	}

	/**
	 * Julia Set 
	 * The method called to calculate the fractal returns a 2-d array with 512 rows and 512 columns
	 */
	@Test
	public void JuliaSetFractalSize() {
		JuliaSet js = new JuliaSet();
		int[][] result = js.fractals();
		assertEquals(512, result.length);
		assertEquals(512, result[0].length);
	}

	// END OF JULIA SET//
	
	/**
	 * Multibrot Set
	 * Translate a pixel's row to the associated x-coordinate in the fractal
	 * test for the first, second and last x coordinate
	 */	
	@Test
	public void MultibrotSetRowToXCoordinate() {
		MultibrotSet mb = new MultibrotSet();
		double[][] x = mb.setCoordinateX();
		assertEquals(-1.0, x[0][0], 0.0001);
		assertEquals(-0.99608611, x[1][0],0.0001);
		assertEquals(1.0, x[511][0], 0.0001);
	}
	
	/**
	 * Multibrot Set
	 * Translate a pixel's row to the associated y-coordinate in the fractal
	 * test for the first, second and last y coordinate
	 */
	@Test
	public void MultibrotSetColToYCoordinate() {
		MultibrotSet mb = new MultibrotSet();
		double[][] y = mb.setCoordinateY();
		assertEquals(-1.3, y[0][0], 0.0001);
		assertEquals(-1.29491194,y[0][1],0.0001);
		assertEquals(1.3, y[0][511], 0.0001);
	}
	
	/**
	 * Multibrot Set 
	 * test for escape time for the given coordinate (0.5859375, 0.24375000000000108)
	 * never exceed escape distance, so escape time == 255
	 */
	@Test
	public void MultibrotNeverExceedEscDis() {
		MultibrotSet mb = new MultibrotSet();
		assertEquals(255, mb.escapeTime(0.5859375, 0.24375000000000108));
	}
	
	/**
	 * Multibrot Set 
	 * test for escape time for the given coordinate (0.9921875, 1.05625)
	 * exceeds the escape distance after a single loop pass, so escape time == 1
	 */
	@Test
	public void MultibrotSetSingleLoop() {
		MultibrotSet mb = new MultibrotSet();
		assertEquals(1, mb.escapeTime(0.9921875, 1.05625));
	}
	
	/**
	 * Multibrot Set 
	 * The method called to calculate the fractal returns a 2-d array with 512 rows and 512 columns
	 */
	@Test
	public void MultibrotFractalSize() {
		MultibrotSet mb = new MultibrotSet();
		int[][] result = mb.fractals();
		assertEquals(512, result.length);
		assertEquals(512, result[0].length);

	}

	
// END OF MULTIBROT //
	
}
