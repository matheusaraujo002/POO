package br.univille.log;

public class LoggerFactory {
    public static Logger getLogger(boolean logToFile, String fileName) {
        if (logToFile) {
            return new LoggerFile(fileName);
        } else {
            return new LoggerConsole();
        }
    }
}

