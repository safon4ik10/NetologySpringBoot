package ru.netology.netologyspringboot.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.netology.netologyspringboot.profile.SystemProfile;
import ru.netology.netologyspringboot.profile.impl.DevProfile;
import ru.netology.netologyspringboot.profile.impl.ProductionProfile;

/**
 * @author Vladimir Troshin
 * @since 23.01.2023
 */
@Configuration
public class JavaConfig {

    @Bean
    @ConditionalOnProperty(name = "netology.profile.dev", havingValue = "true")
    public SystemProfile devProfile() {
        return new DevProfile();
    }

    @Bean
    @ConditionalOnProperty(name = "netology.profile.dev", havingValue = "false")
    public SystemProfile prodProfile() {
        return new ProductionProfile();
    }
}
