/*
    一、单例设计模式：饿汉式
 */
class Singleton {

	// 1.类一加载就创建对象，因为第3步使用static修饰，里边不能使用非静态成员，所以，用static修饰，又因为，只有一个对象，所以使用了final修饰
	private static final Singleton singleton = new Singleton();

	// 2.私有化构造器，使外部不能创建对象
	private Singleton() {
	}

	// 3.提供公共方法使外部能访问该对象，因为外部不能创建对象，所以无法调用此方法，只能通过类名.的方式去调用，故使用static修饰
	public static Singleton getInstance() {
		return singleton;
	}

}

/*
 * 二、单例设计模式：懒汉式（有线程安全问题）
 */
class Singleton1 {
	/**
	 * 1. 这个有线程安全问题
	 */
//    private static Singleton1 singleton1 = null;
//    public static Singleton1 getInstance(){
//        if(singleton1 == null){
//            singleton1 = new Singleton1();
//        }
//        return singleton1;
//    }
	/**
	 * 2. 这个效率太低了，假设有100个线程要创建实例 
	 * 那么，当前几个线程就已经创建了实例后，后边的就不需要去抢锁，然后，去判断实例是否存在，接着创建实例
	 */
//	private static Singleton1 singleton1 = null;
//
//	public static Singleton1 getInstance() {
//		synchronized (Singleton1.class) {
//			if (singleton1 == null) {
//				singleton1 = new Singleton1();
//			}
//		}
//		return singleton1;
//	}
	/**
	 * 3. 这个效率还可以，因为，if的效率要高于抢锁，判断锁的过程
	 */
	private static Singleton1 singleton1 = null;
	public static Singleton1 getInstance() {
		if(singleton1 == null) { //当已经有实例了后，那么后边的几十上百个线程就不需要抢锁了
			synchronized(Singleton1.class) {
				if(singleton1 == null) {
					singleton1 = new Singleton1();
				}
			}
		}
		return singleton1;
	}

}

class TestSingleton {
	public static void main(String[] args) {
		/*
		 * 测试饿汉式 Singleton singleton = Singleton.getInstance(); Singleton singleton1 =
		 * Singleton.getInstance(); System.out.println(singleton.equals(singleton1));
		 */
		// 测试懒汉式
		Singleton1 singleton = Singleton1.getInstance();
		Singleton1 singleton1 = Singleton1.getInstance();
		System.out.println(singleton.equals(singleton1));
	}
}