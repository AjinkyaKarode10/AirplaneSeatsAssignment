package com.assignment.airplane;

import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	String s="[[3,3], [4,3], [2,3], [3,4]]";

    	runApp(s,30);
    	
    	
    }
    
    static int runApp(String input, int noOfPax) {
    	
    	String[][] inputArr = parseInputStringData(input);
    	String[][][] seatingArrangementArr = new String[inputArr.length][][];
    	int maxRow = 0;
    	
    	for(int i=0;i<inputArr.length;i++) {
    		
    		String col = inputArr[i][0];
    		String row = inputArr[i][1];
    		seatingArrangementArr[i] = new String[Integer.valueOf(row)][Integer.valueOf(col)];
    		maxRow = Math.max(maxRow,Integer.valueOf(row) );
    	}
    	

    	fillSeatsWith_M_A_W(seatingArrangementArr);
    	
    	int passengerCounter = fillPassengersinAppropriateSeats(seatingArrangementArr,maxRow,noOfPax);
    	//System.out.println(Arrays.deepToString(seatingArrangementArr));
    	print(seatingArrangementArr,maxRow);
    	return passengerCounter-1;
    	
    }
    
    
    static String[][] parseInputStringData(String input){
    	
    	String[] rows = input.split("], \\[");
    	for (int i = 0; i < rows.length; i++) {
    	    // Remove any beginning and ending braces and any white spaces from input str
    	    rows[i] = rows[i].replace("[[", "").replace("]]", "").replaceAll(" ", "");
    	}

    	// Get the number of columns in a row
    	int numberOfColumns = rows[0].split(",").length;

    	// Setup matrix
    	String[][] matrix = new String[rows.length][numberOfColumns];

    	// Populate matrix
    	for (int i = 0; i < rows.length; i++) {
    	    matrix[i] = rows[i].split(",");
    	}
    	
    	return matrix;

    }
    
    
    static String[][][] initializeAirplaneSeatingArrangement(String[][] matrix, int maxRow){
    	
    	String[][][] seatingArrangementArr = new String[matrix.length][][];
    	//int maxRow = 0;
    	
    	for(int i=0;i<matrix.length;i++) {
    		
    		String col = matrix[i][0];
    		String row = matrix[i][1];
    		seatingArrangementArr[i] = new String[Integer.valueOf(row)][Integer.valueOf(col)];
    		maxRow = Math.max(maxRow,Integer.valueOf(row) );
    	}
    	
    	return seatingArrangementArr;
    		
    }
    
    static void fillSeatsWith_M_A_W(String[][][] seatingArrangementArr) {
    	//1 Fill Seats with Middle first
    	for(int i=0;i<seatingArrangementArr.length;i++) {
    		for(int k=0;k<seatingArrangementArr[i].length;k++) {
    			for(int j=1;j<seatingArrangementArr[i][0].length-1;j++) {
    				seatingArrangementArr[i][k][j]="M";
        		}
    		}
    		
    		
    	}
    	
    	//2 Fill seats with Aisle
    	for(int i=0;i<seatingArrangementArr.length;i++) {
    		for(int k=0;k<seatingArrangementArr[i].length;k++) {
    			for(int j=0;j<seatingArrangementArr[i][0].length;j++) {
    				if(j == 0 || j == seatingArrangementArr[i][0].length-1) {
    					seatingArrangementArr[i][k][j]="A";
    				}
        			
        		}
    		}
    		
    		
    	}
    	
    	//3 Fill seats with WIndows
    	for(int i=0;i<seatingArrangementArr.length;i++) {
    		if(i == 0 || i == seatingArrangementArr.length-1) {
    			for(int r = 0 ;r<seatingArrangementArr[i].length;r++) {
    				if(i==0) {
    					seatingArrangementArr[i][r][0] = "W";
    				}
    				else if(i==seatingArrangementArr[i].length-1) {
    					seatingArrangementArr[i][r][seatingArrangementArr[i][r].length-1] = "W";
    				}
        			
        			
        		}
    		}
    	}
    	
    }
    
    
    static int fillPassengersinAppropriateSeats(String[][][] seatingArrangementArr, int maxRow , int noOfPax) {
    	int passengerCounter = 0;
    	passengerCounter = passengerFillUtility(seatingArrangementArr, "A", 1, maxRow,noOfPax);
    	passengerCounter = passengerFillUtility(seatingArrangementArr, "W", passengerCounter, maxRow,noOfPax);
    	passengerCounter = passengerFillUtility(seatingArrangementArr, "M", passengerCounter, maxRow,noOfPax);
    	
    	return passengerCounter;
    	
    }
    
    
    static int passengerFillUtility(String[][][] seatingArrangementArr, String seatType , int passengerCounter, int maxRow , int noOfPax) {
    	
    	for(int row=0;row<maxRow;row++) {
    		for(int i=0;i<seatingArrangementArr.length;i++) {
    			for(int col=0;col<seatingArrangementArr[i][0].length;col++) {
    				if(row < seatingArrangementArr[i].length && seatingArrangementArr[i][row][col].equals(seatType) && passengerCounter <= noOfPax) {
    					seatingArrangementArr[i][row][col]=seatType+passengerCounter++;
    				}
        			
        		}
    		}

    	}
    	
    	return passengerCounter;
    	
    }
    
    static void print(String[][][] seatingArrangementArr , int maxRow) {
    	StringBuilder builder = new StringBuilder();
    	
    	for(int row=0;row<maxRow;row++) {
    		
    		for(int i=0;i<seatingArrangementArr.length;i++) {
    			
    			for(int col=0;col<seatingArrangementArr[i][0].length;col++) {
    				
    				if(row < seatingArrangementArr[i].length) {
    					//System.out.print(seatingArrangementArr[i][row][col]+",  ");
    					if(seatingArrangementArr[i][row][col].length() == 1) {
    						builder.append(seatingArrangementArr[i][row][col]+"     ");
    					}
    					else if(seatingArrangementArr[i][row][col].length() == 2) {
    						builder.append(seatingArrangementArr[i][row][col]+"    ");
    					}
    					else {
    						builder.append(seatingArrangementArr[i][row][col]+"   ");
    					}
    					
    				}
    				else if(row >= seatingArrangementArr[i].length) {
    					builder.append("      ");
    				}
        		}
    			
    			builder.append(" |  ");

    		}
    		
    		builder.append("\n");

    	}
    	
    	System.out.println(builder.toString());
    	
    	
    }
}
