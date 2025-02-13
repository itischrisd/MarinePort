package controller;

import model.container.Container;
import model.service.ContainerService;
import ui.component.LineComponent;
import view.UtilizationView;

import java.time.LocalDate;
import java.util.Map;

import static model.service.ContainerService.utilizeContainer;

public class UtilizationController implements Controller {

    private final UtilizationView utilizationView;

    public UtilizationController() {
        Map<Container, LocalDate> items = ContainerService.getWarehouseContainers();
        this.utilizationView = new UtilizationView(items);
    }

    @Override
    public void run() {
        utilizationView.display();
        int containerId = utilizationView.collect();
        try {
            utilizeContainer(containerId);
        } catch (Exception e) {
            LineComponent errorComponent = new LineComponent(e.getMessage());
            errorComponent.display();
        }
    }
}
