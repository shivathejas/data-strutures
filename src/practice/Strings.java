package practice;

import java.util.Scanner;

public class Strings {
	
	public void rotatematrix() {
		int a[][]= {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		System.out.println(a.length);
		int N = a.length;
		display(a);
		System.out.println("afetr matrix transpose");
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<a.length;j++) {
				System.out.print(a[j][i]+" ");
			}
			System.out.println();
		}
		System.out.println("ratating matrix anticlockwise direction by 90 degree");
		anticlockRoatation(a);
		display(a);
		System.out.println("ratating matrix clockwise direction by 90 degree");
		clockRotation(a);
		display(a);

	}
	public void display(int a[][]) {
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<a.length;j++) {
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}
	}
	public void display(char a[][]) {
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<a.length;j++) {
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}
	}
	public void anticlockRoatation(int a[][]) {
		int temp=0;
		int N = a.length;
		for(int x=0;x<N/2;x++) {
			for(int y=x;y<N-1-x;y++) {
				temp=a[x][y];
				a[x][y] = a[y][N-1-x];
				a[y][N-1-x] = a[N-1-x][N-1-y];
				a[N-1-x][N-1-y] = a[N-1-y][x];
				a[N-1-y][x] = temp;
			}
		}
	}
	public void clockRotation(int a[][]) {
		int temp=0;
		int N = a.length;
		for(int x=0;x<N/2;x++) {
			for(int y=x;y<N-1-x;y++) {
				temp = a[x][y];
				a[x][y] = a[N-1-y][x];
				a[N-1-y][x] = a[N-1-x][N-1-y];
				a[N-1-x][N-1-y] = a[y][N-1-x];
				a[y][N-1-x] = temp;
			}
		}
	}
//method implements replace 1th row and jth column by zero's if element at at (i,j) is zero
	public void replaceByZero() {
		char a[][] = {{'1','2','3','4'},{'0','5','6','7'},{'8','0','9','1'},{'1','1','9','1'}};
		int n = a.length;
		display(a);
		for(int x=0;x<n;x++) {
			for(int y=0;y<n;y++) {
				if(a[x][y] == '0') {
					for(int i=0;i<n;i++) {
						if(a[i][y] != '0') {
							a[i][y] = '_';
						}
					}
					for(int j=0;j<n;j++) {
						if(a[x][j] != '0') {
							a[x][j] = '_';
						}
					}
				}
			}
		}
		System.out.println("after replacing by zeros");
		display(a);
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(a[i][j] == '_') {
					a[i][j] = '0';
				}
			}
		}
		display(a);
	}
//	method checks whether str2 is a rotation of str1 or not.
	public boolean isRotation(String str1,String str2) {
		boolean result=false;
		/*
		 * StringBuilder sb1 = new StringBuilder(str1); StringBuilder sb2 = new
		 * StringBuilder(); int n =str1.length(); for(int i=0;i<n;i++) { char c1[] =
		 * str1.toCharArray(); char first = c1[0]; char last = c1[n-1-i-i];
		 * sb2.append(c1, i+1, n-2).append(last).append(first); str1 = sb2.toString();
		 * StringBuilder sb3 = new StringBuilder(); sb2 = sb3; if(str1.equals(str2)) {
		 * result = true; break; }else { result = false; } }
		 */
		String s1s1 = str1+str1;
		result = s1s1.contains(str2);
		System.out.println(s1s1.contains(str2));
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new  Scanner(System.in);
		System.out.println("enter a string");
		/*
		 * String str1 = scan.nextLine(); String str2 = scan.nextLine();
		 */
		Strings string = new Strings();
//		string.rotatematrix();
		System.out.println(string.isRotation("waterbottle","arbottlewat" ));
		
	}

}
