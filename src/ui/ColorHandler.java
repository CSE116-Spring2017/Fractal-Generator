package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.IndexColorModel;

import code.Model;

public class ColorHandler implements ActionListener {

	private Model _model;
	private IndexColorModel _indexColorModel;

	public ColorHandler(Model m, IndexColorModel i) {
		_model = m;
		_indexColorModel = i;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		_model.selectColor(_indexColorModel);

	}

}
