package dev.tokoi.emoji;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.vanniktech.emoji.EmojiPopup;
import com.vanniktech.emoji.EmojiTextView;

public class MainActivity extends AppCompatActivity {
    // Initialize variables
    ImageView mEmojiBt, mSendBt;
    EditText mEmojiEt;
    LinearLayout mLinearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Assign variables
        mEmojiBt = findViewById(R.id.bt_emoji);
        mSendBt = findViewById(R.id.bt_send);
        mEmojiEt = findViewById(R.id.et_emoji);
        mLinearLayout = findViewById(R.id.linear_layout);

        // Initialize emoji popup
        EmojiPopup popup = EmojiPopup.Builder
                .fromRootView(findViewById(R.id.root_view))
                .build(mEmojiEt);

        mEmojiBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toggle between text and emoji
                popup.toggle();
            }
        });

        mSendBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Inflate emoji text view
                EmojiTextView emojiTextView = (EmojiTextView) LayoutInflater
                        .from(v.getContext())
                        .inflate(R.layout.emoji_text_view, mLinearLayout, false);

                // Set text on emoji text view
                emojiTextView.setText(mEmojiEt.getText().toString());

                // Add view to linear layout
                mLinearLayout.addView(emojiTextView);

                // Cleat edit text value
                mEmojiEt.getText().clear();
            }
        });
    }
}
