package reactiveStreams;

import java.util.Date;
import java.util.List;
import java.util.concurrent.SubmissionPublisher;

public class ReactiveStreams {
    public static void main(){
        try(SubmissionPublisher<News> submissionPublisher = new SubmissionPublisher<>()){

            NewsSubscriber newsSubscriber = new NewsSubscriber();
            submissionPublisher.subscribe(newsSubscriber);

            List.of(
                    new News("News 1", new Date()),
                    new News("News 2", new Date()),
                    new News("News 3", new Date())
            ).forEach(submissionPublisher::submit);

            while(submissionPublisher.hasSubscribers()){
                //wait
            }
        }
    }
}
