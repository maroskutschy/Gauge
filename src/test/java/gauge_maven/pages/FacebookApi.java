package gauge_maven.pages;


import com.thoughtworks.gauge.datastore.DataStoreFactory;
import org.openqa.selenium.WebDriver;
import org.springframework.social.connect.Connection;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;
import org.springframework.social.oauth2.AccessGrant;

public class FacebookApi extends BasicActions{

    public FacebookApi(WebDriver driver) {
        super(driver);
    }

    public void postFeedForMyPage(String message){
        Connection<Facebook> connection = getFacebookConnection();
        Facebook facebook = connection.getApi();
        String feedId = facebook.feedOperations().post("492041324645402", message);
        DataStoreFactory.getScenarioDataStore().put("feedId",feedId);
        System.out.println("\n My feed id is "+DataStoreFactory.getScenarioDataStore().get("feedId"));
    }

    public void postCommentForFeed(String message){
        Connection<Facebook> connection = getFacebookConnection();
        Facebook facebook = connection.getApi();
        String commentId = facebook.commentOperations().addComment(
                (String) DataStoreFactory.getScenarioDataStore().get("feedId"), message);
        DataStoreFactory.getScenarioDataStore().put("commentId",commentId);
        System.out.println("\n My comment id is "+DataStoreFactory.getScenarioDataStore().get("commentId"));
    }

    public void removeFeed(){
        Connection<Facebook> connection = getFacebookConnection();
        Facebook facebook = connection.getApi();
        facebook.feedOperations().deletePost((String) DataStoreFactory.getScenarioDataStore().get("feedId"));
    }

    private Connection<Facebook> getFacebookConnection() {
        FacebookConnectionFactory facebookConnectionFactory = new FacebookConnectionFactory("174531793441262",
                "4ae195f9f03c09be34829d750390f390");
        AccessGrant accessGrant = new AccessGrant(
                "EAACevFmM0e4BAFSEN0U9xh2BDkobDIrfVowOmXkP7loOMZC9ZAKbipjwzxoFxcLFeP4RbiDm469uoBHs9XS7hEFftZBpuL0YyTcdPv5VZCSP98XQppsIa5VZAuoBDbqyCu7E5zXeydOFmu0GzZAqkmNHNiLIhlvyn4FsFIcZBqcRHx4ewfzCj5oQvG5ZCVkpVD8ZD");
        return facebookConnectionFactory.createConnection(accessGrant);
    }

}
