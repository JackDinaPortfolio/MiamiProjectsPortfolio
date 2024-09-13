import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.imageio.ImageIO;


public class ArtMaker {

	public static void main(String[] args) throws IOException{
		
		makeAsciiArt("happyKnight.png");
		
	}
	
	//This takes an image and creates ascii art, saving
	//it in a text file.
	public static void makeAsciiArt(String filename) throws IOException{
		BufferedImage img = ImageIO.read(new File(filename));
		PrintWriter art = new PrintWriter("art.txt");
		
		int width = img.getWidth();
		int height = img.getHeight();
		//System.out.println(width + "," + height);
		
		//This is just some text arranged based on "brightness"
		//The characters on the left are "dark" because more of 
		//the character is drawn
		String str = "@%#x+=:-. ";
		
		for(int y = 0; y < height; y++ ) {
			for( int x = 0; x < width; x++) {
				Color c = new Color(img.getRGB(x,y)); // upper - left pixel of the image
				
				//Compute brightness as the average of red, green, blue
				int brightness = (c.getRed() + c.getGreen() + c.getBlue()) / 3;
				
				//ceiling(256 / str.length()) will tell us what to divide
				//brightness by to get the right character.
				art.print(str.charAt(brightness/26));
			}// end of one row of pixels
			art.println("");
		}
	
		art.close();
		
	}
	
}
