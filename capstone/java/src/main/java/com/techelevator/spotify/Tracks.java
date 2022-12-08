package com.techelevator.spotify;

import java.util.List;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "href",
        "items",
        "limit",
        "next",
        "offset",
        "previous",
        "total"
})
@Generated("jsonschema2pojo")

public class Tracks {

    @JsonProperty("href")
    private String searchHref;
    @JsonProperty("items")
    private List<Item> items = null;
    @JsonProperty("limit")
    private Integer searchLimit;
    @JsonProperty("next")
    private String next;
    @JsonProperty("offset")
    private Integer offset;
    @JsonProperty("previous")
    private Object previous;
    @JsonProperty("total")
    private Integer total;

    @JsonProperty("href")
    public String getSearchHref() {
        return searchHref;
    }

    @JsonProperty("href")
    public void setSearchHref(String searchHref) {
        this.searchHref = searchHref;
    }

    @JsonProperty("items")
    public List<Item> getItems() {
        return items;
    }

    @JsonProperty("items")
    public void setItems(List<Item> items) {
        this.items = items;
    }

    @JsonProperty("limit")
    public Integer getSearchLimit() {
        return searchLimit;
    }

    @JsonProperty("limit")
    public void setSearchLimit(Integer searchLimit) {
        this.searchLimit = searchLimit;
    }

    @JsonProperty("next")
    public String getNext() {
        return next;
    }

    @JsonProperty("next")
    public void setNext(String next) {
        this.next = next;
    }

    @JsonProperty("offset")
    public Integer getOffset() {
        return offset;
    }

    @JsonProperty("offset")
    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    @JsonProperty("previous")
    public Object getPrevious() {
        return previous;
    }

    @JsonProperty("previous")
    public void setPrevious(Object previous) {
        this.previous = previous;
    }

    @JsonProperty("total")
    public Integer getTotal() {
        return total;
    }

    @JsonProperty("total")
    public void setTotal(Integer total) {
        this.total = total;
    }


}
