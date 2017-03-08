package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import code.BurningShip;

public class BurningShipTest {

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
		assertEquals(255, ship.escapeTime(2,-1.7443359374999874, -0.017451171875000338));
	}
	
	/**
	 * Burning Ship Set 
	 * test none of the pixels in the Burning Ship set have an escape time of 0 or 1
	 */
	@Test
	public void BurningShipEscapeTime() {
		BurningShip ship = new BurningShip();
		int[][] result = ship.getFractals();
		for (int row = 0; row < result.length; row = row + 1) {
			for (int col = 0; col < result[row].length; col = col + 1) {
				assertFalse(1== result[row][col]);
				assertFalse(0==result[row][col]);
			}
		}
	}
	/**
	 * Burning Ship Set 
	 * test for escape time for the given coordinate (-1.6999999999999802, 0.0030136986301371603)
	 * exceeds the escape distance 3 after a ten loop pass, so escape time == 10
	 */
	@Test
	public void BurningShipTenLoop() {
		BurningShip ship = new BurningShip();
		assertEquals(10,ship.escapeTime(3,-1.6999999999999802, 0.0030136986301371603));
	}
	
	/**
	 * Burning Ship Set 
	 * The method called to calculate the fractal returns a 2-d array with 512 rows and 512 columns
	 */
	@Test
	public void BurningShipFractalSize() {
		BurningShip ship = new BurningShip();

		int[][] result = ship.getFractals();

		assertEquals(512, result.length);
		assertEquals(512, result[0].length);

	}

}
