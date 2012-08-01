package com.thoughtworks.mobile.awayday.fragments.contacts.views;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.ViewFlipper;
import com.thoughtworks.mobile.awayday.R;
import com.thoughtworks.mobile.awayday.fragments.contacts.Utils;

public class ContactMainView extends AbstractContactView {
    public ContactMainView(Context context, ViewFlipper viewFlipper) {
        super(context, viewFlipper);

    }

    @Override
    protected void initViewComponents() {
        initButtons();
        if(!Utils.isFileNotExist(context)){
            initQrCode(Utils.readContactInfos(context), view);
        }
    }

    private void initButtons() {
        setButtonListener(R.id.contacts_setting, 1);
        setButtonListener(R.id.contacts_scan, 2);
    }

    private void setButtonListener(int buttonId, final int switchViewIndex) {
        Button contactSetting = (Button) view.findViewById(buttonId);
        contactSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewFlipper.setDisplayedChild(switchViewIndex);
            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.contact_main;
    }
}
