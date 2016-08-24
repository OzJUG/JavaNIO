package org.ozjug.nio2.example;

import java.io.File;
import java.net.URI;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Ex01CriandoCaminhos {
	public static void main(String[] args) {
		// Criando Path
		Path path1 = FileSystems.getDefault().getPath("/foo");
		System.out.println("FileSystems......: " + path1);

		Path path2 = Paths.get("/foo");
		System.out.println("Paths.get(String): " + path2);

		URI uri = URI.create("file:///foo");
		Path path3 = Paths.get(uri);
		System.out.println("Paths.get(URI)...: " + path3);

		File file = new File("/foo");
		Path path4 = file.toPath();
		System.out.println("File.toPath()....: " + path4);
		
	}
}
