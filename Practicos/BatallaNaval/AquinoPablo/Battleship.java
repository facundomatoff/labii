package game;

import java.util.Scanner;
public class Battleship
{
   Scanner input = new Scanner(System.in);
   public static final boolean DEBUG = false;
   public static void breakln()
   {
      System.out.println("_____________________________________");
      System.out.println("");
   }
   public static void createBoard(String[][] board)
   {
	  
      for(int r = 0; r < board.length; r++)
      {
         for(int c = 0; c < board[0].length; c++)
         {
            board[r][c] = "~";
         }
      }
   }
   public static void showBoard(String[][] board)
   {
      breakln();
      System.out.print("  1 2 3 4 5 6 7 8 \n");
      int numero =1;
      for(int r = 0; r < board.length; r++)
      {
    	  System.out.print(numero);
    	  numero++;
         if(DEBUG == true)
         {
            for(int c = 0; c < board[0].length; c++)
            {
               System.out.print(" "+board[r][c]);
            }
            System.out.println("");
         }
         else
         {
            for(int c = 0; c < board[0].length; c++)
            {
               if(board[r][c].equals("S"))
               {
                  System.out.print(" "+"~");
               }
               else
               {
                  System.out.print(" "+board[r][c]);
               }
            }
            System.out.println("");
         }
      }
      breakln();
   }
   public static void createShip(String[][] board,int size)
   {
      if(Math.random() < 0.5)
      {
         int col = (int)(Math.random()*5);
         int row = (int)(Math.random()*7);
         for(int i = 0; i<size; i++)
         {
            board[row][col+i] = "S";
         }
      }
      else
      {
         int col = (int)(Math.random()*7);
         int row = (int)(Math.random()*5);
         for(int i = 0; i<size; i++)
         {
            board[row+i][col] = "S";
         }
      }
   }
   public static int userFire(String[][] board, int hits, int torps)
   {
      Scanner input = new Scanner(System.in);
      int row,col;
      System.out.println("Tienes: "+ torps +" torpedos!");
      System.out.println("Ingresa una fila: ");
      row = input.nextInt();
      while(row > 8 || row < 1) 
      {
         System.out.println("Ingresa una fila valida (1 -> 8)");
         row = input.nextInt();
      }
      System.out.println("Ingresa una columna: ");
      col = input.nextInt();
      while(col > 8 || col < 1) 
      {
         System.out.println("Ingresa una columna valida (1 -> 8)");
         col = input.nextInt();
      }
      if(board[row-1][col-1].equals("S"))
      {
         hits ++;
         System.out.println("~~~~~~~ Le diste ~~~~~~~");
         board[row-1][col-1] = "x";
      }
      else
      {
         System.out.println("~~~~~~~ Errado ~~~~~~~");
         board[row-1][col-1] = "o";
      }
      return hits;
   }
   public static void finall(int hits, int torps)
   {
      if(hits < 2)
         System.out.println("Lo siento, pero perdiste porque no hundiste la nave.");
      if(torps < 1)
         System.out.println("Has perdido todos tus torpedos");
      else
         if(hits >= 2)
         {
            System.out.println("Has ganado el juego, gracias por jugar!");
         }
   }
   public static void main(String[] arg)
   {
	  
      String[][] board = new String[8][8];
      createBoard(board);
      createShip(board, 2);
      int torps = 15;
      int hits = 0;
      
      while(torps > 0 && hits < 2)
      {
         showBoard(board);
         hits = userFire(board, hits, torps);
         torps --;
      }
      finall(hits, torps);
   }}