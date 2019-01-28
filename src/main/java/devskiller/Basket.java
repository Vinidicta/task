package devskiller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Basket {
    /**
     * List of item lines present in the basket
     */
    List<ItemLine> items = new ArrayList<>();

    /**
     * Add item to the basket
     *
     * @param itemLine - ignore if nulls
     */
    public void addItem(ItemLine itemLine) {
        items.add(itemLine);
    }

    /**
     * remove item with given id from the basket
     *
     * @param id
     * @return removed item
     */
    public boolean removeItemById(String id) {
        boolean result = false;
        for (int i = 0; i < items.size(); i++) {
            if (id.equals(items.get(i).getId())) {
                result = items.remove(items.get(i));
            }
        }
        return result;
    }

    /**
     * Calculate basket's total. sum of price of an item lines (note that item line can have different quantities)
     *
     * @return basket's total.
     */
    public BigDecimal calculateTotal() {
        BigDecimal total = BigDecimal.ZERO;
        for (int i = 0; i < items.size(); i++) {
            BigDecimal result = BigDecimal.ZERO;
            result = (BigDecimal) items.get(i).getUnitPrice().multiply(new BigDecimal(items.get(i).getQuantity()));
            total = total.add(result);
        }
        return total;
    }

    /**
     * @return an array of all the items in the basket. Should never be null.
     */
    public ItemLine[] getAllItems() {
        ItemLine[] listOfItems = new ItemLine[items.size()];
        listOfItems = items.toArray(listOfItems);
        return listOfItems;
    }

    /**
     * @return number of items in the basket
     */
    public int countAllItemsInBasket() {
        int totalItems = 0;
        for (int i = 0; i < items.size(); i++) {
            totalItems += items.get(i).getQuantity();
        }
        return totalItems;
    }


    /**
     * Check if basket contains item line with given name
     *
     * @param name
     * @return true if item with given name is present in the basket
     */
    public boolean containsItemLineWithName(String name) {
        boolean isContainsItem = false;
        for (int i = 0; i < items.size(); i++) {
            if (name.equals(items.get(i).getName())) {
                isContainsItem = true;
            }
        }
        return isContainsItem;
    }

    /**
     * Get line items from the basket for which quantity field is greater than the passed parameter.
     *
     * @param quantity
     * @return an array of items. should never be null.
     */
    public ItemLine[] getItemLinesWithQuantityGreaterThan(int quantity) {
        ItemLine[] item = new ItemLine[items.size()];
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getQuantity() > quantity) {
                item[i] = items.get(i);
                System.out.println(item[i]);
            }
        }
        return item;
    }
}
