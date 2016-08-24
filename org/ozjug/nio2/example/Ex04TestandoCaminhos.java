package org.ozjug.nio2.example;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Ex04TestandoCaminhos {

	public static void main(String[] args) {
		// Testando caminhos
		Path path = Paths.get("top", "foo", "bar");
		boolean isStart = path.startsWith("/");
		System.out.println("Começa com '/'...: " + isStart);
		boolean isEnd = path.endsWith("pot");
		System.out.println("Termina com 'pot': " + isEnd);
		boolean isAbs = path.isAbsolute();
		System.out.println("É absoluto.......: " + isAbs);
	}

}
