import java.util.Iterator;
import java.util.Scanner;
import java.util.Comparator;

public class test {

	public static void main(String[] args) {
		Q0();
		Q1();
		Q2();
		Q4();
		Q5b();
		Q5c();
		Q5d();
		Q6();
	}

	private static void Q0() {
		StringIterator iter = new StringIterator("ZZ");
		for (int i = 0; i < 4; i = i + 1) {
			System.out.print(iter.next()+", ");
		}

		System.out.println("||| ZZ, aaa, aab, aac, ");
		System.out.println();

		iter = new StringIterator("z");
		for (int i = 0; i < 4; i = i + 1) {
			System.out.print(iter.next()+", ");
		}
		System.out.println("||| z, A, B, C, ");
		System.out.println();

		iter = new StringIterator("");
		for (int i = 0; i < 4; i = i + 1) {
			System.out.print(iter.next()+", ");
		}
		System.out.println("||| , a, b, c, ");
		System.out.println();

		iter = new StringIterator("ZZaZ");
		for (int i = 0; i < 4; i = i + 1) {
			System.out.print(iter.next()+", ");
		}

		System.out.println("||| ZZaZ, ZZba, ZZbb, ZZbc, ");
		System.out.println();

		iter = new StringIterator("ZZZz");
		for (int i = 0; i < 4; i = i + 1) {
			System.out.print(iter.next()+", ");
		}

		System.out.println("||| ZZZz, ZZZA, ZZZB, ZZZC, ");
		System.out.println();

		iter = new StringIterator("pEZ");
		for (int i = 0; i < 4; i = i + 1) {
			System.out.print(iter.next()+", ");
		}

		System.out.println("||| pEZ, pFa, pFb, pFc, ");
		System.out.println();

		System.out.println("Got:");

		iter = new StringIterator("pYZ");
		for (int i = 0; i < 54; i = i + 1) {
			System.out.print(iter.next()+", ");
		}
		System.out.println("\nExpected:");
		System.out.println("pYZ, pZa, pZb, pZc, pZd, pZe, pZf, pZg, pZh, pZi, pZj, pZk, pZl, pZm, pZn, pZo, pZp, pZq, pZr, pZs, pZt, pZu, pZv, pZw, pZx, pZy, pZz, pZA, pZB, pZC, pZD, pZE, pZF, pZG, pZH, pZI, pZJ, pZK, pZL, pZM, pZN, pZO, pZP, pZQ, pZR, pZS, pZT, pZU, pZV, pZW, pZX, pZY, pZZ, qaa, ");
	}

	private static void Q1() {
		BankAccount ba1 = new BankAccount("a", 1, 1);
		BankAccount ba2 = new BankAccount("c", 3, 100);
		BankAccount ba3 = new BankAccount("d", 4, 1000);


		System.out.println(ba1.depositMoney(0)  + "|true");
		System.out.println(ba1.depositMoney(110)  + "|true");
		System.out.println(ba1.depositMoney(-110)  + "|false");
		System.out.println(ba1.depositMoney(-0)  + "|true");
		System.out.println(ba1.depositMoney(-1)  + "|false");

		System.out.println(ba1.withdrawMoney(0)  + "|true");
		System.out.println(ba1.withdrawMoney(111)  + "|true");
		System.out.println(ba1.withdrawMoney(112)  + "|false");
		System.out.println(ba1.withdrawMoney(-110)  + "|false");
		System.out.println(ba1.withdrawMoney(-0)  + "|true");
		System.out.println(ba1.withdrawMoney(-1)  + "|false");
		System.out.println(ba2.withdrawMoney(110)  + "|false");
		System.out.println(ba3.withdrawMoney(110)  + "|true");
	}

	private static void Q2() {
		BankAccount ba1 = new BankAccount("a", 1, 1);
		BankAccount ba2 = new BankAccount("c", 3, 100);
		Comparator<BankAccount> nameComp = new AccountComparatorByName();
		Comparator<BankAccount> numComp = new AccountComparatorByNumber();

		System.out.println(nameComp.compare(ba1, ba2) + "|-2");
		System.out.println(nameComp.compare(ba2, ba2) + "|0");
		System.out.println(nameComp.compare(ba2, ba1) + "|2");	

		System.out.println(numComp.compare(ba1, ba2) + "|-1");
		System.out.println(numComp.compare(ba2, ba2) + "|0");
		System.out.println(numComp.compare(ba2, ba1) + "|1");
	}

	private static void Q4() {
		Comparator<Integer> c = new IntegerComparator();

		BinarySearchTree t1 = new BinarySearchTree(c);
		t1.insert(10);
		t1.insert(4);
		t1.insert(8);
		t1.insert(7);
		t1.insert(6);
		t1.insert(5);
		System.out.println("----------Got:----------\n" + t1);

		System.out.println("----------Expected:----------");
		System.out.println("  4");
		System.out.println("          5");
		System.out.println("        6");
		System.out.println("      7");
		System.out.println("    8");
		System.out.println("10");
	}

