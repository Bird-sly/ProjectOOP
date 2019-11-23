
package sample;

public class AudioPlayerDriver extends AudioPlayer {
    AudioPlayerDriver(String name, String manufacturer, String audioSpecification, ItemType mediaType) {
        super(name, manufacturer, audioSpecification, mediaType);
    }

    public static void main(String[] args) {
        AudioPlayer newProduct = new AudioPlayer("Sony", "Sony Entertainment", "MONO", ItemType.AUDIO);
        newProduct.play();
        newProduct.stop();
        newProduct.previous();
        newProduct.next();
        System.out.println(newProduct);
    }
}
