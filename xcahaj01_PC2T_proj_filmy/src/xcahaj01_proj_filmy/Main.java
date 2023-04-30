package xcahaj01_proj_filmy;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        AFilm aFilmShrek = new AFilm("Shrek", "Andrew Perkinsont", 2008,10);
        AFilm aFilmShrek2 = new AFilm("Shrek2", "Andrew Hopkin", 2009, 15);

        HFilm hFilmPelisky = new HFilm("Pelisky", "Pavel Hopkin", 2020);
        HFilm hFilmSlunce = new HFilm("Slunce", "Marek Hopkin", 2015);

        Actor act = new Actor("Andy", "Harper");
        Actor act1 = new Actor("Pavel", "Bezruc");

        ArrayList<Actor> actorList = new ArrayList<Actor>();
        actorList.add(act);
        actorList.add(act1);

        prirad(aFilmShrek, act);
        prirad(aFilmShrek2, act);
        prirad(hFilmPelisky, act1);
        prirad(hFilmSlunce, act1);

        aFilmShrek.addReview(10);
        aFilmShrek.addReview(1);
        aFilmShrek.addReview(7);
        aFilmShrek.addReviewString("Výborný film.");
        hFilmPelisky.addReview(3);
        hFilmPelisky.addReview(5);
        hFilmPelisky.addReview(4);
        
        TreeMap<String, Film> list = new TreeMap<String, Film>();
        list.put(aFilmShrek.getName(), aFilmShrek);
        list.put(aFilmShrek2.getName(), aFilmShrek2);
        list.put(hFilmPelisky.getName(), hFilmPelisky);
        list.put(hFilmSlunce.getName(), hFilmSlunce);

        Scanner sc = new Scanner(System.in);

        boolean run = true;
        while(run){
            System.out.println("");
            System.out.println("1. Info o filmu");
            System.out.println("2. Upravení filmu");
            System.out.println("3. Smazání filmu");
            System.out.println("4. Přidání hodnocení filmu");
            System.out.println("5. Vypsat všechny filmy");
            System.out.println("6. Přidání filmu");
            System.out.println("7. Výpis herců a animátorů, kteří se podíleli na více než jednom filmu");
            System.out.println("8. Výpis všech filmů, které obsahují konkrétního herce nebo animátora ");
            System.out.println("9. Uložení informací o filmu do souboru");
            System.out.println("10. Načtení informací o filmu ze souboru ");
            System.out.println("11. Přidání herce/animátora k filmu");


            Integer volba = Inputs.pouzeCislo(1,11);
            switch (volba) {
                case 1:
                    System.out.println("Zadejte název filmu:");
                    String in1 = sc.nextLine();

                    Film info = null;
                    try {
                        info = list.get(in1);
                    } catch (NullPointerException e) {
                    }
                    if(info == null) {
                        System.out.println("Film není v databízi.");
                    }else{
                        if (info instanceof HFilm) {
                            System.out.println("Jméno: " + info.getName() + ", režisér: " + info.getDirector() + ", rok: " + info.getYear());
                            System.out.println("Seznam herců:");
                            info.printActor();

                            if(info.getScore().isEmpty()){
                                System.out.println("Film nemá žádné hodnocení.");
                            }else{
                                System.out.println("Hodnocení diváků:");
                                info.printReview();
                            }
                        } else {
                            System.out.println("Jméno: " + info.getName() + ", režisér: " + info.getDirector() + ", rok: " + info.getYear() + ", doporučený věk diváka: " + info.getRecomendAge());
                            System.out.println("Seznam animátorů:");
                            info.printActor();

                            if(info.getScore().isEmpty()){
                                System.out.println("Film nemá žádné hodnocení.");
                            }else{
                                System.out.println("Hodnocení diváků:");
                                info.printReview();
                            }
                        }
                    }
                    break;


                case 2:
                    System.out.println("Zadejte název filmu, který chcete upravit:");

                    String in2 = sc.nextLine();
                    Film infoUprava = list.get(in2);
                    if(infoUprava == null){
                        System.out.println("Film není v databázi.");
                    }else{
                        if (infoUprava instanceof HFilm) {
                            System.out.println("Zadejte upravený název filmu:");
                            String name = sc.nextLine();
                            System.out.println("Zadejte název režiséra:");
                            String director = sc.nextLine();
                            System.out.println("Zadejte rok vydání:");
                            Integer year = Inputs.pouzeCislo(0, 2024);
                            infoUprava.setName(name);
                            infoUprava.setDirector(director);
                            infoUprava.setYear(year);
                        } else {
                            System.out.println("Zadejte název filmu:");
                            String name = sc.nextLine();
                            System.out.println("Zadejte název režiséra:");
                            String director = sc.nextLine();
                            System.out.println("Zadejte rok vydání:");
                            Integer year = Inputs.pouzeCislo(0, 2024);
                            System.out.println("Zadejte doporučený věk diváků:");
                            Integer recAge = Inputs.pouzeCislo(0, 100);
                            infoUprava.setName(name);
                            infoUprava.setDirector(director);
                            infoUprava.setYear(year);
                            infoUprava.setRecomendAge(recAge);
                        }
                    }
                    break;
                    
                    
                case 3:
                    System.out.println("Zadejte název filmu:");

                    String in3 = sc.nextLine();
                    Film infoSmazani = null;
                    boolean uspesneSmazani = false;
                    try {
                    	infoSmazani = list.get(in3);
                        list.remove(infoSmazani.getName());
                    } catch (NullPointerException e) {
                        System.out.println("Film není v databázi.");
                        uspesneSmazani = true;
                    }
                    if(!uspesneSmazani){
                        System.out.println("Film byl smazán");
                    }
                    break;

                    
                case 4:
                    System.out.println("Zadejte název filmu:");
                    String in4 = sc.nextLine();
                    Film infoHodnoceni = null;

                    try {
                        infoHodnoceni = list.get(in4);
                    } catch (NullPointerException e) {
                    }
                    if(infoHodnoceni == null){
                        System.out.println("Film není v databízi.");
                    }else{
                        if(infoHodnoceni instanceof HFilm){
                            System.out.println("Zadejte počet hvězdiček 1-5:");
                            Integer pocHvezdicek = Inputs.pouzeCislo(1,5);
                            infoHodnoceni.addReview(pocHvezdicek);
                        }else{
                            System.out.println("Zadejte bodové hodnocení 1-10:");
                            Integer pocBoduHodnoceni = Inputs.pouzeCislo(1,10);
                            infoHodnoceni.addReview(pocBoduHodnoceni);
                        }
                    }
                    System.out.println("Chcete přidat slovní hodnocení? 1-ANO 2-NE");
                    Integer chciSlovHondnoceni = Inputs.pouzeCislo(1,2);
                    if(chciSlovHondnoceni == 1){
                    	System.out.println("Napište hodnocení:");
                        String slovHondoceni = sc.nextLine();
                    	infoHodnoceni.addReviewString(slovHondoceni);
                    }
                    else {}
                    
                    break;

                case 5:
                    Iterator<Film> iterator = list.values().iterator();
                    while (iterator.hasNext()) {
                        iterator.next().printInfo();
                    }
                    break;

                    
                case 6:
                    System.out.println("Veberte druh filmu");
                    System.out.println("1 - Hraný film");
                    System.out.println("2 - Animovaný film");
                    Integer typFilmu = Inputs.pouzeCislo(1,2);

                    System.out.println("Zadejte název filmu:");
                    String name = sc.nextLine();
                    System.out.println("Zadejte jméno a příjmení režiséra:");
                    String director = sc.nextLine();
                    System.out.println("Zadejte rok vydání:");
                    Integer year = Inputs.pouzeCislo(0, 2024);
                    
                    if(typFilmu == 1){
                        HFilm f = new HFilm(name, director, year);
                        list.put(f.getName(), f);
                    }else{
                        System.out.println("Zadejte doporučený věk diváků:");
                        Integer recAge = Inputs.pouzeCislo(0, 100);
                        AFilm g = new AFilm(name, director, year, recAge);
                        list.put(g.getName(), g);
                    }
                    break;

                    
                case 7:
                    for(Actor herec:actorList){
                        if(herec.getFilmlist().size() > 1){
                        	herec.printFilms();
                        }
                    }
                    break;

                    
                case 8:
                    System.out.println("Zadejte jméno herce/animátora:");
                    String hNeboAJmeno = sc.nextLine();
                    System.out.println("Zadejte přijmení herce/animátora:");
                    String hNeboAPrijmeni = sc.nextLine();
                    Actor hNeboAVypis = null;
                    boolean jmenoSpravne = false;
                    for(Actor hNeboA:actorList){
                        if(hNeboA.getFirstname().equals(hNeboAJmeno) && hNeboA.getLastname().equals(hNeboAPrijmeni)){
                        	hNeboAVypis = hNeboA;
                        	jmenoSpravne = true;
                        }
                    }
                    if(!jmenoSpravne){
                        System.out.println("Zadali jste špatné jméno herce/animátora.");
                    }
                    if(hNeboAVypis != null) {
                    	hNeboAVypis.printFilms();
                    }
                    else{}
                    break;

                    
                case 9:
                    System.out.println("Zadejte název filmu:");
                    String nazevFilmuUlozSoubor = sc.nextLine();
                    Film infoUlozSoubor = null;
                    try {
                        infoUlozSoubor = list.get(nazevFilmuUlozSoubor);
                    } catch (Exception e) {
                    }
                    if(infoUlozSoubor == null){
                        System.out.println("Film není v databázi.");
                        break;
                    }

                    try {
                        BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\Pepan\\Desktop\\6. semestr (letní)\\PC2T\\xcahaj01_PC2T_proj_filmy\\filmy.txt"));
                        if(infoUlozSoubor instanceof AFilm){
                            bw.write(infoUlozSoubor.getName()+";"+infoUlozSoubor.getDirector()+";"+infoUlozSoubor.getYear()+";"+infoUlozSoubor.getRecomendAge());
                        }else{
                            bw.write(infoUlozSoubor.getName()+";"+infoUlozSoubor.getDirector()+";"+infoUlozSoubor.getYear());
                        }
                        bw.close();
                    }
                    catch(Exception ex){
                        return;
                    }
                    break;

                    
                case 10:
                    File file = new File("C:\\Users\\Pepan\\Desktop\\6. semestr (letní)\\PC2T\\xcahaj01_PC2T_proj_filmy\\filmy.txt");
                    Scanner scan = null;
                    try {
                        scan = new Scanner(file);
                        while (scan.hasNextLine()) {
                            String line = scan.nextLine();
                            String[] lineArray = line.split(";");
                            if(lineArray.length == 4){
                                System.out.println("Animovaný film, jméno: "+lineArray[0]+", režisér: "+lineArray[1]+", rok vydání: "+ lineArray[2] + ", doporučený věk: "+lineArray[3]);
                            }else{
                                System.out.println("Hraný film, jméno: "+lineArray[0]+", režisér: "+lineArray[1]+", rok vydání: "+ lineArray[2]);
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;

                    
                case 11:
                    System.out.println("Zadejte název filmu:");
                    String prirazeniHerce = sc.nextLine();
                    Film infoPrirazeniHerce = null;
                    try {
                    	infoPrirazeniHerce = list.get(prirazeniHerce);
                    } catch (Exception e) {
                    }
                    if(infoPrirazeniHerce == null){
                        System.out.println("Film není v databázi.");
                        break;
                    }

                    System.out.println("1 - existující herec/animátor");
                    System.out.println("2 - nový herec/animátor");
                    Integer existujiciNeboNovy = Inputs.pouzeCislo(1, 2);
                    if(existujiciNeboNovy == 1){
                        System.out.println("Zadejte jméno herce/animátora:");
                        String hNebAJmeno = sc.nextLine();
                        System.out.println("Zadejte přijmení herce/animátora:");
                        String hNebAPrijmeni = sc.nextLine();
                        boolean jmSpravne = false;
                        Actor hNeboAVypisSouboru = null;
                        for(Actor hNeboA:actorList){
                            if(hNeboA.getFirstname().equals(hNebAJmeno) && hNeboA.getLastname().equals(hNebAPrijmeni)){
                            	hNeboAVypisSouboru = hNeboA;
                                jmSpravne = true;
                            }
                        }
                        if(!jmSpravne){
                            System.out.println("Zadali jste špatné jméno herce/animátora.");
                        }
                        if(jmSpravne){
                            if(infoPrirazeniHerce.getActorlist().contains(hNeboAVypisSouboru)){
                                if(infoPrirazeniHerce instanceof AFilm){
                                    System.out.println("Animátor je už u filmu přiřazen.");
                                }else{
                                    System.out.println("Herec je už u filmu přiřazen.");
                                }
                            }else{
                                prirad(infoPrirazeniHerce, hNeboAVypisSouboru);
                            }

                        }
                    }else{
                        System.out.println("Zadejte jméno herce/animátora:");
                        String novyHNeboAJmeno = sc.nextLine();
                        System.out.println("Zadejte přijmení herce/animátora:");
                        String novyHNeboAPrijmeni = sc.nextLine();
                        Actor novyHNeboA = new Actor(novyHNeboAJmeno, novyHNeboAPrijmeni);
			            actorList.add(novyHNeboA);
                        prirad(infoPrirazeniHerce, novyHNeboA);
                    }
                    break;
            }
        }
    }

    private static void prirad(Film film, Actor a) {
        film.addActor(a);
        a.addFilm(film);
        }
    
}