package org.ozjug.nio2.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Ex10ReaderWriter {

	public static void main(String[] args) throws IOException {
		// Leitura (reader) e escrita (Writer)
		Path file = Paths.get("/arquivos/oz_jug/3o_encontro/src001.java");
		Path bkp = Paths.get("/arquivos/oz_jug/3o_encontro/src001.bkp");

		// Nova sintaxe try-with-resource
		try (BufferedReader reader = Files.newBufferedReader(file, StandardCharsets.UTF_8);
				BufferedWriter writer = Files.newBufferedWriter(bkp,
						StandardCharsets.UTF_8, StandardOpenOption.CREATE_NEW)) {
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
				writer.write(String.format("%s%n", line));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
