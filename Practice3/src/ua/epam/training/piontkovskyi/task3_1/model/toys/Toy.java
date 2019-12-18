package ua.epam.training.piontkovskyi.task3_1.model.toys;

public abstract class Toy {
    protected String country;
    protected String material;
    protected String name;
    protected double price;
    protected int ageLimit;

    public void setCountry(String country) {
        this.country = country;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setAgeLimit(int ageLimit) {
        this.ageLimit = ageLimit;
    }

    public String getCountry() {
        return country;
    }

    public String getMaterial() {
        return material;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public int getAgeLimit() {
        return ageLimit;
    }

    public static abstract class BaseBuilder<U extends Toy, V extends BaseBuilder> {
        protected U actualClass;
        protected V actualBuilder;

        protected abstract U getActual();

        protected abstract V getActualBuilder();

        protected BaseBuilder() {
            actualClass = getActual();
            actualBuilder = getActualBuilder();
        }

        public V withCountry(String country) {
            actualClass.setCountry(country);
            return actualBuilder;
        }

        public V withMaterial(String material) {
            actualClass.setMaterial(material);
            return actualBuilder;
        }

        public V withName(String name) {
            actualClass.setName(name);
            return actualBuilder;
        }

        public V withPrice(double price) {
            actualClass.setPrice(price);
            return actualBuilder;
        }

        public V withAgeLimit(int ageLimit) {
            actualClass.setAgeLimit(ageLimit);
            return actualBuilder;
        }

        public abstract U build();

    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                " country=" + country +
                ", material=" + material +
                ", name=" + name +
                ", price=" + price +
                ", ageLimit=" + ageLimit;
    }
}
