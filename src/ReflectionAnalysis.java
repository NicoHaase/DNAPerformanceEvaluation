import java.util.ArrayList;


public class ReflectionAnalysis {
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		int size = 500000;
		
		ArrayList<String>[] res = new ArrayList[size];
		
		long currentTime = System.currentTimeMillis();
		
		for ( int i = 0; i < size; i++) {
			res[i] = new ArrayList<String>();
			res[i].add("test");
		}
		System.out.println("Time needed: " + (System.currentTimeMillis() - currentTime) + " msec");
		currentTime = System.currentTimeMillis();
		
		res = new ArrayList[size];
		for ( int i = 0; i < size; i++) {
			res[i] = (ArrayList<String>) Class.forName("java.util.ArrayList").newInstance();
			res[i].add("test");
		}
		
		System.out.println("Time needed: " + (System.currentTimeMillis() - currentTime) + " msec");
		
	}
}
