package wireworldfiles;

public class Komorka {
	public int stan; //0 - pusta, 1 - g³owa, 2 - ogon, 3 - przewodnik, moze potem inaczej to zrobimy
	public int liczGlowy;
	
	public Komorka(int stan) {
		this.stan = stan;
		liczGlowy = 0;
	}
	public static void main(String[] args) {
	    Komorka myKomorka = new Komorka(2);			// Sprawdzenie, czy dzia³a zmienStan()
	    System.out.println(myKomorka.stan);
	    zmienStan(myKomorka);
	    System.out.println(myKomorka.stan);
	  }
	public static void zmienStan(Komorka komorka) {
		if(komorka.stan == 0)
			komorka.stan = 0;
		else if(komorka.stan == 1)
			komorka.stan = 2;
		else if(komorka.stan == 2)
			komorka.stan = 3;
		else if(komorka.liczGlowy == 1 || komorka.liczGlowy == 2)
			komorka.stan = 1;
		else 
			komorka.stan = 3;
	}
}
