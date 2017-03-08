package code;

import java.awt.image.IndexColorModel;

import ui.UI;

public class Model {
	
	private UI _ui;
	private int[][] _fractals;
	private IndexColorModel _indexColorModel;
	
	public Model() {
		
	}
	public void addObserver(UI ui) {
		_ui = ui; 
		
	}
	public int[][] escapeTime() {
		return _fractals;
	}
	
	public void escapeTime(Set set) {
		_fractals = set.getFractals();
		_ui.update();
	}
	
	public IndexColorModel selectColor() {
		return _indexColorModel;
	}
	
	public void selectColor(IndexColorModel i) {
		_indexColorModel = i;
		_ui.update();
	}
	
	public boolean newFractal(){
		return selectColor()!=null && escapeTime()!=null;
	}
	

}
