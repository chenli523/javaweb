import com.atguigu.bean.*;
import com.atguigu.dao.BookDao;
import com.atguigu.dao.OrderDao;
import com.atguigu.dao.OrderItemDao;
import com.atguigu.dao.UserDao;
import com.atguigu.dao.impl.BookDaoImpl;
import com.atguigu.dao.impl.OrderDaoImpl;
import com.atguigu.dao.impl.OrderItemImpl;
import com.atguigu.dao.impl.UserDaoImpl;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

public class DAOTest {
    UserDao userDao = new UserDaoImpl();
    BookDao bookDao = new BookDaoImpl();
    OrderDao orderDao = new OrderDaoImpl();
    OrderItemDao orderItemDao = new OrderItemImpl();

    @Test
    public void userDaoImpltest() {
        User cai = userDao.getUser(new User("cai", null, "123456", null));
        System.out.println(cai);
    }
    @Test
    public void userDaocheckUserName() {
        User cai = userDao.checkUserName("caixukun");
        System.out.println(cai);
    }
    @Test
    public void userDaoSaveUser() {
        System.out.println(userDao.saveUser(new User("li","lee","12345","nnnnnnn")));
    }
    @Test
    public void bookDaoTest() {
        List<Book> aLlBooks = bookDao.getAllBooks();
        aLlBooks.forEach(System.out::println);
    }
    @Test
    public void pageTest() {
        Page<Book> page = new Page<>();
        page.setPageNo(2);
        Page<Book> booksByPage = bookDao.getBooksByPage(page);
        System.out.println(booksByPage);
    }

    @Test
    public void orderDaoTest() {
        orderDao.insert(new Order("testId",new Date(), 100, 200, 0, 1));
        orderItemDao.insert(new OrderItem(null, 50, 100, "testTitle", "testAuthor",20,"testPath","testId"));
        bookDao.updateBookById(200, 200, 1);
    }
}
