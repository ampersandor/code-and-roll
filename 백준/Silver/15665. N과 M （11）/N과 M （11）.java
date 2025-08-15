import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static BufferedWriter bw;
    static int n;
    static int k;
    static int[] arr;
    static List<Integer> cur;
    static Set<String> res;

    public static void combination() throws IOException{
        if (cur.size() == k) {
            String comb = cur.stream().map(String::valueOf).collect(Collectors.joining(" "));
            if (!res.contains(comb)) {
                res.add(comb);
                bw.write(comb + "\n");
            }
            return;
        }
        for (int i = 0; i < n; i++){
            cur.add(arr[i]);
            combination();
            cur.remove(cur.size() - 1);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter((new OutputStreamWriter(System.out)));
        cur = new ArrayList<>();
        res = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        combination();
        bw.flush();
    }
}
