package pl.hk.zadanie_21_1;

public enum ProductCategory {
    FOOD("spozywcze"), AGD("domowe"), OTHER("inne");

    private final String description;

    ProductCategory(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
