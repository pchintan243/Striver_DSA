class Floor_Ceil {

    public int[] getFloorAndCeil(int x, int[] arr) {
        // code here
        Arrays.sort(arr);
        int low = 0;
        int high = arr.length - 1;
        
        int flr = -1;
        int ce = -1;
        
        while(low <= high) {
            int mid = (low + high) / 2;
            if(arr[mid] == x) {
                flr = arr[mid];
                ce = arr[mid];
                break;
            }
            else if(arr[mid] > x) {
                high = mid - 1;
                ce = arr[mid];
            } else {
                low = mid + 1;
                flr = arr[mid];
            }
        }
        
        int[] ans = new int[2];
        ans[0] = flr;
        ans[1] = ce;
        
        return ans;
    }
}
