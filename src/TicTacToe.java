import java.util.Arrays; 
import java.util.Scanner;
import java.awt.Font;

public class TicTacToe {

    public String Playmore = "Y";
    public String player1 = "A";   //mark 'X'
    public String player2 = "B";   //mark 'O'
    int player1turn = 1;  //0:Not players turn, 1:Players turn, 2:Player won 
    int player2turn = 0;  //0:Not players turn, 1:Players turn, 2:Player won 
    
    int NrOfGames = 0;






    /*
    [1,2,3
     4,5,6
     7,8,9]*/
    public char[] board = new char[9];
    
    public void playTicTacToe() {
        
        while (Playmore != "n" && Playmore != "N") {
            Playmore = "y";
            prepairBoard(); //Ascii
            printBoard();    //Ascii
            DrawFrame(256,256); //StandardDraw Gluggi
            DrawCanvas();
            while (player1turn != 2 && player2turn != 2){ //meðan enginn er að vinna
                makeMove();
                switchPl();
                printBoard();
                DrawToBoard();
                checkWin();
            }
            if (player1turn == 2) {
                System.out.println(player1 + " has won! Do you want to play again (y/n)? ");
                Scanner scan1 = new Scanner(System.in);
                Playmore = scan1.nextLine();  //Playmore = StdIn.readChar();
            }
            else {
                System.out.println(player2 + " has won! Do you want to play again (y/n)? ");
                Scanner scan2 = new Scanner(System.in);
                Playmore = scan2.nextLine();  //Playmore = StdIn.readChar();
            }
        }
    }
    public void switchPl()  {
        if (player1turn == 0){
            player1turn = 1;
            player2turn = 0;
        }
        else {
            player1turn = 0;
            player2turn = 1;
        }
    }
    public void makeMove() {
        
        //do{
       // if(player1turn<9 && player2turn<9){
        while(player1turn>9 && player2turn>9);
        {
                    System.out.println("Error in input. Please enter another number between 1 and 9");
                    int move = StdIn.readInt();
                    board[move-1] = 0;
                    int i = 0;
        }
        
        if (player1turn == 1){
            System.out.println("Make a move " + player1 + " (1-9): ");
            int move = StdIn.readInt();
            board[move-1] = 'X';
            int i = 0;
        }
        else {
            System.out.println("Make a move " + player2 + " (1-9): ");
            int move = StdIn.readInt();
            board[move-1] = 'O';
            int i = 0;
        }
     /*   else
        {
            System.out.println("Error in input. Please enter another number between 1 and 9");
        }*/
    }
    public void checkWin() {
        if (board[0]=='X' && board[4]=='X' && board[8]=='X')
            player1turn = 2;
        if (board[2]=='X' && board[4]=='X' && board[6]=='X')
            player1turn = 2;
        if (board[0]=='X' && board[3]=='X' && board[6]=='X')
            player1turn = 2;
        if (board[1]=='X' && board[4]=='X' && board[7]=='X')
            player1turn = 2;
        if (board[2]=='X' && board[5]=='X' && board[8]=='X')
            player1turn = 2;
        if (board[0]=='X' && board[1]=='X' && board[2]=='X')
            player1turn = 2;
        if (board[3]=='X' && board[4]=='X' && board[5]=='X')
            player1turn = 2;
        if (board[6]=='X' && board[7]=='X' && board[8]=='X')
            player1turn = 2;
        if (board[0]=='O' && board[4]=='O' && board[8]=='O')
            player2turn = 2;
        if (board[2]=='O' && board[4]=='O' && board[6]=='O')
            player2turn = 2;
        if (board[0]=='O' && board[3]=='O' && board[6]=='O')
            player2turn = 2;
        if (board[1]=='O' && board[4]=='O' && board[7]=='O')
            player2turn = 2;
        if (board[2]=='O' && board[5]=='O' && board[8]=='O')
            player2turn = 2;
        if (board[0]=='O' && board[1]=='O' && board[2]=='O')
            player2turn = 2;
        if (board[3]=='O' && board[4]=='O' && board[5]=='O')
            player2turn = 2;
        if (board[6]=='O' && board[7]=='O' && board[8]=='O')
            player2turn = 2;
    }
    public void printBoard (){ //
        int i = 0;
        while (i < 9){
            StdOut.print("[" + board[(i)] + "]");
            if (i%3==2) {System.out.println();}
            i++;
        }
    }
    public void prepairBoard() { //play again,
        if (NrOfGames == 0){
            System.out.println("Enter player 1 name: ");
            Scanner scan = new Scanner(System.in);
            player1 = scan.nextLine();
            System.out.println("Enter player 2 name: ");
            player2 = scan.nextLine();
            NrOfGames++;
        }
        NrOfGames++;
        //clear board
        int i = 0;
        while (i < 9){board[i] = ' ';i++;}
        player1turn = 1;
        player2turn = 0;
    }
    public void DrawFrame(int Y, int X){
        StdDraw.setCanvasSize(Y, X);
        RectHV Frame = new RectHV(0.0,0.0,1.0,1.0);
        StdDraw.setPenColor(StdDraw.DARK_GRAY);
        //StdDraw.setPenColor(new Color(.5f,.5f,.5f));
        StdDraw.setPenRadius(1024);
        Frame.draw();
        StdDraw.show();
    }
    public void DrawToBoard(){
        double fix1 = 0.01;
        double fix = 0.035;
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.setFont(new Font("Arial", Font.BOLD, 55));
        if (board[0] == 'X')
            StdDraw.text(.20-fix1, .20-fix, "X");
        if (board[1] == 'X')
            StdDraw.text(.50-fix1, .20-fix, "X");
        if (board[2] == 'X')
            StdDraw.text(.80-fix1, .20-fix, "X");
        if (board[3] == 'X')
            StdDraw.text(.20-fix1, .50-fix, "X");
        if (board[4] == 'X')
            StdDraw.text(.50-fix1, .50-fix, "X");
        if (board[5] == 'X')
            StdDraw.text(.80-fix1, .50-fix, "X");
        if (board[6] == 'X')
            StdDraw.text(.20-fix1, .80-fix, "X");
        if (board[7] == 'X')
            StdDraw.text(.50-fix1, .80-fix, "X");
        if (board[8] == 'X')
            StdDraw.text(.80-fix1, .80-fix, "X");
        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.setFont(new Font("Arial", Font.BOLD, 55));
        if (board[0] == 'O')
            StdDraw.text(.20-fix1, .20-fix, "O");
        if (board[1] == 'O')
            StdDraw.text(.50-fix1, .20-fix, "O");
        if (board[2] == 'O')
            StdDraw.text(.80-fix1, .20-fix, "O");
        if (board[3] == 'O')
            StdDraw.text(.20-fix1, .50-fix, "O");
        if (board[4] == 'O')
            StdDraw.text(.50-fix1, .50-fix, "O");
        if (board[5] == 'O')
            StdDraw.text(.80-fix1, .50-fix, "O");
        if (board[6] == 'O')
            StdDraw.text(.20-fix1, .80-fix, "O");
        if (board[7] == 'O')
            StdDraw.text(.50-fix1, .80-fix, "O");
        if (board[8] == 'O')
            StdDraw.text(.80-fix1, .80-fix, "O");
        StdDraw.show();
    }
    public void DrawCanvas(){
        StdDraw.setPenRadius(.015);
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.square(.2, .2, .15);
        StdDraw.square(.5, .2, .15);
        StdDraw.square(.8, .2, .15);
        StdDraw.square(.2, .5, .15);
        StdDraw.square(.5, .5, .15);
        StdDraw.square(.8, .5, .15);
        StdDraw.square(.2, .8, .15);
        StdDraw.square(.5, .8, .15);
        StdDraw.square(.8, .8, .15);
        StdDraw.setPenRadius(.03);
        StdDraw.setPenColor(StdDraw.DARK_GRAY);
        StdDraw.square(.5, .5, .45);
        StdDraw.show();
    }
    public static void main(String[] args) {
        System.out.println("Welcome to TicTacToe");
        TicTacToe newgame = new TicTacToe();
        newgame.playTicTacToe();
        System.out.println("Thanks for playing TicTacToe " + newgame.NrOfGames + " times!");
    }
}