package com.vigor;

import com.vigor.web.PropertiesControllerTest;
import com.vigor.web.WebControllerTest;
import com.vigor.web.UserControllerTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        PropertiesControllerTest.class,
        UserControllerTest.class,
        WebControllerTest.class
})
public class ApplicationTests {

}
