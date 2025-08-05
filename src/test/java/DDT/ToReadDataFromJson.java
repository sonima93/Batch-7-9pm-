package DDT;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ToReadDataFromJson {

	public static void main(String[] args) throws IOException, ParseException {
		// TODO Auto-generated method stub
FileReader fir=new FileReader(".\\src\\test\\resources\\CommonData1.json");
JSONParser parser=new JSONParser();

//convert physical file to java obj

Object javaobj=parser.parse(fir);

	

	

	//typecasting
	JSONObject obj=(JSONObject) javaobj;
	
	//reading data
	String BROWSER=obj.get("BROWSER").toString();
	System.out.println(BROWSER);
	
	
}
}