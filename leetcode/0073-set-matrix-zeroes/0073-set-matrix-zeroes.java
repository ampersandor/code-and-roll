class Solution {
    public void setZeroes(int[][] matrix) {
        Set<Integer> zero_rows = new HashSet<>();
        Set<Integer> zero_cols = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j ++) {
                if (matrix[i][j] == 0) {
                    zero_rows.add(i);
                    zero_cols.add(j);
                }
            }
        }

        for (Integer r : zero_rows) {
            for (int c = 0; c < matrix[0].length; c++) {
                matrix[r][c] = 0;
            }
        }
        for (Integer c : zero_cols) {
            for (int r = 0; r < matrix.length; r ++) {
                matrix[r][c] = 0;
            }
        }

    }
}