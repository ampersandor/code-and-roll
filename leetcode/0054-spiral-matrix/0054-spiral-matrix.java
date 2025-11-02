class Solution {
    private static final int[] directions = {0, 1, 0, -1, 0};

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int n = matrix.length;
        int m = matrix[0].length;
        int x = 0;
        int y = 0;
        int d = 0;
        int count = n * m;
        boolean[][] visited = new boolean[n][m];
        int nx, ny;
        while (count-- > 0) {
            res.add(matrix[x][y]);
            visited[x][y] = true;
            nx = x + directions[d];
            ny = y + directions[d+1];
            if (nx > n - 1 || nx < 0 || ny > m - 1 || ny < 0 || visited[nx][ny]) {
                d = (d + 1) % 4;
                nx = x + directions[d];
                ny = y + directions[d+1];
            }
            x = nx;
            y = ny;
        }

        return res;

    }
}