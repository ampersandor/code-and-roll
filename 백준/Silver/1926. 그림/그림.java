import java.io.*;
import java.util.*;


public class Main {
    static int[][] grid;
    static boolean[][] visited;
    static int[] delta = new int[] {1, 0, -1, 0, 1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x, y, nx, ny;
        int[] cur;
        grid = new int[n][m];
        visited = new boolean[n][m];
        Deque<int[]> que = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int count = 0;
        int biggest = 0;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (grid[i][j] == 1 && !visited[i][j]){
                    que.offer(new int[] {i, j});
                    visited[i][j] = true;
                    count++;
                    int size = 0;
                    while (!que.isEmpty()){
                        cur = que.poll();
                        size++;
                        x = cur[0];
                        y = cur[1];
                        for (int d = 0; d < 4; d++) {
                            nx = x + delta[d];
                            ny = y + delta[d+1];
                            if (0 <= nx && nx < n && 0 <= ny && ny < m && grid[nx][ny] == 1 && !visited[nx][ny]){
                                que.offer(new int[] {nx, ny});
                                visited[nx][ny] = true;
                            }
                        }
                    }
                    biggest = Math.max(biggest, size);
                }
            }
        }
        System.out.println(count);
        System.out.println(biggest);



    }
}
