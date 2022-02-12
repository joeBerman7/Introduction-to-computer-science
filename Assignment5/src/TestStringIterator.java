public class TestStringIterator {

	public static void main(String[] args) {
		StringIterator iter = new StringIterator("a");
		for (int i = 1; i < 100; i = i + 1) {
			System.out.print(iter.next()+", ");
		}
		
	}

}
