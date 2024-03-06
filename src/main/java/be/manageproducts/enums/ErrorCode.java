package be.manageproducts.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    SUCCESS("200","Success"),
    UNKNOWN("500","System Error! Please try again later"),
    NOT_FOUND("404","Not Found record");
//    public static final String SUCCESS = "200";
//    public static final String NOT_FOUND = "404";
    String errorCode;
    String message;
    }
