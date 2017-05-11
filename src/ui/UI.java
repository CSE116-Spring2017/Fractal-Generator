package ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import code.BurningShip;
import code.ColorModelFactory;
import code.JuliaSet;
import code.MandelbrotSet;
import code.Model;
import code.MultibrotSet;
import edu.buffalo.fractal.ComputePool;
import edu.buffalo.fractal.FractalPanel;

public class UI implements Runnable {

	private Model _model;
	private JFrame _frame;
	private JMenuBar _menub;
	private FractalPanel _fractalPanel;
	private ArrayList<JLabel> _hint;
	private JPanel _hints;
	private Rectangle _s;
	private ComputePool _cp;

	public UI() {
		_model = new Model();
		_cp = new ComputePool();
	}

	@Override
	public void run() {

		_frame = new JFrame();
		_menub = new JMenuBar();
		/**
		 * Creates a JMenu named "File" Creates 1 JMenu Items with names "Quit".
		 * Use it to exit
		 **/
		JMenu file = new JMenu("File");
		JMenuItem quit = new JMenuItem("Quit");
		quit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		file.add(quit);

		/**
		 * Creates a JMenu on the Interface named "Fractal" Creates 4 JMenu
		 * Items with names "Mandelbrot Set", "Julia Set", "Burning Ship Set",
		 * and "Multibrot Set". It then gives all 4 JMenu Items their own
		 * actionListener. It then adds the each JMenu Item to the JMenu
		 * {@code fractal}
		 **/

		JMenu fractal = new JMenu("Fractal");
		JMenuItem mandelbrot = new JMenuItem("Mandelbrot Set");
		mandelbrot.addActionListener(new EventHandler(_model, new MandelbrotSet()));
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

		/**
		 * Creates a JMenu on the Interface named "Color" Creates 8 JMenu Items
		 * with names "Rainbow", "Blue", "Gray", "Red", "Green", "White",
		 * "Black", and "White Blue". It then gives all 8 JMenu Items their own
		 * actionListener. It then adds the each JMenu Item to the JMenu
		 * {@code color}
		 **/

		JMenu color = new JMenu("Color");
		JMenuItem rainbow = new JMenuItem("Rainbow");
		rainbow.addActionListener(new ColorHandler(_model, ColorModelFactory.createRainbowColorModel(255)));
		JMenuItem blue = new JMenuItem("Blue");
		blue.addActionListener(new ColorHandler(_model, ColorModelFactory.createBluesColorModel(255)));
		JMenuItem gray = new JMenuItem("Gray");
		gray.addActionListener(new ColorHandler(_model, ColorModelFactory.createGrayColorModel(255)));
		JMenuItem red = new JMenuItem("Red");
		red.addActionListener(new ColorHandler(_model, ColorModelFactory.createRedColorModel(255)));
		JMenuItem green = new JMenuItem("Green");
		green.addActionListener(new ColorHandler(_model, ColorModelFactory.createGreenColorModel(255)));
		JMenuItem white = new JMenuItem("White");
		white.addActionListener(new ColorHandler(_model, ColorModelFactory.createWhiteColorModel(255)));
		JMenuItem black = new JMenuItem("Black");
		black.addActionListener(new ColorHandler(_model, ColorModelFactory.createBlackColorModel(255)));
		JMenuItem wblue = new JMenuItem("White Blue");
		wblue.addActionListener(new ColorHandler(_model, ColorModelFactory.createWhiteBlueColorModel(255)));
		color.add(rainbow);
		color.add(blue);
		color.add(gray);
		color.add(red);
		color.add(green);
		color.add(white);
		color.add(black);
		color.add(wblue);

		/**
		 * Creates a JMenu on the Interface named "Other" Creates 1 JMenu Item
		 * with the name of "Escape Distance" Add an Action Listener to the
		 * JMenuItem {@code escapeDis} Then it adds JMenuItem {@code escapeDis}
		 * to JMenu {@code other}
		 **/

		JMenu other = new JMenu("Other");
		JMenuItem escapeDis = new JMenuItem("Escape Distance");
		escapeDis.addActionListener(new ActionListener() {
			/**
			 * Creates an Option to Enter a Distance that is desired by the user
			 * Checks to see if its null, and if it is not, call
			 * {@code checkInput(inputDistance)} to check what the user has
			 * input
			 **/
			@Override
			public void actionPerformed(ActionEvent e) {
				String inputDistance = JOptionPane.showInputDialog("Enter an escape distance:");
				if (inputDistance == null) {
				} else {
					checkInputDistance(inputDistance);
				}
			}
		});
		other.add(escapeDis);

		JMenuItem escapeTime = new JMenuItem("Max Escape Time");
		escapeTime.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String inputDistance = JOptionPane.showInputDialog("Enter a max escape time:");
				if (inputDistance == null) {
				} else {
					checkInputTime(inputDistance);
				}
			}

		});
		other.add(escapeTime);
		JMenuItem threads = new JMenuItem("Threads");
		threads.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String s = JOptionPane.showInputDialog(_frame, "Enter number of threads: ");
				if (s == null) {
				} else {
					checkThreadInput(s);
				}

			}
		});
		other.add(threads);
		JMenuItem reset = new JMenuItem("Reset");
		reset.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					_model.reset();
				} catch (NullPointerException n) {
				}
			}
		});
		other.add(reset);
		/**
		 * Adds all 4 JMenus that were created to the JMenu Bar{@code _menub}
		 * Set JMenu layout to a Grid Layout with dimensions of 4, 1. Then add
		 * JMenuBar {@code _menub} to the JFrame {@code _frame}
		 */
		_menub.add(file);
		_menub.add(fractal);
		_menub.add(color);
		_menub.add(other);
		_menub.setLayout(new GridLayout(1, 4));
		_frame.add(_menub);

		_fractalPanel = new FractalPanel();
		_frame.add(_fractalPanel);

		/**
		 * Create 16 JLbale store into ArrayList<JLabel> {@code _hint} Add all
		 * the 16 JLabel to JPanel {@code _hints} Add JLabel {@code _hints} to
		 * JFrame {@code _frame}
		 */

		_hints = new JPanel();
		_hints.setLayout(new GridLayout(16, 1));
		_hint = new ArrayList<JLabel>();
		for (int x = 0; x < 16; x++) {
			JLabel hint = new JLabel();
			hint.setBackground(new Color(50, 50, 50));
			hint.setForeground(Color.WHITE);
			hint.setOpaque(true);
			hint.setFont(new Font("Consolas", Font.PLAIN, 18));
			hint.setHorizontalAlignment(JLabel.CENTER);
			_hints.add(hint);
			_hint.add(hint);
		}
		_frame.add(_hints);

		_frame.getContentPane().setLayout(new BoxLayout(_frame.getContentPane(), BoxLayout.Y_AXIS));
		_model.addObserver(this);
		update();

		_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		_frame.pack();
		_frame.setVisible(true);
		_frame.setResizable(false);

	}

	/**
	 * Convert String (@code input) to Integer When it throw
	 * ({@code NumberFormatException}), Catch this exception and create a
	 * MessageDialog to tell user it's not a valid input When it throw
	 * ({@code NullPointerException}), Catch this exception and ignore it
	 * because It still pass the new escape distance to the model
	 * 
	 * @param input
	 */
	public void checkInputDistance(String input) {
		int distance;
		try {
			distance = Integer.parseInt(input);
			if (distance > 0) {
				_model.setEscapeDis(distance);
			} else {
				JOptionPane.showMessageDialog(null, "The integer has to be greater than 0.", "Distance Error",
						JOptionPane.ERROR_MESSAGE);
			}
		} catch (NumberFormatException nfe) {
			JOptionPane.showMessageDialog(null, "Invalid input, please enter an integer greater than 0.",
					"Distance Error", JOptionPane.ERROR_MESSAGE);
		} catch (NullPointerException npe) {
		}
	}

	/**
	 * Convert String (@code input) to Integer When it throw ({@code
	 * NumberFormatException}), Catch this exception and create a MessageDialog
	 * to tell user it's not a valid input When it throw ({@code
	 * NullPointerException}), Catch this exception and ignore it because It
	 * still pass the new escape time to the model. Input must be between 0 and
	 * 256.
	 * 
	 * @param input
	 */

	public void checkInputTime(String input) {
		int time;
		try {
			time = Integer.parseInt(input);
			if (time > 0 && time < 256) {
				_model.setMaxEscTime(time);
			} else {
				JOptionPane.showMessageDialog(null, "The integer has to be greater than 0 and less than 256.",
						"Time Error", JOptionPane.ERROR_MESSAGE);
			}
		} catch (NumberFormatException nfe) {
			JOptionPane.showMessageDialog(null,
					"Invalid input, please enter an integer greater than 0 and less than 256.", "Time Error",
					JOptionPane.ERROR_MESSAGE);
		} catch (NullPointerException npe) {
		}
	}

	/**
	 * Checks to see if the value inputed is between 0 and 129
	 * If it is not between those values it will spit out an error message
	 * If it is between the values then it will continue with the operation
	 * It also ONLY accepts integer values. It will not taker any other values
	 * 
	 * @param input
	 */
	
	public void checkThreadInput(String s) {
		try {
			int i = Integer.parseInt(s);
			if (i > 0 && i < 129) {
				_model.setWorkers(i);
			} else {
				JOptionPane.showMessageDialog(_frame,
						"Invalid input, please enter an integer greater than 0 and less than 129", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		} catch (NumberFormatException nfe) {
			JOptionPane.showMessageDialog(_frame,
					"Invalid input, please enter an integer greater than 0 and less than 129", "Error",
					JOptionPane.ERROR_MESSAGE);
		} catch (NullPointerException n) {
		}

	}

	/**
	 * Remove the FractalPanel{@code _fractalPanel} from frame {@code _frame}
	 * Make a new FractalPanel Call method
	 * {@code setIndexColorModel(IndexColorModel)} to set new IndexColorModel
	 * for {@code _fractalPanel} Call method {@code updateImage(EscapeTime)} to
	 * set new escape time for {@code _fractalPanel} Then add
	 * FractalPanel{@code _fractalPanel} to frame {@code _frame}
	 */
	@SuppressWarnings("serial")
	public void newFractal() {
		_cp.clearPool();
		_frame.remove(_fractalPanel);
		_fractalPanel = new FractalPanel(new Dimension(2048, 2048), _model.getSelectColor()) {
			@Override
			public void paint(Graphics g) {
				super.paint(g);
				if (_s != null) {
					g.setColor(Color.cyan);
					g.drawRect(_s.x, _s.y, _s.width, _s.height);
				}
			}
		};
//		_fractalPanel.setPreferredSize(new Dimension(800,800));
		MouseHandler m = new MouseHandler(_model);
		_fractalPanel.addMouseListener(m);
		_fractalPanel.addMouseMotionListener(m);
		_cp.changePanel(_fractalPanel);
		_model.generateFractal(_cp);
		// _fractalPanel.setIndexColorModel(_model.getSelectColor());
		// _fractalPanel.updateImage(_model.getEscapeTime());
		_frame.add(_fractalPanel);
	}

	/**
	 * The selectionBox Method is being run as long as the mouse is being
	 * dragged It takes in the x and y coordinates that the user started to drag
	 * from and it takes the x and y coordinates of where the mouse is being
	 * dragged too (w and h respectively). Everytime the mouse is clicked and
	 * dragged it creates a new rectangle and it sets the bounds with the new
	 * coordinates.
	 */

	public void selectionBox(int x, int y, int w, int h) {
		_s = new Rectangle();
		_s.setBounds(x, y, w, h);
		_fractalPanel.repaint();
	}

	/**
	 * if newFractal() is false - when neither IndexColorModel nor type of
	 * fractal set are select by the user Remove the
	 * FractalPanel{@code _fractalPanel} from frame {@code _frame} Then set text
	 * of JLabel in ArrayList<JLabel> {@code _hint} to show the steps need to do
	 * for the user else remove the JPanel{@code _hint} from frame
	 * {@code _frame} and call {@code newFractal()} to make a new FractalPanel
	 */
	public void update() {
		if (!_model.newFractal()) {
			_frame.remove(_fractalPanel);
			_hint.get(1).setText("To set up your fractal:             ");
			_hint.get(4).setText("    Select a color from the Color menu    ");
			_hint.get(6).setText("  and  ");
			_hint.get(8).setText("  Select a fractal from the Factal menu   ");
			_hint.get(10).setText(" or ");
			_hint.get(12).setText("Select quit from File menu");
		} else {
			_frame.remove(_hints);
			newFractal();
			_s = null;
		}
		_frame.pack();
	}
}
