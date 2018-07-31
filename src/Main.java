import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;
import java.util.TreeMap;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

class Main {
	public static void main(String[] args) {
		
	}
}

class TwoStackGame {
	public static void main(String[] args) {
		int x = 10;
		int a[] = { 4, 2, 4, 6, 1 };
		int b[] = { 2, 1, 8, 5 };
		int sum = 0;
		Stack<Integer> a1 = new Stack<Integer>();
		for (int i = a.length - 1; i >= 0; i--) {
			a1.push(a[i]);
		}
		Stack<Integer> b1 = new Stack<Integer>();
		for (int i = b.length - 1; i >= 0; i--) {
			b1.push(b[i]);
		}
		int count = 0;
		while (sum < x) {

			if (a1.empty() && b1.empty()) {
				count++;
				break;
			} else if (a1.empty()) {
				int q = b1.pop();
				sum += q;
				count++;
			} else if (b1.empty()) {
				int p = a1.pop();
				sum += p;
				count++;
			} else {
				int p = a1.pop();
				int q = b1.pop();
				if (p < q) {
					sum += p;
					b1.push(q);
				} else if (p > q) {
					sum += q;
					a1.push(p);
				} else {
					sum += p;
					b1.push(q);
				}
				count++;
			}
		}
		System.out.println(count - 1);
	}
}

class BalancedBrackets {

	public static void main(String[] argh) {
		Scanner sc = new Scanner(System.in);

		while (sc.hasNext()) {
			String input = sc.next();
			// Complete the code
			Stack<Character> s = new Stack();

			for (int i = 0; i < input.length(); i++) {
				Character c = input.charAt(i);
				if (c == '(' || c == '{' || c == '[') {
					s.push(input.charAt(i));
					// System.out.println(s);
				} else if (c == ')') {
					if (s.isEmpty() || s.pop() != '(') {
						System.out.println("false");
						break;
					}
				} else if (c == '}') {

					if (s.isEmpty() || s.pop() != '{') {
						System.out.println("false");
						break;
					}
				} else if (c == ']') {
					if (s.isEmpty() || s.pop() != '[') {
						System.out.println("false");
						break;
					}
				}
			}

			if (s.empty()) {
				System.out.println("true");
			}

		}

	}
}

class MapEnterySet {
	public static void main(String[] args) {

		Map<String, Integer> mp = new HashMap();
		mp.put("Kunal", 9);
		mp.put("KUNAL", 27);

		for (Map.Entry<String, Integer> me : mp.entrySet()) {
			System.out.println(me.getKey() + "/" + me.getValue());
		}
	}

}

class RAngeApplication {

	public static void main(String[] args) {

		Range A = new Range(2, 3);
		Range B = new Range(3, 5);
		Range C = A.intersection(B);
		C.print();
	}

}

class Range {
	private int start;
	private int range;

	Range(int start, int range) {
		this.start = start;
		this.range = range;
	}

	public Range intersection(Range obj) {
		Range C = new Range(0, 0);
		if (obj.start > this.start) {
			C.start = obj.start;
			C.range = this.start + this.range > obj.start + obj.range ? obj.start + obj.range - C.start
					: this.start + this.range - C.start;
		}

		return C;

	}

	public void print() {
		System.out.println("Start:" + this.start + " Range: " + this.range);
	}

}

class RunnableThread implements Runnable {

	@Override
	public void run() {
		for (int i = 1; i <= 5; i++) {
			System.out.println(i + " " + Thread.currentThread().getId());
			try {
				Thread.sleep(1000);

			} catch (Exception e) {
				// TODO: handle exception
			}
		}

	}

	public static void main(String[] args) {
		// Main m = new Main();new Thread(m).start();
		// Main m2 = new Main();new Thread(m2).start();

	}

}

class ExtendingThreadClassMain extends Thread {

	static private int obj = 1;

	public static void main(String[] args) {
		Main m = new Main();
		Main m2 = new Main();
		for (int i = 0; i < 5; i++) {
			// m.start();
			// m2.start();
		}

	}

	@Override
	public void run() {
		System.out.println(obj);
		obj++;
	}

}

class UniquePairInArrayEqualToSum {

