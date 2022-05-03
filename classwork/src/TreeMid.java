import java.io.FileNotFoundException;
import java.util.*;

public class TreeMid {
    private class TreeNode {
        int info;
        TreeNode left;
        TreeNode right;

        TreeNode(int val, TreeNode lptr, TreeNode rptr) {
            info = val;
            left = lptr;
            right = rptr;
        }
        TreeNode(int val){
            this(val,null,null);
        }
    }

    public TreeNode add(TreeNode root, int value) {
        if (root == null) {
            return new TreeNode(value,null, null);
        }
        if (value < root.info) {
            root.left = add(root.left,value);
        }
        else {
            root.right = add(root.right,value);
        }
        return root;
    }


    //public <T extends Comparable<? super T>> void rearrange(List<T> list, int low, int high) {
    public void rearrange(List<Integer> list, int low, int high) {
        if (low < high) {
            int mid = (low+high)/2;
            Collections.sort(list.subList(low,high+1));
            int temp = list.get(low);
            list.set(low,list.get(mid));
            list.set(mid,temp);
            rearrange(list,low+1,mid);
            rearrange(list,mid+1,high);
        }
    }
    public void treeMeasure(int size, int trials) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int k =1; k <= size; k+=1) {
            list.add(k);
        }

        int[] heights = new int[size+1];
        rearrange(list,0,list.size()-1);
        for(int k=0; k < trials; k+=1) {
            Collections.shuffle(list);
            TreeNode root = null;
            for (int s : list) {
                root = add(root, s);
            }
            int h = height(root);
            heights[h] += 1;
            //System.out.printf("height = %d, lc = %d = %d\n",h,levelMeasure(root),levelMeasure2(root));
        }
        for(int k=0; k < heights.length; k++) {
            if (heights[k] != 0) {
                System.out.printf("%d\t%d\n",k,heights[k]);
            }
        }
    }
    public int height(TreeNode root) {
        if (root == null) return 0;
        return 1+ Math.max(height(root.left),
                height(root.right));
    }

    public int levelMeasure(TreeNode root) {
        Map<Integer,Integer> map = new HashMap<>();
        helpMeasure(root,map,1);
        int total = 0;
        for(int level : map.keySet()) {
            total += level*map.get(level);
        }
        return total;
    }
    private void helpMeasure(TreeNode root,
                             Map<Integer,Integer> map,int level) {
        if (root == null) return;
        map.putIfAbsent(level,0);
        map.put(level, map.get(level) + 1);
        helpMeasure(root.left, map,level+1);
        helpMeasure(root.right,map,level+1);
    }
    public int levelMeasure2(TreeNode root) {
        int total = 0;
        int hgt = height(root);
        for(int level=1; level <= hgt; level += 1){
            int levelCount = getLevelCount(root,level);
            total += level*levelCount;

        }
        return total;
    }
    private int getLevelCount(TreeNode root, int level) {
        if (root == null || level < 0) return 0;
        if (level == 1) {
            return 1;
        }
        return getLevelCount(root.left,level-1) +
               getLevelCount(root.right,level-1);
    }


    public static void main(String[] args) throws FileNotFoundException {
        TreeMid td = new TreeMid();

        td.treeMeasure(1023,10000);
    }
}
