package org.ozjug.nio2.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.GroupPrincipal;
import java.nio.file.attribute.PosixFileAttributes;
import java.nio.file.attribute.PosixFilePermissions;
import java.nio.file.attribute.UserPrincipal;

public class Ex12PosixAttributes {

	public static void main(String[] args) throws IOException {
		// Posix attributes
		Path path = Paths.get("/arquivos/oz_jug/3o_encontro/src001.java");
		PosixFileAttributes posixAttr = Files.readAttributes(path,
				PosixFileAttributes.class);

		UserPrincipal owner = posixAttr.owner();
		System.out.format("Dono......: %s%n", owner);
		GroupPrincipal group = posixAttr.group();
		System.out.format("Grupo.....: %s%n", group);
		String perms = PosixFilePermissions.toString(posixAttr.permissions());
		System.out.format("Permissoes: %s%n", perms);

		Files.setPosixFilePermissions(path,
				PosixFilePermissions.fromString("rwxrwxrwx"));
	}
}
