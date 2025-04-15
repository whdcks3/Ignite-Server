package ignite.api.config;

import javax.annotation.PostConstruct;

import org.springframework.boot.autoconfigure.couchbase.CouchbaseProperties.Env;
import org.springframework.context.annotation.Configuration;

import io.github.cdimascio.dotenv.Dotenv;

@Configuration
public class EnvConfig {

    Dotenv env = Dotenv.load();

    @PostConstruct
    public void init() {
        System.setProperty("spring.datasource.url",
                String.format(
                        "jdbc:mysql://%s:%s/%s",
                        env.get("DB_HOST"),
                        env.get("DB_PORT"),
                        env.get("DB_NAME")));
        System.setProperty("spring.datasource.username", env.get("DB_USER"));
        System.setProperty("spring.datasource.password", env.get("DB_PASSWORD"));

        System.setProperty("aws.s3.bucket", env.get("AWS_BUCKET"));
        System.setProperty("aws.s3.region", env.get("AWS_REGION"));
        System.setProperty("aws.s3.access-key", env.get("AWS_ACCESS"));
        System.setProperty("aws.s3.secret-key", env.get("AWS_SECRET"));
    }

}
