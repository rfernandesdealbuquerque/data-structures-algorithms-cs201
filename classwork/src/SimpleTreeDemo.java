public class SimpleTreeDemo {
    private static class TreeNode {
        TreeNode left;
        TreeNode right;
        String info;
        TreeNode(String s){
            this(s,null,null);
        }
        TreeNode(String s, TreeNode ll, TreeNode rr){
            info = s;
            left = ll;
            right = rr;
        }
    }
    public static void print(TreeNode root){
        if (root != null) {
            print(root.left);
            System.out.println(root.info);
            print(root.right);
        }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode("mango",
                new TreeNode("durian",
                        new TreeNode("apple",null,null),
                        new TreeNode("grapefuit",null,null)),
                new TreeNode("pear",
                        new TreeNode("orange",null,null),
                        new TreeNode("tangerine",null,null)));

        print(root);
    }
}
