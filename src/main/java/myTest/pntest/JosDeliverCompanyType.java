package myTest.pntest;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import java.util.Set;

/**
 * 配送API 360buy.get.vender.all.delivery.company      获取商家的所有物流公司
 *
 * @author Stephen Cai
 * @date 2018-01-29 14:56
 */
public enum JosDeliverCompanyType {
    SF_EXPRESS(467, "顺丰快递"),
    YUANTONG_EXPRESS(466, "圆通快递");

    JosDeliverCompanyType(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    private Integer id;
    private String name;
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static ImmutableSet<String> deliverCompanyTypeSet;
    public static void initialDeliverCompanyTypeSet() {
        Set<String> typeSet = Sets.newHashSet();
        for (JosDeliverCompanyType type : JosDeliverCompanyType.values()) {
            typeSet.add(type.getName());
        }
        deliverCompanyTypeSet = ImmutableSet.copyOf(typeSet);
    }

    public static void main(String[] args) {
        initialDeliverCompanyTypeSet();
        ActivityEvent activityEvent = new ActivityEvent();
        System.out.println(deliverCompanyTypeSet);
        System.out.println(activityEvent.getClass().getSimpleName());
        System.out.println(new Exception().getStackTrace()[1].getMethodName());
    }
}

