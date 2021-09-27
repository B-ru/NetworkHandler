package ru.ischenko.logic;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class NetLoader{
/**
 * NetLoader class responsible for load of the PCC's networks from file into the program.
 */
	private final static String DEFAULT_NETWORKS_FILE	= "networks.txt";
	private String path;

	public Stream<String> Read(){
		try{
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(new FileReader(DEFAULT_NETWORKS_FILE));
			return br.lines();
		} catch (FileNotFoundException e) {
			try {
				getPath();
				try(BufferedReader br = new BufferedReader(new FileReader(path+DEFAULT_NETWORKS_FILE))){
					return br.lines();
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		return null;				
	}

	private void getPath() throws FileNotFoundException, IOException {
		String netPattern = "^networks=(.*)$";
		Pattern pattern = Pattern.compile(netPattern);
		try (BufferedReader r = new BufferedReader ( new FileReader("PCCNH.ini") )) {
			r.lines().forEach(line -> {
					Matcher matcher = pattern.matcher(line);
					if (matcher.find()) {
						this.path= matcher.group(1);
					}
				}
			);
		}
	}
}