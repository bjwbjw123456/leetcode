/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    private void helper(TreeNode n, int sum, List<List<Integer>> list, List<Integer> li, int x) {
        if (n == null) {
            return;
        }
        List<Integer> nn = new ArrayList<Integer>(li);
        if (n.left == null && n.right == null) {
            if (x + n.val == sum) {
                nn.add(n.val);
                list.add(nn);
            }
            return;
        }
        nn.add(n.val);
        helper(n.left,sum,list,nn,x+n.val);
        helper(n.right,sum,list,nn,x+n.val);
    }
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            List<List<Integer>> ll = new ArrayList<List<Integer>>();
            return ll;
        }
        if (root.left == null && root.right==null) {
            if (root.val == sum) {
                List<Integer> lt = new ArrayList<Integer>();
                lt.add(root.val);
                List<List<Integer>> ll = new ArrayList<List<Integer>>();
                ll.add(lt);
                return ll;
            } else {
                List<List<Integer>> ll = new ArrayList<List<Integer>>();
                return ll;
            }
        }
        
        List<Integer> li = new ArrayList<Integer>();
        li.add(root.val);
        List<List<Integer>> lli = new ArrayList<List<Integer>>();
        helper(root.left, sum, lli, li, root.val);
        li = new ArrayList<Integer>();
        li.add(root.val);
        helper(root.right, sum, lli, li, root.val);
        return lli;
    }
}