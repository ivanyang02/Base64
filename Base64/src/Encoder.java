
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Hashtable;
import java.util.StringTokenizer;

public class Encoder {

	static Hashtable<String, Character> table = new Hashtable<String, Character>();
	
	public static void filltable() {
		table.put("000000", 'A');
		table.put("000001", 'B');
		table.put("000010", 'C');
		table.put("000011", 'D');
		table.put("000100", 'E');
		table.put("000101", 'F');
		table.put("000110", 'G');
		table.put("000111", 'H');
		table.put("001000", 'I');
		table.put("001001", 'J');
		table.put("001010", 'K');
		table.put("001011", 'L');
		table.put("001100", 'M');
		table.put("001101", 'N');
		table.put("001110", 'O');
		table.put("001111", 'P');
		table.put("010000", 'Q');
		table.put("010001", 'R');
		table.put("010010", 'S');
		table.put("010011", 'T');
		table.put("010100", 'U');
		table.put("010101", 'V');
		table.put("010110", 'W');
		table.put("010111", 'X');
		table.put("011000", 'Y');
		table.put("011001", 'Z');
		table.put("011010", 'a');
		table.put("011011", 'b');
		table.put("011100", 'c');
		table.put("011101", 'd');
		table.put("011110", 'e');
		table.put("011111", 'f');
		table.put("100000", 'g');
		table.put("100001", 'h');
		table.put("100010", 'i');
		table.put("100011", 'j');
		table.put("100100", 'k');
		table.put("100101", 'l');
		table.put("100110", 'm');
		table.put("100111", 'n');
		table.put("101000", 'o');
		table.put("101001", 'p');
		table.put("101010", 'q');
		table.put("101011", 'r');
		table.put("101100", 's');
		table.put("101101", 't');
		table.put("101110", 'u');
		table.put("101111", 'v');
		table.put("110000", 'w');
		table.put("110001", 'x');
		table.put("110010", 'y');
		table.put("110011", 'z');
		table.put("110100", '0');
		table.put("110101", '1');
		table.put("110110", '2');
		table.put("110111", '3');
		table.put("111000", '4');
		table.put("111001", '5');
		table.put("111010", '6');
		table.put("111011", '7');
		table.put("111100", '8');
		table.put("111101", '9');
		table.put("111110", '+');
		table.put("111111", '/');
	}

	public static String encode(String s, String output) {
		if (s.length() == 0) {
			return output;
		}
		String bits = "";
		int len = 3;
		if (s.length() < 3) {
			len = s.length();
		}
		for (int i = 0; i < len; i++) {
			bits += String.format("%8s", Integer.toBinaryString(s.charAt(0))).replace(' ', '0');
			s = s.substring(1);
		}
		int pads = (24 - bits.length()) / 6;
		for (int i = 0; i < 4; i++) {
			boolean padded = false;
			if (bits.length() < 6) {
				while (bits.length() < 6) {
					bits += '0';
				}
				padded = true;
			}
			String bitpart = bits.substring(0, 6);
			bits = bits.substring(6);
			output += table.get(bitpart);
			if (padded) {
				break;
			}
		}
		for (int i = 0; i < pads; i++) {
			output += '=';
		}
		output = encode(s, output);
		return output;
	}

	public static void main(String[] args) {
		filltable();
		FastReader fs = new FastReader();
		String s = fs.nextLine();
		System.out.println(encode(s, ""));
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
