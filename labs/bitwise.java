class bitwise{
	public static void main(String[] args){
		int a = 0xACCF;
		int b = 0xA8A6;
		System.out.println("AND: "+ String.format("0x%04X",(a&b)));
		System.out.println("OR: "+ String.format("0x%04X",(a|b)));
		System.out.println("XOR: "+ String.format("0x%04X",(a^b)));
		System.out.println("RIGHT SHIFT: "+ String.format("0x%04X",(a>>4)));
		System.out.println("LEFT SHIFT: "+ String.format("0x%04X",(a<<3)));
		System.out.println("UNSIGNED RIGHT SHIFT: "+ String.format("0x%04X",(a>>>3)));
	}
}