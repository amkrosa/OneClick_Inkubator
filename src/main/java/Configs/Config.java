package Configs;

import java.util.HashMap;
import java.util.Map;

public class Config {
    private String language;
    private int timeout;
    private Map<String, Environment> envs = new HashMap<>();

    public Map<String, Environment> getEnvs() {
        return envs;
    }

    public void setEnvs(Map<String, Environment> envs) {
        this.envs = envs;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    @Override
    public String toString() {
        return "Config{" +
                "envs=" + envs +
                ", language='" + language + '\'' +
                '}';
    }
}
