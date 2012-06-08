package Serializacion;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SubjectSerializeDemo {
	
	public static void main(String[] args) throws IOException{
		Subject[] subjectArray = new Subject[5];
		subjectArray[0] = new Subject("72.1","1");
		subjectArray[1] = new Subject("72.2","2");
		subjectArray[2] = new Subject("72.3","7");
		subjectArray[3] = new Subject("72.4","1");
		subjectArray[4] = new Subject("72.5","15");
		
		ObjectOutputStream file = new ObjectOutputStream(
			      					new BufferedOutputStream(
			      					new FileOutputStream("subjects.out")));
		for(Subject p: subjectArray) {
			file.writeObject(p);
		}
		file.close();
	}
}








