int singleNonDuplicate(vector<int> &arr)
{
    // Write your code here
    int n = arr.size();
    int low = 1;
    int high = n - 2;
    // If first and second element are not matching then we have to return first element.
    if (arr[low] != arr[0])
        return arr[0];
    // If last and second last element are not matching then we have to return last element.
    if (arr[high] != arr[n - 1])
        return arr[n - 1];

    while (low <= high)
    {
        int mid = (low + high) / 2;
        // If mid element is not matching for it's previous and next element then return a[mid]
        if (arr[mid] != arr[mid - 1] && arr[mid] != arr[mid + 1])
            return arr[mid];

        // If mid pointing odd index then we have to check a[mid] & it's previous element are matching or not if matching then simply says it never lies on left portion so we have to low pointer = mid + 1
        // If mid pointing even index then we have to check a[mid] & it's next element are matching or not if matching then simply says it never lies on left portion so we have to low pointer = mid + 1
        if ((mid % 2 == 1 && arr[mid] == arr[mid - 1]) || (mid % 2 == 0 && arr[mid] == arr[mid + 1]))
        {
            low = mid + 1;
        }
        // If above condition not satisfied then single element lies on left portion.
        else
        {
            high = mid - 1;
        }
    }
}