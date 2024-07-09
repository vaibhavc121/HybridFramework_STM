package utilities;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertFile
{

	public static void main(String[] args) throws IOException
	{
		String filepath = System.getProperty("user.dir") + "\\src\\test\\resources\\configfiles\\config.properties";
		FileReader fr = new FileReader(filepath);
		Properties properties = new Properties();
		properties.load(fr);
		System.out.println(properties.getProperty("browser"));
		System.out.println(properties.getProperty("testurl"));
	}

}
