package org.nibiru.mobile.wp.ui;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.NotificationMole;

import org.nibiru.mobile.core.api.common.Consumer;
import org.nibiru.mobile.core.api.ui.AlertManager;

import static com.google.common.base.Preconditions.checkNotNull;

public class WindowsPhoneAlertManager implements AlertManager {
	@Override
	public void showMessage(String message) {
		checkNotNull(message);
		alert(message);
	}

	@Override
	public void showNotification(String message) {
		NotificationMole nm = new NotificationMole();
		nm.setAnimationDuration(2000);
		nm.setMessage(message);
		nm.show();
	}

	@Override
	public void showException(Exception exception) {
		checkNotNull(exception);
		showMessage(exception.getClass() + ": " + exception.getMessage());
	}

	@Override
	public void prompt(String title, String message, Consumer<String> callback) {
		checkNotNull(title);
		checkNotNull(message);
		checkNotNull(callback);
		callback.accept(Window.prompt(title + "\n" + message, ""));
	}

	@Override
	public void confirm(String title, String message, Consumer<Boolean> callback) {
		checkNotNull(title);
		checkNotNull(message);
		checkNotNull(callback);
		callback.accept(Window.confirm(title + "\n" + message));
	}

	private static native void alert(String message) /*-{
	  new Windows.UI.Popups.MessageDialog(message).showAsync();
	}-*/;
}
