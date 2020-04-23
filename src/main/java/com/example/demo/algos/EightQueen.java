package com.example.demo.algos;

/**
 * 八皇后问题： 回溯解决法
 * <p>
 * 八皇后问题：8x8 的棋盘，希望往里放 8 个棋子（皇后），每个棋子所在的行、列、对角线都不能有另一个棋子
 */
public class EightQueen {


    private static Integer N = 8;

    /**
     * @param selectedColumns 已选解集合,下标表示行,值表示queen存储在哪一列
     * @param row             可选的空间解,第 n 行可选
     */
    public static void queenSettle(int[] selectedColumns, int row) {
        // 终止条件
        if (row > N - 1) {
            // 说明前 N 行都已经都选完皇后了，
            printQueens(selectedColumns);
            return;
        }

        for (int i = 0; i < N; i++) {

            // 剔除不合法的格子
            if (!isValid(row, i, selectedColumns)) {
                continue;
            }

            // 选择子节点（当前行）其中一个解
            selectedColumns[row] = i;

            // 选完之后再进入下个阶段的（下一行）遍历
            queenSettle(selectedColumns, row + 1);

            // 回溯,换一个解继续 dfs，回溯时要把回溯节点的解移除
            selectedColumns[row] = -1;

        }
    }

    /**
     * 判断相应的格子放置皇后是否OK
     *
     * @param row
     * @param column
     * @param selectedColumns
     * @return
     */
    private static boolean isValid(int row, int column, int[] selectedColumns) {
        //判断row行column列放置是否合适
        int leftup = column - 1, rightup = column + 1;
        for (int i = row - 1; i >= 0; --i) { // 逐行往上考察每一行
            if (selectedColumns[i] == column) return false; // 第i行的column列有棋子吗？
            if (leftup >= 0) { // 考察左上对角线：第i行leftup列有棋子吗？
                if (selectedColumns[i] == leftup) return false;
            }
            if (rightup < 8) { // 考察右上对角线：第i行rightup列有棋子吗？
                if (selectedColumns[i] == rightup) return false;
            }
            --leftup;
            ++rightup;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] selectedColumn = new int[N];
        // 从第 0 行开始 DFS
        queenSettle(selectedColumn, 0);
    }

    private static void printQueens(int[] result) { // 打印出一个二维矩阵
        for (int row = 0; row < 8; ++row) {
            for (int column = 0; column < 8; ++column) {
                if (result[row] == column) System.out.print("Q ");
                else System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
