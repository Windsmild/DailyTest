package lottery;

/**
 * 奖品类
 * @author:rex
 * @date:2014年10月20日
 * @version:1.0
 */
public class Gift {

    private int index;
    private String giftId;
    private String giftName;
    private double probability;

    public Gift(int index, String giftId, String giftName, double probability) {
        this.index = index;
        this.giftId = giftId;
        this.giftName = giftName;
        this.probability = probability;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getGitfId() {
        return giftId;
    }

    public void setGitfId(String gitfId) {
        this.giftId = gitfId;
    }

    public String getGiftName() {
        return giftName;
    }

    public void setGiftName(String giftName) {
        this.giftName = giftName;
    }

    public double getProbability() {
        return probability;
    }

    public void setProbability(double probability) {
        this.probability = probability;
    }

    @Override
    public String toString() {
        return "Gift [index=" + index + ", giftId=" + giftId + ", giftName=" + giftName + ", probability="
            + probability + "]";
    }

}

