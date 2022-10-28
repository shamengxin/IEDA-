/*
设计男人类，每个男人都有身份证号、姓名、性别、女人。
设计女人类，每个女人都有身份证号、姓名、性别、男人。
*/
class Man{
	String idCard;
	String name;
	boolean sex;
	Woman gail;
}
class Woman{
	String idCard;
	String name;
	boolean sex;
	Man boy;
}