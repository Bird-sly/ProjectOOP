package sample;
/**
 * Movieplayer class extends Product
 * @author Brendan Beardsley
 * @version 1.
 */
public class MoviePlayer extends Product implements MultimediaControl {
    Screen screen;
    MonitorType monitorType;
    /**
     * Constructor for the Movie Player
     * @param name         name of the product.
     * @param manufacturer manufacturer of the product.
     * @param screen       screen info for Movie Player.
     * @param monitorType  monitor type for the Movie Player.
     */
    public MoviePlayer(String name, String manufacturer,Screen screen, MonitorType monitorType) {
       super(name, manufacturer, ItemType.VISUAL);
       this.screen = screen;
       this.monitorType = monitorType;
    }


    /**
     * Method to play the movie
     */
    @Override
    public void play() {
        System.out.println("Playing now");
    }

    /**
     * Method to stop the current movie
     */
    @Override
    public void stop() {
        System.out.println("Stopping now");

    }

    /**
     * Method to play the previous movie
     */
    @Override
    public void previous() {
        System.out.println("Going to previous");

    }

    /**
     * Method to play the next movie
     */
    @Override
    public void next() {
        System.out.println("next movie");
    }

    /**
     * Method for ToString.
     */
    @Override
    public String toString() {
        return super.toString() + "\nScreen: " + screen + "\nMonitor Type: " + monitorType;
    }
}