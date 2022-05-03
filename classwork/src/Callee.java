public class Callee {
    public int call(){
        return 5 + Caller.foo.length();
    }
}
