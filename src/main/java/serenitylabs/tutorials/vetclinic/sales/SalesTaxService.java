package serenitylabs.tutorials.vetclinic.sales;

import serenitylabs.tutorials.vetclinic.sales.model.LineItem;
import serenitylabs.tutorials.vetclinic.sales.model.ProductCategory;
import serenitylabs.tutorials.vetclinic.sales.model.SalesTax;
import serenitylabs.tutorials.vetclinic.sales.model.TaxRateNames;

import java.util.HashMap;
import java.util.Map;

public class SalesTaxService {
    private final static double NINE_PERCENT = 0.09;
    private final static double ZERO_PERCENT = 0.00;
    private final static double TWENTYTHREE_PERCENT = 0.23;

    private static final Map<ProductCategory, Double> TAX_RATE_BY_CATEGORY = new HashMap<>();
    private static final Map<Double, TaxRateNames> TAX_NAME_BY_RATE = new HashMap<>();

    static {
        TAX_RATE_BY_CATEGORY.put(ProductCategory.Medicine, ZERO_PERCENT);
        TAX_RATE_BY_CATEGORY.put(ProductCategory.Books, ZERO_PERCENT);
        TAX_RATE_BY_CATEGORY.put(ProductCategory.Snacks, NINE_PERCENT);
        TAX_RATE_BY_CATEGORY.put(ProductCategory.SoftDrinks, NINE_PERCENT);
        TAX_RATE_BY_CATEGORY.put(ProductCategory.Toys, TWENTYTHREE_PERCENT);
        TAX_RATE_BY_CATEGORY.put(ProductCategory.PetFood, TWENTYTHREE_PERCENT);
    }

    static {
        TAX_NAME_BY_RATE.put(ZERO_PERCENT, TaxRateNames.Zero);
        TAX_NAME_BY_RATE.put(NINE_PERCENT, TaxRateNames.Reduced);
        TAX_NAME_BY_RATE.put(TWENTYTHREE_PERCENT, TaxRateNames.Standard);
    }


    public SalesTax salesTaxEntryFor(LineItem item) {
        Double itemRate = TAX_RATE_BY_CATEGORY.get(item.getCategory());
        double itemUnitPrice =  item.getUnitCost();
        return SalesTax.atRateOf(itemRate).withName(TAX_NAME_BY_RATE.get(itemRate).name()).forAnAmountOf(itemUnitPrice * itemRate);
    }
}
