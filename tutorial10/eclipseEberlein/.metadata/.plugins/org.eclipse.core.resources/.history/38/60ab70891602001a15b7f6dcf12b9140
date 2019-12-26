package observer2;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.util.ArrayList;

public class DisplayColors implements ChangeListener, Subject {

    public static void main(String[] args) {
        SwingFacade.launch(new DisplayColors().mainPanel(), "Compute Complementary Colors");
    }
    
    private ArrayList<Observer> observers = new ArrayList<Observer>();
    
    protected OriginalColorPanel originalColorPanel;
    protected ComplementaryColorPanel complementaryColorPanel;

    protected JSlider hueSlider;
    protected JSlider saturationSlider;
    protected JSlider brightnessSlider;

    protected JLabel hueValueLabel;
    protected JLabel saturationValueLabel;
    protected JLabel brightnessValueLabel;

    protected JPanel colorsPanel() {
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(1, 2));
        
        //adding one observer
        originalColorPanel = new OriginalColorPanel(Color.getHSBColor(0, (float) .5, (float) .5));
        originalColorPanel.setPreferredSize(new Dimension(300, 200));
        p.add(SwingFacade.createTitledPanel("Original Color", originalColorPanel));
        Attach(originalColorPanel);
        //end of adding one observer
        
        //adding second Observer
        complementaryColorPanel = new ComplementaryColorPanel(Color.getHSBColor((float) .5, (float) .5, (float) .5));
        complementaryColorPanel.setPreferredSize(new Dimension(300, 200));
        p.add(SwingFacade.createTitledPanel("Complementary Color", complementaryColorPanel));
        Attach(complementaryColorPanel);
        //added second Observer
        
        
        
        return p;
    }
    
    

    protected JPanel mainPanel() {
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(2, 1));
        JPanel colorsPanel = colorsPanel();
        
        JPanel subP = new JPanel();
        subP.setLayout(new GridLayout(3, 1));
        hueSlider = slider();
        subP.add(sliderBox("H", hueSlider, hueValueLabel));
        saturationSlider = slider();
        saturationSlider.setValue(50);
        subP.add(sliderBox("S", saturationSlider, saturationValueLabel));
        brightnessSlider = slider();
        brightnessSlider.setValue(50);
        subP.add(sliderBox("B", brightnessSlider, brightnessValueLabel));
        p.add(subP);
        p.add(colorsPanel);
        return p;
    }

    private JSlider slider() {
        JSlider slider = new JSlider();
       slider.addChangeListener(this);
        
        
        slider.setValue(slider.getMinimum());
        return slider;
    }

    private Box sliderBox(String sliderLabel, JSlider slider, JLabel valueLabel) {
        if (valueLabel == null) {
            valueLabel = new JLabel();
            valueLabel.setFont(SwingFacade.getStandardFont());
            valueLabel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
            valueLabel.setForeground(java.awt.Color.black);
        }
        Box b = Box.createHorizontalBox();
        JLabel label = new JLabel(sliderLabel);
        label.setFont(SwingFacade.getStandardFont());
        label.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
        label.setForeground(java.awt.Color.black);
        b.add(label);
        b.add(valueLabel);
        b.add(slider);
        b.setPreferredSize(new Dimension(600, 50));
        return b;
    }

   


    public void stateChanged(ChangeEvent e) {
        if (hueSlider != null && saturationSlider != null && brightnessSlider != null) {
            float newHue = (float) hueSlider.getValue() / 100;
            float newSaturation = (float) saturationSlider.getValue() / 100;
            float newBrightness = (float) brightnessSlider.getValue() / 100;
            Color newColor = Color.getHSBColor(newHue, newSaturation, newBrightness);
            float complementaryHue = newHue - (float) 0.5;
            if (complementaryHue < 0) {
                complementaryHue = complementaryHue + 1;
            }
            Color complementaryColor = Color.getHSBColor(complementaryHue, newSaturation, newBrightness);
//            this.originalColorPanel.setColor(newColor);
//            this.complementaryColorPanel.setColor(complementaryColor);
            this.Notify(newColor, complementaryColor);
            

        }
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
	public void Notify(Color newCol, Color comtempCol) {
		// TODO Auto-generated method stub
		for (Observer o : this.observers) {
			o.Update(newCol, comtempCol);
		}
	}
}
    
