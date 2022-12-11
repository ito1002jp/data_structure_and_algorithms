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
    
    // public static void clear(int[][] matrix) {
    //     // 0が含まれる正確な位置を知る必要性はない。どの行を0にすべきかという情報のみを記録する。
    //     boolean[] row = new boolean[matrix.length];
    //     boolean[] column = new boolean[matrix[0].length];

    //     // 0が含まれる行と列を記録する
    //     ArrayList<int[]> zeroPoints = new ArrayList<>();
    //     for (int i = 0; i < matrix.length; i++) {
    //         for (int j = 0; j < matrix.length; j++) {
    //             if (matrix[i][j] == 0) {
    //                 row[i] = true;
    //                 column[j] = true;
    //             }
    //         }
    //     }
        
    //     // 行をクリア
    //     for (int r = 0; r < row.length; r++) {
    //         if (row[r]) {
    //             matrix[r] = new int[column.length];
    //         }
    //     }
        
    //     // 列をクリア
    //     for (int c = 0; c < column.length; c++) {
    //         if (row[c]) {
    //             for (int r = 0; r < row.length; r++) {
    //                 matrix[r][c] = 0;
    //             }
    //         }
    //     }
    // }
    
        public static void clear(int[][] matrix) {
        
        // 最初の行と列を0にするかどうかのフラグとして利用する。
        // そのため最初の行と列が0にクリアされるべきかどうかという情報をここで記録しておく
        // 最初の行と列がフラグとしての機能を終えたのち、下記フラグの値に従って最初の行と列を0にする
        boolean firstRowHasZero = false;
        boolean firstColumnHasZero = false;

        // 最初の行に0が含まれるか確認する
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                firstRowHasZero = true;
                break;
            };
        }
        // 最初の列に0が含まれるか確認する
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                firstColumnHasZero = true;
                break;
            }
        }
        
        // 最初の行と列をフラグとして利用する。zeroにすべき行と列を0にする。
        for (int i = 1; i < matrix[0].length; i++) {
            for (int j = 1; j < matrix.length; j++) {
                if(matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        // 行をクリア
        for (int r = 1; r < matrix.length; r++) {
            if (matrix[r][0] == 0) nullyfyRow(matrix, r);
        }
        // // 列をクリア
        for (int c = 1; c < matrix[0].length; c++) {
            if (matrix[0][c] == 0) nullyfyColumn(matrix, c);
        }
        
        // 最後にフラグとして使っていた最初の行と列をクリアする
        if (firstRowHasZero) nullyfyRow(matrix, 0);
        if (firstColumnHasZero) nullyfyColumn(matrix, 0);
    }
    
    public static void nullyfyRow(int[][] matrix, int index) {
        matrix[index] = new int[matrix[0].length];
    }
    
    public static void nullyfyColumn(int[][] matrix, int index) {
        for (int r = 0; r < matrix[0].length; r++) {
            matrix[r][index] = 0;
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

