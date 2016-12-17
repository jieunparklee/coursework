import java.awt.Choice;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ChoiceController {
	private DrawingFrame bT;
	private Choice color;
	private Choice state;
	
	public ChoiceController(DrawingFrame jF)
	{
		LocalColorChoiceHandler cch = new LocalColorChoiceHandler();
		color = new Choice();
		color.addItemListener(cch);
		color.add("Black");
		color.add("Red");
		color.add("Green");
		color.add("Blue");

		LocalFillChoiceHandler fch = new LocalFillChoiceHandler();
		state = new Choice();
		state.addItemListener(fch);
		state.add("Fill");
		state.add("Empty");

		jF.getChoicePanel().add(color);
		jF.getChoicePanel().add(state);

		bT= jF;
	}
	
	private class LocalColorChoiceHandler implements ItemListener{
		public void itemStateChanged(ItemEvent arg0) {
			String item = (String) arg0.getItem();

			if (item.compareTo("Black") == 0)
				bT.setCurrentColor(Color.black);
			else if (item.compareTo("Red") == 0)
				bT.setCurrentColor(Color.red);
			else if (item.compareTo("Green") == 0)
				bT.setCurrentColor(Color.green);
			else if (item.compareTo("Blue") == 0)
				bT.setCurrentColor(Color.blue);	
		}
	}
		
	private class LocalFillChoiceHandler implements ItemListener{
		public void itemStateChanged(ItemEvent arg0) {
			String item = (String) arg0.getItem();

			if (item.compareTo("Fill") == 0)
				bT.setFillState(true);
			else if (item.compareTo("Empty") == 0)
				bT.setFillState(false);
		}
	}
}