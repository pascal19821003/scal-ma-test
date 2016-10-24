package shijiu;

/**
 * Created by Pascal on 2016/10/22.
 */
public class TestArray {
    public static void main(String[] args){
        String[] a1 = {"abc"};
        Object[] a2 = a1;
        a2[0] = new Integer(17);
        String s = a1[0];
    }
}
