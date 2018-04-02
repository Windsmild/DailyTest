package myTest;

/**
 * Created by Stephen Cai on 2017-11-10 16:28.
 */
public enum WanzhoumoCityEnum {
    SHANGHAI(10896,"上海"),
    BEIJING(10898,"北京"),
    GUANGZHOU(10894,"广州"),
    SHENZHEN(10893,"深圳"),
    CHONGQING(10824,"重庆"),
    CHENGDU(10891,"成都");


    private int value;
    private String desc;

    WanzhoumoCityEnum(int value, String desc){
        this.value = value;
        this.desc = desc;
    }
    public int getValue(){
        return this.value;
    }

    public String getDesc(){
        return desc;
    }

    public boolean is(int value) {

        return this.value == value;
    }

    public static void main(String[] args) {
        System.out.println(WanzhoumoCityEnum.BEIJING.getDesc());
    }
}
