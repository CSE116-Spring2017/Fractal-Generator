package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import code.MandelbrotSet;

public class MandelbrotSetTest {

	/**
	 * Mandelbrot Set Translate a pixel's row to the associated x-coordinate in
	 * the fractal test for the first, second and last x coordinate
	 */
	@Test
	public void MandelbrotRowToXCoordinate() {
		MandelbrotSet m = new MandelbrotSet();
		double[][] x = m.setCoordinateX();
		;
		assertEquals(-2.15, x[0][0], 0.0001);
		assertEquals(-2.1446184, x[1][0], 0.0001);
		assertEquals(0.6, x[511][0], 0.0001);

	}

	/**
	 * Mandelbrot Set Translate a pixel's column to the associated y-coordinate
	 * in the fractal test for the first, second and last y coordinate
	 */
	@Test
	public void MandelbrotColToYCoordinate() {
		MandelbrotSet m = new MandelbrotSet();
		double[][] y = m.setCoordinateY();
		assertEquals(-1.3, y[0][0], 0.0001);
		assertEquals(-1.29491194, y[0][1], 0.0001);
		assertEquals(1.3, y[0][511], 0.0001);

	}

	/**
	 * Mandelbrot Set test for escape time for the given coordinate
	 * (0.3207031250000001, -0.07109374999999386) never exceed escape distance 2,
	 * so escape time == 255
	 */
	@Test
	public void MandelbrotNeverExceedEscDis() {
		MandelbrotSet m = new MandelbrotSet();
		assertEquals(255, m.escapeTime(2, 0.3207031250000001, -0.07109374999999386));

	}

	/**
	 * Mandelbrot Set test for escape time for the given coordinate
	 * (0.5946289062500001, 1.2949218750000122) exceeds the escape distance 2
	 * after a single loop pass, so escape time == 1
	 */
	@Test
	public void MandelbrotSingleLoop() {
		MandelbrotSet m = new MandelbrotSet();
		assertEquals(1, m.escapeTime(2, 0.5946289062500001, 1.2949218750000122));
	}

	/**
	 * Mandelbrot Set test for escape time for the given coordinate
	 * (0.46007827788650374, -0.3383561643835661) exceeds the escape distance 3
	 * after a ten loop pass, so escape time == 10
	 */
	@Test
	public void MandelbrotTenLoop() {
		MandelbrotSet m = new MandelbrotSet();
		assertEquals(10, m.escapeTime(3, 0.46007827788650374, -0.3383561643835661));
	}

	/**
	 * Mandelbrot Set The method called to calculate the fractal returns a 2-d
	 * array with 512 rows and 512 columns
	 */
	@Test
	public void MandelbrotFractalSize() {
		MandelbrotSet m = new MandelbrotSet();
		m.setEscapeDis(2);
		int[][] result = m.getEscapeTime();
		assertEquals(512, result.length);
		assertEquals(512, result[0].length);
	}

}
