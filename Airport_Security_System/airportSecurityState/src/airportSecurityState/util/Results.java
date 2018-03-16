package airportSecurityState.util;

import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import airportSecurityState.util.FileDisplayInterface;
import airportSecurityState.util.StdoutDisplayInterface;
import airportSecurityState.util.MyLogger.DebugLevel;

public class Results implements StdoutDisplayInterface, FileDisplayInterface {
	private String FILENAME = "output.txt";
	private String[] results;
	private int index = 0;

	BufferedWriter bWriter = null;
	FileWriter fWriter = null;

	/**
	 * To create an instance to write in output file
	 * @param string
	 */
	public Results(String string) {
		FILENAME = string;
		try {
			fWriter = new FileWriter(FILENAME);
			MyLogger.writeMessage("Result Contructor", DebugLevel.CONSTRUCTOR);
		} catch (IOException e) {
			e.printStackTrace();
		}
		bWriter = new BufferedWriter(fWriter);
	}

	@Override
	public void writeToFile(String inputLine) {

		try {
			bWriter.write(inputLine);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			bWriter.newLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void writeToStdout(String inputLine) {
		System.out.println(inputLine);
	}

	//Helper function to store the output
	public void storeToOutput(String outputValue) {
		results[index++] = (outputValue);
	}
	
	//To close file
	public void closeFile() {
		try {
			bWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
