package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import code.JuliaSet;

public class JuliaSetTest {

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
		assertEquals(-1.69334638,x[1][0], 0.0001);
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

}
