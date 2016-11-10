package j.ershijiu;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pascal on 2016/11/8.
 */
public class JavaWildcardGeneric {
    public static List<?> getList(){
        List<String> listStr=new ArrayList<String>();
        listStr.add("a1");
        listStr.add("a2");
        return listStr;
    }
}
