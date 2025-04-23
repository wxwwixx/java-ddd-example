package tv.codely.apps.backoffice.backend.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import tv.codely.apps.backoffice.backend.middleware.BasicHttpAuthMiddleware;
import tv.codely.shared.domain.bus.command.CommandBus;

import java.util.Arrays;
import java.util.logging.Logger;

@Configuration
public class BackofficeBackendServerConfiguration {

    private static final Logger LOGGER = Logger.getLogger(BackofficeBackendServerConfiguration.class.getName());

    private final CommandBus bus;

    public BackofficeBackendServerConfiguration(CommandBus bus) {
        this.bus = bus;
    }

    @Bean
    public FilterRegistrationBean<BasicHttpAuthMiddleware> basicHttpAuthMiddleware() {
        FilterRegistrationBean<BasicHttpAuthMiddleware> registrationBean = new FilterRegistrationBean<>();

        BasicHttpAuthMiddleware middleware = new BasicHttpAuthMiddleware(bus);
        registrationBean.setFilter(middleware);

        // 🔁 Allow registering multiple URL patterns (can be extended)
        registrationBean.setUrlPatterns(Arrays.asList("/health-check", "/admin/*"));

        // 📊 Set order if there are multiple filters (lower = higher priority)
        registrationBean.setOrder(1);

        LOGGER.info("BasicHttpAuthMiddleware registered for /health-check and /admin/*");

        return registrationBean;
    }
}
