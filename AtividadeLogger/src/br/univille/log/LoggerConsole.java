package br.univille.log;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LoggerConsole implements Logger {
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    @Override
    public void log(Level level, String message) {
        String timestamp = dtf.format(LocalDateTime.now());
        String logMessage = String.format("%s [%s] %s", timestamp, level, message);
        writeConsole(level, logMessage);
    }

    private void writeConsole(Level level, String message) {
        String colorCode;

        switch (level) {
            case DEBUG:
                colorCode = "\u001B[32m"; // Verde
                break;
            case WARNING:
                colorCode = "\u001B[33m"; // Amarelo
                break;
            case ERROR:
                colorCode = "\u001B[31m"; // Vermelho
                break;
            default:
                colorCode = "\u001B[0m"; // Reset
        }

        System.out.println(colorCode + message + "\u001B[0m"); // Resetar cor após a mensagem
    }
}

