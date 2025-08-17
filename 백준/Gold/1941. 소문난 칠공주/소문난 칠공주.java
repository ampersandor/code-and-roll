import java.io.*;

public class Main {
    static final int N = 5;
    static final int K = 7;
    static final int MAX_Y = 3;
    static final int[] delta = new int[]{0, 1, 0, -1, 0};
    static String[] arr;
    static boolean[] visited;
    static int res = 0;

    public static void dfs(int path, int sCount, int yCount) {
        if (yCount > MAX_Y) return;
        if (sCount + yCount == K) {
            res++;
            return;
        }

        for (int node = 0; node < 25; node++) {
            if ((path & (1 << node)) == 0) continue;
            int x = node / N;
            int y = node % N;
            for (int d = 0; d < 4; d++) {
                int nx = x + delta[d];
                int ny = y + delta[d+1];
                int nextPath = path | (1 << (nx * N + ny));
                if (0 <= nx && nx < N && 0 <= ny && ny < N && !visited[nextPath]) {
                    visited[nextPath] = true;
                    if (arr[nx].charAt(ny) == 'S') {
                        dfs(nextPath, sCount + 1, yCount);
                    } else {
                        dfs(nextPath, sCount, yCount + 1);
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

        visited = new boolean[1 << 25];

        for (int node = 0; node < 25; node++) {
            int i = node / 5;
            int j = node % 5;
            visited[1 << node] = true;
            if (arr[i].charAt(j) == 'S') {
                dfs(1 << node, 1, 0);
            } else {
                dfs(1 << node, 0, 1);
            }
        }
        System.out.println(res);
    }
}
