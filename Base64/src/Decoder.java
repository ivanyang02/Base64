
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Hashtable;
import java.util.StringTokenizer;

public class Decoder {

	static Hashtable<Character, String> table = new Hashtable<Character, String>();
	
	public static void filltable() {
		table.put('A', "000000");
		table.put('B', "000001");
		table.put('C', "000010");
		table.put('D', "000011");
		table.put('E', "000100");
		table.put('F', "000101");
		table.put('G', "000110");
		table.put('H', "000111");
		table.put('I', "001000");
		table.put('J', "001001");
		table.put('K', "001010");
		table.put('L', "001011");
		table.put('M', "001100");
		table.put('N', "001101");
		table.put('O', "001110");
		table.put('P', "001111");
		table.put('Q', "010000");
		table.put('R', "010001");
		table.put('S', "010010");
		table.put('T', "010011");
		table.put('U', "010100");
		table.put('V', "010101");
		table.put('W', "010110");
		table.put('X', "010111");
		table.put('Y', "011000");
		table.put('Z', "011001");
		table.put('a', "011010");
		table.put('b', "011011");
		table.put('c', "011100");
		table.put('d', "011101");
		table.put('e', "011110");
		table.put('f', "011111");
		table.put('g', "100000");
		table.put('h', "100001");
		table.put('i', "100010");
		table.put('j', "100011");
		table.put('k', "100100");
		table.put('l', "100101");
		table.put('m', "100110");
		table.put('n', "100111");
		table.put('o', "101000");
		table.put('p', "101001");
		table.put('q', "101010");
		table.put('r', "101011");
		table.put('s', "101100");
		table.put('t', "101101");
		table.put('u', "101110");
		table.put('v', "101111");
		table.put('w', "110000");
		table.put('x', "110001");
		table.put('y', "110010");
		table.put('z', "110011");
		table.put('0', "110100");
		table.put('1', "110101");
		table.put('2', "110110");
		table.put('3', "110111");
		table.put('4', "111000");
		table.put('5', "111001");
		table.put('6', "111010");
		table.put('7', "111011");
		table.put('8', "111100");
		table.put('9', "111101");
		table.put('+', "111110");
		table.put('/', "111111");
		table.put('=', "      ");
	}

	public static String decode(String s, String output) {
		if (s.length() == 0) {
			return output;
		}
		String part = s.substring(0, 4);
		s = s.substring(4);
		char[] characters = part.toCharArray();
		String bits = "";
		for (int i = 0; i < 4; i++) {
			if (characters[i] != '=') {
				bits += table.get(characters[i]);
			}
		}
		for (int i = 0; i < 3; i++) {
			if (bits.length() >= 8) {
				String bitpart = bits.substring(0, 8);
				bits = bits.substring(8);
				output += Character.toString((char) Integer.parseInt(bitpart, 2));
			}
		}
		output = decode(s, output);
		return output;
	}

	public static void main(String[] args) {
		filltable();
		FastReader fs = new FastReader();
		String s = "";
		String in = " ";
		while (!in.isEmpty()) {
			in = fs.nextLine();
			s += in;
		}
		System.out.println(decode(s, ""));
	}

	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}
