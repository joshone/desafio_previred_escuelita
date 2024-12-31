package cl.previred.desafio.status;

public enum StatusEnum {
    ACTIVE, DELETED;

    public static StatusEnum getEnumByName(String name) {
        for (StatusEnum value : values()) {
            if (value.name().equalsIgnoreCase(name)) {
                return value;
            }
        }
        return null;
    }
}
