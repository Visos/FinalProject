package com.betacom.backend.suite;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

import com.betacom.backend.ScarpaServiceTest;
import com.betacom.backend.details.ChiusuraServiceTest;
import com.betacom.backend.details.TipoScarpaImplTest;

@Suite
@SelectClasses({
	ChiusuraServiceTest.class,
	TipoScarpaImplTest.class,
	ScarpaServiceTest.class
})
public class SuiteTestScarpa {

}
