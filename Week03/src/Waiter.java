class Waiter implements Runnable {
    private Meal meal;

    public Waiter(Meal meal) {
        this.meal = meal;
    }

    @Override
    public void run() {
        for(int x=0;x<10;x++){
//            System.out.println(Thread.currentThread().getName() + ":: servingMeal() called");
            meal.servingMeal();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


