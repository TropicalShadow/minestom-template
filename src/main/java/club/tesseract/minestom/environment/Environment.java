package club.tesseract.minestom.environment;


public enum Environment {
    PRODUCTION, // Production & Staging environment
    DEPLOYING, // (Staging ~ Production) Deploying environment
    STAGING, // Staging environment only
    TESTING, // (Dev ~ Staging) Testing environment
    DEVELOPMENT, // Development environment only
    ANY; // Any environment


    public boolean test(Environment environment) {
        if (this == ANY) return true;

        return switch (environment) {
            case PRODUCTION -> this == PRODUCTION || this == DEPLOYING;
            case DEPLOYING -> this == STAGING || this == DEPLOYING || this == PRODUCTION;
            case STAGING -> this == STAGING || this == DEPLOYING;
            case TESTING -> this == DEVELOPMENT || this == TESTING || this == STAGING;
            case DEVELOPMENT -> this == DEVELOPMENT || this == TESTING;
            default -> this == environment;
        };
    }
}
