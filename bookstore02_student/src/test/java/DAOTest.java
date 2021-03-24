import com.atguigu.bean.Book;
import com.atguigu.bean.Page;
import com.atguigu.bean.User;
import com.atguigu.dao.BookDao;
import com.atguigu.dao.UserDao;
import com.atguigu.dao.impl.BookDaoImpl;
import com.atguigu.dao.impl.UserDaoImpl;
import org.junit.jupiter.api.Test;

import java.util.List;

public class DAOTest {
    UserDao userDao = new UserDaoImpl();
    BookDao bookDao = new BookDaoImpl();
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
}
