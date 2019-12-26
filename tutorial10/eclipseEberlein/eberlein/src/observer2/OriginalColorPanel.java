package observer2;

import javax.swing.*;
import java.awt.*;

public class OriginalColorPanel extends ColorPanel {
    

	public OriginalColorPanel(Color initialColor) {
		super(initialColor);
		// TODO Auto-generated constructor stub
	}

	@Override
    public void Update(Color newColor, Color complemenataryColor) {
    	super.setColor(newColor);
    }

	
}