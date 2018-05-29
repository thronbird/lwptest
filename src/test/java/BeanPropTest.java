import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Set;

/**
 * @author liwanping
 * @date 2018-05-10
 */
public class BeanPropTest {

    static void setPersonName(Person x){
        x.name="xxx";
    }

    public static void main (String[] args ) throws InvocationTargetException, IllegalAccessException {
        Person a = new Person();
        Person b=new Person();
        setPersonName(b);
        a.setAge(33);
        copyPropertiesIgnoreNull(a,b);

        System.out.println(a);
        System.out.println(b);
    }
    public static String[] getNullPropertyNames (Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<String>();
        for(java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) emptyNames.add(pd.getName());
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }

    public static void copyPropertiesIgnoreNull(Object src, Object target){
        BeanUtils.copyProperties(src, target, getNullPropertyNames(src));
    }
}
