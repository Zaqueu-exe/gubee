package application;


import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.util.List;

public class Program2 {
    public static void main(String[] args) {
        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("Teste 1 ");
        Department dep = new Department(null ,"FOOD");
        departmentDao.insert(dep);
        System.out.println(dep.getId());

        System.out.println("\n Teste 2");
        List<Department> list = departmentDao.findAll();
        list.forEach(System.out::println);

        System.out.println("\n Teste 3");
        dep = departmentDao.findById(3);
        System.out.println(dep);

        System.out.println("\n Teste 4");
        departmentDao.deleteById(7);

        System.out.println("\n Teste 5");
        dep.setId(8);
        dep.setName("DRINK");
        departmentDao.update(dep);
        list = departmentDao.findAll();
        list.forEach(System.out::println);


    }
}
