public class Meal {
    private String mealName;
    private boolean isReady;
    private boolean foodAvailable;

    public Meal(String mealName) {
        this.mealName = mealName;
        this.isReady = false;
        this.foodAvailable = false;
    }

    public synchronized void cookingMeal(){
        while (isReady){
            try {
//                 Chef is waiting for the waiter to serve the meal. Thread is in the WAITING state.
                System.out.println("Chef is waiting for the waiter to serve the meal.");
                wait();
                System.out.println("Chef is cooking the meal.");

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        // Chef cooks the meal. Marking true, so that the waiter can serve.
        this.isReady = true;
        System.out.println("Chef cooked the meal. Waiter can serve.");
        notifyAll();
    }

    public synchronized void servingMeal(){
        while (!isReady || foodAvailable){
            try {
                // Waiter is waiting for the customer to finish eating. Thread is in the WAITING state.
                System.out.println("Waiter is waiting for the customer to finish eating.");
                wait();
                System.out.println("Chef prepared the meal. Waiter is serving the meal.");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        // Waiter serves the meal. Marking true, so that the customer can eat.
        this.mealName = mealName;
        this.foodAvailable = true;
        System.out.println("Waiter served the meal. Customer can eat.");
        notifyAll();
    }
    public synchronized void eatingMeal(){
        while (!foodAvailable){
            try {
                // Customer is waiting for the waiter to serve the meal. Thread is in the WAITING state.
                System.out.println("Customer is waiting for the waiter to serve the meal.");
                wait();
                System.out.println("Waiter served the meal. Customer is eating the meal.");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        // Customer is done eating. Marking false, so that the waiter can serve another meal.
        this.foodAvailable = false;
        this.isReady = false;
        System.out.println("Customer is done eating. Waiter can serve another meal.");
        notifyAll();
    }
}

