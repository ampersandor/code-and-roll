import java.io.*;
import java.util.*;

public class Main {
    private static int n;
    private static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);
        int left = 0;
        int right = 0;
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < n - 1; i++) {
            int num = arr[i];
            int idx = binarySearch(-num, i + 1);
            int cur = Math.abs(arr[i] + arr[idx]);
            if (cur < diff) {
                diff = cur;
                left  = i;
                right = idx;
            }
        }
        System.out.println(arr[left] + " " + arr[right]);
    }

    public static int binarySearch(int target, int low) {
        int high = n - 1;
        int mid = 0;
        int originalLow = low;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        int left = Math.max(originalLow, mid - 1);
        int right = Math.min(n-1, mid + 1);
        if (left > 0 && Math.abs(target - arr[left]) < Math.abs(target - arr[mid])) mid = left;
        if (right < n && Math.abs(target - arr[right]) < Math.abs(target - arr[mid])) mid = right;
        return mid;
    }
}