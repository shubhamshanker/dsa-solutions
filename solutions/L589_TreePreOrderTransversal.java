package solutions;

import java.util.ArrayList;
import java.util.List;

public class L589_TreePreOrderTransversal {

    class Node {
        public int val;
        public List<Node> children;
        public Node() {}
        public Node(int _val) {
            val = _val;
        }
        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
    List<Integer> li = new ArrayList<>();


    public static void main(String[] args) {
    //
    }

    public List<Integer> preorder(Node root) {
        if(root == null) return li;
        li.add(root.val);
        for(Node n : root.children)
            preorder(n);
        return li;
    }


}
