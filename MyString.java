public class MyString implements CharSequence, Comparable<CharSequence>{
	public static void main(String[] args){
		try {
			System.out.println("FIRST TEST: IF 0 IS PRODUCED, OK: " + "ad".compareTo("bc"));
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
			MyString other = new MyString("helloo");
			System.out.println("How should " + tester + " and " + other + " compare? (expect a negative number): " + tester.compareTo(other));
			System.out.println("Wb " + other + " and " + tester + "? (expect opposite of previous): " + other.compareTo(tester));
			MyString tester1 = new MyString("abcdef");
			MyString other1 = new MyString("ghijkl");
			System.out.println("How should " + tester1 + " and " + other1 + " compare? (expect a negative number): " + tester1.compareTo(other1));
			System.out.println("Wb " + other1 + " and " + tester1 + "? (expect opposite of previous): " + other1.compareTo(tester1));
			MyString tester2 = new MyString("ad");
			MyString other2 =  new MyString("bc");
			System.out.println("How should " + tester2 + " and " + other2 + " compare? (expect a negative number): " + tester2.compareTo(other2));
			System.out.println("Wb " + other2 + " and " + tester2 + "? (expect opposite of previous): " + other2.compareTo(tester2));
			System.out.println("Is compareTo transitive?");
			MyString another = new MyString("goodbye");
			//System.out.println("tester: " + tester + " other: " + other + " another: " + another);
			System.out.println(other + ".compareTo(" + tester + ") equals: " + other.compareTo(tester));
			System.out.println(another + ".compareTo(" + other + ") equals: " + another.compareTo(other));
			System.out.println(another + ".compareTo(" + tester + ") equals: " + another.compareTo(tester));
			System.out.println("Will the opposite produce all negatives as it should?");
			System.out.println(tester + ".compareTo(" + other + ") equals: " + tester.compareTo(other));
			System.out.println(other + ".compareTo(" + another + ") equals: " + other.compareTo(another));
			System.out.println(tester + ".compareTo(" + another + ") equals: " + tester.compareTo(another));
			System.out.println("Can we show two MyStrings are the same with compareTo?");
			MyString same1  = new MyString("abcdef");
			MyString same2  = new MyString("abcdef");
			System.out.println(same1 + ".compareTo(" + same2 + ") equals: " + same1.compareTo(same2));
			System.out.println(same2 + ".compareTo(" + same1 + ") equals: " + same2.compareTo(same1));
			System.out.println("If " + same1 + " and " + same2 + " are compared to the same thing, do they yield the same result?");
			System.out.println(same1 + ".compareTo(" + tester + ") equals: " + same1.compareTo(tester));
			System.out.println(same2 + ".compareTo(" + tester + ") equals: " + same2.compareTo(tester));
			System.out.println("Finally, do we get an error if we try to compare a null object? ");
			MyString nullObj = null;
			System.out.println(tester.compareTo(nullObj));
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
			throw new NullPointerException("parameter is null");
		}
		int toReturn = 0;
		if (o.length() == this.length()) {
			for(int i = 0; i < o.length(); i++){
				if (o.charAt(i) == this.charAt(i)){
					toReturn += 0;
				}
				else{
					toReturn+=(this.charAt(i) - o.charAt(i));
					i = o.length();
				}
			}
		}
		else if (o.length() > this.length()) {
			for (int i = 0; i<this.length(); i++) {
				toReturn += (this.charAt(i) - o.charAt(i));
			}
			for (int i = this.length(); i < o.length(); i++) {
				toReturn -= o.charAt(i);
			}
			//follow same format for if o is longer or they're equal
		}
		else {
			for (int i = 0; i<o.length(); i++) {
				toReturn += (this.charAt(i) - o.charAt(i));
			}
			for (int i = o.length(); i < this.length(); i++) {
				toReturn += this.charAt(i);
			}
		}
		return toReturn;
	}
}
