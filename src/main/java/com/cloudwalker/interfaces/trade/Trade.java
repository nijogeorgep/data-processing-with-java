/**
 *
 */
package com.cloudwalker.interfaces.trade;

import java.util.List;

/**
 * @author nijogeorgep
 *
 */
public class Trade {
    private Integer Quantity;
    private String issuer;
    private String status;
    private List<String> items;

    /**
     *
     */
    public Trade() {
        super();
    }

    /**
     * @param quantity
     * @param issuer
     * @param status
     */
    public Trade(Integer quantity, String issuer, String status) {
        super();
        Quantity = quantity;
        this.issuer = issuer;
        this.status = status;
    }

    public Integer getQuantity() {
        return Quantity;
    }

    public void setQuantity(Integer quantity) {
        Quantity = quantity;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }

}
