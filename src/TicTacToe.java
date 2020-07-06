import java.lang.reflect.Array;
import java.util.*;

public class TicTacToe {
    char[][] gameBoard;
    static ArrayList<Integer> playerPositions =new ArrayList<Integer>();
    static ArrayList<Integer> cpuPositions = new ArrayList<Integer>();

    public TicTacToe() {
        //create game board
        initGameBoard();
        System.out.println("Welcome to Tic tac toe"+ "\n");
        printGameBoard(gameBoard);
         run();
        }
    // print gameboard
    private static void printGameBoard(char[][] gameBoard) {
        for (char[] row : gameBoard) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
        System.out.println("Enter your placement (1-9):");
    }
     public void run(){
        int playerpos =0;
        int cpupos =0;
        String results;
        boolean checkusedFlag=false;
        Scanner scan = new Scanner(System.in);
       while(playerpos != 99) {
           playerpos = scan.nextInt();
           while (playerPositions.contains(playerpos) || cpuPositions.contains(cpupos)) {
               System.out.println("Position taken! Enter a correct position");
               playerpos = scan.nextInt();
           }
           placePiece(gameBoard, playerpos, "Player");
           printGameBoard(gameBoard);
           results = checkWinner();

           if(results.length()>0) {
               System.out.println(results);
               break;
           }
               Random random=new Random();
               cpupos=random.nextInt(9)+1;
           //System.out.println("Position taken! Enter a correct position");
           while(playerPositions.contains(cpupos)|| cpuPositions.contains(cpupos)) cpupos = random.nextInt() + 1;
               placePiece(gameBoard,cpupos,"CPU");
               printGameBoard(gameBoard);
               results= checkWinner();
               if(results.length()>0) {
                   System.out.println(results);
                   break;
               }
           }
         }
      public void initGameBoard(){
          gameBoard = new char[][]{
                  {' ','|',' ','|', ' '},
                  {'-','+','-','+', '-'},
                  {' ','|',' ','|', ' '},
                  {'-','+','-','+', '-'},
                  {' ','|',' ','|', ' '}};

      }
      public static void placePiece(char [][] gameBoard,int pos,String user){
        char symbol =' ';

        if(user.equals("Player")) {
            symbol='X';
            playerPositions.add(pos);
        } else if(user.equals("CPU")){
            symbol='O';
            cpuPositions.add(pos);
        }
        switch(pos){
            case 0:
                 printGameBoard(gameBoard);
                break;

            case 1:
                gameBoard[0][0]=symbol;
                printGameBoard(gameBoard);
                break;
            case 2:
                gameBoard[0][2]=symbol;
                printGameBoard(gameBoard);
                break;
            case 3:
                gameBoard[0][4]=symbol;
                printGameBoard(gameBoard);
                break;
            case 4:
                gameBoard[2][0]=symbol;
                printGameBoard(gameBoard);
                break;
            case 5:
                gameBoard[2][2]=symbol;
                printGameBoard(gameBoard);
                break;
            case 6:
                gameBoard[2][4]=symbol;
                printGameBoard(gameBoard);
                break;
            case 7:
                gameBoard[4][0]=symbol;
                printGameBoard(gameBoard);
                break;
            case 8:
                gameBoard[4][2]=symbol;
                printGameBoard(gameBoard);
                break;
            case 9:
                gameBoard[4][4]=symbol;
                printGameBoard(gameBoard);
                break;
            case 99:
                 break;
          //  default:
           //     throw new IllegalStateException("Please enter value (1-9)" + pos);
            //    break;
        }
      }

      public static String checkWinner(){

          List topRow= Arrays.asList(1,2,3);
          List midRow= Arrays.asList(3,5,6);
          List botRow= Arrays.asList(6,7,8);
          List leftCol= Arrays.asList(1,4,7);
          List midCol = Arrays.asList(2,5,8);
          List rightCol= Arrays.asList(3,6,9);
          List cross1 = Arrays.asList(1,5,9);
          List cross2 = Arrays.asList(7,5,3);

          List<List> winningconditions = new ArrayList<List>();
          winningconditions.add(topRow);
          winningconditions.add(midRow);
          winningconditions.add(botRow);
          winningconditions.add(leftCol);
          winningconditions.add(midCol);
          winningconditions.add(rightCol);
          winningconditions.add(cross1);
          winningconditions.add(cross2);

          for(List l:winningconditions){
              if (playerPositions.containsAll(l)) {
                  return "Concratulations you won" +" Press 0 to restart";

              } else if(cpuPositions.containsAll(l)){

                  return "Machine wins! So Sorry :("+ " Press 0 to restart";
                  } else if(playerPositions.size()+cpuPositions.size()==9){
                   return "Tie"+" Press 0 to restart";
              }


          }


        return "";

      }

}
