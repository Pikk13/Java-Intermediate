import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws NotTrueLoveException, IOException {

        List<Man> udvarlok = new ArrayList<>();
        udvarlok.add(new Man("Feri", 1));
        udvarlok.add(new Man("Jani", 5));
        udvarlok.add(new Man("Bali", 2));
        udvarlok.add(new Man("Laci", 3));
        udvarlok.add(new Man("Győző", 4));
        udvarlok.add(new Man("Fülöp", 3));
        udvarlok.add(new Man("Peti", 1));

        FoxFairy foxFairy = new FoxFairy();
        Legend legend = new Legend(foxFairy, udvarlok);

        do {
            legend.story();
        }while (!foxFairy.isDisappointing());
    }
}