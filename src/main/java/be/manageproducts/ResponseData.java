package be.manageproducts;

import be.manageproducts.enums.ErrorCode;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseData {
    private Object data;
    private String message;
    private String errorCode;

    public static  ResponseData OK() {
        return new ResponseData(null, ErrorCode.SUCCESS.getMessage(), ErrorCode.SUCCESS.getErrorCode());
    }
}
