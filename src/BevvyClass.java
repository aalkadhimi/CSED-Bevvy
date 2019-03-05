public class BevvyClass {
	private BevvyStorage storage;
	private BevvyInput input;
	
	public BevvyClass() {
		storage = new BevvyStorage();
		input = new BevvyInput();
	}
	
	private void processCommand(String command) {
		switch (command.charAt(0)) {
		case 'A':
			DataEntry newEntry = input.readEntry();
			if (newEntry != null) {
				storage.addEntry(newEntry);
			}
			break;
		case 'R':
			for (DataEntry entry: storage.readStorage()) {
				System.out.println(entry.getDate() + ": " + entry.getAmount());
			}
			break;
		default:
			System.out.println("Unknown command");
		}
	}
	
	public void run() {
		while (true) {
			String command = input.readCommand();
			processCommand(command);
		}
	}
}
