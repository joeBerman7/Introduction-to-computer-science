import java.util.Comparator;
import java.util.Iterator;
import java.util.zip.CheckedInputStream;

public class TestNetaAssign5 {

	public static void main(String[] args) {
		//check1_1234();
		//check5();
		check6();
		
	}
	public static void check1_0()
	{
		System.out.println("task 1.0");
		Iterator<String> iter = new StringIterator("");
		System.out.println("empty|"+iter.next());
		System.out.println("a|"+iter.next());
		System.out.println("b|"+iter.next());
		iter = new StringIterator("abZ");
		System.out.println("aca|"+iter.next());
		iter = new StringIterator("ZY");
		System.out.println("ZZ|"+iter.next());
		System.out.println("aaa|"+iter.next());
		String s="";
		String a="";
		for(int i=0;i<100;i++)
			s=s+"Z";
		iter=new StringIterator(s);
		for(int i=0;i<101;i++)
			a=a+"a";
		System.out.println(a+"|\n"+iter.next());
		System.out.println("***************************************************");
		
	}
	public static void Check1_1234() {

		BankAccount ba1=new BankAccount("neta", 1, 1000);
		BankAccount ba2=new BankAccount("shir", 2, 2000);
		BankAccount ba3=new BankAccount("rotem", 3, 3000);
		BankAccount ba4=new BankAccount("dana", 4, 4000);
		BankAccount ba5=new BankAccount("itay", 5, 5000);
		BankAccount ba6=new BankAccount("ohad", 6, 6000);
		BankAccount ba7=new BankAccount("amit", 7, 7000);
		BankAccount ba8=new BankAccount("yuval",8, 8000);
		BankAccount ba9=new BankAccount("shahar", 9, 9000);
		BankAccount ba10=new BankAccount("neta", 10, 10000);
		
		System.out.println("true|"+ba1.depositMoney(200)+" 1200|"+ba1.getBalance());
		System.out.println("true|"+ba2.withdrawMoney(1000)+" 1000|"+ba2.getBalance());
		System.out.println("false|"+ba2.withdrawMoney(-100)+" 1000|"+ba2.getBalance());
		System.out.println("true|"+ba2.withdrawMoney(1000)+" 0|"+ba2.getBalance());
		System.out.println("false|"+ba2.withdrawMoney(1000)+" 0|"+ba2.getBalance());
		System.out.println("false|"+ba2.depositMoney(-100)+" 0|"+ba2.getBalance());
		
		Comparator<BankAccount> nameComparator= new AccountComparatorByName();
		Comparator<BankAccount> numberComparator= new AccountComparatorByNumber();
		System.out.println("number biigger than 0: "+ nameComparator.compare(ba1, ba5));
		System.out.println("number biigger than 0: "+ numberComparator.compare(ba7, ba5));
		System.out.println("number smaller than 0: "+ nameComparator.compare(ba7, ba8));
		System.out.println("number smaller than 0: "+ numberComparator.compare(ba4, ba7));
		System.out.println(" 0: "+ nameComparator.compare(ba7, ba7));
		System.out.println("***************************************");
		System.out.println("check 1.4:");
		System.out.println("make sure it looks like a diagonal tree on the side:");
		System.out.println("___________________________________________________");
		BinarySearchTree t1 = new BinarySearchTree(numberComparator);
		t1.insert(ba1);
		t1.insert(ba2);
		t1.insert(ba3);
		t1.insert(ba4);
		t1.insert(ba5);
		t1.insert(ba6);
		t1.insert(ba7);
		t1.insert(ba8);
		t1.insert(ba9); 
		t1.insert(ba10);
		System.out.println(t1.toString());
		System.out.println();
		System.out.println("messier tree, still looks like a tree");
		System.out.println("______________________________________");
		BinarySearchTree t2 = new BinarySearchTree(nameComparator);
		t2.insert(ba1);
		t2.insert(ba2);
		t2.insert(ba3);
		t2.insert(ba4);
		t2.insert(ba5);
		t2.insert(ba6);
		t2.insert(ba7);
		t2.insert(ba8);
		t2.insert(ba9);
		t2.insert(ba10);
		System.out.println(t2.toString());

	}
	public static void check5()
	{
		BankAccount ba1=new BankAccount("neta", 1, 1000);
		BankAccount ba2=new BankAccount("shir", 2, 2000);
		BankAccount ba3=new BankAccount("rotem", 3, 3000);
		BankAccount ba4=new BankAccount("dana", 4, 4000);
		BankAccount ba5=new BankAccount("itay", 5, 5000);
		BankAccount ba6=new BankAccount("ohad", 6, 6000);
		BankAccount ba7=new BankAccount("amit", 7, 7000);
		BankAccount ba8=new BankAccount("yuval",8, 8000);
		BankAccount ba9=new BankAccount("shahar", 9, 9000);
		BankAccount ba10=new BankAccount("neta", 10, 10000);
		
		Comparator<BankAccount> nameComparator= new AccountComparatorByName();
		Comparator<BankAccount> numberComparator= new AccountComparatorByNumber();
		BankAccountsBinarySearchTree t1=new BankAccountsBinarySearchTree(numberComparator);
		t1.insert(ba1);
		t1.insert(ba2);
		t1.insert(ba3);
		t1.insert(ba4);
		t1.insert(ba5);
		t1.insert(ba6);
		t1.insert(ba7);
		t1.insert(ba8);
		t1.insert(ba9);
		t1.insert(ba10);
		System.out.println("not balanced by account number:");
		System.out.println("_______________________________");
		System.out.println(t1);
		System.out.println(" balanced by account number:");
		System.out.println("___________________________");
		t1.balance();
		System.out.println(t1);
		
		BankAccountsBinarySearchTree t2=new BankAccountsBinarySearchTree(nameComparator);
		t2.insert(ba7);
		t2.insert(ba4);
		t2.insert(ba5);
		t2.insert(ba1);
		t2.insert(ba6);
		t2.insert(ba3);
		t2.insert(ba9);
		t2.insert(ba2);
		t2.insert(ba10);
		t2.insert(ba8);
		System.out.println("not balanced by name,make sure number 10 is not in the tree:");
		System.out.println("_______________________________");
		System.out.println(t2);
		System.out.println(" balanced by name number:");
		System.out.println("___________________________");
		t2.balance();
		System.out.println(t2);
		
		System.out.println();
		System.out.println("task 5.d");
		Filter<BankAccount> filter1= new FilterByBalance(5000);
		System.out.println("true|"+filter1.accept(ba8));
		System.out.println("false|"+filter1.accept(ba1));
		Iterator<BankAccount> iter=new FilteredBankAccountsIterator(t1, filter1);
		BankAccountsBinarySearchTree newTree= new BankAccountsBinarySearchTree(numberComparator);
		while(iter.hasNext()) {
			newTree.insert(iter.next());
		}
		System.out.println("tree with balance only over 5000 (5,6,7,8,9,10):");
		System.out.println("_________________________________");
		System.out.println(newTree);
	}
	public static void check6()
	{
		BankAccount ba1=new BankAccount("neta", 1, 1000);
		BankAccount ba2=new BankAccount("shir", 2, 2000);
		BankAccount ba3=new BankAccount("rotem", 3, 3000);
		BankAccount ba4=new BankAccount("dana", 4, 4000);
		BankAccount ba5=new BankAccount("itay", 5, 5000);
		BankAccount ba6=new BankAccount("ohad", 6, 6000);
		BankAccount ba7=new BankAccount("amit", 7, 7000);
		BankAccount ba8=new BankAccount("yuval",8, 8000);
		BankAccount ba9=new BankAccount("shahar", 9, 9000);
		BankAccount ba10=new BankAccount("neta", 10, 10000);
		BankAccount ba11=new BankAccount("eliya", 9, 10000);
		
		Bank leumiBank =new Bank();
		System.out.println("true|"+leumiBank.add(ba1));
		System.out.println("true|"+leumiBank.add(ba2));
		System.out.println("true|"+leumiBank.add(ba3));
		System.out.println("true|"+leumiBank.add(ba4));
		System.out.println("true|"+leumiBank.add(ba5));
		System.out.println("true|"+leumiBank.add(ba6));
		System.out.println("true|"+leumiBank.add(ba7));
		System.out.println("true|"+leumiBank.add(ba8));
		System.out.println("true|"+leumiBank.add(ba9));
		System.out.println("false|"+leumiBank.add(ba10));
		System.out.println("false|"+leumiBank.add(ba11));
		
		System.out.println("true|"+leumiBank.delete("dana"));
		System.out.println("false|"+leumiBank.delete("dana"));
		System.out.println("true|"+leumiBank.delete(2));
		System.out.println("false|"+leumiBank.delete(2));
		System.out.println("false|"+leumiBank.transferMoney(5000, 3, "amit"));
		System.out.println("true|"+leumiBank.transferMoney(500, 3, "amit"));
		System.out.println("2500|"+ba3.getBalance());
		System.out.println("7500|"+ba7.getBalance());
		ba3.depositMoney(500);
		ba7.withdrawMoney(500);
		System.out.println("3000|"+ba3.getBalance());
		System.out.println("7000|"+ba7.getBalance());
		
		
		
		
		
	}
}
