package code;

/**
 * The Model stores data by the actions from the controller and displayed in the UI
 */
import java.awt.image.IndexColorModel;

import ui.UI;

public class Model {
	
	/** UI thats initialized by addObserver method*/
	private UI _ui;
	
	/** The escape time of the fractal that need to be display on UI*/
	private int[][] _escapeTime;
	
	/** The max escape time of the fractal that need to be display on UI*/
	private int _maxEscTime;
	
	/** The IndexColorModel that need to be display on UI*/
	private IndexColorModel _indexColorModel;
	
	/** The type of the current fractal set that need to be display on UI*/
	private Set _set;
	
	/** The escape distance of the fractal*/
	private int _escapeDistance;
	
	private double _x;
	private double _xx;
	private double _y;
	private double _yy;
	
	public Model() {
		/** Set default escape Distance to 2*/
		_escapeDistance = 2;
		_maxEscTime = 255;
	}

	public void addObserver(UI ui) {
		_ui = ui;
	}
	
	/**
	 * Get the current escape time
	 * 
	 * @return _escpaeTime
	 */
	public int[][] getEscapeTime() {
		return _escapeTime;
	}

	/**
	 * Update the type of fractal set {@code _set} by {@param set}
	 * Passes the escape distance {@code _escapeDistance} to the fractal set 
	 * Update the new escape time with the escape distance {@code _escapeDistance} to {@code _escapeTime}
	 * updates the user interface.
	 * 
	 * @param set
	 */

	public void setFractal(Set set) {
		_set = set;
		_set.setEscapeDis(_escapeDistance);
		_set.setMaxEscapeTime(_maxEscTime);
		_escapeTime = _set.getEscapeTime();
		_ui.update();
	}
	
	/**
	 * Update the max escape time {@code _maxEscTime} by {@param maxEscTime} entered by the user
	 * Then call {@code escapeTime(_set)} to get the new escape time for current fractal set {@code _set}
	 * 
	 * @param maxEscTime
	 */
	public void setMaxEscTime(int maxEscTime) {
		_maxEscTime = maxEscTime;
		setFractal(_set);
	}

	/**
	 * Update the escape distance {@code _escapeDistance} by {@param escapeDistance} entered by the user
	 * Then call {@code escapeTime(_set)} to get the new escape time for current fractal set {@code _set}
	 * 
	 * @param escapeDis
	 */
	public void setEscapeDis(int escapeDistance) {
		_escapeDistance = escapeDistance;
		setFractal(_set);
	}

	/**
	 * Get the current IndexColorModel
	 * 
	 * @return _indexColorModel
	 */
	public IndexColorModel getSelectColor() {
		return _indexColorModel;
	}

	/**
	 * {@param i} gets the color selected by the user
	 * Update the IndexColorModel {@code _indexColorModel} by {@param i}
	 * Then updates the user interface.
	 * 
	 * @param i
	 */
	public void selectColor(IndexColorModel i) {
		_indexColorModel = i;
		_ui.update();
	}

	/**
	 * Returns true if _indexColorModel and _escapeTime are not null
	 * 
	 * @return true
	 */
	public boolean newFractal() {
		return getSelectColor() != null && getEscapeTime() != null;
	}
	
	public void setX(double x, double xx){
		_x = x;
		_xx = xx;
	_set.setCoordinateX(_x, _xx);	
	}
	
	public void setY(double y, double yy){
		_y = y;
		_yy = yy;
	_set.setCoordinateY(_y, _yy);
	_ui.update();
	}
}
