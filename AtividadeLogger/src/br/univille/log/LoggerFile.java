package br.univille.log;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LoggerFile implements Logger {
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    private String FileName;

    public LoggerFile(String logFileName) {
        this.FileName = logFileName;
    }

    @Override
    public void log(Level level, String message) {
        String timestamp = dtf.format(LocalDateTime.now());
        String logMessage = String.format("%s [%s] %s", timestamp, level, message);
        writeFile(logMessage);
    }

    private void writeFile(String message) {
        try {
            Files.write(Paths.get(FileName), (message + System.lineSeparator()).getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println("Erro ao salvar no arquivo de log");
            e.printStackTrace();
        }
    }
}

