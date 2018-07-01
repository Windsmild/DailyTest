package myTest.designMode;

/**
 * 设计模式 组合模式练习
 * @author Stephen Cai
 * @date 2018-07-01 11:56
 */
public  class HRDepartment extends Company{

    public HRDepartment(String name) {
        super(name);
    }

    @Override public void add(Company subCompany) {
    }

    @Override public void remove(Company subCompany) {
    }

    @Override public void display(int depth) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < depth; i++) {
           sb.append("-") ;
        }
        System.out.println(sb.toString() +name);
    }

    @Override public void lineOfDuty() {
        System.out.println(name + "员工管理");
    }
}
