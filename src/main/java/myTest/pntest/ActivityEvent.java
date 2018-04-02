package myTest.pntest;

import java.util.Date;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import net.sf.cglib.beans.BeanCopier;
import org.joda.time.DateTime;

@Data
@ToString(callSuper = true)
@NoArgsConstructor
public class ActivityEvent{

    private static final long serialVersionUID = -1L;


    private int activityId;
    private String specification;
    private Date start;
    private Date end;
    private Date stopSellTime;
    private String desc;

    public static final int DEFAULT_STOP_SALE_DAYS_BEFORE_START = 3;


    public Date validEnd() {
        if (end != null) {
            return end;
        }
        return start;
    }

    public static final int DEFAULT_END_PLUS_HOURS = 3;
    /**
     * 如果结束时间是null,那返回一个默认结束时间
     * 给所有BeanCopier了ActivityEvent的类加上private Date defaultEnd,
     * 因为beanCopier的target必须要接收source的getter
     * 这里用getter为了方便前端直接展示
     * @return getDefaultEnd
     */
    public Date getDefaultEnd() {
        if (end != null) {
            return end;
        } else {
            return new DateTime(start).plusHours(DEFAULT_END_PLUS_HOURS).toDate();
        }
    }


    public static final BeanCopier BEAN_COPIER = BeanCopier.create(ActivityEvent.class, ActivityEvent.class, false);

    public static void main(String[] args) {
       ActivityEvent one = new ActivityEvent();

       ActivityEvent two = new ActivityEvent();
       BEAN_COPIER.copy(one, two, null);
    }

}
