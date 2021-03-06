import java.awt.*;

public class Rectangular extends Shape {

	public Rectangular (Point a1, Point a2) {
		super (a1, a2);
	}
	public Object clone () {
		Rectangular l = new Rectangular (p1,p2);
		return l;
	}
	public void paint (Graphics g) {
		g.setColor(super.getColor());
		
		int rx = super.getp1X();
    	int ry = super.getp1Y();
    	int w = super.getp2X() - rx;
    	int h = super.getp2Y() - ry;

    	if (w < 0)
    		rx += w;
    	if (h < 0)
    		ry += h;

    	w = Math.abs(w);
    	h = Math.abs(h);

		if (super.getFill())
			g.fillRect(rx,ry,w,h);
		else g.drawRect(rx,ry,w,h);
	}

}