
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Sliders extends JFrame { //panneau de déplacement d'unité
	  private JLabel label = new JLabel("Valeur actuelle : 1");  //initialisation valeur 
	  private int resultat;
	  public Sliders(int a, int b){
		JButton button = new JButton("valider");
	    this.setSize(250, 150);
	    this.setTitle("Slider");
	    this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    JSlider slide = new JSlider();
	   
	    slide.setMaximum(b);
	    slide.setMinimum(a);
	    slide.setValue(1);
	    slide.setPaintTicks(true);
	    slide.setPaintLabels(true);
	    slide.setMinorTickSpacing(1);
	    slide.setMajorTickSpacing(1);
	    slide.addChangeListener(new ChangeListener(){

		public void stateChanged(ChangeEvent event){
	        label.setText("Valeur actuelle : " + ((JSlider)event.getSource()).getValue());
	        setResultat(((JSlider)event.getSource()).getValue());
	        button.addMouseListener(new java.awt.event.MouseAdapter(){
	            public void mousePressed(MouseEvent e){
	              slide_mousePressed(e);
	            }
	          });
	        
	      }
	    });      
	    this.getContentPane().add(slide, BorderLayout.NORTH);
	    this.getContentPane().add(label, BorderLayout.CENTER);     
	    this.getContentPane().add(button, BorderLayout.SOUTH);

	    
	  }   
	  void slide_mousePressed (MouseEvent e) {
		    // Enregistre quel bouton de la souris est enfoncé.
		    int button = e.getButton();
		 
		    if (button == MouseEvent.BUTTON1) {
		           // Bouton GAUCHE enfoncé
		    		dispose();
		    } else if(button == MouseEvent.BUTTON2) {
		           // Bouton du MILIEU enfoncé
		    } else if(button == MouseEvent.BUTTON3) {
		           // Bouton DROIT enfoncé
		    }
		 }
	  public int getResultat() {
		return resultat;
	}

	public void setResultat(int resultat) {
		this.resultat = resultat;
	}
	  
	  
}


