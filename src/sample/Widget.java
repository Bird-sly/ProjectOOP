package sample;

/**
 * Widget class to record production that extends product
 * @author Brendan Beardsley
 * @version 1.0
 */
class Widget extends Product {

    Widget(String name, String manufacturer, ItemType type) {
        super(name, manufacturer, type);
    }
}