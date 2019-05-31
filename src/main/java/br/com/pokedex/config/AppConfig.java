package br.com.pokedex.config;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.UnknownHostException;

@Configuration
public class AppConfig {

    /*
     * Use the standard Mongo driver API to create a com.mongodb.Mongo instance.
     */
    public @Bean Mongo mongo() throws UnknownHostException {
        return new MongoClient("localhost");
    }
}
