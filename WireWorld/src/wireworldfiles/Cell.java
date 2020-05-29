package wireworldfiles;

public class Cell {
	
	public int state; // 0 - pusta, 1 - g³owa, 2 - ogon, 3 - przewodnik, moze potem inaczej to zrobimy
	public int headCounter;
	public boolean alreadyInFile;

	public Cell(int stan) {
		this.state = stan;
		headCounter = 0;
		alreadyInFile = false;
	}
	
	public Cell() {
		this.state = 0;
		headCounter = 0;
		alreadyInFile = false;
	}

	
	public int getState() {
		return state;
	}
	
	public void setState(int state) {
		this.state = state;
	}
	
	public int getHeadCounter() {
		return headCounter;
	}

}
