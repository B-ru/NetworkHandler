package ru.ischenko.logic;
import ru.ischenko.gui.NHFrame;

public class Application {
/**
 * Application class contain main method
 */
	public static void main(String[ ] args ) {
		new NHFrame( "Network Handler", new ParseNets( ).getNetworks( ) );
	}
}