package org.ozjug.nio2.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Ex06OperacoesBasicas {

	public static void main(String[] args) throws IOException {
		// File: Operações basicas
		Path path = Paths.get("/", "arquivos", "foo", "bar");

		Path dir = Files.createDirectories(path);
		System.out.println(dir);

		path = dir.resolve("test");
		dir = Files.createDirectory(path);
		System.out.println(dir);

		path = dir.resolve("oz.txt");
		Path file = Files.createFile(path);
		System.out.println(file);
	}

}
