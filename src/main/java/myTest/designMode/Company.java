package myTest.designMode;

/**
 * 设计模式 组合模式练习
 * @author Stephen Cai
 * @date 2018-07-01 11:56
 */
public  abstract class Company {

    protected String name;

    public Company (String name) {
        this.name = name;
    }
    public abstract void add(Company subCompany);
    public abstract void remove(Company subCompany);
    public abstract void display(int depth);
    public abstract void lineOfDuty();

    public static void main(String[] args) {
        ConcreteCompany headCompany = new ConcreteCompany("宇宙总公司");
        headCompany.add(new HRDepartment("宇宙总公司人力资源部"));
        headCompany.add(new FinanceDepartment("宇宙总公司财务部"));

        ConcreteCompany chinaCompany= new ConcreteCompany("中国分公司");
        chinaCompany.add(new HRDepartment("中国分公司人力资源部"));
        chinaCompany.add(new FinanceDepartment("中国分公司财务部"));
        headCompany.add(chinaCompany);

        ConcreteCompany shCompany= new ConcreteCompany("上海分公司");
        shCompany.add(new HRDepartment("上海分公司人力资源部"));
        shCompany.add(new FinanceDepartment("上海分公司财务部"));
        chinaCompany.add(shCompany);

        headCompany.display(1);
        headCompany.lineOfDuty();

    }
}
