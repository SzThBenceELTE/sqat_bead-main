import java.io.InputStream;
import java.util.Properties;

public class Config {
    private static final Properties props = new Properties();

    static {
        try (InputStream in = Config.class
                .getClassLoader()
                .getResourceAsStream("./config.properties")) {
            if (in == null) {
                throw new RuntimeException("config.properties not found");
            }
            props.load(in);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load config.properties", e);
        }
    }

    public static String get(String key) {
        return props.getProperty(key);
    }

    public static int getInt(String key) {
        return Integer.parseInt(props.getProperty(key));
    }

    public static boolean getBool(String key) {
        return Boolean.parseBoolean(props.getProperty(key));
    }
}