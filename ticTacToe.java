import java.util.*;

public class ticTacToe{

public static void showBoard(String[][] board){
   for(int i=0;i<3;i++){
     System.out.print(" | ");
      for(int j=0;j<3;j++){
         System.out.print(board[i][j]+" | ");
      }
     System.out.println("");
     System.out.println("");
   }
}

public static int checkVacancy(String[][] board,int x,int y,int i){

if(board[x][y]==" "){
   if(i%2==0)
   board[x][y]="X";
   
   else
   board[x][y]="O";
   }
   else{
     i--;
     System.out.println("place already occupied");
   }    

return i;
}  //checkVacancy

public static int checkVictory(String[][] board,int flag){
   
    for(int i=0;i<3;i++)
    {
       if((board[i][0]==board[i][1] && board[i][1]==board[i][2]))
       {if(board[i][0]=="X")
          {System.out.println("player 1 Won");
           return 1;}
        else if(board[i][0]=="O")
          {System.out.println("player 2 Won");
           return 1;}
       }
       if((board[0][i]==board[1][i] && board[1][i]==board[2][i]))
       {if(board[0][i]=="X")
          {System.out.println("player 1 Won");
           return 1;}
        else if(board[0][i]=="O")
          {System.out.println("player 2 Won");
           return 1;}
       }
    }
       if((board[0][0]==board[1][1] && board[1][1]==board[2][2]))
       {if(board[1][1]=="X")
          {System.out.println("player 1 Won");
           return 1;}
        else if(board[1][1]=="O")
          {System.out.println("player 2 Won");
           return 1;}
       }

       if((board[0][2]==board[1][1] && board[2][0]==board[1][1]))
       {if(board[1][1]=="X")
          {System.out.println("player 1 Won");
           return 1;}
        else if(board[1][1]=="O")
          {System.out.println("player 2 Won");
           return 1;}
       }

return flag;          
}

public static void playGame(String[][] board){
Scanner reader=new Scanner(System.in);

int x,y;
    int i=0;   
    int flagWon=0;
    while(i<9 && flagWon==0){
 
       if(i%2==0)
       {
        System.out.println("Player One Choose Coordinates");
       }
       else
       {
        System.out.println("Player two Choose Coordinates");
       }
       x=reader.nextInt();
       y=reader.nextInt();

       while(x>2 || y>2 || x<0 || y<0){
       System.out.println("please select another coordinates");
       x=reader.nextInt();
       y=reader.nextInt();
       }

       i=checkVacancy(board,x,y,i);
       showBoard(board);
       if(i>=4){
         flagWon=checkVictory(board,flagWon);
       }
       i++;
    }
  if(flagWon==0)
  System.out.println("DRAW");

}

public static void main(String[] args){

String[][] board={{" "," "," "},{" "," "," "},{" "," "," "}};
showBoard(board);
playGame(board); 
}

}