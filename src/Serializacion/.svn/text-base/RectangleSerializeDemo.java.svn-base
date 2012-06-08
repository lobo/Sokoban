package Serializacion;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class RectangleSerializeDemo {
	
	public static void main(String[] args) throws IOException{
		Rectangle[] rectArray = new Rectangle[5];
		rectArray[0] = new Rectangle(3,1,1,2,3);
		rectArray[1] = new Rectangle(2,2,1,2,3);
		rectArray[2] = new Rectangle(5,7,1,2,3);
		rectArray[3] = new Rectangle(-2,1,1,2,3);
		rectArray[4] = new Rectangle(32,15,1,2,3);
		
		ObjectOutputStream file = new ObjectOutputStream(
			      					new BufferedOutputStream(
			      					new FileOutputStream("rectangles.out")));
		for(Rectangle p: rectArray) {
			file.writeObject(p);
		}
		file.close();
	}
}








