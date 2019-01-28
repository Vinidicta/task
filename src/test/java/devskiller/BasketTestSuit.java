package devskiller;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class BasketTestSuit {
    final Basket basket = new Basket();
    final ItemLine item1 = new ItemLine("B001", "A", new BigDecimal("10.50"), 5);
    final ItemLine item2 = new ItemLine("B002", "B", new BigDecimal("5.50"), 2);
    final ItemLine item3 = new ItemLine("B003", "C", new BigDecimal("8.20"), 3);

    @Test
    public void addItem() {
        //given
        //when
        basket.addItem(item1);
        boolean containsOneItem = basket.containsItemLineWithName("A");

        //then
        Assert.assertTrue(containsOneItem);
    }

    @Test
    public void removeItemById() {
        //given
        basket.addItem(item1);
        basket.addItem(item2);

        //when
        basket.removeItemById("B001");
        boolean isContainsItem1 = basket.containsItemLineWithName("A");

        //then
        Assert.assertFalse(isContainsItem1);

    }

    @Test
    public void calculateTotal() {
        //given
        basket.addItem(item1);
        basket.addItem(item2);
        basket.addItem(item3);
        //when
        final BigDecimal total = basket.calculateTotal();

        //then
        BigDecimal expectedTotal = new BigDecimal("88.10");
        Assert.assertEquals(expectedTotal, total);
    }

    @Test
    public void getAllItems() {
        //given
        basket.addItem(item1);
        basket.addItem(item2);
        basket.addItem(item3);
        //when
        final ItemLine[] allItems = basket.getAllItems();
        final List<ItemLine> allItemsList = Arrays.asList(allItems);

        //then
        Assert.assertTrue("Item with id: " + basket.containsItemLineWithName("A") + " should be present in the all items array", allItemsList.contains(item1));
        Assert.assertTrue("Item with id: " + basket.containsItemLineWithName("B") + " should be present in the all items array", allItemsList.contains(item2));
        Assert.assertTrue("Item with id: " + basket.containsItemLineWithName("C") + " should be present in the all items array", allItemsList.contains(item3));

    }

    @Test
    public void countAllItemsInBasket() {
        //given
        basket.addItem(item1);
        basket.addItem(item2);
        basket.addItem(item3);
        //when
        final int itemsQuantity = basket.countAllItemsInBasket();

        //then
        Assert.assertEquals(10, itemsQuantity);

    }

    @Test
    public void containsItemWithName() {
        //given
        basket.addItem(item1);
        basket.addItem(item2);
        basket.addItem(item3);

        //when
        boolean contains = basket.containsItemLineWithName("A");

        //then
        Assert.assertTrue(contains);
    }

    @Test
    public void getItemLinesWithQuantityGreaterThan() {

        //given
        basket.addItem(item1);
        basket.addItem(item2);
        basket.addItem(item3);
        //when
        final ItemLine[] itemLines = basket.getItemLinesWithQuantityGreaterThan(4);

        //then
        Assert.assertTrue("Array should contain item B003", Arrays.asList(itemLines).contains(item1));

    }
}
