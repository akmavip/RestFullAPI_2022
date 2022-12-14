package com.restfull.oop.exception.errors;

public enum ErrorEnum {
    PRODUCT_NOT_FOUND("TradingProduct","NotFound", "Trading product is not found"),
    PRODUCT_EXISTED("TradingProduct","Existed", "Trading product is existed"),
    PRODUCT_IS_EMPTY("TradingProduct", "IsEmpty", "Trading product of this product is empty"),
    PRODUCT_DUPLICATE("PromotionTradingProduct","Duplicate","Trading product is duplicate in promotion");

    // ... add more cases here ...
    private final String entityName;
    private final String errorKey;
    private String message;

    public String getMessage() {
        message = getEntityName() + "." + getErrorKey();
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getEntityName() {
        return entityName;
    }

    public String getErrorKey() {
        return errorKey;
    }

    ErrorEnum(String entityName, String errorKey, String message) {
        this.entityName = entityName;
        this.errorKey = errorKey;
        this.message = message;
    }
}
