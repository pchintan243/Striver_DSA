#include <bits/stdc++.h>
int maxDepth(string s)
{
    // Write your code here.
    int maxPara = 0;
    int maxLength = -1;
    for (int i = 0; i < s.size(); i++)
    {
        if (s[i] == '(')
        {
            maxPara++;
        }
        maxLength = max(maxLength, maxPara);
        if (s[i] == ')')
        {
            maxPara--;
        }
    }
    return maxLength;
}
