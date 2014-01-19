package ar.com.oxen.nibiru.mobile.sample.ios;

import static com.google.common.base.Preconditions.checkNotNull;

import javax.inject.Inject;

import org.robovm.cocoatouch.coregraphics.CGRect;
import org.robovm.cocoatouch.uikit.UIButton;
import org.robovm.cocoatouch.uikit.UIButtonType;
import org.robovm.cocoatouch.uikit.UIControlState;
import org.robovm.cocoatouch.uikit.UILabel;
import org.robovm.cocoatouch.uikit.UITextBorderStyle;
import org.robovm.cocoatouch.uikit.UITextField;
import org.robovm.cocoatouch.uikit.UIView;

import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.HasClickHandler;
import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.TakesValue;
import ar.com.oxen.nibiru.mobile.ios.ui.mvp.BaseUIViewControllerView;
import ar.com.oxen.nibiru.mobile.ios.ui.mvp.UIButtonAdapter;
import ar.com.oxen.nibiru.mobile.ios.ui.mvp.UILabelAdapter;
import ar.com.oxen.nibiru.mobile.ios.ui.mvp.UITextFieldAdapter;
import ar.com.oxen.nibiru.mobile.sample.app.ui.SampleMessages;
import ar.com.oxen.nibiru.mobile.sample.app.ui.SamplePresenter.Display;

public class SampleDisplay extends BaseUIViewControllerView implements Display {
	private final UIButton alertTrigger;
	private final UITextField nameLoad;
	private final UIButton greetingTrigger;
	private final UILabel greetingDisplay;
	private final UIButton backTrigger;
	private final UIButton showLocation;

	@Inject
	public SampleDisplay(SampleMessages messages) {
		checkNotNull(messages);
		UIView container = new UIView(new CGRect(0, 0, 320, 480));
		getController().setView(container);

		UILabel mensaje = new UILabel(new CGRect(20, 50, 100, 25));
		mensaje.setText(messages.title());
		container.addSubview(mensaje);

		alertTrigger = UIButton.fromType(UIButtonType.RoundedRect);
		alertTrigger.setFrame(new CGRect(20, 80, 100, 25));
		alertTrigger.setTitle(messages.showAlert(), UIControlState.Normal);
		container.addSubview(alertTrigger);

		nameLoad = new UITextField(new CGRect(20, 110, 100, 25));
		nameLoad.setText("Pepe");
		nameLoad.setBorderStyle(UITextBorderStyle.RoundedRect);
		container.addSubview(nameLoad);

		greetingTrigger = UIButton.fromType(UIButtonType.RoundedRect);
		greetingTrigger.setFrame(new CGRect(20, 140, 100, 25));
		greetingTrigger.setTitle(messages.greet(), UIControlState.Normal);
		container.addSubview(greetingTrigger);

		greetingDisplay = new UILabel(new CGRect(20, 170, 100, 25));
		greetingDisplay.setText("");
		container.addSubview(greetingDisplay);

		showLocation = UIButton.fromType(UIButtonType.RoundedRect);
		showLocation.setFrame(new CGRect(20, 200, 100, 25));
		showLocation.setTitle(messages.getPosition(), UIControlState.Normal);
		container.addSubview(showLocation);

		backTrigger = UIButton.fromType(UIButtonType.RoundedRect);
		backTrigger.setFrame(new CGRect(20, 230, 100, 25));
		backTrigger.setTitle(messages.back(), UIControlState.Normal);
		container.addSubview(backTrigger);
	}

	@Override
	public HasClickHandler getAlertTrigger() {
		return new UIButtonAdapter(alertTrigger);
	}

	@Override
	public HasClickHandler getGreetingTrigger() {
		return new UIButtonAdapter(greetingTrigger);
	}

	@Override
	public TakesValue<String> getNameLoad() {
		return new UITextFieldAdapter(nameLoad);
	}

	@Override
	public TakesValue<String> getGreetingDisplay() {
		return new UILabelAdapter(greetingDisplay);
	}

	@Override
	public HasClickHandler getBackTrigger() {
		return new UIButtonAdapter(backTrigger);
	}

	@Override
	public HasClickHandler getShowLocation() {
		return new UIButtonAdapter(showLocation);
	}
}
