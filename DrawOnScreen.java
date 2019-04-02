import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;
public class DrawOnScreen extends JPanel{
	
	private static ArrayList<Point> points = new ArrayList<>();
	
	public DrawOnScreen(){
	} //constructor

	private void drawPoints(Graphics2D graphics){
		for(int a = 0; a < points.size() - 1; a++){
			graphics.drawLine(points.get(a).x, points.get(a).y, points.get(a+1).x, points.get(a+1).y);
		}
	}

	public void paint(Graphics g){
		super.paint(g);
		this.setBackground(Color.WHITE);
		Graphics2D graphics = (Graphics2D)g;
		graphics.setColor(Color.BLACK);
		
		drawPoints(graphics);
	}

	public static void main(String[] args) throws InterruptedException{
		JFrame frame = new JFrame("Draw On Screen");
		DrawOnScreen app = new DrawOnScreen();
		frame.add(app);
		frame.setSize(1920,1080);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setUndecorated(true);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		while(true){
			frame.repaint();
			Point mouseCurrent = MouseInfo.getPointerInfo().getLocation();
			if(!(mouseCurrent.x == points.get(points.size()-1).x && mouseCurrent.y == points.get(points.size()-1).y)){
				points.add(mouseCurrent);
			}
			Thread.sleep(10);
		}
	} //main
}