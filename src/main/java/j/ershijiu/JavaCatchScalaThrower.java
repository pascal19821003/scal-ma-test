package j.ershijiu;

import ershijiu.ScalaThrower;

/**
 * Created by Pascal on 2016/11/8.
 */
public class JavaCatchScalaThrower {
    public static void main(String[] args){
        ScalaThrower st=new ScalaThrower();
        try{
            st.exceptionThrower();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
