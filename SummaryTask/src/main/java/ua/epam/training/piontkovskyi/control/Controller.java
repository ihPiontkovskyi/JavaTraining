package ua.epam.training.piontkovskyi.control;

import ua.epam.training.piontkovskyi.model.data.Manufacturer;
import ua.epam.training.piontkovskyi.model.entity.AbstractTaxi;
import ua.epam.training.piontkovskyi.model.entity.TaxiPark;
import ua.epam.training.piontkovskyi.model.entity.TaxiService;
import ua.epam.training.piontkovskyi.util.Constants;
import ua.epam.training.piontkovskyi.util.Converter;
import ua.epam.training.piontkovskyi.view.InputHandler;
import ua.epam.training.piontkovskyi.view.View;

import java.util.List;

public class Controller {

    private View view;
    private TaxiPark taxiPool;
    private InputHandler inputHandler;
    TaxiService service;

    public Controller() {
        view = new View();
        taxiPool = new TaxiPark();
        inputHandler = new InputHandler(view);
        service =  new TaxiService(taxiPool);
    }

    public void run() {
        int command = 6;//for printing commands list
        while (command != 5) {
            switch (command) {
                case 1:
                    view.print(String.format(Constants.TOTAL_PRICE_MESSAGE, taxiPool.calculateCarsCost()));
                    break;
                case 2:
                    if (checkParkingInNotEmpty()) continue;
                    view.print(Converter.convertListOfCars(taxiPool.sortByFuelEconomy()));
                    break;
                case 3:
                    if (checkParkingInNotEmpty()) continue;
                    findCars();
                    break;
                case 4:
                    view.print(Converter.convertListOfCars(taxiPool.getCars()));
                    break;
                case 6:
                    view.print(Constants.ALL_COMMANDS_MESSAGE);
                    break;
                case 7:
                    handleTaxiService(service);
                    break;
                default:
                    view.print(Constants.WRONG_COMMAND_MESSAGE);
                    break;
            }
            view.print(Constants.ENTER_COMMAND_MESSAGE);
            command = inputHandler.inputInt();
        }
    }

    private boolean checkParkingInNotEmpty() {
        if (taxiPool.getCars().isEmpty()) {
            view.print(Constants.LIST_EMPTY_MESSAGE);
            return true;
        }
        return false;
    }

    private void findCars() {
        view.print(Constants.ENTER_COMPANY_MESSAGE);

        try {
            Manufacturer manufacturer = Manufacturer.valueOf(inputHandler.inputString().toUpperCase());
            view.print(Constants.ENTER_START_RANGE_MESSAGE);
            int start = inputHandler.inputInt();
            view.print(Constants.ENTER_END_RANGE_MESSAGE);
            int end = inputHandler.inputInt();
            List<AbstractTaxi> taxis = taxiPool.searchBySpeed(manufacturer, start, end);
            if(taxis.size()>0){
            view.print(Converter.convertListOfCars(taxis));
            }
            else {
                view.print(Constants.NO_SUCH_CAR_MESSAGE);
            }
        } catch (IllegalArgumentException ex) {
            view.print(Constants.NO_SUCH_COMPANY_MESSAGE);
        }
    }

    private void handleTaxiService(TaxiService service){
      view.print(Constants.MAKE_ORDER_MESSAGE);
      int ans = inputHandler.inputInt();
      while(ans != 1 && ans !=0){
          view.print(Constants.WRONG_INPUT_MESSAGE);
          ans = inputHandler.inputInt();
      }
      if(ans == 1){
          view.print(Constants.ENTER_DISTANCE_MESSAGE);
          int distance  = inputHandler.inputInt();
          view.print(Converter.convertListOfCars(service.getAvailableCars()));
          view.print(Constants.SELECT_CAR_MESSAGE);
          int index = inputHandler.inputInt();
          while (index < 0 || index > service.getAvailableCars().size()){
              view.print(Constants.WRONG_INPUT_MESSAGE);
              index = inputHandler.inputInt();
          }
          Double price = service.makeOrder(distance,index);
          if(!price.equals(-1.)) {
              view.print(String.format(Constants.ORDER_CAR_MESSAGE, price));
          }
          else {
              view.print(Constants.NOT_AVAILABLE_CAR_MESSAGE);
          }
      }
    }
}

