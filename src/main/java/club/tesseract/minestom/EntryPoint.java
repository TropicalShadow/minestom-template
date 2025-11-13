package club.tesseract.minestom;

public class EntryPoint {

    static void main() {
        Server server = new Server();
        server.onStart();

        Runtime.getRuntime().addShutdownHook(new Thread(server::onStop));
    }
}
