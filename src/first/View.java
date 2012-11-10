package first;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Stroke;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class View extends JPanel{
	
	Color[] colors = new Color[6];

 	Stroke drawingStroke = new BasicStroke(12);
 	
	public void paint(Graphics g)
    {
      super.paint(g);

      Graphics2D panel = (Graphics2D) g;
      panel.setStroke(drawingStroke);
      //HANDLES RENDERING --- MAKES THE PICTURE LOOK NICE, SMOTHER AND MORE FLUSH
      RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
      rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
      panel.setRenderingHints(rh);
 
	  	 colors[0]=Color.RED;
	  	 colors[1]=Color.BLUE;
	  	 colors[2]=Color.GRAY;
	  	 colors[3]=Color.YELLOW;
	  	 colors[4]=Color.BLACK;
	  	 colors[5]=Color.ORANGE;
      
	  panel.drawLine(250, 380, 250, 300);	 
      makeTree(panel, 4, 4, 250, 300);
      
    }
	
    public void makeTree(Graphics2D panel, int B, int level, int x1, int y1){
    	if(level==0){
    		return;
    	}
    	int c=1;
    		
    	double theta=Math.PI/B;
    	double length=Math.random()*(level * 2)+60;
    
    	//make the branches
    	for(int i=0; i<=B-1; i++){
    	 double beta=theta*i;
    	 
    	 int x2=(int) (x1+length*Math.cos(Math.random()*theta+beta));
    	 int y2=(int) (y1-length*Math.sin(Math.random()*theta+beta));
    	 
    	 if(c==1){
    		 panel.setColor(colors[1]);//blue
    		 c=2;
    	 }
    	 else if(c==2){
    		 panel.setColor(colors[2]);//grey
    		 c=3;
    	 }
    	 else{
    		 panel.setColor(colors[4]);//black
    		 c=1;
    	 }
    	 Stroke drawingStroke = new BasicStroke(level*2);
    	 panel.setStroke(drawingStroke);
    	 panel.drawLine(x1, y1, x2, y2);
    	
    	 makeTree(panel, B, level-1, x2, y2);
    	}
   }//end of makeTree()
	
	
}
