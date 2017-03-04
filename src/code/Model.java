package code;

import ui.UI;

public class Model {
	
	private UI _ui;
	private Set _set;
	private int[][] _fractals;
	
	public Model() {
		
	}
	public void addObserver(UI ui) {
		_ui = ui;
		
	}
	public void escapeTime(Set set) {
		_fractals = set.fractals();
		_ui.update();
	}
	public int[][] escapeTime() {
		return _fractals;
		
	}
	

}
