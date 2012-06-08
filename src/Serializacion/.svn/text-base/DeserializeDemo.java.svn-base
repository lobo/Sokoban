package Serializacion;

import java.awt.Point;
import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializeDemo {
	
	public static void main(String[] args) throws IOException, ClassNotFoundException{
		Point[] pointArray = new Point[5];
		int i = 0;
		
		ObjectInputStream file = new ObjectInputStream(
                   				new BufferedInputStream(
                   				new FileInputStream("points.out")));
		try {
			while(true) {
				pointArray[i++] = (Point)file.readObject();
			}
		} catch (EOFException e) { //ESTO FUNCIONA PERO ESTA MAL DISEÑADO!!
			file.close();
		}
		
		for(Point p: pointArray) {
			System.out.println(p);
		}
	}
}
