package practice;

public class SetMatrixZeros {

	public static void main(String[] args) {
		int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};
		setZeroes(matrix);
	}
	
	public static void setZeroes(int[][] matrix) {
        for(int i=0; i<matrix.length; i++) {
        	for(int j=0; j<matrix[i].length; j++) {
        		if(matrix[i][j] == 0) {
        			setRowColZero(matrix, i, j);
        		}
        	}
        }
        for(int i=0; i<matrix.length; i++) {
        	for(int j=0; j<matrix[i].length; j++) {
        		if(matrix[i][j] == 2) {
        			matrix[i][j] = 0;
        		}
        	}
        }
    }
	
	private static void setRowColZero(int[][] mat, int row, int col) {
		for(int i=0; i<mat[0].length; i++) {
			mat[row][i]= (mat[row][i] !=0 )?2:0;
		}
		for(int i=0; i<mat.length; i++) {
			mat[i][col]=(mat[i][col] !=0 )?2:0;
		}
	}

}
