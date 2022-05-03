public class Caller {
    public static final String foo = "HELLO";
    public int call(){
        Callee c = new Callee();
        int val = c.call();
        return val + foo.length();
    }
    public static void main(String[] args){
        Caller c = new Caller();
        c.call();
    }
}
