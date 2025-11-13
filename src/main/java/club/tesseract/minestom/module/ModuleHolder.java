package club.tesseract.minestom.module;


import java.util.Optional;

public interface ModuleHolder {

    /**
     * Start the Module.
     */
    void onStart();

    /**
     * Stop the Module.
     */
    void onStop();

    // Module Management

    /**
     * Get a Module of the given type.
     * @param type The type of the Module to get.
     * @return The Module of the given type.
     * @param <T> The type of the Module to get.
     */
    <T extends Module> Optional<T> get(Class<T> type);

    /**
     * Check if a Module of the given type is registered.
     * @param type The type of the Module to check.
     * @return True if the Module is registered, false otherwise.
     */
    boolean has(Class<? extends Module> type);

    /**
     * Register a Module.
     * @param Module The Module to register.
     * @return The registered Module.
     * @param <T> The type of the Module to register.
     */
    <T extends Module> T register(T Module);

    /**
     * Unregister a Module.
     * @param type The type of the Module to unregister.
     * @return True if the Module was unregistered, false otherwise.
     */
    boolean unregister(Class<? extends Module> type);

}
