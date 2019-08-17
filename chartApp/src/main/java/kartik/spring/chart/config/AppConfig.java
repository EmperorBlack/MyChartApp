package kartik.spring.chart.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "kartik.spring.chart")
public class AppConfig extends WebMvcConfigurerAdapter{


	/*
	 * public ViewResolver viewResolver() { InternalResourceViewResolver
	 * viewResolver = new InternalResourceViewResolver();
	 * viewResolver.setViewClass(JstlView.class);
	 * viewResolver.setPrefix("/WEB-INF/"); viewResolver.setSuffix(".html"); return
	 * viewResolver;
	 * 
	 * }
	 */
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
}
