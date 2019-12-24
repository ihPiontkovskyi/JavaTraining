package ua.epam.training.piontkovskyi.model.data;

public enum Manufacturer {
    AUDI(CarClass.BUSINESS),
    BMW(CarClass.REPRESENTATIVE),
    FORD(CarClass.ECONOMY),
    HONDA(CarClass.ECONOMY),
    HYUNDAI(CarClass.ECONOMY),
    JEEP(CarClass.BUSINESS),
    KIA(CarClass.ECONOMY),
    LAND_ROVER(CarClass.BUSINESS),
    LEXUS(CarClass.REPRESENTATIVE),
    MAZDA(CarClass.ECONOMY),
    MERCEDES_BENZ(CarClass.REPRESENTATIVE),
    MITSUBISHI(CarClass.ECONOMY),
    NISSAN(CarClass.ECONOMY),
    PORSCHE(CarClass.REPRESENTATIVE),
    RENAULT(CarClass.ECONOMY),
    SUBARU(CarClass.ECONOMY),
    SUZUKI(CarClass.ECONOMY),
    TESLA(CarClass.REPRESENTATIVE),
    TOYOTA(CarClass.BUSINESS),
    VOLKSWAGEN(CarClass.ECONOMY),
    VOLVO(CarClass.ECONOMY),;
    private CarClass carClass;

    private Manufacturer(CarClass carClass)
    {
        this.carClass = carClass;
    }

    public CarClass getCarClass() {
        return carClass;
    }
}