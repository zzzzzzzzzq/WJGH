package cn.edu.wj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import cn.edu.wj.Application;

@SpringBootApplication
@EnableScheduling
@MapperScan(basePackages = {"cn.edu.wj.Mapper"})

public class Application {
	
	public static void main(String[] args) {
        SpringApplication.run(Application.class, args) ;
    }
}
