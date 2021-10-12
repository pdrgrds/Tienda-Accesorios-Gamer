package org.shopline;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ShoplineApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoplineApplication.class, args);
		System.out.println("Se termino se cargar la app...");
	}

}
