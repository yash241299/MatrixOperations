import java.util.Scanner;
public class Determinant {

    private int calculateDeterminant(int[][] mat) {
        int n = mat.length;
        if(n == 2) {
            return ((mat[0][0] * mat[1][1]) - (mat[0][1] * mat[1][0]));
        }
        int det = 0;
        for(int i = 0; i < n; i++) {
            int[][] subMat =  getSubMatrix(mat, i);
            int sign = i%2 == 0 ? 1 : -1;
            if(mat[0][i] != 0) {
                det += (mat[0][i] * sign * calculateDeterminant(subMat));
            }
        }
        return det;
    }

    private int[][] getSubMatrix(int[][] mat, int skip) {
        int n = mat.length;
        int[][] subMat = new int[n-1][n-1];
        int r = 0;;
        for(int i = 1; i < n; i++) {
            int c = 0;
            for(int j = 0; j < n; j++) {
                if(j == skip) continue;
                subMat[r][c] = mat[i][j];
                c++;
            }
            r++;
        }
        return subMat;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] mat = new int[n][n]; 
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = sc.nextInt();
            }
        }

        Determinant sol = new Determinant();
        System.out.println(sol.calculateDeterminant(mat));
    }
}
