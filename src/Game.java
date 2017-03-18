public class Game extends Pawn{
	public Pawn[] pawns;

	Game SetBoard(){
		Game game2=new Game();
		Pawn[] pawns= new Pawn[25]; //czemu 25?
		game2.pawns=SetWhitePawns(pawns);
		game2.pawns=SetBlackPawns(pawns);
		//PrintPawns(pawns);
		PrintBoard(pawns);
		for(int j=8;j>=1;j--)PrintX(pawns,j);
		return game2;
	}
	
	
	public static void main(String[] args) {
		Game game1= new Game();
		game1.SetBoard();


	}

}

