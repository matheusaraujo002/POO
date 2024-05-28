package br.univille.log;

public class Main {
    public static void main(String[] args) {
        // Logger para console
        Logger consoleLogger = LoggerFactory.getLogger(false, null);
        consoleLogger.log(Level.DEBUG, "XFrostM joined the game");
        consoleLogger.log(Level.DEBUG, "Server/PlayerList] XFrostM[/189.31.127.206:59717] logged in with entity id 49314 at ([world]127.82102663466256, 63.0, 108.03505582496136)");
        consoleLogger.log(Level.WARNING, "Loading class `com.mysql.jdbc.Driver'. This is deprecated. The new driver class is `com.mysql.cj.jdbc.Driver'. The driver is automatically registered via the SPI and manual loading of the driver class is generally unnecessary.");
        consoleLogger.log(Level.ERROR, "github.scarsz.discordsrv.DiscordSRV] [DiscordSRV] Your AvatarUrl config option does not contain the {username} placeholder even though this server is using offline UUIDs.");
        consoleLogger.log(Level.DEBUG, "Server/PlayerConnection] XFrostM lost connection: Disconnected");

        // Logger para arquivo
        Logger fileLogger = LoggerFactory.getLogger(true, "log.txt");
        fileLogger.log(Level.DEBUG, "XFrostM joined the game");
        fileLogger.log(Level.DEBUG, "Server/PlayerList] XFrostM[/189.31.127.206:59717] logged in with entity id 49314 at ([world]127.82102663466256, 63.0, 108.03505582496136)");
        fileLogger.log(Level.WARNING, "Loading class `com.mysql.jdbc.Driver'. This is deprecated. The new driver class is `com.mysql.cj.jdbc.Driver'. The driver is automatically registered via the SPI and manual loading of the driver class is generally unnecessary.");
        fileLogger.log(Level.ERROR, "github.scarsz.discordsrv.DiscordSRV] [DiscordSRV] Your AvatarUrl config option does not contain the {username} placeholder even though this server is using offline UUIDs.");
        fileLogger.log(Level.DEBUG, "Server/PlayerConnection] XFrostM lost connection: Disconnected");
    }
}
