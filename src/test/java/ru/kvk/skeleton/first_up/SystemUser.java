package ru.itex.test.first_up;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import ru.kvk.skeleton.config.JPAConfiguration;
import ru.kvk.skeleton.config.ServiceConfiguration;

/**
 * Created by King on 14.12.2015.
 */
//@ActiveProfiles({ "deep-deep-alpha" })
@ContextConfiguration(
        loader= AnnotationConfigContextLoader.class,
        classes={ServiceConfiguration.class, JPAConfiguration.class}
)
@RunWith(SpringJUnit4ClassRunner.class)
public class SystemUser {


}
