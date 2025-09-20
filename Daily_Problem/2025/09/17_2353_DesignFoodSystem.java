package Daily_Problem.2025.09;
import java.util.HashMap;
import java.util.Map;

public class 17_2353_DesignFoodSystem {
    static class Food {
        String name;
        String cuisine;
        int rating;

        Food(String name, String cuisine, int rating) {
            this.name = name;
            this.cuisine = cuisine;
            this.rating = rating;
        }
    }

    Map<String, Food> foodToMap;
    Map<String, PriorityQueue<Food>> cuisineToMap;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        foodToMap = new HashMap<>();
        cuisineToMap = new HashMap<>();
        for(int i = 0; i < foods.length; i++) {
            Food food = new Food(foods[i], cuisines[i], ratings[i]);
            foodToMap.put(foods[i], food);
            cuisineToMap.computeIfAbsent(cuisines[i], k -> new PriorityQueue<>(
                (a, b) -> {
                    if(b.rating != a.rating) {
                        return b.rating - a.rating;
                    }
                    return a.name.compareTo(b.name);
                }
            )).add(food);
        }
    }
    
    public void changeRating(String food, int newRating) {
        String cuisine = foodToMap.get(food).cuisine;
        Food updateFood = new Food(food, cuisine, newRating);
        foodToMap.put(food, updateFood);
        cuisineToMap.get(cuisine).add(updateFood);
    }
    
    public String highestRated(String cuisine) {
        PriorityQueue<Food> pq = cuisineToMap.get(cuisine);
        while(!pq.isEmpty()) {
            Food top = pq.peek();
            Food latest = foodToMap.get(top.name);
            if(top.rating == latest.rating) {
                return top.name;
            } else {
                pq.poll();
            }
        }

        return "";
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */