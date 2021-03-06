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

	//main方法参数必须为字符串数组(String [ ])，变量名可以随意，
	//通常使用args即是arguments（”参数“的复数形式）的缩写。
	public void wait(String[] args) {
        
		
	}
	public static void main(String[] args) {
//        System.setProperty("webdriver.chrome.driver","E:\\webDriver\\chromedriverV2.28.exe");//chromedriver服务地址
        WebDriver driver =new ChromeDriver(); //新建一个WebDriver 的对象，但是new 的是FirefoxDriver的驱动
        driver.get("http://www.baidu.com");//打开指定的网站
        driver.findElement(By.id("kw")).sendKeys(new  String[] {"hello"});//找到kw元素的id，然后输入hello
        driver.findElement(By.id("su")).click(); //点击按扭
        html=driver.getPageSource();
        System.out.println("点击成功！");
//        System.out.println(html);
        title=driver.getTitle();
        url=driver.getCurrentUrl();
        try {
            /**
             * WebDriver自带了一个智能等待的方法。
            dr.manage().timeouts().implicitlyWait(arg0, arg1）；
            Arg0：等待的时间长度，int 类型 ；
            Arg1：等待时间的单位 TimeUnit.SECONDS 一般用秒作为单位。
             */
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);        
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.printf("页面标题为: %s \n,网址为：%s \n",title,url);
        
       divs=driver.findElement(By.cssSelector
    		   ("#\\31 > div.c-border > div.op_dict_content > "
    		   		+ "table:nth-child(2) > tbody > tr > td:nth-child(2) "
    		   		+ "> span"));
        System.out.println(divs.getText());
//        WebElement ele = driver.findElement(By.xpath("/html"));
//        String htmlStr = ele.getAttribute("innerHTML");// 获取元素内容
//        System.out.printf("%s \n %s",ele,htmlStr);
        

        /**
         * dr.quit()和dr.close()都可以退出浏览器,简单的说一下两者的区别：第一个close，
         * 如果打开了多个页面是关不干净的，它只关闭当前的一个页面。第二个quit，
         * 是退出了所有Webdriver所有的窗口，退的非常干净，所以推荐使用quit作为一个case退出的方法。
         */
        try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       System.out.print("执行结束！");
       
       driver.quit();//退出浏览器
    }
	 
}
