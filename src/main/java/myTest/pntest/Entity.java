package myTest.pntest;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.ToString;

/**
 * @author Stephen Cai
 * @date 2018-01-17 19:18
 */
@Data
@ToString
public abstract class Entity implements Serializable {

    private static final long serialVersionUID = -1L;

    public static final int STATUS_VALID = 1;

    public static final int STATUS_INVALID = 0;

    public static final int STATUS_TO_AUDIT = 1;

    public static final int STATUS_AUDIT_PASS = 2;

    public static final int STATUS_AUDIT_REJECT = 3;

    public int  id;
    Date updateTime;
    Date addTime;
}

