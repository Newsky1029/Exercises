import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private String str;
    private int count;
    
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		String[] Lines = new String[n];
		String str = sc.nextLine();
		for(int i = 0; i < n; i ++) {
			str = sc.nextLine();
			Lines[i] = str;
		}
		sc.close();
		
		ArrayList<Main> loc = new ArrayList<Main>();
		
		
		for(int i = 0; i < n; i ++) {
			Main record = new Main();
			int count = 0;
	        record.str = Lines[i];
			for(int j = 0; j < m; j ++) {
				char a = Lines[i].charAt(j);
			 	for(int k = j + 1; k < m; k ++) {
					char b = Lines[i].charAt(k);
					if(a > b) {
						count ++;
					}
				}
			}
			record.count = count;
			loc.add(record);
		}
		/*√∞≈›≈≈–Ú*/
		for(int i = 0; i < n ; i ++) {
			for(int j = 0; j < n - 1; j ++) {
				Main u = loc.get(j);
				Main v = loc.get(j+1);
				if(u.count > v.count) {
					Main p = new Main();
					p.str = u.str;
					p.count = u.count;
					u.str = v.str;
					u.count = v.count;
					v.str = p.str;
					v.count = p.count;
				}
			}
		}
		
		for(int i = 0; i < n; i ++) {
			Main pr = loc.get(i);
			System.out.println(pr.str);
		}
	}
}