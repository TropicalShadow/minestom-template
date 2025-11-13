package club.tesseract.minestom.module.impl;

import club.tesseract.minestom.module.Module;
import club.tesseract.minestom.module.ModuleHolder;
import club.tesseract.minestom.permission.LuckpermsPermission;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public final class PermissionModule extends Module {

    private final boolean luckpermsExists = classExists("me.lucko.luckperms.minestom.LPMinestomPlugin");;

    private LuckpermsPermission luckPermsPermission = null;

    public PermissionModule(ModuleHolder holder) {
        super(holder);
    }

    @Override
    public void initialise() {
        if(!luckpermsExists || luckPermsPermission != null)return;
        luckPermsPermission = new LuckpermsPermission();
        log.info("Luckperms permission system loaded");
    }

    @Override
    public void close() {
        if(luckPermsPermission == null)return;
        luckPermsPermission.shutdown();
        luckPermsPermission = null;
    }


    private static boolean classExists(String className) {
        try {
            Class.forName(className);
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }
}
