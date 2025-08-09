import java.io.*;
import java.util.*;


public class Main {
    static int n;
    static int[][] grid;
    static int[] delta = new int[]{0, 1, 0, -1, 0};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        grid = new int[n][n];
        StringTokenizer st;
        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
                min = Math.min(min, grid[i][j]);
                max = Math.max(max, grid[i][j]);
            }
        }
        int res = 1;
        for (int water = min; water < max; water++) {
            res = Math.max(res, simulate(water));
        }
        System.out.println(res);
    }

    public static int simulate(int water) {
        boolean[][] visited = new boolean[n][n];
        int island = 0;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (grid[i][j] > water && !visited[i][j]){
                    bfs(i, j, water, visited);
                    island++;
                }
            }
        }
        return island;
    }

    public static void bfs(int i, int j, int water, boolean[][] visited){
        Deque<int[]> que = new ArrayDeque<>();
        int[] cur;
        int x, y, nx, ny;
        que.add(new int[]{i, j});
        visited[i][j] = true;
        while (!que.isEmpty()) {
            cur = que.poll();
            x = cur[0];
            y = cur[1];
            for (int d = 0; d < 4; d++){
                nx = x + delta[d];
                ny = y + delta[d+1];
                if (0 <= nx && nx < n && 0 <= ny && ny < n && grid[nx][ny] > water && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    que.offer(new int[]{nx, ny});
                }
            }
        }
    }
}
