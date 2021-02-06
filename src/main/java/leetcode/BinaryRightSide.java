package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * Input: [1,2,3,null,5,null,4]
Output: [1, 3, 4]
Explanation:

   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---

 * Definition for a binary tree node.
public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
}
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


public class BinaryRightSide {
    public static void main(String[] args) {

        
        
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Queue<TreeNode> temp = new LinkedList<TreeNode>();

        if (root == null) {
            return result;
        }

        temp.add(root);
        
        while (temp.size() > 0) {
            int isize = temp.size();
            for (int i = 0; i < isize; i++) {
                TreeNode tn = temp.poll();
                if (i == 0) {
                    result.add(tn.val);
                }
                if (tn.right != null) {
                    temp.add(tn.right);
                }
                if (tn.left != null) {
                    temp.add(tn.left);
                }
            }
        }
        return result;
    }
}


/*
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> temp = new Stack<TreeNode>();
        
        if (root == null) {
            return result;
        }
        
        temp.push(root);
        
        while (temp.size() > 0) {
            int isize = temp.size();
            for (int i = 0; i < isize; i++) {
                TreeNode tn = temp.pop();
                if (i == 0) {
                    result.add(tn.val);
                }
                if (tn.right != null) {
                    temp.push(tn.right);
                }
                if (tn.right == null && tn.left != null) {
                    temp.push(tn.left);
                }
            }
        }
        return result;

        처음에 스택으로 했다가.. lifo를 깜박했음..
*/


