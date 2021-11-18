package serenitylabs.tutorials.vetclinic.sales.model;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import static serenitylabs.tutorials.vetclinic.sales.model.ProductCategory.*;

public class SalesTaxService {
    //    private final static double NINE_PERCENT = 0.09;
//    private final static double ZERO_PERCENT = 0.00;
//    private final static double TWENTYTHREE_PERCENT = 0.23;
//
//    private static final Map<ProductCategory, Double> TAX_RATE_BY_CATEGORY = new HashMap<>();
//    private static final Map<Double, TaxRateNames> TAX_NAME_BY_RATE = new HashMap<>();
//
//    static {
//        TAX_RATE_BY_CATEGORY.put(ProductCategory.Medicine, ZERO_PERCENT);
//        TAX_RATE_BY_CATEGORY.put(ProductCategory.Books, ZERO_PERCENT);
//        TAX_RATE_BY_CATEGORY.put(ProductCategory.Snacks, NINE_PERCENT);
//        TAX_RATE_BY_CATEGORY.put(ProductCategory.SoftDrinks, NINE_PERCENT);
//        TAX_RATE_BY_CATEGORY.put(ProductCategory.Toys, TWENTYTHREE_PERCENT);
//        TAX_RATE_BY_CATEGORY.put(ProductCategory.PetFood, TWENTYTHREE_PERCENT);
//    }
//
//    static {
//        TAX_NAME_BY_RATE.put(ZERO_PERCENT, TaxRateNames.Zero);
//        TAX_NAME_BY_RATE.put(NINE_PERCENT, TaxRateNames.Reduced);
//        TAX_NAME_BY_RATE.put(TWENTYTHREE_PERCENT, TaxRateNames.Standard);
//    }
//
//
//    public SalesTax salesTaxEntryFor(LineItem item) {
//        Double itemRate = TAX_RATE_BY_CATEGORY.get(item.getCategory());
//        double itemUnitPrice =  item.getUnitCost();
//        return SalesTax.atRateOf(itemRate).withName(TAX_NAME_BY_RATE.get(itemRate).name()).forAnAmountOf(itemUnitPrice * itemRate);
//    }
    public SalesTax salesTaxEntryFor(LineItem item) {
//            return SalesTax.atRateOf(0.09).withName("Reduced").forAnAmountOf(0.27);
        TaxRate applicableTaxRate = taxRateFor(item);
        return SalesTax.atRateOf(applicableTaxRate.getRate())
                .withName(applicableTaxRate.getName())
                .forAnAmountOf(item.getTotal() * applicableTaxRate.getRate());
    }

//    static Function<LineItem, TaxRate> SOME_RATE = new TaxRate(0.00, "TestRate");
    static TaxRateCalculator STANDARD_RATE =
            (item -> new TaxRate(0.23, "Standard"));
    static TaxRateCalculator ZERO_RATE =
            (item -> new TaxRate(0.00, "Zero"));
    static TaxRateCalculator REDUCED_RATE =
            (item -> {
                double rate = (item.getTotal() > 100.0) ? 0.135 : 0.09;
                return new TaxRate(rate, "Reduced");

            });

    private static Map<ProductCategory, TaxRateCalculator> CALCULATOR_PER_PRODUCT = new HashMap<>();

    static {
//        CALCULATOR_PER_PRODUCT.put(Snacks, new ReducedRateCalculator());
//        CALCULATOR_PER_PRODUCT.put(SoftDrinks, new ReducedRateCalculator());
//        CALCULATOR_PER_PRODUCT.put(Books, new ZeroRateCalculator());
//        CALCULATOR_PER_PRODUCT.put(Medicine, new ZeroRateCalculator());
        CALCULATOR_PER_PRODUCT.put(Snacks,  REDUCED_RATE);
        CALCULATOR_PER_PRODUCT.put(SoftDrinks,REDUCED_RATE);
        CALCULATOR_PER_PRODUCT.put(Books, ZERO_RATE);
        CALCULATOR_PER_PRODUCT.put(Medicine, ZERO_RATE);
    }

    private TaxRate taxRateFor(LineItem item) {
//        return CALCULATOR_PER_PRODUCT
//                .getOrDefault(item.getCategory(), new StandardRateCalculator())
//                .rateFor(item);
        return CALCULATOR_PER_PRODUCT
                .getOrDefault(item.getCategory(), STANDARD_RATE)
                .apply(item);
//                .get(item.getCategory()).rateFor(item);

//        TaxRateCalculator taxRateCalculator = new ReducedRateCalculator();
//        return taxRateCalculator.rateFor(item);
    }


}
