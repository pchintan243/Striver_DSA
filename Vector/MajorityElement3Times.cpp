vector<int> majorityElement(vector<int> arr)
{
    // Write your code here

    // It is mandatory array has 2 elements which is majority element.
    int el1, el2;
    int cnt1 = 0, cnt2 = 0;
    vector<int> ans;
    int n = arr.size();

    for (int i = 0; i < n; i++)
    {
        // It checks if el2 is same or not which we currently pointing.
        if (cnt1 == 0 && arr[i] != el2)
        {
            el1 = arr[i];
            cnt1 = 1;
        }
        // It checks if el1 is same or not which we currently pointing.
        else if (cnt2 == 0 && arr[i] != el1)
        {
            el2 = arr[i];
            cnt2 = 1;
        }
        // If el1 found we increase the cnt1
        else if (arr[i] == el1)
        {
            cnt1++;
        }
        // If el2 found we increase the cnt2
        else if (arr[i] == el2)
        {
            cnt2++;
        }
        // If none of the element are found then decrease it.
        else
        {
            cnt1--;
            cnt2--;
        }
    }

    // For final check
    cnt1 = 0, cnt2 = 0;

    // Iterate over the vector to finding the correct majority element.
    for (int i = 0; i < n; i++)
    {
        if (el1 == arr[i])
        {
            cnt1++;
        }
        if (el2 == arr[i])
        {
            cnt2++;
        }
    }

    // N/2 times requirement
    int mini = (int)(n / 3) + 1;
    // If found more than array size / 3 times we simply push in the ans
    if (cnt1 > mini)
        ans.push_back(el1);
    if (cnt2 > mini)
        ans.push_back(el2);
    return ans;
}