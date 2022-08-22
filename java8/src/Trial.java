public class Trial implements Comparable<Trial>, Cloneable{
    private int mark1;
    private int mark2;
    private String account;

    protected final static int PASS_MARK = 120;

    public Trial(String account, int mark1, int mark2) {
        this.account = account;
        this.mark1 = mark1;
        this.mark2 = mark2;
    }

    public int getMark1() {
        return mark1;
    }

    public int getMark2() {
        return mark2;
    }

    public String getAccount() {
        return account;
    }

    public int sumMarks() {
        return mark1 + mark2;
    }

    public boolean isPassed() {
        return sumMarks() >= PASS_MARK;
    }

    public void cleanMarks() {
        mark1 = 0;
        mark2 = 0;
    }

    protected String fieldsToString() {
        return account + Constants.DELIMITER + mark1 + Constants.DELIMITER + mark2;
    }

    @Override
    public String toString() {
        return fieldsToString() + Constants.DELIMITER + isPassed();
    }

    @Override
    public int compareTo(Trial trial) {
        return sumMarks() - trial.sumMarks();
    }

    @Override
    public Trial clone() {
        try {
            return (Trial) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
