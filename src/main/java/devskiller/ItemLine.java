package devskiller;

import java.math.BigDecimal;
import java.util.Objects;

public class ItemLine {
    /**
     * Id of an item
     */
    private String id;
    /**
     * name of an item
     */
    private String name;
    /**
     * Price of one unit ot this item (e.g. for quantity = 1)
     */
    private BigDecimal unitPrice;

    /**
     * Quantity of the item
     */
    private int quantity;

    public ItemLine(String id, String name, BigDecimal unitPrice, int quantity) {
        this.id = id;
        this.name = name;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemLine itemLine = (ItemLine) o;
        return quantity == itemLine.quantity &&
                Objects.equals(id, itemLine.id) &&
                Objects.equals(name, itemLine.name) &&
                Objects.equals(unitPrice, itemLine.unitPrice);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, unitPrice, quantity);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ItemLine{");
        sb.append("id='").append(id).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", unitPrice=").append(unitPrice);
        sb.append(", quantity=").append(quantity);
        sb.append('}');
        return sb.toString();
    }
}
