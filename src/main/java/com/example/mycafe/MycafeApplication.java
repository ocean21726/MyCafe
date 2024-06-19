package com.example.mycafe;

import com.example.mycafe.repository.ItemSearchRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.zip.DataFormatException;

@EnableJpaRepositories(excludeFilters = @ComponentScan.Filter(
		type = FilterType.ASSIGNABLE_TYPE,
		classes = ItemSearchRepository.class))
@SpringBootApplication
public class MycafeApplication {

	public static void main(String[] args) {
		SpringApplication.run(MycafeApplication.class, args);
	}

}
