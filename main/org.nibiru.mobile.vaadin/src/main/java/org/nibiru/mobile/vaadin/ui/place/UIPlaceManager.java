package org.nibiru.mobile.vaadin.ui.place;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Deque;

import javax.inject.Inject;

import org.nibiru.mobile.core.api.ui.mvp.Presenter;
import org.nibiru.mobile.core.api.ui.mvp.PresenterMapper;
import org.nibiru.mobile.core.api.ui.mvp.View;
import org.nibiru.mobile.core.api.ui.place.Place;
import org.nibiru.mobile.core.api.ui.place.PlaceManager;

import com.google.common.collect.Queues;
import com.vaadin.ui.Component;
import com.vaadin.ui.UI;

public class UIPlaceManager implements PlaceManager {
	private final PresenterMapper presenterMapper;
	private final Deque<Presenter<?>> presenterStack;

	@Inject
	public UIPlaceManager(PresenterMapper presenterMapper) {
		this.presenterMapper = checkNotNull(presenterMapper);
		presenterStack = Queues.newArrayDeque();
	}

	@Override
	public Place createPlace(String id) {
		return new UIPlace(presenterMapper, presenterStack,
				id);
	}

	@Override
	public Place createPlace(Enum<?> id) {
		return createPlace(id.toString());
	}

	@Override
	public void back() {
		presenterStack.pop().onDeactivate();
		if (!presenterStack.isEmpty()) {
			Presenter<? extends View> presenter = presenterStack.peek();
			Component view = (Component) presenter.getView().asNative();
			UI.getCurrent().setContent(view);
			presenter.onActivate();
		}
	}
}
