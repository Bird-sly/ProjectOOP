
package sample;

public class AudioPlayer extends Product implements MultimediaControl {
    private String audioSpecification;
    private ItemType mediaType;

    AudioPlayer(String name, String manufacturer, String audioSpecification, ItemType mediaType) {
        super(name, manufacturer, mediaType);
        this.audioSpecification = audioSpecification;
        this.mediaType = mediaType;
    }

    public void play() {
        System.out.println("Playing");
    }

    public void stop() {
        System.out.println("Stopped");
    }

    public void previous() {
        System.out.println("Previous");
    }

    public void next() {
        System.out.println("next");
    }

    public void ToString() {
        System.out.print(super.toString());
        System.out.print("\n Audio specification: " + this.audioSpecification + " \n Media Type: " + this.mediaType);
    }
}
