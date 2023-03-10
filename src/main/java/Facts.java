import com.fasterxml.jackson.annotation.JsonProperty;

public class Facts {
    protected String id;
    protected String user;
    protected String type;
    protected String text;
    protected int upvotes;
    public Facts(
            @JsonProperty("user") String user,
            @JsonProperty("id") String id,
            @JsonProperty("type") String type,
            @JsonProperty("text") String text,
            @JsonProperty("upvotes") int upvotes
    ){
        this.user = user;
        this.id = id;
        this.type = type;
        this.text = text;
        this.upvotes = upvotes;

    }

    public int getUpvotes() {
        return upvotes;
    }
    @Override
    public String toString(){
        return "id = "+id+
        "\n user = "+user+
        "\n type = "+type+
        "\n text = "+text;
    }
}
