package factoryMethod.model;

public class EmployeeFactory {
    public static Employee createEmployeeOfType(String type) 
    {
        if ("manager".equals(type) || "director".equals(type)) 
        {
            Employee employee = new Employee();
             
            employee.setId(1);
            employee.setName("Ravic");
            //Set designation here
            employee.setDesignation(type);
             
            return employee;
        }
        else
        {
            throw new IllegalArgumentException("Unknown product");
        }
    }


}
