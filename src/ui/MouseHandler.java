package ui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import code.Model;

public class MouseHandler implements MouseListener{
	private Model _model;
	
	private int _x;
	private int _xx;
	
	private int _y;
	private int _yy;
	
	public MouseHandler(Model model){
		_model = model;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		_x = e.getX();
		_y = e.getY();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		_xx = e.getX();
		_yy = e.getY();
		
		_model.setX(_x,_xx);
		_model.setY(_y,_yy);
	}

}
