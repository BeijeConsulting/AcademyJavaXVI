package it.beije.beijeAir;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.Arrays;

@SuppressWarnings("deprecation")
@EnableWebMvc
@Configuration
public class SpringWebConfig extends WebMvcConfigurerAdapter {

	private String allowedOrigins[] = new String[] /*{ "http://localhost:8080"};*/  {"*"};
	private String allowedMethods[] = new String[] { "HEAD", "GET", "PUT", "POST", "DELETE", "PATCH" }; // {"*"};

	@Override
	public void addCorsMappings(CorsRegistry registry) {
//    	System.out.println("addCorsMappings");
		registry.addMapping("/**").allowedMethods(allowedMethods);
	}

	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		final CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowedOrigins(Arrays.asList(allowedOrigins));
		configuration.setAllowedMethods(Arrays.asList(allowedMethods));
		configuration.addAllowedHeader("*");
		configuration.applyPermitDefaultValues();
		configuration.setAllowCredentials(true);
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}


}