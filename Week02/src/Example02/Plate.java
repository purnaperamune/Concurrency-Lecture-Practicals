package Example02;

public class Plate {
    private String food;
    private boolean foodAvailable;

    public Plate(String food) {
        this.food = food;
        this.foodAvailable = false;
    }

    public boolean isFoodAvailable() {
        return foodAvailable;
    }

    public void setFoodAvailable(boolean foodAvailable) {
        this.foodAvailable = foodAvailable;
    }

    public synchronized void serveFood(String food){
        while (foodAvailable){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        // If the thread (Mom's thread) is coming to this point, that means the plate is empty.
        this.food = food;
        this.foodAvailable = true;
        notifyAll();
    }

    public synchronized void consumeFood(){
        while (!foodAvailable){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        // If the thread (Son's thread) is coming to this point, that means the plate has food. Son starts eating.
        this.foodAvailable = false;
        notifyAll();
    }
}
