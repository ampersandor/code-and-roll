import java.io.*;
import java.util.*;


public class Main {
    static String[] grid;
    static boolean[][] visited;
    static boolean[][] fired;
    static int[] delta = new int[] {1, 0, -1, 0, 1};
    static int n, m;
    static Deque<int[]> que;
    static Deque<int[]> new_que;
    static Deque<int[]> fires;
    static Deque<int[]> new_fires;


    public static String simulate() {
        int[] cur;
        int x, y, nx, ny;

        for (int trial = 1; trial <= n * m; trial++) {
            new_fires = new ArrayDeque<>();
            new_que = new ArrayDeque<>();
            while (!fires.isEmpty()) {
                cur = fires.poll();
                x = cur[0];
                y = cur[1];
                for (int d = 0; d < 4; d++) {
                    nx = x + delta[d];
                    ny = y + delta[d + 1];
                    if (0 <= nx && nx < n && 0 <= ny && ny < m && grid[nx].charAt(ny) == '.' && !fired[nx][ny]) {
                        fired[nx][ny] = true;
                        new_fires.offer(new int[]{nx, ny});
                    }
                }
            }
            fires = new_fires;
            while (!que.isEmpty()) {
                cur = que.poll();
                x = cur[0];
                y = cur[1];
                for (int d = 0; d < 4; d++) {
                    nx = x + delta[d];
                    ny = y + delta[d + 1];
                    if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                        if (grid[nx].charAt(ny) == '.' && !visited[nx][ny] && !fired[nx][ny]) {
                            visited[nx][ny] = true;
                            new_que.offer(new int[]{nx, ny});
                        }
                    } else {
                        return trial + "";
                    }
                }
            }
            que = new_que;
            if (que.isEmpty()) break;
        }
        return "IMPOSSIBLE";
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());


        for (int test = 0; test < tests; test++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            grid = new String[n];
            que = new ArrayDeque<>();
            fires = new ArrayDeque<>();
            visited = new boolean[n][m];
            fired = new boolean[n][m];
            for (int i = 0; i < n; i++) {
                grid[i] = br.readLine();
                for (int j = 0; j < m; j++) {
                    if (grid[i].charAt(j) == '@') {
                        que.offer(new int[]{i, j});
                        visited[i][j] = true;
                    } else if (grid[i].charAt(j) == '*') {
                        fires.offer(new int[]{i, j});
                        fired[i][j] = true;
                    }
                }
            }
            System.out.println(simulate());
        }

    }
}
