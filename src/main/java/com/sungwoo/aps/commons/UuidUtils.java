package com.sungwoo.aps.commons;

import java.util.UUID;

/**
 * @author phloc
 */
public class UuidUtils {

    public static String generateUuid(int length) {
        UUID uuid = UUID.randomUUID();
        return uuid.toString().substring(0, length - 1);
    }

    public static UUID generateUuid() {
        return UUID.randomUUID();
    }
}
