package transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserServiceImpl implements UserService
{

	@Autowired
	UserDao userDao;

	@Transactional
	@Override
	public void save(User user)
	{
		userDao.save(user);
//		int a = 1/0;
//		userDao.save(user);
	}
}
