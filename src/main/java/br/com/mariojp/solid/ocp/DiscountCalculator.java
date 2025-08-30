package br.com.mariojp.solid.ocp;

import java.util.HashMap;
import java.util.Map;

public class DiscountCalculator {
    private final Map<CustomerType, PolicyDiscount> policies = new HashMap<>();
    public DiscountCalculator (){
        policies.put(CustomerType.REGULAR, amount -> amount * 0.95);
        policies.put(CustomerType.PREMIUM, amount -> amount * 0.90);
        policies.put(CustomerType.PARTNER, amount -> amount * 0.88);
    }
    public double apply(double amount, CustomerType type){
        PolicyDiscount policy = policies.getOrDefault(type, a -> a);
        return policy.apply(amount);
    }
}
