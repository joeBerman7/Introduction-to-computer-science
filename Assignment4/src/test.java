import java.util.Iterator;

public class test extends BitList{

	public static void main(String[] args) {
		
//        System.out.println("task 3.1 + 3.2");
//        BinaryNumber b0 = new BinaryNumber('0');
//        System.out.println("0 | 0 | "+b0);
//        BinaryNumber b1 = new BinaryNumber('1');
//        System.out.println("1 | 01 | "+b1);
//        BinaryNumber b2 = new BinaryNumber('2');
//        System.out.println("2 | 010 | "+b2);
//        BinaryNumber b3 = new BinaryNumber('3');
//        System.out.println("3 | 011 | "+b3);
//        BinaryNumber b4 = new BinaryNumber('4');
//        System.out.println("4 | 0100 | "+b4);
//        BinaryNumber b5 = new BinaryNumber('5');
//        System.out.println("5 | 0101 | "+b5);
//        BinaryNumber b6 = new BinaryNumber('6');
//        System.out.println("6 | 0110 | "+b6);
//        BinaryNumber b7 = new BinaryNumber('7');
//        System.out.println("7 | 0111 | "+b7);
//        BinaryNumber b8 = new BinaryNumber('8');
//        System.out.println("8 | 01000 | "+b8);
//        BinaryNumber b9 = new BinaryNumber('9');
//        System.out.println("9 | 01001 | "+b9);
//        
//        System.out.println("task 3.5");
//        BinaryNumber m1 = b1.negate();
//        System.out.println("1 is = " + b1 + "| -1 is = 11| " + m1);
//        BinaryNumber m2 = b2.negate();
//        System.out.println("2 is = " +b2 + "| -2 is = 110| " + m2);
//        BinaryNumber m3 = b3.negate();
//        System.out.println("3 is = " +b3 + "| -3 is = 101| " + m3);
//        BinaryNumber m4 = b4.negate();
//        System.out.println("4 is = " +b4 + "| -4 is = 1100| " + m4);
//        BinaryNumber m5 = b5.negate();
//        System.out.println("5 is = " +b5 + "| -5 is = 1011| " + m5);
//        BinaryNumber m6 = b6.negate();
//        System.out.println("6 is = " +b6 + "| -6 is = 1010| " + m6);
//        BinaryNumber m7 = b7.negate();
//        System.out.println("7 is = " +b7 + "| -7 is = 1001| " + m7);
//        BinaryNumber m8 = b8.negate();
//        System.out.println("8 is = " +b8 + "| -8 is = 11000| " + m8);
//        BinaryNumber m9 = b9.negate();
//        System.out.println("9 is = " +b9 + "| -9 is = 10111| " + m9);
//        System.out.println("--------------------------------------");
//        
//        BinaryNumber m19 = new BinaryNumber("-19");
//        BinaryNumber m25 = new BinaryNumber("-25");
//        System.out.println("-19 + (-25)=" + m19.add(m25) + "|" + m19.add(m25).toInt());
//        BinaryNumber b13 = b9.add(b9);
//        b13 = b13.add(b13);
//        BinaryNumber m13 = b13.negate();
//        System.out.println("36 = 0100100 | " +b13);
//        BinaryNumber b14 = m9.add(m9);
//        b14 = b14.add(b14);
//        System.out.println("36 = 1011110 | " +b14);
		
//		BitList b1 = new BitList(); //    <> 
//		b1.addFirst(Bit.ZERO);          //   <0>    
//		b1.addFirst(Bit.ZERO);          //  <00> 
//		b1.addFirst(Bit.ONE);           // <001>  
//		System.out.println(b1); // prints <001>
		
		
//		BitList b1 = new BitList();   //        <> 
//		b1.addFirst(Bit.ZERO);            //       <0> 
//		b1.addFirst(Bit.ZERO);            //      <00> 
//		b1.addFirst(Bit.ONE);             //     <001> 
//		System.out.println(b1.getNumberOfOnes());
//		BitList b2 = new BitList(b1); //     <001> 
//		System.out.println(b2.getNumberOfOnes());
//		System.out.println(b2);       //    prints <001> 
//		b2.addFirst(Bit.ONE);             //    <0011>
//		b2.addFirst(Bit.ONE);             //   <00111> 
//		b2.addFirst(Bit.ONE);             //  <001111> 
//		System.out.println(b1);       // prints <001> 
//		System.out.println(b2);       // prints <001111>
//		System.out.println(b2.getNumberOfOnes());
		
//		BitList b1 = new BitList();        //     <> 
//		System.out.println(b1.isNumber()); // prints false 
//		b1.addFirst(Bit.ONE);                  //    <1> 
//		b1.addFirst(Bit.ZERO);                 //   <10> 
//		b1.addFirst(Bit.ZERO);                 //  <100> 
//		System.out.println(b1.isNumber()); // prints false 
//		b1.addLast(Bit.ONE);                   // <1100> 
//		System.out.println(b1.isNumber()); // prints true 
//		b1.addLast(Bit.ONE);                   // <11100> 
//		System.out.println(b1.isNumber()); // prints true 
//		
//		
//		BitList b2 = new BitList();
//		b2.addFirst(Bit.ZERO); 
//		b2.addFirst(Bit.ONE);
//		b2.addFirst(Bit.ZERO);
//		b2.addFirst(Bit.ZERO);
//		System.out.println(b2);
//		System.out.println(b2.isNumber());
//		
//		BitList b3 = new BitList();
//		b3.addFirst(Bit.ZERO);
//		b3.addFirst(Bit.ONE);
//		b3.addFirst(Bit.ZERO);
//		b3.addFirst(Bit.ZERO);
//		b3.addFirst(Bit.ONE);
//		
//		System.out.println(b3);
//		System.out.println(b3.isNumber()); 
//		
//		BitList b4 = new BitList();
//		b4.addFirst(Bit.ONE);
//		b4.addFirst(Bit.ONE);
//		b4.addFirst(Bit.ZERO); 
//		b4.addFirst(Bit.ZERO); 
//		b4.addFirst(Bit.ZERO); 
//		
//		System.out.println(b4);
//		System.out.println(b4.isNumber());
//		
//		BitList b5 = new BitList();
//		b5.addFirst(Bit.ONE);
//		b5.addFirst(Bit.ZERO);
//		b5.addFirst(Bit.ZERO);
//		b5.addFirst(Bit.ONE);
//		b5.addFirst(Bit.ZERO);
//		
//		System.out.println(b5);
//		System.out.println(b5.isNumber());
//		
//		
//		BitList b6 = new BitList();
//		b6.addFirst(Bit.ONE);
//		b6.addFirst(Bit.ZERO);
//		b6.addFirst(Bit.ZERO);
//		b6.addFirst(Bit.ZERO);
//		
//
//
//		System.out.println(b6);
//		System.out.println(b6.isNumber());
//		
//		
//		BitList b7 = new BitList();
//
//		b7.addFirst(Bit.ONE);
//
//
//		System.out.println(b7);
//		System.out.println(b7.isNumber());
		
		/////////////////////////////////////////////////////////////////////
		
//		BitList b1 = new BitList();
//		b1.addFirst(Bit.ZERO);
//		System.out.println(b1);
//		System.out.println(b1.isReduced());
//		
//		BitList b2 = new BitList();
//		b2.addFirst(Bit.ZERO);
//		b2.addFirst(Bit.ONE);
//		System.out.println(b2);
//		System.out.println(b2.isReduced());
//		
//		BitList b3 = new BitList();
//		b3.addFirst(Bit.ONE);
//		b3.addFirst(Bit.ONE);
//		System.out.println(b3);
//		System.out.println(b3.isReduced());
//		
//		
//		BitList b4 = new BitList();
//		b4.addFirst(Bit.ZERO);
//		b4.addFirst(Bit.ONE);
//		b4.addFirst(Bit.ZERO);
//		b4.addFirst(Bit.ZERO);
//		System.out.println(b4);
//		System.out.println(b4.isReduced());
//		
//		BitList b5 = new BitList();
//		b5.addFirst(Bit.ZERO);
//		b5.addFirst(Bit.ONE);
//		b5.addFirst(Bit.ZERO);
//		b5.addFirst(Bit.ONE);
//		b5.addFirst(Bit.ONE);
//		System.out.println(b5);
//		System.out.println(b5.isReduced());
//		
//		BitList b6 = new BitList();
//		b6.addFirst(Bit.ONE);
//		b6.addFirst(Bit.ZERO);
//		b6.addFirst(Bit.ONE);
//		System.out.println(b6);
//		System.out.println(b6.isReduced());
//		
//		BitList b7 = new BitList();
//		b7.addFirst(Bit.ONE);
//		b7.addFirst(Bit.ZERO);
//		b7.addFirst(Bit.ONE);
//		b7.addFirst(Bit.ZERO);
//		b7.addFirst(Bit.ONE);
//		System.out.println(b7);
//		System.out.println(b7.isReduced());
//		
//		BitList b8 = new BitList();
//		b8.addFirst(Bit.ONE);
//		b8.addFirst(Bit.ONE);
//		b8.addFirst(Bit.ZERO);
//		System.out.println(b8);
//		System.out.println(b8.isReduced());
//		
//		BitList b9 = new BitList();
//		b9.addFirst(Bit.ONE);
//		b9.addFirst(Bit.ONE);
//		b9.addFirst(Bit.ZERO);
//		b9.addFirst(Bit.ZERO);
//		System.out.println(b9);
//		System.out.println(b9.isReduced());
//		
//		BitList b10 = new BitList();
//		b10.addFirst(Bit.ONE);
//		b10.addFirst(Bit.ONE);
//		b10.addFirst(Bit.ZERO);
//		b10.addFirst(Bit.ZERO);
//		b10.addFirst(Bit.ZERO);
//		System.out.println(b10);
//		System.out.println(b10.isReduced());
//		
//		
//		BitList b11 = new BitList();
//		b11.addFirst(Bit.ZERO);
//		b11.addFirst(Bit.ZERO);
//		b11.addFirst(Bit.ZERO);
//		b11.addFirst(Bit.ZERO);
//		b11.addFirst(Bit.ZERO);
//		System.out.println(b11);
//		System.out.println(b11.isReduced());
//		
//		BitList b12 = new BitList();
//		b12.addFirst(Bit.ONE);
//		b12.addFirst(Bit.ONE);
//		b12.addFirst(Bit.ONE);
//		b12.addFirst(Bit.ZERO);
//		b12.addFirst(Bit.ONE);
//		System.out.println(b12);
//		System.out.println(b12.isReduced());
//		
//		BitList b13 = new BitList();
//
//		b13.addFirst(Bit.ONE);
//		b13.addFirst(Bit.ZERO);
//		b13.addFirst(Bit.ONE);
//
//		System.out.println(b13);
//		System.out.println(b13.isReduced());
//		
//		BitList b14 = new BitList();
//		b14.addFirst(Bit.ONE);
//		b14.addFirst(Bit.ONE);
//		b14.addFirst(Bit.ONE);
//		b14.addFirst(Bit.ONE);
//		b14.addFirst(Bit.ONE);
//		b14.addFirst(Bit.ZERO);
//		b14.addFirst(Bit.ZERO);
//
//		System.out.println(b14);
//		System.out.println(b14.isReduced());
		
		
//		BinaryNumber bn5 = new BinaryNumber('5');  // 0101 (5) 
//		BinaryNumber bn5a = new BinaryNumber('5'); // 0101 (5) 
//		BinaryNumber bn6 = new BinaryNumber('6');  // 0110 (6)  
//		System.out.println(bn5.equals(bn5a)); // prints true 
//		System.out.println(bn5.equals(bn6));  // prints false
		
		
		
		//BinaryNumber bn1 = new BinaryNumber('1'); //   01  (1) 
		//BinaryNumber bn6  = bn1.add(bn5);         // 0110  (6) 
		
//		BinaryNumber bn5 = new BinaryNumber('3'); // 0101 (5) 
//		BinaryNumber bnM5 = bn5.negate();         // 1011 (-5) 
//		System.out.println(bnM5);      //prints 1011 
		
		//BinaryNumber bn3  = new BinaryNumber('0'); //   011 (3) 
		//BinaryNumber bn5  = new BinaryNumber('9'); //  0101 (5) 
		//BinaryNumber sum = bn3.add(bn5);
		
		//BinaryNumber bn8  = new BinaryNumber('8'); // 01000 (8) 
		//System.out.println(bn3.add(bn5)); // prints 01000 which is the minimal binary representation // of 8.
		
		
		//3.4
//		BinaryNumber bn5 = new BinaryNumber('5'); // 0101 (5) 
//		System.out.println(bn5);
//		BinaryNumber bnM5 = bn5.negate();         // 1011 (-5) 
//		System.out.println(bnM5);      //prints 1011 
//		BinaryNumber bn1 = new BinaryNumber('1'); //   01  (1) 
//		BinaryNumber bn6  = bn1.add(bn5);         // 0110  (6) 
//		System.out.println(bn5.add(bnM5));         // prints 0     
//		System.out.println(bn6.add(bnM5));         // prints 01 
//		
//		BinaryNumber bn9 = new BinaryNumber('8'); // 01001 (9)
//		System.out.println(bn9);
//		System.out.println(bn9.add(bn9));
		
		
		//3.5
//		BinaryNumber bn3  = new BinaryNumber('3'); //   011 (3) 
//		System.out.println(bn3);
//		BinaryNumber bn3n = bn3.negate(); // (-3) 
//		System.out.println(bn3n);
//		BinaryNumber bn5  = new BinaryNumber('5'); //  0101 (5) 
//		System.out.println(bn5);
//		BinaryNumber bn5n = bn5.negate(); // (-5) 
//		System.out.println(bn5n);
//		System.out.println("so far is good");
//		BinaryNumber bn8  = new BinaryNumber('8'); // 01000 (8)
//		System.out.println(bn8);
//		BinaryNumber bn8n = bn8.negate();
//		System.out.println(bn8n);


		
		
		// 3.6 
//		BinaryNumber bn5  = new BinaryNumber ('5'); // 0101    (5) 
//		BinaryNumber bn9  = new BinaryNumber ('9'); // 01001    (9) 
//		System.out.println(bn5.subtract(bn9));
//		System.out.println(bn9.subtract(bn5));
//		System.out.println(bn5.negate().subtract(bn9));
		
		//3.7
		
//		BinaryNumber bn5 = new BinaryNumber('5');     // 0101    (5) 
//		System.out.println(bn5);
//		BinaryNumber bn2 = new BinaryNumber('2'); //  010    (2) 
//		System.out.println(bn2);
//		BinaryNumber bn3 = bn5.subtract(bn2);  //  011    (3)  
//		System.out.println(bn3);
//		System.out.println(bn3.signum());    // prints 1 
//		BinaryNumber bnM2 = bn3.subtract(bn5); //  110    (-2) 
//		System.out.println(bnM2.signum());    //prints -1 
//		BinaryNumber bn0 = new BinaryNumber('5');
//		bn0 = bn0.negate();
//		System.out.println(bn0);
//		System.out.println(bn0.signum());
		
		//3.8
		
//		BinaryNumber bn5 = new BinaryNumber('5'); // 0101 (5) 
//		BinaryNumber bn4 = new BinaryNumber('4'); // 0100 (4) 
//		BinaryNumber bn4a = new BinaryNumber('4'); // 0100 (4)  
//		System.out.println(bn5.compareTo(bn4)); // prints 1 
//		System.out.println(bn4.compareTo(bn4a)); // prints 0 
//		System.out.println(bn4.compareTo(bn5)); // print -1 
		
		
		//3.9
		
//		BinaryNumber bn5 = new BinaryNumber('1'); // 0101 (5) 
//		BinaryNumber bn4 = new BinaryNumber('1'); // 0100 (4)
//		System.out.println(bn5.add(bn4).toInt());      // prints 9 
//		System.out.println(bn4.subtract(bn5).toInt()); // prints -1 
//		BinaryNumber bn12 = new BinaryNumber("12");
//		System.out.println(bn12);
		

//		System.out.println("0 | " + b0.toInt());
//		System.out.println("-1 | " + m1.toInt());
//		//System.out.println("1*0 =" +b1.multiply(b0).toInt());
//        System.out.println("-9*7 =" +m9.multiply(b7).toInt());
//        System.out.println("36*-7 = -252 |" +b13.multiply(m7).toInt());
//        //System.out.println("0*7 =" +b0.multiply(b7).toInt());
//        System.out.println("7*0 =" +b7.multiply(b0).toInt());
//      	//System.out.println("0*-3 =" +b0.multiply(m3).toInt());
//      	//System.out.println("1*7 =" +b1.multiply(b7).toInt());
//      	System.out.println("1*-7 =" +b1.multiply(m7).toInt());
        
//        System.out.println("9/3 = "  + b9.divide(b3).toInt());
//        System.out.println("36/3 = " + b13.divide(b3).toInt());
        //System.out.println("-8/0 = "  + m8.divide(b0).toInt());
        //String bigi = ""+ Integer.MAX_VALUE;
        //BinaryNumber test = new BinaryNumber(bigi);
        //System.out.println(Integer.MAX_VALUE);
        //System.out.println(test);
        //System.out.println(test.toInt());

		
		//System.out.println(bn5.multiplyPositive(bn4));
		
//		String str = "-98";
//		int value=0;
//		if(str.charAt(0) =='-') {
//			String myStr =str.substring(1);
//			for(int i=myStr.length()-1,ten =1;i>=0;i--,ten=ten*10) {
//				value= value +(myStr.charAt(i)-'0')*ten;
//			}
//		}else {
//			for(int i=str.length()-1,ten =1;i>=0;i--,ten=ten*10) {
//				value= value +(str.charAt(i)-'0')*ten;
//			}
//		}
//		
//		//System.out.println(value);
//		//System.out.println(1/2);
//		
//		
//		BinaryNumber bn10  = new BinaryNumber("90158");   // 011001 (25) 
//		BinaryNumber bnM10 = new BinaryNumber("-12");  // 100111 (-25) 
//		System.out.println(bn10);  // prints 25 
		//System.out.println(bnM10.toInt()); // prints -25 
		
//		BinaryNumber two = new BinaryNumber('2');
//    	BinaryNumber five = new BinaryNumber('5');
//    	BinaryNumber ten = two.multiply(five);
//    	BinaryNumber one = new BinaryNumber('1');
//    	BinaryNumber ans =  new BinaryNumber('0');
//		
//    	System.out.println(one.multiply(ten));
//		BinaryNumber test = new BinaryNumber('1');
//		BinaryNumber ten = new BinaryNumber('9');
//		//BinaryNumber ans;
//		
//		while(true) {
//			test= test.multiply(ten);
//			System.out.println(test.toInt());
//		}
		
//		BinaryNumber b1 = new BinaryNumber('9');
//		BinaryNumber b2 = new BinaryNumber('8');
//		//BinaryNumber b3 = b1.multiply(b2);
//		System.out.println(b2.multiply(b1).toInt());
		
		//3.11
		
//		BinaryNumber bn9   = new BinaryNumber('9'); // 01001 (9) 
//		BinaryNumber bnM9  = bn9.negate();          // 10111 (-9) 
//		BinaryNumber bn3   = new BinaryNumber('3'); //   011 (3)
//		BinaryNumber bn2   = new BinaryNumber('2'); //   010 (2) 
//		BinaryNumber bnM3  = bnM9.divide(bn3);      //   101 (-3) 
//		BinaryNumber bnM4  = bnM9.divide(bn2);      //  1100 (-4) 
//		System.out.println(bnM3.toInt());           // prints -3 
		
		
//		
//		
//		System.out.println("----------------------------");
//        System.out.println("Task 3.10");
//        System.out.println("4*5 =" + b4.multiply(b5).toInt());
//        System.out.println("7*7 =" +b7.multiply(b7).toInt());
//        System.out.println("8*8 =" +b8.multiply(b8).toInt());
//        System.out.println("1*0 =" +b1.multiply(b0).toInt());
//        System.out.println("-9*7 =" +m9.multiply(b7).toInt());
//        System.out.println("-4*-4 =" +m4.multiply(m4).toInt());
//        System.out.println("36*-7 = -252 |" +b13.multiply(m7).toInt());
//        System.out.println("-1*-1 =" +m1.multiply(m1).toInt());
//        System.out.println("0*7 =" +b0.multiply(b7).toInt());
//        System.out.println("7*0 =" +b7.multiply(b0).toInt());
//        System.out.println("0*-3 =" +b0.multiply(m3).toInt());
//        System.out.println("-2*0 =" +m2.multiply(b0).toInt());
// //       System.out.println("1*7 =" +b1.multiply(b7).toInt());
//        System.out.println("4*1 =" +b4.multiply(b1).toInt());
//        System.out.println("1*-7 =" +b1.multiply(m7).toInt());
//        System.out.println("-4*1 =" +m4.multiply(b1).toInt());
		
        
//        BinaryNumber c1 = new BinaryNumber("-13");
//        BinaryNumber c2 = new BinaryNumber("-2");
//        //System.out.println(c1.multiply(c2).toInt());
//        System.out.println(c1.multiply(c2).toInt());
        
//        BinaryNumber a1 = new BinaryNumber('9');
//        BinaryNumber a2 = new BinaryNumber('2');
//        //System.out.println(a1.multiply(a2).toInt());
//        
//        BinaryNumber d1 = new BinaryNumber("-89535153");
//        System.out.println(d1.toInt());
        //BinaryNumber four = new BinaryNumber('4');
        //BinaryNumber two = new BinaryNumber('2');
        //System.out.println(four.equals(two.multiply(two)));
		
//		BinaryNumber bn9   = new BinaryNumber("0"); // 01001 
//		System.out.println(bn9.toIntString()); // prints 9 
		//BinaryNumber bnM9  = bn9.negate();          // 10111 (-9) 
		//System.out.println(bnM9.toIntString()); // prints -9 
		
		BinaryNumber a1 = new BinaryNumber("5");
		BinaryNumber a2 = new BinaryNumber("5");
		//System.out.println(BinaryNumber.reminder(a1, a2));
		System.out.println(a1.multiply(a2.negate()).toInt());
		//System.out.println(a1.subtract(a2).toInt());

	
//		one=one.multiply(ten);
//		ans=ans.add(new BinaryNumber(str.charAt(0)).multiply(one));
		
	}
	


}
