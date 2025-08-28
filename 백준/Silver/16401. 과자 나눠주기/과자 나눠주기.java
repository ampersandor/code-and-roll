import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static int n;
    static int m;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        int low = 0;
        int high = arr[m - 1];
        int mid;
        int ans = 0;
        while (low < high) {
            mid = low + (high - low + 1) / 2;
            if (feed(mid) == -1) {
                high = mid - 1;
            } else {
                low = mid;
                ans = mid;
            }
        }
        System.out.println(ans);
        //2147483647
    }

    public static int feed(int length) {
        int count = 0;
        for (int i = 0; i < m; i++){
            count += arr[i] / length;
        }
        return Integer.compare(count, n);
    }


}
