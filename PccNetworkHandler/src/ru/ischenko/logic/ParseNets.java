package ru.ischenko.logic;

import static ru.ischenko.logic.Constants.Defs.*;

import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseNets {
/**
 * ParseNets parsing data from networks file and populates Vector<Vector<String>>
 */
	private Vector<Vector<String>> networks = new Vector<Vector<String>>();

	public ParseNets() {
		final String FILIAL_PATTERN		="^#([^#]++)$";
		final String LOCATION_PATTERN	="^##([^#]++)$";
		final String NET_PATTERN		="^(\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}/\\d{1,2})";
		
		Pattern filialPattern 		= Pattern.compile(FILIAL_PATTERN);
		Pattern locationPattern 	= Pattern.compile(LOCATION_PATTERN);
		Pattern netPattern			= Pattern.compile(NET_PATTERN);
		
		String[] parsed = {"","",""};		
		
		NetLoader rd = new NetLoader();
		rd.Read()
		.forEach(line->{
			Matcher filialMatcher = filialPattern.matcher(line);
			if (filialMatcher.find()) {
				parsed[FILIAL] = filialMatcher.group(1);
			} else {
				if(parsed[FILIAL].isEmpty()) parsed[FILIAL] = UNKNOWN;
				Matcher locationMatcher = locationPattern.matcher(line);
				if(locationMatcher.find()) {
					parsed[LOCATION] = locationMatcher.group(1);
				} else {
					if(parsed[LOCATION].isEmpty()) parsed[LOCATION] = UNKNOWN;
					Matcher netMatcher = netPattern.matcher(line);
					if(netMatcher.find()) {
						parsed[NETWORK] = netMatcher.group(1);
						Vector<String> parsedNet = new Vector<String>();
						for(int i = 0; i < parsed.length; i++ ) parsedNet.add(parsed[i]);
						parsed[LOCATION] = "";
						parsed[NETWORK] = "";						
						addNetwork(parsedNet);
						String netAddr = parsedNet.get(NETWORK);
						String[] netParts = netAddr.split("/");
						String[] netBytes = netParts[0].split("\\.");
						for(int i = 0; i < netBytes.length; i++) System.out.printf("%4.4s%s",netBytes[i],i==3?"/":".");
						System.out.printf("%2.2s\n",netParts[1]);
					}
				}
			}
		});
	}
	
	public Vector<Vector<String>> getNetworks() {
		return networks;
	}
	
	public void addNetwork(Vector<String> net) {
		getNetworks().add(net);
	}
	
}
