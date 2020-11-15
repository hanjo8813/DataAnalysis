package kr.ac.sejong.data_analysis.first_project;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class App {
	public static void main(String[] args) throws IOException {

		BufferedReader r = new BufferedReader(new FileReader("d:\\tdata.txt"));
		ArrayList<Message> data = new ArrayList<Message>();
		
		while (true) {
			String line = r.readLine();
			if (line == null)
				break;
			String[] arr = line.split("\\s");
			data.add(new Message(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]), Long.parseLong(arr[2])));
		}
		r.close();
		
		for(Message m : data) {
			System.out.println(m);
		}

	}
}
