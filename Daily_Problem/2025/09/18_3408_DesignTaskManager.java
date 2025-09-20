package Daily_Problem.2025.09;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class 18_3408_DesignTaskManager {
    private Map<Integer, Task> taskMap;
    private TreeMap<Integer, PriorityQueue<Task>> priorityMap;

    static class Task {
        int userId;
        int taskId;
        int priority;

        Task(int userId, int taskId, int priority) {
            this.userId = userId;
            this.taskId = taskId;
            this.priority = priority;
        }
    }

    public TaskManager(List<List<Integer>> tasks) {
        taskMap = new HashMap<>();
        priorityMap = new TreeMap<>();
        for (List<Integer> taskData : tasks) {
            add(taskData.get(0), taskData.get(1), taskData.get(2));
        }
    }

    public void add(int userId, int taskId, int priority) {
        Task t = new Task(userId, taskId, priority);
        taskMap.put(taskId, t);
        
        priorityMap.computeIfAbsent(priority, k -> new PriorityQueue<>((a, b) -> Integer.compare(b.taskId, a.taskId))).add(t);
    }
    
    public void edit(int taskId, int newPriority) {
        Task oldTask = taskMap.get(taskId);
        
        // This is a new, correct Task object. The old one is still in the PQ.
        Task newTask = new Task(oldTask.userId, taskId, newPriority);
        taskMap.put(taskId, newTask);
        
        // Add the new task; old one will be lazily removed by execTop
        priorityMap.computeIfAbsent(newPriority, k -> new PriorityQueue<>((a, b) -> Integer.compare(b.taskId, a.taskId))).add(newTask);
    }

    public void rmv(int taskId) {
        taskMap.remove(taskId);
    }

    public int execTop() {
        while (!priorityMap.isEmpty()) {
            Map.Entry<Integer, PriorityQueue<Task>> highestPriorityEntry = priorityMap.lastEntry();
            PriorityQueue<Task> pq = highestPriorityEntry.getValue();

            while (!pq.isEmpty()) {
                Task topTask = pq.peek();
                Task taskInMap = taskMap.get(topTask.taskId);

                // Check for staleness by comparing the Task ID. If the task exists in the map and
                // its priority hasn't changed, then it's a valid, non-stale task.
                if (taskInMap != null && taskInMap.priority == topTask.priority) {
                    pq.poll(); // Remove from PQ
                    taskMap.remove(topTask.taskId); // Remove from Map
                    return topTask.userId;
                }
                // If the task is either not in the map or has an outdated priority, it's stale.
                pq.poll();
            }
            
            priorityMap.remove(highestPriorityEntry.getKey());
        }

        return -1;
    }
}