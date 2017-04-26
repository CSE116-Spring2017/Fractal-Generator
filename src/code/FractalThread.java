package code;

import javax.swing.SwingWorker;

import edu.buffalo.fractal.ComputePool;
import edu.buffalo.fractal.WorkerResult;

public class FractalThread {

	
	private int _w;
	
	public FractalThread() {
		reset();
	}

	public void reset() {
		_w = 1;
	}
	public void setWorkers(int i) {
		_w = i;
	}

	public SwingWorker<WorkerResult, Void>[] getWorkers(Set s) {
		SwingWorker<WorkerResult, Void>[] sw = new Worker[_w];
		int split = 2048/_w;
		int start = 0;
		for (int n = 0; n < _w; n++) {
			int r = split;
			if(((split*_w) + n) < 2048) {
				r = split + 1;
			}
			Worker w = new Worker(start, r, s);
			sw[n] = w;
			start = start + r;
		}
		return sw;
	}

	public void generateFractal(ComputePool cp, Set s) {
		cp.generateFractal(2048, getWorkers(s));
	}

}
