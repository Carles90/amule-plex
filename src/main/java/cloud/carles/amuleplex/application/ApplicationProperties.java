package cloud.carles.amuleplex.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class ApplicationProperties {
    @Autowired
    private Environment env;

    public String getAmuleCmdPassword() {
        return env.getProperty("amulecmd.password");
    }

    public String getAmuleIncomingDirectory() {
        return env.getProperty("amule.incoming.directory");
    }

    public String getPlexDirectory() {
        return env.getProperty("plex.directory");
    }
}
