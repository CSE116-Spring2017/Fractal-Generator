package code;

/**
 * 
 * WRITE DESCRIPTION OF THE MODEL CLASS WEN. THANK YOU!!
 */
import java.awt.image.IndexColorModel;

import ui.UI;

public class Model {

	private UI _ui;
	private int[][] _fractals;
	private IndexColorModel _indexColorModel;
	private Set _set;
	private int _escapeDistance;

	public Model() {
		_escapeDistance = 2;
	}

	public void addObserver(UI ui) {
		_ui = ui;

	}

	public int[][] escapeTime() {
		return _fractals;
	}

	/**
	 * 
	 * Passes on the default escape distance to the interface set where distance
	 * will be set to the selected fractal. It then updates the user interface.
	 * 
	 * @param set
	 */

	public void escapeTime(Set set) {
		_set = set;
		_set.setEscapeDis(_escapeDistance);
		_fractals = _set.getFractals();
		_ui.update();
	}

	/**
	 * 
	 * Passes on the escape distance entered by the user to the to the
	 * excapeTime method where the distance will be set to the selected fractal.
	 * 
	 * @param escapeDis
	 */
	public void escapeDis(int escapeDis) {
		_escapeDistance = escapeDis;
		escapeTime(_set);
	}

	/**
	 * @return _indexColorModel
	 */
	public IndexColorModel selectColor() {
		return _indexColorModel;
	}

	/**
	 * {@param i} gets the color selected by the user and passes it on to the
	 * ColorModelFactory class, then updates the user interface.
	 * 
	 * @param i
	 */
	public void selectColor(IndexColorModel i) {
		_indexColorModel = i;
		_ui.update();
	}

	/**
	 * Returns true if selectColor and escapeTime method are not null
	 * 
	 * @return true
	 */
	public boolean newFractal() {
		return selectColor() != null && escapeTime() != null;
	}

}
