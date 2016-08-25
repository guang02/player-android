package com.hnjhn.util;

import android.content.Context;
import android.os.Handler;
import android.widget.Toast;

public class ToastUtil {

	private static Toast mToast;

	private static Handler mHandler = new Handler();
	private static Runnable r = new Runnable() {
		public void run() {
			mToast.cancel();
			mToast = null;// toast���غ󣬽�����Ϊnull
		}
	};
	
	public static void show(Context context, int resId) {
		show(context, context.getResources().getText(resId));
	}

	public static void show(Context context, CharSequence message) {
//		LayoutInflater inflater = (LayoutInflater) context
//				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//		
//		View view = inflater.inflate(R.layout.custom_toast, null);// �Զ��岼��
//		TextView text = (TextView) view.findViewById(R.id.toast_message);// ��ʾ����ʾ����
//		text.setText(message);
		
		mHandler.removeCallbacks(r);
		
		if (mToast == null) {// ֻ��mToast==nullʱ�����´���������ֻ�������ʾ����
//			mToast = new Toast(context);
//			mToast.setDuration(Toast.LENGTH_SHORT);
//			mToast.setGravity(Gravity.BOTTOM, 0, 150);
//			mToast.setView(view);
			mToast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
		}
		mHandler.postDelayed(r, 1000);// �ӳ�1������toast
		mToast.show();
	}
}