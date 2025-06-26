package L11_Exam_Preparation_16_06.workout;

import java.util.ArrayList;
import java.util.List;

//описваме всяка една тренировка
public class Workout {
    //полета
    private String type; //тип на тренировката
    private int exerciseCount; //макс брой упражнение
    private List<Exercise> exercises; //списък с упражнения

    //конструктор

    public Workout(String type, int exerciseCount) {
        //нова тренировка
        //type = null
        //exerciseCount = 0
        //exercises = null
        this.type = type;
        this.exerciseCount = exerciseCount;
        this.exercises = new ArrayList<>();
    }

    //методи
    public void addExercise(Exercise exercise) {
        if (this.exercises.size() < this.exerciseCount) {
            this.exercises.add(exercise);
        }
    }

    public boolean removeExercise(String name, String muscle) {
        //true -> ако успешно премахне упражнението с даденото име и група мускули
        //false -> ако не успее да премахне упражнението с даденото име и група мускули
        //тренировка -> списък с упражнения
        for (Exercise exercise : this.exercises) {
            if (exercise.getName().equals(name) && exercise.getMuscle().equals(muscle)) {
                //намерила упражнението, което искам да премахна
                this.exercises.remove(exercise);
                return true;
            }
        }
        //преминали сме през всички упражнения и не сме намерили нашето
        return false;
    }

    public Exercise getExercise (String name, String muscle) {
        for (Exercise exercise : this.exercises ) {
            if (exercise.getName().equals(name) && exercise.getMuscle().equals(muscle)) {
                return exercise;
            }
        }
        //преминали сме през всички упражнения и не сме намерили нашето
        return null;
    }

    public Exercise getMostBurnedCaloriesExercise() {
        if (this.exercises.size() <= 0) {
            //нямаме никакви упражнения
            return null;
        }
        //имаме упражнения в списъка и търсим това, което гори най-много калории
        int maxBurnedCalories = 0;
        Exercise maxExercise = null;

        for (Exercise exercise : this.exercises) {
            if (exercise.getBurnedCalories() > maxBurnedCalories) {
                maxBurnedCalories = exercise.getBurnedCalories();
                maxExercise = exercise;
            }
        }

        return maxExercise;
    }

    public int getExerciseCount() {
        return this.exercises.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append("Workout type: ").append(this.type).append(System.lineSeparator());

        for (Exercise exercise : this.exercises) {
            sb.append(exercise.toString()).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
