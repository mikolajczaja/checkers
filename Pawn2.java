package checkers;

public class Pawn2 extends Field{

	private int id;
	private int positionX;
	private int positionY;	
	private String colour;
	int iterator=1;
	
	Pawn2(){
	}
	
	Pawn2(int id, int positionX, int positionY ,String colour){
		this.id=id;
		this.positionX=positionX;
		this.positionY=positionY;
		this.colour=colour;		
	}
	
	@Override 
	public String toString(){
		return "id: "+this.id+" ,x: "+this.positionX+" ,y: "
				+this.positionY+" ,kolor: "+this.colour;
	}
	

	
	String GetColour(){
		return this.colour;		
	}	
	int GetId(){
		return this.id;		
	}	
	int GetPositionX(){
		return this.positionX;		
	}	
	int GetPositionY(){
		return this.positionY;		
	}	
	
	Pawn2 GetPawnById(int id){
		if(this.id==id)return this;
		else return null;
	}
	
	Pawn2 GetPawnByPosition(int x, int y, Pawn2[] pawns){
		for(int i=1;i<=24;i++)
				if((pawns[i].GetPositionX()==x)
						&&(pawns[i].GetPositionY()==y))return pawns[i];
		return null;
	}
	
	
	Pawn2[] SetWhitePawns(Pawn2[] pawns){
		for(int i=1;i<=8;i++){
			for(int j=1;j<=3;j++){
				if((i%2)+(j%2)==1){
					
					pawns[iterator]=new Pawn2(iterator,i,j,"white");				
					//System.out.print(pawns[iterator]+"  ||   ");
					iterator++;
				}
			}//System.out.print("\n");
		}
		return pawns;
	}
	
	Pawn2[] SetBlackPawns(Pawn2[] pawns){	
		for(int i=1;i<=8;i++){
			for(int j=8;j>=6;j--){
				if((i%2)+(j%2)==1){
					pawns[iterator]=new Pawn2(iterator,i,j,"black");
					//System.out.print(pawns[iterator]+"  ||   ");
					iterator++;
				}
			}//System.out.print("\n");
		}
		return pawns;
	}
	
	void PrintPawns(Pawn2[] pawns){
		for(int i=1;i<=24;i++)
				if((pawns[i])!=null)System.out.print(pawns[i]);
	}
	void PrintBoard(Pawn2[] pawns){
		for(int i=8;i>=1;i--){
			for(int j=1;j<=8;j++){
				if((GetPawnByPosition(j,i,pawns))!=null){
					if((GetPawnByPosition(j,i,pawns)).colour=="white")System.out.print("w ");
					if((GetPawnByPosition(j,i,pawns)).colour=="black")System.out.print("b ");
				} else System.out.print("- ");
			} System.out.print("\n");
		}
	}
	
	void PrintX(Pawn2[] pawns,int j){
		System.out.print("\n");
		for(int i=1;i<=8;i++){
				if((GetPawnByPosition(i,j,pawns))!=null){
					if((GetPawnByPosition(i,j,pawns)).colour=="white")System.out.print("w ");
					if((GetPawnByPosition(i,j,pawns)).colour=="black")System.out.print("b ");
				} else System.out.print("- ");
		}
	}	
	
}

