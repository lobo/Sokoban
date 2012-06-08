package Serializacion;

import java.awt.Point;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializeDemo {
	
	public static void main(String[] args) throws IOException{
		Point[] pointArray = new Point[5];
		pointArray[0] = new Point(3,1);
		pointArray[1] = new Point(2,2);
		pointArray[2] = new Point(5,7);
		pointArray[3] = new Point(-2,1);
		pointArray[4] = new Point(32,15);
		
		ObjectOutputStream file = new ObjectOutputStream(
			      					new BufferedOutputStream(
			      					new FileOutputStream("points.out")));
		for(Point p: pointArray) {
			file.writeObject(p);
		}
		file.close();
	}
}








