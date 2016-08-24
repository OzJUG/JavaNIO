package org.ozjug.nio2.example;

import static java.nio.charset.StandardCharsets.UTF_8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Ex07OperacoesBasicas {

	public static void main(String[] args) throws IOException {
		// File: Operações basicas
		Path file = Paths.get("/arquivos/oz_jug/3o_encontro/src001.java");

		List<String> lines = Files.readAllLines(file, UTF_8);
		for (String string : lines) {
			System.out.println(string);
		}

		System.out.println();

		byte[] bytes = Files.readAllBytes(file);
		for (byte b : bytes) {
			System.out.print((char) b);
		}
	}

}
