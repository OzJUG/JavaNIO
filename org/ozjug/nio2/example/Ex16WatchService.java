package org.ozjug.nio2.example;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchEvent.Kind;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

public class Ex16WatchService {

	public static void main(String[] args) {
		// Watch Service
		final Path path = Paths.get("/arquivos/oz_jug/3o_encontro/WATCH");
		Ex16WatchService watch = new Ex16WatchService();
		try {
			watch.watchDir(path);
		} catch (IOException | InterruptedException ex) {
			System.err.println(ex);
		}
	}

	public void watchDir(Path path) throws IOException, InterruptedException {
		try (WatchService watchService = FileSystems.getDefault()
				.newWatchService()) {
			path.register(watchService, StandardWatchEventKinds.ENTRY_CREATE,
					StandardWatchEventKinds.ENTRY_MODIFY,
					StandardWatchEventKinds.ENTRY_DELETE);
			// start an infinite loop
			while (true) {
				// retrieve and remove the next watch key
				final WatchKey key = watchService.take();
				// get list of pending events for the watch key
				for (WatchEvent<?> watchEvent : key.pollEvents()) {
					// get the kind of event (create, modify, delete)
					final Kind<?> kind = watchEvent.kind();
					// handle OVERFLOW event
					if (kind == StandardWatchEventKinds.OVERFLOW) {
						continue;
					}
					// get the filename for the event
					final WatchEvent<Path> watchEventPath = (WatchEvent<Path>) watchEvent;
					final Path filename = watchEventPath.context();
					// print it out
					System.out.println(kind + " -> " + filename);
				}
				// reset the key
				boolean valid = key.reset();
				// exit loop if the key is not valid (if the directory was
				// deleted, for example)
				if (!valid) {
					break;
				}
			}
		}
	}
}
