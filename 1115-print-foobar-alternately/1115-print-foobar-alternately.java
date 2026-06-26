class FooBar {
    private int n;
    private Semaphore foos;
    private Semaphore bars;

    public FooBar(int n) {
        this.n = n;
        foos = new Semaphore(1);
        bars = new Semaphore(0);
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            
        	foos.acquire();
            printFoo.run();
            bars.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {

            bars.acquire();            
        	printBar.run();
            foos.release();
        }
    }
}