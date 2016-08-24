package org.ozjug.nio2.example;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Ex05OutrasOperacoes {

	public static void main(String[] args) throws IOException {
		// Outras Operações
		Path path = Paths.get("./top", "foo", "bar");

		Path normal = path.normalize();
		System.out.println(normal);
		Path abs = path.toAbsolutePath();
		System.out.println(abs);
		Path real = path.toRealPath();
		System.out.println(real);
		URI uri = path.toUri();
		System.out.println(uri);
		File file = path.toFile();
		System.out.println(file);

	}

}
