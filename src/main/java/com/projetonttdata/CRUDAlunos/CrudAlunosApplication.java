package com.projetonttdata.CRUDAlunos;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "CRUD Alunos", version = "1.0", description = "CRUD de Alunoss"))
public class CrudAlunosApplication{

		public static void main(String[]args) {
		SpringApplication.run(CrudAlunosApplication.class,args);
		}


		}
