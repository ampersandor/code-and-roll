import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<Integer> set = new HashSet<>();
        int n, m;
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) set.add(Integer.parseInt(st.nextToken()));

        st = new StringTokenizer(br.readLine());
        int k;
        for (int i = 0; i < m; i++) {
            k = Integer.parseInt(st.nextToken());
            set.remove(k);
        }

        System.out.println(set.size());
        if (!set.isEmpty()) {
            System.out.println(set.stream().sorted(Comparator.naturalOrder()).map(String::valueOf).collect(Collectors.joining(" ")));
        }

    }


}
