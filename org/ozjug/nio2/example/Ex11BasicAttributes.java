package org.ozjug.nio2.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;

public class Ex11BasicAttributes {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Path path = Paths.get("/arquivos/oz_jug/3o_encontro/src001.java");
		BasicFileAttributes basicAttr = Files.readAttributes(path,
				BasicFileAttributes.class);

		Object key = basicAttr.fileKey();
		System.out.format("Chave...........: %s%n", key);
		long size = basicAttr.size();
		System.out.format("Tamanho.........: %s bites%n", size);
		boolean isDirectory = basicAttr.isDirectory();
		System.out.format("Eh diretorio....: %s%n", isDirectory);
		FileTime lastModified = basicAttr.lastModifiedTime();
		System.out.format("Ultima alteracao: %s%n", lastModified);
	}

}
