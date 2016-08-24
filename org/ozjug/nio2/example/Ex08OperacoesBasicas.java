package org.ozjug.nio2.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Ex08OperacoesBasicas {

	public static void main(String[] args) throws IOException {
		// File: Operações basicas
		Path source = Paths.get("/", "arquivos", "oz_jug", "3o_encontro", "echo.sh");
		Path target = Paths.get("/", "arquivos", "oz_jug", "3o_encontro", "echo2.sh");
		Path backup = Paths.get("/", "arquivos", "oz_jug", "3o_encontro", "echo.bkp");

		//Files.copy(source, target);

		Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING,
				StandardCopyOption.COPY_ATTRIBUTES);

		Files.move(source, backup, StandardCopyOption.ATOMIC_MOVE);

		//Files.delete(target);
		//Files.deleteIfExists(target);
	}

}
