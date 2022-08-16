package circulation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class InstanceB {

	@Autowired
	InstanceA instanceA;
}
