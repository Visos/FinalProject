package com.betacom.backend.suite;



import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

import com.betacom.backend.VestitoServiceTest;
import com.betacom.backend.details.LunghezzaManicaServiceTest;
import com.betacom.backend.details.LunghezzaServiceTest;
import com.betacom.backend.details.TagliaServiceImplTest;
import com.betacom.backend.details.VestibilitaServiceImplTest;

@Suite
@SelectClasses({
	TagliaServiceImplTest.class,
	VestibilitaServiceImplTest.class,
	LunghezzaServiceTest.class,
	LunghezzaManicaServiceTest.class,
	VestitoServiceTest.class
	})

public class SuiteTestVestito {

}
 