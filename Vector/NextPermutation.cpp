// next permutation

// Permutation always in ascending order.

vector<in> nextGreaterPermutation(vector<int> &A)
{
    // Write your code here.
    int ind = -1;
    int n = A.size();

    // Finding the smallest one compare to current element
    // If no one smallest find then your permutation is last possibility.
    // So you have to return the first permutation of perticular vector.
    // Starting from second last element to compare
    for (int i = n - 2; i >= 0; i--)
    {
        // Find small element
        if (A[i] < A[i + 1])
        {
            // initialize the index if find small element.
            ind = i;
            break;
        }
    }

    // It exist if small element is not found.
    if (ind == -1)
    {
        // Reverse it and return it.
        reverse(A.begin(), A.end());
        return A;
    }

    // After finding the small element we have to find immediately higher element to smaller one

    for (int i = n - 1; i >= ind; i--)
    {
        if (A[i] > A[ind])
        {
            // If immediate higher found then swap it to index.
            swap(A[i], A[ind]);
            break;
        }
    }

    // Rest of the vector we have to reverse it.
    reverse(A.begin() + ind + 1, A.end());

    return A;
}