package entity;

import lombok.Data;
import lombok.ToString;

/**
 * Created by Stephen Cai on 2017-11-16 17:21.
 */
@Data
@ToString(callSuper = true)
public class ActivityStat {
    private static final long serialVersionUID = -1L;
    int clicks;
    int activityId;
    int cityId;

    public static void main(String[] args) {
        ActivityStat activityStat = new ActivityStat();
        System.out.println(activityStat.getClicks());
        activityStat.changeClicks(activityStat);
        System.out.println(activityStat);
    }

    private void changeClicks(ActivityStat change) {
        change.setClicks(change.getClicks() + 1);
    }
}

