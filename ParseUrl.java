import java.util.Scanner;
public class ParseUrl{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while(true){
			System.out.print("Enter a website(or enter -1 to exit):");
			String website = input.next();
			if(website.equals("-1")==true) break;
			else parse(website);
		}
	}
	private static void parse(String fullpath){
		System.out.println();
		System.out.println("input="+fullpath);
		int index1 = fullpath.indexOf(":");
		String protocol = fullpath.substring(0,index1);
		System.out.println("protocol="+protocol);
		String subpath = fullpath.substring(index1+3);
		int index2 = subpath.indexOf("/");
		String host = subpath.substring(0,index2);
		System.out.println("host="+host);
		String tokens[] = host.split("\\.");
		int length = tokens.length;
		if (host.indexOf("tw")==host.length()-2){
			String domain = tokens[length-3]+"."+tokens[length-2]+"."+tokens[length-1];
			System.out.println("domain="+domain);
		}
		else if (host.indexOf("com")==host.length()-3){
			String domain = tokens[length-2]+"."+tokens[length-1];
			System.out.println("domain="+domain);	
		}
		String afterhost = subpath.substring(index2);
		if (afterhost.indexOf("?")>=0){
			int index3 = afterhost.indexOf("?");
			String path = afterhost.substring(0,index3);
			String query = afterhost.substring(index3+1);
			int index4 = path.lastIndexOf("/");
			String shortpath = path.substring(index4+1);
			if (shortpath.indexOf(".")>=0){
				String tokens2[] = shortpath.split("\\.");
				System.out.println("fileName="+tokens2[0]);
				System.out.println("fileType="+tokens2[1]);
			}
			System.out.println("path="+path);
			System.out.println("query="+query);  
		}	
		else if (afterhost.indexOf("#")>=0){
			int index3 = afterhost.indexOf("#");
			String path = afterhost.substring(0,index3);
			String hash = afterhost.substring(index3);
			int index4 = path.lastIndexOf("/");
			String shortpath = path.substring(index4+1);
			if (shortpath.indexOf(".")>=0){
				String tokens2[] = shortpath.split("\\.");
				System.out.println("fileName="+tokens2[0]);
				System.out.println("fileType="+tokens2[1]);
			}
			System.out.println("path="+path);
			System.out.println("hash="+hash);
		}
		else{
			int index4 = afterhost.lastIndexOf("/");
			String file = afterhost.substring(index4+1);
			String tokens3[] = file.split("\\.");
			String fileName = tokens3[0];
			String fileType = tokens3[1];
			System.out.println("fileName="+fileName);
			System.out.println("fileType="+fileType);
			System.out.println("path="+afterhost);
		}
		System.out.println("===============================");
	}
}