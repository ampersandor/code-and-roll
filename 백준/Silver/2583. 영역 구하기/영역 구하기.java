import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


public class Main {
    static int[][] grid;
    static boolean[][] visited;
    static int[] delta = new int[] {1, 0, -1, 0, 1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int a, b, c, d;

        grid = new int[n][m];

        for (int q = 0; q < k; q++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            for (int i = b; i < d; i++) {
                for (int j = a; j < c; j++) {
                    grid[i][j] = 1;
                }
            }
        }
        Deque<int[]> que;
        int[] cur;
        int x, y, nx, ny, size;
        List<Integer> res = new ArrayList<>();

        visited = new boolean[n][m];
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0 && !visited[i][j]) {
                    que = new ArrayDeque<>();
                    que.offer(new int[]{i, j});
                    visited[i][j] = true;
                    size = 0;
                    while (!que.isEmpty()) {
                        cur = que.poll();
                        x = cur[0];
                        y = cur[1];
                        size++;
                        for (int e = 0; e < 4; e++){
                            nx = x + delta[e];
                            ny = y + delta[e+1];
                            if (0 <= nx && nx < n && 0 <= ny && ny < m && grid[nx][ny] == 0 && !visited[nx][ny]) {
                                que.offer(new int[]{nx, ny});
                                visited[nx][ny] = true;
                            }
                        }
                    }
                    res.add(size);
                }
            }
        }
        System.out.println(res.size());
        System.out.println(String.join(" ", res.stream().sorted().map(String::valueOf).reduce((s1, s2) -> s1 + " " + s2).orElse("")));

    }
}
