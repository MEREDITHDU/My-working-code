package testLambda;

public class TestLambda{
	//static Inner class
//	static class Like implements ILike{
//
//		@Override
//		public void Like(int a) {
//			System.out.println("I like lambda-->"+a);
//		}
		
	public static void main(String[] args) {
		//�ֲ��ڲ���
//		class Like implements ILike{
//
//			@Override
//			public void Like(int a) {
//				System.out.println("I like lambda-->"+a);
//			}
//		}	
		ILike like= (int a)->{
			System.out.println("I like lambda-->"+a);
		};
//	ILike like= new ILike(){
//      �����ڲ���Anonymous Classes
//		@Override
//		public void Like(int a) {
//			System.out.println("I like lambda-->"+a);
//			}
//		};
//	like.Like(2);
	}
}
	interface ILike{
		void Like(int a);
	}

//class Like implements ILike{
//
//	@Override
//	public void Like(int a) {
//		System.out.println("I like lambda-->"+a);
//	}
//
//}
