public class MyString implements CharSequence, Comparable<CharSequence>{
	private char[] data;
	public MyString(CharSequence s){
		data = new char[s.length()];
		for (int i = 0; i<s.length(); i++){
			data[i] = s.charAt(i);
		}
	}
	public char charAt(int index){
		return data[index];	
	}
	public int length(){
		return data.length;
	}
	public CharSequence subSequence(int start, int end){
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
		int toReturn = 0; 
		if (o.length() > this.length()) {
			for (int i = 0; i<this.length(); i++) {
				toReturn += (this.charAt(i) - o.charAt(i));
			}		
			for (int i = this.length(); i < o.length(); i++) {
				toReturn += o.charAt(i)
			}
			//follow same format for if o is longer or they're equal
		}
		else if (o.length() <= this.length()){
			return 1;
		}
	}
}
