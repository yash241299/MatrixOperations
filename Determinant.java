
import java.util.Scanner;
public class Determinant {

    public int calculateDeterminant(int[][] mat) {
        int n = mat.length;
        if(n == 2) {
            return ((mat[0][0] * mat[1][1]) - (mat[0][1] * mat[1][0]));
        }
        int det = 0;
        for(int i = 0; i < n; i++) {
            int[][] minor =  getMinorMatrix(mat, 0, i);
            int sign = i%2 == 0 ? 1 : -1;
            if(mat[0][i] != 0) {
                det += (mat[0][i] * sign * calculateDeterminant(minor));
            }
        }
        return det;
    }

    public int[][] getMinorMatrix(int[][] mat, int skipRow, int skipCol) {
        int n = mat.length;
        int[][] subMat = new int[n-1][n-1];
        int r = 0;;
        for(int i = 1; i < n; i++) {
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
    public static void main(String[] args) {
        Determinant sol = new Determinant();
        int[][] mat = matrixInput();
        System.out.println(sol.calculateDeterminant(mat));
    }
}
