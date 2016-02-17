package ru.kvk.skeleton.config;

import org.springframework.core.io.support.ResourcePropertySource;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;
import java.io.IOException;

/**
 * Created by King on 09.12.2015.
 */

public class AppInit  implements WebApplicationInitializer {


    public void onStartup(ServletContext container) {
        // Create the 'root' Spring application context
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(ServiceConfiguration.class, SecurityConfiguration.class, JPAConfiguration.class);

        try {
            rootContext.getEnvironment().getPropertySources().addFirst(new ResourcePropertySource("classpath:application.properties"));
            rootContext.getEnvironment().setActiveProfiles(
                    rootContext.getEnvironment().getRequiredProperty("spring.profiles.active")
            );
        } catch (IOException e) {
            e.printStackTrace();
        }


        // Manage the lifecycle of the root application context
        container.addListener(new ContextLoaderListener(rootContext));

        // Create the dispatcher servlet's Spring application context
        AnnotationConfigWebApplicationContext dispatcherServlet = new AnnotationConfigWebApplicationContext();
        dispatcherServlet.register(WebMvcConfiguration.class);

        // Register and map the dispatcher servlet
        ServletRegistration.Dynamic dispatcher = container.addServlet("dispatcher", new DispatcherServlet(dispatcherServlet));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");

    }
}
