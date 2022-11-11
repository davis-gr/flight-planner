package io.codelex.flightplanner.api;

import javax.validation.constraints.NotNull;
import java.util.Objects;

public class SearchFlightsRequest {

    @NotNull
    private String from;
    @NotNull
    private String to;
    @NotNull
    private String departureDate;

    public SearchFlightsRequest(String from, String to, String departureDate) {
        this.from = from;
        this.to = to;
        this.departureDate = departureDate;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SearchFlightsRequest that)) return false;
        return getFrom().equals(that.getFrom()) && getTo().equals(that.getTo()) && getDepartureDate().equals(that.getDepartureDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFrom(), getTo(), getDepartureDate());
    }

    @Override
    public String toString() {
        return "SearchFlightsRequest{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", departureDate='" + departureDate + '\'' +
                '}';
    }
}
