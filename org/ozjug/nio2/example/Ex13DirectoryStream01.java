package org.ozjug.nio2.example;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Ex13DirectoryStream01 {

	public static void main(String[] args) throws IOException {
		// Listagem de diretorios
		Path dir = Paths.get("/arquivos/oz_jug/3o_encontro");
		try (DirectoryStream<Path> dirStream = Files.newDirectoryStream(dir,
				"*.java")) {
			for (Path path : dirStream) {
				System.out.format("%s%n", path.toAbsolutePath());
			}
		}
	}

}
