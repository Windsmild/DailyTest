package myTest.designMode;

import com.google.common.collect.Lists;
import java.util.List;

/**
 * 设计模式 组合模式练习
 * @author Stephen Cai
 * @date 2018-07-01 11:56
 */
public  class ConcreteCompany extends Company{
    private List<Company> children = Lists.newArrayList();

    public ConcreteCompany(String name) {
        super(name);
    }
    @Override public void add(Company subCompany) {
        children.add(subCompany);
    }

    @Override public void remove(Company subCompany) {
        children.remove(subCompany);
    }

    @Override public void display(int depth) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < depth; i++) {
           sb.append("-") ;
        }
        System.out.println(sb.toString() +name);
        for (Company c : children) {
            c.display(depth+2);
        }
    }

    @Override public void lineOfDuty() {
        for (Company c : children) {
            c.lineOfDuty();
        }
    }
}
