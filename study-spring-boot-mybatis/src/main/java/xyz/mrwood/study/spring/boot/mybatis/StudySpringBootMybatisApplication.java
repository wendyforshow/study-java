package xyz.mrwood.study.spring.boot.mybatis;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.HashMap;

@SpringBootApplication
@ServletComponentScan
@MapperScan("xyz.mrwood.study.spring.boot.mybatis.dao")
public class StudySpringBootMybatisApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudySpringBootMybatisApplication.class, args);
	}

	/**
	 * 注入druid的filter
	 * @return
     */
	@Bean
	public FilterRegistrationBean webStatFilter() {

		System.err.println("进入filter");

		WebStatFilter webStatFilter = new WebStatFilter();
		FilterRegistrationBean frb = new FilterRegistrationBean();
		frb.setFilter(webStatFilter);
		frb.setName("druidWebStatFilter");
		frb.setUrlPatterns(Arrays.asList("/*"));
		frb.setInitParameters(new HashMap<String, String>(){{
			put("exclusions", "*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*");
		}});

		return frb;
	}

	/**
	 * 配置druid的servlet
	 * @return
     */
	@Bean
	public ServletRegistrationBean druidViewServlet(){

		System.err.println("进入servlet!");

		StatViewServlet statViewServlet = new StatViewServlet();
		ServletRegistrationBean srb = new ServletRegistrationBean();
		srb.setServlet(statViewServlet);
		srb.setUrlMappings(Arrays.asList("/druid/*"));
		srb.setInitParameters(new HashMap<String, String>(){{
			put("allow", "192.168.16.110,127.0.0.1");
			put("deny", "127.0.0.2");
			put("loginUsername", "kiwi");
			put("loginPassword", "kiwi");
			put("resetEnable", "false");
		}});

		return srb;
	}
}
