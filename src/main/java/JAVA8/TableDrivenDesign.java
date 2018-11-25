package JAVA8;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * 表驱动
 * @author liwanping
 * @date 2018-11-15 14:52
 **/
public class TableDrivenDesign {

    static  String doxx(String xx){
        return xx;
    }

    String doyy(String xx){
        return xx;
    }

    public static void main (String[] args ){
        TableDrivenDesign tableDrivenDesign = new TableDrivenDesign();
        Map<String, Function<String,?>> actionMappings = new HashMap<>(); // 这里泛型 ? 是为方便演示，实际可替换为你需要的类型
        actionMappings.put("1", (someParams) -> {return(doxx(someParams)); });
        actionMappings.put("2", tableDrivenDesign::doyy);
        actionMappings.put("3", (someParams) -> {return(someParams+"airplane go"); });
        System.out.println(actionMappings.get("2").apply("lwp").toString());
    }
}
