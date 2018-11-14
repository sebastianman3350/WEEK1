import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.s4nWeek1.com.week1.AereolineaTest;
import com.s4nWeek1.com.week1.PersonaTest;

@RunWith(Suite.class)
@SuiteClasses({
	PersonaTest.class,
	AereolineaTest.class
})
public class AllTests {

}
