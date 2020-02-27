package fr.abm.quiz_manager.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configuration {

	public Properties properties;
	
	private static Configuration configuration = null;
	
	private Configuration() {
		File file = new File("quiz.properties");
		try {
			this.properties = new Properties();
			this.properties.load(new FileInputStream(file));
		} catch (IOException e) {
			System.out.println("Erreur lors de l'acces au fichier properties : " + e.getMessage());
		}
	}
	
	public static Configuration getInstance() {
		if (configuration == null) {
			configuration = new Configuration();
		}
		return configuration;
	}
	
	
	public String getPropertyValue(String key) {
		return this.properties.getProperty(key);
	}
	
}