	public static void main(String[] args) {
		int[] ar = { 2, 4, 2, 8, 6 };
		long k = 4;
		int pairs = 0;
		Map<Integer, Integer> mp = new HashMap();
		for (int i = 0; i < ar.length; i++) {
			int part1 = ar[i];
			int part2 = (int) k - part1;

			if (mp.containsKey(part2)) {
				int count = mp.get(part2) - 1;
				pairs++;
				if (count == 0) {
					mp.remove(part2);
				} else {
					mp.put(part2, count);
				}
			} else {
				if (mp.containsKey(part1)) {
					mp.put(part1, mp.get(part1) + 1);
				} else {
					mp.put(part1, 1);
				}
			}

		}

	}
}

class EulerProblem2 {
	public static void main(String[] args) {
		/*
		 * for (int i = 1; i <= 10; i++) {
		 * 
		 * System.out.println(fib(i)); }
		 */
		double ans = 0;
		double num = 1;
		int i = 1;
		while (num < 4000000) {

			num = fib(i);

			if (num % 2 == 0 && num < 4000000) {
				ans += num;
			}
			i++;
		}
		System.out.println(ans);

	}

	static double fib(double n) {
		if (n <= 1) {
			return 1.0d;
		}
		return fib(n - 1) + fib(n - 2);
	}
}

class EulerProblem1 {

	public static void main(String[] args) {

		int ans = 0;
		int i = 1;

		while (3 * i < 1000) {
			ans += 3 * i;
			i++;
		}
		i = 1;
		while (5 * i < 1000) {
			ans += 5 * i;
			i++;
		}

		i = 1;
		while (15 * i < 1000) {
			ans -= 15 * i;
			i++;
		}
		System.out.println(ans);
	}

}

class CollectionAndStrings {
	public static void main(String[] args) {
		String str = "abc";
		String str1 = "abc";
		String x = new String("abc");
		String y = new String("abc");
		System.out.println(x == y);
		System.out.println(str == str1);
		System.out.println(str1.equals("abc"));

		Map hm = new HashMap();
		hm.put(null, "askdjk");
		System.out.println(hm);
		Map lhm = new LinkedHashMap<>();
		lhm.put(null, "sadad");
		System.out.println(lhm);
		Map tm = new TreeMap<>();
		tm.put(1, "asdad");
		System.out.println(tm);

		BlockingQueue q = new ArrayBlockingQueue<>(2);
		q.add(9);
		q.add(6);
		try {
			q.offer(27, 6, TimeUnit.SECONDS);
			System.out.println(q);
			q.remove(6);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(q);
	}
}

class Java8Streams {
	public static void main(String[] args) {
		List<String> ls = new LinkedList();

		ls.add("Kunal");
		ls.add("Balu");
		ls.add("Poku");
		ls.add("Paka");

		ls.stream().filter(u -> u.startsWith("P")).forEach(u -> System.out.println(u));

	}
}

@FunctionalInterface
interface Square {
	public int root(int x);
}

class LambdaExpression {
	public static void main(String[] args) {
		Square sq = new Square() {
			public int root(int x) {
				return x * x;
			};
		};

		System.out.println(sq.root(10));
		Square sqLambda = x -> x * x;
		System.out.println(sqLambda.root(10));

	}

}

class PermutationsOfString {

	private static HashSet<String> hs = new HashSet<String>();

	public static void main(String[] args) {
		String n = "AAB";
		allPermutaion("", n);
		for (String s : hs) {
			System.out.println(s);
		}
	}

	public static void allPermutaion(String prefix, String word) {

		if (word.length() == 0) {
			// System.out.println(prefix);
			hs.add(prefix);
		}
		for (int i = 0; i < word.length(); i++) {
			allPermutaion(prefix + word.charAt(i), word.substring(0, i) + word.substring(i + 1, word.length()));
		}

	}
}

class PalindromeCheck {
	public static void main(String[] args) {
		// abaaaba

		String s = "abaaaba";
		char a[] = s.toCharArray();

		int j = 0;
		String an = "Palindrome";
		for (int i = a.length - 1; i > a.length / 2; i--) {
			if (a[i] != a[j]) {
				an = "Not Palindrome";
				break;
			}
			j++;
		}
		System.out.println(an);
	}
}

class GFG {

	GFG(int x) {
		System.out.println("ONE argument constructor");
	}

	GFG() {
		System.out.println("No  argument constructor");
	}

	static {
		System.out.println("1st static init");
	}

	{
		System.out.println("1st instance init");
	}

	{
		System.out.println("2nd instance init");
	}

	static {
		System.out.println("2nd static init");
	}

	public static void main(String[] args) {
		new GFG();
		new GFG(8);
	}
}