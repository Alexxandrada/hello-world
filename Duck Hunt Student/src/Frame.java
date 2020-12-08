import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Frame extends JPanel implements ActionListener, MouseListener {
	
	//Objects that need to be drawn on the JFrame in the paint method.
	//write the code to create a ground object as one of your instance variables
	Ground foreground = new Ground();
	
	//try same thing w the tree
	Tree tree = new Tree();
	Duck duck = new Duck();
	Dog doggy = new Dog();
	
	// 
	
	
	Music bang = new Music("BANG.wav", false);
	Music ohNo = new Music("OHNO.wav", false);
			
			
			
			
			
		public void paint(Graphics g) {
		foreground.paint(g);
		tree.paint(g);
		duck.paint(g);
		doggy.paint(g);
	
		}
	
	public static void main(String[] arg) {
		Frame f = new Frame();
	}
	
	public Frame() {
		JFrame f = new JFrame("Duck Hunt");
		f.setSize(new Dimension(900, 600));
		f.setBackground(Color.blue);
		f.add(this);
		f.addMouseListener(this);
		f.setResizable(false);
		
		Timer t = new Timer(16, this);
	
		t.start();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

		bang.play(); //plays bang sound when click the duck
		
		if(duck.collide(arg0.getX(), arg0.getY())){
			bang.play();
		
			
		}else if (!duck.collide(arg0.getX(), arg0.getY())) { //when clicked 3 times shows the doc
			
			doggy.setMissed(1);
			
			
		}
		
		if(doggy.youMissed()) {
			doggy.showDog();
			
			ohNo.play(); 
			
		}else {
			doggy.hideDog(); //hides dog
		}
		
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		repaint();
	}

}
