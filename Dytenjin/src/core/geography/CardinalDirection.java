package core.geography;

public enum CardinalDirection {
	N(0), NNE(1), NE(2), NEE(3), E(4), SEE(5), SE(6), SSE(7), S(8), 
	SSW(9), SW(10), SWW(11), W(12), NWW(13), NW(14), NNW(15), ERR(-1), SAME(16);
	
	private int dir;
	
	private CardinalDirection(int dir) {
		this.dir = dir;
	}
	
	public int getDir() {
		return dir;
	}
	
	public CardinalDirection leftSixteenth() {
		if (dir < 0 || dir >= 16) {
			return ERR;
		}
		return CardinalDirection.values()[(dir + 15) % 16];
	}
	
	public CardinalDirection rightSixteenth() {
		if (dir < 0 || dir >= 16) {
			return ERR;
		}
		return CardinalDirection.values()[(dir + 1) % 16];
	}
	
	public CardinalDirection leftEigth() {
		if (dir < 0 || dir >= 16) {
			return ERR;
		}
		return CardinalDirection.values()[(dir + 14) % 16];
	}
	
	public CardinalDirection rightEigth() {
		if (dir < 0 || dir >= 16) {
			return ERR;
		}
		return CardinalDirection.values()[(dir + 2) % 16];
	}
	
	public CardinalDirection leftFourth() {
		if (dir < 0 || dir >= 16) {
			return ERR;
		}
		return CardinalDirection.values()[(dir + 12) % 16];
	}
	
	public CardinalDirection rightFourth() {
		if (dir < 0 || dir >= 16) {
			return ERR;
		}
		return CardinalDirection.values()[(dir + 4) % 16];
	}
	
	public CardinalDirection opposite() {
		if (dir < 0 || dir >= 16) {
			return ERR;
		}
		return CardinalDirection.values()[(dir + 8) % 16];
	}
	
	public static CardinalDirection getDirFromCoords(int xFrom, int yFrom, int xTo, int yTo) {
		int deltaX = xTo - xFrom;
		int deltaY = yTo - yFrom;
		if (deltaX == 0 && deltaY ==0) {
			return SAME;
		}
		//Math.atan returns -pi/2 to pi/2
		double angle = Math.atan(deltaY/(double)deltaX);
		int dir = (int)Math.round(Math.abs(angle) / ((Math.PI/2)*(1/4.0)));
		if (angle <= 0) {
			dir += 4;
		} else {
			dir = Math.abs(dir - 4);
		}
		if (deltaX < 0) {
			dir += 8;
		}
		return CardinalDirection.values()[dir % 16];
	}
}