	private static void Q5b() {
		Comparator<BankAccount> c = new AccountComparatorByNumber();

		BankAccountsBinarySearchTree t1 = new BankAccountsBinarySearchTree(c);
		t1.insert(new BankAccount("a", 9, 0));
		t1.insert(new BankAccount("b", 4, 0));
		t1.insert(new BankAccount("c", 8, 0));
		t1.insert(new BankAccount("d", 7, 0));
		t1.insert(new BankAccount("f", 6, 0));
		t1.insert(new BankAccount("g", 5, 0));
		String unbalanced = t1.toString();
		unbalanced = unbalanced.replace("Name: ", "").replace(", AccountNumber: ", "")
				.replace("a","").replace("b","").replace("c","")
				.replace("d","").replace("f","").replace("g","");

		System.out.println("----------Unbalanced:----------\n" + unbalanced);
		t1.balance();
		String balanced = t1.toString();
		balanced = balanced.replace("Name: ", "").replace(", AccountNumber: ", "")
				.replace("a","").replace("b","").replace("c","")
				.replace("d","").replace("f","").replace("g","");
		System.out.println("----------Got:----------\n" + balanced);
		System.out.println("----------Expected:----------");
		System.out.println("    4\r\n"
				+ "  5\r\n"
				+ "    6\r\n"
				+ "7\r\n"
				+ "    8\r\n"
				+ "  9\r\n"
				+ "");
	}

	private static void Q5c() {
		Filter<BankAccount> f = new FilterByBalance(10000);
		BankAccount ba1 = new BankAccount("a", 1, 0);
		BankAccount ba2 = new BankAccount("b", 2, 123789);
		BankAccount ba3 = new BankAccount("c", 3, -110);
		BankAccount ba4 = new BankAccount("d", 4, 9999);

		System.out.println(f.accept(ba1) + "|false");
		System.out.println(f.accept(ba2) + "|true");
		System.out.println(f.accept(ba3) + "|false");
		System.out.println(f.accept(ba4) + "|false");
	}

	private static void Q5d() {
		BankAccount ba1 = new BankAccount("a", 1, 1);
		BankAccount ba2 = new BankAccount("b", 2, 10);
		BankAccount ba3 = new BankAccount("c", 3, 100);
		BankAccount ba4 = new BankAccount("d", 4, 1000);
		BankAccount ba5 = new BankAccount("e", 5, 10000);
		BankAccount ba6 = new BankAccount("f", 6, 100000);
		BankAccount ba7 = new BankAccount("g", 7, 1000000);
		Comparator<BankAccount> comp = new AccountComparatorByNumber();
		BankAccountsBinarySearchTree baTree = new BankAccountsBinarySearchTree(comp);
		baTree.insert(ba1);
		baTree.insert(ba2);
		baTree.insert(ba3);
		baTree.insert(ba4);
		baTree.insert(ba5);
		baTree.insert(ba6);
		baTree.insert(ba7);

		Filter<BankAccount> f = new FilterByBalance(1000);
		Iterator<BankAccount> iter = new FilteredBankAccountsIterator(baTree, f);

		System.out.println("Got:");

		while(iter.hasNext())
			System.out.println(iter.next());

		System.out.println("Expected:");
		System.out.println("Name: d, AccountNumber: 4\r\n"
				+ "Name: e, AccountNumber: 5\r\n"
				+ "Name: f, AccountNumber: 6\r\n"
				+ "Name: g, AccountNumber: 7");
	}
	
	private static void Q6() {
		BankAccount ba1 = new BankAccount("a", 1, 1);
		BankAccount ba2 = new BankAccount("a", 2, 10);
		BankAccount ba3 = new BankAccount("c", 1, 100);
		Bank bank = new Bank();
		System.out.println(bank.add(ba1) + "|true");
		System.out.println(bank.add(ba2) + "|false");
		System.out.println(bank.add(ba3) + "|false");
		
		System.out.println(bank.delete(ba2.getAccountNumber()) + "|false");
		System.out.println(bank.delete(ba2.getName()) + "|true");
		System.out.println(bank.delete(ba3.getAccountNumber()) + "|false");
		System.out.println(bank.delete(ba3.getName()) + "|false");
		System.out.println(bank.delete(ba1.getAccountNumber()) + "|false");
		System.out.println(bank.delete(ba1.getName()) + "|false");
		System.out.println(bank.add(ba1) + "|true");
		System.out.println(bank.delete(ba1.getName()) + "|true");
		System.out.println(bank.add(ba1) + "|true");
		System.out.println(bank.delete(ba3.getAccountNumber()) + "|true");
	}

}
