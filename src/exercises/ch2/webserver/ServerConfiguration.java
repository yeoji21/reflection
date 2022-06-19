package exercises.ch2.webserver;

import java.net.InetSocketAddress;

public class ServerConfiguration {
    private static ServerConfiguration serverConfigurationInstance;

    private final InetSocketAddress serverAddress;
    private final String greetingMessage;

    private ServerConfiguration(int port, String greetingMessage) {
        this.greetingMessage = greetingMessage;
        this.serverAddress = new InetSocketAddress(port);
        if (serverConfigurationInstance == null) {
            serverConfigurationInstance = this;
        }
    }

    public static ServerConfiguration getInstance() {
        return serverConfigurationInstance;
    }

    public InetSocketAddress getServerAddress() {
        return this.serverAddress;
    }

    public String getGreetingMessage() {
        return this.greetingMessage;
    }
}
