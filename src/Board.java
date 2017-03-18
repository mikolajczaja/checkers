public class Board {

	private Pawn[] pawns=new Pawn[25];
	int iterator=1;
	String turn="white";
	
	
	void ChangeTurn(){
		if(this.turn=="white")this.turn="black";
		else this.turn="white";
	}
	
	Pawn GetPawnById(int id){
		return pawns[id];
	}
	
	Pawn GetPawnByPosition(int positionX, int positionY){
		for(int i=1;i<=24;i++){
			if((pawns[i].GetPositionX()==positionX)
					&&(pawns[i].GetPositionY()==positionY))return pawns[i];
		}
	return null;
	}
	
	boolean HasPawn(int positionX, int positionY){
		if(GetPawnByPosition(positionX,positionY)!=null)return true;
		else return false;
	}
	
	boolean IsWhite(int positionX, int positionY){
		if(GetPawnByPosition(positionX,positionY).GetColour()=="white")return true;
		else return false;	
	}
	
	public void SetWhitePawns(){
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
		
	public void SetBlackPawns(){	
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
	
	void SetBoard(){
		SetWhitePawns();
		SetBlackPawns();
	}
	
	
	void PrintPawnsById(){
		for(int i=1;i<=24;i++)
				if((pawns[i])!=null)System.out.println(pawns[i]);
	}
	
	void PrintBoard(){
		for(int i=8;i>=1;i--){
			for(int j=1;j<=8;j++){
				if((HasPawn(i,j))){
					if(IsWhite(i,j))System.out.print("w ");
					else System.out.print("b ");
				} 
				else System.out.print("- ");
		
			} System.out.print("\n");
		}
	}
	
	int CountNearbyEnemies(Pawn pawn){
		int i=0;
		if(GetPawnByPosition(pawn.GetPositionX()-1,pawn.GetPositionY()-1).GetColour()!=pawn.GetColour())i++;
		if(GetPawnByPosition(pawn.GetPositionX()+1,pawn.GetPositionY()-1).GetColour()!=pawn.GetColour())i++;
		if(GetPawnByPosition(pawn.GetPositionX()+1,pawn.GetPositionY()+1).GetColour()!=pawn.GetColour())i++;
		if(GetPawnByPosition(pawn.GetPositionX()-1,pawn.GetPositionY()+1).GetColour()!=pawn.GetColour())i++;
	
		return i;
	}
	
	Pawn PickNearbyEnemy(Pawn pawn,int number){
		if(number>=CountNearbyEnemies(pawn)){
			if(number==1)return GetPawnByPosition(pawn.GetPositionX()-1,pawn.GetPositionY()-1);
			if(number==2)return GetPawnByPosition(pawn.GetPositionX()+1,pawn.GetPositionY()-1);
			if(number==3)return GetPawnByPosition(pawn.GetPositionX()+1,pawn.GetPositionY()+1);
			if(number==4)return GetPawnByPosition(pawn.GetPositionX()-1,pawn.GetPositionY()+1);
		}
		return null;
	}
	
	boolean CaptureEnemy(Pawn pawn,int number){
		
		while((PickNearbyEnemy(pawn,number))!=null){
			
			int destinationX=pawn.GetPositionX()+(pawn.GetPositionX()
					-PickNearbyEnemy(pawn,number).GetPositionX())*(-2);
			
			int destinationY=pawn.GetPositionY()+(pawn.GetPositionY()
					-PickNearbyEnemy(pawn,number).GetPositionY()*(-2));
		
			if(GetPawnByPosition(destinationX,destinationY)==null){
				pawn.SetPositionX(destinationX);
				pawn.SetPositionY(destinationY);
				return true;
			}

		}
		return false;
	}
	
	void CapturePawn(){
		if(this.turn=="white"){
			for(int i=1;i<=12;i++){
				
			
			}
		}
		else {
			for(int i=13;i<=24;i++){
				
			}
		}
		
	}
	
	
	void MovePawn(int positionX,int positionY,int destinationX,int destinationY){
		
		System.out.println(Math.abs(destinationX-positionX));
		System.out.println(Math.abs(destinationY-positionY));
		System.out.println(HasPawn(destinationX,destinationY));
		
		if((Math.abs(destinationX-positionX)==1)&&(Math.abs(destinationY-positionY)==1)
				&&(HasPawn(destinationX,destinationY)==false))
		{
			System.out.println(GetPawnByPosition(positionX,positionY));//
			System.out.println(destinationX+"  ,  "+destinationY);//
			
			GetPawnByPosition(positionX,positionY).SetPositionX(destinationX);
			GetPawnByPosition(positionX,positionY).SetPositionY(destinationY);
			System.out.println("---------moving");
		};	
	}
	
	void Move(){
		pawns[6].SetPositionX(5);
		pawns[6].SetPositionY(4);
	}
}
