package xcahaj01_proj_filmy;

import java.util.ArrayList;

public class Actor {
    private String Firstname;
    private String Lastname;

    @Override
    public String toString() {
        return  Firstname +" " + Lastname;
    }

    ArrayList<Film> filmList = new ArrayList<Film>();

    public Actor(String firstname, String lastname) {
        Firstname = firstname;
        Lastname = lastname;
    }

    public String getFirstname() {
        return Firstname;
    }

    public void setFirstname(String firstname) {
        Firstname = firstname;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String lastname) {
        Lastname = lastname;
    }

    public ArrayList<Film> getFilmlist() {
        return filmList;
    }

    public void addFilm(Film film) {
        filmList.add(film);
    }

    public void removeFilm(Film film) {
        if(filmList.remove(film)){
            System.out.println("Film byl odstraněn");
        }
        else{
            System.out.println("Film nebyl odstraněn");
        }
    }

    public void printFilms() {
        boolean animovany = false;
        for(Film film: filmList) {
            if (film instanceof AFilm) {
            	animovany = true;
            }
        }
        if(animovany) {
            System.out.println("Animátor "+getFirstname() +" "+ getLastname()+ " pracoval na těchto filmech:");
            for(Film aktFilmSeznamu: filmList){
                System.out.println(aktFilmSeznamu.getName());
            }
        }else {
            System.out.println("Herec "+getFirstname() +" "+ getLastname()+ " pracoval na těchto filmech:");
            for(Film aktFilmSeznamu: filmList){
                System.out.println(aktFilmSeznamu.getName());
            }
        }

        }
    }