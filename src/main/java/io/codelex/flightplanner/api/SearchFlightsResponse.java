package io.codelex.flightplanner.api;

import io.codelex.flightplanner.flights.objects.Flight;

import java.util.List;

public class SearchFlightsResponse {

    private List<Flight> items;
    private int page;
    private int totalItems;

    public SearchFlightsResponse(List<Flight> items, int page, int totalItems) {
        this.items = items;
        this.page = page;
        this.totalItems = totalItems;
    }

    public List<Flight> getItems() {
        return items;
    }

    public void setItems(List<Flight> items) {
        this.items = items;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }

    @Override
    public String toString() {
        return "SearchFlightsResponse{" +
                "items=" + items +
                ", page=" + page +
                ", totalItems=" + totalItems +
                '}';
    }
}
