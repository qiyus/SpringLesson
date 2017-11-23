package com.vigor;

import com.vigor.web.controller.PropertiesControllerTest;
import com.vigor.web.controller.WebControllerTest;
import com.vigor.web.controller.UserControllerTest;
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
