package func;


import java.util.concurrent.Callable;

abstract class  Function implements Callable<Double> {
    public Double submit() throws Exception {
        return call();
    }

    @Override
    public Double call() throws Exception {
        return null;
    }

    public String formatOutput(){
        return null;
    }
}
