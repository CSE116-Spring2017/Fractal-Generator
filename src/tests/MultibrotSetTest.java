package tests;

import static org.junit.Assert.*;

import javax.swing.SwingWorker;

import org.junit.Test;

import code.FractalThread;
import code.MultibrotSet;
import edu.buffalo.fractal.WorkerResult;

public class MultibrotSetTest {

	/**
	 * Multibrot Set Translate a pixel's row to the associated x-coordinate in
	 * the fractal test for the first, second and last x coordinate
	 */
	@Test
	public void MultibrotSetRowToXCoordinate() {
		MultibrotSet mb = new MultibrotSet();
		mb.setCoordinateX(-1.0, 1.0);
		double[][] x = mb.getCoordinateX();
		assertEquals(-1.0, x[0][0], 0.0001);
		assertEquals(1.0, x[2047][0], 0.0001);
	}

	/**
	 * Multibrot Set Translate a pixel's row to the associated y-coordinate in
	 * the fractal test for the first, second and last y coordinate
	 */
	@Test
	public void MultibrotSetColToYCoordinate() {
		MultibrotSet mb = new MultibrotSet();
		mb.setCoordinateY(-1.3, 1.3);
		double[][] y = mb.getCoordinateY();
		assertEquals(-1.3, y[0][0], 0.0001);
		assertEquals(1.3, y[0][2047], 0.0001);
	}

	/**
	 * Multibrot Set test for escape time for the given coordinate (0.5859375,
	 * 0.24375000000000108) never exceed escape distance 2, so escape time ==
	 * 255
	 */
	@Test
	public void MultibrotNeverExceedEscDis() {
		MultibrotSet mb = new MultibrotSet();
		assertEquals(255, mb.escapeTime(255, 2, 0.5859375, 0.24375000000000108));
	}

	/**
	 * Multibrot Set test for escape time for the given coordinate (0.5859375,
	 * 0.24375000000000108) never exceed escape distance 2, so escape time ==
	 * 135
	 */
	@Test
	public void MultibrotNeverExceedEscapeDistance() {
		MultibrotSet mb = new MultibrotSet();
		assertEquals(135, mb.escapeTime(135, 2, 0.5859375, 0.24375000000000108));
	}

	/**
	 * Multibrot Set test for escape time for the given coordinate (0.9921875,
	 * 1.05625) exceeds the escape distance 2 after a single loop pass, so
	 * escape time == 1
	 */
	@Test
	public void MultibrotSetSingleLoop() {
		MultibrotSet mb = new MultibrotSet();
		assertEquals(1, mb.escapeTime(255, 2, 0.9921875, 1.05625));
	}

	/**
	 * Multibrot Set test for escape time for the given coordinate
	 * (0.7025440313111545, -0.5520547945205528) exceeds the escape distance 3
	 * after a ten loop pass, so escape time == 10
	 */
	@Test
	public void MultibrotTenLoop() {
		MultibrotSet mb = new MultibrotSet();
		assertEquals(10, mb.escapeTime(255, 3, 0.7025440313111545, -0.5520547945205528));

	}

	/**
	 * Multibrot Set The method called to calculate the fractal returns a 2-d
	 * array with 512 rows and 512 columns
	 */
	@Test
	public void MultibrotFractalSize() {
		MultibrotSet mb = new MultibrotSet();
		mb.setEscapeDis(2);
		mb.setMaxEscapeTime(255);
		FractalThread f = new FractalThread();
		f.setWorkers(4);
		SwingWorker<WorkerResult, Void>[] sw = f.getWorkers(mb);
		for(SwingWorker<WorkerResult, Void> w: sw) {
			w.execute();
		}
		for(SwingWorker<WorkerResult, Void> w: sw) {
			while(!w.isDone()) {}
		}
		int[][] result = mb.getEscapeTime();
		assertEquals(2048, result.length);
		assertEquals(2048, result[0].length);
	}

}
