package eNum;

public enum Status {
    ACTIVE(1), RETURNED(2), DELAYED(3);
    private final int value;

    Status(int value) {
        this.value = value;
    }

    public static Status getEnumFromInt(int x) {
        for(Status status : values()) {
            if(status.value == x) {
                return status;
            }
        }
        return null;
    }

    public static Status getFromString(String type) {
        for(Status status : Status.values()) {

            if(status.toString().equalsIgnoreCase(type)){
                return status;
            }
        }
        return null;
    }

};