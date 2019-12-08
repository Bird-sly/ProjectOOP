
package sample;

public class AudioPlayer extends Product implements MultimediaControl {
    private String audioSpecification;
    private ItemType mediaType;

    /***
     * @param name
     * @param manufacturer
     * @param audioSpecification
     * @param mediaType
     */
    AudioPlayer(String name, String manufacturer, String audioSpecification, ItemType mediaType) {
        super(name, manufacturer, mediaType);
        this.audioSpecification = audioSpecification;
        this.mediaType = mediaType;
    }
    public void play() {
        System.out.println("Playing...");
    }
    public void stop() {
        System.out.println("Stopping..");
    }
    public void previous() {
        System.out.println("now playing Previous track");
    }
    public void next() {
        System.out.println("playing next track");
    }
    public void ToString() {
        System.out.print(super.toString());
        System.out.print("\n Audio specification: " + this.audioSpecification + " \n Media Type: " + this.mediaType);
    }
}
