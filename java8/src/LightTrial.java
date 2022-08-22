public class LightTrial extends Trial {
    public LightTrial(String account, int mark1, int mark2) {
        super(account, mark1, mark2);
    }

    @Override
    public boolean isPassed() {
        return getMark1() >= Constants.CONSTANT1 & getMark2() >= Constants.CONSTANT2;
    }
}
