package com.vigor;

import com.vigor.web.HelloControllerTest;
import com.vigor.web.LessonProperties;
import com.vigor.web.LessonPropertiesTest;
import com.vigor.web.UserControllerTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        HelloControllerTest.class,
        UserControllerTest.class,
        LessonPropertiesTest.class
})
public class ApplicationTests {

}
