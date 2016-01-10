public class Solution {
    public String simplifyPath(String path) {
        if (path.equals("/")) return path;
        String[] paths = path.split("/");
        
        String r = "";
        Stack<String> stack = new Stack<String>();
        for(int i=0;i<paths.length;i++) {
            String tmp = paths[i];
            if (tmp.length()==0) continue;
            if (tmp.equals(".")){
                continue;
            } else if (tmp.equals("..")){
                if (stack.empty()) {
                    continue;
                } else {
                    stack.pop();
                    continue;
                }
            } else {
                stack.push(tmp);
            } 
        }
        while(!stack.empty()){
            String cur = stack.peek();
            stack.pop();
            r = "/" + cur + r;
        }
        if (r.length()==0) return "/";
        
        return r;
    }
}