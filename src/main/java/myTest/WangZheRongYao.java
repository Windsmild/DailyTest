package myTest;

import java.text.DecimalFormat;

/**
 * @author Stephen Cai
 * @date 2018-07-23 20:24
 */
public class WangZheRongYao {
    /**
     * 计算程咬金何时回血收益大
     *
     * 舍生忘死（被动技能）：程咬金每损失1%最大生命值获得额外3～7点物理攻击力，增加幅度随英雄等级成长， 并且程咬金释放普通技能会消耗当前8%的最大生命值，大招消耗16%的当前生命值； 每次释放技能还会回复6%已损失生命值，回复过程持续3秒。
     *
     * 大招技能效果：程咬金迸发正义热情，5秒内每秒回复8%最大生命，并增加移动速度30%
     *
     * 不死鸟之眼 唯一被动 血统：每损失10%的血量，提升治疗效果6%，当损失90%的血量，回复效果会增加至54%
     */
    public static void calChengyaojinRecover() {
        DecimalFormat df = new DecimalFormat("0.0");
        for (int i = 0; i <= 10; i++) {
            double nowHP = 10.0 * i;
            //使用技能消耗血量
            double consumeHP = nowHP * 0.08;
            double cureHP = (100 - nowHP) * 0.06;
            double earnHP = cureHP - consumeHP;
            System.out.println("当前血量为" + df.format(nowHP) + ",时候使用技能消耗血量" + df.format(consumeHP) + ",恢复血量为"
                + df.format(cureHP) + (earnHP > 0 ? "赚了" : "亏了") + df.format(Math.abs(earnHP)));
            System.out.println("当有不死鸟之眼时候");
            double cureHPwithUnDead = cureHP * (1 + (10 - i) * 0.06);
            double earnHPwithUnDead = cureHPwithUnDead - consumeHP;
            System.out.println("当前血量为" + df.format(nowHP) + ",时候使用技能消耗血量" + df.format(consumeHP) +
                ",恢复血量为" + df.format(cureHPwithUnDead) +
                (earnHPwithUnDead > 0 ? "赚了": "亏了" ) + df.format(Math.abs(earnHPwithUnDead)));
            System.out.println("\n");
        }
    }

    public static void main(String[] args) {
        calChengyaojinRecover();
    }
}
