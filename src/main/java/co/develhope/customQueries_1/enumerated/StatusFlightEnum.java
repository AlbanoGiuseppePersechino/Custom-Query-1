package co.develhope.customQueries_1.enumerated;

public enum StatusFlightEnum {

    ON_TIME("On Time"),
    DELAYED("Delayed"),
    CANCELLED("Cancelled");

    private String description;

    StatusFlightEnum(String description){
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
