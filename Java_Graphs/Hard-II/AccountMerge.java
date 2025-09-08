package Java_Graphs.Hard-II;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountMerge {
    static List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        int[] parent = new int[n];
        int[] size = new int[n];

        for(int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        Map<String, Integer> mp = new HashMap<>();
        for(int i = 0; i < n; i++) {
            for(int j = 1; j < accounts.get(i).size(); j++) {
                String mail = accounts.get(i).get(j);

                if(mp.containsKey(mail)) {
                    makeSize(i, parent, mp.get(mail), size);
                } else {
                    mp.put(mail, i);
                }
            }
        }
        Map<Integer, TreeSet<String>> res = new HashMap<>();

        for(Map.Entry<String, Integer> data: mp.entrySet()) {
            String mail = data.getKey();
            int parentNode = find(data.getValue(), parent);

            res.computeIfAbsent(parentNode, k -> new TreeSet<>()).add(mail);
        }
        List<List<String>> ans = new ArrayList<>();

        for(Map.Entry<Integer, TreeSet<String>> data: res.entrySet()) {
            int root = data.getKey();
            List<String> mergedMail = new ArrayList<>();
            mergedMail.add(accounts.get(root).get(0));
            mergedMail.addAll(data.getValue());
            ans.add(mergedMail);
        }
        return ans;
    }

    static void makeSize(int u, int[] parent, int v, int[] size) {
        int ulU = find(u, parent);
        int ulV = find(v, parent);
        if(ulU == ulV) {
            return;
        }

        if(size[ulU] < size[ulV]) {
            parent[ulU] = ulV;
            size[ulV] += size[ulU];
        } else {
            parent[ulV] = ulU;
            size[ulU] += size[ulV];
        }
    }

    static int find(int node, int[] parent) {
        if(node == parent[node]) {
            return node;
        }

        return parent[node] = find(parent[node], parent);
    }
}

// Time Complexity:O(n*m*alpha(n)), where n is the number of accounts and m is the maximum number of emails in an account, and alpha(n) is the inverse Ackermann function which grows very slowly.
// Space Complexity:O(n*m), where n is the number of accounts and m is the maximum number of emails in an account, due to the hashmap storing emails and the result list.