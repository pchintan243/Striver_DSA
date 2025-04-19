class CntNextGreater {
  public static int[] count_NGEs(int N, int arr[], int queries, int indices[]) {
    // code here
    int cnt = 0;
    int n = indices.length;
    int[] ans = new int[n];
    for(int i = 0; i < n; i++) {
        int el = indices[i];
        for(int j = el + 1; j < N; j++) {
            if(arr[el] < arr[j]) {
                ans[cnt]++;
            }
        }
        cnt++;
    }
    return ans;
  }
}