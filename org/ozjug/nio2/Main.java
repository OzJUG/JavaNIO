package org.ozjug.nio2;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
	public static void main(String[] args) throws IOException {
		// Combinando caminhos
		Path foo = Paths.get("foo");
		System.out.println(foo);

		Path bar = foo.resolve("bar");
		System.out.println(bar);
		Path baz = foo.resolveSibling("baz");
		System.out.println(baz);

		Path qux = Paths.get("baz", "qux");
		Path relative = foo.relativize(qux);
		System.out.println(relative);
	}
}
