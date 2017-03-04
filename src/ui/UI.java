package ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.IndexColorModel;

import javax.swing.*;

import code.BurningShip;
import code.ColorModelFactory;
import code.JuliaSet;
import code.MandelbrotSet;
import code.Model;
import code.MultibrotSet;
import edu.buffalo.fractal.FractalPanel;

public class UI implements Runnable {
	
	private Model _model;
	private JFrame _frame;
	private JMenuBar _menub;
	private FractalPanel _fractalPanel;
	public UI() {
		_model = new Model();
	}
	
	@Override
	public void run() {
		
		_frame = new JFrame();
		_menub = new JMenuBar();
		
		JMenu file = new JMenu("File");
		JMenuItem quit = new JMenuItem("Quit");
		quit.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{ 
				System.exit(0);
			}
		});
		file.add(quit);
		
		JMenu fractal = new JMenu("Fractal");
		JMenuItem mandelbrot = new JMenuItem("Mandelbrot Set");
		mandelbrot.addActionListener(new EventHandler(_model,new MandelbrotSet()));
		JMenuItem julia = new JMenuItem("Julia Set");
		julia.addActionListener(new EventHandler(_model, new JuliaSet()));
		JMenuItem burningShip = new JMenuItem("Burning Ship Set");
		burningShip.addActionListener(new EventHandler(_model, new BurningShip()));
		JMenuItem multibrot = new JMenuItem("Multibrot Set");
		multibrot.addActionListener(new EventHandler(_model, new MultibrotSet()));
		fractal.add(mandelbrot);
		fractal.add(julia);
		fractal.add(burningShip);
		fractal.add(multibrot);
		
		JMenu color = new JMenu("Color");
		
		_menub.add(file);
		_menub.add(fractal);
		_menub.add(color);
		_model.addObserver(this);
		
		_menub.setLayout(new GridLayout(1,3));
		_frame.add(_menub);
		
		_fractalPanel = new FractalPanel();
		_frame.add(_fractalPanel);
		
		_frame.getContentPane().setLayout(new BoxLayout(_frame.getContentPane(), BoxLayout.Y_AXIS));

		_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		_frame.pack();
		_frame.setVisible(true);
	
		
		
	}
	
	public void newFractal() {
		_frame.remove(_fractalPanel);
		_fractalPanel.updateImage(_model.escapeTime());
		IndexColorModel i = ColorModelFactory.createRainbowColorModel(255);
		_fractalPanel.setIndexColorModel(i);
		_frame.add(_fractalPanel);
		
	}
	
	public void update() {
		newFractal();
		_frame.pack();
	}

	

}
