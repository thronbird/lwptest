import org.junit.Test;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.Assert.assertTrue;

/**
 * @author liwanping
 * @date 2018-05-30
 */
public class OptionalTest {

    public static void main (String[] args ){
        User user =new User();
        //Optional<User> personOptional=user;
        System.out.println(""==null);
        //personOptional
    }

    @Test(expected = NoSuchElementException.class)
    public void whenCreateEmptyOptional_thenNull() {
        Optional<User> emptyOpt = Optional.empty();
        emptyOpt.get();
    }
    @Test
    public void Optional_ofNull() {
        User user =null;
        Optional<User> opt = Optional.of(user);//x
        opt.get();

    }
    @Test
    public void Optional_ofNullable() {
        User user = null;
        Optional<User> opt = Optional.ofNullable(user);
        //opt.isPresent (u -> System.out.println(u));
        assertTrue(opt.isPresent());
        opt.get();//x
    }
}
