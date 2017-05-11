package code;

import javax.swing.SwingWorker;

import edu.buffalo.fractal.WorkerResult;


public class Worker extends SwingWorker<WorkerResult, Void>{
	
	private int _s;
	private int _r;
	private Set _set;
	
	/**
	 * Give Worker start, number of rows, and set
	 * @param start
	 * @param row
	 * @param set
	 */
	public Worker(int start, int row, Set set) {
		_s = start;
		_r = row;
		_set = set;
	}
	
	/**
	 * Give the start and row to WorkerResult
	 * Use set to generate the array of escape time to WorkerResult
	 */
	@Override
	protected WorkerResult doInBackground() throws Exception {
		return new WorkerResult(_s, _set.getEscapeTime(_s, _r));
	}
	

}
