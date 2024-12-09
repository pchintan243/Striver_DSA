#include <bits/stdc++.h> 
vector<vector<int>> zeroMatrix(vector<vector<int>> &mat, int n, int m) {
	// Write your code here.

	int colZero = 1;
	// Set first row & col 0 if zero found in that row & col
	for(int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
			if(mat[i][j] == 0) {
				// If in first column found 0 then make colZero as 0
				// We don't make mat[0][0] = 0 because it effects on row as well.
				if(j == 0)  {
					colZero = 0;
				}
				else {
					// Mark the first row zero
					mat[0][j] = 0;
					// Make the first column zero
					mat[i][0] = 0;
				}
			}
		}
    }

	// Make row & col 0 if in first row or col has zero.
	for(int i = 1; i < n; i++) {
        for (int j = 1; j < m; j++) {
			if(mat[0][j] == 0 || mat[i][0] == 0)  {
				mat[i][j] = 0;
			}
		}
    }

	// If first element is zero then make whole row zero.
	// Make sure you first initialize zero in first row after that first column.
	if(mat[0][0] == 0) {
		for(int j = 0; j < m; j++) {
			mat[0][j] = 0;
		}
	}

	// If colZero 0 it means make first column 0
	if(colZero == 0) {
		for(int i = 0; i < n; i++) {
			mat[i][0] = 0;
		}
	}

	return mat;
}