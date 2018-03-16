package airportSecurityState.driver;

import airportSecurityState.AirportContext;
import airportSecurityState.util.FileProcessor;
import airportSecurityState.util.MyLogger;
import airportSecurityState.util.Results;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;

public class Driver {
	public static void main(String[] args) throws IOException {
		//To check valid command line arguments
		if (args.length != 3) {
			System.err.println("Invalid arguments. Provide <input.txt> " + "<output.txt" + "<DebugLevel>");
			System.exit(1);
		}
		//To check if the file is empty or not present
		File file = new File(args[0]);
		if (file.length() == 0) {
			System.err.println("Input file is empty or missing");
			System.exit(1);
		}

		Results results = new Results(args[1]);
		AirportContext inputParams = new AirportContext(results);
		MyLogger.setDebugValue(Integer.parseInt(args[2]));
		
		String line;

		try {
			FileProcessor processor = new FileProcessor(args[0]);
			while ((line = processor.readLine()) != null) {
				inputParams.lineProcessing(line);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		results.closeFile();
	}
}