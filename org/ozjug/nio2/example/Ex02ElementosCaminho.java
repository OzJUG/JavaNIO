package org.ozjug.nio2.example;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Ex02ElementosCaminho {
	public static void main(String[] args) {
		
		// Acessando elementos de um caminho
		Path path = Paths.get("/","foo","bar","x");
		Path fileName = path.getFileName();
		System.out.println("Nome do arquivo: " + fileName);
		Path parent = path.getParent();
		System.out.println("Diretório pai..: " + parent);
		Path root = path.getRoot();
		System.out.println("Diretório raiz.: " + root);
		Path subpath = path.subpath(1,3);
		System.out.println("Subcaminho.....: " + subpath);
		System.out.println("Qtd elementos..:" + path.getNameCount());
		System.out.println();
		
		System.out.println("Elementos do caminho:");
		for (Path element : path ) {
			System.out.format("- %s%n", element);
		}
		
	}
}
