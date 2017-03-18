package checkers;

public class Game2 extends Pawn2{
	public Pawn2[] pawns;

	Game2 SetBoard(){
		Game2 game2=new Game2();
		Pawn2[] pawns= new Pawn2[25]; //czemu 25?
		game2.pawns=SetWhitePawns(pawns);
		game2.pawns=SetBlackPawns(pawns);
		//PrintPawns(pawns);
		PrintBoard(pawns);
		for(int j=8;j>=1;j--)PrintX(pawns,j);
		return game2;
	}
	
	
	public static void main(String[] args) {
		Game2 game1= new Game2();
		game1.SetBoard();


	}

}
