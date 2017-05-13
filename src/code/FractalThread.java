package code;

import javax.swing.SwingWorker;

import edu.buffalo.fractal.ComputePool;
import edu.buffalo.fractal.WorkerResult;

public class FractalThread {

	/**
	 *  accepts the # of threads and divides it appropriately into the of processors in the PC
	 */
	private int _w;

	public FractalThread() {
		reset();
	}

	
	/**
	 * reset method to change _2
	 */
	public void reset() {
		_w = 4;
	}

	/**
	 * setter method that sets it to the instance variable
	 * 
	 *  @param int i
	 */
	public void setWorkers(int i) {
		_w = i;
	}
	/**
	 * Performs the multi-threading
	 * 
	 * @param Set s
	 * @return sw SwingWorker<WorkerResult, Void>[]
	 * 
	 */
	public SwingWorker<WorkerResult, Void>[] getWorkers(Set s) {
		SwingWorker<WorkerResult, Void>[] sw = new Worker[_w];
		int split = 2048 / _w;
		int start = 0;
		for (int n = 0; n < _w; n++) {
			int r = split;
			if (((split * _w) + n) < 2048) {
				r = split + 1;
			}
			Worker w = new Worker(start, r, s);
			sw[n] = w;
			start = start + r;
		}
		return sw;
	}

	
	/**
	 *	Generates a 2048 fractal
	 * @param ComputePool cp
	 * @parm Set s
	 */
	
	public void generateFractal(ComputePool cp, Set s) {
		cp.generateFractal(2048, getWorkers(s));
	}

}
