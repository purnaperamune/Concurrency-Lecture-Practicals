class Chef implements Runnable {
    private Meal meal;

    public Chef(Meal meal) {
        this.meal = meal;
    }

    @Override
    public void run() {
        for(int x=0;x<10;x++){
//            System.out.println(Thread.currentThread().getName()+":: cookingMeal() called"+x);
            meal.cookingMeal();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}