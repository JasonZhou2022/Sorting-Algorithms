//Jason Zhou
//Mr. Mouradov
//AP CS Lv 1
// 3/14/21

//importing libraries for future use
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Arrays;

public class CustomPanel extends JPanel { //class that creates the panel for the frame, also extends the JPanel class

	//creating class variables for later reference
	private Rectangle[] arr;
	private int width;
	private int height;
	private int heightLimit;
	
	public CustomPanel() //default Constructor for the CustomPanel class
	{
		arr = new Rectangle[5];
		for (int i = 0; i < arr.length; i++)
			arr[i] = new Rectangle();
		height = 100;
		width = 100;
		heightLimit = 400;
	}
	
	public CustomPanel(Rectangle[] arr, int width, int height, int rectangleHeightLimit) //all parameter constructor of the Custom Panel class
	{
		//sets all of the variables
		this.arr = arr;
		this.width = width;
		this.height = height;
		this.heightLimit = rectangleHeightLimit;
	}
	
	
	public void paintComponent(Graphics g) //paints the frame
	{
		//Color c;
		//g.setFont(font); <-- use this to change the border size, find a font object to put in
		super.paintComponent(g); //calls the parent class's paintcomponenet method
		
		//changes the color to cyan and makes a rectangle to show the background as cyan
		g.setColor(Color.CYAN);
		g.fillRect(0, 0, width, height);
		
		for (int i = 0; i < arr.length;i++) //iterates through the array that holds all of the rectangles
		{
			
			g.setColor(arr[i].getC()); //sets the color of the pen
			g.fillRect(0, arr[i].getY(), width, heightLimit/ arr.length); //draws a filled in rectangle at the rectangle's y-coordinate
			
		}
		
		for (int i = 0; i < arr.length;i++) //iterates through the array that holds all of the rectangles
		{
			if (arr[i].isSelected()) //if the rectangle's variable is selected, then set the color to yellow and draw a yellow outline to show that it is selected
			{
				g.setColor(Color.yellow); //sets the pen to yellow
				g.drawRect(0, arr[i].getY(), width, heightLimit/ arr.length); //draws the yellow rectangle
			}
		}
		
		for (int i = 0; i < arr.length; i++)  //iterates through the array that holds all of the rectangles
			if (arr[i].isSwap()) //if the swap variable for a rectangle object is true, then swap them
			{
				g.setColor(Color.green); //sets the color to green
				g.drawRect(0, arr[i].getY(), width, heightLimit/ arr.length); //draws a green rectangle that serves as an outline
				
				for (int j = 1; j <= 8; j++) //repeats the inside code a total of 8 times
				{
					g.drawLine(j * (width / 8), (heightLimit * i / arr.length), j * (width / 8), heightLimit * (i + 1) / arr.length); //draws a horizontal line
					//draws a vertical line
					g.drawLine(0, (heightLimit * i / arr.length) + (heightLimit * j / (8 * arr.length)), width, (heightLimit * i / arr.length) + (heightLimit * j / (8 * arr.length)));
					 
				}
				
			}
		
		g.setFont(new Font("Arial", Font.ITALIC, 15)); //sets the fond
		g.setColor(Color.black);//sets the color to black
		g.drawString("Swap Count: " + Rectangle.getSwapCount(), 0, heightLimit + 20); //makes a text that tells the reader how many swaps they have
		g.drawString("Number Of Boxes: " + arr.length, 0, heightLimit + 40); //makes a text that tells the reader how many swaps they have
				
		
		
			
	}

	public Rectangle[] getArr() {//getter that gets the array
		return arr;
	}

	public int getWidth() { //getter that gets the width of the array
		return width;
	}

	public int getHeight() { //getter that gets the height of the array
		return height;
	}

	public int getHeightLimit() { //getter that gets the heightLimit of the array
		return heightLimit;
	}
	
	public void setArr(Rectangle[] arr) { //setter that sets the array for the CustomPanel object
		this.arr = arr;
	}

	public void setWidth(int width) { //setter that sets the width for the CustomPanel object
		this.width = width;
	}

	public void setHeight(int height) { //setter that sets the height for the CustomPanel object
		this.height = height;
	}

	public void setHeightLimit(int heightLimit) { //setter that sets the heightLimit for the CustomPanel object
		this.heightLimit = heightLimit;
	}
	
	
	
}
