/* Copyright by Gokturk Yuksek 2015 */

package hackbu15.pebblechefcompanion;

public class PebbleMessage {
    private byte sequence;
    private String title;
    private String description;
    private String duration;
    private byte more;

    public PebbleMessage() {
        sequence = 0;
        title = "";
        description = "";
        duration = "0";
        more = 0;
    }

    public PebbleMessage(byte sequence, String title, String description,
                         String duration, byte more) {
        this.sequence = sequence;
        this.title = title;
        this.description = description;
        this.duration = duration;
        this.more = more;
    }

    public byte getSequence() {
        return sequence;
    }

    public void setSequence(byte sequence) {
        this.sequence = sequence;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public byte getMore() {
        return more;
    }

    public void setMore(byte more) {
        this.more = more;
    }
}

