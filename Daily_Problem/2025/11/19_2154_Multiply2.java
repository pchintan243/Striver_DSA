package Daily_Problem.2025.11;

class 19_2154_Multiply2 {
    public int findFinalValue(int[] nums, int original) {
        boolean x=true;
        while(x){
            x=found(nums,original);
            original*=2;
        }
        return original/2;
        
    }
    public boolean found(int [] nums,int var){
        for(int ele:nums){
            if(ele==var){
                return true;
            }
        }
        return false;
    }
}