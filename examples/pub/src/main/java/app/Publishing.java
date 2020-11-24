package app;

import com.studiomediatech.pubsub.PubBuilder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;


@SpringBootApplication
public class Publishing implements CommandLineRunner {

    private static final Logger LOG = LoggerFactory.getLogger(Publishing.class);

    @Autowired
    PubBuilder pubBuilder;

    public static void main(String[] args) {

        new SpringApplicationBuilder(Publishing.class).web(WebApplicationType.NONE).run(args);
    }


    @Override
    public void run(String... args) throws Exception {

        LOG.info("About to begin publishing...");
        Thread.sleep(3000);

        while (true) {
            LOG.info("Publishing authors..");

            pubBuilder.publishTo("authors", String.class)
                .withValue("William Gibson");

            pause();
        }
    }


    private void pause() throws InterruptedException {

        LOG.info("Sleeping for 10s...");
        Thread.sleep(10000);
    }
}
