package cloud.carles.amuleplex.application.services.amulecmd;

import cloud.carles.amuleplex.application.ApplicationProperties;
import cloud.carles.amuleplex.application.services.amulecmd.command.AmuleCommand;
import cloud.carles.amuleplex.application.services.amulecmd.exception.AmuleCommandException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class AmuleCommandApi {
    @Autowired
    private ApplicationProperties properties;

    public String[] send(AmuleCommand command) throws AmuleCommandException {
        try {
            ProcessBuilder builder = new ProcessBuilder();
            builder.command("amulecmd", "-P", properties.getAmuleCmdPassword(), "-c", command.serialize());
            builder.directory(new File(System.getProperty("user.home")));
            builder.redirectOutput(new File(System.getProperty("user.home") + "/amuleplex_output.txt"));
            builder.redirectError(new File(System.getProperty("user.home") + "/amuleplex_error.txt"));
            Process process = builder.start();
            process.waitFor();

            return getCommandOutput();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            throw new AmuleCommandException(new String[0]);
        }
    }

    public void sendMulti(List<AmuleCommand> commands) {
        try {
            FileWriter fileWriter = new FileWriter(System.getProperty("user.home") + "/amuleplex.cmd");

            for (AmuleCommand command : commands) {
                fileWriter.write(command.serialize() + "\n");
            }

            fileWriter.close();

            ProcessBuilder builder = new ProcessBuilder();
            builder.command("amulecmd", "-P", properties.getAmuleCmdPassword());
            builder.directory(new File(System.getProperty("user.home")));
            builder.redirectInput(new File(System.getProperty("user.home") + "/amuleplex.cmd"));
            builder.redirectOutput(new File(System.getProperty("user.home") + "/amuleplex_output.txt"));
            builder.redirectError(new File(System.getProperty("user.home") + "/amuleplex_error.txt"));
            Process process = builder.start();
            process.waitFor();
            getCommandOutput();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private String[] getCommandOutput() {
        BufferedReader reader;
        List<String> lines = new ArrayList<>();

        try {
            reader = new BufferedReader(new FileReader(
                    System.getProperty("user.home") + "/amuleplex_output.txt"
            ));
            String line = reader.readLine();
            lines.add(line);
            while (line != null) {
                line = reader.readLine();
                lines.add(line);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lines.toArray(String[]::new);
    }

    private String[] getCommandErrorOutput() {
        BufferedReader reader;
        List<String> lines = new ArrayList<>();

        try {
            reader = new BufferedReader(new FileReader(
                    System.getProperty("user.home") + "/amuleplex_error.txt"
            ));
            String line = reader.readLine();
            lines.add(line);
            while (line != null) {
                line = reader.readLine();
                lines.add(line);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lines.toArray(String[]::new);
    }
}
