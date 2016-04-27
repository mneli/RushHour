package g42861.rushhour;

import g42861.rushhour.model.Car;
import g42861.rushhour.model.Orientation;
import g42861.rushhour.model.Position;
import g42861.rushhour.model.RushHourException;
import g42861.rushhour.model.RushHourGame;
import g42861.rushhour.view.Keyboard;
import g42861.rushhour.view.RushHourView;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Main class of RushHourGame. Used to start the game
 *
 * @author G42861
 */
public class RushHour {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        char reload;
        int difficulty;
        File file = null;

        System.out.println("RushHour Game!");

        do {
            System.out.println("Please choose the difficulty : ");

            do {
                System.out.println("1 : Easy" + "\n2 : Medium" + "\n3 : Hard");
                difficulty = Keyboard.scanInt();
                System.out.println(difficulty);
            } while (difficulty < 1 || difficulty > 3);

            switch (difficulty) {
                case 1:
                    file = new File("src/g42861/rushhour/easyLevels.xml");
                    break;
                case 2:
                    file = new File("src/g42861/rushhour/mediumLevels.xml");
                    break;
                case 3:
                    file = new File("src/g42861/rushhour/hardLevels.xml");
            }

            List<RushHourGame> levels = parseLevels(file);

            System.out.println("Please choose a level : ");
            int levelChoice = Keyboard.scanLevel(levels.size());

            RushHourView view = new RushHourView(levels.get(levelChoice));
            view.play();

            reload = Keyboard.scanChar("Would you like to play another level?"
                    + "\nPress Y for yes or any key to stop the game\n");
        } while (reload == 'Y');
    }

    /**
     * Parse levels from an XML file.
     *
     * @param file the raw xml file
     * @return a list of RushHourGame/level
     */
    private static List<RushHourGame> parseLevels(File file) {
        List<RushHourGame> levels = new ArrayList<>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document xmlDoc = builder.parse(file);

            List<List<Car>> listCars = parseCarList(xmlDoc);

            NodeList nList = xmlDoc.getElementsByTagName("level");
            for (int i = 0; i < nList.getLength(); i++) {
                RushHourGame game = null;
                Node node = nList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element elt = (Element) node;
                    game = getGame(elt, listCars.get(i));
                }
                levels.add(game);
            }

        } catch (ParserConfigurationException | SAXException | IOException e) {
            System.out.println(e.getMessage());
        }
        return levels;
    }

    /**
     * Parse a car lists from an XML file.
     *
     * @param doc the Document file obtained from the XML file with
     * DocumentBuilderFacory.
     * @return a list of car list
     */
    private static List<List<Car>> parseCarList(Document doc) {
        List<List<Car>> listCars = new ArrayList<>();
        NodeList nList = doc.getElementsByTagName("cars");
        for (int i = 0; i < nList.getLength(); i++) {
            Node node = nList.item(i);
            List<Car> cars = new ArrayList<>();
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element elt = (Element) node;
                int item = 0;
                while (elt.getElementsByTagName("id").item(item) != null) {
                    Car car = getCar(elt, item);
                    cars.add(car);
                    item++;
                }
            }
            listCars.add(i, cars);
        }
        return listCars;
    }

    /**
     * Get the text content of an element.
     *
     * @param elt the level from where the data will be extracted
     * @param tag the tag name
     * @param itemNumber the tag to take. For example the tag cars contains
     * often more than one tag car. So to get the first car that comes in the
     * XML file the item number should be 0. For the second car, the item number
     * should be 1.
     * @return the text content
     */
    private static String getItem(Element elt, String tag, int itemNumber) {
        return elt.getElementsByTagName(tag).item(itemNumber).getTextContent();
    }

    /**
     * Get the red car of the level
     *
     * @param elt the level from where the data will be extracted
     * @return the red car
     */
    private static Car getRedCar(Element elt) {
        Car redCar = new Car(
                getItem(elt, "redCarId", 0).charAt(0),
                Integer.parseInt(getItem(elt, "redCarSize", 0)),
                Orientation.valueOf(getItem(elt, "redCarOrientation", 0)),
                new Position(
                        Integer.parseInt(getItem(elt, "redCarRow", 0)),
                        Integer.parseInt(getItem(elt, "redCarCol", 0))));
        return redCar;
    }

    /**
     * Get a car of the level
     *
     * @param elt the level from where the data will be extracted
     * @param item the car to return
     * @return a car
     */
    private static Car getCar(Element elt, int item) {
        Car car = new Car(
                getItem(elt, "id", item).charAt(0),
                Integer.parseInt(getItem(elt, "size", item)),
                Orientation.valueOf(getItem(elt, "orientation", item)),
                new Position(
                        Integer.parseInt(getItem(elt, "row", item)),
                        Integer.parseInt(getItem(elt, "col", item))));
        return car;
    }

    /**
     * Get a level of RushHourGame.
     *
     * @param elt the level from where the data will be extracted
     * @param cars a list of cars
     * @return a constructed level of RushHourGame
     */
    private static RushHourGame getGame(Element elt, List<Car> cars) {
        RushHourGame game = null;
        try {
            game = new RushHourGame(
                    Integer.parseInt(getItem(elt, "height", 0)),
                    Integer.parseInt(getItem(elt, "width", 0)),
                    new Position(
                            Integer.parseInt(getItem(elt, "exitRow", 0)),
                            Integer.parseInt(getItem(elt, "exitCol", 0))),
                    cars,
                    getRedCar(elt));
        } catch (RushHourException e) {
            System.out.println(e.getMessage());
        }
        return game;
    }

}
