package first;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Tree extends JFrame{

	public static void main(String[] args) {
		new Tree();
	}
	
	public Tree(){
		add(new View());
		setTitle("Tree");
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	    setSize(450, 550);
	    setLocationRelativeTo(null);
	    setVisible(true);
	    setResizable(true);
	}
	
	
}
