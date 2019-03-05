import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class BevvyStorage {
	private String storageFile;
	
	private BufferedWriter writer;
	private BufferedReader reader;
	
	public BevvyStorage() {
		storageFile = "storage.csv";
		writer = null;
		reader = null;
	}
	
	public void addEntry(DataEntry newEntry) {
		try {
			writer = new BufferedWriter(new FileWriter(storageFile, true));
			writer.write(newEntry.getDate() + ",");
			writer.write(newEntry.getAmount() + ",\n");
		} catch (IOException io) {
			System.out.println("Error writing new entry");
			System.out.println(io);
		} finally {
			try {
				writer.close();
			} catch (IOException closeError) {
				System.out.println("Error closing file stream");
				System.out.println(closeError);
			}
		}
	}
	
	private DataEntry fromString(String line) {
		String elements[] = line.split(",");
		DataEntry newEntry = new DataEntry(elements[0], elements[1]);
		return newEntry;
	}
	
	public List<DataEntry> readStorage() {
		List<DataEntry> entries = new ArrayList<DataEntry>();
		try {
			reader = new BufferedReader(new FileReader(storageFile));
			String entryLine = null;
			while ((entryLine = reader.readLine()) != null) {
				DataEntry newEntry = fromString(entryLine);
				entries.add(newEntry);
			}
		} catch (IOException io) {
			System.out.println("Error reading entries from the file");
			System.out.println(io);
		} finally {
			try {
				reader.close();
			} catch (IOException closeError) {
				System.out.println("Error closing file stream");
				System.out.println(closeError);
			}
		}
		
		return entries;
	}
}
