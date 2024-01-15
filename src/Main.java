import model.Harbor;
import model.Train;
import model.container.ContainerBuilder;
import model.exception.TooManyContainersException;

public class Main {
    public static void main(String[] args) throws TooManyContainersException, InterruptedException {

        Harbor.getInstance().setTrain(new Train());
        Train train = Harbor.getInstance().getTrain();

        ContainerBuilder containerBuilder = new ContainerBuilder();
        for (int i = 0; i < 10; i++) {
            train.addContainer(containerBuilder.basicConatiner().build());
        }

        System.out.println(train.getContainers().size());

        Thread.sleep(3000);

        System.out.println(train.getContainers().size());
    }
}