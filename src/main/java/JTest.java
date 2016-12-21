import ershijiu.SO;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Pascal on 2016/11/5.
 */
public class JTest {
    public static void main(String[] args) {
//        SO so = new SO();
//        List<Object> d = so.d();
//        for(Object o:d){
//            System.out.println(o);
//        }
        splitCsvWithQuote("aa,bb,\"cc,dd\",ee",true);
    }
//    private static final Pattern PATTERN_COMMA_W_QUOTES = Pattern.compile(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
    private static final Pattern PATTERN_COMMA_W_QUOTES = Pattern.compile("(,|\\r?\\n|^)([^\",\\r\\n]+|(?>=\")(?:[^\"]|\"\")*(?=\"))");
    /**
     *
     * @param input
     * @return
     */
    public static String[] splitCsvWithQuote(String input, boolean incudeTrailingEmpty){
        String[] result;
        result = PATTERN_COMMA_W_QUOTES.split(input);
        Matcher matcher = PATTERN_COMMA_W_QUOTES.matcher(input);
        while(matcher.find()){
            if(matcher.groupCount()>=2){
                System.out.println(matcher.group(2));
            }

        }

//        for(int i=1;i<=count;i++){
//            System.out.println(matcher.group(i));
//        }
        for(String s:result ){
            System.out.println("s:"+s);
        }
//        if (incudeTrailingEmpty)
//            result = PATTERN_COMMA_W_QUOTES.split(input, -1);
//        else
//            result = PATTERN_COMMA_W_QUOTES.split(input);

//        for (int i=0;i<result.length; i++)
//            result[i] = StringUtils.strip(result[i], "\"");

        return result;
    }
}
