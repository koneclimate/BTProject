package th.bt.btportal.utils;

import java.util.UUID;

public class GenerateUtil {
    public static String genUUIDAll() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
}
