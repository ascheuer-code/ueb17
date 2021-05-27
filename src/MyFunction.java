public interface MyFunction{

    public int apply(int i);

    public default int conditionateInput (int i, Preadikat p) {
        if (p.checkNumber(i)) {
            return apply(i);
        }
        else {
        return 0;
        }
    }
    
    public default int conditionateOutput (int i, Preadikat p) {
        if (p.checkNumber(apply(i))) {
            return apply(i);
        }
        else {
            return 0;
        }
    }
    }
