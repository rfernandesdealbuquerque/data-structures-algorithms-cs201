public class Gravity {
    public double falling(double time, double velo){
        // fill in code here
        double d = velo*time +
                0.5*9.8*time*time;
        return d;
    }
}
