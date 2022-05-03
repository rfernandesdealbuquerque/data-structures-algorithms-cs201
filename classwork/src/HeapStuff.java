import java.util.*;
public class HeapStuff {
    public void add(ArrayList<Integer> heap, int value) {
        heap.add(value);
        int loc = heap.size()-1;
        while (1 < loc &&
               value < heap.get(loc/2)) {
            // loc is an index in heap
            // value@loc is less than parent
            heap.set(loc, heap.get(loc/2));
            loc = loc/2;
        }
        heap.set(loc,value);
    }

    public int remove(ArrayList<Integer> heap) {
        int min = heap.get(1);
        int newValue = heap.remove(heap.size()-1);
        int loc = 1;
        if (heap.size() == 1) {
            return min;
        }
        while (2*loc < heap.size()) {
            int minChild = heap.get(2*loc);
            int minChildIndex = 2*loc;

            if (2*loc+1 < heap.size() &&
                heap.get(2*loc+1) < minChild) {
                minChild = heap.get(2*loc+1);
                minChildIndex = 2*loc+1;
            }
            if (newValue < minChild) {
                break;
            }
            heap.set(loc,minChild);
            loc = minChildIndex;
        }
        heap.set(loc,newValue);
        return min;
    }
    public int peek(ArrayList<Integer> heap) {
        return heap.get(1);
    }
    public void demo(){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(-1); // start at 1
        for(int i : new int[] {6,10,7,17,13,9,21,19,25}) {
            add(list,i);
            System.out.println(list);
        }
        while (list.size() > 1) {
            int min = remove(list);
            System.out.printf("%d:\t%s\n",min,list);
        }
    }
    public static void main(String[] args) {
        HeapStuff hd = new HeapStuff();
        hd.demo();
    }
}
