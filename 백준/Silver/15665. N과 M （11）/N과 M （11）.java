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

    public static void permutation() throws IOException{
        if (cur.size() == k) {
            bw.write(cur.stream().map(String::valueOf).collect(Collectors.joining(" ")) + "\n");
            return;
        }
        int dup = -1;
        for (int i = 0; i < n; i++){
            if (dup == arr[i]) continue;
            dup = arr[i];
            cur.add(arr[i]);
            permutation();
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
        permutation();
        bw.flush();
    }
}
