package ginzberg.casino;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

/**
 * Created by mkulima on 1/25/17.
 */
public class Test_User_Class {
    User deppMan;

    @Before
    public void setup(){
        deppMan = new User("John Depp", 1000);

    }

    @Test
    public void getName_test(){
        Assert.assertThat("user name not what was expected", deppMan.getName(), is("John Depp"));
    }

    @Test
    public void getName_Balance(){
        Assert.assertThat("user balance not what was expected", deppMan.getBalance(), is(1000.0));
    }
}