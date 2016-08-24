package org.ozjug.nio2.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Ex09LinksSimbolicos {

	public static void main(String[] args) throws IOException {
		// Links Simbolicos
		Path link = Paths.get("/", "arquivos", "oz_jug", "link_demo");
		System.out.println("Link........: " + link);

		Path target = Paths.get("/", "arquivos", "oz_jug", "3o_encontro", "path001.png");
		System.out.println("Alvo........: " + target);

		Files.createSymbolicLink(link, target);
		boolean isSymLink = Files.isSymbolicLink(link);
		System.out.println("Eh SymLink..: " + isSymLink);
		boolean isSame = Files.isSameFile(link, target);
		System.out.println("Mesmo arqivo: " + isSame);

		Path path = Files.readSymbolicLink(link);
		System.out.println("\n" + path);

	}

}
