package DZ8.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "ru.dmalomoshin.homework8")
@EnableAspectJAutoProxy
public class ProjectConfiguration {
}
