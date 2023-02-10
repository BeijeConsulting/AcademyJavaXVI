package it.beije.neumann.nido.array;

import java.util.Objects;

public class MixedElem {
	int age;
	String name;

	MixedElem(int age, String name) {
		this.age = age;
		this.name = name;
	}

	@Override
	public String toString() {
		return "MixedElem [age=" + age + ", name=" + name + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MixedElem other = (MixedElem) obj;
		return age == other.age && Objects.equals(name, other.name);
	}
	
	

}