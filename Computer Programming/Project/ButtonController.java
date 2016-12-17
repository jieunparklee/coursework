import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonController{
	private DrawingFrame bT;
	private Button b1;
	private Button b2;
	private Button b3;
	private Button b4;
	
	public ButtonController(DrawingFrame jF)
	{
		LocalButtonHandler bh = new LocalButtonHandler();

		b1 = new Button("Line");
		b1.addActionListener(bh);
		b2 = new Button("Circle");
		b2.addActionListener(bh);
		b3 = new Button("Rectangular");
		b3.addActionListener(bh);
		b4 = new Button("Clear ALL");
		b4.addActionListener(bh);

		jF.getButtonPanel().add(b1);
		jF.getButtonPanel().add(b2);
		jF.getButtonPanel().add(b3);
		jF.getButtonPanel().add(b4);

		bT = jF;
	}
	
	private class LocalButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			 String action = ae.getActionCommand();

			 if (action.compareTo("Line") == 0)
			 	bT.setShape(0);
			 else if (action.compareTo("Circle") == 0)
			 	bT.setShape(1);
			 else if (action.compareTo("Rectangular") == 0)
			 	bT.setShape(2);
			 else if (action.compareTo("Clear ALL") == 0)
			 	bT.removeAll();
		}
	}
}