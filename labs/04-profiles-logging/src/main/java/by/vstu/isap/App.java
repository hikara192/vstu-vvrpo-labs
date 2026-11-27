package by.vstu.isap;

import java.io.InputStream;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Демонстрационное приложение для лабораторной работы №4.
 */
public final class App {

    private static final Logger ROOT_LOGGER = LogManager.getRootLogger();
    private static final Logger LOGGER = LogManager.getLogger(App.class);

    private App() {
    }

    public static void main(String[] args) {
        ROOT_LOGGER.info("info message");
        LOGGER.info("Приложение запущено");

        if (ROOT_LOGGER.isDebugEnabled()) {
            ROOT_LOGGER.debug("In debug message");
        }

        printBuildInfo();

        try {
            throw new NullPointerException("Null!!!");
        } catch (NullPointerException ex) {
            ROOT_LOGGER.error("error message: " + ex.getMessage());
            ROOT_LOGGER.fatal("fatal error message: " + ex.getMessage());
        }

        LOGGER.info("Приложение завершило работу");
    }

    private static void printBuildInfo() {
        Properties properties = new Properties();
        try (InputStream input = App.class.getResourceAsStream("/app.properties")) {
            if (input == null) {
                LOGGER.warn("Файл app.properties не найден");
                return;
            }
            properties.load(input);
            LOGGER.info("Сборка: {} {}, профиль: {}",
                    properties.getProperty("app.name"),
                    properties.getProperty("app.version"),
                    properties.getProperty("build.profile"));
        } catch (Exception ex) {
            LOGGER.error("Не удалось прочитать app.properties", ex);
        }
    }
}
