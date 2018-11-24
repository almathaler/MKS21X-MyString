public class MyString implements CharSequence, Comparable<CharSequence>{
	public static void main(String[] args){
		try {
			MyString tester = new MyString("hello");
			System.out.println("tester: " + tester);
			System.out.println("Length of tester (expect 5): " + tester.length());
			System.out.println("Get each character individually? (expect 'h', 'e', 'l', 'l', 'o')");
			for (int k = 0; k<tester.length()-1; k++) {
				System.out.print(tester.charAt(k) + ", ");
			}
			System.out.print(tester.charAt(tester.length()-1) + "\n");
			System.out.println("Get subsequences?");
			for (int k = 0; k<tester.length()+1; k++){
				System.out.println(tester.subSequence(0,k) + " (from: " + 0 + " to: " + k + ")");
			}
			System.out.println("Testing errors");
			System.out.println("When index for charAt is negative: ");
			//System.out.println(tester.charAt(-1));
			System.out.println("When index for charAt is greater than length: ");
			//System.out.println(tester.charAt(tester.length()));
			System.out.println("When start is less than 0, end less than 0, end less than start, end greater than tester.length(): ");
			//System.out.println(tester.subSequence(-1, 1));
			//System.out.println(tester.subSequence(-4, -1));
			//System.out.println(tester.subSequence(4, 2));
			//System.out.println(tester.subSequence(4, 6));
		}catch(IndexOutOfBoundsException e){
			System.out.println(e);
		}catch(NullPointerException e){
			System.out.println(e);
		}
	}
	private char[] data;
	public MyString(CharSequence s){
		data = new char[s.length()];
		for (int i = 0; i<s.length(); i++){
			data[i] = s.charAt(i);
		}
	}
	public char charAt(int index){
		if (index < 0 || index >= this.length()) {
			throw new IndexOutOfBoundsException("index for charAt out of bounds");
		}
		return data[index];
	}
	public int length(){
		return data.length;
	}
	public CharSequence subSequence(int start, int end){
		if (start < 0 || end < 0 || end > this.length() || start > end) {
			throw new IndexOutOfBoundsException("index for subSequence of out bounds");
		}
		String toReturn = "";
		for (int i = start; i<end; i++){
			toReturn += this.charAt(i);
		}
		return toReturn;
	}
	public String toString(){
		String toReturn = "";
		for (int i = 0; i<this.length(); i++){
			toReturn += this.charAt(i);
		}
		return toReturn;
	}
	public int compareTo(CharSequence o){
		if (o == null) {
			throw new NullPointerException("o is null");
		}
		int toReturn = 0;
		if (o.length() > this.length()) {
			for (int i = 0; i<this.length(); i++) {
				toReturn += (this.charAt(i) - o.charAt(i));
			}
			for (int i = this.length(); i < o.length(); i++) {
				toReturn -= o.charAt(i);
			}
			//follow same format for if o is longer or they're equal
		}
		else if (o.length() <= this.length()){
			for (int i = 0; i<o.length(); i++) {
				toReturn += (this.charAt(i) - o.charAt(i));
			}
			for (int i = o.length(); i < this.length(); i++) {
				toReturn += o.charAt(i);
			}
		}
		return toReturn;
	}
}
