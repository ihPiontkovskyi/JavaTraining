package ua.epam.training.piontkovskyi.model.entity;

import java.util.ArrayList;
import java.util.List;

public class TaxiService {

    private TaxiPark park;
    private List<AbstractTaxi> availableCars = null;

    public TaxiService(TaxiPark park) {
        this.park = park;
    }

    public List<AbstractTaxi> getAvailableCars(){
        if(availableCars == null){
            availableCars = new ArrayList<>();
            for(AbstractTaxi taxi: park.getCars()){
                if(!taxi.isBusy()){
                    availableCars.add(taxi);
                }
            }
        }

        return new ArrayList<>(availableCars);
    }

    public double makeOrder(int distance, int taxiIndex){
        if(availableCars == null){
            getAvailableCars();
        }
        if(availableCars.size() > 0) {
            availableCars.get(taxiIndex - 1).makeOrder(distance);
            return availableCars.remove(taxiIndex - 1).calcPrice();
        }
        return -1;
    }

}
