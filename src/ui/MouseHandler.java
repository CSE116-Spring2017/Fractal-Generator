package ui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import code.Model;

public class MouseHandler implements MouseMotionListener{
	private Model _model;
	
	private double _x;
	private double _xx;
	
	private double _y;
	private double _yy;
	
	public MouseHandler(Model model){
		_model = model;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	
}
