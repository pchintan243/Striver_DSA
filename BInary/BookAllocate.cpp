int bookAllocate(vector<int> &arr, int pageCapacity)
{
    int studentCount = 1;
    int last = 0;
    for (int i = 0; i < arr.size(); i++)
    {
        // If book pages capacity doesn't exist then you have to add the book pages
        if (arr[i] + last <= pageCapacity)
        {
            last += arr[i];
        }
        // If capacity exist then you havve to add student number and initialize current index as a last.
        else
        {
            last = arr[i];
            studentCount++;
        }
    }
    return studentCount;
}

int findPages(vector<int> &arr, int n, int m)
{
    // Write your code here.

    // Number of students is higher than book it means book are not enough to give each student
    if (m > n)
        return -1;

    // Max element as low
    int low = *max_element(arr.begin(), arr.end());
    // Sum of the pages as high
    int high = accumulate(arr.begin(), arr.end(), 0);

    while (low <= high)
    {
        int mid = (low + high) / 2;
        int ans = bookAllocate(arr, mid);

        if (ans > m)
        {
            low = mid + 1;
        }
        else
        {
            high = mid - 1;
        }
    }
    return low;
}