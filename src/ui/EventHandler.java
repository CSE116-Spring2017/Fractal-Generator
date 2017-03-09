package ui;

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

	@Override
	public void actionPerformed(ActionEvent e) {
		_model.escapeTime(_s);

	}

}
