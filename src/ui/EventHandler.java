package ui;

/**
 * 
 * This class is used to set the fractal selected by the user.
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import code.Model;
import code.Set;

public class EventHandler implements ActionListener {

	private Model _model;
	private Set _s;

	public EventHandler(Model m, Set s) {
		_model = m;
		_s = s;
	}

	/**
	 * Passes on the fractal selected by the user to the model class.
	 * 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		_model.setEscapeTime(_s);
	}
    
}
