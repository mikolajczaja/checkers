public class Game{

	Board board;
	
	//Game(Board board){
	//	this.board=board;
	//}
	
	public static void main(String[] args) {
		Board board1= new Board();
		//Game game1= new Game(board1);
		
		board1.setBoard();
		//board1.PrintPawnsById();
		System.out.print("\n");
		//board1.PrintBoard();
		
		board1.movePawn(4,3,5,4);
		board1.move();
		//board1.PrintPawnsById();
		System.out.print("\n");
		board1.printBoard();


	}

}

