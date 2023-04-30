package xcahaj01_proj_filmy;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class AFilm extends Film {
    Integer recomendAge;
    public AFilm(String name, String director, Integer year, Integer recomendAge) {
        super(name, director, year);
        this.recomendAge = recomendAge;

    }

    public Integer getRecomendAge() {
        return recomendAge;
    }

    public void setRecomendAge(Integer recomendAge) {
        this.recomendAge = recomendAge;
    }


    @Override
    public void printReview() {
        ArrayList<Integer> scores = super.getScore();

        Collections.sort(scores, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

        for (Integer score : scores) {
            System.out.println(score);
        }

        ArrayList<String> scoreStrings = super.getScorestring();

        if (!scoreStrings.isEmpty()) {
            for (String scoreString : scoreStrings) {
                System.out.println(scoreString);
            }
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", doporučený věk diváka: "+getRecomendAge();
    }

    @Override
    public void printInfo(){
        System.out.println("Jméno filmu: " + getName() + ", režisér: " + getDirector() + ", rok: " + getYear() + ", doporučený věk diváka: " + getRecomendAge());
        if(super.getActorlist().isEmpty()){

        }
        else{
            System.out.println("Animátoři:");
            printActor();

        }

    }
}
