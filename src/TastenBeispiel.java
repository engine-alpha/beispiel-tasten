import ea.*;

public class TastenBeispiel
extends Game 
			//Die Tasten-Interfaces, benutzt um direkt auf Tastendruck zu reagieren
implements TastenLosgelassenReagierbar,
			//Implementiert zusätzlich Ticker, um Multitasking für zu ermöglichen.
			//Wird benutzt, um die Figur kontinuierlich zu bewegen.
			Ticker {

	/**
	 * Die Spielfigur, die wir bewegen werden.
	 *  (muss natürlich instanziiert werden)
	 */ 
	private Rechteck figur;

	/**
	 * Konstruktor. Initiiert das Demo-Projekt.
	 */
	public TastenBeispiel() {
		super();
		
		//Spielfigur erstellen und sichtbar machen.
		figur = new Rechteck(100, 100, 60, 60);
		figur.farbeSetzen("Blau");
		wurzel.add(figur);
		
		//Diese Klasse für die Tasten-Interfaces anmelden, damit 
		//die **reagieren**-Methoden für die Tasten auch aufgerufen werden.
		//(mit Ausnahme von tasteReagieren(..), das immer aufgerufen wird)
		tastenReagierbarAnmelden(this);
		tastenLosgelassenReagierbarAnmelden(this);
		
		//Zusätzlich wird für die kontinuierliche Bewegung der Spielfigur
		//noch das Ticker-Interface angemeldet, damit die tick-Methode
		//alle 20 ms aufgerufen wird.
		tickerAnmelden(this, 20);
	}

	/**
	 * Die <b>Standard-Methode</b>, mit der der einfache Tastendruck abgefangen
	 * werden kann.
	 * Wird immer aufgerufen, wenn eine Taste heruntergedrückt wird.
	 * @param code	Der Tastaturcode der Taste, die gerade heruntergedrückt wurde.
	 */
	@Override
	public void tasteReagieren(int code) {
		System.out.println("Taste mit dem Code " + code + " wurde runtergedrückt.");
	}

	/**
	 * Wird immer aufgerufen, wenn eine Taste losgelassen wird.
	 * @param code	Der Tastaturcode der Taste, die gerade losgelassen wurde.
	 */
	@Override
	public void tasteLosgelassen(int code) {
		System.out.println("Taste mit dem Code " + code + " wurde losgelassen.");
	}
	
	public static void main(String[] args) {
		new TastenBeispiel();
	}
	
	/**
	 * Diese Methode wird regelmäßig alle 20 Millisekunden aufgerufen.
	 * In jedem Schritt (also jedem Funktionsaufruf) wird wird ein Objekt
	 */
	public void tick() {
		//ist gerade die Pfeiltaste Oben gedrückt?
		if(tasteGedrueckt(Taste.OBEN)) {
			//Verschiebe die Figur um 1 Pixel nach oben.
			figur.verschieben(0, -2);
		}
		//ist gerade die Pfeiltaste rechts gedrückt?
		if(tasteGedrueckt(Taste.RECHTS)) {
			//Verschiebe die Figur um 1 Pixel nach rechts.
			figur.verschieben(2, 0);
		}
		//ist gerade die Pfeiltaste unten gedrückt?
		if(tasteGedrueckt(Taste.UNTEN)) {
			//Verschiebe die Figur um 1 Pixel nach unten.
			figur.verschieben(0, 2);
		}
		//ist gerade die Pfeiltaste links gedrückt?
		if(tasteGedrueckt(Taste.LINKS)) {
			//Verschiebe die Figur um 1 Pixel nach links.
			figur.verschieben(-2, 0);
		}
	}
}