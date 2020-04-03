package ui;

import java.util.ArrayList;
import java.util.List;


public class Question {

	String type;
	String value;
	String text;
	public static List<Question> questionList = new ArrayList<Question>();

	public Question(String type, String value, String text)
	{
		this.type = type;
		this.value = value;
		this.text = text;
	}
	public void init() {
		Question question1 = new Question ("TYPE","Work","Folosesti laptopul pentru a lucra pe el ?");
		this.questionList.add(question1);
		Question question2 = new Question ("TYPE","Gaming","Folosesti laptopul pentru a te juca ?");
		this.questionList.add(question2);
		Question question3 = new Question ("SIZE","17","Preferi dimensiunea de 17inch?");//2
		this.questionList.add(question3);
		Question question4 = new Question ("SIZE","15","Preferi dimensiunea de 15inch?");
		this.questionList.add(question4);
		Question question5 = new Question ("CPU","I3","Preferi procesor I3 ?");
		this.questionList.add(question5);
		Question question6 = new Question ("CPU","I5","Preferi procesor I5 ?");
		this.questionList.add(question6);
		Question question7 = new Question ("CPU","I7","Preferi procesor I7 ?");
		this.questionList.add(question7);
		Question question8 = new Question ("MEMORY","4","Preferi 4GB Memorie RAM?");//7
		this.questionList.add(question8);
		Question question9 = new Question ("MEMORY","8","Preferi 8GB Memorie RAM?");//8
		this.questionList.add(question9);
		Question question10 = new Question ("MEMORY","16","Preferi 16GB Memorie RAM?");//9
		this.questionList.add(question10);
		Question question11 = new Question ("PRET","2000","Preferi un pret sub 3000 lei?");//10
		this.questionList.add(question11);
		Question question12 = new Question ("PRET","3000","Preferi un pret sub 4000 lei?");
		this.questionList.add(question12);
		Question question13 = new Question ("PRET","4000","Preferi un pret sub 5000 lei?");
		this.questionList.add(question13);
		Question question14 = new Question ("PRET","5000","Preferi un pret sub 6000 lei?");
		this.questionList.add(question14);
		Question question15 = new Question ("PRET","6000","Preferi un pret sub 7000 lei?");//14
		this.questionList.add(question15);
		Question question16 = new Question ("BRAND","ASUS","Preferi Brandul Asus?");
		this.questionList.add(question16);
		Question question17 = new Question ("BRAND","LENOVO","Preferi Brandul Lenovo?");
		this.questionList.add(question17);
		Question question18 = new Question ("BRAND","ACER","Preferi Brandul Acer?");
		this.questionList.add(question18);
		Question question19 = new Question ("BRAND","APPLE","Preferi Brandul Apple?");
		this.questionList.add(question19);
		Question question20 = new Question ("BRAND","TOSHIBA","Preferi Brandul Toshiba?");
		this.questionList.add(question20);
		Question question21 = new Question ("BRAND","SAMSUNG","Preferi Brandul Samsung?");
		this.questionList.add(question21);
		Question question22 = new Question ("BRAND","SONY","Preferi Brandul Sony?");
		this.questionList.add(question22);
		Question question23 = new Question ("BRAND","DELL","Preferi Brandul Dell?");
		this.questionList.add(question23);
		Question question24 = new Question ("BRAND","HP","Preferi Brandul HP?");
				this.questionList.add(question24);//23
				
		
		
	}
}
