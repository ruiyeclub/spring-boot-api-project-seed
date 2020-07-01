package com.company.project.configurer;
 
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
 
/**
 * 资源拦截器
 * @author Ray。
 */
@Configuration
public class WebMvcConfigurer extends WebMvcConfigurationSupport {

	/**
	 * 这里配置静态资源文件的路径导包都是默认的直接导入就可以
	 */
	@Override
	protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/")
                .addResourceLocations("classpath:/templates/");
        super.addResourceHandlers(registry);
	}
	
}