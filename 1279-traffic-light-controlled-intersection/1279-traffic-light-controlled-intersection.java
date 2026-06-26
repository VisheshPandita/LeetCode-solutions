class TrafficLight {
    private final ReentrantLock lock;
    private int currentGreen;

    public TrafficLight() {
        lock = new ReentrantLock(true);
        currentGreen = 1;
    }
    
    public void carArrived(
        int carId,           // ID of the car
        int roadId,          // ID of the road the car travels on. Can be 1 (road A) or 2 (road B)
        int direction,       // Direction of the car
        Runnable turnGreen,  // Use turnGreen.run() to turn light to green on current road
        Runnable crossCar    // Use crossCar.run() to make car cross the intersection 
    ) {
        lock.lock();
        try {
            if(currentGreen != roadId) {
                turnGreen.run();
                currentGreen = roadId;
            }

            crossCar.run();
        } finally {
            lock.unlock();
        }
    }
}