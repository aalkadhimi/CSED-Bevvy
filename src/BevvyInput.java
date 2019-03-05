import java.io.*;

public class BevvyInput {
	private BufferedReader inputReader;
	
	public BevvyInput() {
		inputReader = new BufferedReader(new InputStreamReader(System.in));
	}
	
	public String readCommand() {
		String command = "";
		System.out.println("(A)dd data or (R)ead data");
		try {
			command = inputReader.readLine();
		} catch (IOException io) {
			System.out.println("Error reading command from the user");
			System.out.println(io);
		}
		return command;
	}
	
	public DataEntry readEntry() {
		DataEntry newEntry = null;
		try {
			System.out.println("Please enter the date of consumption: ");
	        String date = inputReader.readLine();
	        System.out.println("Please enter the amount consumed: ");
	        String amount = inputReader.readLine();
	        newEntry = new DataEntry(date, amount);
		} catch (IOException io) {
			System.out.println("Error reading data entry");
			System.out.println(io);
		}
		return newEntry;
	}
}
