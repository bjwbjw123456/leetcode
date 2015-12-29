public class Solution {
    public boolean isValid(String s) {
        if (s.length() == 0) {
            return true;
        }
        Stack stack = new Stack();
        for(int i=0;i<s.length();i++) {
            char tmp = s.charAt(i);
            switch (tmp) {
                case '(':
                case '[':
                case '{': {
                    stack.push(tmp);
                    break;
                }
                case ')': {
                    if (stack.isEmpty() || stack.peek().toString().charAt(0)!='(') {
                        return false;
                    } else {
                        stack.pop();
                    }
                    break;
                }
                case ']': {
                    if (stack.isEmpty() || stack.peek().toString().charAt(0)!='[') {
                        return false;
                    } else {
                        stack.pop();
                    }
                    break;
                }
                case '}': {
                    if (stack.isEmpty() || stack.peek().toString().charAt(0)!='{') {
                        return false;
                    } else {
                        stack.pop();
                    }
                    break;
                }
                default: return false;
            }
        }
        if (!stack.isEmpty()) {
            return false;
        }else{
            return true;
        }
        
        
    }
}