import java.io.*;
import java.util.*;


public class Main {
    static String[] grid;
    static boolean[][] visited;
    static boolean[][] fired;
    static int[] delta = new int[] {1, 0, -1, 0, 1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x, y, nx, ny;

        int[] cur;
        grid = new String[n];
        visited = new boolean[n][m];
        fired = new boolean[n][m];
        Deque<int[]> que = new ArrayDeque<>();
        Deque<int[]> new_que;
        Deque<int[]> fires = new ArrayDeque<>();
        Deque<int[]> new_fires;
        for (int i = 0; i < n; i++) {
            grid[i] = br.readLine();
            for (int j = 0; j < m; j++) {
                if (grid[i].charAt(j) == 'J') {
                    que.offer(new int[] {i, j});
                    visited[i][j] = true;
                }
                else if (grid[i].charAt(j) == 'F') {
                    fires.offer(new int[] {i, j});
                    fired[i][j] = true;
                }
            }
        }

        for (int trial = 1; trial <= n * m; trial++){
            new_que = new ArrayDeque<>();
            new_fires = new ArrayDeque<>();
            while (!fires.isEmpty()){
                cur = fires.poll();
                x = cur[0];
                y = cur[1];
                for (int d = 0; d < 4; d++){
                    nx = x + delta[d];
                    ny = y + delta[d+1];
                    if (0 <= nx && nx < n && 0 <= ny && ny < m && grid[nx].charAt(ny) == '.' && !fired[nx][ny]) {
                        new_fires.offer(new int[] {nx, ny});
                        fired[nx][ny] = true;
                    }
                }
            }
            fires = new_fires;
            while (!que.isEmpty()){
                cur = que.poll();
                x = cur[0];
                y = cur[1];
                for (int d = 0; d < 4; d++) {
                    nx = x + delta[d];
                    ny = y + delta[d+1];
                    if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                        if (grid[nx].charAt(ny) == '.' && !visited[nx][ny] && !fired[nx][ny]){
                            new_que.offer(new int[] {nx, ny});
                            visited[nx][ny] = true;
                        }
                    } else {
                        System.out.println(trial);
                        return;
                    }
                }
            }
            que = new_que;
            if (fires.isEmpty() && que.isEmpty()) {
                System.out.println("IMPOSSIBLE");
                return;
            }
        }

    }
}
