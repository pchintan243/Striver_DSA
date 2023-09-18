// Optimal approach

int longestSuccessiveElements(vector<int> &a)
{
    // Write your code here.
    int longest = 1;
    // unordered set which takes unique element but not sorted.
    unordered_set<int> s;

    // insert all the element in s;
    for (int i = 0; i < a.size(); i++)
    {
        s.insert(a[i]);
    }

    // iterating over the set.
    for (auto it : s)
    {
        // Check immediate smaller value exits or not.
        if (s.find(it - 1) == s.end())
        {
            int count = 1;
            int x = it;
            // If immediate higher value found than increment the count and x as well.
            while (s.find(x + 1) != s.end())
            {
                x++;
                count++;
            }
            longest = max(longest, count);
        }
    }
    return longest;
}