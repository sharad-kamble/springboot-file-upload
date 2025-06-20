package com.example.demo.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileController {

	@Value("${location}")
	String location;

	@PostMapping("/upload")
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file)
			throws IllegalStateException, IOException {

		if (file.isEmpty()) {

			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("File could not found");

		}

		try {
			String filePath=location+""+ File.separator+file.getOriginalFilename();
			File dest = new File(filePath);
			file.transferTo(dest);
			return ResponseEntity.ok("File uploaded sucessfully! " + file.getOriginalFilename());
		} catch (IOException e) {

			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("File uploaded failed");

		}

	}

}
