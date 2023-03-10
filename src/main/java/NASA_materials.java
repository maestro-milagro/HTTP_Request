import com.fasterxml.jackson.annotation.JsonProperty;

public class NASA_materials {
    protected String copyright;
    protected String date;
    protected String explanation;
    protected String hdurl;
    protected String media_type;
    protected String service_version;
    protected String title;
    protected String url;

    public NASA_materials(
            @JsonProperty("copyright") String copyright,
            @JsonProperty("date") String date,
            @JsonProperty("explanation") String explanation,
            @JsonProperty("hdurl") String hdurl,
            @JsonProperty("media_type") String media_type,
            @JsonProperty("service_version") String service_version,
            @JsonProperty("title") String title,
            @JsonProperty("url") String url
    ) {
        this.copyright = copyright;
        this.date = date;
        this.explanation = explanation;
        this.hdurl = hdurl;
        this.media_type = media_type;
        this.service_version = service_version;
        this.title = title;
        this.url = url;

    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "copyright = " + copyright +
                "\n date = " + date +
                "\n explanation = " + explanation +
                "\n hdurl = " + hdurl +
                "\n media_type = " + media_type +
                "\n service_version = " + service_version +
                "\n title = " + title +
                "\n url = " + url;
    }
}
