class ZigZag {
    public String convert(String s, int numRows) {
        if(numRows<2){
            return s;
        }
        StringBuilder output = new StringBuilder(); 
        int sLen = s.length();
        int jump = 2*(numRows -1);
        for(int i=0; i<numRows; i++){
            int j = i;
            if(j==0 || j==numRows-1){
                while(j<sLen){
                    output.append(s.charAt(j));
                    j=j+jump;
                }
            }
            else{
                while(j<sLen){
                    output.append(s.charAt(j));
                    int k = j+jump-2*i;
                    if(k<sLen && k>=0){
                        output.append(s.charAt(k));
                    }
                    j=j+jump;
                }
            }
        }
        return output.toString();
    }
}