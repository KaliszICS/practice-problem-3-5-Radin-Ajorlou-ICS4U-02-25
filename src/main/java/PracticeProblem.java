public class PracticeProblem {

	public static void main(String args[]) {

		String[][] array = {
			{"k", "l", "l", "F"},
			{"s", "l", "h", "h", "l", "l"}
		};

		System.out.println(noOfPaths(array));

	}




	public static int searchMazeMoves(String[][] arr){
		int curRow = arr.length - 1;
		int curCol = 0;
		int moves = 0;
		int leastMoves = 10000;
		return helper(arr, moves, curCol, curRow, leastMoves);
	}

	public static int helper(String[][] arr, int moves, int column, int row, int leastMoves){
		if(arr[row][column] == "marked"){
			System.out.println("WAS MARKED");
			moves--;
			return 1000;
		}

		else if (arr[row][column] == "F"){ // found location
			System.out.println("FOUND");
			if (moves <= leastMoves){
				leastMoves = moves;
				System.out.println(leastMoves);
				return leastMoves;
			}
			return moves;
		}
		try{
			System.out.println("Moved right");
			moves++;
			int a = helper(arr, moves, column + 1, row, leastMoves); //tries to move right
			if (a <= leastMoves){
				leastMoves = a;
			}
			moves--;
			arr[row][column + 1] = "marked";
		}
		catch(ArrayIndexOutOfBoundsException e){
			moves--;
			System.out.println("Was out right");
		}

		try{
			System.out.println("moved up");
			moves++;
			int a = helper(arr, moves, column, row - 1, leastMoves); //tries to move up
			if (a <= leastMoves){
				leastMoves = a;
			}
			arr[row - 1][column] = "marked";
		}
		catch(ArrayIndexOutOfBoundsException l){
			moves--;
			System.out.println("was out up");
		}
		return leastMoves;
		




		
	}
















	public static int noOfPaths(String[][] arr){
		int row = arr.length - 1;
		int column = 0;
		int paths = 0;
		return pathsHelper (arr, row, column, paths);

	}

	public static int pathsHelper (String[][] arr, int row, int column, int paths){
		if (arr[row][column] == "F"){
			System.out.println("FOUND");
			paths++;
			System.out.println(paths);
			return paths;
		}


		try{
			paths = pathsHelper(arr, row, column + 1, paths); // tries moving right
		}
		catch(ArrayIndexOutOfBoundsException e){

		}
		try{
			paths = pathsHelper(arr, row - 1, column, paths); // tries moving up 
		}
		catch(ArrayIndexOutOfBoundsException l){

		}
		return paths;
	}

	

}
