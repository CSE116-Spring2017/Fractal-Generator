package tests;

import static org.junit.Assert.*;

import javax.swing.SwingWorker;

import org.junit.Test;

import code.FractalThread;
import code.JuliaSet;
import edu.buffalo.fractal.WorkerResult;

public class JuliaSetTest {

	/**
	 * Julia Set Translate a pixel's row to the associated x-coordinate in the
	 * fractal test for the first, second and last x coordinate
	 */
	@Test
	public void JuliaSetRowToXCoordinate() {
		JuliaSet js = new JuliaSet();
		js.setCoordinateX(-1.7, 1.7);
		double[][] x = js.getCoordinateX();
		assertEquals(-1.7, x[0][0], 0.0001);
		assertEquals(1.7, x[2047][0], 0.0001);
	}

	/**
	 * Julia Set Translate a pixel's column to the associated y-coordinate in
	 * the fractal test for the first, second and last y coordinate
	 */
	@Test
	public void JuliaSetColToYCoordinate() {
		JuliaSet js = new JuliaSet();
		js.setCoordinateY(-1.0, 1.0);
		double[][] y = js.getCoordinateY();
		assertEquals(-1.0, y[0][0], 0.0001);
		assertEquals(1.0, y[0][2047], 0.0001);

	}

	/**
	 * Julia Set test for escape time for the given coordinate
	 * (1.0492187499999897, -0.234375) never exceed escape distance 2, so escape
	 * time == 255
	 */
	@Test
	public void JuliaSetNeverExceedEscDis() {
		JuliaSet js = new JuliaSet();
		assertEquals(255, js.escapeTime(255, 2, 1.0492187499999897, -0.234375));
	}

	/**
	 * Julia Set test for escape time for the given coordinate
	 * (1.0492187499999897, -0.234375) never exceed escape distance 2 , so
	 * escape time == 135
	 */
	@Test
	public void JuliaNeverExceedEscapeDistance() {
		JuliaSet js = new JuliaSet();
		assertEquals(135, js.escapeTime(135, 2, 1.0492187499999897, -0.234375));
	}

	/**
	 * Julia Set test for escape time for the given coordinate
	 * (1.6933593749999853, 0.9765625) exceeds the escape distance 2 after a
	 * single loop pass, so escape time == 1
	 */
	@Test
	public void JuliaSetSingleLoop() {
		JuliaSet js = new JuliaSet();
		assertEquals(1, js.escapeTime(255, 2, 1.6933593749999853, 0.9765625));
	}

	/**
	 * Julia Set test for escape time for the given coordinate
	 * (1.4538160469667272, -0.13502935420743645) exceeds the escape distance 3
	 * after a ten loop pass, so escape time == 10
	 */
	@Test
	public void JuliaSetTenLoop() {
		JuliaSet js = new JuliaSet();
		assertEquals(10, js.escapeTime(255, 3, 1.4538160469667272, -0.13502935420743645));
	}

	/**
	 * Julia Set The method called to calculate the fractal returns a 2-d array
	 * with 512 rows and 512 columns
	 */
	@Test
	public void JuliaSetFractalSize() {
		JuliaSet js = new JuliaSet();
		js.setEscapeDis(2);
		js.setMaxEscapeTime(255);
		FractalThread f = new FractalThread();
		f.setWorkers(4);
		SwingWorker<WorkerResult, Void>[] sw = f.getWorkers(js);
		for(SwingWorker<WorkerResult, Void> w: sw) {
			w.execute();
		}
		for(SwingWorker<WorkerResult, Void> w: sw) {
			while(!w.isDone()) {}
		}
		int[][] result = js.getEscapeTime();
		assertEquals(2048, result.length);
		assertEquals(2048, result[0].length);
	}

}
