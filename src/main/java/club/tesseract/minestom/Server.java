package club.tesseract.minestom;

import club.tesseract.minestom.environment.Environment;
import club.tesseract.minestom.environment.SharedConstants;
import club.tesseract.minestom.module.Module;
import club.tesseract.minestom.module.ModuleHolder;
import club.tesseract.minestom.module.impl.PermissionModule;
import club.tesseract.minestom.utils.entity.player.MinestomPlayer;
import lombok.extern.slf4j.Slf4j;
import net.minestom.server.Auth;
import net.minestom.server.MinecraftServer;

import java.util.ArrayList;
import java.util.Optional;

@Slf4j
public final class Server implements ModuleHolder {

    private final ArrayList<Module> modules = new ArrayList<>();
    private final MinecraftServer minecraftServer = MinecraftServer.init(
            SharedConstants.ENVIRONMENT
                    .test(Environment.DEVELOPMENT) ?
                    new Auth.Offline() :
                    new Auth.Online()
    );

    public void onStart() {

        register(new PermissionModule(this));

        MinestomPlayer.register();
        minecraftServer.start("0.0.0.0", 25565);
    }

    public void onStop() {
        modules.stream().map(Module::getClass).forEach(this::unregister);
        MinecraftServer.stopCleanly();
    }

    @Override
    public <T extends Module> Optional<T> get(Class<T> type) {
        return modules.stream()
                .filter(type::isInstance)
                .map(type::cast)
                .findAny();
    }

    @Override
    public boolean has(Class<? extends Module> type) {
        return modules.stream().anyMatch(type::isInstance);
    }

    @Override
    public <T extends Module> T register(T module) {
        if (this.has(module.getClass())) {
            throw new IllegalArgumentException("module of type " + module.getClass().getName() + " is already registered.");
        }
        try {
            module.initialise();
        } catch (Exception e) {
            log.error("Failed to initialise module {}", module.getClass().getName(), e);
            return null;
        }
        modules.add(module);
        log.info("Registered module {}", module.getClass().getName());
        return module;
    }

    @Override
    public boolean unregister(Class<? extends Module> type) {
        return modules.removeIf(type::isInstance);
    }

}
