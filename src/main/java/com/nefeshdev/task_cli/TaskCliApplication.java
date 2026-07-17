package com.nefeshdev.task_cli;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.shell.command.annotation.CommandScan;

@SpringBootApplication
// Em vez de basePackages, usa basePackageClasses apontando para a classe principal ou a própria classe de comandos
@CommandScan(basePackageClasses = {TaskCliApplication.class})
public class TaskCliApplication {
	public static void main(String[] args) {
		SpringApplication.run(TaskCliApplication.class, args);
	}
}