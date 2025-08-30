import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[][] compressed = new int[m][n];
        int[] nums = new int[n];
        int res = 0;
        List<Integer> sortedNum;
        Set<Integer> set;

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            set = new HashSet<>();
            for(int j = 0; j < n; j++) {
                nums[j] = Integer.parseInt(st.nextToken());
                set.add(nums[j]);
            }
            sortedNum = set.stream().sorted().collect(Collectors.toList());
            set.clear();
            for(int j = 0; j < n; j ++){
                compressed[i][j] = Collections.binarySearch(sortedNum, nums[j]);
            }
        }

        for(int i = 0; i < m - 1; i++) {
            for(int j = i + 1; j < m; j++) {
                if(Arrays.equals(compressed[i], compressed[j])) res++;
            }
        }

        System.out.println(res);
    }
}