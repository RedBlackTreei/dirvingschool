package onlyfun.js.junit;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import onlyfun.js.model.*;
import onlyfun.js.uitl.HibernateUtil;

import org.hibernate.*;
import org.junit.*;

public class TestUtil {

	Session session = null;
	Transaction transaction = null;
	SimpleDateFormat format = null;

	@Before
	public void setUp() throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		format = new SimpleDateFormat("yyyy-MM-dd");
	}

	@Test
	public void addSomeone() {
		transaction = session.beginTransaction();

		Coach c = new Coach();
		c.setName("纪森");
		c.setAddress("2-4#101");
		c.setIdNum("341227198701282634");
		c.setSex(true);
		c.setTel("15280774223");
		c.setUsername("jishen521");
		c.setPassword("8053263");
		c.setSex(true);
		c.setStuFull(false);
		c.setTeachSubject("item3");

		LocalOfSign l = new LocalOfSign();
		l.setAddress("武夷学院");
		l.setName("武夷驾校");
		l.setTel("15280756453");

		Student stu = new Student();
		stu.setName("墨水");
		stu.setAddress("2-3#301");
		stu.setIdNum("2138412384081203498");
		stu.setSex(true);
		stu.setDateOfEntry(format.format(new Date()));
		stu.setTel("12388347876");
		stu.setUsername("ji");
		stu.setPassword("101");
		stu.setCoach(c);
		stu.setFinshedSub(3);
		stu.setPayfee(true);
		stu.setSchoolTime("8");
		stu.setLocalOfSign(l);

		Car car = new Car();
		car.setCoach(c);
		car.setStudent(stu);
		car.setType("奥迪A6");
		car.setPlateNum("闽H354300");
		//car.setRegDate(format.format(new Date()));
		car.setRemark("好车！");

		session.save(c);
		session.save(l);
		session.save(stu);
		session.save(car);

		transaction.commit();
	}

	@Test
	public void testAddNews() {
		transaction = session.beginTransaction();
		News n = new News();
		n.setTitle("传日美取消联合夺岛演习 被指为避免刺激中国");
		n.setContent("据日本媒体报道，美国和日本取消了原定于11月5日起举行的联合夺岛军事实弹演习，据称是为了避免刺激中国。日本新闻网10月19日报道援引消息人士的话说，为了避免刺激中国，日美两国政府决定取消原定于11月5日起举行的联合夺岛军事实弹演习。同时，美国政府担心，这一次的联合夺岛军事演习将会给日中紧张关系增添危机。日本政府内部也出现了对此表示慎重的声音。此外，而近日发生的美军士兵轮奸冲绳女性的问题，也让冲绳县民对于日美两军在冲绳县的入砂岛实施实弹夺岛演习感到反感。该消息人士称，综合因素导致日美两国政府决定取消这一次联合军事演习。");
		n.setDate(format.format(new Date()));
		session.save(n);
		transaction.commit();
	}

	@Test
	public void testAddQuestion() {
		transaction = session.beginTransaction();
		Question q = new Question();
		q.setTitle("驾驶机动车看到这种标志需要注意什么？");
		QuestionItem item1 = new QuestionItem();
		item1.setItem("减速、观察、慢行");
		item1.setQuestion(q);
		QuestionItem item2 = new QuestionItem();
		item2.setItem("鸣喇叭驱赶牲畜");
		item2.setQuestion(q);
		QuestionItem item3 = new QuestionItem();
		item3.setItem("从牲畜的空隙中穿过");
		item3.setQuestion(q);
		QuestionItem item4 = new QuestionItem();
		item4.setItem("低速行驶冲开牲畜群");
		item4.setQuestion(q);
		session.save(item1);
		session.save(item2);
		session.save(item3);
		session.save(item4);
		transaction.commit();

	}

	@Test
	public void testGetNews() {
		transaction = session.beginTransaction();
		Question q = (Question) session.load(Question.class, 4l);
		Set<QuestionItem> items = q.getItems();
		System.out.println(q.getTitle());
		System.out.println(items.size());
		Iterator<QuestionItem> it = items.iterator();
		boolean hasNext = it.hasNext();
		while (hasNext) {
			System.out.println(it.next().getItem());
		}

		transaction.commit();
	}

	@Test
	public void testAddStock() {
		Stock stock = new Stock();
		stock.setStoresName("台式电脑");
		stock.setStoresId("367-9842-86395");
		stock.setCurrentNum(31);
		stock.setMinNum(50);
		stock.setPrice(3679);
		transaction = session.beginTransaction();
		session.save(stock);
		transaction.commit();
	}

	@Test
	public void testAddStudyItems() {
		transaction = session.beginTransaction();
		StudyItems items = new StudyItems();
		items.setClassHour(48);
		items.setItemName("项目1");
		Coach c = (Coach) session.load(Coach.class, 1l);
		Set<Coach> set = new HashSet<Coach>();
		set.add(c);
		items.setCoach(set);
		session.save(items);
		transaction.commit();

	}

	@Test
	public void testDate() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(format.format(new Date()));
	}

	@After
	public void tearDown() throws Exception {
		session.close();
	}

}
