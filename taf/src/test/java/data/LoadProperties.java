package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoadProperties {

	
	
public static Properties userData = loadProperties("C:\\Users\\moha2\\Desktop\\Selenuim Course\\Selenuim Course\\Projects\\taf\\src\\main\\java\\properties\\userdata.properties");


private static Properties loadProperties(String path) {
	Properties pro = new Properties();
	try {
		FileInputStream stream = new FileInputStream(path);
		try {
			pro.load(stream);
		} catch (IOException e) {
			System.out.println("Error "+ e.getMessage());
					
		}
		
		
		
	} catch (FileNotFoundException e) {
		System.out.println("Error "+ e.getMessage());
	}
	
	
	return pro;
	
}


}
