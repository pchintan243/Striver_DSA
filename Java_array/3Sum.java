import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class 3Sum {
  public static void main(String[] args) throws IOException {
BufferedReader br = new BufferedReader
          (new InputStreamReader(System.in));
        
    // Read the first line and split it into tokens
    StringTokenizer st = new StringTokenizer(br.readLine());
    
    // Read the total number of 
    // integers (n) and the divisor (k)
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    if(n <= 0 || k <= 0) {
      return;
    }

    StringTokenizer st2 = new StringTokenizer(br.readLine());
    int[] arr = new int[n];
    List<List<Integer>> result = new ArrayList<>();

    Map<Integer, List<Integer>> numToIndices = new HashMap<>();

    for(int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st2.nextToken());
      numToIndices.computeIfAbsent(arr[i], t -> new ArrayList<>()).add(i);
    }
    boolean flag = true;
    for(int i = 0; i < n - 2; i++) {
      for(int j = i + 1; j < n - 1; j++) {
        int sum = k - arr[i] - arr[j];
        if (numToIndices.containsKey(sum)) {
          for(int t : numToIndices.get(sum)) {
            if(t != i && t != j) {
              System.out.println((i + 1) + " " + (j + 1) + " " + (t + 1));
              flag = false;
              break;
            }
          }
        }
        
        if(!flag)
          break;
      }
      
      if(!flag)
        break;
    }
    
    if(flag) {
      System.out.print(-1);
    }
  }
}