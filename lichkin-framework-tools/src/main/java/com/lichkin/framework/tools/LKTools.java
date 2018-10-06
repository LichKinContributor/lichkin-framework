package com.lichkin.framework.tools;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;

import javax.swing.JOptionPane;

import com.lichkin.framework.utils.security.otp.LKOTPEncrypter;

public class LKTools {

	public static void main(String[] args) {
		String encrypt = LKOTPEncrypter.encrypt();
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(encrypt), null);
		JOptionPane.showMessageDialog(null, "密码：【" + encrypt + "】已经复制到剪贴板", "提示", JOptionPane.WARNING_MESSAGE);
	}

}
