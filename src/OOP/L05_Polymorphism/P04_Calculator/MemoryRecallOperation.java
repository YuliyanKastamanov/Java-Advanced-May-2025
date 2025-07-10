package OOP.L05_Polymorphism.P04_Calculator;

public class MemoryRecallOperation implements Operation {
    private MemoryStorage memory;

    public MemoryRecallOperation(MemoryStorage memory) {
        this.memory = memory;
    }

    @Override
    public void addOperand(int operand) {
    }

    @Override
   public boolean isCompleted(){
        return true;
    }

    @Override
    public int getResult() {
        return this.memory.getResult();
    }
}
