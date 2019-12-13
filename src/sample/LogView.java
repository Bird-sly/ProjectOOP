package sample;

/**
 * Log view class for table from Log text file
 */
public class LogView {
    private String log;
    private int lineId;

    /**
     * Constructor Logview
     *
     * @param log    log statement
     * @param lineId id of the login
     */
    public LogView(String log, int lineId) {
        this.log = log;
        this.lineId = lineId;
    }

    /**
     * Getter for property 'log'.
     *
     * @return Value for property 'log'.
     */
    public String getLog() {
        return log;
    }

    /**
     * Setter for property 'log'.
     *
     * @param log Value to set for property 'log'.
     */
    public void setLog(String log) {
        this.log = log;
    }

    /**
     * Getter for property 'lineId'
     *
     * @return Value for property 'lineId'.
     */
    public int getLineId() {
        return lineId;
    }

    /**
     * Setter for property 'lineId'.
     *
     * @param lineId Value to set for property 'lineId'.
     */
    public void setLineId(int lineId) {
        this.lineId = lineId;
    }
}
