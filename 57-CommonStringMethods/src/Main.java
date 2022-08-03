
public class Main {
	public static void main(String[] args) {
		
		String words[] = { "funk", "chunk", "furry", "baconator" };
		
		//startsWidth
		for(String w : words) {
			if(w.startsWith("fu"))
				System.out.println(w + " starts with fu");
		}		
		
		String w;
		for(int i = 0; i < words.length; i++) {
			if(words[i].endsWith("nk"))
				System.out.println(words[i] + " ends with nk");
		}
	}
}
