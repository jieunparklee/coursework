import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class DrawingFrame extends JFrame {
	private ShapeContainer shapeContainer;
	private Panel buttonPanel; 
	private Panel choicePanel;
	private Label name;
	
	private int currentShape;
	private Color currentColor;
	private boolean fillState;
	
	private WhiteBoardService rmiModule;
	private String entity;

	public DrawingFrame(String title, WhiteBoardService rmi)
	{
		super(title);
		entity = title;

		buttonPanel = new Panel();		
		new ButtonController(this);
		getContentPane().add("South",buttonPanel);

		choicePanel = new Panel();
		new ChoiceController(this);
		getContentPane().add("East", choicePanel);

		name = new Label("Paint"); // name
		getContentPane().add("North", name);

		shapeContainer = new ShapeContainer();
		setShapeContainer(shapeContainer);

		new CanvasMouseController(this);

		currentShape = new Shape().LINE;
		currentColor = Color.BLACK;
		fillState = true;

		rmiModule = rmi;
	
		addWindowListener(new LocalWindowListener());

		setSize(500,500);
		//show();
		this.setVisible(true);
	}
	
	public Container getShapeContainer() { return shapeContainer; }
	public Panel getButtonPanel() { return buttonPanel; }
	public Panel getChoicePanel() { return choicePanel; }
	public void setShape(int shape) { currentShape = shape; }
	public int getSHape() { return currentShape; }
	public void setShapeContainer(ShapeContainer s) { getContentPane().add(s); }
	
	public void addShape(Point p1, Point p2)
	{
		Shape newShape = new Line(p1,p2);
		
		if (getSHape() == new Shape().CIRCLE)
		{
			newShape = new Circle(p1,p2);
		}
		else if (getSHape() == new Shape().RECT)
		{
			newShape = new Rectangular(p1,p2);
		}
		
		newShape.setColor(getCurrentColor());
		newShape.setFill(getFillState());
		//newShape.setBounds(0,0,getShapeContainer().getWidth(), getShapeContainer().getHeight());
		try {
			getShapeContainer().add(newShape);
			rmiModule.add(newShape,entity);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		repaint();
	}
	
	public void removeFrontShape()
	{
		try {
			rmiModule.removeFrontShape(entity);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		repaint();
	}
	
	public void removeAll()
	{
		try {
			rmiModule.removeAll(entity);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		repaint();
	}
	
	public void setCurrentColor(Color c) { currentColor = c; }
	public Color getCurrentColor() { return currentColor; }
	
	public void setFillState(boolean b) { fillState = b; }
	public boolean getFillState() { return fillState; }
	
	public WhiteBoardService getRmiModule() { return rmiModule; }
	public void setRmiModule(WhiteBoardServiceImpl m) { rmiModule = m; }
	
	private class LocalWindowListener extends WindowAdapter {
		public void windowClosing(WindowEvent e){
			System.exit(0);
		}
	}
}