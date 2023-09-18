string read(int n, vector<int> book, int target)
{
    // Write your code here.
    sort(book.begin(), book.end());
    int left = 0, right = book.size() - 1;
    while(left < right) {
        int sum = book[left] + book[right];
        if(target == sum) 
            return "YES";
        else if(target < sum) 
            right--;
        else 
            left++;
    }
    return "NO";
}
