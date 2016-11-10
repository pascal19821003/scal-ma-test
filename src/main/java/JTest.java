import ershijiu.SO;

import java.util.List;

/**
 * Created by Pascal on 2016/11/5.
 */
public class JTest {
    public static void main(String[] args) {
        SO so = new SO();
        List<Object> d = so.d();
        for(Object o:d){
            System.out.println(o);
        }
    }
}
