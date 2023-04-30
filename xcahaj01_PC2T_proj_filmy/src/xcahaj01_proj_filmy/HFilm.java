package xcahaj01_proj_filmy;


import java.util.Collections;
import java.util.Comparator;

public class HFilm extends Film {
    public HFilm(String name, String director, Integer year) {
        super(name, director, year);
    }

    @Override
    public void printReview() {
        Collections.sort(super.getScore(), new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        for(Integer a: super.getScore()) {
            switch (a) {
                case 1:
                    System.out.println("*");
                    break;
                case 2:
                    System.out.println("**");
                    break;
                case 3:
                    System.out.println("***");
                    break;
                case 4:
                    System.out.println("****");
                    break;
                case 5:
                    System.out.println("*****");
                    break;
            }
        }

        if(super.getScorestring().isEmpty()){

        }
        else{
            for(String a: super.getScorestring()){
                System.out.println(a);
            }
        }
    }

    @Override
    public void setRecomendAge(Integer recAge) {
    }

    @Override
    public Integer getRecomendAge() {
        return null;
    }
    
    @Override
    public void printInfo(){
        System.out.println("Jméno filmu: " + getName() + ", režisér: " + getDirector() + ", rok: " + getYear());
        if(super.getActorlist().isEmpty()){

        }
        else{
            System.out.println("Herci:");
            printActor();
        }
    }
}
