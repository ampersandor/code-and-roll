import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main{
    public static int[] arr;
    public static int n;
    public static int k;
    public static List<Integer> cur;
    public static Set<String> res;
    public static BufferedWriter bw;
    public static void backtracking(int idx) throws IOException{
        if (cur.size() == k) {
            String comb = cur.stream().map(String::valueOf).collect(Collectors.joining(" "));
            if (!res.contains(comb)) {
                bw.write(comb + "\n");
                res.add(comb);
            }
            return;
        }
        for (int i = idx; i < n; i++) {
            cur.add(arr[i]);
            backtracking(i + 1);
            cur.remove(cur.size()-1);
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n];
        cur = new ArrayList<>();
        res = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        backtracking(0);

        bw.flush();
    }
}
