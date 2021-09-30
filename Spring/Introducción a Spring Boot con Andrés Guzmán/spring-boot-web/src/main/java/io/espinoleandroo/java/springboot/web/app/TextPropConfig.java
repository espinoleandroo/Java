package io.espinoleandroo.java.springboot.web.app;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySources({
	@PropertySource("classpath:text.properties")
})
public class TextPropConfig {

}
