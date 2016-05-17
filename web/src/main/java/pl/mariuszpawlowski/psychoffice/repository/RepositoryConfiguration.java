package pl.mariuszpawlowski.psychoffice.repository;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by Mariusz.Pawlowski on 2016-05-17.
 */
@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = {"pl.mariuszpawlowski.psychoffice.domain.jpa"})
@EnableJpaRepositories(basePackages = {"pl.mariuszpawlowski.psychoffice.repository"})
@EnableTransactionManagement
public class RepositoryConfiguration {
}
