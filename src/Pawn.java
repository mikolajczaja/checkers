public class Pawn{

	private int id;
	private int positionX;
	private int positionY;	
	private String colour;
	private boolean type=false; //regular pawn=false
	private boolean state=true; 
	int iterator=1;
	
	Pawn(){
	}
	
	Pawn(int id, int positionX, int positionY ,String colour){
		this.id=id;
		this.positionX=positionX;
		this.positionY=positionY;
		this.colour=colour;		
	}
	
	@Override 
	public String toString(){
		return "id: "+this.id+" ,x: "+this.positionX+" ,y: "
				+this.positionY+" ,kolor: "+this.colour+ " ,typ: "+ this.type+
				" ,stan: "+this.state;
	}
	

	
	String getColour(){
		return this.colour;		
	}
	int getId(){
		return this.id;		
	}	
	
	int getPositionX(){
		return this.positionX;		
	}	

	void setPositionX(int positionX){
		this.positionX=positionX;
	}
	
	int getPositionY(){
		return this.positionY;		
	}	
	
	void setPositionY(int positionY){
		this.positionY=positionY;
	}
	
	boolean getState(){
		return this.state;
	}
	
	void setState(boolean state){
		this.state=state;
	}
	
	boolean getType(){
		return this.type;
	}
	
	void setType(boolean type){
		this.type=type;
	}
	
	
	
	Pawn getPawnById(int id){
		if(this.id==id)return this;
		else return null;
	}
	
	Pawn getPawnByPosition(int x, int y, Pawn[] pawns){
		for(int i=1;i<=24;i++)
				if((pawns[i].getPositionX()==x)
						&&(pawns[i].getPositionY()==y))return pawns[i];
		return null;
	}

	void printX(Pawn[] pawns,int j){
		System.out.print("\n");
		for(int i=1;i<=8;i++){
				if((getPawnByPosition(i,j,pawns))!=null){
					if((getPawnByPosition(i,j,pawns)).colour=="white")System.out.print("w ");
					if((getPawnByPosition(i,j,pawns)).colour=="black")System.out.print("b ");
				} else System.out.print("- ");
		}
	}	
	
}


