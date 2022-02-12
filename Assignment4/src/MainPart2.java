public class MainPart2 {
    public static void main(String[] args) {
        System.out.println("task 3.1 + 3.2");
        BinaryNumber b0 = new BinaryNumber('0');
        System.out.println("0 | 0 | "+b0);
        BinaryNumber b1 = new BinaryNumber('1');
        System.out.println("1 | 01 | "+b1);
        BinaryNumber b2 = new BinaryNumber('2');
        System.out.println("2 | 010 | "+b2);
        BinaryNumber b3 = new BinaryNumber('3');
        System.out.println("3 | 011 | "+b3);
        BinaryNumber b4 = new BinaryNumber('4');
        System.out.println("4 | 0100 | "+b4);
        BinaryNumber b5 = new BinaryNumber('5');
        System.out.println("5 | 0101 | "+b5);
        BinaryNumber b6 = new BinaryNumber('6');
        System.out.println("6 | 0110 | "+b6);
        BinaryNumber b7 = new BinaryNumber('7');
        System.out.println("7 | 0111 | "+b7);
        BinaryNumber b8 = new BinaryNumber('8');
        System.out.println("8 | 01000 | "+b8);
        BinaryNumber b9 = new BinaryNumber('9');
        System.out.println("9 | 01001 | "+b9);
        //ERROR after this point
        //BinaryNumber b10 = new BinaryNumber('x');
        //BinaryNumber b11 = new BinaryNumber('j');
        //BinaryNumber b12 = new BinaryNumber('-');
        //-----------------------------------------------
        System.out.println("Task 3.3");
        System.out.println("False | " + b0.equals(b9));
        System.out.println("True  | " + b7.equals(b7));
        System.out.println("False | " + b2.equals(b3));
        System.out.println("False | " + b4.equals(b5));
        System.out.println("True  | " + b6.equals(b6));
        System.out.println("False | " + b7.equals(b3));
        System.out.println("--------------------------");

        //-----------------------------------------------

        System.out.println("task 3.5");
        BinaryNumber m1 = b1.negate();
        System.out.println("1 is = " + b1 + "| -1 is = 11| " + m1);
        BinaryNumber m2 = b2.negate();
        System.out.println("2 is = " +b2 + "| -2 is = 110| " + m2);
        BinaryNumber m3 = b3.negate();
        System.out.println("3 is = " +b3 + "| -3 is = 101| " + m3);
        BinaryNumber m4 = b4.negate();
        System.out.println("4 is = " +b4 + "| -4 is = 1100| " + m4);
        BinaryNumber m5 = b5.negate();
        System.out.println("5 is = " +b5 + "| -5 is = 1011| " + m5);
        BinaryNumber m6 = b6.negate();
        System.out.println("6 is = " +b6 + "| -6 is = 1010| " + m6);
        BinaryNumber m7 = b7.negate();
        System.out.println("7 is = " +b7 + "| -7 is = 1001| " + m7);
        BinaryNumber m8 = b8.negate();
        System.out.println("8 is = " +b8 + "| -8 is = 11000| " + m8);
        BinaryNumber m9 = b9.negate();
        System.out.println("9 is = " +b9 + "| -9 is = 10111| " + m9);
        System.out.println("--------------------------------------");

//        //-------------------------------------------------
//
        System.out.println("Task 3.4 + 3.5");
        System.out.println("-5+4= " + m5.add(b4));
        System.out.println("-9-5=" + m9.add(m5));
        System.out.println("4+3=" + b4.add(b3));
        System.out.println("5-7=" + b5.add(m7));
        System.out.println("-4+6=" + m4.add(b6));
        System.out.println("9+0=" + b9.add(b0));
        System.out.println("0+0=" + b0.add(b0));
        System.out.println("1-1=" + b1.add(m1));
        System.out.println("1+1=" + b1.add(b1));
        System.out.println("9-9=" + b9.add(m9));
        BinaryNumber m19 = new BinaryNumber("-19");
        BinaryNumber m25 = new BinaryNumber("-25");
        System.out.println("-19 + (-25)=" + m19.add(m25) + "|" + m19.add(m25).toInt());
        BinaryNumber b13 = b9.add(b9);
        b13 = b13.add(b13);
        BinaryNumber m13 = b13.negate();
        //System.out.println("36 = 0100100 | " +b13);
        BinaryNumber b14 = m9.add(m9);
        b14 = b14.add(b14);
        //System.out.println("36 = 1011110 | " +b14);
        //0100100 - 1011110

//        //----------------------------------------------------------
//        System.out.println("----------------------------");
//        System.out.println("Task 3.6");
//        System.out.println("subtract 2,-5 = 0111 | " + b2.subtract(m5));
//        System.out.println("subtract 2,-9 = 01011 | " + b2.subtract(m9));
//        System.out.println("subtract -2,7 = 10111 | " + m2.subtract(b7));
//        System.out.println("subtract 0,-5 = 0101 | " + b0.subtract(m5));
//        System.out.println("subtract 1,-1 = 010 | " + b1.subtract(m1));
//        System.out.println("subtract 2,0 = 010 | " + b2.subtract(b0));
//        System.out.println("subtract 0,5 =1011 | " + b0.subtract(b5));
//        System.out.println("subtract -2,0 = 110 | " + m2.subtract(b0));
////
////        //----------------------------------------------------------------
//        System.out.println("----------------------------");
//        System.out.println("Task 3.7");
//        System.out.println("1  |" + b1.signum());
//        System.out.println("1  |" + b9.signum());
//        System.out.println("1  |" + b13.signum());
//        System.out.println("0  |" + b0.signum());
//        System.out.println("-1 |" + m1.signum());
//        System.out.println("-1 |" + m7.signum());
//        System.out.println("-1 |" + m9.signum());
////        //-----------------------------------------------------------------
////
//        System.out.println("----------------------------");
//        System.out.println("Task 3.8");
//        System.out.println("-1| " + m1.compareTo(b1));
//        System.out.println("1 | " + b1.compareTo(m1));
//        System.out.println("1 | " + b2.compareTo(b1));
//        System.out.println("-1| " + b1.compareTo(b2));
//        System.out.println("1 | " + m1.compareTo(m2));
//        System.out.println("-1| " + m2.compareTo(m1));
//        System.out.println("0 | " + m6.compareTo(m6));
//        System.out.println("0 | " + b9.compareTo(b9));
////
//        //---------------------------------------------------------
//        System.out.println("----------------------------");
//        System.out.println("Task 3.9");
//        //System.out.println("0 | " + b0.toInt());
//        System.out.println("-7 | " + m7.toInt());
//        System.out.println("9 | " + b9.toInt());
//        System.out.println("36 | " + b13.toInt());
////        System.out.println("-1 | " + m1.toInt());
//       System.out.println("-9 | " + m9.toInt());
////       System.out.println("0 | " + b0.toInt());
////        System.out.println("0 | " + b0.toInt());
////        System.out.println("0 | " + b0.toInt());
////        System.out.println("0 | " + b0.toInt());
//        System.out.println("4-5 =  | " + b4.subtract(b5).toInt());
//        System.out.println("5-4 =  | " + b5.subtract(b4).toInt());
//        System.out.println("-36 | " + b14.toInt());
//
////        //---------------------------------------------------------
//        System.out.println("----------------------------");
//        System.out.println("Task 3.10");
//        System.out.println("4*5 =" + b4.multiply(b5).toInt());
//        System.out.println("7*7 =" +b7.multiply(b7).toInt());
//        System.out.println("8*8 =" +b8.multiply(b8).toInt());
////        System.out.println("1*0 =" +b1.multiply(b0).toInt());
//        System.out.println("-9*7 =" +m9.multiply(b7).toInt());
//        System.out.println("-4*-4 =" +m4.multiply(m4).toInt());
////        System.out.println("36*-7 = -252 |" +b13.multiply(m7).toInt());
//        System.out.println("-1*-1 =" +m1.multiply(m1).toInt());
////        System.out.println("0*7 =" +b0.multiply(b7).toInt());
////        System.out.println("7*0 =" +b7.multiply(b0).toInt());
////        System.out.println("0*-3 =" +b0.multiply(m3).toInt()); 
//        System.out.println("-2*0 =" +m2.multiply(b0).toInt());
////        System.out.println("1*7 =" +b1.multiply(b7).toInt());
//        System.out.println("4*1 =" +b4.multiply(b1).toInt());
////        System.out.println("1*-7 =" +b1.multiply(m7).toInt());
//        System.out.println("-4*1 =" +m4.multiply(b1).toInt());
////
////        //---------------------------------------------------------
//        System.out.println("----------------------------");
//        System.out.println("Task 3.11");
//        System.out.println("8/3 = "  + b8.divide(b3).toInt());
////        System.out.println("9/3 = "  + b9.divide(b3).toInt());
//        System.out.println("8/2 = "  + b8.divide(b2).toInt());
//        System.out.println("7/7 = "  + b7.divide(b7).toInt());
////        System.out.println("36/3 = " + b13.divide(b3).toInt());
//        System.out.println("-36/3 = " + m13.divide(b3).toInt());
//        System.out.println("-8/2 = "  + m8.divide(b2).toInt());
//        System.out.println("8/-2 = "  + b8.divide(m2).toInt());
//        System.out.println("-8/-2 = "  + m8.divide(m2).toInt());
//        System.out.println("0/-2 = "  + b0.divide(m2).toInt());
        //error after this point
        //System.out.println("-8/0 = "  + m8.divide(b0).toInt());
//
//        //---------------------------------------------------------
        System.out.println("----------------------------");
        System.out.println("Task 3.12");
        BinaryNumber s1 = new BinaryNumber("16");
        System.out.println("16 | 010000 | " + s1);

        BinaryNumber s2 = new BinaryNumber("117");
        System.out.println("117 | 01110101 | " + s2);

        BinaryNumber s3 = new BinaryNumber("-117");
        System.out.println("-117 | 10001011 | " + s3);

        BinaryNumber s4 = new BinaryNumber("444");
        System.out.println("444 | 0110111100 | " + s4);

        BinaryNumber s5 = new BinaryNumber("1000");
        System.out.println("1000 | 01111101000 | " + s5);

        BinaryNumber s6 = new BinaryNumber("-212");
        System.out.println("-212 | 100101110 | " + s6);
        //212 - 011010100 | -212 100101110

        BinaryNumber s7 = new BinaryNumber("658462");
        System.out.println("658462 | 010100000110000011110 | " + s7);

        BinaryNumber s8 = new BinaryNumber("-0");
        System.out.println("0 | 0 | " + s8);

        BinaryNumber s9 = new BinaryNumber("-7777");
        System.out.println("-117 | 10000110011111 | " + s9);
        // 7777 - 1111001100001 | -7777 - 0000110011111

































    }
}
