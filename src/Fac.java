public class Fac implements MyFunction{

    @Override
    public int apply(int i) {
        return (i == 0) ? 1 : i * apply(i - 1);
    }
    
}
