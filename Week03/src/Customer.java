public class Customer implements Runnable{
    private Meal meal;

    public Customer(Meal meal) {
        this.meal = meal;
    }

    @Override
    public void run() {
        for(int x=0;x<10;x++){
//            System.out.println(Thread.currentThread().getName()+":: eatingMeal() called"+x);
            meal.eatingMeal();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
