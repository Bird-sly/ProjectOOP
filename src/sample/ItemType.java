package sample;
public enum ItemType {
    AUDIO("AU"),
    VISUAL("VI"),
    AUDIOMOBILE("AM"),
    VISUALMOBILE("VM");

    final String itemType;
//didnt use setter because item type is final
    ItemType(String itemType) {
      this.itemType =  itemType;
    }

    public String getItemType() {
        return itemType;
    }
}


