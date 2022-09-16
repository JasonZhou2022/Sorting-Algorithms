//Jason Zhou
//Mr. Mouradov
//AP CS Lv 1
// 3/14/21

//importing libraries
import java.awt.Color;
import java.util.Arrays;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class SortLab {

	public static void main(String[] args) { //runs the main logic of the color sorter code
		// TODO Auto-generated method stub

		//setting up the J-Frame
		JFrame frame = new JFrame();
		
		
		//creating array of Strings in order to give the user multiple options for input in the future
		String[] choices = {"Selection Sort", "Bubble Sort", "Insertion Sort"};
		String[] choices2 = {"Random", "Reverse"};
		String[] yOn = {"Yes", "No"}; //yOn stands for "yes or no", this will give the user the option of whether they want to play again
		//Integer numOfRect = (Integer) JOptionPane.showMessageDialog(frame, "How Many Rectangles Would You Like To Sort?", "Input", JOptionPane.INFORMATION_MESSAGE);
		
		
		//establishing variables for future use
		frame.setSize(200, 520); //sets the size
		frame.setVisible(true); //sets the visibility(whether you can see it or not)
		frame.setResizable(false); //decides whether the window is resizable
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Visual Sort");
		Rectangle[] rect;
		CustomPanel panel = null;
		String playAgain = null;
		Integer numOfBoxes = 0;
		boolean error = false;
		Integer delay = Rectangle.getDelay();
			
		do //repeat the main logic as long as the user selects "Yes" and wants to keep using the program
		{
			if (playAgain != null) //if the playAgain String is not null, then remove the current panel and reset the swap counter
			{
				frame.getContentPane().remove(panel); //removes the panel
				Rectangle.setSwapCount(0); //resets the swap counter
			}
				

			//gets the user input for how many boxes they want, if they want it in random or reverse order, and what type of sort they want
			
			do //if the user has inputed an invalid number, then give them an error and have them try again
			{
				if (error) //if there is an error, then give the user an error and switch this variable to false
				{
					JOptionPane.showMessageDialog(null, "Your Input Was Invalid! Please Try Again!");
					error = false;
				}
					
				
				numOfBoxes = Integer.parseInt(JOptionPane.showInputDialog("How Many Boxes Would You Like To Sort?")); //asks the user for input
				
				if (numOfBoxes <= 0) //if the numOfBoxes is less than or equal to zero, then switch 'error' to true
					error = true;
			}while(error); //if the user has inputed an invalid number, then give them an error and have them try again
			
			//numOfBoxes = Integer.parseInt(JOptionPane.showInputDialog("How Many Boxes Would You Like To Sort?"));
			String rOr = (String) JOptionPane.showInputDialog(frame, "Would You Like The Boxes to be Random?", "Input", JOptionPane.QUESTION_MESSAGE, null, choices2, choices2[0]);
			String typeSort = (String) JOptionPane.showInputDialog(frame, "What Type Of Sort Would You Like To Use?", "Input", JOptionPane.QUESTION_MESSAGE, null, choices, choices[0]);
			
			rect = new Rectangle[numOfBoxes]; //makes a new array of rectangles
			for (int i = 0; i < rect.length; i++) //iterates through the "rect" array and assigns new rectangle objects to each reference variable
				rect[i] = new Rectangle((frame.getHeight() - 120) / rect.length * i, new Color((int)(256* Math.random()), 0 ,0));
			
			panel = new CustomPanel(rect, frame.getWidth(), frame.getHeight(), frame.getHeight() - 120); //creates the panel object for the screen
			
			do //if the user has inputed an invalid number, then give them an error and have them try again
			{
				if (error) //if there is an error, then give the user an error and switch this variable to false
				{
					JOptionPane.showMessageDialog(null, "Your Input Was Invalid! Please Try Again!");
					error = false;
				}
					
				
				delay = Integer.parseInt(JOptionPane.showInputDialog("What Would You Like the Delay To Be?"));
				
				if (delay <= 0) //if the Rectangle.getDelay() is less than or equal to zero, then switch 'error' to true
					error = true;
			}while(error); //if the user has inputed an invalid number, then give them an error and have them try again
			
			Rectangle.setDelay(delay); //sets the delay
			
			
			//for (int i = 0; i < rect.length; i++) //iterates through the rectangle array
				//System.out.println(rect[i].getC().getRed()); //
			
			
				
			
			frame.getContentPane().add(panel); //adds myPicture to the frame
			frame.setVisible(true); //sets the visibility(whether you can see it or not)
			//frame.setVisible(true); //sets the visibility(whether you can see it or not)
			//close, then open, or repaint
			
			if (rOr.equals("Reverse")) //if the user wants the colors to start reversed, then reverse bubble sort the rectangles and repaint the array
			{
				reverseBubbleSort(rect, frame); //sorts the rectangles into reverse order
				frame.repaint(); //repaints the screen
			}
			
			if (typeSort.equals("Selection Sort")) //if the user chose selection sort, then run the selection sort method
			{
				selectionSort(panel.getArr(), frame);
			}
			else if (typeSort.equals("Bubble Sort"))  //if the user chose bubble sort, then run the bubble sort method
			{
				bubbleSort(panel.getArr(), frame);
			}
			else if (typeSort.equals("Insertion Sort"))  //if the user chose bubble sort, then run the bubble sort method
			{
				insertionSort(panel.getArr(), frame);
			}
				
			frame.setVisible(true); //sets the visibility(whether you can see it or not)
			frame.repaint(); //repaints the screen
			
			//asks the player if they would like to play again and records their response
			playAgain = (String) JOptionPane.showInputDialog(frame, Rectangle.getSwapCount() + " Swaps were made.\nWould You Like To Play Again?", "Input", JOptionPane.QUESTION_MESSAGE, null, yOn, yOn[0]);
			
			
			
		}while(playAgain.equals("Yes")); //repeat the main logic as long as the user selects "Yes" and wants to keep using the program
		
		
	}
	
	public static void selectionSort(Rectangle[] arr, JFrame frame) //this method sorts the array in a selection sort fashion
	{
		//arr[0].setC(Color.blue);
		
		
		
		for (int i = 0; i < arr.length - 1; i++) //iterates through the array all teh way until the second to last element
		{
			arr[i].setSelected(true); //switches the rectangle object's "selected" variable to true
			frame.repaint(); //repaints the screen
			
			Rectangle min = arr[i];  //records the first rectangle in the array as the minumum
			int minSpot = i;
			for (int j = i + 1; j < arr.length; j++) //iterates through the second index of the array all the way until the end
				if (arr[j].compareTo(min) == 1) //if the arr[j] is bigger than the min rectangle, then switch then record their positions and switch them
				{
					min = arr[j];
					minSpot = j;
				}
			
			try {
				Thread.sleep(Rectangle.getDelay()); //delays the code by 1 second
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			swap(arr, i, minSpot, frame); //swaps the two rectangles
			arr[i].setSelected(false); //switches the "selected" variable of the rectangle back to false
			frame.repaint(); //repaints the screen
			

		}
		
		
			
		
	}
	
	public static void reverseBubbleSort(Rectangle[] arr, JFrame frame) //plays an algorithm that sorts the rectangles in a bubble sort fashion
	{
		//establishes methods for later use
		boolean swapped = false;
		int counter = 0;
		do //as long as the list has swapped elements, the bubble sort will keep going
		{
			swapped = false;
			
			for (int i = 0; i < arr.length - 1 - counter; i++) //iterates through the array
			{
				if (arr[i].compareTo(arr[i + 1]) == 1) //if arr[i] is bigger than arr[i + 1], then swap them and turn the "swap" variable to true
				{
					swap(arr, i, i + 1); //swaps the two rectangles
					swapped = true; //switches the variable to true
				}
			}
			counter++; //increases the counter
		}while(swapped); //as long as the list has swapped elements, the bubble sort will keep going
	}
	
	public static void bubbleSort(Rectangle[] arr, JFrame frame) //plays an algorithm that sorts the rectangles in a bubble sort fashion
	{
		boolean swapped = false;
		int counter = 0;
		do //as long as the list has swapped elements, the bubble sort will keep going
		{
			swapped = false;
			
			for (int i = 0; i < arr.length - 1 - counter; i++) //iterates through the array
			{
				arr[i].setSelected(true);  //switches the rectangle object's "selected" variable to true
				frame.repaint();//repaints the frame
				try {
					Thread.sleep(Rectangle.getDelay()); //delays the code by one second
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (arr[i].compareTo(arr[i + 1]) == -1) //if arr[i] is smaller than arr[i+1], then swap them and repaint the frame
				{
					
					swap(arr, i, i + 1, frame); //swaps the two rectangles
					frame.repaint(); //repaints the frame
					//arr[i].setSelected(false); //switches the rectangle object's "selected" variable to false
					swapped = true;
				}
				arr[i].setSelected(false); //switches the rectangle object's "selected" variable to false
				frame.repaint(); //repaints the screen
			}
			counter++; //increases the counter
		}while(swapped);//as long as the list has swapped elements, the bubble sort will keep going
		
		
		//for (int i = 0; i < arr.length; i++)
			//System.out.println(arr[i].getC().getRed());
	}
	
	public static void insertionSort(Rectangle[] arr, JFrame frame) //sorts the array in an insertion sort fashion, basically the arr sorts relative to its already sorted part
	{
		
		//int swapCount = 0; //establishes
		//arr[1].setSelected(true); //switches the rectangle object's "selected" variable to true
        for(int i = 1; i<arr.length;i++) //iterates through the array
        {
        	
        	arr[i].setSelected(true); //switches the rectangle object's "selected" variable to true
        	frame.repaint(); //repaints the screen
        	
        	try { //delays the code by 1 second
				Thread.sleep(Rectangle.getDelay());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
        	arr[i].setSelected(false); //switches the rectangle object's "selected" variable to true
        	
            int spot = i; //records the spot
            while(spot>0 && arr[spot].compareTo(arr[spot-1]) == 1)
            {
            	arr[spot].setSelected(true); //switches the rectangle object's "selected" variable to true
            	frame.repaint();
            	try { //delays the code by 1 second
					Thread.sleep(Rectangle.getDelay());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            	swap(arr, spot, spot - 1, frame); //swaps the elements in the current index and the index ahead of it
            	arr[i].setSelected(false); //switches the "selected" variable of the rectangle back to false
				frame.repaint();
				
                spot--;
            }
            
            /*
            if (arr[spot].compareTo(arr[spot-1]) != 1)
            {
            	arr[spot].setSelected(true); //switches the rectangle object's "selected" variable to true
            	frame.repaint();
            	try { //delays the code by 1 second
					Thread.sleep(Rectangle.getDelay());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
            */
            //System.out.println(Arrays.toString(arr));
        }
 
		
	}
	
	public static void swap(Rectangle[] arr, int spot1, int spot2, JFrame frame) //swaps two elements in an array and repaints it on the graphics window
	{
		
		if (spot1 == spot2) //if the spots are the same, then kick out and do not swap them
			return;
		
		arr[spot1].flash(frame, arr[spot2]); //causes the rectangles in spot1 and spot2 to flash
		
		arr[spot1].setSelected(false); //switches the rectangle object's "selected" variable to false
		
		//swaps the y-coordinates of the rectangles
		int temp = arr[spot1].getY();
		arr[spot1].setY(arr[spot2].getY());
		arr[spot2].setY(temp);
		
		//physically swaps the rectangles in the array
		Rectangle temp2 = arr[spot1];
		arr[spot1] = arr[spot2];
		arr[spot2] = temp2;
		
		
		
		//Rectangle.setSwapCount(Rectangle.getSwapCount() + 1); //increases the amount of swaps
	}
	
	public static void swap(Rectangle[] arr, int spot1, int spot2) //swaps two elements in an array and repaints it on the graphics window
	{ //this is an overloaded version of swap for the convenience of reverse sorting the array
		
		if (spot1 == spot2) //if the spots are the same, then kick out and do not swap them
			return;
		
		//swaps the y-coordinates of the rectangles
		int temp = arr[spot1].getY();
		arr[spot1].setY(arr[spot2].getY());
		arr[spot2].setY(temp);
		
		//physically swaps the rectangles in the array
		Rectangle temp2 = arr[spot1];
		arr[spot1] = arr[spot2];
		arr[spot2] = temp2;
	}
	
	
}
