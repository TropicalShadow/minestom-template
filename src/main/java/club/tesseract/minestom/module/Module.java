package club.tesseract.minestom.module;

import lombok.AccessLevel;
import lombok.extern.slf4j.Slf4j;

@Slf4j(access = AccessLevel.PROTECTED)
public abstract class Module {

    protected final ModuleHolder holder;

    public Module(ModuleHolder holder) {
        this.holder = holder;
    }


    abstract public void initialise();
    abstract public void close();

}
