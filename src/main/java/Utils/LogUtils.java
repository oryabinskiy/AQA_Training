package Utils;


import org.apache.log4j.Logger;

/**
 * Created by oleg on 09.06.17.
 */
public class LogUtils {

    public static Logger logger = Logger.getLogger(LogUtils.class);

    public static void testStep(String message) {
        logger.info("Test step:" + message);
    }

    public static void info(String message) {
        logger.info(message);
    }

}
