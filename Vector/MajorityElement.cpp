
// Moore’s Voting Algorithm:\Initialize 2 variables:
// Count –  for tracking the count of element
// Element – for which element we are counting
// Traverse through the given array.
// If Count is 0 then store the current element of the array as Element.
// If the current element and Element are the same increase the Count by 1.
// If they are different decrease the Count by 1.
// The integer present in Element should be the result we are expecting

int majorityElement(vector<int> v)
{
    // Write your code here
    int count = 0;
    int el;
    for (int i = 0; i < v.size(); i++)
    {
        if (count == 0)
        {
            count = 1;
            el = v[i];
        }
        else if (v[i] == el)
        {
            count++;
        }
        else
        {
            count--;
        }
    }

    int count1 = 0;
    for (int i = 0; i < v.size(); i++)
    {
        if (v[i] == el)
        {
            count1++;
        }
    }

    if (count1 > (v.size() / 2))
    {
        return el;
    }
    return -1;
}