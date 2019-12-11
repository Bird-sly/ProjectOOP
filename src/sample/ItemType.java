package sample;
public enum ItemType {
    AUDIO("AU"),
    VISUAL("VI"),
    AUDIO_MOBILE("AM"),
    VISUAL_MOBILE("VM");

    private String code;

    ItemType(String code) {
        this.code = code;
    }

    /**
     * Getter for property 'code'.
     *
     * @return Value for property 'code'.
     */
    public String getCode() {
        return code;
    }

}