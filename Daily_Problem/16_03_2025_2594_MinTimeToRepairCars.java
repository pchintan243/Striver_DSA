class 16_03_2025_2594_MinTimeToRepairCars {
    boolean poss(int[] ranks, int cars, long mid) {
        long time = 0;
        for(int i: ranks) {
            long c2 = (long) Math.sqrt(mid / i);
            time += c2;
        }

        return time >= cars;
    }
    public long repairCars(int[] ranks, int cars) {
        long low = 1;
        long high = (long) 1e14;
        while(low <= high) {
            long mid = (low + high) >> 1;
            if(poss(ranks, cars, mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}