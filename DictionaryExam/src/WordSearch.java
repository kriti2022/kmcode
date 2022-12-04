import java.util.Properties;
import java.util.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WordSearch {

	public static void main(String[] args) throws Exception {
		FileReader reader = new FileReader("files.properties");
		// File tempFile = new File("text.txt");

		Properties p = new Properties();
		p.load(reader);

		// This method is to check if given file exists
		FileExist("Directory.txt");

		// This method outputs the dictionary in the format asked in the question
		formatDictionary();

	}
	
	public static void FileExist(String path) {
		try {
			Scanner scanFile = new Scanner(new File(path));
			System.out.println("File exists.");
		} catch (FileNotFoundException x) {

			System.out.println("Invalid file name supplied, please try again.");
		}
	}
	
	public static void formatDictionary() {
		// File path is passed as parameter
		File file = new File("Dict_Files\\Dictionary.txt");

		// Note: Double backquote is to avoid compiler
		// interpret words
		// like \test as \t (ie. as a escape sequence)

		// Creating an object of BufferedReader class
		BufferedReader br = null;

		try {
			br = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		// Declaring a string variable
		String st;
		String lastWord = "Initial No Words Read";
		// Condition holds true till
		// there is character in a string
		try {
			while ((st = br.readLine()) != null) {
				String[] tokens = st.split("-");

				if (lastWord.equals(tokens[0])) {
					System.out.println(tokens[1]);
				} else {
					System.out.println(tokens[0]);
					System.out.println(tokens[1]);

				}
				lastWord = tokens[0];

			}
		} catch (IOException e) {

			e.printStackTrace();
		}

	}


//***************************************************************//
	
	public static void name() {
		File f = new File("Dictionary.txt");
		if (!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {

				e.printStackTrace();
			}
		} else {
			System.out.println("File already exists");
		}
	}

	public static void checkfile(File x) {
		boolean exists = x.exists();
		if (exists) {
			System.out.println("File exists.");
		} else {
			System.out.println("File does not exist");
		}
	}

	public static void doesFileExist(String path) {
		Path x = Paths.get(path);
		if (Files.exists(x)) {
			System.out.println("File exists.");
		} else {
			System.out.println("File does not exist");
		}
	}

	

	public static String getMeaning(String word) {
		// File path is passed as parameter
		File file = new File("Dict_Files\\Dictionary.txt");

		// Note: Double backquote is to avoid compiler
		// interpret words
		// like \test as \t (ie. as a escape sequence)

		// Creating an object of BufferedReader class
		BufferedReader br = null;

		try {
			br = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		// Declaring a string variable
		String st;
		Boolean foundMeaning = false;
		// Condition holds true till
		// there is character in a string
		System.out.println(word);
		try {
			while ((st = br.readLine()) != null)
				if (st.contains(word)) {
					String[] tokens = st.split("-");
					foundMeaning = true;
					// Print the string
					System.out.println(tokens[1]);
				}
		} catch (IOException e) {

			e.printStackTrace();
		}
		if (foundMeaning == false) {
			System.out.println("Meaning Not Found");
		}

		return word;

	}
}
	