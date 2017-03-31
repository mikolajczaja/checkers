public class Board {

	private Pawn[] pawns=new Pawn[25];
	int iterator=1;
	String turn="white";
	
	
	void changeTurn(){
		if(this.turn=="white")this.turn="black";
		else this.turn="white";
	}
	
	Pawn getPawnById(int id){
		return pawns[id];
	}
	
	Pawn getPawnByPosition(int positionX, int positionY){
		for(int i=1;i<=24;i++){
			if((pawns[i].getPositionX()==positionX)
					&&(pawns[i].getPositionY()==positionY))return pawns[i];
		}
	return null;
	}
	
	boolean hasPawn(int positionX, int positionY){
		if(getPawnByPosition(positionX,positionY)!=null)return true;
		else return false;
	}
	
	boolean isWhite(int positionX, int positionY){
		if(getPawnByPosition(positionX,positionY).getColour()=="white")return true;
		else return false;	
	}
	
	public void setWhitePawns(){
		for(int i=1;i<=8;i++){
			for(int j=1;j<=3;j++){
				if((i%2)+(j%2)==1){
					
					pawns[iterator]=new Pawn(iterator,i,j,"white");				
					//System.out.print(pawns[iterator]+"  ||   ");
					iterator++;
				}
			}//System.out.print("\n");
		}

	}
		
	public void setBlackPawns(){	
		for(int i=1;i<=8;i++){
			for(int j=8;j>=6;j--){
				if((i%2)+(j%2)==1){
					pawns[iterator]=new Pawn(iterator,i,j,"black");
					//System.out.print(pawns[iterator]+"  ||   ");
					iterator++;
				}
			}//System.out.print("\n");
		}
	}
	
	void setBoard(){
		setWhitePawns();
		setBlackPawns();
	}
	
	
	void printPawnsById(){
		for(int i=1;i<=24;i++)
				if((pawns[i])!=null)System.out.println(pawns[i]);
	}
	
	void printBoard(){
		for(int i=8;i>=1;i--){
			for(int j=1;j<=8;j++){
				if((hasPawn(i,j))){
					if(isWhite(i,j))System.out.print("w ");
					else System.out.print("b ");
				} 
				else System.out.print("- ");
		
			} System.out.print("\n");
		}
	}
	
	int countNearbyEnemies(Pawn pawn){
		int i=0;
		if(getPawnByPosition(pawn.getPositionX()-1,pawn.getPositionY()-1).getColour()!=pawn.getColour())i++;
		if(getPawnByPosition(pawn.getPositionX()+1,pawn.getPositionY()-1).getColour()!=pawn.getColour())i++;
		if(getPawnByPosition(pawn.getPositionX()+1,pawn.getPositionY()+1).getColour()!=pawn.getColour())i++;
		if(getPawnByPosition(pawn.getPositionX()-1,pawn.getPositionY()+1).getColour()!=pawn.getColour())i++;
	
		return i;
	}
	
	Pawn pickNearbyEnemy(Pawn pawn,int number){
		if(number>=countNearbyEnemies(pawn)){
			if(number==1)return getPawnByPosition(pawn.getPositionX()-1,pawn.getPositionY()-1);
			if(number==2)return getPawnByPosition(pawn.getPositionX()+1,pawn.getPositionY()-1);
			if(number==3)return getPawnByPosition(pawn.getPositionX()+1,pawn.getPositionY()+1);
			if(number==4)return getPawnByPosition(pawn.getPositionX()-1,pawn.getPositionY()+1);
		}
		return null;
	}
	
	boolean captureEnemy(Pawn pawn,int number){
		
		while((pickNearbyEnemy(pawn,number))!=null){
			
			int destinationX=pawn.getPositionX()+(pawn.getPositionX()
					-pickNearbyEnemy(pawn,number).getPositionX())*(-2);
			
			int destinationY=pawn.getPositionY()+(pawn.getPositionY()
					-pickNearbyEnemy(pawn,number).getPositionY()*(-2));
		
			if(getPawnByPosition(destinationX,destinationY)==null){
				pawn.setPositionX(destinationX);
				pawn.setPositionY(destinationY);
				return true;
			}

		}
		return false;
	}
	
	void capturePawn(){
		if(this.turn=="white"){
			for(int i=1;i<=12;i++){
				
			
			}
		}
		else {
			for(int i=13;i<=24;i++){
				
			}
		}
		
	}
	
	
	void movePawn(int positionX,int positionY,int destinationX,int destinationY){
		
		System.out.println(Math.abs(destinationX-positionX));
		System.out.println(Math.abs(destinationY-positionY));
		System.out.println(hasPawn(destinationX,destinationY));
		
		if((Math.abs(destinationX-positionX)==1)&&(Math.abs(destinationY-positionY)==1)
				&&(hasPawn(destinationX,destinationY)==false))
		{
			System.out.println(getPawnByPosition(positionX,positionY));//
			System.out.println(destinationX+"  ,  "+destinationY);//
			
			getPawnByPosition(positionX,positionY).setPositionX(destinationX);
			getPawnByPosition(positionX,positionY).setPositionY(destinationY);
			System.out.println("---------moving");
		};	
	}
	
	void move(){
		pawns[6].setPositionX(5);
		pawns[6].setPositionY(4);
	}
}
