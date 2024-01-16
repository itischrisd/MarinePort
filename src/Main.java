import model.Harbor;
import model.container.ContainerBuilder;
import model.exception.TooManyContainersException;
import model.train.TrainBuilder;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws TooManyContainersException, InterruptedException {

        TrainBuilder trainBuilder = new TrainBuilder();
        Harbor.getInstance().setTrain(trainBuilder.train().withContainers(new ArrayList<>()).build());

        ContainerBuilder containerBuilder = new ContainerBuilder();
        for (int i = 0; i < 10; i++) {
            Harbor.getInstance().getTrain().addContainer(containerBuilder.basicConatiner().build());
        }

        System.out.println(Harbor.getInstance().getTrain());

        Thread.sleep(3000);

        System.out.println(Harbor.getInstance().getTrain());
    }
}