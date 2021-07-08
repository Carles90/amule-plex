package cloud.carles.amuleplex.application.job;

import cloud.carles.amuleplex.application.ApplicationProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;

@Component
public class AmuleIncomingToPlexMover {
    @Autowired
    private ApplicationProperties properties;

    @EventListener(ApplicationReadyEvent.class)
    public void run() throws IOException, InterruptedException {
        WatchService watchService = FileSystems.getDefault().newWatchService();

        Path listenPath = Paths.get(properties.getAmuleIncomingDirectory());

        listenPath.register(watchService, StandardWatchEventKinds.ENTRY_CREATE);

        WatchKey key;
        while ((key = watchService.take()) != null) {
            for (WatchEvent<?> event : key.pollEvents()) {
                Files.move(
                        Paths.get(properties.getAmuleIncomingDirectory() + "/" + event.context()),
                        Paths.get(properties.getPlexDirectory() + "/" + event.context()),
                        StandardCopyOption.REPLACE_EXISTING
                );

                final File file = new File(properties.getPlexDirectory() + "/" + event.context());
                file.setReadable(true, false);
                file.setExecutable(true, false);
                file.setWritable(true, false);
            }
            key.reset();
        }
    }
}
