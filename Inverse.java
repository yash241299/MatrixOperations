import java.util.Scanner;
public class Inverse {
    public int calculateDeterminant(int[][] mat) {
        int n = mat.length;
        if(n == 2) {
            return ((mat[0][0] * mat[1][1]) - (mat[0][1] * mat[1][0]));
        }
        int det = 0;
        for(int i = 0; i < n; i++) {
            int[][] minor =  this.getMinorMatrix(mat, 0, i);
            int sign = i%2 == 0 ? 1 : -1;
            if(mat[0][i] != 0) {
                det += (mat[0][i] * sign * this.calculateDeterminant(minor));
            }
        }
        return det;
    }

    public int[][] getMinorMatrix(int[][] mat, int skipRow, int skipCol) {
        int n = mat.length;
        int[][] subMat = new int[n-1][n-1];
        int r = 0;;
        for(int i = 0; i < n; i++) {
            if(i == skipRow) continue;
            int c = 0;
            for(int j = 0; j < n; j++) {
                if(j == skipCol) continue;
                subMat[r][c] = mat[i][j];
                c++;
            }
            r++;
        }
        return subMat;
    }

    public int[][] calculateCofactorMatrix(int[][] mat) {
        int n = mat.length;
        int[][] cofactorMatrix = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                int[][] minor = this.getMinorMatrix(mat, i, j);
                int sign = ((i+j) % 2) == 0 ? 1 : -1;
                cofactorMatrix[i][j] = sign * this.calculateDeterminant(minor);
            }
        }
        return cofactorMatrix;
    } 


    public static int[][] matrixInput() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] mat = new int[n][n]; 
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = sc.nextInt();
            }
        }
        return mat;
    }
    public double[][] getInverseMatrix(int[][] mat) {
        int[][] adjointMat = transpose(this.calculateCofactorMatrix(mat));
        // A^-1 = adj(A) / |A|
        int determinant = this.calculateDeterminant(mat);
        double[][] inverseMatrix = new double[mat.length][mat.length];
        for(int i = 0; i < adjointMat.length; i++) {
            for(int j = 0; j < adjointMat.length; j++) {
                inverseMatrix[i][j] = adjointMat[i][j] / (double)determinant;
            }
        }

        return inverseMatrix;

    }

    private static void printMatrix(double[][] mat) {
        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat.length; j++) {
                System.out.print(mat[i][j]);
                if(j < mat.length-1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    } 

    public int[][] transpose(int[][] mat) {
        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat.length; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
        return mat;
    }
    public static void main(String[] args) {
        int[][] mat = matrixInput();
        Inverse inverse = new Inverse();
        double[][] inverseMatrix = inverse.getInverseMatrix(mat);

        printMatrix(inverseMatrix);
    }
}