package Serializacion;

import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class SubjectDeserializeDemo {
	
	public static void main(String[] args) throws IOException, ClassNotFoundException{
		Subject[] subjectArray = new Subject[5];
		int i = 0;
		
		ObjectInputStream file = new ObjectInputStream(
                   				new BufferedInputStream(
                   				new FileInputStream("subjects.out")));
		try {
			while(true) {
				subjectArray[i++] = (Subject)file.readObject();
			}
		} catch (EOFException e) {
			file.close();
		}
		
		for(Subject p: subjectArray) {
			System.out.println(p);
		}
	}
}
