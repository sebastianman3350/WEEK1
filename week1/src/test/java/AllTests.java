import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.s4nWeek1.com.week1.AereolineaLamdaTest;
import com.s4nWeek1.com.week1.AereolineaOptionalTest;
import com.s4nWeek1.com.week1.PersonaTest;

@RunWith(Suite.class)
@SuiteClasses({
	PersonaTest.class,
	AereolineaLamdaTest.class,
	AereolineaOptionalTest.class
})
public class AllTests {

}
