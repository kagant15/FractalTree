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
	
	Color[] colors = new Color[6];				//Array of colors for branches
 	Stroke drawingStroke = new BasicStroke(12); //Line thickness
 	
	public void paint(Graphics g)
    {
      Graphics2D panel = (Graphics2D) g;
      
      //HANDLES RENDERING --- MAKES THE PICTURE LOOK NICE, SMOTHER AND MORE FLUSH
      RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
      				 rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
      panel.setRenderingHints(rh);
      
      //Set the thickness of the stroke
      panel.setStroke(drawingStroke);
      
	  colors[0]=Color.RED;
	  colors[1]=Color.BLUE;
	  colors[2]=Color.GRAY;
	  colors[3]=Color.YELLOW;
	  colors[4]=Color.BLACK;
	  colors[5]=Color.ORANGE;
      
	  //Draw the trunk
	  panel.drawLine(250, 380, 250, 300);
	  
	  //Makes the fractal tree
      makeTree(3, 3, 250, 300, panel);
      
    }//End of paint method
	
	/**
	 * This is the fractal algorithm that generates the branches of a tree.
	 * @param B		The number of branches at each level
	 * @param level	The number branch levels.  The number of generations
	 * @param x1	The starting X coordinate
	 * @param y1	The starting Y coordinate
	 * @param panel The graphics 2D object that the lines are to be drawn to
	 */
    public void makeTree(int B, int level, int x1, int y1, Graphics2D panel){
    	if(level==0){
    		return;
    	}
    	
    	//The angle range between the branch and the horizon
    	double theta=Math.PI/B;
    	
    	//The length of the branch
    	double length=Math.random()*(level*2)+(20*level);
    
    	//Make the branches
    	for(int branchNumber=0; branchNumber<B; branchNumber++){
    		double beta=theta*branchNumber;
    	 
    		//Calculates the ending X and Y coordinates for the branch
    		int x2=(int) (x1+length*Math.cos(Math.random()*theta+beta));
    		int y2=(int) (y1-length*Math.sin(Math.random()*theta+beta));
    	 
    		//Determine and set the color of the branch
    		if(branchNumber==0){
    			panel.setColor(colors[1]);//blue
    		}
    		else if(branchNumber==1){
    			panel.setColor(colors[2]);//grey
    		}
    		else{
    			panel.setColor(colors[4]);//black
    		}
    		
    		//Set thickness of the branch
    		Stroke drawingStroke = new BasicStroke(level*2);
    	 	panel.setStroke(drawingStroke);
    	 
    	 	//draw line
    	 	panel.drawLine(x1, y1, x2, y2);
    	
    	 	//Recursive call
    	 	makeTree(B, level-1, x2, y2, panel);
    	}
    	
   }//end of makeTree()
	
	
}
