class 08_03_2025_2379MinRecolors {
    public int minimumRecolors(String blocks, int k) {
        int opr=0, n=blocks.length(), ans;
        for(int i=0; i<k; i++){
            if(blocks.charAt(i)=='W') opr++;
        }
        ans=opr;
        for(int i=k; i<n; i++){
            if(blocks.charAt(i-k)!=blocks.charAt(i)){
                if(blocks.charAt(i-k)=='W') opr--;
                else opr++;
            }
            if(ans>opr) {
                ans=opr;
                if(ans==0) return ans;
            }
        }
        return ans;
    }
}


// 0 1 2 3 4 5 6 7 8 9
// W B B W W B B W B W