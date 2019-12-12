package sample;
/**
 * Audio player thats extends abstract class product and implement multimedia control.
 *
 * @author Brendan Beardsley
 * @version 1.0
 */
public class AudioPlayer extends Product implements MultimediaControl {
    private String audioSpecification;
    private ItemType mediaType;
    /**
     * Audio player constructor.
     *
     * @param name               name of the product.
     * @param manufacturer       manufacture of the product.
     * @param audioSpecification type of audio.
     * @param mediaType          type of media.
     */
    AudioPlayer(String name, String manufacturer, String audioSpecification, ItemType mediaType) {
        super(name, manufacturer, mediaType);
        this.audioSpecification = audioSpecification;
        this.mediaType = mediaType;
    }
    /**
     * Notification of playing.
     */
    @Override
    public void play() {
        System.out.println("Playing");
        Main.infoMessage("Playing");
    }
    /**
     * Notification of stop.
     */
    @Override
    public void stop() {
        System.out.println("Stopped");
        Main.infoMessage("Stopped");
    }
    /**
     * Notification of playing previous.
     */
    @Override
    public void previous() {
        System.out.println("Previous");
        Main.infoMessage("Previous");
    }
    /**
     * Notification of playing next.
     */
    @Override
    public void next() {
        System.out.println("next");
        Main.infoMessage("Next");
    }
    /**
     * To String method of audio player.
     */
    public void ToString() {
        System.out.print(super.toString());
        System.out.print(
                "\n Audio specification: " + this.audioSpecification + " \n Media Type: " + this.mediaType);
    }
}