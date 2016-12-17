import java.awt.*;
import javax.swing.*;


public class Shape extends JComponent implements Cloneable {
	
	protected Point p1,p2;
	protected Color color;
	protected boolean fill;
	
	final int LINE = 0;
	final int CIRCLE = 1;
	final int RECT = 2;
	
	public int getp1X() {
		return (int) p1.getX();
	}
	public int getp1Y() {
		return (int) p1.getY();
	}
	public int getp2X() {
		return (int) p2.getX();
	}
	public int getp2Y() {
		return (int) p2.getY();
	}

	//for LINE/CIRCLE/RECT fields access purposes
	public Shape () {
		 
	}
	
	public Shape (Point a1, Point a2) {
	 
	    p1 = a1;
	    p2 = a2;
	    color = Color.BLACK;
	    fill = false;
	}
	
	public Shape (Point a1, Point a2, Color c) {

	    p1 = a1;
	    p2 = a2;
	    color = c;
	    fill = false;
	}
	
	public boolean equals(Shape shape)
	{
		return ( (p1.getX()==shape.p1.getX()) && (p2.getX()==shape.p2.getX()) 
				&& (p1.getY()==shape.p1.getY()) &&(p2.getY()==shape.p2.getY()) ); 
	}
	
	public Object clone (){
		System.err.println ("Shape.clone(): Internal Error: This method should not be getting called.  All shapes should override it.");
		return new Shape (p1,p2);
	}
	
	public Color getColor()
	{
		return color;
	}
	
	public void setColor(Color c)
	{
		color = c;
	}
	
	public void setFill(boolean b)
	{
		fill = b;
	}

	public boolean getFill() {
		return fill;
	}
	public void paint (Graphics g, int s) {

	}
	
	public Dimension getPreferredSize () {
		return new Dimension ((int)Math.abs(p1.getX()-p2.getX()),(int)Math.abs(p1.getY()-p2.getY()));
	}

	public Dimension getMinimumSize () {
		return new Dimension ((int)Math.abs(p1.getX()-p2.getX()), (int)Math.abs (p1.getY()-p2.getY()));
	}

	public Dimension getMaximumSize () {
		return new Dimension ((int)Math.abs(p1.getX()-p2.getX()), (int)Math.abs (p1.getY()-p2.getY()));
	}
	
	public void setSecondPoint(Point a2) { p2 = a2; }
}