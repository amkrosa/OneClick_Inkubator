package Configs;

public class Environment {
    private String url;
    private EnvironmentType env;
    private boolean active;

    Environment() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public EnvironmentType getEnv() {
        return env;
    }

    public void setEnv(EnvironmentType env) {
        this.env = env;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Environment{" +
                "url='" + url + '\'' +
                ", env=" + env +
                ", active=" + active +
                '}';
    }
}
