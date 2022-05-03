import java.awt.*;

public class ColorDemo {
    public static void main(String[] args) {
        Color[] list = new Color[20];
        Color dukeBlue = new Color(0,48,135);
        Color stanfordRed = new Color(140,21,21);
        Color nwPurple = new Color(78,42,132);
        list[0] = nwPurple; //dukeBlue;
        for(int k=1; k < list.length; k++) {
            list[k] = list[k-1].darker();
        }
        for(int k=0; k < list.length; k++) {
            System.out.printf("%d\t%s\n",k,list[k]);
        }
    }
}
