package ru.ischenko.logic;

import java.util.Vector;

public class Filial {
/**
 * Filial class responsible for containing basic information about filial's netowrks,
 * i.e. it contains Networks instances as attributes 
 */
	private String name;
	private Vector<String> locations = new Vector<String>(); 
	private Vector<Network> deck = new Vector<Network>();
	/////////////////////////////////////////////////////////////////////////////////////
	public String 			getName		( ) 						{ return name; 						}
	public void 			setName		( String name )				{ this.name = name;					}
	public Vector<Network>	getDeck		( )							{ return deck;						}
	public void 			setDeck		( Vector<Network> deck )	{ this.deck = deck;					}
	public void				addToDeck	( Network net )				{ deck.add(net);					}
	public void				delFromDeck	( Network net )				{ deck.remove(net);					}
	public Vector<String>	getLocations( )							{ return locations;					}
	public void				setLocations( Vector<String> locations ){ this.locations = locations;		}
	public void				addLocation	( String location )			{ getLocations().add(location); 	}
	public void				delLocation	( String location )			{ getLocations().remove(location);	}
	public 					Filial		( String name ) 			{ super(); setName(name);			}
	/////////////////////////////////////////////////////////////////////////////////////
	@Override 
	public String toString() {
		StringBuilder outbuff 	= new StringBuilder( );
		outbuff					.append	( String.format( "%-44.44s\n--------------------------------------------\n", getName( ) ) );
		deck					.forEach( net -> outbuff.append( net.toString() + "\n" ) );
		return outbuff.toString();
	}
}
