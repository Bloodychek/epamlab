public class ExtraTrial extends Trial {
    int mark3;

    public ExtraTrial(String account, int mark1, int mark2, int mark3) {
        super(account, mark1, mark2);
        this.mark3 = mark3;
    }

    @Override
    public boolean isPassed() {
        return super.isPassed() & + mark3 >= Constants.CONSTANT3;
    }

    @Override
    public String fieldsToString(){
        return super.fieldsToString() + Constants.DELIMITER + mark3;
    }

    @Override
    public void cleanMarks(){
        super.cleanMarks();
        mark3 = 0;
    }
}
