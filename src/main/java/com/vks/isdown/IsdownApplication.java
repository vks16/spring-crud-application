package com.vks.isdown;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class IsdownApplication {

	public static void main(String[] args) {
		SpringApplication.run(IsdownApplication.class, args);
	}

	@GetMapping("/hello/{name}")
	public String hello(@PathVariable String name) {

		return "Hello " + capitalizeString(name) + " " + "https://www.youtube.com/watch?v=pGroX3gmeP8";
	}

	private static String capitalizeString(String str) {
		var strArray = str.split(" ");
		List<String> arr = Stream.of(strArray)
				.map(e -> String.valueOf(e.charAt(0)).toUpperCase() + e.substring(1))
				.toList();


		return String.join(" ", arr);
	}
}
