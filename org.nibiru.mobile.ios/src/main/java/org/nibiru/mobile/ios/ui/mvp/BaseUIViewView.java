package org.nibiru.mobile.ios.ui.mvp;

import apple.uikit.protocol.UITextFieldDelegate;

public abstract class BaseUIViewView implements UIViewView {
    private final UITextFieldDelegate textFieldDelegate = new TextFieldDelegate();

    protected UITextFieldDelegate getTextFieldDelegate() {
        return textFieldDelegate;
    }
}
