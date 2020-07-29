import java.math.BigInteger;
import java.security.SecureRandom;

public class Test {
	public static void main(String[] args) {
		//HugeInteger num1 = new HugeInteger("");
		//HugeInteger leadingzero=new HugeInteger("-00000000000000000123343235324534534254");
		//HugeInteger num2= new HugeInteger("123439028409$42903252412.");
		HugeInteger num3=new HugeInteger("-21324793284972398749218748971329487912847981732498723947891729841378391290312342412412");
		HugeInteger almostsamenum3=new HugeInteger("-21324793284972398749218748971329487912847981732498723947891729841378391290312342412411");
		HugeInteger num4= new HugeInteger("-21232323423532452349554059348098204398092831092438190");
		HugeInteger num5= new HugeInteger("93102138128937612736912763");
		HugeInteger num6=new HugeInteger("4982472893479823749827917498371498174298739182749128749817293871");
		HugeInteger num7=new HugeInteger(34);
		HugeInteger num8=new HugeInteger(4);
		
		
			HugeInteger num9=num5.add(num6);
			HugeInteger num10=num5.add(num3);
			HugeInteger num11= num3.add(num4);
			HugeInteger num12=num6.subtract(num5);
			HugeInteger num13=num6.subtract(num4);
			HugeInteger num14=num4.subtract(num6);
			HugeInteger num15=num4.subtract(num3);
			//HugeInteger num16=num1.multiply(num5);
			HugeInteger num17= num5.multiply(num6);
			HugeInteger num18=num4.multiply(num5);
			HugeInteger num19=num4.multiply(num3);
			int num20=num6.compareTo(num3);
			int num21=num3.compareTo(num4);
			int num22=num6.compareTo(num5);
			int num23=num6.compareTo(num6);
			int num24=almostsamenum3.compareTo(num3);
			
			/*HugeInteger huge1,huge2,huge3;
			int compare;
			long startTime,endTime;
			double runTime=0.0;
			int MAXNUMINTS=100;
			int MAXRUN=500;
			for(int numInts=0;numInts<MAXNUMINTS;numInts++) {
				huge1=new HugeInteger(10000);  //n is number of digits
				huge2=new HugeInteger(10000);
				startTime=System.currentTimeMillis();
				for(int numRun=0;numRun<MAXRUN;numRun++) {
					compare=huge1.compareTo(huge2);
				}
				endTime=System.currentTimeMillis();
				runTime+=(double)(endTime- startTime)/((double) MAXRUN);
			}
			runTime=runTime/((double) MAXNUMINTS);*/
			
			BigInteger huge1,huge2,huge3;
			long startTime,endTime;
			int compare;
			double runTime=0.0;
			int MAXNUMINTS=100;
			int MAXRUN=1000;
			for(int numInts=0;numInts<MAXNUMINTS;numInts++) {
				huge1=new BigInteger(500,new SecureRandom());  //n is number of digits
				huge2=new BigInteger(500,new SecureRandom());
				startTime=System.currentTimeMillis();
				for(int numRun=0;numRun<MAXRUN;numRun++) {
					compare=huge1.compareTo(huge2);
				}
				endTime=System.currentTimeMillis();
				runTime+=(double)(endTime- startTime)/((double) MAXRUN);
			}
			runTime=runTime/((double) MAXNUMINTS);
		
		
		
		System.out.println(runTime);
		
		/*System.out.println(num9.toString());
		System.out.println(num10.toString());
		System.out.println(num11.toString());
		System.out.println(num12.toString());
		System.out.println(num13.toString());
		System.out.println(num14.toString());
		System.out.println(num15.toString());
		System.out.println(num16.toString());
		System.out.println(num17.toString());
		System.out.println(num18.toString());
		System.out.println(num19.toString());
		System.out.println(num20);
		System.out.println(num21);
		System.out.println(num22);
		System.out.println(num23);
		System.out.println(num24);*/
		//System.out.println(num1.toString());
		
		

}
}
