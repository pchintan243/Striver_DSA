class Solution {
    public long pickGifts(int[] gifts, int k) {
        long sum = 0;
        while(k != 0) {
            int maxEl = Arrays.stream(gifts).max().orElseThrow();
            int giftsPile = (int) Math.sqrt(maxEl);
            int maxIndex = IntStream.range(0, gifts.length)
                                .filter(i -> gifts[i] == maxEl)
                                .findFirst()
                                .orElse(-1);

            gifts[maxIndex] = giftsPile;
            k--;
        }

        for(int i = 0; i < gifts.length; i++) {
            sum += gifts[i];
            System.out.println(gifts[i]);
        }
        return sum;
    }
}