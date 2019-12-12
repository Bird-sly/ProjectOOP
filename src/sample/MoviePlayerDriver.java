package sample;

/**
 * Movie Player Driver Class.
 *
 * @author Brendan Beardsley
 * @version 1.0
 */
public class MoviePlayerDriver extends MoviePlayer {

    /**
     * Constructor for MoviePlayer Driver
     *
     * @param name         name of the  movie player
     * @param manufacturer manufacturer of the movie player
     * @param screen       screen of the movie player
     * @param monitorType  monitor type of the movie player
     */

    MoviePlayerDriver(String name, String manufacturer, Screen screen, MonitorType monitorType) {
        super(name, manufacturer, screen, monitorType);
    }

    /**
     * @param args method to test the driver.
     */
    public static void main(String[] args) {

        MoviePlayer newProduct = new MoviePlayer("NEC", "Nippon Electric Company",
                new Screen("1920*2000", 200, 300), MonitorType.LED);
        newProduct.play();
        newProduct.stop();
        newProduct.previous();
        newProduct.next();
        System.out.println(newProduct);

    }
}