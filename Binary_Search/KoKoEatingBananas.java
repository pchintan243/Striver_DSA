class KoKoEatingBananas {
    boolean findSpeed(int[] piles, int h, int speed) {
        int totalHr = 0;
        System.out.println(h);
        for(int i = 0; i < piles.length; i++) {
            if((piles[i] % speed) == 0) {
                totalHr += (piles[i] / speed);
            } else {
                totalHr += (piles[i] / speed) + 1;
            }
            if(totalHr > h) {
                return false;
            }
        }

        return true;
    }

    int findMax(int[] piles) {
        int maxEl = Integer.MIN_VALUE;

        for(int i = 0; i < piles.length; i++) {
            maxEl = Math.max(maxEl, piles[i]);
        }

        return maxEl;
    }

    public int minEatingSpeed(int[] piles, int h) {

        int low = 1;
        int high = findMax(piles);
        int n = piles.length;
        // System.out.println(high);
        if(h == n) {
            return high;
        }
        for(int i = low; i <= high; i++) {
            boolean isValid = findSpeed(piles, h, low);
            if(isValid) {
                return low;
            }
        }

        return -1;
        
    }
    public static void main(String[] args) {
        int[] piles = new int[4];
        piles[0] = 3;
        piles[1] = 6;˳
        piles[2] = 7;
        piles[3] = 11;

        int ans = minEatingSpeed(piles, 8);
        System.out.println(ans);
    }
}