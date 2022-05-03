import java.util.*;
import java.io.*;

//ola

public class TreeDemo {
	private class TreeNode {
        String info;
        TreeNode left;
        TreeNode right;

        TreeNode(String s, TreeNode lptr, TreeNode rptr) {
            info = s;
            left = lptr;
            right = rptr;
        }
        TreeNode(String s){
        	this(s,null,null);
		}
    }
	
	/**
	 * Return # nodes in tree
	 * @param root is root of tree whose nodes are counted
	 * @return # nodes in tree
	 */
	public int count(TreeNode root) {
		if (root == null) return 0;
		return 1 + count(root.left) + count(root.right);
	}
	
	/**
	 * Add value to a search tree to keep it a search tree
	 * @param root search tree being added to
	 * @param value will be added to true
	 * @return root of tree after value is added
	 */
	public TreeNode add(TreeNode root, String value) {
		if (root == null) {
			return new TreeNode(value,null, null);
		}
		int comp = value.compareTo(root.info);
		if (comp <= 0) {
			root.left = add(root.left,value);
		}
		else {
			root.right = add(root.right,value);
		}
		return root;
	}

	//public <T extends Comparable<? super T>> void rearrange(List<T> list, int low, int high) {
	public void rearrange(List<String> list, int low, int high) {
		if (low < high) {
			int mid = (low+high)/2;
			Collections.sort(list.subList(low,high));
			String temp = list.get(low);
			list.set(low,list.get(mid));
			list.set(mid,temp);
			rearrange(list,low+1,mid-1);
			rearrange(list,mid+1,high);
		}
	}
	public void treeMeasure(int size, int trials) {
		ArrayList<String> list = new ArrayList<>();
		for(int k =0; k < size; k+=1) {
			list.add(""+k);
		}
		System.out.println(list);
		//rearrange(list,0,list.size()-1);
		System.out.println(list);
		int[] heights = new int[size];
		for(int k=0; k < trials; k+=1) {
			//Collections.shuffle(list);
			TreeNode root = null;
			for (String s : list) {
				root = add(root, s);
			}
			int h = height(root);
			heights[h] += 1;
		}
		for(int k=0; k < heights.length; k++) {
			if (heights[k] != 0) {
				System.out.printf("%d\t%d\n",k,heights[k]);
			}
		}

	}

	public TreeNode addIter(TreeNode root, String value) {
		if (root == null) {
			return new TreeNode(value,null, null);
		}
		TreeNode top = root;
		while (true) {
			int comp = value.compareTo(root.info);
			if (comp <= 0) {
				if (root.left == null) {
					root.left = new TreeNode(value);
					break;
				}
				root = root.left;
			} else {
				if (root.right == null) {
					root.right = new TreeNode(value);
					break;
				}
				root = root.right;
			}
		}
		return top;
	}
	
	public void inOrder(TreeNode root) {
		if (root != null) {
			inOrder(root.left);
			System.out.println(root.info);
			inOrder(root.right);
		}
	}
	
	public void preOrder(TreeNode root) {
		if (root != null) {
			System.out.println(root.info);
			preOrder(root.left);
			preOrder(root.right);
		}
	}
	
	public void postOrder(TreeNode root) {
		if (root != null) {
			postOrder(root.left);
			postOrder(root.right);
			System.out.println(root.info);
		}
	}
	
	public boolean isBalanced(TreeNode root) {
		if (root == null) return true;
		
		int lh = height(root.left);         // O(n)
		int rh = height(root.right);        // O(n)

		return isBalanced(root.left)  &&    // T(n/2)
			   isBalanced(root.right) &&    // T(n/2)
			   Math.abs(lh - rh) <= 1;      // O(1)
	}

	/**
	 * Print level order traversal of tree
	 * @param root of tree being traversed in level order
	 */
	public void levelOrder(TreeNode root) {
		Queue<TreeNode> list = new LinkedList<>();
		if (root != null) {
			list.add(root);
		}
		while (list.size() > 0) {
			root = list.remove();
			System.out.printf("%s\n",root.info);
			if (root.left != null) list.add(root.left);
			if (root.right != null) list.add(root.right);
		}
	}

	public ArrayList<String> visit(TreeNode root) {
		ArrayList<String> list = new ArrayList<>();
		doInOrder(root,list);
		return list;
	}

	private void doInOrder(TreeNode root, ArrayList<String> list) {
		if (root!= null) {
			doInOrder(root.left,list);
			list.add(root.info);
			doInOrder(root.right,list);
		}
	}

	public void demo() {
		String[] words = {"macaque", "chimp", "monkey", "lemur",
				          "tamarin", "orangutan", "baboon"};
		TreeNode root = null;
		for(String s : words) {
			root = addIter(root,s);
		}
		System.out.println("---inorder---");
		inOrder(root);
		System.out.println("---level-order---");
		levelOrder(root);
		System.out.println("---iterator order---");
		Iterator<String> iter = new TreeIterator(root);
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
	}
	public TreeNode create() {
		TreeNode root = new TreeNode("macaque",
				               new TreeNode("chimp",
									   new TreeNode("baboon"),
									   new TreeNode("lemur")),
				               new TreeNode("monkey",
									   null,
									   new TreeNode("tamarin",
											   new TreeNode("orangutan"),
											   null)));
		return root;
	}
	
	public class TreeIterator implements Iterator<String> {
		
		private Stack<TreeNode> myStack;

		public TreeIterator(TreeNode root) {
			myStack = new Stack<>();
			while (root != null) {
				myStack.push(root);
                root = root.left;
            }
		}
		@Override
		public boolean hasNext() {
			return myStack.size() > 0;
		}

		@Override
		public String next() {
	        TreeNode t = myStack.pop();
			String data = t.info;
			findSuccessor(t);
	        return data;
		}
		
		private void findSuccessor(TreeNode t) {
			if (t == null)
	            return;               // no successor
	        if (t.right != null) {    // has a right child
	            t = t.right;
	            while (t != null) {
	            	myStack.push(t);
	                t = t.left;
	            }
	        }
		}
	}
	
	public void testIter() throws FileNotFoundException {

		TreeNode root = null;
		ArrayList<String> lista = new ArrayList<>();
		ArrayList<String> listb = new ArrayList<>();
		Scanner scan = new Scanner(new File("/data/darwin.txt"));
		while (scan.hasNext()) {
			String s = scan.next();
			lista.add(s);
			root = add(root,s);
		}
		Collections.sort(lista);
		Iterator<String> iter = new TreeIterator(root);
		while (iter.hasNext()) listb.add(iter.next());
		System.out.printf("list sets equal %s %d %d\n ",lista.equals(listb),
				           lista.size(), count(root));
	}
	
	public int diameter(TreeNode t) {
		if (t == null) return 0;
		int rootPath = height(t.left) + height(t.right) + 1;
		return Math.max(rootPath,
				        Math.max(diameter(t.left),diameter(t.right)));
	}

	public int height(TreeNode root) {
		if (root == null) return 0;
		return 1+ Math.max(height(root.left),
				           height(root.right));
	}

	public boolean contains(TreeNode tree, String target) {
		if (tree == null) return false;
		int result = target.compareTo(tree.info);
		if (result == 0) return true;
		if (result < 0) return contains(tree.left,target);
		return contains(tree.right, target);
	}
	public static void main(String[] args) throws FileNotFoundException {
		TreeDemo td = new TreeDemo();
		//td.demo();
		//td.testIter();
		td.treeMeasure(15,5);
	}
}
