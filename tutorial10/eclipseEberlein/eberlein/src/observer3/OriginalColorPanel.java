package observer3;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class OriginalColorPanel extends ColorPanel implements Subject, PropertyChangeListener {
    
    private ArrayList<Observer> observers = new ArrayList<Observer>();

	
	public OriginalColorPanel(Color initialColor) {
		super(initialColor);
	}

	

	@Override
	public void Attach(Observer o) {
		// TODO Auto-generated method stub
        this.observers.add(o);

		
	}



	@Override
	public void Detach(Observer o) {
		// TODO Auto-generated method stub
		this.observers.remove(o);
		
	}



	@Override
	public void Notify(Color color) {
		// TODO Auto-generated method stub
		for (Observer o : this.observers) {
			o.Update( color);
		}
	}

	


	  public void propertyChange(PropertyChangeEvent e) {
	        String propertyName = e.getPropertyName();
	        if ("background".equals(propertyName)) {
	        	Notify(this.color);
	        } else {
	            
	        }
	    }

	




	}