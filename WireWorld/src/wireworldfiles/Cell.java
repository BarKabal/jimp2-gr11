package wireworldfiles;

public class Cell {
	public int state; // 0 - pusta, 1 - g�owa, 2 - ogon, 3 - przewodnik, moze potem inaczej to zrobimy
	public int headCounter;

	public Cell(int stan) {
		this.state = stan;
		headCounter = 0;
	}
	
	public Cell() {
		this.state = 0;
		headCounter = 0;
	}

}
