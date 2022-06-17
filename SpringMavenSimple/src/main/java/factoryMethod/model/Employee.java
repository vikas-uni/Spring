package factoryMethod.model;

public class Employee {
    private Integer id;
    private String name;
    private String designation;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
    

    @Override
    public String toString() {
        return "Employee [id=" + id + ", firstName=" + name
                 + ", type=" + designation + "]";
    }


}
