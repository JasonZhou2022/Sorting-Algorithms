//Jason Zhou
//Mr. Mouradov
//AP CS Lv 1
// 3/14/21

//importing libraries for future reference
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;

//rectangle class for making rectangles on the Custom Panel
public class Rectangle implements Comparable {
	
	//Mouradov just has a color and a y value
	
	/*
	int x1, y1, width, height;
	Color c;
	static int currentX = 0;
	static int currentY = 0;
	static int rValue = 0;
	*/
	
	//creating class variables for future use
	private Color c;
	private int y;
	private boolean selected;
	private boolean swap;
	private static int swapCount = 0;
	private static int delay = 0;
	
	

	

	

	public Rectangle() //default constuctor for the Rectangle object, sets the corner coordinates for the shape
	{
		//makes a square
		y = 0;
		c = new Color(0, 0, 0);
		selected = false;
		swap = false;
		swapCount = 0;
		delay = 1000;
		
	}
	
	public Rectangle(int y, Color c) //constructor for simply adding rectangles
	{
		this.y = y;
		this.c = c;
		selected = false;
		swap = false;
		delay = 1000;
		swapCount = 0;
		//currentX += width;
	}
	
	public Rectangle(int y, Color c, boolean selected, boolean swap, int delay, int swapCount) //all parameter constructor for the Rectangle class
	{
		this.y = y;
		this.c = c;
		this.selected = selected;
		this.swap = swap;
		this.swapCount = swapCount;
		this.delay = delay;
	}

	public static int getDelay() { //getter that gets the delay static variable
		return delay;
	}

	public Color getC() { //getter that gets the Color of the rectangle object
		return c;
	}

	public int getY() { //getter that gets the y-coordinate of the rectangle object
		return y;
	}
	
	public static int getSwapCount() { //getter that gets the variable "swapCount"
		return swapCount;
	}

	public boolean isSwap() { //getter that gets the variable "swap"
		return swap;
	}
	
	public boolean isSelected() { //getter that gets the variable "selected"
		return selected;
	}

	public void setY(int y) { //setter that sets the y-coordinate of the rectangle object
		this.y = y;
	}	

	public void setSelected(boolean selected) { //setter that sets the variabke "selected"
		this.selected = selected;
	}	

	public void setSwap(boolean swap) { //setter that sets the variable "swap"
		this.swap = swap;
	}
	
	public void setC(Color c) { //setter that sets the color of the rectangle object
		this.c = c;
	}
	
	public static void setSwapCount(int swapCount) { //setter that sets the variable "swapCount"
		Rectangle.swapCount = swapCount;
	}
	
	public static void setDelay(int delay) { //setter that sets the delay static variable
		Rectangle.delay = delay;
	}
	
	public void flash(JFrame frame, Rectangle other) //causes the rectangle to flash
	{
		
		for (int i = 0; i < 6; i++) //repeats the flashing process a total of six times
		{
			this.swap = !swap; //switches the swap variable from false to true and vice versa
			other.setSwap(!other.isSwap()); //switches the swap variable from false to true and vice versa
			frame.repaint(); //refreshes the page so the see can see the flashing
			
			try { //delays the code by 1/10th of a second
				Thread.sleep(delay);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		swapCount++; //increases swapCount by 1
		
	}
	
	@Override
	public int compareTo(Object arg0) { //creates a way to compare rectangles, compares by their r-value for their color
		// TODO Auto-generated method stub
		
		if (this.c.getRed() > ((Rectangle)arg0).getC().getRed())
			return 1;
		else if (this.c.getRed() < ((Rectangle)arg0).getC().getRed())
			return -1;
		else
			return 0;
		
	}
	
	
	
	

}
