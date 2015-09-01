import java.io.*;

public class Reverse {
	public static void main(String[] args) {
	
		String file = "audio.dat";
		String line = null;
		
		try {
			FileReader fileReader =
				new FileReader(file);
			BufferedReader linecountReader =
				new BufferedReader(fileReader);

			PrintWriter writer = new PrintWriter(file + "_reverse");
			
			int numLines = 0;
			while((line = linecountReader.readLine()) != null) {
				numLines++;
			}

			String dataArr[] = new String[numLines + 1];

			fileReader = new FileReader(file);

			BufferedReader bufferedReader = 
				new BufferedReader(fileReader);

			int i = 0;
			while((line = bufferedReader.readLine()) != null) {
	
				if (line == null || line.length() <= 0) {
					System.out.println("Null or 0 length line");
				} else if (line.length() >= 18) {
					dataArr[numLines - i] = line.substring(18);
					i = i + 1;
				}
			}

			fileReader = new FileReader(file);

			BufferedReader writeBuffer = 
				new BufferedReader(fileReader);

			i = 0;
			while((line = writeBuffer.readLine()) != null) {
	
				if (line == null || line.length() <= 0) {
					System.out.println("Null or 0 length line");
				} else if (line.length() >= 18) {
					writer.println(line.substring(0, 17) + dataArr[i]);	
					i = i + 1;
				}
			}
			writer.close();


			bufferedReader.close();
		}	

		catch(FileNotFoundException ex) {
			System.out.println("Error - file not found");
		}
		catch(IOException ex) {
			System.out.println("Error reading file");
		}
	}
}
