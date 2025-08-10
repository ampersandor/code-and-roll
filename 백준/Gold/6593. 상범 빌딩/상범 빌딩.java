import java.io.*;
import java.util.*;


public class Main {
    static int L, R, C;
    static char[][][] grid;
    static boolean[][][] visited;
    static int[] dx = new int[]{1, -1, 0, 0, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1, 0, 0};
    static int[] dz = new int[]{0, 0, 0, 0, 1, -1};
    static BufferedReader br;

    static final String SUCCESS = "Escaped in %d minute(s).";
    static final String FAIL = "Trapped!";
    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        String test = br.readLine();
        while (!test.equals("0 0 0")) {
            simulate(test);
            test = br.readLine();
        }

    }
    public static void simulate(String test) throws IOException{
        StringTokenizer st = new StringTokenizer(test);
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        grid = new char[R][C][L];
        visited = new boolean[R][C][L];
        Deque<int[]> que = new ArrayDeque<>();
        for (int floor = 0; floor < L; floor++) {
            for (int i = 0; i < R; i ++){
                String row = br.readLine();
                for (int j = 0; j < C; j++) {
                    grid[i][j][floor] = row.charAt(j);
                    if (row.charAt(j) == 'S') {
                        que.offer(new int[]{i, j, floor, 0});
                        visited[i][j][floor] = true;
                    }
                }
            }
            br.readLine();
        }
        System.out.println(bfs(que));

    }
    public static String bfs(Deque<int[]> que) {
        int[] cur;
        int x, y, z, nx, ny, nz, c;
        while (!que.isEmpty()) {
            cur = que.poll();
            x = cur[0];
            y = cur[1];
            z = cur[2];
            c = cur[3];
            if (grid[x][y][z] == 'E') return String.format(SUCCESS, c);
            for (int d = 0; d < 6; d++) {
                nx = x + dx[d];
                ny = y + dy[d];
                nz = z + dz[d];

                if (0 <= nx && nx < R && 0 <= ny && ny < C && 0 <= nz && nz < L && !visited[nx][ny][nz] && grid[nx][ny][nz] != '#') {
                    visited[nx][ny][nz] = true;
                    que.offer(new int[]{nx, ny, nz, c + 1});
                }
            }
        }
        return FAIL;


    }
}
