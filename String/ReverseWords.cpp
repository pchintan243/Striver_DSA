// 1st solution

class Solution {
public:
    string reverseWords(string s) {
        string temp;
        size_t start = s.find_first_not_of(" ");
        size_t end = s.find_last_not_of(" ");
        s = s.substr(start, end - start + 1);
        if (s.size() > 0)
        {
            string temp2;
            for (int i = s.size() - 1; i >= 0; i--)
            {
                if (s[i] == ' ' && s[i + 1] != ' ')
                {
                    reverse(temp2.begin(), temp2.end());
                    temp.size() == 0 ? "" : temp.append(" ");
                    temp.append(temp2);
                    temp2 = "";
                }
                else if(s[i] != ' ')
                {
                    temp2 += s[i];
                }

                if(i == 0 && !temp2.empty()) {
                    reverse(temp2.begin(), temp2.end());
                    temp.size() == 0 ? "" : temp.append(" ");
                    temp.append(temp2);
                }
            }
        }
        return temp;
    }
};


// 2nd solution

class Solution {
public:
    string reverseWords(string s) {
        vector<string> vec;
        int i = 0;
        int si = s.size();
        string temp;
        while(si > i) {
            if(s[i] != ' '){
                temp += s[i];
            }
            else if(!temp.empty()) {
                vec.push_back(temp);
                temp.clear();
            }
            i++;
        }

        if (!temp.empty()) {
            vec.push_back(temp);
        }

        string res;

        for(int i = vec.size() - 1; i >= 0; i--) {
            res += vec[i];
            if(i!=0){
                res += " ";
            }
        }
        return res;
    }
};