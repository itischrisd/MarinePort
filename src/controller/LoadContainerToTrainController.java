package controller;

import model.container.Container;
import model.service.ContainerService;
import ui.core.IOProvider;
import ui.core.View;
import view.ContainerSelectorView;

import java.util.List;

public class LoadContainerToTrainController implements Controller {

    private final View<Integer> containerSelectorView;

    public LoadContainerToTrainController() {
        List<Container> containers = ContainerService.getWarehouseContainers().keySet().stream().toList();
        this.containerSelectorView = new ContainerSelectorView(containers);
    }

    @Override
    public void run() {
        containerSelectorView.display();
        int containerId = containerSelectorView.collect();
        try {
            ContainerService.loadOntoTrain(containerId);
        } catch (Exception e) {
            IOProvider.getPrinter().println(e.getMessage());
        }
    }
}
