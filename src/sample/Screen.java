package sample;

/**
 * Screen class which implements from ScreenSpec
 *
 * @author Brendan Beardsley
 * @version 1.0
 */
public class Screen implements ScreenSpec {
    String resolution;
    int refreshrate;
    int responsetime;

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public void setRefreshrate(int refreshrate) {
        this.refreshrate = refreshrate;
    }

    public void setResponsetime(int responsetime) {
        this.responsetime = responsetime;
    }

    public Screen(String resolution, int refreshrate, int responsetime) {
        setResolution(resolution);
        setRefreshrate(refreshrate);
        setResponsetime(responsetime);
    }

    @Override
    public String getResolution() {
        return null;
    }

    @Override
    public int getRefreshRate() {
        return 0;
    }

    @Override
    public int getResponseTime() {
        return 0;
    }

    @Override
    public String toString() {
        return "Resolution: " + resolution + "\nRefresh Rate: " + refreshrate
                + "\nResponse Time: " + responsetime;
    }

}