import java.awt.*;

import javax.swing.*;

public class Line extends Shape {
	public Line (Point a1, Point a2) {
		super (a1, a2);
	}
	public Object clone () {
		Line l = new Line (p1,p2);
		return l;
	}
	public void paint (Graphics g) {
		g.setColor(super.getColor());
		g.drawLine(super.getp1X(), super.getp1Y(), super.getp2X(), super.getp2Y());
	 }
}