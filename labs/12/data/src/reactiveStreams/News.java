package reactiveStreams;

import java.util.Date;

public class News {

    private String headline;
    private Date date;

    public News(String headline, Date date) {
        this.headline = headline;
        this.date = date;
    }

    public String getHeadline() {
        return headline;
    }

    public Date getDate() {
        return date;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
