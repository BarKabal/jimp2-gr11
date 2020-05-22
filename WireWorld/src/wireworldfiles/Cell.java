package wireworldfiles;

public class Cell {
	public int state; // 0 - pusta, 1 - g³owa, 2 - ogon, 3 - przewodnik, moze potem inaczej to zrobimy
	public int headCounter;

	public Cell(int stan) {
		this.state = stan;
		headCounter = 0;
	}
	
	public Cell() {
		this.state = 0;
		headCounter = 0;
	}

	
	public static void zmienStan(Cell komorka) {
		if (komorka.state == 0)
			komorka.state = 0;
		else if (komorka.state == 1)
			komorka.state = 2;
		else if (komorka.state == 2)
			komorka.state = 3;
		else if (komorka.headCounter == 1 || komorka.headCounter == 2)
			komorka.state = 1;
		else
			komorka.state = 3;
	}
}
