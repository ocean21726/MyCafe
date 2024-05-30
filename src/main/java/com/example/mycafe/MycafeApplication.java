package com.example.mycafe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.util.zip.DataFormatException;

@SpringBootApplication
public class MycafeApplication {

	public static void main(String[] args) {
		SpringApplication.run(MycafeApplication.class, args);
	}

}
