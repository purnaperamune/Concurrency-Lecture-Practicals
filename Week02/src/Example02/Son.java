package Example02;

public class Son implements Runnable {
    private Plate plate;
    @Override
    public void run() {
        for(int x=0;x<10;x++){
            plate.consumeFood();
        }
    }
}
