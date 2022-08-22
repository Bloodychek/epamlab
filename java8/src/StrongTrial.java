public class StrongTrial extends Trial{
    public StrongTrial( String account, int mark1, int mark2) {
        super(account, mark1, mark2);
    }

    public int halfFirstMark(){
        return getMark1() / 2;
    }

    @Override
    public boolean isPassed() {
        return halfFirstMark() + getMark2() >= PASS_MARK;
    }
}
