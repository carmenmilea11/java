package reactiveStreams;

import java.util.concurrent.Flow;

public class NewsSubscriber implements Flow.Subscriber<News> {

    private Flow.Subscription subscription;
    private static final int MAX_NEWS = 2;
    private int NEWS_RECEIVED = 0;

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        System.out.println("New subscription " + subscription);
        this.subscription = subscription;
        subscription.request(1);
    }

    @Override
    public void onNext(News item) {
        System.out.println("Received news: " + item.getHeadline() + " " + item.getDate());
        NEWS_RECEIVED++;

        if(NEWS_RECEIVED >= MAX_NEWS){
            System.out.println("Limit reached. Cancelling subscription");
            subscription.cancel();
            return;
        }

        subscription.request(1);
    }

    @Override
    public void onError(Throwable throwable) {
        System.out.println("Error occurred: " + throwable.getMessage());
    }

    @Override
    public void onComplete() {
        System.out.println("Receiving news complete.");
    }
}
