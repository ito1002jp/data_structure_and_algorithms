import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // Your code here!
        int[][] matrix = {{1,1,1,1}, {1,1,1,1}, {1,1,0,1}, {1,1,1,1}};
        print(matrix);
        clear(matrix);
        print(matrix);
    }
    
    // public static void clear(int[][] matrix) {

    //     // 0が含まれる座標を記録する
    //     ArrayList<int[]> zeroPoints = new ArrayList<>();
    //     for (int i = 0; i < matrix.length; i++) {
    //         for (int j = 0; j < matrix.length; j++) {
    //             if (matrix[i][j] == 0) {
    //                 int[] zeroPoint = {i, j};
    //                 zeroPoints.add(zeroPoint);
    //             }
    //         }
    //     }
        
    //     // 0が含まれるポイントの縦横の行列を全て0に置き換える4e
    //     for (int i = 0; i < zeroPoints.size(); i++) {
    //         int[] point = zeroPoints.get(i);
    //         for (int v = 0; v < matrix.length; v++) {
    //             matrix[v][point[0]] = 0;
    //         }
    //         for (int h = 0; h < matrix[0].length; h++) {
    //             matrix[point[1]][h] = 0;
    //         }
    //     }
    // }
    
    public static void clear(int[][] matrix) {
        
        boolean[] row = new boolean[matrix.length];
        boolean[] column = new boolean[matrix[0].length];

        // 0が含まれる行と列を記録する
        ArrayList<int[]> zeroPoints = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    column[j] = true;
                }
            }
        }
        
        // 行をクリア
        for (int r = 0; r < row.length; r++) {
            if (row[r]) {
                matrix[r] = new int[column.length];
            }
        }
        
        // 列をクリア
        for (int c = 0; c < column.length; c++) {
            if (row[c]) {
                for (int r = 0; r < row.length; r++) {
                    matrix[r][c] = 0;
                }
            }
        }
    }
    
    
    public static void print(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
                System.out.print(" ");
            }
            System.out.println("");
        }
        System.out.println("");
    }
}

