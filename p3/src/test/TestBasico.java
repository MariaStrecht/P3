package test;

public class TestBasico {
	 public static void main(String[] args) {
	        CountingBloomFilter cb = new CountingBloomFilter(100,8);
	        cb.init();
	        cb.insert("cona");
	        System.out.println(cb.check("penis"));
	    }
}