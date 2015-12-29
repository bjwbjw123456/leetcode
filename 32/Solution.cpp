class Solution {
public:
    int longestValidParentheses(string s) {
        if (s.size() <= 1) {
            return 0;
        }
        stack<int> stack;
        int max = 0;
        int cur = 0;
        int start = 0;
        for (int i=0;i<s.size();i++) {
            char tmp = s[i];
            if (tmp == '(') {
                stack.push(i);
            } else {
                if (stack.empty() ) {
                    start = i+1;
                    continue;
                }
                stack.pop();
                if (stack.empty()){
                    cur = i-start+1;
                } else {
                    cur = i-stack.top();
                }
                
                if (cur>max) max = cur;
            }
            
        }
        return max;
        
    }
};