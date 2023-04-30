package xcahaj01_proj_filmy;

import java.util.ArrayList;

public abstract class Film {

    private String name;
    private String director;
    private Integer year;

    ArrayList<Integer> score = new ArrayList<Integer>();
    ArrayList<String> scoreString = new ArrayList<String>();
    ArrayList<Actor> actorList = new ArrayList<Actor>();
    
    @Override
    public String toString() {
        return "Název: " + name + ", režisér: " + director +", rok vydání: "+ year;
    }

    public Film(String name, String director, Integer year) {
        this.name = name;
        this.director = director;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public ArrayList<Integer> getScore() {
        return score;
    }

    public void setScore(ArrayList<Integer> score) {
        this.score = score;
    }

    public ArrayList<Actor> getActorlist() {
        return actorList;
    }

    public void setActorlist(ArrayList<Actor> actorlist) {
        this.actorList = actorlist;
    }

    public void addActor(Actor act) {
        actorList.add(act);
    }

    public void removeActor(Actor a) {
        if(actorList.remove(a)){
            System.out.println("Herec byl odstraněn");
        }
        else{
            System.out.println("Herec nebyl odstraněn");
        }
    }

    public void printActor(){
        if(actorList.isEmpty()){
            System.out.println("Film nemá žádného herce/animátora.");
        }else{
            for(Actor a:actorList){
                System.out.println(a);
            }
        }

    }

    public ArrayList<String> getScorestring() {
        return scoreString;
    }

    public abstract void printReview();


    public void addReview(Integer a){
        score.add(a);
    }

    public void addReviewString(String a){
        scoreString.add(a);
    }
    public abstract void setRecomendAge(Integer year);

    public abstract Integer getRecomendAge();

    public abstract void printInfo();
}
