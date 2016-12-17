import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;

public class ShapeContainer extends Container implements java.io.Serializable {
	public int s;
	
	public ShapeContainer () {
		super ();     
		setBackground (Color.white);
		s = 0;
	}
	
	public void paint(Graphics g) {
		g.setColor(getBackground());
		g.fillRect(0, 0, getWidth(), getHeight());

		//super.paint(g);
		for(int i = 0; i < getComponentCount(); i++) {
			getComponent(i).paint(g);
     	 }
	}

	public Dimension getPreferredSize () {
		return new Dimension (300,300);
	}
}