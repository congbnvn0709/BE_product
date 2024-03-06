package be.manageproducts.utils;

public class StringUtils {

    public static boolean isNullOrEmpty(String val) {
        return val == null || val.trim().isBlank() || val.trim().isEmpty();
    }

    public static boolean isNotNullOrEmpty(String val) {
        return !isNullOrEmpty(val);
    }

}
