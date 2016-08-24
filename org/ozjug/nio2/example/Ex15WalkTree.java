package org.ozjug.nio2.example;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class Ex15WalkTree {

	public static void main(String[] args) throws IOException {
		// Percorrendo arvores de diretorios
		Path start = Paths.get("/arquivos/oz_jug/3o_encontro");
		Files.walkFileTree(start, new SimpleFileVisitor<Path>(){
		   public FileVisitResult preVisitDirectory(Path dir,
		      BasicFileAttributes attrs) throws IOException {
		      System.out.format("preVisitDirectory: %s%n", dir);
		      return FileVisitResult.CONTINUE;
		   }

		   public FileVisitResult visitFile(Path file,
		      BasicFileAttributes attrs) throws IOException {
			   System.out.format("visitFile: %s%n", file);
		      return FileVisitResult.CONTINUE;
		   }
		});
	}

}
