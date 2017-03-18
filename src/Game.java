public class Game{

	Board board;
	
	//Game(Board board){
	//	this.board=board;
	//}
	
	public static void main(String[] args) {
		Board board1= new Board();
		//Game game1= new Game(board1);
		
		board1.SetBoard();
		//board1.PrintPawnsById();
		System.out.print("\n");
		//board1.PrintBoard();
		
		board1.MovePawn(4,3,5,4);
		board1.Move();
		//board1.PrintPawnsById();
		System.out.print("\n");
		board1.PrintBoard();


	}

}

