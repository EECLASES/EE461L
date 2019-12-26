package observer3;

import java.awt.Color;
import java.util.ArrayList;

public interface  Subject {
	
	public void Attach(Observer o);
	public void Detach(Observer o);
	
	public void Notify(Color color);
	
}
