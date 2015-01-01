package ar.com.oxen.nibiru.mobile.ios.ui;

import static com.google.common.base.Preconditions.checkNotNull;

import org.robovm.apple.uikit.UIAlertView;

import ar.com.oxen.nibiru.mobile.core.api.ui.AlertManager;

public class UIAlertViewAlertManager implements AlertManager {
	@Override
	public void showMessage(String message) {
		checkNotNull(message);
		UIAlertView alertView = new UIAlertView();
		alertView.setTitle("Message");
		alertView.addButton("Ok");
		alertView.setMessage(message);
		alertView.show();
	}

	@Override
	public void showException(Exception exception) {
		checkNotNull(exception);
		showMessage(exception.getClass() + ": " + exception.getMessage());
	}
}
