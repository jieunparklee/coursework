import java.awt.Color;
import java.awt.Container;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.*;

public class CanvasMouseController implements MouseMotionListener, MouseListener {
	private DrawingFrame bT;
	private Point p1, p2;
	private int drag;
	
	public CanvasMouseController(DrawingFrame jF)
	{
		bT = jF;

		bT.getShapeContainer().addMouseListener(this);
		bT.getShapeContainer().addMouseMotionListener(this);
	}
	
	public void mouseDragged(MouseEvent arg0) {
		//System.out.println("Mouse Dragged: (" +arg0.getX()+", "+arg0.getY() +")");
		drag++;
		if (drag>0)
			bT.removeFrontShape();

		bT.addShape(p1, arg0.getPoint());
	}

	public void mouseMoved(MouseEvent arg0) {
		//System.out.println("Mouse Moved: (" +arg0.getX()+", "+arg0.getY() +")");

	}

	public void mouseClicked(MouseEvent arg0) {
		//System.out.println("Mouse Clicked: " +arg0);
		
	}

	public void mousePressed(MouseEvent arg0) {
		//System.out.println("Mouse Pressed: " +arg0);
		p1 = arg0.getPoint();
		drag = -1;
	}

	public void mouseReleased(MouseEvent arg0) {
		//System.out.println("Mouse released: " +arg0);
		p2 = arg0.getPoint();
		bT.removeFrontShape();
		bT.addShape(p1, p2);
		p1 = new Point();
		p2 = new Point();
	}

	public void mouseEntered(MouseEvent arg0) {
		//System.out.println("Mouse entered: " +arg0);
	}

	public void mouseExited(MouseEvent arg0) {
		//System.out.println("Mouse exited: " +arg0);
	}
}