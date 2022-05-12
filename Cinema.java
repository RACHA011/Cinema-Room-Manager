
import java.util.*;

public class Cinema {
    static int incom = 0;
    static final int s = 60;
    static int x = 0;
    static char[][] arr = null;
    public static void main(String[] args) {
        // Write your code here
       Scanner scanner = new Scanner(System.in);
       
       System.out.println("Enter the number of rows:");
       int row = scanner.nextInt();
       
       System.out.println("Enter the number of seats in each row:");
       int col = scanner.nextInt();
       
       option(row ,col);
       
       scanner.close();
    }
    
    static void option(int row ,int col) {
    	int rows = 0;
        int cols = 0;
        
        Scanner scanner = new Scanner(System.in);
        outloop:
    	while (true) {
            
            
            System.out.println();
            System.out.printf("1. Show the seats%n");
            System.out.printf("2. Buy a ticket%n");
            System.out.printf("3. Statistics%n");
            System.out.printf("0. Exit%n");
            int option = scanner.nextInt();
            
            System.out.println();
            
            
            switch (option) {
                case 1:
                    if (x == 0) {
                    	System.out.println("Cinema:");
                    	printArray(row , col);
                    	break;
                    } else {
                    	System.out.println("Cinema:");
                        printArray(row, col, rows, cols);
                        break;
                    }
                case 2:
                    System.out.println("Enter a row number:");
                    rows = scanner.nextInt();
       
                    System.out.println("Enter a seat number in that row:");
                    cols = scanner.nextInt();
                    
                    System.out.println();
                    
                    if (rows > row || cols > col) {
                    	wrongInput(row ,col ,rows ,cols);
                    	
                    } else {
                    	total(row, col, rows, cols);
                    	
                    }
                    
                    break;
                case 0:
                	scanner.close();
                    break outloop;
                case 3:
                	statistics(row, col, x);
                	break;
                default:
                	break;
            }
        }
    }
    
    static void wrongInput(int row ,int col,int rows,int cols) {
    	while (rows > row || cols > col) {
    		System.out.println("Wrong input!");
    		
    		Scanner scanner = new Scanner(System.in);
        	
        	System.out.println("Enter a row number:");
            rows = scanner.nextInt();

            System.out.println("Enter a seat number in that row:");
            cols = scanner.nextInt();
            
            System.out.println();
    	}
    }
    
    static void statistics (int row, int col, int x) {
    	int result = row * col;
    	
    	int total = 0;
    	double percent = ((double)x /((double)row * (double)col)) * 100;
    	if (result < s) {
        	total = row * col * 10;
    	} else {
    		total = (row / 2) * col * 10 + (row - (row / 2)) * col * 8;
    	}
    	
    	System.out.printf("Number of purchased tickets: %d %n", x);
    	System.out.printf("Percentage: %.2f",percent); 
    	System.out.print("%\n");
    	System.out.printf("Current income: $%d%n", incom);
    	System.out.printf("Total income: $%d%n", total);
    }
    
    static void printArray(int row,int col) {
        col = ((col + 1) * 2) - 1;
        row = row + 1;
        createArray(row,col);
        for (int i = 0;i < row;i++) {
            for (int j = 0;j < col;j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
    
    static void fail(int row,int col, int rows,int cols) {
    	Scanner scanner = new Scanner(System.in);
    	
    	System.out.println("Enter a row number:");
        rows = scanner.nextInt();

        System.out.println("Enter a seat number in that row:");
        cols = scanner.nextInt();
        
        System.out.println();
        total(row, col, rows, cols);
    }
    
    static void total(int row,int col,int rows,int cols) {
        
        if (arr == null) {
        	int co = ((col + 1) * 2) - 1;
            int ro = row + 1;
            createArray(ro,co);
        }
        
        cols = ((cols + 1) * 2) - 2;
    	
    	if (arr[rows][cols] == 'B') {
    		System.out.println("That ticket has already been purchased!");
    		fail(row, col, rows, cols);
    	} else {
    		arr[rows][cols] = 'B';
    		x++;
    		int total = row * col;
            int rowDiv = row / 2;
            if (total < s) {
                incom += 10;
            	System.out.printf("Ticket price: $%d%n", 10);
            } else if (rows <= rowDiv) {
                incom += 10;
                System.out.printf("Ticket price: $%d%n", 10);
            } else {
                incom += 8;
            	System.out.printf("Ticket price: $%d%n", 8);
            }
    	}
    	
    }

    static void createArray (int row,int col) {
    	arr = new char[row][col];
        int xc = '1';
        int y = '0';
    
        for (int i = 0;i < row;i++) {
            for (int j = 0;j < col;j++) {
                if (j == 0 && j % 2 == 0) {
                    arr[i][j] = (char)y;
                    y++; 
                } else if (j % 2 != 0){
                    arr[i][j] = ' ';
                } else if (i == 0 && j % 2 == 0) {
                    arr[i][j] = (char)xc;
                    xc++;
                } else {
                    arr[i][j] = 'S';
                } 
            }
        }
        arr[0][0] = ' ';       
    
    }
    
    static void printArray(int row,int col,int rows,int cols) {
    	col = ((col + 1) * 2) - 1;
        row = row + 1;
    	
        if (arr == null) {
            createArray(row,col);
        }
        
        
        for (int i = 0;i < row;i++) {
            for (int j = 0;j < col;j++) {
               System.out.print(arr[i][j]);
            }
            System.out.println();
        }
        	
        }


}