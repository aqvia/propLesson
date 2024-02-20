import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AppConfig {
    public static void main(String[] args) {
        Properties prop = new Properties();

        try (InputStream input = AppConfig.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
                return;
            }
            prop.load(input);
            System.out.println("Database URL: " + prop.getProperty("database.url"));
            System.out.println("Database User: " + prop.getProperty("database.user"));
            System.out.println("Database Password: " + prop.getProperty("database.password"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
