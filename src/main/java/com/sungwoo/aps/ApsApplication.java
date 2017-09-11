package com.sungwoo.aps;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;

/**
 * @author phloc
 */
@SpringBootApplication
@EnableSwagger2
public class ApsApplication extends SpringBootServletInitializer/* implements CommandLineRunner*/ {
    private final static Logger LOGGER = Logger.getLogger(ApsApplication.class);

    public static void main(String[] args) throws Exception {
        ApplicationContext ctx = SpringApplication.run(ApsApplication.class, args);
        LOGGER.info("Let's inspect the beans provided by Spring Boot:");
        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            LOGGER.info(beanName);
        }
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ApsApplication.class);
    }

    @Bean
    UiConfiguration uiConfig() {
        return new UiConfiguration(
                "aps.sungwoo.com");
//                "none",       // docExpansion          => none | list
//                "alpha",      // apiSorter             => alpha
//                "schema",     // defaultModelRendering => schema
//                UiConfiguration.Constants.DEFAULT_SUBMIT_METHODS,
//                false,        // enableJsonEditor      => true | false
//                true,         // showRequestHeaders    => true | false
//                60000L);      // requestTimeout => in milliseconds, defaults to null (uses jquery xh timeout)
    }

    @Bean
    public TaskScheduler taskScheduler() {
        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        scheduler.setThreadNamePrefix("myScheduler-");
        scheduler.setPoolSize(10);
        // block spring context stopping to allow SI pollers to complete
        // (to graceful shutdown still running tasks, without destroying beans used in these tasks)
        scheduler.setWaitForTasksToCompleteOnShutdown(true);
        scheduler.setAwaitTerminationSeconds(20);
        return scheduler;
    }

//    class ExitException extends RuntimeException implements ExitCodeGenerator {
//        private static final long serialVersionUID = 1L;
//
//        @Override
//        public int getExitCode() {
//            return 10;
//        }
//    }
}
