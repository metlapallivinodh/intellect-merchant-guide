package test.intellect.merchantguide.model;

public enum RomanCurrency {

    I(1d), V(5d), X(10d), L(50d), C(100d), D(500d), M(1000d);

    private Double value;

    RomanCurrency(Double value) {
        this.value = value;
    }

    public Double getValue() {
        return value;
    }
}
