package ar.com.oxen.nibiru.mobile.ios.ioc;

import ar.com.oxen.nibiru.mobile.core.api.data.security.UserDao;
import ar.com.oxen.nibiru.mobile.core.api.service.security.AuthenticationService;
import ar.com.oxen.nibiru.mobile.core.api.service.security.LoginDto;
import ar.com.oxen.nibiru.mobile.core.api.ui.security.SecurityMessages;
import ar.com.oxen.nibiru.mobile.core.impl.service.security.AuthenticationServiceImpl;
import ar.com.oxen.nibiru.mobile.core.impl.ui.security.LoginPresenter;
import ar.com.oxen.nibiru.mobile.ios.data.security.DummyUserDao;
import ar.com.oxen.nibiru.mobile.ios.ui.security.LoginDisplay;

import com.google.inject.AbstractModule;

public class DefaultSecurityModule extends AbstractModule {
	@Override
	protected void configure() {
		/* Data bindings */
		bind(UserDao.class).to(DummyUserDao.class);
//		/* Service bindings */
//		bind(LoginDto.class).to(LoginDtoImpl.class);
//		bind(AuthenticationService.class).to(AuthenticationServiceImpl.class);
//		/* UI bindings */
//		bind(LoginPresenter.Display.class).to(LoginDisplay.class);
//		bind(SecurityMessages.class).toProvider(
//				new MessageProvider<SecurityMessages>(SecurityMessages.class));
	}
}
