package code;

import java.awt.Point;
/**
 * The Model stores data by the actions from the controller and displayed in the UI
 */
import java.awt.image.IndexColorModel;

import ui.UI;

public class Model {

	/** UI thats initialized by addObserver method */
	private UI _ui;

	/** Boundary use to check the range of zoom in */
	private Boundary _b;

	/** The escape time of the fractal that need to be display on UI */
	private int[][] _escapeTime;

	/** The escape distance of the fractal */
	private int _escapeDistance;

	/** The max escape time of the fractal that need to be display on UI */
	private int _maxEscTime;

	/** The IndexColorModel that need to be display on UI */
	private IndexColorModel _indexColorModel;

	/** The type of the current fractal set that need to be display on UI */
	private Set _set;

	public Model() {
		_b = new Boundary();
		/** Set default escape Distance to 2 */
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
	 * Update the type of fractal set {@code _set} by {@param set} Passes the
	 * escape distance {@code _escapeDistance} to the fractal set Update the new
	 * escape time with the escape distance {@code _escapeDistance} to
	 * {@code _escapeTime} updates the user interface.
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
	 * Update the max escape time {@code _maxEscTime} by {@param maxEscTime}
	 * entered by the user Then call {@code escapeTime(_set)} to get the new
	 * escape time for current fractal set {@code _set}
	 * 
	 * @param maxEscTime
	 */
	public void setMaxEscTime(int maxEscTime) {
		_maxEscTime = maxEscTime;
		setFractal(_set);
	}

	/**
	 * Update the escape distance {@code _escapeDistance} by
	 * {@param escapeDistance} entered by the user Then call
	 * {@code escapeTime(_set)} to get the new escape time for current fractal
	 * set {@code _set}
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
	 * {@param i} gets the color selected by the user Update the IndexColorModel
	 * {@code _indexColorModel} by {@param i} Then updates the user interface.
	 * 
	 * @param i
	 */
	public void selectColor(IndexColorModel i) {
		_indexColorModel = i;
		_ui.update();
	}

	/**
	 * Returns true if {@code _indexColorModel} and {@code _escapeTime} are not
	 * null
	 * 
	 * @return true
	 */
	public boolean newFractal() {
		return getSelectColor() != null && getEscapeTime() != null;
	}

	/**
	 * if the {@code _indexColorModel} and {@code _escapeTime} are selected by
	 * the user (not null) then create new Rectangle whose upper-left corner is
	 * at ({@code x}, {@code y}) in the coordinate space, with width {@code w}
	 * and height {@code h}
	 * 
	 * @param x
	 *            x coordinate of upper-left corner of the selected region
	 * @param y
	 *            y coordinate of upper-left corner of the selected region
	 * @param w
	 *            width of the selected region
	 * @param h
	 *            height of the selected region
	 * 
	 */
	public void selectionBox(int x, int y, int w, int h) {
		if (newFractal()) {
			_ui.selectionBox(x, y, w, h);
		}
	}

	/**
	 * pass points {@code p} and {@code p1} to {@code _b} and check region
	 * 
	 * @param p
	 *            Point when pressed
	 * @param p1
	 *            Point when dragged
	 * 
	 */
	public void selection(Point p, Point p1) {
		_b.selection(this, p, p1);
	}

	/**
	 * use {@code selection(p, p1)} to check the region and
	 * {@code set(_set, p, p1)} from _b to update the new x and y range
	 * {@code setFractal(_set)} update and set up the new fractal
	 * 
	 * @param p
	 *            Point when pressed
	 * @param p1
	 *            Point when released
	 * 
	 */
	public void setNew(Point p, Point p1) {
		selection(p, p1);
		_b.setNew(_set, p, p1);
		setFractal(_set);
	}

	/**
	 * reset the all fractal set's x and y range to default and use
	 * {@code setFractal(_set)} update and set up the new fractal
	 */
	public void reset() {
		_set.reset();
		setFractal(_set);
	}

}
