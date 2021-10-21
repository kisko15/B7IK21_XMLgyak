package SaxB7IK211020;

public class Cats {

	private int id;
	private String name;
	private int age;
	private String breed;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}
	@Override
	public String toString() {
		return "Cats [id=" + id + ", name=" + name + ", age=" + age + ", breed=" + breed + "]";
	}
}
