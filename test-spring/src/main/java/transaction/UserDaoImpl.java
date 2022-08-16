package transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;


@Component
public class UserDaoImpl implements UserDao
{
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void save(User user)
	{
		jdbcTemplate.update("insert into user values(?,?)",user.getName(),user.getAge());
	}
}
