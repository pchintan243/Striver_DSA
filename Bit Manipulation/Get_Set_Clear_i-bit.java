// Optimal Approach using bit operation

class Get_Set_Clear_i-bit {
    static void bitManipulation(int num, int i) {
        // code here
        boolean leftShift = ((1 << (i - 1)) & num) > 0;
        int getBit = leftShift ? 1 : 0;
        System.out.print(getBit + " ");
        
        int setBit = (1 << (i - 1)) | num;
        System.out.print(setBit + " ");
        
        int clearBit = leftShift ? num ^ (1 << (i - 1)) : num;
        System.out.print(clearBit + " ");
        
    }
}


// class Get_Set_Clear_i-bit {
//     static void bitManipulation(int num, int i) {
//         // code here
//         StringBuilder res = new StringBuilder();
//         int storeNum = num;
//         while(storeNum != 1) {
//             if(storeNum % 2 == 1) {
//                 res.append('1');
//             } else {
//                 res.append('0');
//             }
//             storeNum /= 2;
//         }
//         res.append('1');
        
//         int n = res.length();
//         if(i > n) {
//             System.out.print("0 ");
//             System.out.print((long) (num + Math.pow(2, i - 1)) + " ");
//             System.out.print(num);
//             return;
//         }
//         char ind = res.charAt(i - 1);
//         System.out.print(ind + " ");
//         if(ind == '1') {
//             System.out.print(num + " ");
//             System.out.print((long) (num - Math.pow(2, i - 1)));
//         }
//         else {
//             System.out.print((long) (num + Math.pow(2, i - 1)) + " ");
//             System.out.print(num);
//         }
            
        
//     }
// }
