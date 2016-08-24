package org.ozjug.nio2.example;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Ex14DirectoryStream02 {

	public static void main(String[] args) throws IOException {
		// Listagem de diretorios
		Path dir = Paths.get("/arquivos/oz_jug/3o_encontro");

		/*DirectoryStream.Filter<Path> filter = new DirectoryStream.Filter<Path>() {
			public boolean accept(Path entry) throws IOException {
				return Files.size(entry) > 1024;
			}
		};*/
		
		DirectoryStream.Filter<Path> filter = entry -> Files.size(entry) > 1024;
		
		try (DirectoryStream<Path> dirStream = Files.newDirectoryStream(dir,
				filter)) {
			for (Path path : dirStream) {
				System.out.format("%s%n", path.toAbsolutePath());
			}
		}
	}

}
