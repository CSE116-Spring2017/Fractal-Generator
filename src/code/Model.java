package code;

import java.awt.image.IndexColorModel;

import ui.UI;

public class Model {
	
	private UI _ui;
	private int[][] _fractals;
	private IndexColorModel _indexColorModel;
	private Set _set;
	private int _escapeDis;
	
	public Model() {
		
	}
	public void addObserver(UI ui) {
		_ui = ui; 
		
	}
	public int[][] escapeTime() {
		return _fractals;
	}
	
	public void escapeDis(int escapeDistance){
		_escapeDis = escapeDistance;
		escapeTime(_set);
		_ui.update();
	}
	
	public void excapeTime(Set set){
		_set = set;
		_set.setEscapeDis(_escapeDis);
		_fractals = _set.getFractals();
		_ui.update();
	}
	
	public void escapeTime(Set set) {
		try{
		_fractals = set.getFractals();
		_ui.update();
		}catch(NullPointerException npe){
			
		}
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
