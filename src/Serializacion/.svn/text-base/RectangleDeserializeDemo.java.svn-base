package Serializacion;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class RectangleDeserializeDemo {
	
	public static void main(String[] args) throws IOException, ClassNotFoundException{
		Rectangle[] rectArray = new Rectangle[5];
		
		ObjectInputStream file = new ObjectInputStream(
                   				new BufferedInputStream(
                   				new FileInputStream("rectangles.out")));
		
		for (int i= 0; i< 5; i++) {
				rectArray[i] = (Rectangle)file.readObject();
		}
		file.close();
		
		for(Rectangle p: rectArray) {
			System.out.println(p);
		}
	}
}
