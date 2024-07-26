package co.develhope.customQueries_1.entities;

import co.develhope.customQueries_1.enumerated.StatusFlightEnum;
import jakarta.persistence.*;

import javax.swing.*;

@Entity
@Table(name = "flight")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column
    private String  description;

    @Column
    private String fromAirport;

    @Column
    private String toAirport;

    @Column
    private StatusFlightEnum status;

    public Flight() {
    }

    public Flight(Integer id, String description, String fromAirport, String toAirport, StatusFlightEnum status) {
        this.id = id;
        this.description = description;
        this.fromAirport = fromAirport;
        this.toAirport = toAirport;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFromAirport() {
        return fromAirport;
    }

    public void setFromAirport(String fromAirport) {
        this.fromAirport = fromAirport;
    }

    public String getToAirport() {
        return toAirport;
    }

    public void setToAirport(String toAirport) {
        this.toAirport = toAirport;
    }

    public StatusFlightEnum getStatus() {
        return status;
    }

    public void setStatus(StatusFlightEnum status) {
        this.status = status;
    }
}
