package club.tesseract.minestom.module.impl;

import club.tesseract.minestom.module.Module;
import club.tesseract.minestom.module.ModuleHolder;
import club.tesseract.minestom.utils.metrics.SparkManager;

public class SparkModule extends Module {

    private SparkManager sparkManager = null;

    public SparkModule(ModuleHolder holder) {
        super(holder);
    }

    @Override
    public void initialise() {
        sparkManager = new SparkManager();
    }

    @Override
    public void close() {
        if(sparkManager == null)return;
        sparkManager.shutdown();
        sparkManager = null;
    }
}
