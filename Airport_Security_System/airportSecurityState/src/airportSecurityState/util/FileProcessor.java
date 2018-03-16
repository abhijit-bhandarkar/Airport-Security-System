package airportSecurityState.util;

import java.io.BufferedReader;
import java.io.IOException;

import airportSecurityState.util.MyLogger.DebugLevel;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class FileProcessor {

	private String inputFile;
	private BufferedReader br;

	/**
	 * Constructs a new FileProcessor which reads from the file specified by
	 * command line input
	 * 
	 * @param inputFile
	 *            name of the file to read
	 * @throws FileNotFoundException
	 */
	public FileProcessor(String inputFile) throws FileNotFoundException {
		this.inputFile = inputFile;
		initializeBufferReader();
		MyLogger.writeMessage("FileProcessor Constructor", DebugLevel.CONSTRUCTOR);
	}

	private void initializeBufferReader() throws FileNotFoundException {
		br = new BufferedReader(new FileReader(inputFile));
	}

	public String readLine() throws IOException {
		return br.readLine();

	}

}