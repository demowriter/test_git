package st_1;
//
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class openChrome {
	private static String html;
	private static String title;
	private static String url;
	private static WebElement divs;

	//main������������Ϊ�ַ�������(String [ ])���������������⣬
	//ͨ��ʹ��args����arguments�����������ĸ�����ʽ������д��
	public void wait(String[] args) {
        
		
	}
	public static void main(String[] args) {
//        System.setProperty("webdriver.chrome.driver","E:\\webDriver\\chromedriverV2.28.exe");//chromedriver�����ַ
        WebDriver driver =new ChromeDriver(); //�½�һ��WebDriver �Ķ��󣬵���new ����FirefoxDriver������
        driver.get("http://www.baidu.com");//��ָ������վ
        driver.findElement(By.id("kw")).sendKeys(new  String[] {"hello"});//�ҵ�kwԪ�ص�id��Ȼ������hello
        driver.findElement(By.id("su")).click(); //�����Ť
        html=driver.getPageSource();
        System.out.println("����ɹ���");
//        System.out.println(html);
        title=driver.getTitle();
        url=driver.getCurrentUrl();
        try {
            /**
             * WebDriver�Դ���һ�����ܵȴ��ķ�����
            dr.manage().timeouts().implicitlyWait(arg0, arg1����
            Arg0���ȴ���ʱ�䳤�ȣ�int ���� ��
            Arg1���ȴ�ʱ��ĵ�λ TimeUnit.SECONDS һ��������Ϊ��λ��
             */
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);        
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.printf("ҳ�����Ϊ: %s \n,��ַΪ��%s \n",title,url);
        
       divs=driver.findElement(By.cssSelector
    		   ("#\\31 > div.c-border > div.op_dict_content > "
    		   		+ "table:nth-child(2) > tbody > tr > td:nth-child(2) "
    		   		+ "> span"));
        System.out.println(divs.getText());
//        WebElement ele = driver.findElement(By.xpath("/html"));
//        String htmlStr = ele.getAttribute("innerHTML");// ��ȡԪ������
//        System.out.printf("%s \n %s",ele,htmlStr);
        

        /**
         * dr.quit()��dr.close()�������˳������,�򵥵�˵һ�����ߵ����𣺵�һ��close��
         * ������˶��ҳ���ǹز��ɾ��ģ���ֻ�رյ�ǰ��һ��ҳ�档�ڶ���quit��
         * ���˳�������Webdriver���еĴ��ڣ��˵ķǳ��ɾ��������Ƽ�ʹ��quit��Ϊһ��case�˳��ķ�����
         */
        try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       System.out.print("ִ�н�����");
       
       driver.quit();//�˳������
    }
	 
}
