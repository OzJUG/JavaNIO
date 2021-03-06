package org.ozjug.nio2.example;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

public class Copy2Test {

	public static void main(String[] args) throws IOException {
		
        Path source = Paths.get("/arquivos/isos/ubuntu-16.04-desktop-amd64.iso");

        //copy file conventional way using Stream
        Path dest = Paths.get("/arquivos/tmp/stream.iso");
        long start = System.nanoTime();
        copyFileUsingStream(source, dest);
        long elapsedTime = System.nanoTime()-start;
        System.out.println("Time taken by Stream Copy = "+TimeUnit.SECONDS.convert(elapsedTime, TimeUnit.NANOSECONDS));
        
        //copy files using java.nio FileChannel
        dest = Paths.get("/arquivos/tmp/fileChannel.iso");
        start = System.nanoTime();
        copyFileUsingChannel(source, dest);
        elapsedTime = System.nanoTime()-start;
        System.out.println("Time taken by Channel Copy = "+TimeUnit.SECONDS.convert(elapsedTime, TimeUnit.NANOSECONDS));
        
        //using Java 7 Files class
        dest = Paths.get("/arquivos/tmp/java7.iso");
        start = System.nanoTime();
        copyFileUsingJava7Files(source, dest);
        elapsedTime = System.nanoTime()-start;
        System.out.println("Time taken by Java7 Files Copy = "+TimeUnit.SECONDS.convert(elapsedTime, TimeUnit.NANOSECONDS));

	}

	private static void copyFileUsingJava7Files(Path source, Path dest) throws IOException {
	    Files.copy(source, dest);
	}
	
	private static void copyFileUsingChannel(Path source, Path dest) throws IOException {
	    FileChannel sourceChannel = null;
	    FileChannel destChannel = null;
	    try {
	        sourceChannel = new FileInputStream(source.toFile()).getChannel();
	        destChannel = new FileOutputStream(dest.toFile()).getChannel();
	        destChannel.transferFrom(sourceChannel, 0, sourceChannel.size());
	       }finally{
	           sourceChannel.close();
	           destChannel.close();
	   }
	}
	
	private static void copyFileUsingStream(Path source, Path dest) throws IOException {
	    InputStream is = null;
	    OutputStream os = null;
	    try {
	        is = Files.newInputStream(source);
	        os = Files.newOutputStream(dest);
	        byte[] buffer = new byte[1024];
	        int length;
	        while ((length = is.read(buffer)) > 0) {
	            os.write(buffer, 0, length);
	        }
	    } finally {
	        is.close();
	        os.close();
	    }
	}
	
}
