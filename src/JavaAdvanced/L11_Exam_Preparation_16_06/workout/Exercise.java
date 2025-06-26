package L11_Exam_Preparation_16_06.workout;

//описваме как ще изглежда всяко едно упражнение
public class Exercise {
    //полета -> описваме характеристики
    private String name; //име на упражнение
    private String muscle; //мускули, които тренираме по време на упражнението
    private int burnedCalories; //изгорени калории

    //конструктор -> специален метод, чрез който създаваме обекти от класа
    //menu Generate
    //windows -> alt + insert
    //mac -> control + enter
    public Exercise(String name, String muscle, int burnedCalories) {
        //ново празно упражнение
        //name = null
        //muscle = null
        //burnedCalories = 0
        this.name = name;
        this.muscle = muscle;
        this.burnedCalories = burnedCalories;
    }

    //методи -> описваме действия
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMuscle() {
        return this.muscle;
    }

    public void setMuscle(String muscle) {
        this.muscle = muscle;
    }

    public int getBurnedCalories() {
        return this.burnedCalories;
    }

    public void setBurnedCalories(int burnedCalories) {
        this.burnedCalories = burnedCalories;
    }

    @Override
    public String toString() {
        //връща всеки един обект от класа (упражнение) по формата на текст
        return String.format("Exercise: %s, %s, %d", this.name, this.muscle, this.burnedCalories);
    }
}
