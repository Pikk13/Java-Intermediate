import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Random;

public class Legend {

    private FoxFairy foxFairy;
    private List<Man> manList;
    private Man trueLove = null;


    public Legend(FoxFairy foxFairy, List<Man> manList) {
        this.foxFairy = foxFairy;
        this.manList = manList;
    }

    void story() throws NotTrueLoveException {
        for (int i = 0; i < manList.size(); i++) {
            Random random = new Random();
            int randomValue = random.nextInt(1, 101);
            if (randomValue < 70) {
                woo(manList.get(i));
            } else {
                System.out.println("A rókatündér nem talált udvarlót az erdőben");
            }
        }
    }


    void woo(Man man) throws NotTrueLoveException {


        NotTrueLoveException notTrueLoveException = new NotTrueLoveException("A rókatündér nem talált igaz szerelemre");

        if (man.trueLove(foxFairy) && foxFairy.trueLove(man)) {
            trueLove = man;
            System.out.println("Megtalálta a zsák a foltját: Happy End!" + " Rókatündér + " + trueLove.getName());


            File story = new File("story.txt");

            try {

                if (story.createNewFile()) {
                    System.out.println("Sikeresen létrehoztam a fájlt!");
                } else {
                    System.out.println("A fájl már létezik.");
                }
                //createNewFile metódus: arra jó, hogy megvizsgálja, létezik-e az adott file, így nem // fordulhat elvileg elő, hogy felülírunk egy létező filet. Nem runtime exceptionjei vannak, amiket le kell kezelni
            } catch (IOException e) {
                System.out.println("IO hiba: " + e);
            }

            try {
                FileWriter fileWriter = new FileWriter("story.txt");
                fileWriter.write("A rókatündér igaz szerelme: " + man.getName() + System.lineSeparator());
                System.out.println("A felülírás megtörtént");
                fileWriter.close();
            } catch (IOException ioException) {
                System.out.println("Írási hiba" + ioException);
            }
            System.exit(0);

        } else if (!man.trueLove(foxFairy)) {

            manList.forEach(System.out::println);
            manList.remove(man);
            System.out.println(man + " törölve az udvarlók listájából!");
            foxFairy.increaseVictim();


            if (foxFairy.isDisappointing()) {

                throw notTrueLoveException;
            }
        }
    }
}


