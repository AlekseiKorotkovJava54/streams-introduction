package telran.streams.students;

import java.util.Arrays;
import java.util.Iterator;

public class Colledge implements Iterable<Student> {
	Student[] students;
	public Colledge(Student[] students) {
		this.students = Arrays.copyOf(students, students.length);
	}
private class ColledgeIterator implements Iterator<Student> {

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Student next() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
	@Override
	public Iterator<Student> iterator() {
		
		return new ColledgeIterator();
	}

}