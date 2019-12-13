package sample;

/**
 * Audio Player Driver that extends to Audio Player.
 *
 * @author Brendan  Beardsley
 * @version 1.0
 */
public class AudioPlayerDriver extends AudioPlayer {
    /**
     * @param name               name of the product.
     * @param manufacturer       manufacturere of the product.
     * @param audioSpecification audio specification of the product.
     * @param mediaType          media type of the product.
     */
    AudioPlayerDriver(String name, String manufacturer, String audioSpecification,
                      ItemType mediaType) {
        super(name, manufacturer, audioSpecification, mediaType);
    }

    /**
     * Audio Player driver execution.
     */
    public static void main(String[] args) {
        AudioPlayer newProduct = new AudioPlayer("Walkman", "Walkman", "MONO", ItemType.AUDIO);
        newProduct.play();
        newProduct.stop();
        newProduct.previous();
        newProduct.next();

    }

}