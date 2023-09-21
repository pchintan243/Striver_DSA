#include<vector>

int subarrayWithMaxProduct(vector<int> &arr){
	// Write your code here.
    // For iterating over the array from front
	int prefixProduct = 1;
    // For iterating over the array from last to front
	int suffixProduct = 1;
	int n = arr.size();
    // Storing the prodct of the sub array
	int maxProduct = 0;
	for(int i = 0; i < n; i++) {
        // If zero is in an array then skip it make Product as 1
		if(prefixProduct == 0) prefixProduct = 1;
		if(suffixProduct == 0) suffixProduct = 1;

		prefixProduct *= arr[i];
		suffixProduct *= arr[n - i - 1];
		maxProduct = max(maxProduct, max(prefixProduct, suffixProduct));
	}
	return maxProduct;
}