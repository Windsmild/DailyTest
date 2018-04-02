package myTest;

/**
 * Created by Stephen Cai on 2017-08-23 15:01.
 */
public class ReviewRelatedActivity {
	@Override
	public String toString() {
		return  "{"+activityId + ", " + relatedActivityId +"}";
	}

	private  int activityId;

	private int relatedActivityId;

	private int status;

	public int getActivityId() {
		return activityId;
	}

	public void setActivityId(int activityId) {
		this.activityId = activityId;
	}

	public int getRelatedActivityId() {
		return relatedActivityId;
	}

	public void setRelatedActivityId(int relatedActivityId) {
		this.relatedActivityId = relatedActivityId;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}
