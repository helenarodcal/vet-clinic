package serenitylabs.tutorials.vetclinic.sales.model;

import serenitylabs.tutorials.vetclinic.sales.model.LineItem;
import serenitylabs.tutorials.vetclinic.sales.model.TaxRate;

import java.util.function.Function;

//public interface TaxRateCalculator {
//    TaxRate rateFor(LineItem item);
//}
public interface TaxRateCalculator extends Function<LineItem, TaxRate> {}
